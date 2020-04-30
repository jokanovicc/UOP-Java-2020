package model.korisnici;

public class Admin extends Korisnik {
	
	private double plata;
	
	public Admin() {
		super();
		plata = 0;
	}

	public Admin(String ime, String prezime, int jmbg, String pol, String brojTelefona, String username, String lozinka,
			double plata) {
		super(ime, prezime, jmbg, pol, brojTelefona, username, lozinka);
		this.plata = plata;
	}


	public double getPlata() {
		return plata;
	}


	public void setPlata(double plata) {
		this.plata = plata;
	}



	@Override
	public String toString() {
		return "Admin [plata=" + plata + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol=" + pol
				+ ", brojTelefona=" + brojTelefona + ", username=" + username + ", lozinka=" + lozinka + "]";
	}
	
	

}
