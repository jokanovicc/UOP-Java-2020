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
		
		
		//Ocitanje sadrzaja iz lista svih
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
		System.out.println("\n");
		System.out.println("\n AKTUELNI SERVIS-----------------------------------------------------------");
		podaci.ucitajServis();
		System.out.println("\n");
		System.out.println("SERVISNE KNJIZICE--------------------------------------------------------------------------------------------------------");
		podaci.ucitajKnjizicu();
		//------------------------------------------------------------------------------------------------------------------
		
		
		//BLOK ZA DODAVANJE I SNIMANJE
		Musterija musterijaTest = new Musterija("Goran", "Ilic", "1703242", Pol.valueOf("Muski"), "065910002", "Novi Sad", "gogi", "123", 1222211, false, 1);
		podaci.dodajMusteriju(musterijaTest);
		podaci.snimiMusteriju();

		Serviser serviserTest = new Serviser("Perica", "Peric", "13324", Pol.valueOf("Muski"), "0613424", "Zabalj", "pericaservis", "servis11123", 21321312,false,30300, Specijalizacija.valueOf("AUTOELEKTRICAR"));
		podaci.dodajServisera(serviserTest);
		podaci.snimiServisera();

		
		
	//	Admin adminTest = new Admin("Nikola", "Dzonic", "343243234", Pol.valueOf("Muski"), "06331311", "Zrenjanin", "admin33123", "ado11", 11331555, false,60000);
	//	podaci.dodajAdmina(adminTest);
	//	podaci.snimiAdmina();
		
	//	podaci.izmeniAdmina("Jovan", "Jankovic", "12031991023", Pol.valueOf("Muski"), "0644322", "Beograd", "jovan12", "jovan123",11331555 , false, 80000);
	//	podaci.snimiAdmina();

		Automobil automobili = new Automobil(musterijaTest, MarkaModelDeo.valueOf("FIATSTILO"), 2002, "1900m", "110ks", Gorivo.valueOf("DIZEL"), 20100,false);
		podaci.dodajAutomobil(automobili);
		podaci.snimiAutomobil();


	//	Deo deo2= new Deo(MarkaModelDeo.valueOf("TOYOTACOROLLA"),"Desna strana motora", 8000, "100060",false);
		
	//	deo2.kreirajSimetricniDeo(deo2);
	//	podaci.dodajDeo(deo2);
	//	podaci.snimiDeo();
		Deo deo3= new Deo(MarkaModelDeo.valueOf("FIATSTILO"),"Desni zmigavac", 1000, "102330",false);
//
		
		Servis servistest = new Servis(automobili, serviserTest, "02.06.2020", "Zamena Migavca", new ArrayList<Deo>(), Statusi.valueOf("ZAKAZAN"), "102255",false);
		servistest.getDeo().add(deo3);	
		podaci.dodajServis(servistest);
		podaci.snimiServis();	

		
		ServisnaKnjizica knjizicaTest = new ServisnaKnjizica(new ArrayList<Servis>(), "111555",false);
		knjizicaTest.getServisi().add(servistest);
		podaci.dodajKnjizicu(knjizicaTest);
		podaci.snimiKnjizicu();
	//	podaci.obrisiKnjizicu(knjizicaTest);
		
		
		
		
		podaci.obrisiMusteriju(musterijaTest);
		
		System.out.println("\n Liste-------------------------------------------");
		IspisiSvepodatke(podaci);  //Vuce sve iz lista pravih
		
		
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
