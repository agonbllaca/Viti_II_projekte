package numerike_II;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import numeric.DecimalFloating;

public class PageRank {
	// 1==>2,3;2==>1,3;3==>2 cilat linqe i kan faqet perkatese
	private static double[][] Pages_Statistics = { { 0, 0.5, 0.5, 0 }, { 0, 1.0 / 3.0, 1.0 / 3.0, 1.0 / 3.0 },
			{ 0, 1, 0, 0 } };

	// merr si hyrje nje matric qe prezanton rendin e faqes dhe me cilat linqe
	// te faqeve tjera lidhet ajo

	public static double[] Page_rank(double[][] a) {
		Double[] v = new Double[a[0].length];
		for (int i = 0; i < v.length; i++) {
			v[i] = DecimalFloating.fl(1.0 / v.length);
		}

		double[] aXv = new double[v.length];
		double[] a_kXv = new double[v.length];
		double[] save = new double[v.length];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				aXv[i] = aXv[i] + a[i][j] * v[i];
			}
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				a_kXv[i] = a_kXv[i] + a[i][j] * aXv[i];
			}
		}

		return aXv;
	}

	public static void main(String[] args) {
		DecimalFloating f = new DecimalFloating();
		f.setNumDigits(2);
		f.setRounding(RoundingMode.DOWN);
		double[] a = Page_rank(Pages_Statistics);
		System.out.println("Page rank per faqe e dhena eshte vektori\n");
		for (int i = 0; i < a.length; i++) {
			a[i] = f.fl(a[i]);
			System.out.println(a[i]);
		}
	}
}
