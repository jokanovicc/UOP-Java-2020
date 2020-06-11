package gui.FormeZaPrikazMusterija;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import model.korisnici.Korisnik;
import model.korisnici.Musterija;
import model.korisnici.Serviser;
import radSaDatotekama.Datoteke;

public class MusterijaPrikazInfoSvoje extends JFrame {

	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	private JLabel infoLBL = new JLabel("Ovde su prikazane vase informacije, za izmenu javite se adminu");
	
	private DefaultTableModel tableModel;
	private JTable musterijeTabela;
	
	private Datoteke datoteka;
	private Korisnik prijavljenKorisnik;
	
	public MusterijaPrikazInfoSvoje(Datoteke datoteka,Korisnik prijavljenKorisnik) {
		this.datoteka=datoteka;
		this.prijavljenKorisnik = prijavljenKorisnik;
		setTitle("Musterija");
		setSize(700, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		
	}
	
	
	public void initGUI() {
	
		String[] zaglavlja = new String[] {"ID","Ime","Prezime","JMBG","Pol","Adresa","Broj telefona","Korisnicko Ime","Lozinka","Broj Sakupljenih Bodova"};
		Object[][] sadrzaj = new Object[datoteka.musterijaPrikaz(prijavljenKorisnik).size()][zaglavlja.length];
		
		for(int i=0; i<datoteka.musterijaPrikaz(prijavljenKorisnik).size(); i++) {
			Musterija musterija = datoteka.musterijaPrikaz(prijavljenKorisnik).get(i);
	//		if(musterija.getIDOznaka().equals(prijavljenKorisnik.getIDOznaka())) {
			sadrzaj[i][0] = musterija.getIDOznaka();
			sadrzaj[i][1] = musterija.getIme();
			sadrzaj[i][2] = musterija.getPrezime();
			sadrzaj[i][3] = musterija.getJmbg();
			sadrzaj[i][4] = musterija.getPol();
			sadrzaj[i][5] = musterija.getAdresa();
			sadrzaj[i][6] = musterija.getBrojTelefona();
			sadrzaj[i][7] = musterija.getUsername();
			sadrzaj[i][8] = musterija.getLozinka();
			sadrzaj[i][9] = musterija.getBrojSakupljenihBodova();
			
		}
	//	}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		musterijeTabela = new JTable(tableModel);
		
		
		musterijeTabela.setRowSelectionAllowed(true);
		musterijeTabela.setColumnSelectionAllowed(false);
		musterijeTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		musterijeTabela.setDefaultEditor(Object.class, null);
		musterijeTabela.getTableHeader().setReorderingAllowed(false);
		
		infoLBL.setVerticalAlignment(JLabel.TOP);
		infoLBL.setFont(new Font("Verdana", Font.PLAIN, 15));
		infoLBL.setPreferredSize(new Dimension(310, 120));
		infoLBL.setForeground(new Color(120, 90, 40));
		infoLBL.setBackground(new Color(100, 20, 70));
		
		
		JScrollPane scrollPane = new JScrollPane(musterijeTabela);
		
		add(scrollPane, BorderLayout.CENTER);
		add(infoLBL, BorderLayout.SOUTH);
	}
	


	
	
	public void initActions() {
		
	}

}
