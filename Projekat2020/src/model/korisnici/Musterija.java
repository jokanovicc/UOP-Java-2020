package model.korisnici;

import java.util.Arrays;

import model.automobili.Automobil;

public class Musterija extends Korisnik {
	
	private int bodovi;
	
	
	public Musterija() {
		super();
		this.bodovi = 0;
		
	}


	public Musterija(String ime, String prezime, int jmbg, String pol, String brojTelefona, String username,
			String lozinka, int bodovi) {
		super(ime, prezime, jmbg, pol, brojTelefona, username, lozinka);
		this.bodovi = bodovi;;
	}


	public int getBodovi() {
		return bodovi;
	}


	public void setBodovi(int bodovi) {
		this.bodovi = bodovi;
	}


	@Override
	public String toString() {
		return "Musterija [bodovi=" + bodovi + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol="
				+ pol + ", brojTelefona=" + brojTelefona + ", username=" + username + ", lozinka=" + lozinka + "]";
	}





	
	
	
	

	
	


	
	


	
	



	
	
	
	

}
