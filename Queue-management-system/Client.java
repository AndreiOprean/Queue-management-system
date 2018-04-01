package tema2;

import java.util.Random;

public class Client {
	private int arrivalTime;
	private int processingTime;
	private int ID;
	
	public Client(int minC,int maxC,int minS,int maxS,int ID){
		Random r = new Random();
		arrivalTime = r.nextInt(maxC - minC + 1) + minC; //generarea aleatoare a informatiirlor despre client
		processingTime = r.nextInt(maxS - minS + 1) + minS;
		this.ID = ID;
	}
	
	public int getarrivalTime(){
		return arrivalTime;
	}
	
	public int getprocessingTime(){
		return processingTime;
	}
	
	public int getID(){
		return ID;
	}
	
	
}
