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
	private String termin;
	private String opis;
	private ArrayList<Deo> deo;
	private Statusi status;
	private String iDoznaka;
	private boolean vidljivost;	

	
	public Servis() {
		this.automobil = new Automobil();
		this.serviser = new Serviser();
		this.termin = "";
		this.opis = "";
		this.deo = new ArrayList<Deo>();
		this.status = Statusi.SLOBODAN;
		this.iDoznaka = "";
	}






	public Servis(Automobil automobil, Serviser serviser, String termin, String opis, ArrayList<Deo> deo,
			Statusi status, String iDoznaka) {
		super();
		this.automobil = automobil;
		this.serviser = serviser;
		this.termin = termin;
		this.opis = opis;
		this.deo = deo;
		this.status = status;
		this.iDoznaka = iDoznaka;
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



	public String getTermin() {
		return termin;
	}



	public void setTermin(String termin) {
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
	
	public ArrayList<String> getDeoID(){
		ArrayList<String> deoID = new ArrayList<String>();
		for (Deo deo1 : deo) {
			deoID.add(deo1.getIdDela());
			
		}
		return deoID;
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




	
	public String getiDoznaka() {
		return iDoznaka;
	}






	public void setiDoznaka(String iDoznaka) {
		this.iDoznaka = iDoznaka;
	}






	public int getAutomobilid() {
		return automobil.getIdOznaka();
	}
	
	public int getServiserid() {
		return serviser.getIDOznaka();
	}
	

	
	public boolean getVidljivost() {
		return vidljivost;
	}
	
	public void brisanje() {
		this.vidljivost = false;
	}
	
	@Override
	public String toString() {
		return  "\n" + automobil + "|" + serviser + "|" + termin + "|" + opis
				+ "|" + deo + "|" + status + "|" + iDoznaka;
	}
	
	public String toString2() {
		return "|" +  opis
				+ "|" + status + "|" + iDoznaka;
	}
	
	



	


	
	

	

	
		
		
	}
	
 
