
public class Cyber_owca extends Zwierzeta{

	public Cyber_owca(Swiat s1)
	{
		obrazek = "cyber_owca.jpg";
		nazwa = "Cyber owca";
		symbol = 'C';
		swiat = s1;
		sila = 11;
		inicjatywa = 4;
		polozenie_x = random.nextInt(swiat.getSzerokosc());
		polozenie_y = random.nextInt(swiat.getWysokosc());
		swiat.dodajDoPlanszy(polozenie_y, polozenie_x, 'C');
		swiat.dodajOrganizm(this);
		swiat.incrementIloscOrganizmow();
	}
	@Override
	public void akcja()
	{
		Organizm  tmp = swiat.getPierwszyOrganizm();
		boolean barszcz = false;
		int barszcz_x = 0, barszcz_y=0;
		while (tmp != null)
		{
			if (tmp.getSymbol() == 'B' || tmp instanceof Barszcz_Sosnowskiego)
			{
				barszcz = true;
				barszcz_x = tmp.getPolozenie_x();
				barszcz_y = tmp.getPolozenie_y();
				break;
			}
			tmp = tmp.getNext();
		}
		if (barszcz)
		{
			int polozenie_y_before = polozenie_y;
			int polozenie_x_before = polozenie_x;

			swiat.dodajDoPlanszy(polozenie_y, polozenie_x, ' ');

			if (polozenie_x < barszcz_x)polozenie_x++;
			else if (polozenie_x > barszcz_x)polozenie_x--;

			if (polozenie_y < barszcz_y)polozenie_y++;
			else if (polozenie_y > barszcz_y)polozenie_y--;

			if (swiat.getPlansza(polozenie_y, polozenie_x) != ' ')
			{
				Organizm tmp2 = swiat.getPierwszyOrganizm();
				while (tmp2 != null)
				{
					if (tmp2.getPolozenie_x() == polozenie_x && tmp2.getPolozenie_y() == polozenie_y && tmp2 != this)
					{
							kolizja(tmp2, polozenie_y_before, polozenie_x_before);
							break;
					}
					tmp2 = tmp2.getNext();
				}
			}
			else { swiat.dodajDoPlanszy(polozenie_y, polozenie_x, symbol); }

		}
		//Zachowuje siê jak zwyk³a owca
		else
		{
			super.akcja();
		}
	}
	@Override
	public boolean czyGinieOdBarszczu(){return false;}
}
