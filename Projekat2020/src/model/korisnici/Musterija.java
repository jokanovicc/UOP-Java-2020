package model.korisnici;

import java.util.Arrays;

import model.automobili.Automobil;
import model.enumeracije.Pol;

public class Musterija extends Korisnik {
	private int brojSakupljenihBodova;
	
	
	
	public Musterija() {
		super();
		this.brojSakupljenihBodova = 0;
	}



	public Musterija(String ime, String prezime, String jmbg, Pol pol, String brojTelefona, String username,
			String lozinka, int brojSakupljenihBodova) {
		super(ime, prezime, jmbg, pol, brojTelefona, username, lozinka);
		this.brojSakupljenihBodova = brojSakupljenihBodova;
	}



	public int getBrojSakupljenihBodova() {
		return brojSakupljenihBodova;
	}



	public void setBrojSakupljenihBodova(int brojSakupljenihBodova) {
		this.brojSakupljenihBodova = brojSakupljenihBodova;
	}



	@Override
	public String toString() {
		return "Musterija [brojSakupljenihBodova=" + brojSakupljenihBodova + ", ime=" + ime + ", prezime=" + prezime
				+ ", jmbg=" + jmbg + ", pol=" + pol + ", brojTelefona=" + brojTelefona + ", username=" + username
				+ ", lozinka=" + lozinka + "]";
	}
	
	



	
	


	
	
	





	
	
	
	

	
	


	
	


	
	



	
	
	
	

}
