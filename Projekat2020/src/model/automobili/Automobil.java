package model.automobili;


import model.enumeracije.Gorivo;
import model.enumeracije.MarkaModelDeo;
import model.korisnici.Musterija;

public class Automobil {
	
	private Musterija vlasnik;
	private MarkaModelDeo markaModel;
	private int godinaProizvodnje;
	private String zapreminaMotora;
	private String snaga;
	private Gorivo vrstaGoriva;
	private int idOznaka;
	
	public Automobil() {
		this.vlasnik = new Musterija();
		this.markaModel = MarkaModelDeo.FORDFOCUS;
		this.godinaProizvodnje = 0;
		this.zapreminaMotora = "";
		this.snaga = "";
		this.vrstaGoriva = Gorivo.GAS;
		this.idOznaka = 0;
	}
	
	
	



	public Automobil(Musterija vlasnik, MarkaModelDeo markaModel, int godinaProizvodnje, String zapreminaMotora,
			String snaga, Gorivo vrstaGoriva, int idOznaka) {
		super();
		this.vlasnik = vlasnik;
		this.markaModel = markaModel;
		this.godinaProizvodnje = godinaProizvodnje;
		this.zapreminaMotora = zapreminaMotora;
		this.snaga = snaga;
		this.vrstaGoriva = vrstaGoriva;
		this.idOznaka = idOznaka;
	}


	




	public Musterija getVlasnik() {
		return vlasnik;
	}






	public void setVlasnik(Musterija vlasnik) {
		this.vlasnik = vlasnik;
	}






	public MarkaModelDeo getMarkaModel() {
		return markaModel;
	}






	public void setMarkaModel(MarkaModelDeo markaModel) {
		this.markaModel = markaModel;
	}






	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}






	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}






	public String getZapreminaMotora() {
		return zapreminaMotora;
	}






	public void setZapreminaMotora(String zapreminaMotora) {
		this.zapreminaMotora = zapreminaMotora;
	}






	public String getSnaga() {
		return snaga;
	}






	public void setSnaga(String snaga) {
		this.snaga = snaga;
	}






	public Gorivo getVrstaGoriva() {
		return vrstaGoriva;
	}






	public void setVrstaGoriva(Gorivo vrstaGoriva) {
		this.vrstaGoriva = vrstaGoriva;
	}






	public int getIdOznaka() {
		return idOznaka;
	}






	public void setIdOznaka(int idOznaka) {
		this.idOznaka = idOznaka;
	}

	public int getVlasnikId() {
		return vlasnik.getIDOznaka();
	}




	@Override
	public String toString() {
		return  markaModel + "|"
				+ godinaProizvodnje + "|" + zapreminaMotora + "|" + snaga + "|"
				+ vrstaGoriva + "|" + idOznaka;
	}
	
	
	


	
	
	
	
	

}
