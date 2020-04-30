package model.korisnici;

import java.util.Arrays;

import model.automobili.Automobil;

public class Musterija extends Korisnik {
	
	private int bodovi;
	private Automobil[] automobil;
	
	
	public Musterija() {
		super();
		this.bodovi = 0;
		this.automobil = new Automobil[3];
		
	}


	public Musterija(String ime, String prezime, int jmbg, String pol, String brojTelefona, String username,
			String lozinka, int bodovi, Automobil[] automobil) {
		super(ime, prezime, jmbg, pol, brojTelefona, username, lozinka);
		this.bodovi = bodovi;
		this.automobil = automobil;
	}


	public int getBodovi() {
		return bodovi;
	}


	public void setBodovi(int bodovi) {
		this.bodovi = bodovi;
	}


	public Automobil[] getAutomobil() {
		return automobil;
	}


	public void setAutomobil(Automobil[] automobil) {
		this.automobil = automobil;
	}


	@Override
	public String toString() {
		return "Musterija [bodovi=" + bodovi + ", automobil=" + Arrays.toString(automobil) + ", ime=" + ime
				+ ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol=" + pol + ", brojTelefona=" + brojTelefona
				+ ", username=" + username + ", lozinka=" + lozinka + "]";
	}
	
	
	
	

	
	


	
	


	
	



	
	
	
	

}
