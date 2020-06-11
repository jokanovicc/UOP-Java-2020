package gui.FormeZaPrikazMusterija;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import model.automobili.Automobil;
import model.korisnici.Korisnik;
import radSaDatotekama.Datoteke;

public class SvojAutoPrikaz extends JFrame {
	private DefaultTableModel tableModel;
	private JTable autoTabela;
	
	private Datoteke datoteka;
	private Korisnik prijavljeniKorisnik;
	
		
		public SvojAutoPrikaz(Datoteke datoteka,Korisnik prijavljeniKorisnik) {
			this.datoteka=datoteka;
			this.prijavljeniKorisnik = prijavljeniKorisnik;
			setTitle("Automobili");
			setSize(700, 300);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			initGUI();
			
		}
		
		public void initGUI() {
			
			String[] zaglavlja = new String[] {"ID","Marka i Model","Godina Proizvodnje","Zapremina Motora","Snaga","Gorivo"};
			Object[][] sadrzaj = new Object[datoteka.autoPrikaz(prijavljeniKorisnik.getIDOznaka()).size()][zaglavlja.length];
			
			for(int i=0; i<datoteka.autoPrikaz(prijavljeniKorisnik.getIDOznaka()).size(); i++) {
				Automobil automobil = datoteka.autoPrikaz(prijavljeniKorisnik.getIDOznaka()).get(i);
			//	if(automobil.getVlasnikId().equals(prijavljeniKorisnik.getIDOznaka())) {
				sadrzaj[i][0] = automobil.getIdOznaka();
				sadrzaj[i][1] = automobil.getMarkaModel();
				sadrzaj[i][2] = automobil.getGodinaProizvodnje();
				sadrzaj[i][3] = automobil.getZapreminaMotora();
				sadrzaj[i][4] = automobil.getSnaga();
				sadrzaj[i][5] = automobil.getVrstaGoriva();
				
		//	}
			}
			
			tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
			autoTabela = new JTable(tableModel);
			
			
			autoTabela.setRowSelectionAllowed(true);
			autoTabela.setColumnSelectionAllowed(false);
			autoTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			autoTabela.setDefaultEditor(Object.class, null);
			autoTabela.getTableHeader().setReorderingAllowed(false);
			
			
			JScrollPane scrollPane = new JScrollPane(autoTabela);
			
			add(scrollPane, BorderLayout.CENTER);
			
		}
		

}
