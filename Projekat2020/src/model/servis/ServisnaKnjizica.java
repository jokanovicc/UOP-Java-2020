package model.servis;

import java.util.ArrayList;
import java.util.Arrays;

import model.automobili.Automobil;
import model.korisnici.Serviser;

public class ServisnaKnjizica {
	
	//private Serviser serviser;
	private ArrayList<Servis> servisi;
	private String idOznaka;
	private boolean obrisan;
	
	public ServisnaKnjizica() {
		this.servisi = new ArrayList<Servis>();
		this.idOznaka = "";
		this.obrisan = false;
	}







	public ServisnaKnjizica(ArrayList<Servis> servisi, String idOznaka, boolean obrisan) {
		super();
		this.servisi = servisi;
		this.idOznaka = idOznaka;
		this.obrisan = obrisan;
	}







	public ArrayList<Servis> getServisi() {
		return servisi;
	}
	
	public ArrayList<String> getServisID(){
		ArrayList<String> servisID = new ArrayList<String>();
		for (Servis servis1 : servisi) {
			servisID.add(servis1.getiDoznaka());
			
		}
		return servisID;
	}


	public void setServisi(ArrayList<Servis> servisi) {
		this.servisi = servisi;
	}



	public String getIdOznaka() {
		return idOznaka;
	}





	public void setIdOznaka(String idOznaka) {
		this.idOznaka = idOznaka;
	}


	
	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}
	
	
	
	@Override
	public String toString() {
		return servisi
				+ "|" + idOznaka +"|" + isObrisan();
	}
	
	
	
	
	

	




	




	
	

}
