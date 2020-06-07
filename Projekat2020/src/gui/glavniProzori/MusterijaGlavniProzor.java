package gui.glavniProzori;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.korisnici.Korisnik;
import radSaDatotekama.Datoteke;

public class MusterijaGlavniProzor extends JFrame {
	private JMenuBar mainMenu  = new JMenuBar();
	private JMenu korisniciMenu = new JMenu("Vase informacije");
	private JMenuItem musterijaItem = new JMenuItem("Pregled informacija");
	private JMenu servisMenu = new JMenu("Aktuelni servis");
	private JMenuItem servisItem = new JMenuItem("Servis");
	private JMenuItem knjizicaItem = new JMenuItem("Servisna knjizica");
	private JMenu automobilMeni = new JMenu("Vas Automobil");
	private JMenuItem automobilItem = new JMenuItem("Prikaz Automobila");
	//JLabel lblLogo = new JLabel(new ImageIcon("src/slike/admin.png"));
	JLabel lblLogo = new JLabel(new ImageIcon("src/slike/musterija.png"));

	
	private Datoteke podaci;
	private Korisnik prijavljenKorisnik;
	
	
	public MusterijaGlavniProzor(Datoteke podaci, Korisnik prijavljenKorisnik) {
		this.podaci = podaci;
		this.prijavljenKorisnik = prijavljenKorisnik;
		
		setTitle("Musterija: " + prijavljenKorisnik.getIme() + " " + prijavljenKorisnik.getPrezime());
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initMenu();
		initActions();
		
	}
	
	public void initMenu() {
		setJMenuBar(mainMenu);
		add(lblLogo);
		mainMenu.add(korisniciMenu);
		korisniciMenu.add(musterijaItem);
		
		mainMenu.add(automobilMeni);
		automobilMeni.add(automobilItem);
		
		mainMenu.add(servisMenu);
		servisMenu.add(servisItem);
		servisMenu.add(knjizicaItem);
		
		
	}
	
	public void initActions() {
		
	}
	
	
	
}
