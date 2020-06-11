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

import gui.formeZaDodavanjeIzmene.ServiserForma;
import model.korisnici.Serviser;
import radSaDatotekama.Datoteke;

public class ServiserProzorPrikaz extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	
	private DefaultTableModel tableModel;
	private JTable serviserTabela;
	
	private Datoteke datoteka;
	
	public ServiserProzorPrikaz(Datoteke datoteka) {
		this.datoteka=datoteka;
		setTitle("Serviseri");
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
		
		String[] zaglavlja = new String[] {"ID","Ime","Prezime","JMBG","Pol","Adresa","Broj telefona","Korisnicko Ime","Lozinka","Plata","Specijalizacija"};
		Object[][] sadrzaj = new Object[datoteka.sveNeobrisaniServiseri().size()][zaglavlja.length];
		
		for(int i=0; i<datoteka.sveNeobrisaniServiseri().size(); i++) {
			Serviser serviser = datoteka.sveNeobrisaniServiseri().get(i);
			sadrzaj[i][0] = serviser.getIDOznaka();
			sadrzaj[i][1] = serviser.getIme();
			sadrzaj[i][2] = serviser.getPrezime();
			sadrzaj[i][3] = serviser.getJmbg();
			sadrzaj[i][4] = serviser.getPol();
			sadrzaj[i][5] = serviser.getAdresa();
			sadrzaj[i][6] = serviser.getBrojTelefona();
			sadrzaj[i][7] = serviser.getUsername();
			sadrzaj[i][8] = serviser.getLozinka();
			sadrzaj[i][9] = serviser.getPlata();
			sadrzaj[i][10] = serviser.getSpecijalizacija();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		serviserTabela = new JTable(tableModel);
		
		serviserTabela.setRowSelectionAllowed(true);
		serviserTabela.setColumnSelectionAllowed(false);
		serviserTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		serviserTabela.setDefaultEditor(Object.class, null);
		serviserTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(serviserTabela);
		
		add(scrollPane, BorderLayout.CENTER);
	}
	
	public void initActions() {
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ServiserForma sf = new ServiserForma(datoteka, null);
				sf.setVisible(true);
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = serviserTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null,"Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String serviserID = tableModel.getValueAt(red, 0).toString();
					Serviser serviser = datoteka.nadjiServisera(serviserID);
					ServiserForma sf = new ServiserForma(datoteka, serviser);
					sf.setVisible(true);
				}
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = serviserTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String serviserID = serviserTabela.getValueAt(red, 0).toString();
					Serviser serviser =datoteka.nadjiServisera(serviserID);
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete Automobil?", 	
				
							serviserID + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						datoteka.obrisiServisera(serviser);
				}
			}
			}
		});
	}
	

}
