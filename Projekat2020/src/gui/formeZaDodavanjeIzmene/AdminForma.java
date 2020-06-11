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
import model.korisnici.Admin;
import model.korisnici.Serviser;
import net.miginfocom.swing.MigLayout;
import radSaDatotekama.Datoteke;

public class AdminForma extends JFrame {
	
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
	
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	
	private Datoteke datoteke;
	private Admin admin;
	
	public AdminForma(Datoteke datoteke, Admin admin) {
		this.datoteke = datoteke;
		this.admin = admin;
		if(admin==null) {
			setTitle("Dodavanje admina");
		}else {
			setTitle("Izmena admina - " + admin.getIme());
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
		
		if(admin != null) {
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
				double plata = Double.parseDouble(txtPlata.getText().trim());
				
				if(admin == null) {
				Admin novi = new Admin(ime, prezime, jmbg, pol, brojTel, adresa, korIme, sifra, id, false, plata);
				datoteke.dodajAdmina(novi);
				}else {
					admin.setIme(ime);
					admin.setPrezime(prezime);
					admin.setPol(pol);
					admin.setAdresa(adresa);
					admin.setBrojTelefona(brojTel);
					admin.setIDOznaka(id);
					admin.setPlata(plata);
					admin.setUsername(korisnickoIme);
					admin.setLozinka(sifra);
					admin.setJmbg(jmbg);
					
					
				}
				
				datoteke.snimiAdmina();
				AdminForma.this.dispose();
				AdminForma.this.setVisible(false);
			}
			}
			
		});
		
	}
	
	private void popuniPolja() {
		txtIme.setText(admin.getIme());
		txtPrezime.setText(admin.getPrezime());
		txtJmbg.setText(admin.getJmbg());
		cbPol.setSelectedItem(admin.getPol());
		txtBrojTelefona.setText(admin.getBrojTelefona());
		txtAdresa.setText(admin.getAdresa());
		txtKorisnickoIme.setText(admin.getUsername());
		pfSifra.setText(admin.getLozinka());
		txtID.setText(admin.getIDOznaka());
		txtPlata.setText(String.valueOf(admin.getPlata()));
		
	}
	
	private boolean validacije() {
		boolean ok = true;	
		String poruka = "Molimo popravite sledece greske u unosu:\n";	
		if(txtID.getText().trim().equals("")) {
			poruka += "- Morate uneti ID\n";
			ok = false;
	
	}else if(admin == null) {
		String id = txtID.getText().trim();
		Admin pronadjen = datoteke.nadjiAdmina(id);
		if(pronadjen != null) {
			poruka += "- Admin sa unetim ID vec postoji\n";
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
