
public class Barszcz_Sosnowskiego extends Rosliny{

	public Barszcz_Sosnowskiego(Swiat s1)
	{
		obrazek = "barszcz_sosnowskiego.png";
		nazwa = "Barszcz";
		symbol = 'B';
		sila = 10;
		swiat = s1;
		polozenie_x = random.nextInt(swiat.getSzerokosc());
		polozenie_y = random.nextInt(swiat.getWysokosc());
		swiat.dodajDoPlanszy(polozenie_y, polozenie_x, 'B');
		swiat.dodajOrganizm(this);
		swiat.incrementIloscOrganizmow();
	}
	@Override
	public void akcja()
	{
		Organizm tmp = swiat.getPierwszyOrganizm();
		while (tmp != null)
		{
			if (((tmp.getPolozenie_x() == polozenie_x + 1 && tmp.getPolozenie_y() == polozenie_y)
				|| (tmp.getPolozenie_x() == polozenie_x - 1 && tmp.getPolozenie_y() == polozenie_y)
				|| (tmp.getPolozenie_x() == polozenie_x && tmp.getPolozenie_y() + 1 == polozenie_y)
				|| (tmp.getPolozenie_x() == polozenie_x && tmp.getPolozenie_y() - 1 == polozenie_y)
				|| (tmp.getPolozenie_x() == polozenie_x + 1 && tmp.getPolozenie_y() + 1 == polozenie_y)
				|| (tmp.getPolozenie_x() == polozenie_x - 1 && tmp.getPolozenie_y() - 1 == polozenie_y)
				|| (tmp.getPolozenie_x() == polozenie_x + 1 && tmp.getPolozenie_y() - 1 == polozenie_y)
				|| (tmp.getPolozenie_x() == polozenie_x - 1 && tmp.getPolozenie_y() + 1 == polozenie_y))
				&& (tmp.czyGinieOdBarszczu()==true) && tmp != this && tmp.getSymbol()!='C')
			{
				swiat.dodajWiadomosc(" Barszcz sosnowskiego wlasnie unicestwil ");
				swiat.dodajWiadomosc(tmp.getNazwa());
				swiat.dodajWiadomosc(" ");
				tmp.kill();
			}
			tmp = tmp.getNext();
		}
	}
	@Override
	public boolean czyRoslinaTrujaca(){return true;}
	@Override
	public boolean czyZabijZjadajacego(Organizm atakujacy)
	{
		if(atakujacy.getSymbol()=='C')return false;
		else return true;
	}
}
