package pageRankSystem;

import java.io.Serializable;

public class DatosEntrada implements Serializable {
	private double nodes;
	private int iterations;
	private int matrix[][];
	
	public DatosEntrada() {
		
	}

	public double getNodes() {
		return nodes;
	}

	public void setNodes(double nodes) {
		this.nodes = nodes;
	}

	public int getIterations() {
		return iterations;
	}

	public void setIterations(int iterations) {
		this.iterations = iterations;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	
	
	

}
