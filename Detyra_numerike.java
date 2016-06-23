package numerike_II;

public class Detyra_numerike {
	// hapsira eshte e koduar me 32 kurse alfabeti eshte i koduar me
	// Beckward Code dhe me numra psh. a=z por kjo e shprehur me numra i bie
	// a=26 dhe z=1.
	// Kjo vlen per shkronjat e vogla. Shkronjat e medha jane te koduara ne
	// numrin e karakterit te tyre psh. A=65...Z=90 .
	// Mesazhin do ta kodojme ne matric katrore. Kurse dekodimi mund te behet me
	// qfardo lloj matrice.
	public static int[][] Kodusi(String a) {

		int n = 0;
		for (int i = 1; i * i <= a.length(); i++) {
			n = i + 1;
		}
		int[][] matrica_koduar = new int[n][n];

		int counter = 0;
		char shkronja;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (counter < a.length()) {
					if (a.charAt(counter) == ' ') {
						matrica_koduar[i][j] = 32;
					} else if ((int) (a.charAt(counter)) >= 97)// kodon
																// shkronjat e
																// vogla
					{
						shkronja = a.charAt(counter);
						matrica_koduar[i][j] = 123 - (int) (shkronja);
					} else if ((int) (a.charAt(counter)) <= 90)// kodon
																// shkronjat e
																// medha
					{
						shkronja = a.charAt(counter);
						matrica_koduar[i][j] = (int) (shkronja);
					}
					counter++;
				} else {
					matrica_koduar[i][j] = 32;
				}
			}
		}
		return matrica_koduar;
	}

	// Dekodusi merr matricene koduar te qfardo rendi dhe e kthen ne mesazh te
	// lexushem ne baze te kodimit te mesiperm
	public static String Dekodus(int[][] a) {
		int m = a.length;
		int n = a[0].length;

		String mesazhi = "";

		char shkronja;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] != 32) {

					if (a[i][j] <= 26) {

						a[i][j] = 123 - a[i][j];
						shkronja = (char) (a[i][j]);
						mesazhi = mesazhi + shkronja;
					} else {
						shkronja = (char) (a[i][j]);
						mesazhi = mesazhi + shkronja;

					}
				}

				else {
					mesazhi = mesazhi + " ";
				}
			}
		}

		return mesazhi;
	}

	public static void main(String[] args) {

		int[][] a = Kodusi("Analiza matematike II");

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}

		int[][] c = { { 65, 13, 26, 15, 18 }, { 1, 26, 32, 14, 26 }, { 7, 22, 14, 26, 7 }, { 18, 16, 22, 32, 73 },
				{ 73, 32, 32, 32, 32 } };
		System.out.println(Dekodus(c));
	}

}
