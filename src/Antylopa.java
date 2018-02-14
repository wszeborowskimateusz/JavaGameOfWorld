
public class Antylopa extends Zwierzeta{

	public Antylopa(Swiat s1)
	{ 
		obrazek = "antylopa.png";
		nazwa = "Antylopa";
		symbol = 'A';
		swiat = s1;
		sila = 4;
		inicjatywa = 4;
		polozenie_x = random.nextInt(swiat.getSzerokosc());
		polozenie_y = random.nextInt(swiat.getWysokosc());
		swiat.dodajDoPlanszy(polozenie_y, polozenie_x, symbol);
		swiat.dodajOrganizm(this);
		swiat.incrementIloscOrganizmow();
	}
	@Override
	public void akcja()
	{
		super.akcja(2);
	}
	@Override
	public boolean czyUcieka(){return true;}
}
