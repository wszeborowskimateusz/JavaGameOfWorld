import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;

public class Button extends JButton implements ActionListener{

	//Wysokosc i szerokosc planszy
	private static int wysokosc,szerokosc;
	private Swiat s;
	private int posx,posy;
	ImageIcon X,O;
	
	public Button(int wys, int sze,Swiat swiat)
	{
		s = swiat;
		wysokosc = wys;
		szerokosc = sze;
		Dimension pSize = new Dimension(5*wys, 5*sze);
		setPreferredSize(pSize);
		X = new ImageIcon(this.getClass().getResource("pusty.svg"));
		setIcon(X);
		this.addActionListener(this);
	}
	
	public Button(String napis,Swiat swiat)
	{
		s = swiat;
		setText(napis);
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		if(this.getText()=="NASTEPNA TURA")
		{
			s.wykonaj_ture();
			//Mozliwosc ruszania czlowiekiem po nowej turze, ustawienie focusu
			s.requestFocusInWindow();
		}
		else if(this.getText()=="ZAPISZ"){
			IO io = new IO(s);
			io.zapis();
		}
		else if(this.getText()=="WCZYTAJ"){
			IO io = new IO(s);
			io.wczytaj();
		}
		else
		{
			if(s.getPlansza(posy, posx)==' ')
			{
				Wybor wybor=new Wybor(posy,posx,s);
			}
		}
	}
	
	public int getPosx(){return posx;}
	public int getPosy(){return posy;}
	public void setPosx(int x){posx=x;}
	public void setPosy(int y){posy=y;}
	
	public void ZmienObrazek(String nazwa_obrazka)
	{
		ImageIcon obrazek = new ImageIcon(this.getClass().getResource(nazwa_obrazka));
		Image image = obrazek.getImage(); // transform it 
		Image newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		obrazek = new ImageIcon(newimg);
		setIcon(obrazek);
	}
	
}
