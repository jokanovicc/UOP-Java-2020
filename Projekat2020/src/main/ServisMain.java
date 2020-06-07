package main;

import java.util.ArrayList;

import gui.LoginProzor;
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
		podaci.ucitajServisera();	
		podaci.ucitajMusteriju();
		podaci.ucitajAdmina();
		podaci.ucitajDeo();
		podaci.ucitajAutomobil();
		podaci.ucitajServis();
		podaci.ucitajKnjizicu();
		//------------------------------------------------------------------------------------------------------------------
		
		LoginProzor lp = new LoginProzor(podaci);
		lp.setVisible(true);
		

	

	

	}
}
