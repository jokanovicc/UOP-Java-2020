package main;

import java.util.ArrayList;

import model.automobili.Automobil;
import model.enumeracije.Gorivo;
import model.enumeracije.MarkaModelDeo;
import model.enumeracije.Pol;
import model.enumeracije.Specijalizacija;
import model.enumeracije.Statusi;
import model.korisnici.Admin;
import model.korisnici.Musterija;
import model.korisnici.Serviser;
import model.servis.Deo;
import model.servis.Servis;
import model.servis.ServisnaKnjizica;
import radSaDatotekama.KorisniciUI;


public class ServisMain {

	public static void main(String[] args) {
		KorisniciUI musterije = new KorisniciUI();
		
		System.out.println("KORISNICI:------------------------------------------------------------------------------------------------");
		System.out.println("\n SERVISERI");
		musterije.ucitajServisera();	
		System.out.println("\n");
		System.out.println("MUSTERIJE----------------------------------------------------------------------------------------------");
		musterije.ucitajMusteriju();
		System.out.println("\nADMINI------------------------------------------------------------------------------------");
		musterije.ucitajAdmina();
		System.out.println("------------------------------------------------------------------------------------------------------------");
		System.out.println("\n");
		System.out.println("\n DELOVI---------------------------------------------------------------------------------");
		musterije.ucitajDeo();
		System.out.println("\nAUTOMOBIL---------------------------------------------------------------------------------------------");
		musterije.ucitajAutomobil();
		
		//System.out.println(musterije);
		//System.out.println("Proba");
		//System.out.println("Dodavanje...");
		//musterije.snimiMusteriju();
		
		
		
	//	Musterija musterijaTest = new Musterija("Marko","Peric", "1612155", Pol.valueOf("Muski"), "06332300", "Vozdovac", "markop", "marko123", 100003, 1);
		//System.out.println(musterijaTest.getVidljivost());
	//	musterije.dodajMusteriju(musterijaTest);
	//	musterije.snimiMusteriju();
	//	System.out.println("dodato");
	//	System.out.println("Dodavanje servisera");
		
		
		
	//	Serviser serviserTest = new Serviser("Jovan", "Jovanovic", "194432195", Pol.valueOf("Muski"), "06593363", "Novi Becej", "jovanservis", "servis1123", 21133222, 30300, Specijalizacija.valueOf("LIMAR"));
	//	musterije.dodajServisera(serviserTest);
	//	musterije.snimiServisera();
	//	System.out.println("dODATO");
		
		
		//Admin adminTest = new Admin("Admin111", "Test2", "343243234", Pol.valueOf("Muski"), "06311311", "Zrenjanin", "admin33123", "ado11", 11331555, 50000);
	//	musterije.dodajAdmina(adminTest);
	//	musterije.snimiAdmina();
		
	//	System.out.println("Dodaj auto");

	//	Automobil automobili = new Automobil(musterijaTest, MarkaModelDeo.valueOf("FORDFOCUS"), 2008, "1200m", "60ks", Gorivo.valueOf("BENZIN"), 8001);
	//	musterije.dodajAutomobil(automobili);
	//	musterije.snimiAutomobil();
	//	System.out.println("Dodato nesto");
		
	//	Deo deo1 = new Deo(MarkaModelDeo.valueOf("FORDFOCUS"),"ZadnjaVrata", 45000, "1000015");
	//	musterije.dodajDeo(deo1);
	//	musterije.snimiDeo();
	//	System.out.println("Dodato");
		
	//	Servis servistest = new Servis(automobili, serviserTest, "17.05.2020", "ZamenaVrata", new ArrayList<Deo>(), Statusi.valueOf("ZAKAZAN"), "1000125");
	//	servistest.getDeo().add(deo1);
	//	musterije.dodajServis(servistest);
	//	musterije.snimiServis();
		System.out.println("Uspesno");
		System.out.println("\n");
		System.out.println("\n AKTUELNI SERVIS-----------------------------------------------------------");
		musterije.ucitajServis();
		
	//	ServisnaKnjizica knjizicaTest = new ServisnaKnjizica(automobili, new ArrayList<Servis>(), "1000236");
	//	knjizicaTest.getServisi().add(servistest);
	//	musterije.dodajKnjizicu(knjizicaTest);
	//	musterije.snimiKnjizicu();
		System.out.println("Uspesno");
		System.out.println("\n");
		System.out.println("SERVISNE KNJIZICE--------------------------------------------------------------------------------------------------------");
		musterije.ucitajKnjizicu();
		
		

	}
		

			

}
