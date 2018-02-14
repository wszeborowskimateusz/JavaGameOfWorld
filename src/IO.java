import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//Zapis i wczytywanie
public class IO extends JFrame{

	Swiat swiat;
	protected JPanel ios = new JPanel();
	protected JTextArea text= new JTextArea("");
	protected JButton OK = new JButton("OK");
	public IO(Swiat s)
	{
		super("Zapis i wczytywanie");
		setSize(250,250);
		setResizable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		add(ios);
		
		//Pole do wprowadzenia nazwy pliku
		text.setText("Podaj nazwa pliku");
		text.setEditable(true);
		text.setMaximumSize(new Dimension(50,100));
		ios.add(text);
		
		ios.add(OK);
		swiat = s;
	}
	public void zapis()
	{
		OK.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent e) { 
		  String nazwa = text.getText();
		  swiat.zapiszSwiat(nazwa);
          dispose(); 
     }
		});
	}
	public void wczytaj()
	{
		OK.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent e) { 
		  String nazwa = text.getText();
		  try {
			swiat.wczytajSwiat(nazwa,swiat);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("Nie znaleziono pliku o podanej nazwie");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
          dispose(); 
     }
		});
		
	}
}
