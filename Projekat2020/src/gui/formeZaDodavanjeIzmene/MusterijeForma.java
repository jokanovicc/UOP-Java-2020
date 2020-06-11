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
import model.korisnici.Musterija;
import net.miginfocom.swing.MigLayout;
import radSaDatotekama.Datoteke;

public class MusterijeForma extends JFrame {
	
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
	
	private JLabel lblBodovi = new JLabel("Bodovi");
	private JTextField txtBodovi = new JTextField(20);
	
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	
	private Datoteke datoteke;
	private Musterija musterija;
	
	
	public MusterijeForma(Datoteke datoteke,Musterija musterija) {
		this.datoteke = datoteke;
		this.musterija = musterija;
		if(musterija==null) {
			setTitle("Dodavanje musterija");
		}else {
			setTitle("Izmena podataka - " + musterija.getIme());
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
		if(musterija != null) {
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
		add(lblBodovi);
		add(txtBodovi);
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
				int bodovi = Integer.parseInt(txtBodovi.getText().trim());
				String id = txtID.getText().trim();
				String korisnickoIme = txtKorisnickoIme.getText().trim();
				
				if(musterija==null) {
					Musterija novi = new Musterija(ime, prezime, jmbg, pol, brojTel, adresa, korIme, sifra, id, false, bodovi);
					datoteke.dodajMusteriju(novi);
				}else {
					musterija.setIme(ime);
					musterija.setPrezime(prezime);
					musterija.setPol(pol);
					musterija.setAdresa(adresa);
					musterija.setBrojTelefona(brojTel);
					musterija.setIDOznaka(id);
					musterija.setBrojSakupljenihBodova(bodovi);
					musterija.setUsername(korisnickoIme);
					musterija.setLozinka(sifra);
					musterija.setJmbg(jmbg);
					musterija.setLozinka(sifra);
					

				}
				
				datoteke.snimiMusteriju();
				MusterijeForma.this.dispose();
				MusterijeForma.this.setVisible(false);
			}
			}
			
	
		});

		
	}
	
	private void popuniPolja() {
		txtIme.setText(musterija.getIme());
		txtPrezime.setText(musterija.getPrezime());
		txtJmbg.setText(musterija.getJmbg());
		cbPol.setSelectedItem(musterija.getPol());
		txtBrojTelefona.setText(musterija.getBrojTelefona());
		txtAdresa.setText(musterija.getAdresa());
		txtKorisnickoIme.setText(musterija.getUsername());
		pfSifra.setText(musterija.getLozinka());
		txtID.setText(musterija.getIDOznaka());
		txtBodovi.setText(String.valueOf(musterija.getBrojSakupljenihBodova()));


	}
	
	public boolean validacije() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";	
		if(txtID.getText().trim().equals("")) {
			poruka += "- Morate uneti ID\n";
			ok = false;
	
	}else if(musterija == null) {
		String id = txtID.getText().trim();
		Musterija pronadjen = datoteke.nadjiMusteriju(id);
		if(pronadjen != null) {
			poruka += "- Musterija sa unetim ID vec postoji\n";
			ok = false;
		}
	}
		try {
			Double.parseDouble(txtBodovi.getText().trim());
		}catch (NumberFormatException e) {
			poruka += "- Bod mora biti broj\n";
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
