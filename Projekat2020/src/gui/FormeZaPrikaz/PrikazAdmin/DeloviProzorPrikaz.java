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

import gui.formeZaDodavanjeIzmene.DeoForma;
import model.korisnici.Musterija;
import model.servis.Deo;
import radSaDatotekama.Datoteke;

public class DeloviProzorPrikaz extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	
	private DefaultTableModel tableModel;
	private JTable deoTabela;
	
	private Datoteke datoteka;
	
	public DeloviProzorPrikaz(Datoteke datoteka) {
		this.datoteka=datoteka;
		setTitle("Delovi");
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
		
		String[] zaglavlja = new String[] {"ID","Automobil","Naziv","Cena"};
		Object[][] sadrzaj = new Object[datoteka.sviNeobrisaniDelovi().size()][zaglavlja.length];
		
		for(int i=0; i<datoteka.sviNeobrisaniDelovi().size(); i++) {
			Deo deo = datoteka.sviNeobrisaniDelovi().get(i);
			sadrzaj[i][0] = deo.getIdDela();
			sadrzaj[i][1] = deo.getAutomobil();
			sadrzaj[i][2] = deo.getNaziv();
			sadrzaj[i][3] = deo.getCena();

			
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		deoTabela = new JTable(tableModel);
		
		
		deoTabela.setRowSelectionAllowed(true);
		deoTabela.setColumnSelectionAllowed(false);
		deoTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		deoTabela.setDefaultEditor(Object.class, null);
		deoTabela.getTableHeader().setReorderingAllowed(false);
		
		
		JScrollPane scrollPane = new JScrollPane(deoTabela);
		
		add(scrollPane, BorderLayout.CENTER);
		
	}
	
	public void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = deoTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String deoID = tableModel.getValueAt(red, 0).toString();
					Deo deo = datoteka.nadjiDeo(deoID);
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete deo?", 	
				
							deoID + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
				if(izbor == JOptionPane.YES_OPTION) {
					datoteka.obrisiDeo(deo);
				}
				
				}
				
				
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DeoForma df = new DeoForma(datoteka,null);
				df.setVisible(true);
				
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = deoTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null,"Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String deoID = tableModel.getValueAt(red, 0).toString();
					Deo deo = datoteka.nadjiDeo(deoID);
					DeoForma df = new DeoForma(datoteka, deo);
					df.setVisible(true);
				}
				
			}
		});
		
		
	}
	
}
	

