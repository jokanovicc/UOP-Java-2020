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

import gui.formeZaDodavanjeIzmene.ServisFormaZaAdmina;
import model.servis.Deo;
import model.servis.Servis;
import radSaDatotekama.Datoteke;

public class ServisProzorPrikaz extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	
	private DefaultTableModel tableModel;
	private JTable servisTabela;
	
	private Datoteke datoteka;
	
	
	public ServisProzorPrikaz(Datoteke datoteka) {
		this.datoteka=datoteka;
		setTitle("Servisi");
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
		
		String[] zaglavlja = new String[] {"ID","Automobil ID","Serviser ID","Termin","Opis","Deo ID", "Status","Troskovi"};
		Object[][] sadrzaj = new Object[datoteka.sviNeobrisaniServisi().size()][zaglavlja.length];

		for(int i=0; i<datoteka.sviNeobrisaniServisi().size(); i++) {
			Servis servis = datoteka.sviNeobrisaniServisi().get(i);
			sadrzaj[i][0] = servis.getiDoznaka();
			sadrzaj[i][1] = servis.getAutomobilid();
			sadrzaj[i][2] = servis.getServiserid();
			sadrzaj[i][3] = servis.getTerminSimpleDate();
			sadrzaj[i][4] = servis.getOpis();
			sadrzaj[i][5] = servis.getDeoID();
			sadrzaj[i][6] = servis.getStatus();
			sadrzaj[i][7] = servis.getTroskovi();
			
			
		}
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		servisTabela = new JTable(tableModel);
		
		
		servisTabela.setRowSelectionAllowed(true);
		servisTabela.setColumnSelectionAllowed(false);
		servisTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		servisTabela.setDefaultEditor(Object.class, null);
		servisTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(servisTabela);
		
		add(scrollPane, BorderLayout.CENTER);
		
	}
	
	public void initActions() {
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ServisFormaZaAdmina sfza = new ServisFormaZaAdmina(datoteka, null);
				sfza.setVisible(true);
				
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = servisTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null,"Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String servisID = tableModel.getValueAt(red, 0).toString();
					Servis servis = datoteka.nadjiServis(servisID);
					ServisFormaZaAdmina sfza = new ServisFormaZaAdmina(datoteka, servis);
					sfza.setVisible(true);
				}
				
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = servisTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String servisID = tableModel.getValueAt(red, 0).toString();
					Servis servis = datoteka.nadjiServis(servisID);
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete Servis?", 	
				
							servisID + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					
					if(izbor == JOptionPane.YES_OPTION) {
						datoteka.obrisiServis(servis);
					}
				}
				
			}
		});
		
	}
}
