package gui.glavniProzori;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.korisnici.Korisnik;
import radSaDatotekama.Datoteke;

public class ServiserGlavniProzor extends JFrame {
	private JMenuBar mainMenu  = new JMenuBar();
	private JMenu korisniciMenu = new JMenu("Korisnici");
	private JMenuItem musterijeItem = new JMenuItem("Musterije");
	private JMenuItem serviseriItem = new JMenuItem("Serviseri");

	private JMenu servisMenu = new JMenu("Servis");
	private JMenuItem servisItem = new JMenuItem("Servisi");
	private JMenuItem knjizicaItem = new JMenuItem("Servisna knjizica");
	private JMenuItem deoItem = new JMenuItem("Delovi");
	private JMenu automobilMeni = new JMenu("Automobili");
	private JMenuItem automobilItem = new JMenuItem("Svi automobili");
	JLabel lblLogo = new JLabel(new ImageIcon("src/slike/serviser.png"));


	private Datoteke podaci;
	private Korisnik prijavljenKorisnik;
	
	
	public ServiserGlavniProzor(Datoteke podaci, Korisnik prijavljenKorisnik) {
		this.podaci = podaci;
		this.prijavljenKorisnik = prijavljenKorisnik;
		setTitle("Serviser: " + prijavljenKorisnik.getUsername());
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initMenu();
		initActions();
	}
	
	private void initMenu() {
		setJMenuBar(mainMenu);
		add(lblLogo);
		mainMenu.add(korisniciMenu);
		korisniciMenu.add(serviseriItem);
		korisniciMenu.add(musterijeItem);
		
		mainMenu.add(servisMenu);
		servisMenu.add(servisItem);
		servisMenu.add(knjizicaItem);
		servisMenu.add(deoItem);
		
		mainMenu.add(automobilMeni);
		automobilMeni.add(automobilItem);
		
	}
	
	private void initActions() {
		
	}

}
