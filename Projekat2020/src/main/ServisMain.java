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
	public static Datoteke podaci = new Datoteke();
     
	


	public static void main(String[] args) {
	//	Datoteke podaci = new Datoteke();
		
		
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
		podaci.ucitajServis();
		podaci.ucitajKnjizicu();
		
		
		
		
		Musterija musterijaTest = new Musterija("Dragan", "Petro", "2000", Pol.valueOf("Muski"), "063434", "Konak", "gagi", "123", 11111111, false, 2);
		podaci.dodajMusteriju(musterijaTest);
		podaci.snimiMusteriju();
	//	podaci.dodajMusteriju(musterijaTest);
	//	podaci.snimiMusteriju();
	//	Musterija musterijaTest2 = new Musterija("izmena", "Mf2223dic", "113434", Pol.valueOf("Muski"), "065348888", "Alibunar", "al434", "121", 2344, false, 2);
	//	podaci.IzmeniMusteriju(musterijaTest, musterijaTest2);
		
		
		
		
	//	System.out.println(musterijaTest);

		System.out.println("dodato");
		System.out.println("Dodavanje servisera");
		
		
		
	Serviser serviserTest = new Serviser("Jovica", "Peric", "133234342195", Pol.valueOf("Muski"), "0643563", "Orlovat", "jovicaservis", "servis11123", 2123311444,false,30300, Specijalizacija.valueOf("AUTOELEKTRICAR"));
		podaci.dodajServisera(serviserTest);
		podaci.snimiServisera();
	//	System.out.println("dODATO");
		
		
	//	Admin adminTest = new Admin("Nikola", "Dzonic", "343243234", Pol.valueOf("Muski"), "06331311", "Zrenjanin", "admin33123", "ado11", 11331555, false,60000);
	//	podaci.dodajAdmina(adminTest);
	//	podaci.snimiAdmina();
		


		Automobil automobili = new Automobil(musterijaTest, MarkaModelDeo.valueOf("TOYOTACOROLLA"), 1998, "1300m", "110ks", Gorivo.valueOf("BENZIN"), 90100,false);
		podaci.dodajAutomobil(automobili);
		podaci.snimiAutomobil();

		
		
		
		
		
		
		
		
	//	Deo deo2= new Deo(MarkaModelDeo.valueOf("TOYOTACOROLLA"),"Desna strana motora", 8000, "100060",false);
		
	//	deo2.kreirajSimetricniDeo(deo2);
	//	podaci.dodajDeo(deo2);
	//	podaci.snimiDeo();
		Deo deo3= new Deo(MarkaModelDeo.valueOf("TOYOTACOROLLA"),"Desna fdfdfora", 23, "100060",false);
//
		
		Servis servistest = new Servis(automobili, serviserTest, "31.05.2020", "Zamena", new ArrayList<Deo>(), Statusi.valueOf("ZAKAZAN"), "10123",false);
		servistest.getDeo().add(deo3);	
		podaci.dodajServis(servistest);
		podaci.snimiServis();	

		
		
		
		System.out.println("\n");
		System.out.println("\n AKTUELNI SERVIS-----------------------------------------------------------");
		
		ServisnaKnjizica knjizicaTest = new ServisnaKnjizica(new ArrayList<Servis>(), "111333",false);
		knjizicaTest.getServisi().add(servistest);
		podaci.dodajKnjizicu(knjizicaTest);
		podaci.snimiKnjizicu();
		System.out.println("\n");
		System.out.println("SERVISNE KNJIZICE--------------------------------------------------------------------------------------------------------");
		podaci.obrisiKnjizicu(knjizicaTest);
		
		System.out.println("\n Liste-------------------------------------------");
	//	IspisiSvepodatke(podaci);
		
		

		podaci.obrisiMusteriju(musterijaTest);
//		podaci.obrisiServisera(serviserTest);
	}
	
	public static void IspisiSvepodatke(Datoteke datoteke) {
		for (Musterija musterija: datoteke.getMusterija()) {
			System.out.println(musterija + "\n");
			
		}
		
		for(Automobil automobil : datoteke.getAutomobil()) {
			System.out.println("\n"+automobil + "\n");
		}
		
		for(ServisnaKnjizica knjizica : datoteke.getServisnaKnjizica()) {
			System.out.println("\n"+knjizica + "\n");
		}
		
		for(Servis servisi : datoteke.getServis()) {
			System.out.println("\n"+servisi + "\n");
		}
		for(Musterija musterija : datoteke.sveNeobrisaneMusterije()) {
			System.out.println("-------------------------------\n"+musterija + "\n");
		}
		
		
		
	}
	

	

}
