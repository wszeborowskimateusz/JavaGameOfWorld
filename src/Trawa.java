
public class Trawa extends Rosliny{

	public Trawa(Swiat s1)
	{
		obrazek = "trawa.png";
		nazwa = "Trawa";
		symbol = 'T';
		sila = 0;
		swiat = s1;
		polozenie_x = random.nextInt( swiat.getSzerokosc());
		polozenie_y = random.nextInt( swiat.getWysokosc());
		swiat.dodajDoPlanszy(polozenie_y, polozenie_x, 'T');
		swiat.dodajOrganizm(this);
		swiat.incrementIloscOrganizmow();
	}
}
