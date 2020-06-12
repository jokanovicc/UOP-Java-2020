package model.servis;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

import model.automobili.Automobil;
import model.enumeracije.Pol;
import model.enumeracije.Specijalizacija;
import model.enumeracije.Statusi;
import model.korisnici.Serviser;

public class Servis {
	private Automobil automobil;
	private Serviser serviser;
	private GregorianCalendar termin;
	private String opis;
	private ArrayList<Deo> deo;
	private Statusi status;
	private String iDoznaka;
	private boolean obrisan;
	private double troskovi;

	
	public Servis() {
		this.automobil = new Automobil();
		this.serviser = new Serviser();
		serviser.setIDOznaka("0000");
		this.opis = "";
		this.deo = new ArrayList<Deo>();
		this.status = Statusi.OBRADA;
		this.iDoznaka = "";
		this.obrisan = false;
		this.troskovi = troskovi;
		this.termin = new GregorianCalendar(0001, 01, 01);
	}



	public Servis(Automobil automobil, Serviser serviser, GregorianCalendar termin, String opis, ArrayList<Deo> deo,
			Statusi status, String iDoznaka, boolean obrisan, double troskovi) {
		super();
		this.automobil = automobil;
		this.serviser = serviser;
		this.termin = termin;
		this.opis = opis;
		this.deo = deo;
		this.status = status;
		this.iDoznaka = iDoznaka;
		this.obrisan = obrisan;
		this.troskovi = troskovi;
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




	public GregorianCalendar getTermin() {
		return termin;
	}



	public void setTermin(GregorianCalendar termin) {
		this.termin = termin;
	}
	
	public String getTerminSimpleDate() {
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy.");
		return format.format(termin.getTime());
	}
	
	
	public static GregorianCalendar StringToGregorian(String termin) {
		GregorianCalendar datum = new GregorianCalendar();
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy.");
		
		try {
			datum.setTime(format.parse(termin));
		}catch (Exception e) {
			System.out.println("Ne valja datum");
		}
		
		
		return datum;
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



	public String getAutomobilid() {
		return automobil.getIdOznaka();
	}
	
	public String getServiserid() {
		return serviser.getIDOznaka();
	}
	
	public String getVlasnikID() {
		return automobil.getVlasnikId();
	}

	
	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}
	
	
	
	
	public double getTroskovi() {
		return troskovi;
	}



	public void setTroskovi(double troskovi) {
		this.troskovi = troskovi;
	}



	@Override
	public String toString() {
		return  "\n" + automobil + "|" + serviser + "|" + termin + "|" + opis
				+ "|" + deo + "|" + status + "|" + iDoznaka + "|"+troskovi +"|" + isObrisan();
	}
	
	public String toString2() {
		return iDoznaka +"|" +  opis
				+ "|" + status.ordinal() + "|" + iDoznaka+ "|"+troskovi +"|"  + isObrisan();
	}
	
	



	


	
	

	

	
		
		
	}
	
 
