
public class Lis extends Zwierzeta{
	
	public Lis(Swiat s1)
	{
		obrazek = "lis.png";
		nazwa = "Lis";
		symbol = 'L';
		swiat = s1;
		sila = 3;
		inicjatywa = 7;
		polozenie_x = random.nextInt( swiat.getSzerokosc());
		polozenie_y = random.nextInt(swiat.getWysokosc());
		swiat.dodajDoPlanszy(polozenie_y, polozenie_x, 'L');
		swiat.dodajOrganizm(this);
		swiat.incrementIloscOrganizmow();
	}
	@Override
	public boolean czyDobryWech(Organizm broniacy)
	{
		if(broniacy.getSila()>this.getSila())
		return true;
		else return false;
	}

}
