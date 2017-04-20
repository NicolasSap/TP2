package unPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MatrizMath {
	int dimCol;
	int dimFil;
	double [][] matriz;
	public MatrizMath(double[][] matriz) {
		this.matriz = matriz;
		this.dimCol = matriz.length;
		this.dimFil = matriz[0].length;
	}
	
	public MatrizMath(String path) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(path));
		matriz = new double[sc.nextInt()][sc.nextInt()];
		this.dimCol = matriz.length;
		this.dimFil = matriz[0].length;
		while(sc.hasNextLine())
			matriz[sc.nextInt()][sc.nextInt()] = sc.nextDouble();
		sc.close();
	}

	public int getDimCol() {
		return dimCol;
	}

	public void setDimCol(int dimCol) {
		this.dimCol = dimCol;
	}

	public int getDimFil() {
		return dimFil;
	}

	public void setDimFil(int dimFil) {
		this.dimFil = dimFil;
	}

	public double[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(double[][] matriz) {
		this.matriz = matriz;
	}

	public void mostrarMatriz() {
		System.out.println("Matriz: ");
		for (int j = 0; j < matriz.length; j++) {
			System.out.println(Arrays.toString(matriz[j]));
		}
	}
	
	public MatrizMath invertir(){
		double [][] invertida = new double[matriz.length][matriz.length];
		MatrizMath mInvertida = new MatrizMath(matriz);
		for (int o = 0; o < invertida.length; o++) {
			invertida[o][o] = 1;
		}
		for (int i = 0; i < mInvertida.matriz.length; i++) {
			if(mInvertida.matriz[i][i] == 0){
				moverFila(mInvertida.matriz);
			}
			dividir(mInvertida.matriz,i,invertida);
			cerosInferiores(mInvertida.matriz,i,invertida);
		}
		for (int i = 0; i <mInvertida.matriz.length; i++) {
			cerosSuperiores(mInvertida.matriz,i,invertida);
		}
		mInvertida.setMatriz(invertida);
		return mInvertida;
		
	}



	private void cerosSuperiores(double[][] original, int i, double[][] invertida) {
		double valor;
		for (int j = i+1; j < original.length; j++) {
			valor = original[i][j];
			for (int k = 0; k < original.length; k++) {
				original[i][k] -= valor*original[j][k];
				invertida[i][k] -= valor*invertida[j][k];

			}
		}
		
	}

	private void cerosInferiores(double[][] original, int i, double[][] invertida) {
		double valor;
		for (int j = i+1; j < original.length; j++) {
			valor = original[j][i];
			for (int k = 0; k < original.length; k++) {
				original[j][k] -= valor*original[i][k];
				invertida[j][k] -= valor*invertida[i][k];

			}
		}
	}

	private void dividir(double[][] original, int i, double[][] invertida) {
		// Guardo el valor previo para no perderlo y aprovechar el for para también
		// modificar la invertida
		double valorInicial = original[i][i];
		for (int j = 0; j < original.length; j++) {
			original[i][j] /= valorInicial;
			invertida[i][j] /= valorInicial;
		}
		
	}

	private void moverFila(double[][] original) {
		// TODO Auto-generated method stub
		// REVISAR POR QUE NO SE HACE OTRA REFERENICA
	}
	
}