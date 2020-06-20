package gui.formeZaDodavanjeIzmene;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.servis.Deo;
import model.servis.Servis;
import model.servis.ServisnaKnjizica;
import net.miginfocom.swing.MigLayout;
import radSaDatotekama.Datoteke;

public class KnjizicaForma extends JFrame {
	
	private JLabel lblID = new JLabel("ID");
	private JTextField txtID = new JTextField(20);
	
	private JLabel lblServisi = new JLabel("Servisi");
	private JTextField txtServisi = new JTextField(20);
	
	
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	
	
	private Datoteke datoteke;
	private ServisnaKnjizica knjizica;
	
	
	public KnjizicaForma(Datoteke datoteke, ServisnaKnjizica knjizica) {
		this.datoteke = datoteke;
		this.knjizica = knjizica;
		
		if(knjizica != null) {
			txtID.setEnabled(false);
			popuniPolja();
			setTitle("Izmeni knjizicu");
		}else {
			setTitle("Dodavanje nove knjizice");
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		setResizable(false);
		pack();
	}
	
	private void initGUI() {
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
		setLayout(layout);
		
		
		add(lblServisi);
		add(txtServisi);
		add(lblID);
		add(txtID);
		
		add(new JLabel());
		add(btnOk, " split 2");
		add(btnCancel);
		
	}
	
	private void initActions() {
		
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacije()) {
				String id = txtID.getText().trim();
				String servisID = txtServisi.getText().trim();
				
				String[] servisiSplit = servisID.split(";");
				ArrayList<Servis> servis2 = new ArrayList<Servis>();
				for (String sif : servisiSplit) {                         //ovo pravi listu delova
					Servis s = datoteke.nadjiServis(sif);
					if(s != null) {
						servis2.add(s);
						
					}
			//		System.out.println(servis2);
		
					
				}
				
				if(knjizica == null) {
		//		System.out.println(servis2);
				ServisnaKnjizica nova = new ServisnaKnjizica(servis2, id, false);
			//	System.out.println(nova);
				datoteke.dodajKnjizicu(nova);
				}else {
					knjizica.setIdOznaka(id);
					knjizica.setServisi(servis2);
				}
				datoteke.snimiKnjizicu();
				KnjizicaForma.this.dispose();
				KnjizicaForma.this.setVisible(false);
				
			}
			}
		});
	}
	
	
	public void popuniPolja() {
		txtID.setText(knjizica.getIdOznaka());
	}
	
	
	
	public boolean validacije() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		if(txtID.getText().trim().equals("")) {
			poruka += "- Morate uneti ID\n";
			ok = false;
	}else if(knjizica == null) {
		String id = txtID.getText().trim();
		ServisnaKnjizica pronadjen = datoteke.nadjiKnjizicu2(id);
		if(pronadjen != null) {
			poruka += "-Knjizica sa unetim ID vec postoji\n";
			ok = false;
	}
	}
		if(txtServisi.getText().trim().equals("")) {
			poruka += "- Morate uneti deo\n";
			ok = false;
		}else {
		String idDela =txtServisi.getText().trim();
//		Deo pronadjen = datoteka.nadjiDeo(idDela);
		String[] deloviSplit = idDela.split(";");
		ArrayList<Servis> deo2 = new ArrayList<Servis>();
		for (String sif : deloviSplit) {                         //ovo pravi listu delova
			Servis d = datoteke.nadjiServis(sif);
			if(d == null) {
				poruka += "- Nema takvog servisa kod nas";
				ok = false;
				
				
			}
			
		}
	}
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
		
		
}
}
