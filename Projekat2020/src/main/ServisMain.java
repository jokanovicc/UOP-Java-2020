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
		
		
		
	//	Musterija musterijaTest = new Musterija("Musterija","test1", "16445", Pol.valueOf("Muski"), "06534300", "Secanj", "vladd1", "vlafgfg1231", 1603508, 2);
	//	System.out.println(musterijaTest.getVidljivost());
	//	musterije.dodajMusteriju(musterijaTest);
	//	musterije.snimiMusteriju();
	//	System.out.println("dodato");
	//	System.out.println("Dodavanje servisera");
		
		
		
	//	Serviser serviserTest = new Serviser("Paja", "Jovanovic", "23433441444", Pol.valueOf("Muski"), "334314344333", "Zrenjanin", "pajasevis", "ser1vis123", 22455, 30300, Specijalizacija.valueOf("LIMAR"));
	//	musterije.dodajServisera(serviserTest);
	//	musterije.snimiServisera();
		//System.out.println("dODATO");
		
		
	//	Admin adminTest = new Admin("Admin111", "Test2", "343243234", Pol.valueOf("Muski"), "06311311", "Zrenjanin", "admin33123", "ado11", 11331555, 50000);
	//	musterije.dodajAdmina(adminTest);
		//musterije.snimiAdmina();
		
	//	System.out.println("Dodaj auto");

	//Automobil automobili = new Automobil(musterijaTest, MarkaModelDeo.valueOf("FORDFOCUS"), 2005, "2500m", "159ks", Gorivo.valueOf("DIZEL"), 7722);
	//	musterije.dodajAutomobil(automobili);
	//	musterije.snimiAutomobil();
		///System.out.println("Dodato nesto");
	//	
	//	Deo deo1 = new Deo(MarkaModelDeo.valueOf("FORDFOCUS"),"kvacilo", 25000, 311215);
	//	musterije.dodajDeo(deo1);
	//	musterije.snimiDeo();
		//System.out.println("Dodato");
		
	//Deo testDeo = new Deo(MarkaModelDeo.valueOf("FORDFOCUS"), "Menjac", 25000, 5223233);
	///	Servis servistest = new Servis(automobili, serviserTest, "06.10.2021", "ZamenaMenjaca", new ArrayList<Deo>(), Statusi.valueOf("ZAKAZAN"), 11253252);
	//	servistest.getDeo().add(testDeo);
	//	musterije.dodajServis(servistest);
	//	musterije.snimiServis();
	//	System.out.println("Uspesno");
		System.out.println("\n");
		System.out.println("\n AKTUELNI SERVIS-----------------------------------------------------------");
		musterije.ucitajServis();
		
		//ServisnaKnjizica knjizicaTest = new ServisnaKnjizica(automobili, new ArrayList<Servis>(), 121210);
		//knjizicaTest.getServisi().add(servistest);
	//	musterije.dodajKnjizicu(knjizicaTest);
	//	musterije.snimiKnjizicu();
		//System.out.println("Uspesno");
		//System.out.println("\n");
		//System.out.println("SERVISNE KNJIZICE--------------------------------------------------------------------------------------------------------");
		musterije.ucitajKnjizicu();
		
		

	}
		

			

}
