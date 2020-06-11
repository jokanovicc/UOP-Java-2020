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
import gui.formeZaDodavanjeIzmene.ServiserForma;
import model.korisnici.Admin;
import model.korisnici.Musterija;
import model.korisnici.Serviser;
import radSaDatotekama.Datoteke;

public class AdminProzorPrikaz extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable adminiTabela;
	
	private Datoteke datoteka;
	
	public AdminProzorPrikaz(Datoteke datoteka) {
		this.datoteka=datoteka;
		setTitle("Admini");
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
		
		String[] zaglavlja = new String[] {"ID","Ime","Prezime","JMBG","Pol","Adresa","Broj telefona","Korisnicko Ime","Lozinka","Plata"};
		Object[][] sadrzaj = new Object[datoteka.sveNeobrisaneAdmini().size()][zaglavlja.length];
		
		for(int i=0; i<datoteka.sveNeobrisaneAdmini().size(); i++) {
			Admin admin = datoteka.sveNeobrisaneAdmini().get(i);
			sadrzaj[i][0] = admin.getIDOznaka();
			sadrzaj[i][1] = admin.getIme();
			sadrzaj[i][2] = admin.getPrezime();
			sadrzaj[i][3] = admin.getJmbg();
			sadrzaj[i][4] = admin.getPol();
			sadrzaj[i][5] = admin.getAdresa();
			sadrzaj[i][6] = admin.getBrojTelefona();
			sadrzaj[i][7] = admin.getUsername();
			sadrzaj[i][8] = admin.getLozinka();
			sadrzaj[i][9] = admin.getPlata();
			
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		adminiTabela = new JTable(tableModel);
		
		adminiTabela.setRowSelectionAllowed(true);
		adminiTabela.setColumnSelectionAllowed(false);
		adminiTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		adminiTabela.setDefaultEditor(Object.class, null);
		adminiTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(adminiTabela);
		
		add(scrollPane, BorderLayout.CENTER);
		
	}
	
	public void initActions() {
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminForma af = new AdminForma(datoteka, null);
				af.setVisible(true);
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = adminiTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null,"Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String adminID = tableModel.getValueAt(red, 0).toString();
					Admin admin = datoteka.nadjiAdmina(adminID);
					AdminForma af = new AdminForma(datoteka, admin);
					af.setVisible(true);
				}
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = adminiTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String adminID = adminiTabela.getValueAt(red, 0).toString();
					Admin admin =datoteka.nadjiAdmina(adminID);
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete Admina?", 	
				
							adminID + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						datoteka.obrisiAdmina(admin);
				}
			}
			}
		});
	}
		
		
		
	}
	
	
	
	
	
	

