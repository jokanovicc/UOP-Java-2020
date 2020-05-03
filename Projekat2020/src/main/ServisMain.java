package main;

import java.util.ArrayList;

import model.enumeracije.Pol;
import model.korisnici.Musterija;
import radSaDatotekama.AutomobiliUI;
import radSaDatotekama.KorisniciUI;


public class ServisMain {

	public static void main(String[] args) {
		KorisniciUI musterije = new KorisniciUI();
		KorisniciUI serviseri = new KorisniciUI();
		KorisniciUI admini = new KorisniciUI();
		AutomobiliUI automobili = new AutomobiliUI();
		System.out.println("KORISNICI:------------------------------------------------------------------------------------------------");
		serviseri.ucitajServisera();	
		System.out.println("\n");	
		musterije.ucitajMusteriju();	
		System.out.println("\n");
		admini.ucitajAdmina();
		System.out.println("------------------------------------------------------------------------------------------------------------");
		System.out.println("/n");
		automobili.ucitajAutomobil();
		
		//System.out.println(musterije);
		//System.out.println("Proba");
		System.out.println("Dodavanje...");
		Musterija musterijaTest = new Musterija("bla1", "bla2", "11111", Pol.Muski, "555555", "trgfgffg", "5555aaa55", "112233", 3);
		musterije.dodajMusteriju(musterijaTest);
		System.out.println("dodato");
		//musterije.dodajMusteriju(musterija);

	}
		

			

}
