package gui.FormeZaPrikazServiser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//import org.graalvm.compiler.lir.amd64.AMD64Arithmetic.FPDivRemOp;

import gui.formeZaDodavanjeIzmene.ServisFormaZaAdmina;
import model.automobili.Automobil;
import model.enumeracije.Statusi;
import model.korisnici.Korisnik;
import model.korisnici.Serviser;
import model.servis.Deo;
import model.servis.Servis;
import net.miginfocom.swing.MigLayout;
import radSaDatotekama.Datoteke;

public class FormaServisServisera extends JFrame {
	private JLabel lblAuto = new JLabel("Automobil");
	private JComboBox<String> cbAuto = new JComboBox<String>();
	
	private JLabel lblServiser = new JLabel("Serviser");
	private JComboBox<String> cbServiser = new JComboBox<String>();

	private JLabel lblTermin = new JLabel("Termin");
	private JTextField txtTermin = new JTextField(10);
	
	private JLabel lblDeo = new JLabel("Deo;Deo");
	private JTextField txtDeo = new JTextField(10);
	
	
	private JLabel lblStatus = new JLabel("Status");
	private JComboBox<Statusi> cbStatus = new JComboBox<Statusi>(Statusi.values());
	
	private JLabel lblID = new JLabel("ID");
	private JTextField txtID = new JTextField(20);
	
	
	
	private JLabel lblOpis = new JLabel("Opis");
	private JTextField txtOpis = new JTextField(20);
	
	private JLabel lblTroskovi = new JLabel("Troskovi");
	private JTextField txtTroskovi = new JTextField(10);
	
