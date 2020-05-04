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
import model.servis.Deo;
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
		
		
		
		//Musterija musterijaTest = new Musterija("Janko","Jankovic", "222340", Pol.valueOf("Muski"), "0639911", "Milanovac", "janko123", "11111222", 222333, 3);
		//musterije.dodajMusteriju(musterijaTest);
		//musterije.snimiMusteriju();
		//System.out.println("dodato");
		//System.out.println("Dodavanje servisera");
		
		
		
		//Serviser serviserTest = new Serviser("S44s1", "Serv44overa", "24411", Pol.valueOf("Muski"), "33333", "adresa", "usern", "2222aaa2", 222555, 3000, Specijalizacija.valueOf("LIMAR"));
		//musterije.dodajServisera(serviserTest);
		//musterije.snimiServisera();
		//System.out.println("dODATO");
		
		
		//Admin adminTest = new Admin("Admin", "Adminic", "1111111111", Pol.Muski, "06377777", "vozdovac", "adminat", "admini111", 45000);
		//musterije.dodajAdmina(adminTest);
		//musterije.snimiAdmina();
		
		//System.out.println("Dodaj auto");

		//Automobil automobili = new Automobil(musterijaTest, MarkaModelDeo.valueOf("FIATSTILO"), 1990, "1200m", "120ks", Gorivo.valueOf("BENZIN"), 2225);
		//musterije.dodajAutomobil(automobili);
		//musterije.snimiAutomobil();
		//System.out.println("Dodato nesto");
		
		//Deo deo1 = new Deo(MarkaModelDeo.valueOf("TOYOTACOROLLA"),"ko555", 25000, 1225);
		//musterije.dodajDeo(deo1);
		//musterije.snimiDeo();
		//System.out.println("Dodato");

	}
		

			

}
