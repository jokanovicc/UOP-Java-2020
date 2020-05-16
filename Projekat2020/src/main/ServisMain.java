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
		
		System.out.println(podaci);
		podaci.snimiMusteriju();
		
		
		
	//	Musterija musterijaTest = new Musterija("Goran","Mitrovic", "2729335", Pol.valueOf("Muski"), "065321200", "Zitiste", "goranmitro", "mitro123", 100021, 1);
	//	System.out.println(musterijaTest.getVidljivost());
	//	podaci.dodajMusteriju(musterijaTest);
	//	podaci.snimiMusteriju();
	///	System.out.println("dodato");
	//	System.out.println("Dodavanje servisera");
		
		
		
	//	Serviser serviserTest = new Serviser("Branko", "Ivanovic", "194342195", Pol.valueOf("Muski"), "06591363", "Sutjeska", "brankoservis", "servis1123", 21111222, 30300, Specijalizacija.valueOf("AUTOELEKTRICAR"));
	//	podaci.dodajServisera(serviserTest);
	//	podaci.snimiServisera();
	//	System.out.println("dODATO");
		
		
		//Admin adminTest = new Admin("Admin111", "Test2", "343243234", Pol.valueOf("Muski"), "06311311", "Zrenjanin", "admin33123", "ado11", 11331555, 50000);
	//	podaci.dodajAdmina(adminTest);
	//	podaci.snimiAdmina();
		
	//	System.out.println("Dodaj auto");

	//	Automobil automobili = new Automobil(musterijaTest, MarkaModelDeo.valueOf("OPETASTRA"), 2012, "1600m", "95ks", Gorivo.valueOf("BENZIN"), 9001);
	//	podaci.dodajAutomobil(automobili);
	//	podaci.snimiAutomobil();
	//	System.out.println("Dodato nesto");
		
	//	Deo deo1 = new Deo(MarkaModelDeo.valueOf("OPETASTRA"),"Svecica", 5000, "100012");
	//	podaci.dodajDeo(deo1);
	//	podaci.snimiDeo();
	//	System.out.println("Dodato");
		
	//	Servis servistest = new Servis(automobili, serviserTest, "18.05.2020", "RadSaSvecicama", new ArrayList<Deo>(), Statusi.valueOf("ZAKAZAN"), "1000925");
	//	servistest.getDeo().add(deo1);
	//	podaci.dodajServis(servistest);
	//	podaci.snimiServis();
		System.out.println("Uspesno");
		System.out.println("\n");
		System.out.println("\n AKTUELNI SERVIS-----------------------------------------------------------");
		podaci.ucitajServis();
		
	//	ServisnaKnjizica knjizicaTest = new ServisnaKnjizica(automobili, new ArrayList<Servis>(), "1100236");
	//	knjizicaTest.getServisi().add(servistest);
	//	podaci.dodajKnjizicu(knjizicaTest);
	//	podaci.snimiKnjizicu();
	//	System.out.println("Uspesno");
		System.out.println("\n");
		System.out.println("SERVISNE KNJIZICE--------------------------------------------------------------------------------------------------------");
		podaci.ucitajKnjizicu();
		
		

	}
		

			

}
