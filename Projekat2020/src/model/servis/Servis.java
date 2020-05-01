package model.servis;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import model.automobili.Automobil;
import model.enumeracije.Statusi;
import model.korisnici.Serviser;

public class Servis {
	private Automobil automobil;
	private Serviser serviser;
	private Date termin;
	private String opis;
	private ArrayList<Deo> deo;
	private Statusi status;
	
	
	
	public Servis() {
		this.automobil = new Automobil();
		this.serviser = new Serviser();
		this.termin = null;
		this.opis = "";
		this.deo = new ArrayList<Deo>();
		this.status = Statusi.SLOBODAN;	
	}

	public Servis(Automobil automobil, Serviser serviser, Date termin, String opis, ArrayList<Deo> deo,
			Statusi status) {
		super();
		this.automobil = automobil;
		this.serviser = serviser;
		this.termin = termin;
		this.opis = opis;
		this.deo = deo;
		this.status = status;
	}

	public Automobil getAutomobil() {
		return automobil;
	}

	public void setAutomobil(Automobil automobil) {
		this.automobil = automobil;
	}

	public Serviser getServiser() {
		return serviser;
	}

	public void setServiser(Serviser serviser) {
		this.serviser = serviser;
	}

	public Date getTermin() {
		return termin;
	}

	public void setTermin(Date termin) {
		this.termin = termin;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public ArrayList<Deo> getDeo() {
		return deo;
	}

	public void setDeo(ArrayList<Deo> deo) {
		this.deo = deo;
	}

	public Statusi getStatus() {
		return status;
	}

	public void setStatus(Statusi status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Servis [automobil=" + automobil + ", serviser=" + serviser + ", termin=" + termin + ", opis=" + opis
				+ ", deo=" + deo + ", status=" + status + "]";
	}
	
	


	
	

	

	
		
		
	}
	
 
