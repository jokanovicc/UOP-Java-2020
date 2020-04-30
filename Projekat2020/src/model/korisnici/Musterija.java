package model.korisnici;


public class Musterija extends Korisnik {
	
	private int bodovi;
	
	
	public Musterija() {
		this.bodovi = 0;
	}


	public Musterija(String ime, String prezime, int jmbg, String pol, String brojTelefona, String username,
			String lozinka, int bodovi) {
		super(ime, prezime, jmbg, pol, brojTelefona, username, lozinka);
		this.bodovi = bodovi;
	}
	
	


	
	



	
	
	
	

}
