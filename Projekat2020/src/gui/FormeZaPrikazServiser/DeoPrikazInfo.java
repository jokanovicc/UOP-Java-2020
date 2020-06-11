package gui.FormeZaPrikazServiser;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import model.servis.Deo;
import radSaDatotekama.Datoteke;

public class DeoPrikazInfo extends JFrame {
	private JToolBar mainToolbar = new JToolBar();
	
	
	private DefaultTableModel tableModel;
	private JTable deoTabela;
	
	private Datoteke datoteka;
	
	public DeoPrikazInfo(Datoteke datoteka) {
		this.datoteka=datoteka;
		setTitle("Delovi");
		setSize(700, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		
	}
	
	public void initGUI() {
	
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
	
	

}
