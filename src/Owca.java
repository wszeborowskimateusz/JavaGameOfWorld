
public class Owca extends Zwierzeta{
	
	public Owca(Swiat s1)
	{
		obrazek = "owca.png";
		nazwa = "Owca";
		symbol = 'O';
		swiat = s1;
		sila = 4;
		inicjatywa = 4;
		polozenie_x = random.nextInt(swiat.getSzerokosc());
		polozenie_y = random.nextInt( swiat.getWysokosc());
		swiat.dodajDoPlanszy(polozenie_y, polozenie_x, 'O');
		swiat.dodajOrganizm(this);
		swiat.incrementIloscOrganizmow();
	}

}
