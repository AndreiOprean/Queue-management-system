package tema2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Server extends Thread{
	private BlockingQueue<Client> clienti = new ArrayBlockingQueue<Client>(1000);	
	private int servID;
	private int timp;
	private JTextField[] coz;
	private  JTextArea logger;
	private int m;
	private int maxSim;
	private int tSim;
	public Server(int servID,JTextField[] c,JTextArea logger,int maxSim){
		this.servID = servID;
		timp = 0;
		tSim = 0;
		this.coz = c;
		this.logger = logger;
		this.maxSim = maxSim;
	}
	
	public  void addClient(Client c,int m) throws InterruptedException{
		
		
		
		this.m = m;
		
		clienti.put(c);
		timp = timp + c.getprocessingTime();
		
		coz[m].setText("");
		for (int i = 0;i < clienti.size() ;i++){
			coz[m].setText(coz[m].getText() + "[C]  " );
		}
		
		logger.setText(logger.getText() +"\n" + "Client: " + c.getID() + "  adaugat la serverul  " + servID  );

	}
	
	public  Client delClient() throws InterruptedException{
	
		Client c = clienti.take();
		for (int i = 0;i < clienti.size() ;i++){
			coz[m].setText(coz[m].getText() + "[C]  " );
		}
		
		sleep(c.getprocessingTime() * 500);
		logger.setText(logger.getText() + "\n" +"Clientul: " + c.getID() + " a fost procesat de serverul " + servID);
		timp = timp - c.getprocessingTime();
		
		return c;
	}
	
	public void run(){
		try{
			while(tSim < maxSim){
				coz[m].setText("");
				Client dc = delClient();
				tSim = tSim + 1;
			}
		}
		catch(InterruptedException e){
			System.out.println("Va rugam nu va inghesuiti la cozi");
		}
		
		
	}
	
	public int getTimp(){
		return timp;
	}
	
}