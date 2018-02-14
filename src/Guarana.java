
public class Guarana extends Rosliny{

	public Guarana(Swiat s1)
	{
		obrazek = "guarana.jpg";
		nazwa = "Guarana";
		symbol = 'G';
		sila = 0;
		swiat = s1;
		polozenie_x = random.nextInt(swiat.getSzerokosc());
		polozenie_y = random.nextInt(swiat.getWysokosc());
		swiat.dodajDoPlanszy(polozenie_y, polozenie_x, 'G');
		swiat.dodajOrganizm(this);
		swiat.incrementIloscOrganizmow();
	}
}
