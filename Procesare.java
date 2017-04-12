package tema2;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Procesare extends Thread {

	
	
	private int maxClient;
	private int minClient;
	private int maxSimulare;
	private int minSimulare;
	private int cozi;
	private int maxService;
	private int minService;
	private int nrClient;
	private Server[] servere;
	private int sid;
	private int m;
	private int interval;
	private	JTextField[] coz;
	private JTextArea logger;
	
	
	
	public Procesare(int minClient,int maxClient,int minSimulare,int maxSimulare,int cozi,int minService,int maxService,JTextField[] c,JTextArea logger){
		this.minClient = minClient;
		this.maxClient = maxClient;
		this.minSimulare = minSimulare;
		this.maxSimulare = maxSimulare;
		this.cozi = cozi;
		this.minService = minService;
		this.maxService = maxService;
		this.coz = c;
		this.logger = logger;
		sid = 0;
	
		servere = new Server[cozi];
		for (int i=0;i<cozi;i++){
			servere[i] = new Server(sid,coz,logger,maxSimulare);
			sid++;
			
			servere[i].start();
		}
		
	}
	//metoda care gaseste coada cu cel mai putin timp de asteptare(processingTime) adunat si intoarce indicele cozii
	public int getTimpMin(){
		int min = Integer.MAX_VALUE;
		int index = 0;
		min = servere[0].getTimp();
		index = 0;
		for (int i=0;i<cozi;i++ ){
	
			if(servere[i].getTimp()<min){
				min = servere[i].getTimp();
				index = i;
			}
		}
	
		return index;
	}
	
	
	public void run(){
		
		interval = minSimulare;
		try{
		sleep(minSimulare*500);
		
		}
		catch(InterruptedException e){
			System.out.println("Va rugam nu va inghesuiti la cozi");
		}
		
		while(interval <= maxSimulare){
		try{
			
			Client c = new Client(minClient,maxClient,minService,maxService,nrClient);
			nrClient++; 
			m = getTimpMin();	
			
			interval++;
				sleep(c.getarrivalTime() * 500);
				servere[m].addClient(c,m);
			}
		
		catch(InterruptedException e){
			System.out.println("Va rugam nu va inghesuiti la cozi");
		}
	}
		
	
}
	
	
}
