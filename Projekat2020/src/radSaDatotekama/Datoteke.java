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
import java.util.GregorianCalendar;

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
	
	
//MODUL SLUZI ZA RAD SA DATOTEKAMA, LOGIKA ZA CITANJE, SNIMANJE, PRIKAZIVANJE, FORMIRANJE LISTA	
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
		this.musterije.add(musterija);                     //Samo doda u vec postojecu listu
	}

	
	public Musterija nadjiMusteriju(String IDOznaka) {
		for (Musterija musterija : musterije) {                //OVO MI TREBA KAD REFERENCIRAM
			if (musterija.getIDOznaka().equals(IDOznaka)) {
				return musterija;
			}
		}
		return null;
	}
	
	public void obrisiMusteriju(Musterija musterija) {   //ako obrise musteriju, povuce za sobom i njegov automobil
		musterija.setObrisan(true);
	//	musterije.remove(musterija);
	//	dodajMusteriju(musterija);             //OVO CE KREIRATI LANAC BRISANJA
		snimiMusteriju();
		for(Automobil a:automobili) {
			if(a.getVlasnikId().equals(musterija.getIDOznaka())) {
				obrisiAutomobil(a);                              //brise se i auto, takodje i servis samog auta
															//knjizica moze ostati u sistemu, nju je potrebno nezavisno obrisati
				
			}
		}
	}
	
	
	public ArrayList<Musterija> sveNeobrisaneMusterije(){
		ArrayList<Musterija> neobrisane = new ArrayList<Musterija>();
		for(Musterija musterija: musterije) {                   //lista neobrisanih musterija
			if(!musterija.isObrisan()) {
				neobrisane.add(musterija);
			}
		}
		return neobrisane;
	}
	
	
	
	
	public void izmeniMusteriju(String ime, String prezime, String jmbg, Pol pol, String brojTelefona, String adresa,    
	String username, String lozinka, String iDOznaka, boolean obrisan, int brojSakupljenihBodova) {     //metode prima objekta kao parametre
		for(Musterija musterija:musterije) {
			if(musterija.getIDOznaka() == iDOznaka) {      //id se ne sme menjati
				musterija.setIme(ime);
				musterija.setPrezime(prezime);         //setuje atribute samo
				musterija.setJmbg(jmbg);
				musterija.setPol(pol);
				musterija.setBrojTelefona(brojTelefona);
				musterija.setAdresa(adresa);
				musterija.setUsername(username);
				musterija.setLozinka(lozinka);
				musterija.setObrisan(obrisan);
				musterija.setBrojSakupljenihBodova(brojSakupljenihBodova);
			
			}
		}
	//	snimiMusteriju();
	}
	

//----------------------------------------------------------------------------------------------------------------------------

	
	public void dodajServisera(Serviser serviser) {
		this.serviseri.add(serviser);
	}
	
	public Serviser nadjiServisera(String IDOznaka) {
		for (Serviser serviser : serviseri) {
			if (serviser.getIDOznaka().equals(IDOznaka)) {
				return serviser;
			}
		}
		return null;
	}
	
	public void obrisiServisera(Serviser serviser) {
		serviser.setObrisan(true);
		musterije.remove(serviser);
		//dodajServisera(serviser);                            //ako obrises servisera, obrisaces i servis
		snimiServisera();
		for(Servis servis : servisi) {
			if(serviser.getIDOznaka().equals(servis.getServiserid())) {
				obrisiServis(servis);                                   //NADOVEZUJE SE NA PRETHODNO BRISANJE
			}
		}
	}
	
	public ArrayList<Serviser> sveNeobrisaniServiseri(){
		ArrayList<Serviser> neobrisane = new ArrayList<Serviser>();
		for(Serviser serviser: serviseri) {
			if(!serviser.isObrisan()) {
				neobrisane.add(serviser);
			}
		}
		return neobrisane;
	}
	
	
	public void izmeniServisera(String ime, String prezime, String jmbg, Pol pol, String brojTelefona, String adresa,
			String username, String lozinka, String iDOznaka, boolean obrisan, double plata,
			Specijalizacija specijalizacija) {
		for(Serviser serviser:serviseri) {
			if(serviser.getIDOznaka() == iDOznaka) {
				serviser.setIme(ime);
				serviser.setPrezime(prezime);
				serviser.setJmbg(jmbg);
				serviser.setPol(pol);
				serviser.setBrojTelefona(brojTelefona);            //IZMENA SERVISA
				serviser.setAdresa(adresa);
				serviser.setUsername(username);
				serviser.setLozinka(lozinka);
				serviser.setPlata(plata);
				serviser.setObrisan(obrisan);
				serviser.setSpecijalizacija(specijalizacija);
			}
		}
		
	//	snimiServisera();
	}

