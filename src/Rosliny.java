
public class Rosliny extends Organizm {

	public Rosliny(){inicjatywa=0;}
	@Override
	public void kolizja(Organizm broniacy, int polozenie_y_before, int polozenie_x_before){
		
	}
	@Override 
	public void akcja(int zasieg){
		int szansa = random.nextInt(20);
		if (szansa == 0) 
		{
			int polozenie_x_dziecko, polozenie_y_dziecko;
			int wysokosc = swiat.getWysokosc();
			int szerokosc = swiat.getSzerokosc();
			int mozliwe_kierunki[] = new int [8];
			for(int i=0;i<8;i++)mozliwe_kierunki[i]=0;

			if (polozenie_y + 1 < wysokosc && swiat.getPlansza(polozenie_y + 1, polozenie_x) == ' ')mozliwe_kierunki[0] = 1;
			if (polozenie_y - 1 >= 0 && swiat.getPlansza(polozenie_y - 1, polozenie_x) == ' ')mozliwe_kierunki[1] = 1;
			if (polozenie_x - 1 >= 0 && swiat.getPlansza(polozenie_y, polozenie_x - 1) == ' ')mozliwe_kierunki[2] = 1;
			if (polozenie_x + 1 < szerokosc && swiat.getPlansza(polozenie_y, polozenie_x + 1) == ' ')mozliwe_kierunki[3] = 1;
			if (polozenie_y - 1 >= 0 && polozenie_x - 1 >= 0 && swiat.getPlansza(polozenie_y - 1, polozenie_x - 1) == ' ')mozliwe_kierunki[4] = 1;
			if (polozenie_y + 1 < wysokosc && polozenie_x + 1 < szerokosc && swiat.getPlansza(polozenie_y + 1, polozenie_x + 1) == ' ')mozliwe_kierunki[5] = 1;
			if (polozenie_y - 1 >= 0 && polozenie_x + 1 < szerokosc && swiat.getPlansza(polozenie_y - 1, polozenie_x + 1) == ' ')mozliwe_kierunki[6] = 1;
			if (polozenie_y + 1 < wysokosc && polozenie_x - 1 >= 0 && swiat.getPlansza(polozenie_y + 1, polozenie_x - 1) == ' ')mozliwe_kierunki[7] = 1;

			int ile = 0;
			for (int i = 0; i < 8; i++)
			{
				if (mozliwe_kierunki[i] == 1)ile++;
			}

			if (swiat.getIloscOrganizmow() >= swiat.getSzerokosc()*swiat.getWysokosc()
				|| (ile == 0))
			{
				//swiat.dodajWiadomosc(" Nieudana proba rozprzestrzenienia ");
				//swiat.dodajWiadomosc(this.getNazwa());
				//swiat.dodajWiadomosc(" ");
				return;
			}
			else
			{
				int random1 = random.nextInt(8);
				while (mozliwe_kierunki[random1] != 1)
				{
					random1 = random.nextInt(8);
				}
				if (random1 == 0)
				{
					polozenie_y_dziecko = polozenie_y + 1;
					polozenie_x_dziecko = polozenie_x;
				}
				else if (random1 == 1)
				{
					polozenie_y_dziecko = polozenie_y - 1;
					polozenie_x_dziecko = polozenie_x;
				}
				else if (random1 == 2)
				{
					polozenie_y_dziecko = polozenie_y;
					polozenie_x_dziecko = polozenie_x - 1;
				}
				else if (random1 == 3)
				{
					polozenie_y_dziecko = polozenie_y;
					polozenie_x_dziecko = polozenie_x + 1;
				}
				else if (random1 == 4)
				{
					polozenie_y_dziecko = polozenie_y - 1;
					polozenie_x_dziecko = polozenie_x - 1;
				}
				else if (random1 == 5)
				{
					polozenie_y_dziecko = (polozenie_y + 1);
					polozenie_x_dziecko = (polozenie_x + 1);
				}
				else if (random1 == 6)
				{
					polozenie_y_dziecko = (polozenie_y - 1);
					polozenie_x_dziecko = (polozenie_x + 1);
				}
				else
				{
					polozenie_y_dziecko = (polozenie_y + 1);
					polozenie_x_dziecko = (polozenie_x - 1);
				}

				Organizm tmp = null;
				switch (this.getSymbol())
				{
				case 'T': tmp = new Trawa(swiat); break;
				case 'M': tmp = new Mlecz(swiat); break;
				case 'G': tmp = new Guarana(swiat); break;
				case 'J': tmp = new Wilcze_Jagody(swiat); break;
				default:break;
				}
				swiat.dodajDoPlanszy(tmp.getPolozenie_y(), tmp.getPolozenie_x(), ' ');
				tmp.setPolozenie_x(polozenie_x_dziecko);
				tmp.setPolozenie_y(polozenie_y_dziecko);
				tmp.setDelay(true);
				swiat.dodajDoPlanszy(tmp.getPolozenie_y(), tmp.getPolozenie_x(), tmp.getSymbol());
				swiat.dodajWiadomosc(this.getNazwa());
				swiat.dodajWiadomosc(" wlasnie sie rozprzestrzenil \n");
				
			}
		}
		else return;
	}
	@Override
	public void akcja()
	{
		akcja(1);
	}
	@Override
	public boolean czyGinieOdBarszczu(){return false;}
	
	
}
