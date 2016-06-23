package numerike_II;

import javax.swing.*;

public class Vektoret {
	// mbushim vektorin me te dhena ja caktojme madhesine vargur me argument
	public static double[] fillVektor(int madhesia) {
		double[] vektori = new double[madhesia];
		JOptionPane.showMessageDialog(null, "Mbushe vektorin");
		for (int i = 0; i < madhesia; i++) {
			vektori[i] = new Integer(JOptionPane.showInputDialog("a" + i + " ="));
		}
		JOptionPane.showMessageDialog(null, "Vektori u mbush");

		return vektori;
	}

	// a nr i rreshtave, b nr i shtyllave te matrices
	public static double[][] fillMatrica(int a, int b) {
		JOptionPane.showMessageDialog(null, "Mbushe Matricen");
		double[][] matrica = new double[a][b];

		for (int i = 0; i < a; i++) {

			for (int j = 0; j < b; j++) {

				matrica[i][j] = new Integer(JOptionPane.showInputDialog("a" + i + "" + j + " ="));
			}
		}

		JOptionPane.showMessageDialog(null, "Matrica u mbush u mbush");
		return matrica;
	}

	// infinit norma e vargut
	public static double L_infini_norm(double[] a) {
		double max = 0;
		for (int i = 0; i < a.length; i++) {
			if (Math.abs(a[i]) > max) {
				max = Math.abs(a[i]);
			}
		}
		return max;
	}

	// l2 norma e vargut
	public static double L2_norm(double[] a) {

		double rez = 0;
		for (int i = 0; i < a.length; i++) {
			rez = rez + a[i] * a[i];
		}
		rez = Math.sqrt(rez);
		return rez;
	}

	// distanca euklidiane
	public static double Euclidean_distance(double[] a, double[] b) {

		if (a.length != b.length) {
			System.out.println("Vektoret nuk kane te njejten gjatesi");
			System.exit(0);
		}
		double rez = 0;
		for (int i = 0; i < a.length; i++) {
			rez = rez + Math.pow((a[i] - b[i]), 2);
		}
		return rez = Math.sqrt(rez);
	}

	// distanca maksimale
	public static double Max_distance(double[] a, double[] b) {
		if (a.length != b.length) {
			System.out.println("Vektoret nuk kane te njejten gjatesi");
			System.exit(0);
		}
		double max = 0;
		for (int i = 0; i < a.length; i++) {
			if (max < Math.abs(a[i] - b[i])) {
				max = Math.abs(a[i] - b[i]);
			}
		}
		return max;
	}

	// Infinit norma e matrices
	public static double Matrix_infini_norm(double[][] a) {
		double max = 0;
		double shuma = 0;
		for (int i = 0; i < a[0].length; i++) {
			for (int j = 0; j < a.length; j++) {
				shuma = shuma + a[i][j];
			}
			if (shuma > max)
				max = shuma;
		}
		return max;

	}

	// Frobenius norma funksionon kur matrica eshte katrore
	public static double Frobenius_norm(double[][] a) {
		double rez = 0;
		if (a.length != a[0].length) {
			System.out.println("Matrica nuk eshte katrore");
			System.exit(0);
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				rez = rez + a[i][j] * a[i][j];
			}
		}

		return Math.sqrt(rez);
	}

	// mbledhja e 2 matricave
	public static double[][] Matrix_addition(double[][] a, double[][] b) {
		if (a.length != b.length || a[0].length != b[0].length) {
			System.out.println("Matricat nuk jane te rendit te njejte");
			System.exit(0);
		}
		double[][] rez = new double[a.length][a[0].length];
		for (int i = 0; i < a[0].length; i++) {
			for (int j = 0; j < a.length; j++) {
				rez[i][j] = a[i][j] + b[i][j];
			}
		}
		return rez;
	}

	// zbritja e 2 matricave
	public static double[][] Matrix_substraction(double[][] a, double[][] b) {
		if (a.length != b.length || a[0].length != b[0].length) {
			System.out.println("Matricat nuk jane te rendit te njejte");
			System.exit(0);
		}
		double[][] rez = new double[a.length][a[0].length];
		for (int i = 0; i < a[0].length; i++) {
			for (int j = 0; j < a.length; j++) {
				rez[i][j] = a[i][j] - b[i][j];
			}
		}
		return rez;
	}

	public static void main(String[] args) {
		double[] a = fillVektor(3);
		double[] a1 = fillVektor(3);
		double[][] b = fillMatrica(2, 2);
		double[][] b1 = fillMatrica(2, 2);
		System.out.println("L-infinit norma e vektorit te dhene eshte " + L_infini_norm(a) + "\n");
		System.out.println("L2 norma e vektorit te dhene eshte " + L2_norm(a) + "\n");
		System.out.println("Distanca euklidiane eshte " + Euclidean_distance(a, a1) + "\n");
		System.out.println("Distanca maksimale eshte " + Max_distance(a, a1) + "\n");
		System.out.println("Norma infinite e matricave eshte\n||b||&= " + Matrix_infini_norm(b) + "\n||b1||&"
				+ Matrix_infini_norm(b1) + "\n");
		System.out.println(
				"Frobenius norma e matricave \n||b||F = " + Frobenius_norm(b) + "\n||b1||F = " + Frobenius_norm(b1));

	}
	// Metodat per mbledhje dhe zbritje te dy matricave jane me larte
}