	private JLabel ProzorTroskovi = new JLabel();
	private JButton btnZavrsi = new JButton("Zavrsi servis");
	
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	
	private Datoteke datoteka;
	private Servis servis;
	private Korisnik prijavljenKorisnik;
	private Serviser serviser;
	
	
	public FormaServisServisera(Datoteke datoteka, Servis servis, Korisnik prijavljenKorisnik) {
		this.datoteka = datoteka;
		this.servis = servis;
		this.prijavljenKorisnik = prijavljenKorisnik;
		
		if(servis != null) {
			txtID.setEnabled(false);
			txtTermin.setEnabled(false);
			cbAuto.setEnabled(false);
			txtDeo.setEnabled(false);
			popuniPolja();
			setTitle("Izmene vrednosti servisa");
		}else {
			setTitle("Dodavanje novog servisa");
			btnZavrsi.setEnabled(false);
			txtTroskovi.setEnabled(false);
			cbStatus.setEnabled(false);
		}
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);;
		setLocationRelativeTo(null);
		setResizable(false);
		initGUI();
		initActions();
		pack();
	}
	
	
	public void initGUI() {
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][]20[]");
		setLayout(layout);
		
		
		for(Automobil automobil : datoteka.sviNeobrisaniAutomobili()) {
			cbAuto.addItem(automobil.getIdOznaka());
		}
		
		
		add(lblAuto);
		add(cbAuto);
	//	add(cbServiser);

		add(lblOpis);
		add(txtOpis);
		
		add(lblID);
		add(txtID);
		
		add(lblStatus);
		add(cbStatus);
		
		add(lblDeo);
		add(txtDeo);
		add(lblTermin);
		add(txtTermin);
		
		add(lblTroskovi);
		add(txtTroskovi);
		add(btnZavrsi);
		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCancel);

		
	}
	
	public void initActions() {
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			if(validacije()) {	
			String id = txtID.getText().trim();
			
			String auto = cbAuto.getSelectedItem().toString();
			Automobil automobil = datoteka.nadjiAutomobil(auto);
			
			String serviserID = prijavljenKorisnik.getIDOznaka();
			Serviser serviser = datoteka.nadjiServisera(serviserID);
			
			String opis = txtOpis.getText().toString();
			
			double trosak = 0;		
			String deoID = txtDeo.getText().trim();
			
			
			String[] deloviSplit = deoID.split(";");
			ArrayList<Deo> deo2 = new ArrayList<Deo>();
			for (String sif : deloviSplit) {                         //ovo pravi listu delova
				Deo d = datoteka.nadjiDeo(sif);
				if(d != null) {
					deo2.add(d);
					
				}
				
			}

			Statusi status = Statusi.valueOf("ZAKAZAN");
			
			String datum = txtTermin.getText().trim();
			GregorianCalendar termin = Servis.StringToGregorian(datum);
			
			if(servis == null) {
			
			Servis novi = new Servis(automobil, serviser, termin, opis, deo2, status, id, false,trosak);
			datoteka.dodajServis(novi);
			System.out.println(novi);
			}else {
				servis.setOpis(opis);
			//	servis.setAutomobil(automobil);
				servis.setTermin(termin);
			//	servis.setServiser(serviser);
				servis.setiDoznaka(id);
				servis.setTroskovi(trosak);
				servis.setStatus(status);
			}
			datoteka.snimiServis();
			FormaServisServisera.this.dispose();
			FormaServisServisera.this.setVisible(false);
			}
			}
		});
		
		btnZavrsi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				servis.setStatus(Statusi.valueOf("ZAVRSEN"));
				datoteka.snimiServis();
				TroskoviForma tf = new TroskoviForma(datoteka, prijavljenKorisnik, servis);
				tf.setVisible(true);

				
			}
		});
		
	}
	
	public void popuniPolja() {
		txtOpis.setText(servis.getOpis());
		txtTermin.setText(servis.getTerminSimpleDate());
		cbAuto.setSelectedItem(servis.getAutomobil());
		cbServiser.setSelectedItem(servis.getServiser());
		cbStatus.setSelectedItem(servis.getStatus());
		txtID.setText(servis.getiDoznaka());
		txtDeo.setText(servis.getDeoID().toString());
		txtTroskovi.setText(String.valueOf(servis.getTroskovi()));
	}
	
	private boolean termineokej(String termin) {
		SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy.");
		format.setLenient(false);
		try {
			format.parse(termin.trim());
		}catch (Exception e) {
			return false;
		}
		
		return true;
	}

	
	
	public boolean validacije() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		if(txtID.getText().trim().equals("")) {
			poruka += "- Morate uneti ID\n";
			ok = false;
	}else if(servis == null) {
		String id = txtID.getText().trim();
		Servis pronadjen = datoteka.nadjiServis(id);
		if(pronadjen != null) {
			poruka += "-Auto sa unetim ID vec postoji\n";
			ok = false;
		}
	}
		if(txtOpis.getText().trim().equals("")) {
			poruka += "- Morate uneti naziv\n";
			ok = false;
		}
		
		if(servis!=null) {
		try {
			Double.parseDouble(txtTroskovi.getText().trim());
		}catch (NumberFormatException e) {
			poruka += "- Cena mora biti broj\n";
			ok = false;
		}
		}
		
		
		if(txtTermin.getText().trim().equals("")) {
			poruka += "- Morate uneti termin\n";
			ok = false;
		}else if(servis == null) {
			String termin = txtTermin.getText().trim();
			termineokej(termin);
			if(termineokej(termin) == false) {
				poruka += "Nisi lepo uneo datum";
				ok = false;
			}
		}
		if(servis==null) {
		if(txtDeo.getText().trim().equals("")) {
			poruka += "- Morate uneti deo\n";
			ok = false;
		}else {
			String idDela =txtDeo.getText().trim();
	//		Deo pronadjen = datoteka.nadjiDeo(idDela);
			String[] deloviSplit = idDela.split(";");
			ArrayList<Deo> deo2 = new ArrayList<Deo>();
			for (String sif : deloviSplit) {                         //ovo pravi listu delova
				Deo d = datoteka.nadjiDeo(sif);
				if(d == null) {
					poruka += "- Nema takvog dela kod nas";
					ok = false;
					
					
				}
			}
			}
		}
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;

}
}


