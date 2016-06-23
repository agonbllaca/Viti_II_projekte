package numerike_II;
import javax.swing.*;
public class Population_Growth_Rate {

	private static double annual_percentage;
	private static int nrI_viteve;
	private static int popullsia_present;
	private static int popullsia_future;
	
	public int kalulo_rritjen(){
		return (int)((annual_percentage*nrI_viteve*popullsia_present)/100 +popullsia_present);
	} 
	
	public double kalkulo_perqindjen(){
		return ((popullsia_future-popullsia_present)*100.0/(popullsia_present));
	}
	
	public void setVitet(int vitet){
		nrI_viteve=vitet;
	}
	
	public int getVitet(){
		return nrI_viteve;
	}
	
	public void setPresent_Population(int popullata){
		popullsia_present=popullata;
	}
	public int getPresent_Population(){
		return popullsia_present;
	}
	
	
	public void setFuture_Population(int popullata){
		popullsia_future=popullata;
	}
	public int getFuture_Population(){
		return  popullsia_future;
	}
	
	
	public void setAnual(double anual){
		annual_percentage=anual;
	}
	public double getAnual(){
		return annual_percentage;
	}
	
}
