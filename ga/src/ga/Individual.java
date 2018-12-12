package ga;

import java.util.Random;

public class Individual {
	
	private int[] genes;
	private int fitness;
	private Random randomGenerator;

	public Individual() {
		this.genes = new int[Constants.CHROMOSOME_LENGTH*2];
		this.randomGenerator = new Random();
	}
	
	public void generateIndividual() {
		for(int i = 0; i < (Constants.CHROMOSOME_LENGTH*2); i++) {
			int gene = randomGenerator.nextInt(2);
			genes[i] = gene;
		}
	}
	
	public double f(double x, double y) {
		int xd = App.option;
		if (xd == 1) {
			//funkcja Beale'a
		return Math.pow((1.5-x+(x*y)), 2) + Math.pow((2.25-x) + (x*Math.pow(y, 2)), 2) + 
				Math.pow(((2.625 - x) + (x*Math.pow(y, 3))), 2);
		}
		else if (xd == 2) {
			//funkcja Rosenbrocka
			return (Math.pow((1-x),2)) + (100*(Math.pow((y-Math.pow(x,2)),2)));
		} else if(xd == 3) {
			//funkcja Booth'a
			return Math.pow((x + (2*y) -7), 2) + Math.pow(((2*x) + y - 5), 2);
		} else if (xd == 4) {
			//funkcja
			return -Math.cos(x)*Math.cos(y)*Math.exp(-(Math.pow((x - Math.PI), 2) + Math.pow(y - Math.PI, 2)) );
		} else return x + y;
	}
	
	public double getFitness() {
		double genesToDouble1 = genesToDouble(0);
		double genesToDouble2 = genesToDouble(1);
		return f(genesToDouble1, genesToDouble2);
	}
	
	public double getFitnessResult(int x) {
		double genesToDouble = genesToDouble(x);
		return genesToDouble;
	}
	
	public double genesToDouble(int x) {
		
		int base = 1;
		double geneInDouble = 0;
			if(x == 0) {
			for( int i =0; i < Constants.GENE_LENGTH; i++) {
				if(this.genes[i] == 1) 
					geneInDouble += base;
				
				base = base*2;
			}
		} else if ( x == 1) {
				for( int i = Constants.GENE_LENGTH; i < (Constants.GENE_LENGTH*2); i++) {
					if(this.genes[i] == 1) 
						geneInDouble += base;
					
					base = base*2;
				}
		}
		geneInDouble = (geneInDouble / 1024) * 10.1;
		
		return geneInDouble;
	}
	
	public int getGene(int index) {
		return this.genes[index];
	}
	
	public void setGene(int index, int value) {
		this.genes[index] = value;
		this.fitness = 0;
	}
}
