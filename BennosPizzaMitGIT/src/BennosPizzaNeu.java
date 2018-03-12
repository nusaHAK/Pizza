


import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class BennosPizzaNeu extends JFrame {

	private JLabel ueberschrift;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblSorte;
	private JLabel lblExtras;
	private JCheckBox chk1;
	private JCheckBox chk2;
	private JCheckBox chk3;
	private JCheckBox chk4;
	private JTextField txtAnmerkung;
	private JLabel lblAnmerkung;
	private JCheckBox chkAbholer;
	private JButton btnLoeschen;
	private JButton btnOK;
	private JButton btnAbbruch;
	
  public BennosPizzaNeu() {
	  setTitle("Formular mit GridBagLayout");
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  initComponents();
	  MyActionListener mylistener = new MyActionListener();
	  btnLoeschen.addActionListener(mylistener);
	  btnOK.addActionListener(mylistener);
	  btnAbbruch.addActionListener(mylistener);
	  
	  pack();
	  setVisible(true);
  }
  
  private class MyActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==btnLoeschen){
			txtName.setText("");
			chk1.setSelected(false);
			chk2.setSelected(false);
			chk3.setSelected(false);
			chk4.setSelected(false);
			txtAnmerkung.setText("");
			chkAbholer.setSelected(false);
			
		}
		else if (e.getSource()==btnAbbruch){
			System.exit(0);
		}
		else if (e.getSource() == btnOK){
			String sorte = "";
			String extras = "";
			String abholer = "";
			if (txtName.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Bitte geben Sie einen Namen ein.");
			}
			else{
			    if (chk1.isSelected() == false && chk2.isSelected()== false){
						JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Pizza aus.");
				}
				else {
					if (chk1.isSelected()== true){
						sorte = "Margherita";
					}
					if (chk3.isSelected() == true){
						sorte = sorte + " Schinken";
					}
					if (chk2.isSelected()){
						extras = "Mais";
					}
					if (chk4.isSelected()){
						extras = extras + " Pfeffersalami";
					}
					if (chkAbholer.isSelected()){
						abholer = "Abholer";
					}
					else {
						abholer = "Lieferung";
					}
					JOptionPane.showMessageDialog(null, "Name: " + txtName.getText() + 
							                            "\nPizza: " + sorte +
							                            "\nExtras: " + extras + 
							                            "\n " + abholer);
				}
			}
		}
	}
	
	  
  }
  
  private void initComponents(){
	  
	getContentPane().setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
    
    JLabel ueberschrift = new JLabel("Benno's Pizza Service");
    Font header = new Font("Sans Serif", Font.BOLD, 16);
    ueberschrift.setFont(header);
    ueberschrift.setForeground(Color.WHITE);
    ueberschrift.setHorizontalAlignment(JLabel.CENTER);
    c.gridx = 0; //Spalte
    c.gridy = 0; //Zeile
    c.gridwidth = 2;
    c.gridheight = 2;
    c.anchor = GridBagConstraints.CENTER;
    c.fill = GridBagConstraints.BOTH;
    c.insets = new Insets(0, 5, 0, 5);
    add(ueberschrift, c);
    /*
    BufferedImage mypic;
	try {
		mypic = ImageIO.read(this.getClass().getResource("pizza.jpg"));
		JLabel lblIcon = new JLabel(new ImageIcon(mypic));
		lblIcon.setToolTipText("Bennos Pizza");
	    c.gridx = 0; //Spalte
	    c.gridy = 0; //Zeile
	    c.gridwidth = 2;
	    c.gridheight = 1;
	    c.anchor = GridBagConstraints.CENTER;
	    c.insets = new Insets(0, 5, 0, 5);
		add(lblIcon,c);
	
	} catch (IOException e) {	
		e.printStackTrace();
	}
	catch (IllegalArgumentException ex) {
		System.err.println("Datei nicht gefunden!");
	}
	*/
    Font schriftart = new Font("SansSerif", Font.PLAIN, 12);
    c.gridx = 0; 
    c.gridy = 2;
    c.gridwidth = 2;
    c.gridheight = 1;
    c.anchor = GridBagConstraints.WEST;
    c.fill = GridBagConstraints.NONE;
    lblName  = new JLabel("Name:");
    lblName.setFont(schriftart);
    add(lblName, c);

    c.gridx = 0; 
    c.gridy = 3;
    c.insets = new Insets(0, 5, 0, 5);
    txtName = new JTextField(20);
    txtName.setFont(schriftart);
    add(txtName, c);

    c.gridx = 0; 
    c.gridy = 4;
    c.gridwidth = 1;
    lblSorte = new JLabel("Sorte:");
    lblSorte.setFont(schriftart);
    add(lblSorte, c);
    
    c.gridx = 1; 
    c.gridy = 4;
    lblExtras = new JLabel("Extras:");
    lblExtras.setFont(schriftart);
    add(lblExtras, c);

    c.gridx = 0; 
    c.gridy = 5;
    c.fill = GridBagConstraints.NONE; 
    chk1 = new JCheckBox("Margherita");
    chk1.setFont(schriftart);
    add(chk1, c);
    
    c.gridx = 1; 
    c.gridy = 5;
    chk2 = new JCheckBox("Mais");
    chk2.setFont(schriftart);
    add(chk2, c);
    
    c.gridx = 0; 
    c.gridy = 6;
    chk3 = new JCheckBox("Schinken");
    chk3.setFont(schriftart);
    add(chk3, c);
    
    c.gridx = 1; 
    c.gridy = 6;
    chk4 = new JCheckBox("Pfeffersalami");
    chk4.setFont(schriftart);
    add(chk4, c);

    c.gridx = 0; 
    c.gridy = 7;
    lblAnmerkung = new JLabel("Anmerkungen:");
    lblAnmerkung.setFont(schriftart);
    add(lblAnmerkung, c);

    c.gridx = 0; 
    c.gridy = 8;
    c.fill = GridBagConstraints.BOTH; //Komponente ausdehnen
    c.gridwidth = 1;
    c.gridheight = 2;
    c.insets = new Insets(0, 5, 0, 5);
    txtAnmerkung = new JTextField();
    txtAnmerkung.setFont(schriftart);
    add(txtAnmerkung, c);
   
    c.gridx = 1; 
    c.gridy = 8;
    c.fill = GridBagConstraints.NONE; 
    c.gridheight = 1;
    chkAbholer = new JCheckBox("Abholer");
    chkAbholer.setFont(schriftart);
    add(chkAbholer, c);

    c.gridx = 1; 
    c.gridy = 9;
    btnLoeschen = new JButton("Löschen");
    btnLoeschen.setFont(schriftart);
    add(btnLoeschen, c);
 
    c.gridx = 0; 
    c.gridy = 11;
    c.anchor = GridBagConstraints.CENTER; 
    c.fill = GridBagConstraints.NONE;
    c.insets = new Insets(20, 0, 10, 0);
    btnOK = new JButton("OK");
    btnOK.setFont(schriftart);
    add(btnOK, c);
    
    c.gridx = 1; 
    c.gridy = 11;
    c.anchor = GridBagConstraints.WEST;
    c.insets = new Insets(20, 5, 10, 0);
    btnAbbruch = new JButton("Abbruch");
    btnAbbruch.setFont(schriftart);
    add(btnAbbruch, c); 
  }

	public static void main(String[] args) {
		BennosPizzaNeu fenster = new BennosPizzaNeu();
	}
}