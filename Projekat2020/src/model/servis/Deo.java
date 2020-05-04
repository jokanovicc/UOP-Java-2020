package model.servis;

import model.automobili.Automobil;
import model.enumeracije.MarkaModelDeo;

public class Deo {
	
	private MarkaModelDeo automobil; //Klasa deo mi nema referencu na klasu automobil vec na enum MarkuModela,
									//jer je jedan deo moze na vise automobile iste marke, ne samo na jedan zadati
	private String naziv;
	private double cena;
	private int idDela;
	
	
	public Deo() {
		this.automobil = MarkaModelDeo.FORDFOCUS;
		this.naziv = "";
		this.cena = 0;
		this.idDela = 0;
	}


	public Deo(MarkaModelDeo automobil, String naziv, double cena, int idDela) {
		super();
		this.automobil = automobil;
		this.naziv = naziv;
		this.cena = cena;
		this.idDela = idDela;
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


	public int getIdDela() {
		return idDela;
	}


	public void setIdDela(int idDela) {
		this.idDela = idDela;
	}


	@Override
	public String toString() {
		return automobil + "|" + naziv + "|" + cena + "|" + idDela;
	}



	
	

}


