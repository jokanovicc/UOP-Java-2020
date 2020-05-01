package model.servis;

import java.util.ArrayList;
import java.util.Arrays;

import model.automobili.Automobil;
import model.korisnici.Serviser;

public class ServisnaKnjizica {
	
	private Automobil automobil;
	private Serviser serviser;
	private ArrayList<Servis> servisi;
	
	
	public ServisnaKnjizica() {
		this.automobil = new Automobil();
		this.serviser = new Serviser();
		this.servisi = new ArrayList<Servis>();
	}


	public ServisnaKnjizica(Automobil automobil, Serviser serviser, ArrayList<Servis> servisi) {
		super();
		this.automobil = automobil;
		this.serviser = serviser;
		this.servisi = servisi;
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


	public ArrayList<Servis> getServisi() {
		return servisi;
	}


	public void setServisi(ArrayList<Servis> servisi) {
		this.servisi = servisi;
	}


	@Override
	public String toString() {
		return "ServisnaKnjizica [automobil=" + automobil + ", serviser=" + serviser + ", servisi=" + servisi + "]";
	}
	
	




	




	
	

}
