package model.servis;

import model.automobili.Automobil;
import model.enumeracije.MarkaModelDeo;

public class Deo {
	
	private MarkaModelDeo automobil; //Klasa deo mi nema referencu na klasu automobil vec na enum MarkuModela,
									//jer je jedan deo moze na vise automobile iste marke, ne samo na jedan zadati
	private String naziv;
	private double cena;
	
	
	public Deo() {
		this.automobil = MarkaModelDeo.FORDFOCUS;
		this.naziv = "";
		this.cena = 0;
	}


	public Deo(MarkaModelDeo automobil, String naziv, double cena) {
		super();
		this.automobil = automobil;
		this.naziv = naziv;
		this.cena = cena;
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


	@Override
	public String toString() {
		return "Deo [automobil=" + automobil + ", naziv=" + naziv + ", cena=" + cena + "]";
	}
	
	
	

}


