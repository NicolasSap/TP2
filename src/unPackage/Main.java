package unPackage;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
//		double result;
		try {
//			VectorMath v1 = new VectorMath("vector.in");
//			System.out.println(v1.toString());
//			VectorMath v2 = new VectorMath("vector2.in");
//			System.out.println(v2.toString());
//			VectorMath v3 = v1.sumaVectores(v2);
//			System.out.println(v3.toString());
//			result = v1.producto(v2);
//			System.out.println("Producto Escalar=" + result);
//			
//			System.out.println("Norma Uno = " + v1.normaUno());
//			System.out.println("Norma Dos = " + v1.normaDos());
//			
//			System.out.println(v1.producto(3));
//			
//			System.out.println(v1.equals(v2));
//			System.out.println(v1.equals(v1));
//			
//			VectorMath v5 = v1.clone();
//			System.out.println(v5.normaInfinita());
//			MatrizMath m1 = new MatrizMath("matriz.in");
//			m1.mostrarMatriz();
			Lector l = new Lector("sel.in");
			MatrizMath matriz = new MatrizMath(l.getMatriz());
			VectorMath vector = new VectorMath(l.getVector());
			matriz.mostrarMatriz();
//			System.out.println(vector.toString());
			MatrizMath test = matriz.invertir();
			test.mostrarMatriz();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//		} catch (DistDemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		
	}

}
