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
		
		
		
	//	Musterija musterijaTest = new Musterija("Zivojin", "Jovanovic", "116300322", Pol.valueOf("Muski"), "06538888", "Alibunar", "ali123", "12345", 222344, false, 2);
	//	podaci.dodajMusteriju(musterijaTest);
	//	podaci.snimiMusteriju();
		//System.out.println(musterijaTest);

	//	System.out.println("dodato");
	//	System.out.println("Dodavanje servisera");
		
		
		
	//	Serviser serviserTest = new Serviser("Jovica", "Peric", "133234342195", Pol.valueOf("Muski"), "0643563", "Orlovat", "jovicaservis", "servis11123", 2123311444,false,30300, Specijalizacija.valueOf("AUTOELEKTRICAR"));
	//	podaci.dodajServisera(serviserTest);
//		podaci.snimiServisera();
//		System.out.println("dODATO");
		
		
	//	Admin adminTest = new Admin("Nikola", "Dzonic", "343243234", Pol.valueOf("Muski"), "06331311", "Zrenjanin", "admin33123", "ado11", 11331555, false,60000);
	//	podaci.dodajAdmina(adminTest);
	//	podaci.snimiAdmina();
		
	//	System.out.println("Dodaj auto");

	//	Automobil automobili = new Automobil(musterijaTest, MarkaModelDeo.valueOf("TOYOTACOROLLA"), 1993, "1300m", "110ks", Gorivo.valueOf("BENZIN"), 9020,false);
	//	podaci.dodajAutomobil(automobili);
	//	podaci.snimiAutomobil();
	//	System.out.println("Dodato nesto");
		
	//	Deo deo1 = new Deo(MarkaModelDeo.valueOf("TOYOTACOROLLA"),"Volan", 8000, "100060",false);
	//	podaci.dodajDeo(deo1);
	//	podaci.snimiDeo();
	//	System.out.println("Dodato");
		
//		Servis servistest = new Servis(automobili, serviserTest, "26.05.2020", "Zamena Volana", new ArrayList<Deo>(), Statusi.valueOf("ZAKAZAN"), "100140",false);
//		servistest.getDeo().add(deo1);
	//	podaci.dodajServis(servistest);
	//	podaci.snimiServis();
	//	System.out.println("Uspesno");
		System.out.println("\n");
		System.out.println("\n AKTUELNI SERVIS-----------------------------------------------------------");
		podaci.ucitajServis();
		
	//	ServisnaKnjizica knjizicaTest = new ServisnaKnjizica(new ArrayList<Servis>(), "111333",false);
	//	knjizicaTest.getServisi().add(servistest);
	//	podaci.dodajKnjizicu(knjizicaTest);
	//	podaci.snimiKnjizicu();
		System.out.println("Uspesno");
		System.out.println("\n");
		System.out.println("SERVISNE KNJIZICE--------------------------------------------------------------------------------------------------------");
		podaci.ucitajKnjizicu();
		
		

	}
		

			

}
