package gui.FormeZaPrikazMusterija;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.automobili.Automobil;
import model.enumeracije.Statusi;
import model.korisnici.Korisnik;
import model.servis.Servis;
import net.miginfocom.swing.MigLayout;
import radSaDatotekama.Datoteke;

public class DodavanjeServisaMusterija extends JFrame {
	
	JLabel lblAuto = new JLabel("Automobil: ");
	private JComboBox<String> cbAuto = new JComboBox<String>();

	

	private JLabel lblOpis = new JLabel("Opis");
	private JTextField txtOpis = new JTextField(20);
	
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private Datoteke datoteka;
	private Servis servis;
	private Korisnik prijavljenKorisnik;
	private Automobil automobil;
	
	public DodavanjeServisaMusterija(Datoteke datoteka, Servis servis, Korisnik prijavljenKorisnik) {
		this.datoteka = datoteka;
		this.servis = servis;
		this.prijavljenKorisnik = prijavljenKorisnik;
		setTitle("Zakazivanje servisa");
		
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
		
		for(Automobil automobil : datoteka.autoPrikaz(prijavljenKorisnik.getIDOznaka())) {
			cbAuto.addItem(automobil.getIdOznaka());
		}
		
		add(lblAuto);
		add(cbAuto);
		
		add(lblOpis);
		add(txtOpis);
		
		
		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCancel);
		
	}
	
	private void initActions() {
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String auto = cbAuto.getSelectedItem().toString();
				Automobil automobil = datoteka.nadjiAutomobil(auto);
				
				String opis = txtOpis.getText().toString();

				Servis novi = new Servis();
				novi.setAutomobil(automobil);
				novi.setOpis(opis);
				
				datoteka.dodajServis(novi);
				System.out.println(novi);
				datoteka.snimiServis();
				DodavanjeServisaMusterija.this.dispose();
				DodavanjeServisaMusterija.this.setVisible(false);
				
			}
		});
		
	}
	
	

}
