package model.servis;

import model.automobili.Automobil;
import model.korisnici.Serviser;

public class ServisnaKnjizica {
	
	private Automobil automobil;
	private Serviser serviser;
	private Servis servis;
	
	
	public ServisnaKnjizica() {
		this.automobil = new Automobil();
		this.serviser = new Serviser();
		this.servis = new Servis();
	}


	public ServisnaKnjizica(Automobil automobil, Serviser serviser, Servis servis) {
		super();
		this.automobil = automobil;
		this.serviser = serviser;
		this.servis = servis;
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


	public Servis getServis() {
		return servis;
	}


	public void setServis(Servis servis) {
		this.servis = servis;
	}


	@Override
	public String toString() {
		return "ServisnaKnjizica [automobil=" + automobil + ", serviser=" + serviser + ", servis=" + servis + "]";
	}
	
	
	

}
