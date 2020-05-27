package radSaDatotekama;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import model.automobili.Automobil;
import model.enumeracije.Gorivo;
import model.enumeracije.MarkaModelDeo;
import model.enumeracije.Pol;
import model.enumeracije.Specijalizacija;
import model.enumeracije.Statusi;
import model.korisnici.Admin;
import model.korisnici.Korisnik;
import model.korisnici.Musterija;
import model.korisnici.Serviser;
import model.servis.Deo;
import model.servis.Servis;
import model.servis.ServisnaKnjizica;

public class Datoteke {
	
	private ArrayList<Musterija> musterije;
	private ArrayList<Serviser> serviseri;
	private ArrayList<Admin> admini;
	private ArrayList<Automobil> automobili;
	private ArrayList<Deo> delovi;
	private ArrayList<Servis> servisi;
	private ArrayList<ServisnaKnjizica> knjizice;
	
	
//--------------------------------------------------------------------------------------------------------------------
	public Datoteke() {
		this.musterije = new ArrayList<Musterija>();    //kreiranje novih lista
		this.serviseri = new ArrayList<Serviser>();
		this.admini = new ArrayList<Admin>();
		this.automobili = new ArrayList<Automobil>();
		this.delovi = new ArrayList<Deo>();
		this.servisi = new ArrayList<Servis>();
		this.knjizice = new ArrayList<ServisnaKnjizica>();
	}
	
//-----------------------------------------------------------------------------	---------------------------------------
	public ArrayList<Musterija> getMusterija(){
		return musterije;
		
	}
	public void dodajMusteriju(Musterija musterija) {
		this.musterije.add(musterija);
	}

	
	public Musterija nadjiMusteriju(int IDOznaka) {
		for (Musterija musterija : musterije) {
			if (musterija.getIDOznaka()==(IDOznaka)) {
				return musterija;
			}
		}
		return null;
	}
	
	public void obrisiMusteriju(Musterija musterija) {   //ako obrise musteriju, povuce za sobom i njegov automobil
		musterija.setObrisan(true);
		this.musterije.remove(musterija);
		for(Automobil a:automobili) {
			if(a.getVlasnikId()==musterija.getIDOznaka()) {
				obrisiAutomobil(a);
				
			}
		}
	}
	
	public ArrayList<Musterija> sveNeobrisaneMusterije(){
		ArrayList<Musterija> neobrisane = new ArrayList<Musterija>();
		for(Musterija musterija: musterije) {
			if(musterija.isObrisan()) {
				neobrisane.add(musterija);
			}
		}
		return neobrisane;
	}
//----------------------------------------------------------------------------------------------------------------------------

	
	public void dodajServisera(Serviser serviser) {
		this.serviseri.add(serviser);
	}
	
	public Serviser nadjiServisera(int IDOznaka) {
		for (Serviser serviser : serviseri) {
			if (serviser.getIDOznaka()==(IDOznaka)) {
				return serviser;
			}
		}
		return null;
	}
	
	public void obrisiServisera(Serviser serviser) {
		serviser.setObrisan(true);
		this.serviseri.remove(serviser);
	}
	
	public ArrayList<Serviser> sveNeobrisaniServiseri(){
		ArrayList<Serviser> neobrisane = new ArrayList<Serviser>();
		for(Serviser serviser: serviseri) {
			if(serviser.isObrisan()) {
				neobrisane.add(serviser);
			}
		}
		return neobrisane;
	}

//-----------------------------------------------------------------------------
	
	public ArrayList<Automobil> getAutomobil(){
		return automobili;
	}
	
	public void dodajAutomobil(Automobil automobil) {
		this.automobili.add(automobil);
	}
	public Automobil nadjiAutomobil(int idOznaka) {
		for (Automobil automobil : automobili) {
			if (automobil.getIdOznaka()==(idOznaka)) {
				return automobil;
			}
		}
		return null;
	}
	
	public void obrisiAutomobil(Automobil automobil) {
		automobil.setObrisan(true);
		this.automobili.remove(automobil);   //ako obrise automobil ode i njegov servis
		for(Servis servis: servisi) {
			if(servis.getAutomobilid()==automobil.getIdOznaka()) {  
				obrisiServis(servis);
			}
			
		}
	}
	
	public ArrayList<Automobil> sviNeobrisaniAutomobili(){
		ArrayList<Automobil> neobrisani = new ArrayList<Automobil>();
		for(Automobil automobil: automobili) {
			if(!automobil.isObrisan()) {
				neobrisani.add(automobil);    //posebna lista za neobrisane aute
			}
		}
		
		return neobrisani;
		
		
	}
//------------------------------------------------------------------------------------------------------------------------------------
	
	
	public ArrayList<Admin> getAdmin(){
		return admini;		
	}
	public void dodajAdmina(Admin admin) {
		this.admini.add(admin);
	}

