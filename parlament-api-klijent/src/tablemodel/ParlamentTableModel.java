package tablemodel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import domen.Poslanik;

public class ParlamentTableModel extends AbstractTableModel{
	private final String[] kolone = {"Id", "Ime", "Prezime", "Datum rodjenja"};
	private LinkedList<Poslanik> poslanici = new LinkedList<>();
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if(poslanici==null){
			return 0;
		}
		return poslanici.size();
	}
	
	@Override
	public void setValueAt(Object o, int red, int kolona) {
		// TODO Auto-generated method stub
		Poslanik p = poslanici.get(red);

		switch (kolona) {
		case 1:
			String ime = o.toString();
			if (ime != null && !ime.isEmpty()) {
				p.setIme(ime);
			} else {
				JOptionPane.showMessageDialog(null, "Ime nije ispravno uneto!", "Greska",
						JOptionPane.ERROR_MESSAGE);
			}
			break;

		case 2:
			String prezime = o.toString();
			if (prezime != null && !prezime.isEmpty()) {
				p.setPrezime(prezime);
			} else {
				JOptionPane.showMessageDialog(null, "Prezime nije ispravno uneto!", "Greska!",
						JOptionPane.ERROR_MESSAGE);
			}
			break;

		case 3:
			String datumS = o.toString();
			try {
				Date datum = sdf.parse(datumS);
				p.setDatumRodjenja(datum);
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "Datum mora biti u formatu: dd.MM.yyyy!", "Greska!",
						JOptionPane.ERROR_MESSAGE);
			}

			break;

		default:
			return;
		}
		fireTableCellUpdated(red, kolona);
	}
	@Override
	public Object getValueAt(int red, int kolona) {
		// TODO Auto-generated method stub
		Poslanik p = new Poslanik();
		p = poslanici.get(red);
		switch(kolona){
		case 0: return p.getId();
		case 1: return p.getIme();
		case 2: return p.getPrezime();
		case 3: return p.getDatumRodjenja();
		default: return "";
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if(columnIndex == 0){
			return false;
		} else{
			return true;
		}
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return kolone[column];
	}

	public LinkedList<Poslanik> getPoslanici() {
		return poslanici;
	}

	public void setPoslanici(LinkedList<Poslanik> poslanici) {
		this.poslanici = poslanici;
		fireTableDataChanged();
	}
	
	
	
}
