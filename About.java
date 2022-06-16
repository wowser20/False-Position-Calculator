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
public class About extends JFrame implements ActionListener{
	
	private JLabel lbl_description,lbl_icon,lbl_about;
	private JButton btn_back;
	private JPanel panel_background;
	
	
	About(){
	
		Container pane = getContentPane();
		pane.setLayout(null);
		pane.setBackground(Color.white);
				
		lbl_icon=new JLabel();
		Image icon1 = new ImageIcon(this.getClass().getResource("/info_64.png")).getImage();
		lbl_icon.setIcon(new ImageIcon(icon1));
		
		
		lbl_about =new JLabel("FALSE POSITION METHOD (REGULA FALSI)");
		lbl_about.setFont(new Font("Dialog",Font.BOLD,18));
		
			
		lbl_description=new JLabel();
		Image icon3 = new ImageIcon(this.getClass().getResource("/about_background.png")).getImage();
		lbl_description.setIcon(new ImageIcon(icon3));
		
		
		Image icon2 = new ImageIcon(this.getClass().getResource("/home2_24.png")).getImage();
		btn_back=new JButton ("");
		btn_back.setIcon(new ImageIcon(icon2));
		btn_back.setBackground(Color.WHITE);	
		btn_back.setForeground(Color.BLACK);
		btn_back.setBorder(null);
	
		
		
		panel_background= new JPanel();
		panel_background.setLayout(null);
		panel_background.setBackground(new Color(0,102,204));
		
	
		panel_background.add(btn_back).setBounds(10,10,80,30);
		panel_background.add(lbl_icon).setBounds(520,0,120,120);
		
		
		pane.add(panel_background).setBounds(0,0,1120,110);
		pane.add(lbl_description).setBounds(200,70,700,500);
		pane.add(lbl_description);
		
		setSize(1120,625);
		setTitle("ABOUT");
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		btn_back.addActionListener(this);
	
		
		}
	

	public static void main(String[]args) {
		new About();
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {//This is where I've placed the function of the buttons when pressing it.
		// TODO Auto-generated method stub
		if(e.getSource().equals(btn_back)) {
			
			dispose();
			new Home();
		}
			
	
		}
		
		
		
	}
