package gui.formeZaDodavanjeIzmene;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import main.ServisMain;
import model.enumeracije.MarkaModelDeo;
import model.servis.Deo;
import net.miginfocom.swing.MigLayout;
import radSaDatotekama.Datoteke;

public class DeoForma extends JFrame {
	
	private JLabel lblNaziv = new JLabel("Naziv: ");
	private JTextField txtNaziv = new JTextField(20);
	private JLabel lblCena = new JLabel("Cena: ");
	private JTextField txtCena = new JTextField(20);
	private JLabel lblID = new JLabel("ID Dela: ");
	private JTextField txtID = new JTextField(20);
	
	private JLabel lblModel = new JLabel("Za auto");
	private JComboBox<MarkaModelDeo> cbModel = new JComboBox<MarkaModelDeo>(MarkaModelDeo.values());
	
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private Datoteke datoteka;
	private Deo deo;
	
	
	public DeoForma(Datoteke datoteka, Deo deo) {
		this.datoteka = datoteka;
		this.deo = deo;
		if(deo == null) {
			setTitle("Dodavanje Dela");
		}else {
			setTitle("Izmena podataka - " + deo.getIdDela());
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
		if(deo !=null) {
			txtID.setEnabled(false);
			popuniPolja();
		}
		
		
		add(lblID);
		add(txtID);
		add(lblNaziv);
		add(txtNaziv);
		add(lblModel);
		add(cbModel);
		add(lblCena);
		add(txtCena);
		
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
				String naziv = txtNaziv.getText().trim();
				double cena = Double.parseDouble(txtCena.getText().trim());
				MarkaModelDeo model = (MarkaModelDeo)cbModel.getSelectedItem();
				
				if(deo == null) {
					Deo novi = new Deo(model, naziv, cena, id, false);
					datoteka.dodajDeo(novi);
					kreirajSimetricniDeo2(novi);
				}else {
					deo.setCena(cena);
					deo.setNaziv(naziv);
					deo.setAutomobil(model);
	
				}
				datoteka.snimiDeo();
				DeoForma.this.dispose();
				DeoForma.this.setVisible(false);
			}
			}
		});
		
	}
	
	private void popuniPolja() {
		txtID.setText(deo.getIdDela());
		txtNaziv.setText(deo.getNaziv());
		txtCena.setText(String.valueOf(deo.getCena()));
		txtNaziv.setText(deo.getNaziv());
		cbModel.setSelectedItem(deo.getAutomobil());
		
	}
	
	private boolean validacije() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		
		if(txtID.getText().trim().equals("")) {
			poruka += "- Morate uneti ID\n";
			ok = false;

	}else if(deo == null) {
		String id = txtID.getText().trim();
		Deo pronadjen = datoteka.nadjiDeo(id);
		if(pronadjen != null) {
			poruka += "- Deo sa unetim ID vec postoji\n";
			ok = false;
		}
	}
		
		try {
			Double.parseDouble(txtCena.getText().trim());
		}catch (NumberFormatException e) {
			poruka += "- Cena mora biti broj\n";
			ok = false;
		}
		
		if(txtNaziv.getText().trim().equals("")) {
			poruka += "- Morate uneti naziv\n";
			ok = false;
		}
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
	
	public void kreirajSimetricniDeo(Deo deo) {
		String mystring = deo.getNaziv();
		String arr[] = mystring.split(" ", 3);                     //Formiranje simetricnog dela
																//za sad se oslanja na Main, pa cu kasnije pomeriti gde bude trebalo za gui					
		
		 if((arr[0].equals("Leva") && arr[1].equals("strana")) 
				 || (arr[0].equals("Desna") && arr[1].equals("strana"))) {
		
		
		
			if(arr[0].equals("Leva") && arr[1].equals("strana")) {
				Deo deo2 = new Deo (deo.getAutomobil(),
						"Desna strana" + " " +arr[2] , deo.getCena(), deo.getIdDela(), deo.isObrisan());
				datoteka.dodajDeo(deo2);  //ovo duplo ce biti izmenjeno, zavisi gde funkcija bude trebala
				datoteka.snimiDeo();
				
				
			} else if (arr[0].equals("Desna") && arr[1].equals("strana")) {
				Deo deo2 = new Deo (deo.getAutomobil(),
						"Leva strana" + " "+ arr[2] , deo.getCena(), deo.getIdDela(), deo.isObrisan());
				datoteka.dodajDeo(deo2);
				datoteka.snimiDeo();
				
			
			
		} }
	}
	
	public void kreirajSimetricniDeo2(Deo deo) {  //isto kreiranje ali samo sa funkcjimo contains
		String mystring = deo.getNaziv();                  
																				
		
		 if((mystring.contains("desna strana")) 
				 || (mystring.contains("leva strana"))) {
		
		
		
			if(mystring.contains("leva strana")) {
				Deo deo2 = new Deo (deo.getAutomobil(),
						deo.getNaziv().replace("leva", "desna") + " " , deo.getCena(), deo.getIdDela(), deo.isObrisan());
				datoteka.dodajDeo(deo2);  //ovo duplo ce biti izmenjeno, zavisi gde funkcija bude trebala
				datoteka.snimiDeo();
				
				
			} else if (mystring.contains("desna strana")) {
				Deo deo2 = new Deo (deo.getAutomobil(),
						deo.getNaziv().replace("desna", "leva") + " " , deo.getCena(), deo.getIdDela(), deo.isObrisan());
				datoteka.dodajDeo(deo2);
				datoteka.snimiDeo();
				
			
			
		} }
	}
		

	

	}
	
	


