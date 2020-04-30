package model.korisnici;

import model.enumeracije.Specijalizacija;

public class Serviser extends Korisnik {
	
	private double plata;
	private Specijalizacija specijalizacija;
	
	
	public Serviser() {
		super();
		this.plata = 0;
		this.specijalizacija = Specijalizacija.AUTOELEKTRICAR;
	}


	public Serviser(String ime, String prezime, int jmbg, String pol, String brojTelefona, String username,
			String lozinka, double plata, Specijalizacija specijalizacija) {
		super(ime, prezime, jmbg, pol, brojTelefona, username, lozinka);
		this.plata = plata;
		this.specijalizacija = specijalizacija;
	}


	public double getPlata() {
		return plata;
	}


	public void setPlata(double plata) {
		this.plata = plata;
	}


	public Specijalizacija getSpecijalizacija() {
		return specijalizacija;
	}


	public void setSpecijalizacija(Specijalizacija specijalizacija) {
		this.specijalizacija = specijalizacija;
	}


	@Override
	public String toString() {
		return "Serviser [plata=" + plata + ", specijalizacija=" + specijalizacija + ", ime=" + ime + ", prezime="
				+ prezime + ", jmbg=" + jmbg + ", pol=" + pol + ", brojTelefona=" + brojTelefona + ", username="
				+ username + ", lozinka=" + lozinka + "]";
	}
	
	
	

}

