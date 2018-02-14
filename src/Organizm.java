import java.util.Random;

public abstract class  Organizm {

	public final Random random = new Random();
	protected int sila;
	protected int polozenie_x;
	protected int polozenie_y;
	protected int inicjatywa;
	protected Swiat swiat;
	protected char symbol;
	protected String nazwa;
	protected Organizm next;
	protected boolean delay;
	protected String obrazek;
	
	public Organizm()
	{
		delay = false;
	}
	public void kill()
	{
		swiat.decrementIloscOrganizmow();
		swiat.dodajDoPlanszy(polozenie_y, polozenie_x, ' ');
		swiat.usunOrganizm(this);
	}
	public void akcja(int zasieg){}
	public void akcja(){akcja(1);}
	public void kolizja(Organizm  broniacy, int polozenie_y_before, int polozenie_x_before){}
	public int getSila(){return sila;}
	public void setSila(int s){sila=s;}
	public int getInicjatywa(){return inicjatywa;}
	public int getSzerokoscSwiata() { int i = swiat.getSzerokosc(); return i;}
	public int getWysokoscSwiata() { int i = swiat.getWysokosc(); return i; }
	public int getPolozenie_x() { return polozenie_x; }
	public int getPolozenie_y() { return polozenie_y; }
	public void setPolozenie_y(int y) { polozenie_y = y; }
	public void setPolozenie_x(int x) { polozenie_x = x; }
	public char getSymbol() { return symbol; }
	public Organizm getNext()  { return next; }
	public void setNext(Organizm organizm) { next = organizm; }
	public boolean czyOdbijAtak(Organizm atakujacy){return false;};
	public boolean czyGinieOdBarszczu(){return true;}
	public boolean czyDobryWech(Organizm broniacy){return false;}
	public boolean czyUcieka(){return false;}
	public boolean czyRoslinaTrujaca(){return false;}
	public boolean czyZabijZjadajacego(Organizm atakujacy){return false;}
	public String getNazwa() { return nazwa; }
	public boolean getDelay() { return delay; }
	public void setDelay(boolean x) { delay = x; }
	public String getObrazek(){return obrazek;}
}
