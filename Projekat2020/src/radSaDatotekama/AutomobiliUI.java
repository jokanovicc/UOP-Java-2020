package radSaDatotekama;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.automobili.Automobil;
import model.enumeracije.Gorivo;
import model.enumeracije.MarkaModelDeo;
import model.korisnici.Musterija;

public class AutomobiliUI {
	private ArrayList<Automobil> automobili;
	
	public AutomobiliUI() {
		this.automobili = new ArrayList<Automobil>();
		
		

		
	}
	
	public ArrayList<Automobil> getAutomobil(){
		return automobili;
	}
	
	
	
	
	public void ucitajAutomobil() {
		try {
			File autoFile = new File("src/txt/automobili.txt");
			BufferedReader reader = new BufferedReader(new FileReader(autoFile));
			String line = null;
			while((line = reader.readLine()) != null){
				String[] split = line.split("\\|");
				String vlasnik = split[0];
				int indeksMarka = Integer.parseInt(split[1]);
				MarkaModelDeo markaModel = MarkaModelDeo.values()[indeksMarka];
				int godinaProizvodnje = Integer.parseInt(split[2]);
				String zapreminaMotora = split[3];
				String snaga = split[4];
				int indeksGorivo = Integer.parseInt(split[5]);
				Gorivo vrstaGoriva = Gorivo.values()[indeksGorivo];
				String id = split[6];
				Musterija vlasnik1 = new Musterija();
				vlasnik1.setIme(vlasnik);
				Automobil automobil = new Automobil(vlasnik1, markaModel, godinaProizvodnje, zapreminaMotora, snaga, vrstaGoriva, id);
				automobili.add(automobil);
				

				System.out.println(automobil);
				
			}
			reader.close();
			
									
		}catch(IOException e) {
			System.out.println("Problem sa ocitavanjem");
		}
	}
	

}