	public void obrisiAdmina(Admin admin) {
		admin.setObrisan(true);
		this.admini.remove(admin);
	}
	
//------------------------------------------------------------------------------------------------------------------------------------------
	
	public ArrayList<Deo> getDeo(){
		return delovi;
	}
	public void dodajDeo(Deo deo) {
		this.delovi.add(deo);
	}

	
	public Deo nadjiDeo(String idOznaka) {
		for (Deo deo : delovi) {
			if(deo.getIdDela().equals(idOznaka)) {
				return deo;
			}
		}
		return null;
	}
	
	public void obrisiDeo(Deo deo) {
		deo.setObrisan(true);
		delovi.remove(deo);
	}

//------------------------------------------------------------------------------------------------------------------------------------------
	
	public ArrayList<Servis> getServis(){
		return servisi;
	}
	
	public void dodajServis(Servis servis) {
		this.servisi.add(servis);
	}
	public void obrisiServis(Servis servis) {
		servis.setObrisan(true);
		this.servisi.remove(servis);
		for(ServisnaKnjizica knjizica: knjizice) {
			if(knjizica.getServisID().equals(servis.getiDoznaka())) {  
				obrisiKnjizicu(knjizica);
			}
			
		}
													
	}
	
	public ArrayList<Servis> sviNeobrisaniServisi(){
		ArrayList<Servis> neobrisani = new ArrayList<Servis>();
		for(Servis servis: servisi) {
			if(!servis.isObrisan()) {
				neobrisani.add(servis);      //pravi listu neobrisanih
			}
		}
		
		return neobrisani;
		
	}
	
//------------------------------------------------------------------------------------------------------------------------------------------
	
	public ArrayList<ServisnaKnjizica> getServisnaKnjizica(){
		return knjizice;
	}
	
	public void dodajKnjizicu(ServisnaKnjizica knjizica) {
		this.knjizice.add(knjizica);
	}
	
	
	public ArrayList<ServisnaKnjizica> getKnjizica(){
		return knjizice;
	}

	public void obrisiKnjizicu(ServisnaKnjizica knjizica) {  //servisna knjizica moze postojati i bez servisa
		knjizica.setObrisan(true);
		this.knjizice.remove(knjizica);                     //izmena se vrsi tako sto se prvo obrise pa se ponovo unese objekat
	}
	
	public ArrayList<ServisnaKnjizica> sveNeobrisaneKnjizice(){
		ArrayList<ServisnaKnjizica> neobrisane = new ArrayList<ServisnaKnjizica>();
		for(ServisnaKnjizica knjizica: knjizice) {
			if(!knjizica.isObrisan()) {
				neobrisane.add(knjizica);
			}
		}
		return neobrisane;
	}
//------------------------------------------------------------------------------------------------------------------------------------------
	
	public Servis nadjiServis(String idOznaka) {
		for (Servis servis : servisi) {
			if (servis.getiDoznaka().equals(idOznaka)) {
				return servis;
			}
		}
		return null;
	}
	

	
//---------------------------------------------------RAD SA MUSTERIJAMA----------------------------------------------------------------------------	

	public void ucitajMusteriju() {
		try {
			File musterijeFile = new File("src/txt/musterija.txt");
			BufferedReader reader = new BufferedReader(new FileReader(musterijeFile));
			String line = null;
			while((line = reader.readLine()) != null){
				String[] split = line.split("\\|");
				int brojSakupljenihBodova = Integer.parseInt(split[9]);
				int IDOznaka = Integer.parseInt(split[0]);
				String indeksPol =split[4];
				Pol pol  = Pol.valueOf(indeksPol);
				boolean obrisan = Boolean.parseBoolean(split[10]);
				Musterija musterija = new Musterija(split[1], split[2], split[3], pol, split[5], split[6], split[7], split[8], IDOznaka,obrisan, brojSakupljenihBodova);
				musterije.add(musterija);
				System.out.println(musterija);
				
			}
			reader.close();
			
									
		}catch(IOException e) {
			System.out.println("Problem sa ocitavanjem");
		}
	}

