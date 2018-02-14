
public class Mlecz extends Rosliny {

	public Mlecz(Swiat s1)
	{
		obrazek = "mlecz.png";
		nazwa = "Mlecz";
		symbol = 'M';
		sila = 0;
		swiat = s1;
		polozenie_x = random.nextInt(swiat.getSzerokosc());
		polozenie_y = random.nextInt(swiat.getWysokosc());
		swiat.dodajDoPlanszy(polozenie_y, polozenie_x, 'M');
		swiat.dodajOrganizm(this);
		swiat.incrementIloscOrganizmow();
	}
	@Override 
	public void akcja()
	{
		super.akcja();
		super.akcja();
		super.akcja();
	}
}
