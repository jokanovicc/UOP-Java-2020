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
import model.servis.Servis;
import radSaDatotekama.Datoteke;

public class StatusServisaPrikaz extends JFrame {
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	private JLabel spis = new JLabel("Ovo su servisi koji su povezani sa vasim nalogom");
	private JButton zakaziBTN = new JButton("ZAKAZI SERVIS");

	
	
	private DefaultTableModel tableModel;
	private JTable servisTabela;
	
	private Datoteke datoteka;
	private Korisnik prijavljenKorisnik;
	
	
	public StatusServisaPrikaz(Datoteke datoteka, Korisnik prijavljenKorisnik) {
		this.datoteka=datoteka;
		this.prijavljenKorisnik = prijavljenKorisnik;
		setTitle("Vasi servisi");
		setSize(700, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		
	}
	
	public void initGUI() {
		ImageIcon addIcon = new ImageIcon(getClass().getResource("/slike/add.gif"));
		btnAdd.setIcon(addIcon);
		ImageIcon editIcon = new ImageIcon(getClass().getResource("/slike/edit.gif"));
		btnEdit.setIcon(editIcon);
	
		mainToolbar.add(btnAdd);
		mainToolbar.add(btnEdit);
		add(mainToolbar, BorderLayout.NORTH);
		
		String[] zaglavlja = new String[] {"ID","Automobil ID","Termin","Opis","Deo ID", "Status"};
		Object[][] sadrzaj = new Object[datoteka.servisPrikaz(prijavljenKorisnik.getIDOznaka()).size()][zaglavlja.length];

		for(int i=0; i<datoteka.servisPrikaz(prijavljenKorisnik.getIDOznaka()).size(); i++) {
			Servis servis = datoteka.servisPrikaz(prijavljenKorisnik.getIDOznaka()).get(i);
		//	if(prijavljenKorisnik.getIDOznaka().equals(servis.getVlasnikID())) {
			sadrzaj[i][0] = servis.getiDoznaka();
			sadrzaj[i][1] = servis.getAutomobilid();
			sadrzaj[i][2] = servis.getTerminSimpleDate();
			sadrzaj[i][3] = servis.getOpis();
			sadrzaj[i][4] = servis.getDeoID();
			sadrzaj[i][5] = servis.getStatus();
			
			
	//	}
	}
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		servisTabela = new JTable(tableModel);
		
		
		servisTabela.setRowSelectionAllowed(true);
		servisTabela.setColumnSelectionAllowed(false);
		servisTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		servisTabela.setDefaultEditor(Object.class, null);
		servisTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(servisTabela);
	    spis.setVerticalAlignment(JLabel.TOP);
	    spis.setFont(new Font("Verdana", Font.PLAIN, 15));
	    spis.setPreferredSize(new Dimension(290, 100));
	    spis.setForeground(new Color(120, 90, 40));
	    spis.setBackground(new Color(100, 20, 70));
		
		add(scrollPane, BorderLayout.CENTER);
		add(spis, BorderLayout.SOUTH);
		add(zakaziBTN, BorderLayout.SOUTH);
		
	}
	
	public void initActions() {
		
	}
	


}
