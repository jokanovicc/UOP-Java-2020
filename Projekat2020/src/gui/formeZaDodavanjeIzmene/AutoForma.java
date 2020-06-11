package gui.formeZaDodavanjeIzmene;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.automobili.Automobil;
import model.enumeracije.Gorivo;
import model.enumeracije.MarkaModelDeo;
import model.korisnici.Musterija;
import model.servis.Deo;
import net.miginfocom.swing.MigLayout;
import radSaDatotekama.Datoteke;

public class AutoForma extends JFrame {
	
	
	private JLabel lblVlasnici = new JLabel("Vlasnik");
	private JComboBox<String> cbVlasnici = new JComboBox<String>();
	private JTextField txtVlasnik = new JTextField(20);
	
	private JLabel lblModel = new JLabel("Marka i Model");
	private JComboBox<MarkaModelDeo> cbModel = new JComboBox<MarkaModelDeo>(MarkaModelDeo.values());
	
	private JLabel lblGodiste = new JLabel("Godiste");
	private JTextField txtGodiste = new JTextField(20);
	
	private JLabel lblZapremina = new JLabel("Zapremina Motora: ");
	private JTextField txtZapremina = new JTextField(20);
	
	private JLabel lblSnaga = new JLabel("Snaga motora");
	private JTextField txtSnaga = new JTextField(20);
	
	private JLabel lblGorivo = new JLabel("Gorivo");
	private JComboBox<Gorivo> cbGorivo = new JComboBox<Gorivo>(Gorivo.values());
	
	private JLabel lblID = new JLabel("ID Oznaka");
	private JTextField txtID = new JTextField(20);
	
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	
	private Datoteke datoteka;
	private Automobil automobil;
	
	
	public AutoForma(Datoteke datoteka, Automobil automobil) {
		this.datoteka = datoteka;
		this.automobil = automobil;
		if(automobil==null) {
			setTitle("Dodavanje automobila");
		}else {
			setTitle("Izmena podataka - " + automobil.getIdOznaka());
		}
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);;
		setLocationRelativeTo(null);
		
		setResizable(false);
		initGUI();
		initActions();
		pack();

	}
	
	private void initGUI() {
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][]20[]");
		setLayout(layout);
		
		if(automobil != null) {
			txtID.setEnabled(false);
			popuniPolja();
		}
		
		for(Musterija musterija : datoteka.sveNeobrisaneMusterije()) {
			cbVlasnici.addItem(musterija.getIDOznaka());
		}
		add(lblVlasnici);
		add(cbVlasnici);
		
		add(lblModel);
		add(cbModel);
		add(lblGodiste);
		add(txtGodiste);
		add(lblGorivo);
		add(cbGorivo);
		add(lblID);
		add(txtID);
		add(lblSnaga);
		add(txtSnaga);
		add(lblZapremina);
		add(txtZapremina);
		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCancel);
		}
		
	
	
	private void initActions() {
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacije()) {
				String id = txtID.getText().trim();
				String zapremina = txtZapremina.getText().trim();
				String snaga = txtSnaga.getText().trim();
				
				String vlasnikID = cbVlasnici.getSelectedItem().toString();
				Musterija musterija = datoteka.nadjiMusteriju(vlasnikID);
				
				MarkaModelDeo model = (MarkaModelDeo)cbModel.getSelectedItem();
				Gorivo gorivo = (Gorivo)cbGorivo.getSelectedItem();

				
				int godiste = Integer.parseInt(txtGodiste.getText().trim());
				
				if(automobil == null) {
				
				Automobil novi = new Automobil(musterija, model, godiste, zapremina, snaga, gorivo, id, false);
				datoteka.dodajAutomobil(novi);
				System.out.println(novi);
				datoteka.getMusterija().add(musterija);
				}else {
					automobil.setGodinaProizvodnje(godiste);
					automobil.setMarkaModel(model);
					automobil.setSnaga(snaga);
					automobil.setVrstaGoriva(gorivo);
					automobil.setVlasnik(musterija);
					automobil.setZapreminaMotora(zapremina);
					automobil.setIdOznaka(id);
					
				}

				datoteka.snimiAutomobil();
				AutoForma.this.dispose();
				AutoForma.this.setVisible(false);
				
			}
			}
		});
	}
	

public void popuniPolja() {
	txtGodiste.setText(String.valueOf(automobil.getGodinaProizvodnje()));
	txtSnaga.setText(automobil.getSnaga());
	txtZapremina.setText(automobil.getZapreminaMotora());
	txtID.setText(automobil.getIdOznaka());
	cbModel.setSelectedItem(automobil.getMarkaModel());
	cbVlasnici.setSelectedItem(automobil.getVlasnik());
	cbGorivo.setSelectedItem(automobil.getVrstaGoriva());

	
}

private boolean validacije() {
	boolean ok = true;
	String poruka = "Molimo popravite sledece greske u unosu:\n";
	if(txtID.getText().trim().equals("")) {
		poruka += "- Morate uneti ID\n";
		ok = false;
}else if(automobil == null) {
	String id = txtID.getText().trim();
	Automobil pronadjen = datoteka.nadjiAutomobil(id);
	if(pronadjen != null) {
		poruka += "-Auto sa unetim ID vec postoji\n";
		ok = false;
	}
}
	
	try {
		Double.parseDouble(txtGodiste.getText().trim());
	}catch (NumberFormatException e) {
		poruka += "Godiste mora biti broj\n";
		ok = false;
	}
	
	if(txtSnaga.getText().trim().equals("")) {
		poruka += "- Morate uneti naziv\n";
		ok = false;
	}
	
	if(txtZapremina.getText().trim().equals("")) {
		poruka += "- Morate uneti naziv\n";
		ok = false;
	}
	
	if(ok == false) {
		JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
	}
	return ok;

	

	
	
}
}
