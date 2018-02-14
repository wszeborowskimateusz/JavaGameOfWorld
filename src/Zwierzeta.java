
public class Zwierzeta extends Organizm {

	@Override
	public void akcja(int zasieg)
	{
		swiat.dodajDoPlanszy(polozenie_y, polozenie_x, ' ');
		int polozenie_x_before = polozenie_x;
		int polozenie_y_before = polozenie_y;
		int szerokoscSwiata = swiat.getSzerokosc();
		int wysokoscSwiata = swiat.getWysokosc();
		int random2;
		if ((polozenie_y == 0 && polozenie_x == 0)||(polozenie_y == 0 && polozenie_x == szerokoscSwiata - 1)
			||(polozenie_y == wysokoscSwiata - 1 && polozenie_x == 0 )
			||(polozenie_y == wysokoscSwiata - 1 &&polozenie_x == szerokoscSwiata - 1)
			||(zasieg==2 && polozenie_x==1 && polozenie_y==1) || (zasieg == 2 && polozenie_x == 1 && polozenie_y == wysokoscSwiata-zasieg)
			|| (zasieg == 2 && polozenie_x == szerokoscSwiata-zasieg && polozenie_y == 1) 
			|| (zasieg == 2 && polozenie_x == szerokoscSwiata-zasieg && polozenie_y == wysokoscSwiata-zasieg)
			|| (zasieg == 2 && ((polozenie_x == 2 && polozenie_y == 1)||(polozenie_x==1 && polozenie_y == 2)
				||(polozenie_x==szerokoscSwiata-3 && polozenie_y==2)||(polozenie_x == szerokoscSwiata - 2 && polozenie_y == wysokoscSwiata - 3)
				||(polozenie_x == 1 && polozenie_y == wysokoscSwiata - 3)||(polozenie_x == 3 && polozenie_y == wysokoscSwiata - 2)
				||polozenie_x == szerokoscSwiata - 2 && polozenie_y == wysokoscSwiata -3)
				|| polozenie_x == szerokoscSwiata - 3 && polozenie_y == wysokoscSwiata -2))
		{
			random2 = random.nextInt(3);
			switch (random2)
			{
			case 0:
				if (polozenie_y == 0 ||(zasieg==2 && (polozenie_y==1 || polozenie_y == 2)))
					polozenie_y+=zasieg; 
				else 
					polozenie_y-= zasieg;
				break;
			case 1:
				if (polozenie_x == 0 ||(zasieg == 2 && (polozenie_x == 1 || polozenie_x == 2)))
					polozenie_x+= zasieg;
				else polozenie_x-= zasieg;
				break;
			case 2:
				if (polozenie_x == 0 && polozenie_y == 0 || (zasieg == 2 && (polozenie_x == 1 && polozenie_y == 1
					|| (polozenie_x == 2 && polozenie_y == 1) || (polozenie_x == 1 && polozenie_y == 2))))
				{
					polozenie_x+= zasieg;
					polozenie_y+= zasieg;
				}
				else if (polozenie_x == 0 && polozenie_y == wysokoscSwiata - 1 
					|| (zasieg == 2 && (polozenie_x == 1 && polozenie_y == wysokoscSwiata - zasieg
						||(polozenie_x == 1 && polozenie_y == wysokoscSwiata - 3) || (polozenie_x == 3 && polozenie_y == wysokoscSwiata - 2))))
				{
					polozenie_x+= zasieg;
					polozenie_y-= zasieg;
				}
				else if (polozenie_x == szerokoscSwiata - 1 && polozenie_y == 0 
					|| (zasieg == 2 && (polozenie_x == szerokoscSwiata - zasieg && polozenie_y == 1)
						||(polozenie_x == szerokoscSwiata - 3 && polozenie_y == 2) || (polozenie_x == szerokoscSwiata - 2 && polozenie_y == wysokoscSwiata - 3)))
				{
					polozenie_x-= zasieg;
					polozenie_y+= zasieg;
				}
				else
				{
					polozenie_x-= zasieg;
					polozenie_y-= zasieg;
				}
				break;
			}
		}
		else if (polozenie_x == 0 ||(zasieg==2 && polozenie_x==1)|| polozenie_x == szerokoscSwiata - zasieg || (zasieg == 2 && polozenie_x == szerokoscSwiata - 1) 
			|| polozenie_y == 0 || (zasieg == 2 && polozenie_y == 1) || polozenie_y == wysokoscSwiata - zasieg || (zasieg == 2 && polozenie_y == wysokoscSwiata - 1))
		{
			random2 = random.nextInt(5);
			if (polozenie_x == 0 || (zasieg == 2 && polozenie_x == 1))
			{
				if (random2 == 0) polozenie_y-= zasieg;
				else if (random2 == 1)
				{
					polozenie_y-= zasieg;
					polozenie_x+= zasieg;
				}
				else if (random2 == 2) polozenie_x+= zasieg;
				else if (random2 == 3)
				{
					polozenie_y+= zasieg;
					polozenie_x+= zasieg;
				}
				else polozenie_y+= zasieg;
			}
			else if (polozenie_x == szerokoscSwiata - zasieg || (zasieg == 2 && polozenie_x == szerokoscSwiata - 1))
			{
				if (random2 == 0) polozenie_y-= zasieg;
				else if (random2 == 1)
				{
					polozenie_y-= zasieg;
					polozenie_x-= zasieg;
				}
				else if (random2 == 2)polozenie_x-= zasieg;
				else if (random2 == 3)
				{
					polozenie_x-= zasieg;
					polozenie_y+= zasieg;
				}
				else polozenie_y+= zasieg;
			}
			else if (polozenie_y == 0 || (zasieg == 2 && polozenie_y == 1))
			{
				if (random2 == 0)polozenie_x-=zasieg;
				else if (random2 == 1)
				{
					polozenie_x-= zasieg;
					polozenie_y+= zasieg;
				}
				else if (random2 == 2) polozenie_y+= zasieg;
				else if (random2 == 3)
				{
					polozenie_x+= zasieg;
					polozenie_y+= zasieg;
				}
				else polozenie_x+= zasieg;
			}
			else
			{
				if (random2 == 0)polozenie_x-= zasieg;
				else if (random2 == 1)
				{
					polozenie_x-= zasieg;
					polozenie_y-= zasieg;
				}
				else if (random2 == 2)polozenie_y-= zasieg;
				else if (random2 == 3)
				{
					polozenie_x+= zasieg;
					polozenie_y-= zasieg;
				}
				else polozenie_x+= zasieg;
			}
		}
		else
		{
			random2 = random.nextInt(8);
			if (random2 == 0)polozenie_y-= zasieg;
			else if (random2 == 1)
			{
				polozenie_x+= zasieg;
				polozenie_y-= zasieg;
			}
			else if (random2 == 2)polozenie_x++;
			else if (random2 == 3)
			{
				polozenie_x+= zasieg;
				polozenie_y+= zasieg;
			}
			else if (random2 == 4)polozenie_y++;
			else if (random2 == 5)
			{
				polozenie_x-= zasieg;
				polozenie_y+= zasieg;
			}
			else if (random2 == 6)polozenie_x-= zasieg;
			else
			{
				polozenie_x-= zasieg;
				polozenie_y-= zasieg;
			}
		}
		if (swiat.getPlansza(polozenie_y, polozenie_x)!=' ')
		{
			
			Organizm tmp2 = swiat.getPierwszyOrganizm();
			while (tmp2 != null)
			{
				if (tmp2.getPolozenie_x() == polozenie_x && tmp2.getPolozenie_y() == polozenie_y && tmp2!=this)
				{
					if (this.czyDobryWech(tmp2)==true)
					{
						int wysokosc = swiat.getWysokosc();
						int szerokosc = swiat.getSzerokosc();
						//Nie ma dok¹d iœæ - stoi w miejscu
						if ((polozenie_y_before + 1 < wysokosc && swiat.getPlansza(polozenie_y_before + 1, polozenie_x_before) != ' ')
							&& (polozenie_y_before - 1 >= 0 && swiat.getPlansza(polozenie_y_before - 1, polozenie_x_before) != ' ')
							&& (polozenie_x_before - 1 >= 0 && swiat.getPlansza(polozenie_y_before, polozenie_x_before - 1) != ' ')
							&& (polozenie_x_before + 1 < szerokosc && swiat.getPlansza(polozenie_y_before, polozenie_x_before + 1) != ' ')
							&& (polozenie_y_before - 1 >= 0 && polozenie_x_before - 1 >= 0 && swiat.getPlansza(polozenie_y_before - 1, polozenie_x_before - 1) != ' ')
							&& (polozenie_y_before + 1 < wysokosc && polozenie_x_before + 1 < szerokosc && swiat.getPlansza(polozenie_y_before + 1, polozenie_x_before + 1) != ' ')
							&& (polozenie_y_before - 1 >= 0 && polozenie_x_before + 1 < szerokosc && swiat.getPlansza(polozenie_y_before - 1, polozenie_x_before + 1) != ' ')
							&& (polozenie_y_before + 1 < wysokosc && polozenie_x_before - 1 >= 0 && swiat.getPlansza(polozenie_y_before + 1, polozenie_x_before - 1) != ' '))
						{
							this.setPolozenie_x(polozenie_x_before);
							this.setPolozenie_y(polozenie_y_before);
							swiat.dodajDoPlanszy(polozenie_y_before, polozenie_x_before, symbol);
							break;
						}
						else 
						{
							this.setPolozenie_x(polozenie_x_before);
							this.setPolozenie_y(polozenie_y_before);
							swiat.dodajDoPlanszy(polozenie_y_before, polozenie_x_before, symbol);
						}
					}
					else 
					{
						kolizja(tmp2, polozenie_y_before, polozenie_x_before);
						break;
					}
				}
				tmp2 = tmp2.getNext();
			}
		}
		else { swiat.dodajDoPlanszy(polozenie_y, polozenie_x, symbol); }
	}
	@Override 
	public void akcja(){akcja(1);}
	
