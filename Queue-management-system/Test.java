package tema2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Test {
	

	private int maxClient;
	private int minClient;
	private int maxSimulare;
	private int minSimulare;
	public int cozi;
	private int maxService;
	private int minService;
	private JTextField[] c;
	private Procesare pr;
	private Panel p = new Panel();
	private JTextArea logger;
	private JScrollPane scroll;
	
	public Test(){
		
	}
	
	
	public void primireaDatelor(){
	
		p.ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				minClient = Integer.parseInt(p.minClient.getText());
				maxClient = Integer.parseInt(p.maxClient.getText());
				maxSimulare = Integer.parseInt(p.finalProg.getText());
				minSimulare = Integer.parseInt(p.startProg.getText());
				cozi = Integer.parseInt(p.nrCozi.getText());
				maxService = Integer.parseInt(p.maxServic.getText());
				minService = Integer.parseInt(p.minServic.getText());
				c= new JTextField[cozi];
				
				logger = new JTextArea();
				scroll = new JScrollPane(logger,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				p.log.add(scroll);
				for (int i = 0;i<cozi;i++){
					
					p.iesire.add(new JLabel("Coada" + String.valueOf(i)));
					c[i] = new JTextField(10);
					p.iesire.add(c[i]);
					
					p.iesire.revalidate();
				
					
				}
				 pr = new Procesare(minClient,maxClient,minSimulare,maxSimulare,cozi,minService,maxService,c,logger);
			
				pr.start();
							
		}
	});
	}
	
	
	
	
	
	
	
	public static void main(String[] args){
		
		Test t = new Test();
		t.primireaDatelor();
		
		
	}
	
}