	public void snimiMusteriju() {
		try {
			File file = new File("src/txt/musterija.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (Musterija musterija : musterije) {
				
				sadrzaj += musterija.toString() +"\n";
			}
			br.write(sadrzaj);
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//-------------------------RAD SA SERVISERIMA----------------------------------------------------------------------------------------*

	public void ucitajServisera() {
		try {
			File serviserFile = new File("src/txt/serviser.txt");
			BufferedReader reader = new BufferedReader(new FileReader(serviserFile));
			String line = null;
			while((line = reader.readLine()) != null){
				String[] split = line.split("\\|");
				int IDOznaka = Integer.parseInt(split[0]);
				String polInt = split[4];
				Pol pol  = Pol.valueOf(polInt);
				double plata = Double.parseDouble(split[9]);
				String indeksSpec = split[10];
				boolean obrisana = Boolean.parseBoolean(split[11]);
				Specijalizacija specijalizacija = Specijalizacija.valueOf(indeksSpec);
				Serviser serviser = new Serviser(split[1], split[2],split[3], pol, split[5], split[6],split[7], split[8], IDOznaka,obrisana, plata, specijalizacija);
				serviseri.add(serviser);
				System.out.println(serviser);
				
			}
			reader.close();
			
									
		}catch(IOException e) {
			System.out.println("Problem sa ocitavanjem");
		}
	}
	
	public void snimiServisera() {
		try {
			File file = new File("src/txt/serviser.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (Serviser serviser : serviseri) {
				
				sadrzaj += serviser.toString() +"\n";
			}
			br.write(sadrzaj);
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	//---------------------RAD SA ADMINIMA--------------------------------------------------------------------
	
	public void ucitajAdmina() {
		try {
			File adminFile = new File("src/txt/admini.txt");
			BufferedReader reader = new BufferedReader(new FileReader(adminFile));
			String line = null;
			while((line = reader.readLine()) != null){
				String[] split = line.split("\\|");
				int IDOznaka = Integer.parseInt(split[0]);
				String indeksPol = split[4];
				Pol pol  = Pol.valueOf(indeksPol);
				double plata = Double.parseDouble(split[9]);
				boolean obrisana = Boolean.parseBoolean(split[3]);
				Admin admin = new Admin(split[1], split[2],split[3], pol, split[5],split[6], split[7], split[8], IDOznaka,obrisana, plata);
				admini.add(admin);
				System.out.println(admin);
				
			}
			reader.close();
			
									
		}catch(IOException e) {
			System.out.println("Problem sa ocitavanjem");
		}
	}

	public void snimiAdmina() {
		try {
			File file = new File("src/txt/admini.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (Admin admin : admini) {
				
				sadrzaj += admin.toString() +"\n";
			}
			br.write(sadrzaj);
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
// ----------------------------------- OCITAVANJE AUTOMOBILA---------------------------------------------------------------------------------------------------
	public void ucitajAutomobil() {
		try {
			File autoFile = new File("src/txt/automobili.txt");
			BufferedReader reader = new BufferedReader(new FileReader(autoFile));
			String line = null;
			while((line = reader.readLine()) != null){
				String[] split = line.split("\\|");
				int id1 = Integer.parseInt(split[0]);
				Musterija IDOznaka = nadjiMusteriju(id1);
				String indeksMarka = split[1];
				MarkaModelDeo markaModel = MarkaModelDeo.valueOf(indeksMarka);
				int godinaProizvodnje = Integer.parseInt(split[2]);
				String indeksGorivo = split[5];
				Gorivo vrstaGoriva = Gorivo.valueOf(indeksGorivo);
				int id = Integer.parseInt(split[6]);
				boolean obrisana = Boolean.parseBoolean(split[7]);
				
				
				Automobil automobil = new Automobil(IDOznaka, markaModel, godinaProizvodnje, split[3], split[4], vrstaGoriva, id,obrisana);
				automobili.add(automobil);
				System.out.println(automobil);
				
			}
			reader.close();
			
									
		}catch(IOException e) {
			System.out.println("Problem sa ocitavanjem");
		}
	}
	
	public void snimiAutomobil() {
		try {
			File file = new File("src/txt/automobili.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (Automobil automobil : automobili) {
				
				sadrzaj += automobil.getVlasnikId() +"|"+ automobil.toString2() +"\n";
			}
			br.write(sadrzaj);
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
//    -------------------------- OCITAVANJE SERVISA	---------------------------------------------------------------------------------------------
	
	public void ucitajDeo() {
		try {
			File deoFile = new File("src/txt/deo.txt");
			BufferedReader reader = new BufferedReader(new FileReader(deoFile));
			String line = null;
			while((line = reader.readLine()) != null){
				String[] split = line.split("\\|");
				String markaindex = split[0];
				String naziv = split[1];
				MarkaModelDeo markamodel = MarkaModelDeo.valueOf(markaindex);
				double cena = Double.parseDouble(split[2]);
				String id = split[3];
				boolean obrisana = Boolean.parseBoolean(split[4]);
				Deo deo = new Deo(markamodel, naziv, cena, id,obrisana);
				delovi.add(deo);
				System.out.println(deo);
				
			}
			reader.close();
			
									
		}catch(IOException e) {
			System.out.println("Problem sa ocitavanjem");
		}
	}
	
	
	
	public void snimiDeo() {
		try {
			File file = new File("src/txt/deo.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (Deo deo : delovi) {
				
				sadrzaj += deo.toString() +"\n";
			}
			br.write(sadrzaj);
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//--------------------------------------------------------------------------------------------------------------------------------------------------
	public static ArrayList<Deo> getIdDela(String[] delovi){
		ArrayList<Deo> delovi1 = new ArrayList<Deo>();
		
		for (int i = 0; i < delovi.length; i++) {
			String idStr = delovi[i];
			for (Deo deo : delovi1) {
				if(idStr.equals(deo.getIdDela())) {
					delovi1.add(deo);
				}
			}
			
		}
		return delovi1;
		
	}
	
	public ArrayList<Deo> sviNeobrisaniDelovi(){
		ArrayList<Deo> neobrisani = new ArrayList<Deo>();
		for(Deo deo: delovi) {
			if(!deo.isObrisan()) {
				neobrisani.add(deo);    //posebna lista za neobrisane aute
			}
		}
		
		return neobrisani;
		
		
	}
	
//-----------------------RAD SA SERVISOM---------------------------------------------------------------------------------------	
	
	public void ucitajServis() {
		try {
			File servisFile = new File("src/txt/servis.txt");
			BufferedReader reader = new BufferedReader(new FileReader(servisFile));
			String line = null;
			while((line = reader.readLine()) != null){
				String[] split = line.split("\\|");
				int id1 = Integer.parseInt(split[0]);
				Automobil idOznaka = nadjiAutomobil(id1);
				int idserv = Integer.parseInt(split[1]);
				Serviser idServisera = nadjiServisera(idserv);
				String delovi1 = split[3];
				String statusIndex = split[6];
				Statusi statusi = Statusi.valueOf(statusIndex);
				String idoznaka = split[7];
				boolean obrisan = Boolean.parseBoolean(split[8]);
				
				String[] deloviSplit = delovi1.split(";");
				ArrayList<Deo> deo2 = new ArrayList<Deo>();
				for (String sif : deloviSplit) {
					Deo d = nadjiDeo(sif);
					if(d != null) {
						deo2.add(d);
						
					}
					
				}
				Servis servis = new Servis(idOznaka, idServisera, split[2], split[5], deo2, statusi, idoznaka,obrisan);
				servisi.add(servis);
				System.out.println(servis);
				
			}
			reader.close();
			
									
		}catch(IOException e) {
			System.out.println("Problem sa ocitavanjem");
		}
	}	
	public void snimiServis() {
		try {
			File file = new File("src/txt/servis.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file,true));
			String sadrzaj = "";
			for (Servis servis : servisi) {
			
				sadrzaj += servis.getAutomobilid() +"|" + servis.getServiserid() +"|" + servis.getTermin() + "|" + String.join(";", servis.getDeoID())  +"|"+ servis.toString2() + "\n";
			}
			br.write(sadrzaj);
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
	}
	}
	
//--------------------------------RAD SA KNJIZICOM----------------------------------------------------------------------------------------
	
	public void ucitajKnjizicu() {
		try {
			File knjiziceFile = new File("src/txt/knjizica.txt");
			BufferedReader reader = new BufferedReader(new FileReader(knjiziceFile));
			String line = null;
			while((line = reader.readLine()) != null){
				String[] split = line.split("\\|");
				//int id1 = Integer.parseInt(split[0]);
			//	Automobil idOznaka = nadjiAutomobil(id1);		
				//int idserv = Integer.parseInt(split[1]);
				//Serviser idServisera = nadjiServisera(idserv);
				String servis1 = split[1];
				String idoznaka = split[0];
				boolean obrisana = Boolean.parseBoolean(split[2]);
				
				String[] servisSplit = servis1.split(";");
				ArrayList<Servis> servisi1 = new ArrayList<Servis>();
				for (String sif : servisSplit) {
					Servis s = nadjiServis(sif);
					if(s!=null) {
						servisi1.add(s);
					}
					
				}			
				ServisnaKnjizica knjizica = new ServisnaKnjizica(servisi1, idoznaka,obrisana);
				knjizice.add(knjizica);
				System.out.println(knjizica);
				
			}
			reader.close();
			
									
		}catch(IOException e) {
			System.out.println("Problem sa ocitavanjem");
		}
	}

	
	public void snimiKnjizicu() {
		try {
			File file = new File("src/txt/knjizica.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file,true));
			String sadrzaj = "";
			for (ServisnaKnjizica knjizica : knjizice) {
				
				sadrzaj += knjizica.getIdOznaka()  + "|" + String.join(";", knjizica.getServisID()) +"|" +knjizica.isObrisan()+"\n";
			}
			br.write(sadrzaj);
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	

	

	

//----------------------------------------------------------------------------------------------------------------------------
	
	
	
	
//----------------------------------------------------------------------------------------------------------------------------------------------------
	

