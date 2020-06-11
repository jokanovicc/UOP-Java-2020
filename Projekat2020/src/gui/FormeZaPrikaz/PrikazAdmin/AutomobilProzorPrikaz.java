package gui.FormeZaPrikaz.PrikazAdmin;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import gui.formeZaDodavanjeIzmene.AutoForma;
import gui.formeZaDodavanjeIzmene.DeoForma;
import model.automobili.Automobil;
import model.korisnici.Musterija;
import model.servis.Deo;
import radSaDatotekama.Datoteke;

public class AutomobilProzorPrikaz extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable autoTabela;
	
	private Datoteke datoteka;
	
	public AutomobilProzorPrikaz(Datoteke datoteka) {
		this.datoteka=datoteka;
		setTitle("Automobili");
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
		ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/slike/remove.gif"));
		btnDelete.setIcon(deleteIcon);
		
		mainToolbar.add(btnAdd);
		mainToolbar.add(btnEdit);
		mainToolbar.add(btnDelete);
		add(mainToolbar, BorderLayout.NORTH);
		
		String[] zaglavlja = new String[] {"ID","Marka i Model","Godina Proizvodnje","Zapremina Motora","Snaga","Gorivo","Vlasnik ID"};
		Object[][] sadrzaj = new Object[datoteka.sviNeobrisaniAutomobili().size()][zaglavlja.length];
		
		for(int i=0; i<datoteka.sviNeobrisaniAutomobili().size(); i++) {
			Automobil automobil = datoteka.sviNeobrisaniAutomobili().get(i);
			sadrzaj[i][0] = automobil.getIdOznaka();
			sadrzaj[i][1] = automobil.getMarkaModel();
			sadrzaj[i][2] = automobil.getGodinaProizvodnje();
			sadrzaj[i][3] = automobil.getZapreminaMotora();
			sadrzaj[i][4] = automobil.getSnaga();
			sadrzaj[i][5] = automobil.getVrstaGoriva();
			sadrzaj[i][6] = automobil == null ? "--" : automobil.getVlasnikId();

			
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
	
	public void initActions() {
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AutoForma af = new AutoForma(datoteka, null);
				af.setVisible(true);
				
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = autoTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null,"Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String autoID = tableModel.getValueAt(red, 0).toString();
					Automobil automobil = datoteka.nadjiAutomobil(autoID);
					AutoForma af = new AutoForma(datoteka, automobil);
					af.setVisible(true);
				}
				
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = autoTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String autoID = tableModel.getValueAt(red, 0).toString();
					Automobil automobil = datoteka.nadjiAutomobil(autoID);
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete Automobil?", 	
				
							autoID + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
				if(izbor == JOptionPane.YES_OPTION) {
					datoteka.obrisiAutomobil(automobil);;
				}
				
				}
				
			}
		});
		
	}
	
	
	

}
