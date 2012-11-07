import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;


public class filmoviGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edNaziv;
	private JTextField edGodina;
	private JTextField edZanr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					filmoviGui frame = new filmoviGui();
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
	public filmoviGui() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final LinkedList<filmovi> katalog = new LinkedList<filmovi>();
		
		JLabel lblNewLabel = new JLabel("Katalog filmova");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		lblNewLabel.setBounds(24, 11, 432, 28);
		contentPane.add(lblNewLabel);
		
		edNaziv = new JTextField();
		edNaziv.setBounds(94, 70, 86, 20);
		contentPane.add(edNaziv);
		edNaziv.setColumns(10);
		
		edGodina = new JTextField();
		edGodina.setBounds(94, 118, 86, 20);
		contentPane.add(edGodina);
		edGodina.setColumns(10);
		
		edZanr = new JTextField();
		edZanr.setBounds(94, 171, 86, 20);
		contentPane.add(edZanr);
		edZanr.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Naziv filma");
		lblNewLabel_1.setBounds(10, 73, 74, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Godina");
		lblNewLabel_2.setBounds(10, 121, 74, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Zanr");
		lblNewLabel_3.setBounds(10, 174, 74, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btUnesi = new JButton("Unesi");
		btUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				filmovi f = new filmovi();
				
				if(edNaziv.getText()=="")
					if(edNaziv.getText()==null)
						throw new RuntimeException("Unesite naziv filma");
				else
					f.setNaziv(edNaziv.getText());
				try {
					f.setGodina(Integer.parseInt(edGodina.getText()));
					
					
				} catch (NumberFormatException e) {
					
					JOptionPane.showMessageDialog(null, "Unesite godinu, ne tekst");
				}
				
				f.setZanr(edZanr.getText());
				
				for (int i = 0; i<katalog.size(); i++)
					if (!(katalog.contains(f)))
						katalog.add(f);
				edNaziv.setText("");
				edGodina.setText("");
				edZanr.setText("");
				
				
			}
		});
		btUnesi.setBounds(24, 238, 89, 23);
		contentPane.add(btUnesi);
		
		JButton btSacuvaj = new JButton("Sacuvaj");
		btSacuvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("katalog.txt")));
					for (int i = 0; i<katalog.size(); i++) {
						out.println(katalog.get(i).getNaziv() + ' ' + katalog.get(i).getGodina() + ' ' + katalog.get(i).getZanr() );
				
					}
					out.close();
				} catch (Exception p) {
					System.out.println("Greska" + p.getMessage());
				}
				
					
			}
			
		});
		
		btSacuvaj.setBounds(145, 238, 89, 23);
		contentPane.add(btSacuvaj);
	}
}
