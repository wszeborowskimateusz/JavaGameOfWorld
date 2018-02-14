
public class Wilcze_Jagody extends Rosliny{

	public Wilcze_Jagody(Swiat s1)
	{
		obrazek = "wilcze_jagody.png";
		nazwa = "Jagody";
		symbol = 'J';
		sila = 99;
		swiat = s1;
		polozenie_x = random.nextInt(swiat.getSzerokosc());
		polozenie_y = random.nextInt(swiat.getWysokosc());
		swiat.dodajDoPlanszy(polozenie_y, polozenie_x, 'J');
		swiat.dodajOrganizm(this);
		swiat.incrementIloscOrganizmow();
	}
	
	@Override
	public boolean czyRoslinaTrujaca(){return true;}
	
	@Override
	public boolean czyZabijZjadajacego(Organizm atakujacy){return true;}
}
