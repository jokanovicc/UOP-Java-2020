package model.korisnici;

public class Serviser extends Korisnik {
	
	private Specijalizacija specijalizacija;
	protected double plata;
	
	
	
	public Serviser() {
		this.specijalizacija = Specijalizacija.AUTOELEKTRICAR;
		this.plata = 0;
		
	}
	
	

	public Serviser(String ime, String prezime, int jmbg, String pol, String brojTelefona, String username,
			String lozinka, Specijalizacija specijalizacija, double plata) {
		super(ime, prezime, jmbg, pol, brojTelefona, username, lozinka);
		this.specijalizacija = specijalizacija;
		this.plata = plata;
	}





	public Specijalizacija getSpecijalizacija() {
		return specijalizacija;
	}



	public void setSpecijalizacija(Specijalizacija specijalizacija) {
		this.specijalizacija = specijalizacija;
	}



	public double getPlata() {
		return plata;
	}



	public void setPlata(double plata) {
		this.plata = plata;
	}





	@Override
	public String toString() {
		return "Serviser [specijalizacija=" + specijalizacija + ", plata=" + plata + ", ime=" + ime + ", prezime="
				+ prezime + ", jmbg=" + jmbg + ", pol=" + pol + ", brojTelefona=" + brojTelefona + ", username="
				+ username + ", lozinka=" + lozinka + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
