package radSaDatotekama;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.enumeracije.Pol;
import model.korisnici.Musterija;

public class KorisniciUI {
	private ArrayList<Musterija> musterije;
	//ocitavanje fajlova
	
	
	public KorisniciUI() {
		this.musterije = new ArrayList<Musterija>();
	}
	
	public ArrayList<Musterija> getMusterija(){
		return musterije;		
	}
	public void dodajMusteriju(Musterija musterija) {
		this.musterije.add(musterija);
	}	
	public void obrisiProdavca(Musterija musterija) {
		this.musterije.remove(musterija);
	}
	
	public Musterija nadjiMusteriju(String username) {
		for (Musterija musterija : musterije) {
			if (musterija.getUsername().equals(username)) {
				return musterija;
			}
		}
		return null;
	}
	
	public void ucitajMusteriju() {
		try {
			File musterijeFile = new File("src/txt/musterija.txt");
			BufferedReader reader = new BufferedReader(new FileReader(musterijeFile));
			String line = null;
			while((line = reader.readLine()) != null){
				String[] split = line.split("\\|");
				String ime = split[0];
				String prezime = split[1];
				String jmbg = split[2];
				int indeksPol = Integer.parseInt(split[3]);
				Pol pol  = Pol.values()[indeksPol];
				String adresa = split[4];
				String brojTelefona = split[5];
				String username = split[6];
				String lozinka = split[7];
				int brojSakupljenihBodova = Integer.parseInt(split[8]);
				Musterija musterija = new Musterija(ime, prezime, jmbg, pol, brojTelefona, username, lozinka, brojSakupljenihBodova);
				musterije.add(musterija);
				System.out.println("Uspesno iscitano");
				System.out.println(musterija);
			}
			reader.close();
			
									
		}catch(IOException e) {
			System.out.println("Problem sa ocitavanjem");
		}
	}
	
	
	
	
	
}
