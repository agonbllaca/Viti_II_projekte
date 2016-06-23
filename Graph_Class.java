package numerike_II;

import javax.swing.*;
import java.text.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class Graph_Class extends JPanel {

	public static Population_Growth_Rate test = new Population_Growth_Rate();

	public static int[] vlerat = new int[2];

	private static String title;

	public Graph_Class(int[] v, String t) {
		vlerat = v;
		title = t;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);

		g2.drawLine(75, 200, 325, 200);
		g2.drawString("50000", 35, 200);
		g2.drawLine(75, 150, 325, 150);
		g2.drawString("100000", 35, 150);
		g2.drawLine(75, 100, 325, 100);
		g2.drawString("150000", 35, 100);
		g2.drawLine(75, 50, 325, 50);
		g2.drawString("200000", 35, 50);

		Color gjelber1 = new Color(12, 166, 7);// e gjelberta e mbyllur
		g.setColor(gjelber1);
		g.fillRect(130, 250 - (int) (0.001 * vlerat[0]), 50, (int) (0.001 * vlerat[0]));
		Color gjelber2 = new Color(118, 255, 52);// e gjelberta e qelur
		g.setColor(gjelber2);
		g.fillRect(135, 255 - (int) (0.001 * vlerat[0]), 40, (int) (0.001 * vlerat[0]));

		Color kuq1 = new Color(248, 15, 15);// e kuqja e mbyllur
		g.setColor(kuq1);
		g.fillRect(220, 250 - (int) (0.001 * vlerat[1]), 50, (int) (0.001 * vlerat[1]));
		Color kuq2 = new Color(239, 69, 69);// e kuqja e qelur
		g.setColor(kuq2);
		g.fillRect(225, 255 - (int) (0.001 * vlerat[1]), 40, (int) (0.001 * vlerat[1]));

		g.setColor(Color.gray);
		g.drawString("" + vlerat[1], 225, 275);
		g.drawString("" + vlerat[0], 130, 275);
		path.moveTo(75, 250);
		path.lineTo(325, 250);

		Stroke stroke = new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		g2.setStroke(stroke);
		g2.draw(path);
		g.setColor(Color.black);
		g.drawString("Rritje per " + (vlerat[1] - vlerat[0]) + " ne periudhen " + test.getVitet() + " vjeqare", 40,
				290);

	}

	public static void llogarit_rritjen() {
		test.setAnual(new Double(JOptionPane.showInputDialog("Shenoni Perqindjen Anuale(Vjetore) : ")));
		test.setPresent_Population(new Integer(JOptionPane.showInputDialog("Shenoni numrin e popullsise : ")));
		test.setVitet(new Integer(JOptionPane.showInputDialog("Shenoni Distancen Kohore) : ")));
	}

	public static void llogarit_perqindjen() {
		test.setPresent_Population(
				new Integer(JOptionPane.showInputDialog("Shenoni numrin e popullsise ne kohe te mehershme : ")));
		test.setFuture_Population(
				new Integer(JOptionPane.showInputDialog("Shenoni numrin e popullsise ne kohe te mevonshme : ")));
	}

	public static void main(String[] args) {

		int i = new Integer(JOptionPane.showInputDialog(
				"Zgjidhni opcionin e deshiruar\n1:LLogarit rritjen e popullsise ne baze te\n perqindjes anuale\n2:LLogarit perqindjen e rritjes se popullsise"));
		DecimalFormat formato = new DecimalFormat("0.0000");
		if (i == 1) {
			llogarit_rritjen();

			vlerat[0] = test.getPresent_Population();
			vlerat[1] = test.kalulo_rritjen();
			JFrame f = new JFrame();
			f.setSize(400, 400);

			f.getContentPane().add(new Graph_Class(vlerat, "BarGraf"));
			f.getDefaultCloseOperation();
			f.setTitle("BarGraf");
			f.setVisible(true);

		} else if (i == 2) {
			llogarit_perqindjen();
			JOptionPane.showMessageDialog(null,
					"Perqindja e rritjes se popullates eshte " + formato.format(test.kalkulo_perqindjen()));
		} else {
			System.exit(0);
		}
	}
}
