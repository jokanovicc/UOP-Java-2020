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

import gui.formeZaDodavanjeIzmene.AdminForma;
import gui.formeZaDodavanjeIzmene.KnjizicaForma;
import model.korisnici.Admin;
import model.servis.Deo;
import model.servis.ServisnaKnjizica;
import radSaDatotekama.Datoteke;

public class KnjizicaProzorPrikaz extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	
	private DefaultTableModel tableModel;
	private JTable knjizicaTabela;
	
	private Datoteke datoteka;
	
	public KnjizicaProzorPrikaz(Datoteke datoteka) {
		this.datoteka=datoteka;
		setTitle("Servisne Knjizice");
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
		
		String[] zaglavlja = new String[] {"ID","Servisi ID"};
		Object[][] sadrzaj = new Object[datoteka.sveNeobrisaneKnjizice().size()][zaglavlja.length];
	
		for(int i=0; i<datoteka.sveNeobrisaneKnjizice().size(); i++) {
			ServisnaKnjizica knjizica = datoteka.sveNeobrisaneKnjizice().get(i);
			sadrzaj[i][0] = knjizica.getIdOznaka();
			sadrzaj[i][1] = knjizica.getServisID();
		

			
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		knjizicaTabela = new JTable(tableModel);
		
		knjizicaTabela.setRowSelectionAllowed(true);
		knjizicaTabela.setColumnSelectionAllowed(false);
		knjizicaTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		knjizicaTabela.setDefaultEditor(Object.class, null);
		knjizicaTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(knjizicaTabela);
		
		add(scrollPane, BorderLayout.CENTER);
		
	}
	public void initActions() {
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KnjizicaForma kf = new KnjizicaForma(datoteka, null);
				kf.setVisible(true);
			
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = knjizicaTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null,"Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String knjizicaID = tableModel.getValueAt(red, 0).toString();
					ServisnaKnjizica knjizica = datoteka.nadjiKnjizicu2(knjizicaID);
					KnjizicaForma kf = new KnjizicaForma(datoteka, knjizica);
					kf.setVisible(true);
				}
			}				
				
			
		});
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = knjizicaTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String knjizicaID = knjizicaTabela.getValueAt(red, 0).toString();
					ServisnaKnjizica knjizica =datoteka.nadjiKnjizicu2(knjizicaID);
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete Admina?", 	
				
							knjizicaID + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						datoteka.obrisiKnjizicu(knjizica);
				}
			}
				
			}
		});
	}
}