	@Override 
	public void kolizja(Organizm  broniacy, int polozenie_y_before, int polozenie_x_before){
		
		if (this.getSymbol() == broniacy.getSymbol())
		{
			this.setPolozenie_x(polozenie_x_before);
			this.setPolozenie_y(polozenie_y_before);
			swiat.dodajDoPlanszy(polozenie_y, polozenie_x, symbol);
			int polozenie_x_dziecko, polozenie_y_dziecko;

			int broniacy_x = broniacy.getPolozenie_x();
			int broniacy_y = broniacy.getPolozenie_y();
			int szerokosc = swiat.getSzerokosc();
			int wysokosc = swiat.getWysokosc();
			int [] mozliwe_kierunki = new int[16];
			for(int i=0;i<16;i++)mozliwe_kierunki[i]=0;
			//mozliwe kierunki zespa³nowania dziecka wzglêdem broni¹cego
			if (broniacy_y + 1 < wysokosc && swiat.getPlansza(broniacy_y + 1, broniacy_x) == ' ')mozliwe_kierunki[0] = 1;
			if (broniacy_y - 1 >= 0 && swiat.getPlansza(broniacy_y - 1, broniacy_x) == ' ')mozliwe_kierunki[1] = 1;
			if (broniacy_x - 1 >= 0 && swiat.getPlansza(broniacy_y, broniacy_x - 1) == ' ')mozliwe_kierunki[2] = 1;
			if (broniacy_x + 1 < szerokosc && swiat.getPlansza(broniacy_y, broniacy_x + 1) == ' ')mozliwe_kierunki[3] = 1;
			if (broniacy_y - 1 >= 0 && broniacy_x - 1 >= 0 && swiat.getPlansza(broniacy_y - 1, broniacy_x - 1) == ' ')mozliwe_kierunki[4] = 1;
			if (broniacy_y + 1 < wysokosc && broniacy_x + 1 < szerokosc && swiat.getPlansza(broniacy_y + 1, broniacy_x + 1) == ' ')mozliwe_kierunki[5] = 1;
			if (broniacy_y - 1 >= 0 && broniacy_x + 1 < szerokosc && swiat.getPlansza(broniacy_y - 1, broniacy_x + 1) == ' ')mozliwe_kierunki[6] = 1;
			if (broniacy_y + 1 < wysokosc && broniacy_x - 1 >= 0 && swiat.getPlansza(broniacy_y + 1, broniacy_x - 1) == ' ')mozliwe_kierunki[7] = 1;

			int atakujacy_x = this.getPolozenie_x();
			int atakujacy_y = this.getPolozenie_y();
			//mozliwe kierunki zespa³nowania dziecka wzglêdem atakujacego
			if (atakujacy_y + 1 < wysokosc && swiat.getPlansza(atakujacy_y + 1, atakujacy_x) == ' ')mozliwe_kierunki[8] = 1;
			if (atakujacy_y - 1 >= 0 && swiat.getPlansza(atakujacy_y - 1, atakujacy_x) == ' ')mozliwe_kierunki[9] = 1;
			if (atakujacy_x - 1 >= 0 && swiat.getPlansza(atakujacy_y, atakujacy_x - 1) == ' ')mozliwe_kierunki[10] = 1;
			if (atakujacy_x + 1 < szerokosc && swiat.getPlansza(atakujacy_y, atakujacy_x + 1) == ' ')mozliwe_kierunki[11] = 1;
			if (atakujacy_y - 1 >= 0 && atakujacy_x - 1 >= 0 && swiat.getPlansza(broniacy_y - 1, atakujacy_x - 1) == ' ')mozliwe_kierunki[12] = 1;
			if (atakujacy_y + 1 < wysokosc && atakujacy_x + 1 < szerokosc && swiat.getPlansza(broniacy_y + 1, atakujacy_x + 1) == ' ')mozliwe_kierunki[13] = 1;
			if (atakujacy_y - 1 >= 0 && atakujacy_x + 1 < szerokosc && swiat.getPlansza(broniacy_y - 1, atakujacy_x + 1) == ' ')mozliwe_kierunki[14] = 1;
			if (atakujacy_y + 1 < wysokosc && atakujacy_x - 1 >= 0 && swiat.getPlansza(broniacy_y + 1, atakujacy_x - 1) == ' ')mozliwe_kierunki[15] = 1;

			int ile = 0;
			for (int i = 0; i < 16; i++)
			{
				if (mozliwe_kierunki[i] == 1)ile++;
			}

			if (swiat.getIloscOrganizmow() >= swiat.getSzerokosc()*swiat.getWysokosc()
				|| (ile == 0))
			{
				//swiat.dodajWiadomosc("Nieudana proba rozmnozenia ");
				//swiat.dodajWiadomosc(this.getNazwa());
				//swiat.dodajWiadomosc(" ");
				return;
			}
			else
			{
				
				int random2 = random.nextInt(16);
				while (mozliwe_kierunki[random2] != 1)
				{
					random2 = random.nextInt(16);
				}


				if (random2 == 0)
				{
					polozenie_y_dziecko=broniacy_y + 1;
					polozenie_x_dziecko = broniacy_x;
				}
				else if (random2 == 1)
				{
					polozenie_y_dziecko = broniacy_y - 1;
					polozenie_x_dziecko = broniacy_x;
				}
				else if (random2 == 2)
				{
					polozenie_y_dziecko = broniacy_y;
					polozenie_x_dziecko = broniacy_x - 1;
				}
				else if (random2 == 3)
				{
					polozenie_y_dziecko = broniacy_y;
					polozenie_x_dziecko = broniacy_x + 1;
				}
				else if (random2 == 4)
				{
					polozenie_y_dziecko = broniacy_y - 1;
					polozenie_x_dziecko = broniacy_x - 1;
				}
				else if (random2 == 5)
				{
					polozenie_y_dziecko = (broniacy_y + 1);
					polozenie_x_dziecko = (broniacy_x + 1);
				}
				else if (random2 == 6)
				{
					polozenie_y_dziecko = (broniacy_y - 1);
					polozenie_x_dziecko = (broniacy_x + 1);
				}
				else if(random2 == 7)
				{
					polozenie_y_dziecko = (broniacy_y + 1);
					polozenie_x_dziecko = (broniacy_x - 1);
				}
				else if (random2 == 8)
				{
					polozenie_y_dziecko = atakujacy_y + 1;
					polozenie_x_dziecko = atakujacy_x;
				}
				else if (random2 == 9)
				{
					polozenie_y_dziecko = atakujacy_y - 1;
					polozenie_x_dziecko = atakujacy_x;
				}
				else if (random2 == 10)
				{
					polozenie_y_dziecko = atakujacy_y;
					polozenie_x_dziecko = atakujacy_x - 1;
				}
				else if (random2 == 11)
				{
					polozenie_y_dziecko = atakujacy_y;
					polozenie_x_dziecko = atakujacy_x + 1;
				}
				else if (random2 == 12)
				{
					polozenie_y_dziecko = atakujacy_y - 1;
					polozenie_x_dziecko = atakujacy_x - 1;
				}
				else if (random2 == 13)
				{
					polozenie_y_dziecko = (atakujacy_y + 1);
					polozenie_x_dziecko = (atakujacy_x + 1);
				}
				else if (random2 == 14)
				{
					polozenie_y_dziecko = (atakujacy_y - 1);
					polozenie_x_dziecko = (atakujacy_x + 1);
				}
				else 
				{
					polozenie_y_dziecko = (atakujacy_y + 1);
					polozenie_x_dziecko = (atakujacy_x - 1);
				}

			}
			Organizm tmp = null;
			switch (this.getSymbol())
			{
			case 'A': tmp = new Antylopa(swiat); break;
			case 'C': tmp = new Cyber_owca(swiat); break;
			case 'L': tmp = new Lis(swiat); break;
			case 'O': tmp = new Owca(swiat); break;
			case 'W': tmp = new Wilk(swiat); break;
			case 'Z': tmp = new Zolw(swiat); break;
			default:break;
			}
			swiat.dodajDoPlanszy(tmp.getPolozenie_y(), tmp.getPolozenie_x(), ' ');
			tmp.setPolozenie_x(polozenie_x_dziecko);
			tmp.setPolozenie_y(polozenie_y_dziecko);
			tmp.setDelay(true);
			swiat.dodajDoPlanszy(tmp.getPolozenie_y(), tmp.getPolozenie_x(), tmp.getSymbol());
			swiat.dodajWiadomosc(this.getNazwa());
			swiat.dodajWiadomosc(" wlasnie sie rozmnozyl ");
			
			
		}
		else if(broniacy.czyRoslinaTrujaca()==true)
		{
			if(broniacy.czyZabijZjadajacego(this)==true)
			{
				
				swiat.dodajWiadomosc(broniacy.getNazwa());
				swiat.dodajWiadomosc(" zabil napastnika ");
				swiat.dodajWiadomosc(this.getNazwa());
				swiat.dodajDoPlanszy(polozenie_y, polozenie_x, ' ');
				this.kill();
				broniacy.kill();
			}
			else
			{
				
				swiat.dodajWiadomosc(this.getNazwa());
				swiat.dodajWiadomosc(" zabil ");
				swiat.dodajWiadomosc(broniacy.getNazwa());
				broniacy.kill();
				swiat.dodajDoPlanszy(polozenie_y, polozenie_x, symbol);
			}
		}
		else
		{
			if (this.getSila() >= broniacy.getSila())
			{
				if(broniacy.czyOdbijAtak(this)==true)
				{
					this.setPolozenie_x(polozenie_x_before);
					this.setPolozenie_y(polozenie_y_before);
					swiat.dodajDoPlanszy(polozenie_y_before, polozenie_x_before, this.getSymbol());
					swiat.dodajWiadomosc("Zolw zablokowal atak zwierzecia ");
					swiat.dodajWiadomosc(this.getNazwa());
					
				}
				else if(broniacy.czyUcieka()==true)
				{
					int random2 = random.nextInt(2);
					if (random2 == 1)
					{
						
						swiat.dodajWiadomosc(this.getNazwa());
						swiat.dodajWiadomosc(" zabil ");
						swiat.dodajWiadomosc(broniacy.getNazwa());
						broniacy.kill();
						swiat.dodajDoPlanszy(polozenie_y, polozenie_x, symbol);
					}
					else
					{
						int broniacy_x = broniacy.getPolozenie_x();
						int broniacy_y = broniacy.getPolozenie_y();
						int szerokosc = swiat.getSzerokosc();
						int wysokosc = swiat.getWysokosc();
						int mozliwe_kierunki[] = new int [8];
						for(int i=0;i<8;i++)mozliwe_kierunki[i]=0;
						if (broniacy_y + 1 < wysokosc && swiat.getPlansza(broniacy_y + 1, broniacy_x) == ' ')mozliwe_kierunki[0] = 1;
						if (broniacy_y - 1 >= 0 && swiat.getPlansza(broniacy_y - 1, broniacy_x) == ' ')mozliwe_kierunki[1] = 1;
						if (broniacy_x - 1 >= 0 && swiat.getPlansza(broniacy_y, broniacy_x - 1) == ' ')mozliwe_kierunki[2] = 1;
						if (broniacy_x + 1 < szerokosc && swiat.getPlansza(broniacy_y, broniacy_x + 1) == ' ')mozliwe_kierunki[3] = 1;
						if (broniacy_y - 1 >= 0 && broniacy_x - 1 >= 0 && swiat.getPlansza(broniacy_y - 1, broniacy_x - 1) == ' ')mozliwe_kierunki[4] = 1;
						if (broniacy_y + 1 < wysokosc && broniacy_x + 1 < szerokosc && swiat.getPlansza(broniacy_y + 1, broniacy_x + 1) == ' ')mozliwe_kierunki[5] = 1;
						if (broniacy_y - 1 >= 0 && broniacy_x + 1 < szerokosc && swiat.getPlansza(broniacy_y - 1, broniacy_x + 1) == ' ')mozliwe_kierunki[6] = 1;
						if (broniacy_y + 1 < wysokosc && broniacy_x - 1 >= 0 && swiat.getPlansza(broniacy_y + 1, broniacy_x - 1) == ' ')mozliwe_kierunki[7] = 1;
	
						int ile = 0;
						for (int i = 0; i < 8; i++)
						{
							if (mozliwe_kierunki[i] == 1)ile++;
						}
						if (ile == 0)
						{

							swiat.dodajWiadomosc(this.getNazwa());
							swiat.dodajWiadomosc(" zabil ");
							swiat.dodajWiadomosc(broniacy.getNazwa());
							broniacy.kill();
							swiat.dodajDoPlanszy(polozenie_y, polozenie_x, symbol);
						}
						else
						{
							swiat.dodajWiadomosc(this.getNazwa());
							swiat.dodajWiadomosc(" probwal zaatakowac Antylope. Ta jednak uciekla ");
	
							int random3 = random.nextInt(8);
							while (mozliwe_kierunki[random3] != 1)
							{
								random3 = random.nextInt(8);
							}
							if (random3 == 0)
							{
								broniacy.setPolozenie_y(broniacy_y + 1);
								swiat.dodajDoPlanszy(broniacy_y + 1, broniacy_x, broniacy.getSymbol());
							}
							else if (random3 == 1)
							{
								broniacy.setPolozenie_y(broniacy_y - 1);
								swiat.dodajDoPlanszy(broniacy_y - 1, broniacy_x, broniacy.getSymbol());
							}
							else if (random3 == 2)
							{
								broniacy.setPolozenie_x(broniacy_x - 1);
								swiat.dodajDoPlanszy(broniacy_y, broniacy_x - 1, broniacy.getSymbol());
							}
							else if (random3 == 3)
							{
								broniacy.setPolozenie_x(broniacy_x + 1);
								swiat.dodajDoPlanszy(broniacy_y, broniacy_x + 1, broniacy.getSymbol());
							}
							else if (random3 == 4)
							{
								broniacy.setPolozenie_y(broniacy_y - 1);
								broniacy.setPolozenie_x(broniacy_x - 1);
								swiat.dodajDoPlanszy(broniacy_y - 1, broniacy_x - 1, broniacy.getSymbol());
							}
							else if (random3 == 5)
							{
								broniacy.setPolozenie_y(broniacy_y + 1);
								broniacy.setPolozenie_x(broniacy_x + 1);
								swiat.dodajDoPlanszy(broniacy_y + 1, broniacy_x + 1, broniacy.getSymbol());
							}
							else if (random3 == 6)
							{
								broniacy.setPolozenie_y(broniacy_y - 1);
								broniacy.setPolozenie_x(broniacy_x + 1);
								swiat.dodajDoPlanszy(broniacy_y - 1, broniacy_x + 1, broniacy.getSymbol());
							}
							else
							{
								broniacy.setPolozenie_y(broniacy_y + 1);
								broniacy.setPolozenie_x(broniacy_x - 1);
								swiat.dodajDoPlanszy(broniacy_y + 1, broniacy_x - 1, broniacy.getSymbol());
							}
							swiat.dodajDoPlanszy(polozenie_y, polozenie_x, symbol);
						}
					}
				}
				else
				{
					if (broniacy.getSymbol() == 'G')sila += 3;
					
					swiat.dodajWiadomosc(this.getNazwa());
					swiat.dodajWiadomosc(" zabil ");
					swiat.dodajWiadomosc(broniacy.getNazwa());
					broniacy.kill();
					swiat.dodajDoPlanszy(polozenie_y, polozenie_x, symbol);
				}
			}
			else
			{

				swiat.dodajWiadomosc(broniacy.getNazwa());
				swiat.dodajWiadomosc(" zabil napastnika ");
				swiat.dodajWiadomosc(this.getNazwa());
				this.kill();
				swiat.dodajDoPlanszy(polozenie_y, polozenie_x, broniacy.getSymbol());
			}
		}
		swiat.dodajWiadomosc("\n");
	}
	
}
