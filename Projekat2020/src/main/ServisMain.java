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
		
		
		//Musterija musterijaTest = new Musterija("Vlado2","Jokan1", "16030804", Pol.valueOf("Muski"), "06531000", "Secanj", "vladd1", "vlado1231", 160508, 2);
		//musterije.dodajMusteriju(musterijaTest);
		//musterije.snimiMusteriju();
		//System.out.println("dodato");
		//System.out.println("Dodavanje servisera");
		
		
		
		//Serviser serviserTest = new Serviser("Jack1", "Jackovic1", "234341444", Pol.valueOf("Muski"), "334314333", "Becej", "jack1servis", "ser1vis123", 22413455, 30300, Specijalizacija.valueOf("LIMAR"));
		//musterije.dodajServisera(serviserTest);
		//musterije.snimiServisera();
		//System.out.println("dODATO");
		
		
		//Admin adminTest = new Admin("Admin11", "Test", "34324234", Pol.valueOf("Muski"), "0631111", "Zrenjanin", "admin123", "ado", 111555, 50000);
		//musterije.dodajAdmina(adminTest);
		//musterije.snimiAdmina();
		
	//	System.out.println("Dodaj auto");

		//Automobil automobili = new Automobil(musterijaTest, MarkaModelDeo.valueOf("FORDFOCUS"), 2005, "2000m", "109ks", Gorivo.valueOf("DIZEL"), 77333222);
		//musterije.dodajAutomobil(automobili);
		//musterije.snimiAutomobil();
		///System.out.println("Dodato nesto");
		
		//Deo deo1 = new Deo(MarkaModelDeo.valueOf("TOYOTACOROLLA"),"kvacilo", 25000, 31115);
		//musterije.dodajDeo(deo1);
		//musterije.snimiDeo();
		//System.out.println("Dodato");
		
		//Deo testDeo = new Deo(MarkaModelDeo.valueOf("FIATSTILO"), "Menjac", 25000, 522333);
	//	Servis servistest = new Servis(automobili, serviserTest, "06.10.2021", "Zamena23", new ArrayList<Deo>(), Statusi.valueOf("ZAKAZAN"), 1153252);
	//	servistest.getDeo().add(testDeo);
		//musterije.dodajServis(servistest);
	//	musterije.snimiServis();
	//	System.out.println("Uspesno");
		System.out.println("\n");
		System.out.println("\n AKTUELNI SERVIS-----------------------------------------------------------");
		musterije.ucitajServis();
		
	//	ServisnaKnjizica knjizicaTest = new ServisnaKnjizica(automobili, serviserTest, new ArrayList<Servis>(), 1210);
	//	knjizicaTest.getServisi().add(servistest);
	//	musterije.dodajKnjizicu(knjizicaTest);
	//	musterije.snimiKnjizicu();
	//	System.out.println("Uspesno");
		System.out.println("\n");
		System.out.println("SERVISNE KNJIZICE--------------------------------------------------------------------------------------------------------");
		musterije.ucitajKnjizicu();
		
		

	}
		

			

}
