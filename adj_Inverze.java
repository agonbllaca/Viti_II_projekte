package numerike_II;

public class adj_Inverze {

	
	public static double [][] matrica = new double [2][2];
	
	public double Determinanta2(double[][]a)//2x2
	{
		return a[0][0]*a[1][1]-a[0][1]*a[1][0];
	}
	public double Determinanta3(double[][]a)//3x3
	{
		return a[0][0]*a[1][1]*a[2][2]+a[1][0]*a[2][1]*a[0][2]-a[0][2]*a[1][1]*a[2][0]-a[1][2]*a[2][1]*a[0][0]-a[1][0]*a[0][1]*a[2][2];
	}
	
	public double [][] adjunguar(double[][]a)//2x2
	{
		double [][] adj=new double [2][2];
		adj[1][1]=a[0][0];
		adj[0][1]=-a[0][1];
		adj[1][0]=-a[1][0];
		adj[0][0]=a[1][1];
		
		return adj;
	}
	
	public double[][] minoret (double[][]a)
	{
		double [][]min=new double [3][3];
		
		min[0][0]=a[1][1]*a[2][2]-a[1][2]*a[1][2];
		return min;
		
	}
	
	public static void main(String[] args) {
		
	   
	     
	     
	}
}
