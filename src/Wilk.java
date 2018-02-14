
public class Wilk extends Zwierzeta {

	public Wilk(Swiat s1)
	{
		obrazek = "wilk.png";
		nazwa = "Wilk";
		symbol = 'W';
		sila = 9;
		inicjatywa = 5;
		swiat = s1;
		polozenie_x = random.nextInt(swiat.getSzerokosc());
		polozenie_y = random.nextInt(swiat.getWysokosc());
		swiat.dodajDoPlanszy(polozenie_y, polozenie_x, 'W');
		swiat.dodajOrganizm(this);
		swiat.incrementIloscOrganizmow();
	}
}
