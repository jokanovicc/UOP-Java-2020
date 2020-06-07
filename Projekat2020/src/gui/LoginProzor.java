package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gui.glavniProzori.AdminGlavniProzor;
import gui.glavniProzori.MusterijaGlavniProzor;
import gui.glavniProzori.ServiserGlavniProzor;
import model.korisnici.Admin;
import model.korisnici.Korisnik;
import model.korisnici.Musterija;
import model.korisnici.Serviser;
import net.miginfocom.swing.MigLayout;
import radSaDatotekama.Datoteke;

public class LoginProzor extends JFrame {
	
	private JLabel lblPozdrav = new JLabel("Dobrodosli u Auto Servis! Molim Vas da se prijavite.");
	private JLabel lblKorisnickoIme = new JLabel("Korisnicko ime");
	private JTextField txtKorisnickoIme = new JTextField(20);
	private JLabel lblSifra = new JLabel("Sifra");
	private JPasswordField pfSifra = new JPasswordField(20);
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	JLabel lblLogo = new JLabel(new ImageIcon("src/slike/logo.png"));
	
	private Datoteke datoteka;
	
	public LoginProzor(Datoteke datoteka) {
		this.datoteka = datoteka;
		setTitle("Prijava");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		pack();
		
	}
	
	public void initGUI() {

		MigLayout mig = new MigLayout("wrap 2","[][]","[]10[][]10[]");
		setLayout(mig);
		add(lblLogo);
		
		add(lblPozdrav,"span 2");
		add(lblKorisnickoIme);
		add(txtKorisnickoIme);
		add(lblSifra);
		add(pfSifra);
		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCancel);
		
		getRootPane().setDefaultButton(btnOk);
		
	}
	
	public void initActions() {
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginProzor.this.dispose();
				LoginProzor.this.setVisible(false);
				
			}
		});
		
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String korisnickoIme = txtKorisnickoIme.getText().trim();
				String sifra = new String(pfSifra.getPassword()).trim();
				if(korisnickoIme.equals("") || sifra.equals("")) {
					JOptionPane.showMessageDialog(null, "Morate uneti ispravne podatke");
				}else {
					Korisnik korisnik = datoteka.login(korisnickoIme, sifra);
					if(korisnik != null) {
						
						if(korisnik instanceof Serviser) {          //ako je taj korisnik instanca servisera i slicno
							LoginProzor.this.dispose();
							LoginProzor.this.setVisible(false);
							ServiserGlavniProzor sgp = new ServiserGlavniProzor(datoteka, korisnik);
							sgp.setVisible(true);
						
						}
						if(korisnik instanceof Musterija) {
							LoginProzor.this.dispose();
							LoginProzor.this.setVisible(false);
							MusterijaGlavniProzor mgp = new MusterijaGlavniProzor(datoteka, korisnik);
							mgp.setVisible(true);
						}
						if(korisnik instanceof Admin) {
							LoginProzor.this.dispose();
							LoginProzor.this.setVisible(false);
							AdminGlavniProzor agp = new AdminGlavniProzor(datoteka, korisnik);
							agp.setVisible(true);
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Pogresni login podaci!");
						
					}
					
				}
				
			}
		});
		
	}

}
