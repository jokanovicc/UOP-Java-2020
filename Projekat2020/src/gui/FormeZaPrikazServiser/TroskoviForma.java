package gui.FormeZaPrikazServiser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



import model.korisnici.Korisnik;
import model.korisnici.Musterija;
import model.korisnici.Serviser;
import model.servis.Deo;
import model.servis.Servis;
import net.miginfocom.swing.MigLayout;
import radSaDatotekama.Datoteke;

public class TroskoviForma extends JFrame {
	
	private JLabel lblTrosak = new JLabel("Unesi troskove servisa: ");
	private JTextField txtTrosak = new JTextField(20);
	private JButton btnOk = new JButton("OK");
	
	private Datoteke datoteke;
	private Korisnik prijavljeniKorisnik;
	private Serviser serviser;
	private Musterija musterija;
	private Servis servis;
	
	
	public TroskoviForma(Datoteke datoteke, Korisnik prijavljeniKorisnik, Servis servis) {
		this.datoteke = datoteke;
		this.prijavljeniKorisnik = prijavljeniKorisnik;
		this.servis = servis;
		
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
		setTitle("Cena usluge servisera");
		add(lblTrosak);
		add(txtTrosak);
		add(new JLabel());
		add(btnOk);
	}
	
	private void initActions() {
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacije()) {
				int izbor = JOptionPane.showConfirmDialog(null, 
						"Zelite li iskoristiti bodove", 
						 "Snizenje cijene", JOptionPane.YES_NO_OPTION);
			    Musterija musterija1 = datoteke.nadjiMusteriju(servis.getVlasnikID());
			   // Deo deo1 = datoteke.nadjiDeo(servis.getDeoID());
			    ArrayList<String> deoID = servis.getDeoID();
				ArrayList<Deo> deo2 = new ArrayList<Deo>();
				double cena = 0;
				
				for(Deo deo1 : servis.getDeo()) {
					cena += deo1.getCena();
				}

				
			  		    
			    
			    int bodovi = musterija1.getBrojSakupljenihBodova();
		    	double trosakServisa = Double.parseDouble(txtTrosak.getText().trim()) + cena;
		    	 
			    
			    if(izbor == JOptionPane.YES_OPTION) {
			    	
			    //	 System.out.println(musterija1);
			    //	 int bodovi = musterija1.getBrojSakupljenihBodova();
			    //	 double cena = Double.parseDouble(txtTrosak.getText().trim());
			    	 for (int i = 0; i < bodovi; i++) {
			    		trosakServisa = trosakServisa * 0.98;
					 	 
						
					}
			  //  	 System.out.println("stisno si da");
			    	 musterija1.setBrojSakupljenihBodova(0);
			    	 servis.setTroskovi(trosakServisa);
			    //	 datoteke.snimiMusteriju();
			    //	 datoteke.snimiServis();
				//	 JOptionPane.showMessageDialog(null, "Servis je Zavrsen. Cena servisa je: " +servis.getTroskovi() + ". Broj trenutno sakupljenih bodova musterije je " + musterija1.getBrojSakupljenihBodova(), "Greska", JOptionPane.INFORMATION_MESSAGE);


			    	
			   }
			    
			  if(izbor == JOptionPane.NO_OPTION) {
			//	  System.out.println("NOOOOOOOOOOOOOOO");
				  if(bodovi < 10) {
				  int bodovi1 = bodovi +1;
				  musterija1.setBrojSakupljenihBodova(bodovi1);
				  }
				  servis.setTroskovi(trosakServisa);
			//	  musterija1.setBrojSakupljenihBodova(bodovi1);
			//	  datoteke.snimiServis();
			//	  datoteke.snimiMusteriju();
			//	  JOptionPane.showMessageDialog(null, "Servis je Zavrsen. Cena servisa je: " +servis.getTroskovi() + ". Broj trenutno sakupljenih bodova musterije je " + musterija1.getBrojSakupljenihBodova(), "Greska", JOptionPane.INFORMATION_MESSAGE);

				  
				  
			  }
				 JOptionPane.showMessageDialog(null, "Servis je Zavrsen. Ukupna cena servisa je: " +servis.getTroskovi() + ". Broj trenutno sakupljenih bodova musterije je " + musterija1.getBrojSakupljenihBodova(), "Zavrseno", JOptionPane.INFORMATION_MESSAGE);
				 datoteke.snimiServis();
				 datoteke.snimiMusteriju();
				   

			}
			}
		});
	}
	
	private boolean validacije() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		try {
			Double.parseDouble(txtTrosak.getText().trim());
		}catch (NumberFormatException e) {
			poruka += "- Cena mora biti broj\n";
			ok = false;
		}
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
		
		}
	}
	


