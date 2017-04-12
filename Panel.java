package tema2;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel extends JPanel {
	public JFrame frame;
	public JPanel clienti,servire,cozi,durata,iesire,log;
	public JTextField minClient,maxClient,minServic,maxServic,nrCozi,startProg,finalProg;
	public JLabel minC,maxC,minS,maxS,nrC,startP,finalP;
	public JButton ok;
	
	
	public Panel(){
		frame = new JFrame("Simulator gestiune clienti");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,600);
		frame.setVisible(true);
		frame.setLayout(new GridLayout(10,5));
		inceput();
	}
	
	
	
	public void inceput(){
		clienti = new JPanel();
		servire = new JPanel();
		cozi = new JPanel();
		durata = new JPanel();
		ok = new JButton("OK");
		iesire = new JPanel();
		log = new JPanel();
		log.setLayout(new BoxLayout(log,BoxLayout.Y_AXIS));
		
		iesire.setLayout(new BoxLayout(iesire,BoxLayout.Y_AXIS));
		minC = new JLabel("Timp minim de sosire intre clienti");
		maxC = new JLabel("Timp maxim de sosire intre clienti");
		minClient = new JTextField(6);
		maxClient = new JTextField(6);
		
		minS = new JLabel("Timp minim de servire");
		maxS = new JLabel("Timp maxim de servire");
		minServic = new JTextField(6);
		maxServic = new JTextField(6);
		
		nrC = new JLabel("Numar de cozi");
		nrCozi = new JTextField(6);
		
		startP = new JLabel("Inceputul simularii");
		finalP = new JLabel("Sfarsitul simularii");
		startProg = new JTextField(6);
		finalProg = new JTextField(6);
		
		clienti.add(minC);
		clienti.add(minClient);
		clienti.add(maxC);
		clienti.add(maxClient);
		
		clienti.add(minS);
		clienti.add(minServic);
		clienti.add(maxS);
		clienti.add(maxServic);
		
		clienti.add(startP);
		clienti.add(startProg);
		clienti.add(finalP);
		clienti.add(finalProg);
		
		clienti.add(nrC);
		clienti.add(nrCozi);
		
		clienti.add(ok);
		
		
		
		JPanel p = new JPanel();
		
		
		p.add(clienti);
		
		
		
		p.add(iesire);
		p.add(log);
		p.setLayout(new GridLayout(2,10,0,5));
		frame.setContentPane(p);
		
		
		
	}
	

}