//-----------------------------------------------------------------------------
	
	public ArrayList<Automobil> getAutomobil(){
		return automobili;
	}
	
	public void dodajAutomobil(Automobil automobil) {
		this.automobili.add(automobil);
	}
	public Automobil nadjiAutomobil(String idOznaka) {
		for (Automobil automobil : automobili) {
			if (automobil.getIdOznaka().equals(idOznaka)) {
				return automobil;
			}
		}
		return null;
	}
	
	public void obrisiAutomobil(Automobil automobil) {
		automobil.setObrisan(true);
		snimiAutomobil();
		
		for(Servis servis: servisi) {
			if(servis.getAutomobilid().equals(automobil.getIdOznaka())) {
				obrisiServis(servis);                                        //brisanjem auta ode i njegov servis

				
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
	
	
	public void izmeniAutomobil(Musterija vlasnik, MarkaModelDeo markaModel, int godinaProizvodnje, String zapreminaMotora,
			String snaga, Gorivo vrstaGoriva, String idOznaka, boolean obrisan) {
		for(Automobil automobil:automobili) {
			if(automobil.getIdOznaka() == idOznaka) {
				automobil.setVlasnik(vlasnik);
				automobil.setMarkaModel(markaModel);
				automobil.setGodinaProizvodnje(godinaProizvodnje);
				automobil.setZapreminaMotora(zapreminaMotora);
				automobil.setSnaga(snaga);
				automobil.setVrstaGoriva(vrstaGoriva);
				automobil.setObrisan(obrisan);
				
			}
		}
		
		//snimiAutomobil();
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
		snimiAdmina();
	}
	
	public Admin nadjiAdmina(String idOznaka) {
		for (Admin admin: admini) {
			if(admin.getIDOznaka().equals(idOznaka)) {
				return admin;
			}
		}
		return null;
	}
	
	
	public void izmeniAdmina(String ime, String prezime, String jmbg, Pol pol, String brojTelefona, String adresa, String username,
			String lozinka, String iDOznaka, boolean obrisan, double plata) {
		for(Admin admin:admini) {
			if(admin.getIDOznaka()==iDOznaka) {
				admin.setIme(ime);
				admin.setPrezime(prezime);
				admin.setJmbg(jmbg);
				admin.setBrojTelefona(brojTelefona);
				admin.setAdresa(adresa);
				admin.setUsername(username);
				admin.setLozinka(lozinka);
				admin.setObrisan(obrisan);
				admin.setPlata(plata);
			}
		}
	//		snimiAdmina();
	}
	
	
	public ArrayList<Admin> sveNeobrisaneAdmini(){
		ArrayList<Admin> neobrisane = new ArrayList<Admin>();
		for(Admin admin: admini) {                   //lista neobrisanih musterija
			if(!admin.isObrisan()) {
				neobrisane.add(admin);
			}
		}
		return neobrisane;
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
		snimiDeo();
	}
	
	
	public void izmeniDeo(MarkaModelDeo automobil, String naziv, double cena, String idDela, boolean obrisano) {
		for(Deo deo: delovi) {
			if(deo.getIdDela() == idDela) {
				deo.setAutomobil(automobil);
				deo.setNaziv(naziv);
				deo.setCena(cena);
				deo.setObrisan(obrisano);
				
			}
		}
		//snimiDeo();
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
		snimiServis();

	}
	
	
	
	public Servis nadjiServis(String idOznaka) {
		for (Servis servis : servisi) {
			if (servis.getiDoznaka().equals(idOznaka)) {   //U SLUCAJU DA ZELIMO OBRISATI SAMO SERVIS, BEZ DIRANJA KNJIZICE...
				return servis;
			}
		}
		return null;
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
	
	public void izmeniServis(Automobil automobil, Serviser serviser, GregorianCalendar termin, String opis, ArrayList<Deo> deo,
			Statusi status, String iDoznaka, boolean obrisan, double troskovi) {
		for(Servis servis: servisi) {
			if(servis.getiDoznaka().equals(iDoznaka)) {
				servis.setAutomobil(automobil);
				servis.setServiser(serviser);
				servis.setTermin(termin);
				servis.setOpis(opis);
				servis.setDeo(deo);
				servis.setStatus(status);
				servis.setObrisan(obrisan);
				servis.setTroskovi(troskovi);
			
			}
		}
		
		//snimiServis();
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

	public void obrisiKnjizicu(ServisnaKnjizica knjizica) {  //servisna knjizica moze postojati i bez servisa, ona se sama brise
		knjizica.setObrisan(true);
		snimiKnjizicu();

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
	
	
	public void izmeniKnjizicu(ArrayList<Servis> servisi, String idOznaka, boolean obrisan) {
		for(ServisnaKnjizica knjizica:knjizice) {
			if(knjizica.getIdOznaka().equals(idOznaka)) {
				knjizica.setServisi(servisi);
				knjizica.setIdOznaka(idOznaka);
				knjizica.setObrisan(obrisan);
			}
		}
		//snimiKnjizicu();
	}

	public ServisnaKnjizica nadjiKnjizicu2(String idOznaka) {
		for (ServisnaKnjizica knjizica : knjizice) {
			if (knjizica.getIdOznaka().equals(idOznaka)) {   //U SLUCAJU DA ZELIMO OBRISATI SAMO SERVIS, BEZ DIRANJA KNJIZICE...
				return knjizica;
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
				int brojSakupljenihBodova = Integer.parseInt(split[9]);         //CITA
				String IDOznaka = split[0];
				int polInt = Integer.parseInt(split[4]);
				Pol pol = Pol.values()[polInt];
				boolean obrisan = Boolean.parseBoolean(split[10]);
				Musterija musterija = new Musterija(split[1], split[2], split[3], pol, split[5], split[6], split[7], split[8], IDOznaka,obrisan, brojSakupljenihBodova);
				musterije.add(musterija);
				
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
			for (Musterija musterija : musterije) {              //SNIMA
				
				sadrzaj += musterija.toString2() +"\n";
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
				String IDOznaka = split[0];
				int polInt = Integer.parseInt(split[4]);
				Pol pol = Pol.values()[polInt];;
				double plata = Double.parseDouble(split[9]);
				boolean obrisana = Boolean.parseBoolean(split[11]);
				int specInt = Integer.parseInt(split[10]);
				Specijalizacija specijalizacija = Specijalizacija.values()[specInt];;
				Serviser serviser = new Serviser(split[1], split[2],split[3], pol, split[5], split[6],split[7], split[8], IDOznaka,obrisana, plata, specijalizacija);
				serviseri.add(serviser);
				
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
				
				sadrzaj += serviser.toString2() +"\n";
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
				String IDOznaka = split[0];
				int polInt = Integer.parseInt(split[4]);
				Pol pol = Pol.values()[polInt];
				double plata = Double.parseDouble(split[9]);
				boolean obrisana = Boolean.parseBoolean(split[3]);
				Admin admin = new Admin(split[1], split[2],split[3], pol, split[5],split[6], split[7], split[8], IDOznaka,obrisana, plata);
				admini.add(admin);
				
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
				
				sadrzaj += admin.toString2() +"\n";
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
				String id1 = split[0];
				Musterija IDOznaka = nadjiMusteriju(id1);
				int autoInt = Integer.parseInt(split[1]);
				MarkaModelDeo markaModel = MarkaModelDeo.values()[autoInt];
				int godinaProizvodnje = Integer.parseInt(split[2]);
				int gorivoInt = Integer.parseInt(split[5]);
				Gorivo vrstaGoriva = Gorivo.values()[gorivoInt];
				String id = split[6];
				boolean obrisana = Boolean.parseBoolean(split[7]);
				
				
				Automobil automobil = new Automobil(IDOznaka, markaModel, godinaProizvodnje, split[3], split[4], vrstaGoriva, id,obrisana);
				automobili.add(automobil);
				
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
				
				sadrzaj += automobil.toString2() +"\n";
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
				String naziv = split[1];
				int autoInt = Integer.parseInt(split[0]);
				MarkaModelDeo markamodel = MarkaModelDeo.values()[autoInt];
				double cena = Double.parseDouble(split[2]);
				String id = split[3];
				boolean obrisana = Boolean.parseBoolean(split[4]);
				Deo deo = new Deo(markamodel, naziv, cena, id,obrisana);
				delovi.add(deo);
				
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
				
				sadrzaj += deo.toString2() +"\n";
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
		return delovi1;                                        //OVI DELOVI MI TREBAJU ZA SERVIS KASNIJE
		
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
				String id1 = split[0];
				Automobil idOznaka = nadjiAutomobil(id1);
				String idserv =split[1];
				GregorianCalendar termin = Servis.StringToGregorian(split[2]);
				Serviser idServisera = nadjiServisera(idserv);
				String delovi1 = split[3];
				int opisInt = Integer.parseInt(split[6]);
				Statusi statusi = Statusi.values()[opisInt];
				String idoznaka = split[7];
				String troskoviStr = split[8];
				double troskovi = Double.parseDouble(troskoviStr);
				boolean obrisan = Boolean.parseBoolean(split[9]);
				
				String[] deloviSplit = delovi1.split(";");
				ArrayList<Deo> deo2 = new ArrayList<Deo>();
				for (String sif : deloviSplit) {
					Deo d = nadjiDeo(sif);
					if(d != null) {
						deo2.add(d);
						
					}
					
				}
				Servis servis = new Servis(idOznaka, idServisera, termin, split[5], deo2, statusi, idoznaka,obrisan,troskovi);
				servisi.add(servis);
				
			}
			reader.close();
			
									
		}catch(IOException e) {
			System.out.println("Problem sa ocitavanjem");
		}
	}	
	public void snimiServis() {
		try {
			File file = new File("src/txt/servis.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (Servis servis : servisi) {
			
				sadrzaj += servis.getAutomobilid() +"|" + servis.getServiserid() +"|" +servis.getTerminSimpleDate() +"|" +String.join(";", servis.getDeoID()) +"|"+ servis.toString2() + "\n";
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
				
			}
			reader.close();
			
									
		}catch(IOException e) {
			System.out.println("Problem sa ocitavanjem");
		}
	}

	
	public void snimiKnjizicu() {
		try {
			File file = new File("src/txt/knjizica.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (ServisnaKnjizica knjizica : knjizice) {
				
				sadrzaj += knjizica.getIdOznaka()  + "|" + String.join(";", knjizica.getServisID()) +"|" +knjizica.isObrisan()+"\n";
				
				
			}
			br.write(sadrzaj);
			System.out.println(sadrzaj);
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Korisnik login(String korisnickoIme, String sifra) {
		for(Musterija m : musterije) {        //funkcije za login
			if(!m.isObrisan()) {                //provera jel obrisano
				if(m.getUsername().equals(korisnickoIme) && m.getLozinka().equals(sifra)) {    //provera sa geterima
					return m;
				}
				
			}
		}
		
		for(Serviser s : serviseri) {
			if(!s.isObrisan()) {
				if(s.getUsername().equals(korisnickoIme) && s.getLozinka().equals(sifra)) {
					return s;
				}
				
			}

		}
		
		for(Admin a: admini) {
			if(!a.isObrisan()) {
				if(a.getUsername().equals(korisnickoIme) && a.getLozinka().equals(sifra)) {
					return a;
				}
				
			}
		
			
		}
		
		return null;
		
	}
	
	public ArrayList<Musterija> musterijaPrikaz(Korisnik prijavljenKorisnik){
		ArrayList<Musterija> jedna = new ArrayList<Musterija>();
		for(Musterija musterija: musterije) {
			if(prijavljenKorisnik.getIDOznaka().equals(musterija.getIDOznaka())) {
				jedna.add(musterija);
			}
		}
		return jedna;
	}
	
	public ArrayList<Serviser> serviserPrikaz(String prijavljenKorisnik){
		ArrayList<Serviser> jedna = new ArrayList<Serviser>();
		for(Serviser serviser: sveNeobrisaniServiseri()) {
			if(prijavljenKorisnik.equals(serviser.getIDOznaka())) {
				jedna.add(serviser);
			}
		}
		return jedna;
	}
	
	public ArrayList<Automobil> autoPrikaz(String id){
		ArrayList<Automobil> auto = new ArrayList<Automobil>();
		for(Automobil automobil: sviNeobrisaniAutomobili()) {
			if(id.equals(automobil.getVlasnikId())) {
				auto.add(automobil);
			}
		}
		return auto;
	}
	
	public ArrayList<Servis> servisPrikaz(String prijavljenKorisnik){
		ArrayList<Servis> servisprikaz = new ArrayList<Servis>();
		for(Servis servis: sviNeobrisaniServisi()) {
			if(prijavljenKorisnik.equals(servis.getVlasnikID())){
				servisprikaz.add(servis);
				
				
			}
			
			
		}
		return servisprikaz;
	}
	
	public ArrayList<Servis> servisServisera(String idServisera){
		ArrayList<Servis> servisServisera = new ArrayList<Servis>();
		for(Servis servis: sviNeobrisaniServisi()) {
			if(idServisera.equals(servis.getServiserid())){
				servisServisera.add(servis);
			//	return servisServisera;
				
			}
			
			
		}
		return servisServisera;
	}



	

	
	}




