package model.korisnici;

public abstract class Korisnik {
	
	protected String ime;
	protected String prezime;
	protected int jmbg;
	protected String pol;
	protected String brojTelefona;
	protected String username;
	protected String lozinka;
	
	
	public Korisnik() {
		this.ime = "";
		this.prezime = "";
		this.jmbg = 0;
		this.pol = "";
		
		
	}


	public Korisnik(String ime, String prezime, int jmbg, String pol, String brojTelefona, String username,
			String lozinka) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.pol = pol;
		this.brojTelefona = brojTelefona;
		this.username = username;
		this.lozinka = lozinka;
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


	public int getJmbg() {
		return jmbg;
	}


	public void setJmbg(int jmbg) {
		this.jmbg = jmbg;
	}


	public String getPol() {
		return pol;
	}


	public void setPol(String pol) {
		this.pol = pol;
	}


	public String getBrojTelefona() {
		return brojTelefona;
	}


	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
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


	@Override
	public String toString() {
		return "Korisnik [ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol=" + pol + ", brojTelefona="
				+ brojTelefona + ", username=" + username + ", lozinka=" + lozinka + "]";
	}
	
	

}
