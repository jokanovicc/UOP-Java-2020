package gui.formeZaDodavanjeIzmene;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.enumeracije.Pol;
import model.enumeracije.Specijalizacija;
import model.korisnici.Serviser;
import net.miginfocom.swing.MigLayout;
import radSaDatotekama.Datoteke;

public class ServiserForma extends JFrame {
	
	private JLabel lblIme = new JLabel("Ime");
	private JTextField txtIme = new JTextField(20);
	
	private JLabel lblPrezime = new JLabel("prezime");
	private JTextField txtPrezime = new JTextField(20);
	
	private JLabel lblJmbg = new JLabel("JMBG");
	private JTextField txtJmbg = new JTextField(20);
	
	private JLabel lblPol = new JLabel("Pol");
	private JComboBox<Pol> cbPol = new JComboBox<Pol>(Pol.values());
	private JLabel lblSifra = new JLabel("Sifra");
	private JPasswordField pfSifra = new JPasswordField(20);

	private JLabel lblKorisnickoIme = new JLabel("Korisnicko ime");
	private JTextField txtKorisnickoIme = new JTextField(20);

	
	private JLabel lblbrojTelefona = new JLabel("Broj telefona");
	private JTextField txtBrojTelefona = new JTextField(20);
	
	private JLabel lblAdresa = new JLabel("Adresa");
	private JTextField txtAdresa = new JTextField(20);
	
	private JLabel lblID = new JLabel("ID Oznaka");
	private JTextField txtID = new JTextField(20);
	
	private JLabel lblPlata = new JLabel("Plata");
	private JTextField txtPlata = new JTextField(10);
	
	private JLabel lblSpecijalizacija = new JLabel("Specijalizacija");
	private JComboBox<Specijalizacija> cbSpecijalizacija = new JComboBox<Specijalizacija>(Specijalizacija.values());

	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	
	private Datoteke datoteke;
	private Serviser serviser;
	
	public ServiserForma(Datoteke datoteke, Serviser serviser) {
		this.datoteke = datoteke;
		this.serviser = serviser;
		if(serviser==null) {
			setTitle("Dodavanje servisera");
		}else {
			setTitle("Izmena podataka - " + serviser.getIme());
		}
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		setResizable(false);
		pack();
		
		
	}
	
	private void initGUI() {
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
		setLayout(layout);
		
		if(serviser != null) {
			txtID.setEnabled(false);
			popuniPolja();

		}
		
		add(lblID);
		add(txtID);
		add(lblIme);
		add(txtIme);
		add(lblPrezime);
		add(txtPrezime);
		add(lblPol);
		add(cbPol);
		add(lblAdresa);
		add(txtAdresa);
		add(lblbrojTelefona);
		add(txtBrojTelefona);
		add(lblKorisnickoIme);
		add(txtKorisnickoIme);
		add(lblJmbg);
		add(txtJmbg);
		add(lblSifra);
		add(pfSifra);
		add(lblPlata);
		add(txtPlata);
		add(lblSpecijalizacija);
		add(cbSpecijalizacija);
		add(new JLabel());
		add(btnOk, " split 2");
		add(btnCancel);
		
	}
	
	
	private void initActions() {
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacije()) {
				
				String ime = txtIme.getText().trim();
				String prezime = txtPrezime.getText().trim();
				Pol pol = (Pol)cbPol.getSelectedItem();
				String adresa = txtAdresa.getText().trim();
				String brojTel = txtBrojTelefona.getText().trim();
				String korIme = txtKorisnickoIme.getText().trim();
				String jmbg = txtJmbg.getText().trim();
				String sifra = new String(pfSifra.getPassword()).trim();
				String id = txtID.getText().trim();
				String korisnickoIme = txtKorisnickoIme.getText().trim();
				Specijalizacija specijalizacija = (Specijalizacija)cbSpecijalizacija.getSelectedItem();
				double plata = Double.parseDouble(txtPlata.getText().trim());
				
				if(serviser == null) {
				Serviser novi = new Serviser(ime, prezime, jmbg, pol, brojTel, adresa, korIme, sifra, id, false, plata, specijalizacija);
				datoteke.dodajServisera(novi);
				}else {
					serviser.setIme(ime);
					serviser.setPrezime(prezime);
					serviser.setPol(pol);
					serviser.setAdresa(adresa);
					serviser.setBrojTelefona(brojTel);
					serviser.setIDOznaka(id);
					serviser.setPlata(plata);
					serviser.setUsername(korisnickoIme);
					serviser.setLozinka(sifra);
					serviser.setSpecijalizacija(specijalizacija);
					serviser.setJmbg(jmbg);
					
					
				}
				
				datoteke.snimiServisera();
				ServiserForma.this.dispose();
				ServiserForma.this.setVisible(false);
			}
			}
			
		});
		
	}
	
	private void popuniPolja() {
		txtIme.setText(serviser.getIme());
		txtPrezime.setText(serviser.getPrezime());
		txtJmbg.setText(serviser.getJmbg());
		cbPol.setSelectedItem(serviser.getPol());
		txtBrojTelefona.setText(serviser.getBrojTelefona());
		txtAdresa.setText(serviser.getAdresa());
		txtKorisnickoIme.setText(serviser.getUsername());
		pfSifra.setText(serviser.getLozinka());
		txtID.setText(serviser.getIDOznaka());
		txtPlata.setText(String.valueOf(serviser.getPlata()));
		cbSpecijalizacija.setSelectedItem(serviser.getSpecijalizacija());
		
	}
	
	private boolean validacije() {
		boolean ok = true;	
		String poruka = "Molimo popravite sledece greske u unosu:\n";	
		if(txtID.getText().trim().equals("")) {
			poruka += "- Morate uneti ID\n";
			ok = false;
	
	}else if(serviser == null) {
		String id = txtID.getText().trim();
		Serviser pronadjen = datoteke.nadjiServisera(id);
		if(pronadjen != null) {
			poruka += "- Serviser sa unetim ID vec postoji\n";
			ok = false;
		}
	}
		
		try {
			Double.parseDouble(txtPlata.getText().trim());
		}catch (NumberFormatException e) {
			poruka += "- Plata mora biti broj\n";
			ok = false;
		}
		
		if(txtIme.getText().trim().equals("")) {
			poruka += "- Morate uneti ime\n";
			ok = false;
		}
		if(txtPrezime.getText().trim().equals("")) {
			poruka += "- Morate uneti prezime\n";
			ok = false;
		}
		
		if(txtAdresa.getText().trim().equals("")) {
			poruka += "- Morate uneti adresu\n";
			ok = false;
		}
		
		if(txtBrojTelefona.getText().trim().equals("")) {
			poruka += "- Morate uneti broj telefona\n";
			ok = false;
		}
		if(txtJmbg.getText().trim().equals("")) {
			poruka += "- Morate uneti jmbg\n";
			ok = false;
		}
		if(txtKorisnickoIme.getText().trim().equals("")) {
			poruka += "- Morate uneti username\n";
			ok = false;
		}
		
		if(pfSifra.getText().trim().equals("")) {
			poruka += "- Morate uneti sifru\n";
			ok = false;
		}
		
		if(txtID.getText().trim().equals("")) {
			poruka += "- Morate uneti sifru\n";
			ok = false;
		}
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	
	}
}
