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

import model.korisnici.Musterija;
import radSaDatotekama.Datoteke;

public class MusterijaPrikazInfo extends JFrame {
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable musterijeTabela;
	
	private Datoteke datoteka;
	
	
	public MusterijaPrikazInfo(Datoteke datoteka) {
		this.datoteka=datoteka;
		setTitle("Musterija");
		setSize(700, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		
	}
	
	
	public void initGUI() {
		
		String[] zaglavlja = new String[] {"ID","Ime","Prezime","JMBG","Pol","Adresa","Broj telefona","Korisnicko Ime","Broj Sakupljenih Bodova"};
		Object[][] sadrzaj = new Object[datoteka.sveNeobrisaneMusterije().size()][zaglavlja.length];
		
		for(int i=0; i<datoteka.sveNeobrisaneMusterije().size(); i++) {
			Musterija musterija = datoteka.sveNeobrisaneMusterije().get(i);
			sadrzaj[i][0] = musterija.getIDOznaka();
			sadrzaj[i][1] = musterija.getIme();
			sadrzaj[i][2] = musterija.getPrezime();
			sadrzaj[i][3] = musterija.getJmbg();
			sadrzaj[i][4] = musterija.getPol();
			sadrzaj[i][5] = musterija.getAdresa();
			sadrzaj[i][6] = musterija.getBrojTelefona();
			sadrzaj[i][7] = musterija.getUsername();
			sadrzaj[i][8] = musterija.getBrojSakupljenihBodova();
			
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		musterijeTabela = new JTable(tableModel);
		
		
		musterijeTabela.setRowSelectionAllowed(true);
		musterijeTabela.setColumnSelectionAllowed(false);
		musterijeTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		musterijeTabela.setDefaultEditor(Object.class, null);
		musterijeTabela.getTableHeader().setReorderingAllowed(false);
		
		
		JScrollPane scrollPane = new JScrollPane(musterijeTabela);
		
		add(scrollPane, BorderLayout.CENTER);
		
	}
	
	
	public void initActions() {
		
	}


}
