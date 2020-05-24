package model.servis;

import model.automobili.Automobil;
import model.enumeracije.MarkaModelDeo;

public class Deo {
	
	private MarkaModelDeo automobil; //Klasa deo mi nema referencu na klasu automobil vec na enum MarkuModela,
									//jer je jedan deo moze na vise automobile iste marke, ne samo na jedan zadati
	private String naziv;
	private double cena;
	private String idDela;
	private boolean obrisan;
	
	
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
	
	@Override
	public String toString() {
		return automobil + "|" + naziv + "|" + cena + "|" + idDela + "|" + isObrisan();
	}



	
	

}


