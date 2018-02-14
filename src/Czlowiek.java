

public class Czlowiek extends Zwierzeta {

	
	//0 wy³¹czona
	//1 w³¹czona 100%
	//2 w³¹czona 50%
	private int moc_specjalna;
	//Czas 5ciu tur po ktorych mozna aktywowac umiejetnosc specjalna
	private boolean cooldown;
	//Pomocnicze zmienne do okreslania ile czasu pozostalo do konca umiejetnosci lub cooldownu
	private int liczba_tur_mocy;
	private int liczba_tur_cooldown;
	
	public Czlowiek(Swiat s1)
	{
		obrazek = "czlowiek.png";
		liczba_tur_cooldown = 0;
		liczba_tur_mocy = 0;
		cooldown = false;
		moc_specjalna = 0;
		nazwa = "Czlowiek";
		symbol = 'Y';
		sila = 5;
		inicjatywa = 4;
		swiat = s1;
		polozenie_x = random.nextInt(swiat.getSzerokosc());
		polozenie_y = random.nextInt( swiat.getWysokosc());
		swiat.dodajDoPlanszy(polozenie_y, polozenie_x, 'Y');
		swiat.dodajOrganizm(this);
		swiat.incrementIloscOrganizmow();
		
	}
	
	@Override
	public void kill()
	{
		super.kill();
		liczba_tur_mocy = 0;
		moc_specjalna = 0;
		cooldown = false;
		liczba_tur_cooldown = 0;
	}
	
	@Override
	public void akcja(int zasieg)
	{
		boolean brak_mocy = false;
		Czlowiek_Ruch kierunek = swiat.getRuch();
		//System.out.println(kierunek);
		if (moc_specjalna == 1)liczba_tur_mocy++;
		if (liczba_tur_mocy == 4 || liczba_tur_mocy == 5) { moc_specjalna = 2; liczba_tur_mocy++; }
		if (liczba_tur_mocy == 6)
		{
			cooldown = true;
			liczba_tur_mocy = 0;
			moc_specjalna = 0;
		}
		if (cooldown)liczba_tur_cooldown++;
		if (liczba_tur_cooldown == 6)cooldown = false;
		//Pojawienie sie tylko jednego komunikatu o niepowodzeniu przy aktywowaniu mocy
		
		
		if (moc_specjalna == 1)zasieg = 2;
		else if (moc_specjalna == 2)
		{
			int random1 = random.nextInt(2);
			if (random1== 0)zasieg = 2;
			else zasieg = 1;
		}
		
		if(swiat.qPressed){
			if (!cooldown && moc_specjalna==0)
			{
				moc_specjalna = 1;
				liczba_tur_mocy++;
				brak_mocy = true;
				zasieg = 2;
			}
			else if (!brak_mocy) { brak_mocy = true; }
		}
		int polozenie_x_before = polozenie_x;
		int polozenie_y_before = polozenie_y;
		swiat.dodajDoPlanszy(polozenie_y, polozenie_x, ' ');
		
		
		if(kierunek == Czlowiek_Ruch.GORA &&  polozenie_y - zasieg >= 0)polozenie_y-=zasieg;
		else if(kierunek ==Czlowiek_Ruch.DOL && polozenie_y + zasieg < swiat.getWysokosc())polozenie_y+=zasieg;
		else if(kierunek == Czlowiek_Ruch.LEWO && polozenie_x - zasieg >= 0)polozenie_x-=zasieg;
		else if(kierunek == Czlowiek_Ruch.PRAWO && polozenie_x + zasieg < swiat.getSzerokosc())polozenie_x+=zasieg;
		
		if (swiat.getPlansza(polozenie_y, polozenie_x) != ' ')
		{
			Organizm tmp2 = swiat.getPierwszyOrganizm();
			while (tmp2 != null)
			{
				if (tmp2.getPolozenie_x() == polozenie_x && tmp2.getPolozenie_y() == polozenie_y && tmp2 != this)
				{
					super.kolizja(tmp2, polozenie_y_before, polozenie_x_before);
					break;
				}
				tmp2 = tmp2.getNext();
			}
		}
		else
		{swiat.dodajDoPlanszy(polozenie_y, polozenie_x, 'Y');}
		
	}

	@Override
	public void akcja()
	{
		akcja(1);
	}
	
	public int  getMocSpecjalna() { return moc_specjalna; }
	public boolean getCooldown() { return cooldown; }
	public int getLiczbaTurMocy() { return liczba_tur_mocy; }
	public int getLiczbaTurCooldown() { return liczba_tur_cooldown; }
	public void setMocSpecjalna(int m) { moc_specjalna = m; }
	public void setCooldown(boolean m) { cooldown = m; }
	public void setLiczbaTurMocy(int m) { liczba_tur_mocy = m; }
	public void setLiczbaTurCooldown(int m) { liczba_tur_cooldown = m; }

}
