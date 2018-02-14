
public class Zolw extends Zwierzeta {

	public Zolw(Swiat s1)
	{
		obrazek = "zolw.png";
		nazwa = "Zolw";
		symbol = 'Z';
		swiat = s1;
		sila = 2;
		inicjatywa = 1;
		polozenie_x = random.nextInt(swiat.getSzerokosc());
		polozenie_y = random.nextInt(swiat.getWysokosc());
		swiat.dodajDoPlanszy(polozenie_y, polozenie_x, 'Z');
		swiat.dodajOrganizm(this);
		swiat.incrementIloscOrganizmow();
	}
	@Override 
	public void akcja()
	{
		int chanceToMove = random.nextInt(4);
		if(chanceToMove<3)return;
		else super.akcja();
	}
	@Override
	public boolean czyOdbijAtak(Organizm atakujacy)
	{
		if(atakujacy.getSila()<5)return true;
		else return false;
	}
}
