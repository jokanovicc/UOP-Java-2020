package model.servis;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import model.automobili.Automobil;
import model.enumeracije.Statusi;
import model.korisnici.Serviser;

public class Servis {
	
	private Automobil[] automobil;
	private Serviser[] serviser;
	private SimpleDateFormat datum;
	private String opis;
	private Statusi status;
	private Deo[] deo;
	private ServisnaKnjizica[] knjizice;
	
	
	public Servis() {
		this.automobil = new Automobil[10];
		this.serviser = new Serviser[5];
		this.datum = new SimpleDateFormat("12-04-2019");
		this.opis = "";
		this.status = Statusi.ZAKAZAN;
		this.deo = new Deo[5];
		this.knjizice = new ServisnaKnjizica[5];
		
	}


	public Servis(Automobil[] automobil, Serviser[] serviser, SimpleDateFormat datum, String opis, Statusi status,
			Deo[] deo, ServisnaKnjizica[] knjizice) {
		super();
		this.automobil = automobil;
		this.serviser = serviser;
		this.datum = datum;
		this.opis = opis;
		this.status = status;
		this.deo = deo;
		this.knjizice = knjizice;
	}


	public Automobil[] getAutomobil() {
		return automobil;
	}


	public void setAutomobil(Automobil[] automobil) {
		this.automobil = automobil;
	}


	public Serviser[] getServiser() {
		return serviser;
	}


	public void setServiser(Serviser[] serviser) {
		this.serviser = serviser;
	}


	public SimpleDateFormat getDatum() {
		return datum;
	}


	public void setDatum(SimpleDateFormat datum) {
		this.datum = datum;
	}


	public String getOpis() {
		return opis;
	}


	public void setOpis(String opis) {
		this.opis = opis;
	}


	public Statusi getStatus() {
		return status;
	}


	public void setStatus(Statusi status) {
		this.status = status;
	}


	public Deo[] getDeo() {
		return deo;
	}


	public void setDeo(Deo[] deo) {
		this.deo = deo;
	}


	public ServisnaKnjizica[] getKnjizice() {
		return knjizice;
	}


	public void setKnjizice(ServisnaKnjizica[] knjizice) {
		this.knjizice = knjizice;
	}


	@Override
	public String toString() {
		return "Servis [automobil=" + Arrays.toString(automobil) + ", serviser=" + Arrays.toString(serviser)
				+ ", datum=" + datum + ", opis=" + opis + ", status=" + status + ", deo=" + Arrays.toString(deo)
				+ ", knjizice=" + Arrays.toString(knjizice) + "]";
	}
	
	
	
	



	
 
}
