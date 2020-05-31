package model.servis;

import model.automobili.Automobil;
import main.*;
import model.enumeracije.MarkaModelDeo;
import radSaDatotekama.Datoteke;
import main.ServisMain;

public class Deo {
	
	private MarkaModelDeo automobil; //Klasa deo mi nema referencu na klasu automobil vec na enum MarkuModela,
									//jer je jedan deo moze na vise automobile iste marke, ne samo na jedan zadati
	private String naziv;
	private double cena;
	private String idDela;
	private boolean obrisan;
	//public static ServisMain podaci = new ServisMain();  //samo za potrebe maina

	
	
	
	public Deo() {
		this.automobil = MarkaModelDeo.FORDFOCUS;
		this.naziv = "";
		this.cena = 0;
		this.idDela = "";
		this.obrisan = false;
	}



	public Deo(MarkaModelDeo automobil, String naziv, double cena, String idDela, boolean obrisano) {
		super();
		this.automobil = automobil;
		this.naziv = naziv;
		this.cena = cena;
		this.idDela = idDela;
		this.obrisan = obrisano;
	}

	

	public MarkaModelDeo getAutomobil() {
		return automobil;
	}


	public void setAutomobil(MarkaModelDeo automobil) {
		this.automobil = automobil;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public double getCena() {
		return cena;
	}


	public void setCena(double cena) {
		this.cena = cena;
	}



	public String getIdDela() {
		return idDela;
	}


	public void setIdDela(String idDela) {
		this.idDela = idDela;
	}

	public boolean isObrisan() {
		return obrisan;
	}
	

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}
	
	public static void kreirajSimetricniDeo(Deo deo) {
		String mystring = deo.getNaziv();
		String arr[] = mystring.split(" ", 3);
	
		
		 if((arr[0].equals("Leva") && arr[1].equals("strana")) 
				 || (arr[0].equals("Desna") && arr[1].equals("strana"))) {
		
		
		
			if(arr[0].equals("Leva") && arr[1].equals("strana")) {
				Deo deo2 = new Deo (deo.getAutomobil(),
						"Desna strana" + " " +arr[2] , deo.getCena(), deo.getIdDela(), deo.isObrisan());
				ServisMain.podaci.dodajDeo(deo2);  //ovo duplo ce biti izmenjeno, zavisi gde funkcija bude trebala
				ServisMain.podaci.snimiDeo();
				
				
			} else if (arr[0].equals("Desna") && arr[1].equals("strana")) {
				Deo deo2 = new Deo (deo.getAutomobil(),
						"Leva strana" + " "+ arr[2] , deo.getCena(), deo.getIdDela(), deo.isObrisan());
				ServisMain.podaci.dodajDeo(deo2);
				ServisMain.podaci.snimiDeo();
				
			
			
		} }
	}
	
	@Override
	public String toString() {
		return automobil + "|" + naziv + "|" + cena + "|" + idDela + "|" + isObrisan();
	}

	
	
	


}


