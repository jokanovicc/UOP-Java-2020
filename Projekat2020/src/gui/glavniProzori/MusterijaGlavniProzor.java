package gui.glavniProzori;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import gui.FormeZaPrikaz.PrikazAdmin.MusterijaProzorPrikaz;
import gui.FormeZaPrikazMusterija.MusterijaPrikazInfoSvoje;
import gui.FormeZaPrikazMusterija.StatusServisaPrikaz;
import gui.FormeZaPrikazMusterija.SvojAutoPrikaz;
import model.korisnici.Korisnik;
import model.korisnici.Musterija;
import net.miginfocom.swing.MigLayout;
import radSaDatotekama.Datoteke;

public class MusterijaGlavniProzor extends JFrame {
	private JMenuBar mainMenu  = new JMenuBar();
	private JMenu korisniciMenu = new JMenu("Vase informacije");
	private JMenuItem musterijaItem = new JMenuItem("Pregled informacija");
	private JMenu automobilMeni = new JMenu("Vas Automobil");
	private JMenuItem automobilItem = new JMenuItem("Prikaz Automobila");
	//JLabel lblLogo = new JLabel(new ImageIcon("src/slike/admin.png"));
	JLabel lblLogo = new JLabel(new ImageIcon("src/slike/musterija.png"));
	private JButton zakaziBtn = new JButton("STATUS VASEG SERVISA!");

	
	private Datoteke podaci;
	private Korisnik prijavljenKorisnik;
	private Musterija musterija;
	
	
	public MusterijaGlavniProzor(Datoteke podaci, Korisnik prijavljenKorisnik) {
		this.podaci = podaci;
		this.prijavljenKorisnik = prijavljenKorisnik;
		
		setTitle("Musterija: " + prijavljenKorisnik.getIme() + " " + prijavljenKorisnik.getPrezime());
		setSize(350, 440);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initMenu();
		initActions();
		
	}
	
	public void initMenu() {
		add(lblLogo);
		setJMenuBar(mainMenu);
		add(lblLogo);
		mainMenu.add(korisniciMenu);
		korisniciMenu.add(musterijaItem);
		
		mainMenu.add(automobilMeni);
		automobilMeni.add(automobilItem);;
		
		add(zakaziBtn, BorderLayout.SOUTH);
		
		
	}
	
	public void initActions() {
		
		musterijaItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MusterijaPrikazInfoSvoje mpis = new MusterijaPrikazInfoSvoje(podaci, prijavljenKorisnik);
				mpis.setVisible(true);
				
			}
		});
		
		automobilItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SvojAutoPrikaz sup = new SvojAutoPrikaz(podaci, prijavljenKorisnik);
				sup.setVisible(true);
				
			}
		});
		
		zakaziBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StatusServisaPrikaz sppi = new StatusServisaPrikaz(podaci, prijavljenKorisnik);
				sppi.setVisible(true);
				
			}
		});
		
	}
	
	
	
}
