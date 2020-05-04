package main;

import java.util.ArrayList;

import model.automobili.Automobil;
import model.enumeracije.Gorivo;
import model.enumeracije.MarkaModelDeo;
import model.enumeracije.Pol;
import model.enumeracije.Specijalizacija;
import model.korisnici.Admin;
import model.korisnici.Musterija;
import model.korisnici.Serviser;
import radSaDatotekama.KorisniciUI;


public class ServisMain {

	public static void main(String[] args) {
		KorisniciUI musterije = new KorisniciUI();
		System.out.println("KORISNICI:------------------------------------------------------------------------------------------------");
		//musterije.ucitajServisera();	
		System.out.println("\n");	
		musterije.ucitajMusteriju();
		System.out.println("\n");
		musterije.ucitajAdmina();
		System.out.println("------------------------------------------------------------------------------------------------------------");
		musterije.ucitajAutomobil();
		
		//System.out.println(musterije);
		//System.out.println("Proba");
		//System.out.println("Dodavanje...");
		//musterije.snimiMusteriju();
		Musterija musterijaTest = new Musterija("ime", "petrovic2", "33333", Pol.Muski, "065", "bezbroja", "imep", "aaa22", 3);
		musterije.dodajMusteriju(musterijaTest);
		musterije.snimiMusteriju();
		//System.out.println("dodato");
		System.out.println("Dodavanje servisera");
		
		
		
		//Serviser serviserTest = new Serviser("Servo", "Servis", "222233333", Pol.Muski,"0655100" ,"beograd", "sero11", "11222", 30000, Specijalizacija.AUTOELEKTRICAR);
		//musterije.dodajServisera(serviserTest);
		//musterije.snimiServisera();
		System.out.println("dODATO");
		
		
		//Admin adminTest = new Admin("Admin", "Adminic", "1111111111", Pol.Muski, "06377777", "vozdovac", "adminat", "admini111", 45000);
		//musterije.dodajAdmina(adminTest);
		//musterije.snimiAdmina();
		
		System.out.println("Dodaj auto");
		//Automobil automobil = new Automobil(Korisnik, MarkaModelDeo.FIATSTILO, 2005, "1200m", "30", Gorivo.BENZIN, 121);

	}
		

			

}
