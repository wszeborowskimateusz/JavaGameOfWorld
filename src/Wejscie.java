import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class Wejscie extends IO{

	
	public Wejscie()
	{
		super(null);
		text.setText("Podaj szerokosc i wysokosc (po spacji)");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ios.add(OK);
		setVisible(true);
	}
	
	@Override
	public void wczytaj()
	{

		OK.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent e) { 
		  int wysokosc = 20;
		  int szerokosc = 20;
		  String nazwa = text.getText();
		  String next[];
		  next = nazwa.split(" ");
		  try{
		  wysokosc = Integer.parseInt(next[0]);
		  szerokosc = Integer.parseInt(next[1]);
		  }catch(NumberFormatException error){
			  
		  }
		  
		  Swiat swiat=new Swiat(wysokosc,szerokosc);
		  Wilk wilk = new Wilk(swiat);
		  Owca owca = new Owca(swiat);
		  Trawa trawa = new Trawa(swiat);
		  Guarana guarana = new Guarana(swiat);
		  Mlecz mlecz = new Mlecz(swiat);
	      Wilcze_Jagody jagody = new Wilcze_Jagody(swiat);
		  Barszcz_Sosnowskiego barszcz = new Barszcz_Sosnowskiego(swiat);
		  Cyber_owca cyber = new Cyber_owca(swiat);
		  Zolw zolw = new Zolw(swiat);
		  Lis lis = new Lis(swiat);
		  Wilk wilk2 = new Wilk(swiat);
		  Wilk wilk3 = new Wilk(swiat);
		  Owca owca2 = new Owca(swiat);
		  Owca owca3 = new Owca(swiat);
		  Antylopa antylopa = new Antylopa(swiat);
		  Czlowiek czlowiek = new Czlowiek(swiat);
		  swiat.rysuj_plansze();
		  
		  dispose();
		}
	});
	
	}
}
