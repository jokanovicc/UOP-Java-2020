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
		
		
		
		//Musterija musterijaTest = new Musterija("Pavle","Jovanovic", "19898203949", Pol.valueOf("Muski"), "0639565611", "Beograd", "pavlejovan", "jvoan123", 1112225333, 2);
		//musterije.dodajMusteriju(musterijaTest);
		//musterije.snimiMusteriju();
		//System.out.println("dodato");
		//System.out.println("Dodavanje servisera");
		
		
		
		//Serviser serviserTest = new Serviser("Radenko", "Radenkovic", "2344444", Pol.valueOf("Muski"), "33444333", "Becej", "radenkoservis", "servis123", 224442555, 30300, Specijalizacija.valueOf("LIMAR"));
		//musterije.dodajServisera(serviserTest);
		//musterije.snimiServisera();
		//System.out.println("dODATO");
		
		
		//Admin adminTest = new Admin("aDO", "Adminic", "222111", Pol.valueOf("Muski"), "053333", "Vozdovac", :, lozinka, iDOznaka, plata)
		//musterije.dodajAdmina(adminTest);
		//musterije.snimiAdmina();
		
		//System.out.println("Dodaj auto");

		//Automobil automobili = new Automobil(musterijaTest, MarkaModelDeo.valueOf("VOLKSWAGENGOLF"), 2005, "1200m", "120ks", Gorivo.valueOf("DIZEL"), 1703);
		//musterije.dodajAutomobil(automobili);
		//musterije.snimiAutomobil();
		//System.out.println("Dodato nesto");
		
		//Deo deo1 = new Deo(MarkaModelDeo.valueOf("TOYOTACOROLLA"),"ko555", 25000, 1225);
		//musterije.dodajDeo(deo1);
		//musterije.snimiDeo();
		//System.out.println("Dodato");
		
		//Deo testDeo = new Deo(MarkaModelDeo.valueOf("FIATSTILO"), "Menjac", 25000, 555333);
		//Servis servistest = new Servis(automobili, serviserTest, "06.05.2020", "Urgiranje", new ArrayList<Deo>(), Statusi.valueOf("ZAKAZAN"), 1112222);
		//servistest.getDeo().add(testDeo);
		//musterije.dodajServis(servistest);
		//musterije.snimiServis();
		//System.out.println("Uspesno");
		//System.out.println("\n");
		//System.out.println("\nAktuelni servis");
		//musterije.ucitajServis();
		
		//ServisnaKnjizica knjizicaTest = new ServisnaKnjizica(automobili, serviserTest, new ArrayList<Servis>(), 1204);
		//knjizicaTest.getServisi().add(servistest);
		//musterije.dodajKnjizicu(knjizicaTest);
		//musterije.snimiKnjizicu();
		//System.out.println("Uspesno");
		//musterije.ucitajKnjizicu();
		
		

	}
		

			

}
