import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Swiat extends JFrame implements KeyListener {
	private  Czlowiek_Ruch ruch;
	public boolean qPressed = false;
	private int numer_tury;
	private int wysokosc;
	private int szerokosc;
	private char plansza[][];
	private Organizm pierwszyOrganizm;
	private int ilosc_organizmow;
	private String wiadomosc;
	private Button buttons[][];
	JPanel p = new JPanel();
	
	public JTextArea text= new JTextArea(28,50);
	//For scroll bars in commentator
	JScrollPane sp = new JScrollPane(text);

	public Swiat(int wys,int sze){
		
		super("Mateusz Wszeborowski 165562");
		p.setLayout(new GridBagLayout());
		setSize(wys*100, sze*150);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		//Dodawanie przyciskow - planszy
		buttons = new Button[wys][sze];
		for(int i=0;i<wys;i++)
		{
			for(int j=0;j<sze;j++)
				{
					buttons[i][j] = new Button(wys,sze,this);
					buttons[i][j].setPreferredSize(new Dimension(30,30));
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = j;
					c.gridy = i;
					p.add(buttons[i][j],c);
					buttons[i][j].setPosy(i);
					buttons[i][j].setPosx(j);
				}
		}
		
		//Przyciski sterujace
		Button nastepna_tura = new Button("NASTEPNA TURA",this);
		Button zapisz = new Button("ZAPISZ",this);
		Button wczytaj = new Button("WCZYTAJ",this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weighty = 0.5;
		c.gridx = 1; 
		c.gridwidth = 2;   
		c.gridy = wys;       
		p.add(nastepna_tura,c);
		c.gridx = 3;
		p.add(zapisz,c);
		c.gridx = 5;
		p.add(wczytaj,c);
		
		//Setting text area
		text.setEditable(false);
		text.setMaximumSize(new Dimension(28,50));
		c.gridy = -1;
		c.gridheight=0;
		c.gridx=-1;
		p.add(sp, c);

		//Dodawanie panelu do ramki
		add(p);
		
		//Obsluga klawiatury
		addKeyListener(this);
		this.setFocusable(true);
    
		setVisible(true);
		
		ilosc_organizmow = 0;
		pierwszyOrganizm = null;
		wysokosc = wys;
		szerokosc = sze;
		wiadomosc = "";
		numer_tury = 0;
		plansza = new char [wysokosc][szerokosc];
		
		for(int i=0;i<wys;i++)
		{
			for(int j=0;j<sze;j++)plansza[i][j]=' ';
		}
	}
	
	public void wykonaj_ture(){
		wiadomosc = "";
		numer_tury++;
		Organizm tmp = pierwszyOrganizm;
		while (tmp != null)
		{
			if (tmp.getDelay())tmp.setDelay(false);
			else 
			{
				tmp.akcja();
			}
			tmp = tmp.getNext();
		}
		rysuj_plansze();
		text.setText(wiadomosc);
	}
	public void rysuj_plansze(){
		for(int i=0;i<wysokosc;i++)
		{
			for(int j=0;j<szerokosc;j++)
			{
				switch(plansza[i][j])
				{
				case 'Y':buttons[i][j].ZmienObrazek("czlowiek.png");break;
				case 'W':buttons[i][j].ZmienObrazek("wilk.png");break;
				case 'O':buttons[i][j].ZmienObrazek("owca.png");break;
				case 'L':buttons[i][j].ZmienObrazek("lis.png");break;
				case 'Z':buttons[i][j].ZmienObrazek("zolw.png");break;
				case 'A':buttons[i][j].ZmienObrazek("antylopa.png");break;
				case 'C':buttons[i][j].ZmienObrazek("cyber_owca.jpg");break;
				case 'T':buttons[i][j].ZmienObrazek("trawa.png");break;
				case 'M':buttons[i][j].ZmienObrazek("mlecz.png");break;
				case 'G':buttons[i][j].ZmienObrazek("guarana.jpg");break;
				case 'J':buttons[i][j].ZmienObrazek("wilcze_jagody.png");break;
				case 'B':buttons[i][j].ZmienObrazek("barszcz_sosnowskiego.png");break;
				default:buttons[i][j].setIcon(null);break;
				}
			}
		}
	}
	public int getWysokosc() {return wysokosc;}
	public int getSzerokosc(){return szerokosc;}
	public void setWysokosc(int wys){wysokosc=wys;}
	public void setSzerokosc(int sze){szerokosc=sze;}
	public char getPlansza(int wys,int sze){if(wys>=0 && wys<wysokosc && sze >= 0 && sze<szerokosc) return plansza[wys][sze]; else return '?'; }
	public int getNumerTury() { return numer_tury; }
	public void setNumerTury(int n) { numer_tury = n; }
	public Organizm getPierwszyOrganizm() { return pierwszyOrganizm; }
	public void dodajDoPlanszy(int wys, int sze , char zn)
	{
		if (wys < wysokosc && sze < szerokosc && wys >= 0 && sze >= 0)
		plansza[wys][sze] = zn;
	}
	public void incrementIloscOrganizmow() { ilosc_organizmow++; }
	public void decrementIloscOrganizmow() { ilosc_organizmow--; }
	public int getIloscOrganizmow() { return ilosc_organizmow; }
	public void dodajOrganizm(Organizm organizm)
	{
		if (pierwszyOrganizm == null) 
		{ 
			organizm.setNext(null);
			pierwszyOrganizm = organizm; 
		}
		else
		{
			Organizm tmp = pierwszyOrganizm;
			boolean dodanie = false;
			while (tmp != null)
			{
				if (tmp == pierwszyOrganizm && tmp.getInicjatywa() < organizm.getInicjatywa())
				{
					pierwszyOrganizm = organizm;
					organizm.setNext(tmp);
					dodanie = true;
					break;
				}
				else if (tmp.getNext()!=null &&tmp.getNext().getInicjatywa() < organizm.getInicjatywa())
				{
					organizm.setNext(tmp.getNext());
					tmp.setNext(organizm);
					dodanie = true;
					break;
				}
				tmp = tmp.getNext();
			}
			if (!dodanie)
			{
				Organizm tmp2 = pierwszyOrganizm;
				while (tmp2 != null)
				{
					if (tmp2.getNext() == null)
					{
						tmp2.setNext(organizm);
						organizm.setNext(null);
					}
					tmp2 = tmp2.getNext();
				}
			}
		}
	}
	public void usunOrganizm(Organizm organizm)
	{
		if (pierwszyOrganizm == organizm)
		{
			pierwszyOrganizm = organizm.getNext();
		}
		else 
		{
			Organizm tmp = pierwszyOrganizm;
			while (tmp != null)
			{
				if (tmp.getNext() == organizm)
				{
					tmp.setNext( tmp.getNext().getNext());
					break;
				}
				tmp = tmp.getNext();
			}
		}
	}
	public void dodajWiadomosc(String komunikat) { wiadomosc += komunikat; }
	public void wypiszWiadomosc(){System.out.println(wiadomosc);}
	public void zapiszSwiat(String nazwa){
			try{
			    PrintWriter writer = new PrintWriter(nazwa, "UTF-8");
			    //writer.println("The first line");
			    
			    int wysokosc = this.getWysokosc();
				int szerokosc = this.getSzerokosc();
				Organizm tmp = this.getPierwszyOrganizm();
				int numer_tury = this.getNumerTury();
				
				writer.println(wysokosc+" "+szerokosc+" "+numer_tury);
				while (tmp != null)
				{
					writer.print(tmp.getSymbol()+" "+tmp.getPolozenie_y()+" "+tmp.getPolozenie_x()+" "+tmp.getSila());
					if (tmp.getSymbol() == 'Y')
					{
						Czlowiek c = (Czlowiek)tmp;
						writer.print(" "+c.getMocSpecjalna() + " "+c.getCooldown()+" "+c.getLiczbaTurMocy()+" "+c.getLiczbaTurCooldown() );
					}
					tmp = tmp.getNext();
					writer.println();
				}
			    
			    writer.close();
			} catch (IOException e) {
			   System.out.println("NIE UDALO SIE ZAPISAC SWIATA");
			}
		}
	public Czlowiek_Ruch getRuch(){return ruch;}
	public void wczytajSwiat(String nazwa,Swiat sw) throws IOException, FileNotFoundException{
		
		Swiat s1 = null;
		int i=0;
        int wysokosc, szerokosc, numer_tury;
		String znak;
		int moc_specjalna=0;
		boolean cooldown = false;
		int liczba_tur_mocy=0;
		int liczba_tur_cooldown=0;
		Organizm tmp = null;
		int polozenie_y, polozenie_x, sila;
		String nextLine,next[];
		BufferedReader inFile = new BufferedReader(new FileReader(nazwa));
		while((nextLine = inFile.readLine())!= null){
		    	
			if(i==0)
			{
				next = nextLine.split(" ");
				wysokosc = Integer.parseInt(next[0]);
				szerokosc = Integer.parseInt(next[1]);
				numer_tury = Integer.parseInt(next[2]);
				s1 = new Swiat(wysokosc, szerokosc);
				s1.setNumerTury(numer_tury);
			}
			else
			{
				next = nextLine.split(" ");
				znak = next[0];
				polozenie_y = Integer.parseInt(next[1]);
				polozenie_x = Integer.parseInt(next[2]);
				sila = Integer.parseInt(next[2]);
				if(znak == "Y")
				{
					moc_specjalna = Integer.parseInt(next[3]);
					cooldown = Boolean.parseBoolean(next[4]);
					liczba_tur_mocy = Integer.parseInt(next[5]);
					liczba_tur_cooldown = Integer.parseInt(next[6]);
				}
				switch (znak)
				{
				case "Y":tmp = new Czlowiek(s1); break;
				case "W":tmp = new Wilk(s1); break;
				case "O":tmp = new Owca(s1); break;
				case "L":tmp = new Lis(s1); break;
				case "Z":tmp = new Zolw(s1); break;
				case "A":tmp = new Antylopa(s1); break;
				case "C":tmp = new Cyber_owca(s1); break;
				case "T":tmp = new Trawa(s1); break;
				case "M":tmp = new Mlecz(s1); break;
				case "G":tmp = new Guarana(s1); break;
				case "J":tmp = new Wilcze_Jagody(s1); break;
				case "B":tmp = new Barszcz_Sosnowskiego(s1); break;
				}
				if(tmp!=null){
					if (tmp.getSymbol() == 'Y')
					{
						((Czlowiek)tmp).setCooldown(cooldown);
						((Czlowiek)tmp).setLiczbaTurCooldown(liczba_tur_cooldown);
						((Czlowiek)tmp).setLiczbaTurMocy(liczba_tur_mocy);
						((Czlowiek)tmp).setMocSpecjalna(moc_specjalna);
					}
					s1.dodajDoPlanszy(tmp.getPolozenie_y(), tmp.getPolozenie_x(), ' ');
					tmp.setPolozenie_y(polozenie_y);
					tmp.setPolozenie_x(polozenie_x);
					tmp.setSila(sila);
					s1.dodajDoPlanszy(tmp.getPolozenie_y(), tmp.getPolozenie_x(), tmp.getSymbol());
				}
			}
			i++;
		 }

		    inFile.close();
		    if(s1!=null){
			    sw = s1;
			    sw.rysuj_plansze();
			    dispose();
		    }
		}
	public void dodajZwierze(int y,int x,char zn)
	{
		
		if(getPlansza(y, x)==' ')
		{		
			Organizm tmp = null;
			switch (zn)
			{
			case 'A': tmp = new Antylopa(this); break;
			case 'C': tmp = new Cyber_owca(this); break;
			case 'L': tmp = new Lis(this); break;
			case 'O': tmp = new Owca(this); break;
			case 'W': tmp = new Wilk(this); break;
			case 'Z': tmp = new Zolw(this); break;
			case 'T': tmp = new Trawa(this); break;
			case 'M': tmp = new Mlecz(this); break;
			case 'G': tmp = new Guarana(this); break;
			case 'J': tmp = new Wilcze_Jagody(this); break;
			case 'B': tmp = new Barszcz_Sosnowskiego(this); break;
			default:break;
			}
			if(tmp!=null)
			{
				this.dodajDoPlanszy(tmp.getPolozenie_y(), tmp.getPolozenie_x(), ' ');
				tmp.setPolozenie_x(x);
				tmp.setPolozenie_y(y);
				tmp.setDelay(true);
				this.dodajDoPlanszy(tmp.getPolozenie_y(), tmp.getPolozenie_x(), tmp.getSymbol());
				this.rysuj_plansze();
			}
		}
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_UP){
            ruch = Czlowiek_Ruch.GORA;
        }

		else if (code == KeyEvent.VK_DOWN){
        	ruch = Czlowiek_Ruch.DOL;
        }

		else if (code == KeyEvent.VK_LEFT){
        	ruch = Czlowiek_Ruch.LEWO;
        }

		else if (code == KeyEvent.VK_RIGHT){
           ruch = Czlowiek_Ruch.PRAWO;
        }
		else if(code == KeyEvent.VK_Q)
			{
				if(!qPressed)
				qPressed = true;
				else qPressed = false;
			}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
