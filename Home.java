import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * False Position Method (Regula Falsi) Calculator
 * - can solve and show solutions on getting the root using the False Position Method.
 * 
 * @author Andrea Ella Remoreras
 * 
 * BSM325(NUMERICAL ANALYSIS) - FINAL OUTPUT
 *
 * 
 */
@SuppressWarnings("serial")
public class Home extends JFrame implements ActionListener {

	private JButton btn_proceed,btn_about;
	private JLabel lbl_title,lbl_proceed,lbl_about,lbl_icon;
	private JPanel panel_background1;
	
	Home(){
		Container pane = getContentPane();
		pane.setLayout(null);
		pane.setBackground(Color.white);
		
		panel_background1=new JPanel();
		panel_background1.setLayout(null);
		panel_background1.setBackground(new Color(0,102,204));
		
		lbl_icon=new JLabel();
		Image icon3 = new ImageIcon(this.getClass().getResource("/home_24.png")).getImage();
		lbl_icon.setIcon(new ImageIcon(icon3));
		
		lbl_title=new JLabel("FALSE POSITION METHOD");
		lbl_title.setFont(new Font("Tahoma",Font.BOLD,20));
		
		lbl_proceed= new JLabel("CALCULATOR");
		lbl_proceed.setFont(new Font("Tahoma",Font.BOLD,14));

		
		lbl_about= new JLabel("ABOUT");
		lbl_about.setFont(new Font("Tahoma",Font.BOLD,14));

		btn_proceed = new JButton("");
		Image icon1 = new ImageIcon(this.getClass().getResource("/calculator_64.png")).getImage();
		btn_proceed.setIcon(new ImageIcon(icon1));
		btn_proceed.setBackground(new Color(0,102,204));
		btn_proceed.setForeground(Color.WHITE);
		
		btn_about= new JButton("");
		Image icon2 = new ImageIcon(this.getClass().getResource("/info_64.png")).getImage();
		btn_about.setIcon(new ImageIcon(icon2));
		btn_about.setBackground(new Color(0,102,204));
		btn_about.setForeground(Color.WHITE);
		
		
		panel_background1.add(lbl_icon).setBounds(190,5,30,30);
		
		pane.add(panel_background1).setBounds(0,0,430,40);
		pane.add(lbl_title).setBounds(80,40,370,50);
		pane.add(btn_proceed).setBounds(40,100,100,100);
		pane.add(lbl_proceed).setBounds(40,210,150,20);
		pane.add(btn_about).setBounds(250,100,100,100);
		pane.add(lbl_about).setBounds(270,210,100,20);
		
		
		setTitle("HOME");
		setSize(430,290);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		btn_proceed.addActionListener(this);
		btn_about.addActionListener(this);
	
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {//This is where I've placed the function of the buttons when pressing it.
		// TODO Auto-generated method stub
		if(e.getSource().equals(btn_proceed)) {
			dispose();
			new RegulaFalsi();
			
		}
		else if(e.getSource().equals(btn_about)) {
			
			dispose();
			new About();
			}
	}
	
	public static void main(String[]args) {
		new Home();
	}
	
	
	
	

}
