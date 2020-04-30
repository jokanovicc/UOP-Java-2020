package model.automobili;

import model.enumeracije.AutoMarka;
import model.enumeracije.AutoModel;
import model.enumeracije.Gorivo;
import model.korisnici.Musterija;

public class Automobil {
	
	private Musterija vlasnik;
	private AutoMarka marka;
	private AutoModel model;
	private int godinaProizvodnje;
	private String zapreminaMotora;
	private String snaga;
	private Gorivo vrstaGoriva;
	
	public Automobil() {
		this.vlasnik = new Musterija();
		this.marka = AutoMarka.FORD;
		this.model = AutoModel.FOCUS;
		this.godinaProizvodnje = 0;
		this.zapreminaMotora = "";
		this.snaga = "";
		this.vrstaGoriva = Gorivo.GAS;
	}

	public Automobil(Musterija vlasnik, AutoMarka marka, AutoModel model, int godinaProizvodnje, String zapreminaMotora,
			String snaga, Gorivo vrstaGoriva) {
		super();
		this.vlasnik = vlasnik;
		this.marka = marka;
		this.model = model;
		this.godinaProizvodnje = godinaProizvodnje;
		this.zapreminaMotora = zapreminaMotora;
		this.snaga = snaga;
		this.vrstaGoriva = vrstaGoriva;
	}

	public Musterija getVlasnik() {
		return vlasnik;
	}

	public void setVlasnik(Musterija vlasnik) {
		this.vlasnik = vlasnik;
	}

	public AutoMarka getMarka() {
		return marka;
	}

	public void setMarka(AutoMarka marka) {
		this.marka = marka;
	}

	public AutoModel getModel() {
		return model;
	}

	public void setModel(AutoModel model) {
		this.model = model;
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

	@Override
	public String toString() {
		return "Automobil [vlasnik=" + vlasnik + ", marka=" + marka + ", model=" + model + ", godinaProizvodnje="
				+ godinaProizvodnje + ", zapreminaMotora=" + zapreminaMotora + ", snaga=" + snaga + ", vrstaGoriva="
				+ vrstaGoriva + "]";
	}
	
	
	
	
	
	

}
