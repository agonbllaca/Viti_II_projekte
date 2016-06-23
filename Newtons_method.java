package numerike_II;


public class Newtons_method{
	
	public static double L2_norm(double[] vector)
	{
		double rezult = 0;
		for(int i=0;i<vector.length;i++){		
			rezult = rezult + Math.pow(vector[i], 2);
		}
		return Math.sqrt(rezult);
	}
	
	
	public static double[][] m_subt(double[][] m1,double[][] m2)
	{
		double[][] rezult = new double[m1.length][m1.length];
		for(int i=0;i<m1.length;i++)
		{
			for(int j=0;j<m1.length;j++){
				rezult[i][j] = m1[i][j] - m2[i][j];
			}
		}
		return rezult;
	}
	
    public static double[][] inverse_3X_3(double[][] A) {
        double[][] rez = new double[3][3];
        double matrix_det = A[0][0] * A[1][1] * A[2][2] + A[0][2] * A[1][0] * A[2][1]
        			+ A[2][0] * A[1][2] * A[0][1]- A[2][0] * A[1][1] * A[0][2] 
        			- A[2][2] * A[1][0] * A[0][1] - A[0][0] * A[2][1] * A[1][2]; 
                      
        rez[0][0] = 1 / matrix_det * (A[1][1] * A[2][2] - A[2][1] * A[1][2]);
        rez[0][1] = 1 / matrix_det * (A[0][2] * A[2][1] - A[2][2] * A[0][1]);
        rez[0][2] = 1 / matrix_det * (A[0][1] * A[1][2] - A[1][1] * A[0][2]);
        rez[1][0] = 1 / matrix_det * (A[1][2] * A[2][0] - A[2][2] * A[1][0]);
        rez[1][1] = 1 / matrix_det * (A[0][0] * A[2][2] - A[2][0] * A[0][2]);
        rez[1][2] = 1 / matrix_det * (A[0][2] * A[1][0] - A[1][2] * A[0][0]);
        rez[2][0] = 1 / matrix_det * (A[1][0] * A[2][1] - A[2][0] * A[1][1]);
        rez[2][1] = 1 / matrix_det * (A[0][1] * A[2][0] - A[2][1] * A[0][0]);
        rez[2][2] = 1 / matrix_det * (A[0][0] * A[1][1] - A[1][0] * A[0][1]);
        
        return rez;
    }
	
    public static double[][] m_multiplication(double[][] m1, double[][] m2) 
    {
        double[][] rez = new double[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) 
        {
            for (int j = 0; j < m2[0].length; j++){ 
            
                for (int k = 0; k < m1[0].length; k++) {
                
                    rez[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return rez;
    }
	
	public static double[][] function(double X_1,double X_2,double X_3)
	{
		double[][] rez = new double[3][3];		
		rez[0][0] = 3.0*X_1 - Math.cos(X_2*X_3) - 1.0/2;
		rez[1][0] = X_1*X_1 - 81.0*Math.pow(X_2+0.1,2) + Math.sin(X_3) + 1.06;
		rez[2][0] = Math.exp(-X_1*X_2) + 20.0*X_3 + (10*Math.PI - 3)/3.0;
		return rez;
	}
	
	public static double[][] f_prim(double X_1,double X_2,double X_3)
	{
		double[][] rez = new double[3][3];
		rez[0][0] = 3;
		rez[0][1] = X_3*Math.sin(X_2*X_3);
		rez[0][2] = X_2*Math.sin(X_2*X_3);
		rez[1][0] = 2*X_1;
		rez[1][1] = -162*(X_2+0.1);
		rez[1][2] = Math.cos(X_3);
		rez[2][0] = -1*X_2*Math.exp(-1*X_1*X_2);
		rez[2][1] = -1*X_1*Math.exp(-1*X_1*X_2);
		rez[2][2] = 20;
		return rez;
	}
	
	public static double[][] n_equations(int N, double[][] x, double TOL)
	{
		double[][] y = new double[x.length][x.length];
		int k = 0;
		while(k<N)
		{
			double[][] inversedJ = inverse_3X_3(f_prim(x[0][0],x[1][0],x[2][0]));
			y = m_multiplication(inversedJ,function(x[0][0],x[1][0],x[2][0]));
			x = m_subt(x,y);
			double[] y1 = {y[0][0],y[1][0],y[2][0]};
			if(L2_norm(y1)<TOL)
			{return x;}
			k++;
		}
		return x;
	}
	
	public static void main(String[] args)
	{
		double[][] A = {{0.1,0,0},	
						    {0.1,0,0},
					       {-0.1,0,0}};
		double[][] x = n_equations(6,A,0.000000000000000001);
		System.out.println("	Zgjidhjet");
		System.out.println("X1: "+x[0][0] + "\nX2: " +x[1][0] + "\nX3: " + x[2][0]);
		System.out.println("\n	Vërtetimi: ");
		System.out.println("E1: "+(3.0*x[0][0] - Math.cos(x[1][0]*x[2][0]) - 1.0/2)); 
		System.out.println("E2: "+(x[0][0]*x[0][0] - 81.0*Math.pow(x[1][0]+0.1,2) + Math.sin(x[2][0]) + 1.06)); 
		System.out.println("E3: "+(Math.exp(-x[0][0]*x[1][0]) + 20.0*x[2][0] + (10*Math.PI - 3)/3.0)+" = 0"); 
	}

}
