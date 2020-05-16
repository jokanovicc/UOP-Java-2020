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
import radSaDatotekama.Datoteke;


public class ServisMain {

	public static void main(String[] args) {
		Datoteke podaci = new Datoteke();
		
		System.out.println("KORISNICI:------------------------------------------------------------------------------------------------");
		System.out.println("\n SERVISERI");
		podaci.ucitajServisera();	
		System.out.println("\n");
		System.out.println("MUSTERIJE----------------------------------------------------------------------------------------------");
		podaci.ucitajMusteriju();
		System.out.println("\nADMINI------------------------------------------------------------------------------------");
		podaci.ucitajAdmina();
		System.out.println("------------------------------------------------------------------------------------------------------------");
		System.out.println("\n");
		System.out.println("\n DELOVI---------------------------------------------------------------------------------");
		podaci.ucitajDeo();
		System.out.println("\nAUTOMOBIL---------------------------------------------------------------------------------------------");
		podaci.ucitajAutomobil();
		
		//System.out.println(podaci);
	//	podaci.snimiMusteriju();
		
		
		
	//	Musterija musterijaTest = new Musterija("Milan","Milanovic", "27129335", Pol.valueOf("Muski"), "063335200", "Klek", "milanm", "milanm123", 100071, 1);
	//	System.out.println(musterijaTest.getVidljivost());
	//	podaci.dodajMusteriju(musterijaTest);
	//	podaci.snimiMusteriju();
	//	System.out.println("dodato");
	//	System.out.println("Dodavanje servisera");
		
		
		
	//	Serviser serviserTest = new Serviser("Rade", "Radic", "134342195", Pol.valueOf("Muski"), "06331363", "Despotovac", "radeservis", "servis1123", 212311222, 30300, Specijalizacija.valueOf("AUTOELEKTRICAR"));
	//	podaci.dodajServisera(serviserTest);
	//	podaci.snimiServisera();
	//	System.out.println("dODATO");
		
		
		//Admin adminTest = new Admin("Admin111", "Test2", "343243234", Pol.valueOf("Muski"), "06311311", "Zrenjanin", "admin33123", "ado11", 11331555, 50000);
	//	podaci.dodajAdmina(adminTest);
	//	podaci.snimiAdmina();
		
	//	System.out.println("Dodaj auto");

	//	Automobil automobili = new Automobil(musterijaTest, MarkaModelDeo.valueOf("TOYOTACOROLLA"), 2009, "1400m", "95ks", Gorivo.valueOf("BENZIN"), 9006);
	//	podaci.dodajAutomobil(automobili);
	//	podaci.snimiAutomobil();
	//	System.out.println("Dodato nesto");
		
	//	Deo deo1 = new Deo(MarkaModelDeo.valueOf("TOYOTACOROLLA"),"Karburator", 23000, "100017");
	//	podaci.dodajDeo(deo1);
	//	podaci.snimiDeo();
	//	System.out.println("Dodato");
		
	//	Servis servistest = new Servis(automobili, serviserTest, "21.05.2020", "Zamena Karburatora", new ArrayList<Deo>(), Statusi.valueOf("ZAKAZAN"), "100125");
	//	servistest.getDeo().add(deo1);
	//	podaci.dodajServis(servistest);
	//	podaci.snimiServis();
//		System.out.println("Uspesno");
		System.out.println("\n");
		System.out.println("\n AKTUELNI SERVIS-----------------------------------------------------------");
		podaci.ucitajServis();
		
	//	ServisnaKnjizica knjizicaTest = new ServisnaKnjizica(automobili, new ArrayList<Servis>(), "1100238");
	//	knjizicaTest.getServisi().add(servistest);
//		podaci.dodajKnjizicu(knjizicaTest);
	//	podaci.snimiKnjizicu();
	//	System.out.println("Uspesno");
		System.out.println("\n");
		System.out.println("SERVISNE KNJIZICE--------------------------------------------------------------------------------------------------------");
		podaci.ucitajKnjizicu();
		
		

	}
		

			

}
