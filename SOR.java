package numerike_II;

public class SOR {

	public static void sor_method(double[][] matrica, double[] B, double[] X, double w, int N, double TOL) {
		int k = 1;

		double[] x = new double[matrica.length];

		while (k <= N) {
			for (int i = 1; i < matrica.length; i++) {
				for (int j = 1; j < matrica.length; j++) {
					double n1 = matrica[i][j] * X[j] + B[i];
					x[i] = (1 - w) * X[i]
							+ (w * ((-1) * sum(i - 1, matrica[i][j] * x[j]) - sum_1(i + 1, matrica.length, n1)))
									/ matrica[i][i];

				}

			}

			if (V_distace(x, X) > TOL) {
				Vektori(x);

				System.exit(0);
			}

			else {
				k++;

				for (int i = 1; i < matrica.length; i++) {
					X[i] = x[i];

				}
			}

		}

		System.out.println("Eshte kaluar numri maximal i iterimeve");

	}

	public static double sum(int kufiri, double numri) {
		double sum = 0;
		for (int i = 1; i <= kufiri; i++) {
			sum = sum + numri;

		}
		return sum;

	}

	public static double sum_1(int fillimi, int kufiri, double numri) {
		double sum = 0;
		for (int i = fillimi; i <= kufiri; i++) {
			sum = sum + numri;

		}
		return sum;

	}

	public static double V_distace(double[] A, double[] B) {
		double rez = Math.abs(A[0] - B[0]);

		for (int i = 0; i < A.length; i++) {

			if (Math.abs(A[i] - B[i]) > Math.abs(rez)) {
				rez = Math.abs(A[i] - B[i]);
			}
		}
		return rez;

	}

	public static void Vektori(double[] v) {
		for (int i = 0; i < v.length; i++) {
			System.out.println(v[i] + ",");

		}

	}

	public static void main(String[] args) {
		double[][] A = { { 4, 3, 0 }, { 3, 4, -1 }, { 0, -1, 4 } };
		double[] B = { 24, 30, -24 };
		double[] X = { 1, 1, 1 };
		sor_method(A, B, X, 1.25, 20, 0.0000001);

	}

}
