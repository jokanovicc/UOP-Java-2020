package model.korisnici;

import java.util.Arrays;

import model.automobili.Automobil;
import model.enumeracije.Pol;

public class Musterija extends Korisnik {
	private byte brojSakupljenihBodova;
	
	
	
	public Musterija() {
		super();
		this.brojSakupljenihBodova = 0;
	}



	public Musterija(String ime, String prezime, String jmbg, Pol pol, String brojTelefona, String username,
			String lozinka, byte brojSakupljenihBodova) {
		super(ime, prezime, jmbg, pol, brojTelefona, username, lozinka);
		this.brojSakupljenihBodova = brojSakupljenihBodova;
	}



	public byte getBrojSakupljenihBodova() {
		return brojSakupljenihBodova;
	}



	public void setBrojSakupljenihBodova(byte brojSakupljenihBodova) {
		this.brojSakupljenihBodova = brojSakupljenihBodova;
	}



	@Override
	public String toString() {
		return "Musterija [brojSakupljenihBodova=" + brojSakupljenihBodova + ", ime=" + ime + ", prezime=" + prezime
				+ ", jmbg=" + jmbg + ", pol=" + pol + ", brojTelefona=" + brojTelefona + ", username=" + username
				+ ", lozinka=" + lozinka + "]";
	}
	
	
	
	





	
	
	
	

	
	


	
	


	
	



	
	
	
	

}
