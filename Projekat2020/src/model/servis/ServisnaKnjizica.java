package model.servis;

import java.util.ArrayList;
import java.util.Arrays;

import model.automobili.Automobil;
import model.korisnici.Serviser;

public class ServisnaKnjizica {
	
	private Automobil automobil;
	//private Serviser serviser;
	private ArrayList<Servis> servisi;
	private int idOznaka;
	private boolean vidljivost;
	
	public ServisnaKnjizica() {
		this.automobil = new Automobil();
		this.servisi = new ArrayList<Servis>();
		this.idOznaka = 0;
	}


	public ServisnaKnjizica(Automobil automobil, ArrayList<Servis> servisi, int idOznaka) {
		super();
		this.automobil = automobil;
		this.servisi = servisi;
		this.idOznaka = idOznaka;
	}


	public Automobil getAutomobil() {
		return automobil;
	}


	public void setAutomobil(Automobil automobil) {
		this.automobil = automobil;
	}


	public ArrayList<Servis> getServisi() {
		return servisi;
	}
	
	public ArrayList<Integer> getServisID(){
		ArrayList<Integer> servisID = new ArrayList<Integer>();
		for (Servis servis1 : servisi) {
			servisID.add(servis1.getiDoznaka());
			
		}
		return servisID;
	}


	public void setServisi(ArrayList<Servis> servisi) {
		this.servisi = servisi;
	}


	public int getIdOznaka() {
		return idOznaka;
	}


	public void setIdOznaka(int idOznaka) {
		this.idOznaka = idOznaka;
	}
	public int getAutomobilid() {
		return automobil.getIdOznaka();
	}
	

	public boolean getVidljivost() {
		return vidljivost;
	}
	

	public void brisanje() {
		this.vidljivost = false;
	}

	
	
	
	@Override
	public String toString() {
		return "\n" + automobil + "|" + servisi
				+ "|" + idOznaka;
	}
	
	
	
	
	

	




	




	
	

}
