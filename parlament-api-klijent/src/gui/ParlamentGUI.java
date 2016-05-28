package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import tablemodel.ParlamentTableModel;

public class ParlamentGUI extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel;
	private JScrollPane scrollPane_1;
	private JTextArea textArea;
	private JButton btnPreuzmiClanove;
	private JButton btnPopuniTabelu;
	private JButton btnSacuvajPromene;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParlamentGUI frame = new ParlamentGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ParlamentGUI() {
		setTitle("Clanovi parlamenta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		contentPane.add(getPanel(), BorderLayout.EAST);
		contentPane.add(getScrollPane_1(), BorderLayout.SOUTH);
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new ParlamentTableModel());
			table.getColumnModel().getColumn(3).setPreferredWidth(89);
		}
		return table;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(130, 10));
			panel.add(getBtnPreuzmiClanove());
			panel.add(getBtnPopuniTabelu());
			panel.add(getBtnSacuvajPromene());
		}
		return panel;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setMinimumSize(new Dimension(100, 23));
			scrollPane_1.setMaximumSize(new Dimension(100, 32767));
			scrollPane_1.setPreferredSize(new Dimension(100, 50));
			scrollPane_1.setViewportView(getTextArea());
		}
		return scrollPane_1;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBorder(new TitledBorder(null, "STATUS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		}
		return textArea;
	}
	private JButton getBtnPreuzmiClanove() {
		if (btnPreuzmiClanove == null) {
			btnPreuzmiClanove = new JButton("Preuzmi clanove");
			btnPreuzmiClanove.setPreferredSize(new Dimension(125, 25));
		}
		return btnPreuzmiClanove;
	}
	private JButton getBtnPopuniTabelu() {
		if (btnPopuniTabelu == null) {
			btnPopuniTabelu = new JButton("Popuni tabelu");
			btnPopuniTabelu.setPreferredSize(new Dimension(125, 25));
			btnPopuniTabelu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
		}
		return btnPopuniTabelu;
	}
	private JButton getBtnSacuvajPromene() {
		if (btnSacuvajPromene == null) {
			btnSacuvajPromene = new JButton("Sacuvaj promene");
			btnSacuvajPromene.setPreferredSize(new Dimension(125, 25));
		}
		return btnSacuvajPromene;
	}
}
