package model.korisnici;

import model.enumeracije.Pol;

public abstract class Korisnik {
	
	protected String ime;
	protected String prezime;
	protected String jmbg;
	protected Pol pol;
	protected String brojTelefona;
	protected String adresa;
	protected String username;
	protected String lozinka;
	protected String IDOznaka;
	protected boolean obrisan;
	
	public Korisnik() {
		this.ime = "";
		this.prezime = "";
		this.jmbg = "";
		this.pol = Pol.Muski;
		this.adresa = "";
		this.brojTelefona = "";
		this.lozinka = "";
		this.IDOznaka = "";
		this.obrisan = false;
		
	}
	
	




	public Korisnik(String ime, String prezime, String jmbg, Pol pol, String brojTelefona, String adresa,
			String username, String lozinka, String iDOznaka, boolean obrisan) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.pol = pol;
		this.brojTelefona = brojTelefona;
		this.adresa = adresa;
		this.username = username;
		this.lozinka = lozinka;
		IDOznaka = iDOznaka;
		this.obrisan = obrisan;
	}






	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public String getPrezime() {
		return prezime;
	}


	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}


	public String getJmbg() {
		return jmbg;
	}


	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}


	public Pol getPol() {
		return pol;
	}


	public void setPol(Pol pol) {
		this.pol = pol;
	}


	public String getBrojTelefona() {
		return brojTelefona;
	}


	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}


	public String getAdresa() {
		return adresa;
	}


	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getLozinka() {
		return lozinka;
	}


	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}



	public String getIDOznaka() {
		return IDOznaka;
	}



	public void setIDOznaka(String iDOznaka) {
		IDOznaka = iDOznaka;
	}






	public boolean isObrisan() {
		return obrisan;
	}


	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}
	
	@Override
	public String toString() {
		return "Korisnik [ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol=" + pol + ", brojTelefona="
				+ brojTelefona + ", adresa=" + adresa + ", username=" + username + ", lozinka=" + lozinka
				+ ", IDOznaka=" + IDOznaka + "]";
	}


	
	
	

	
	





	

	
	

}
