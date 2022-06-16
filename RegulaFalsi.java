import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
/*
 * False Position Method (Regula Falsi) Calculator
 * - can solve and show solutions on getting the approximate root using the False Position Method(Regula Falsi).
 * 
 * @author Andrea Ella Remoreras
 * 
 * BSM325(NUMERICAL ANALYSIS) - FINAL OUTPUT
 * 
 */


@SuppressWarnings("serial")
public class RegulaFalsi extends JFrame implements ActionListener{

	private JLabel lbl_title,lbl_function,lbl_1stguess,lbl_2ndguess,lbl_icon;
	private JTextField txt_function,txt_1stguess,txt_2ndguess;
	private JButton btn_find,btn_clear,btn_clear2,btn_exit,btn_help;
	private JPanel  panel_results,panel_background1,panel_background2;
	private JTextArea txt_results3,txt_results,txt_results2;
	private JScrollPane scroller;
	
	
	
	RegulaFalsi(){
		
		Container pane = getContentPane();
		pane.setLayout(null);
		pane.setBackground(Color.white);
		
		
		
		lbl_icon=new JLabel();
		Image icon2 = new ImageIcon(this.getClass().getResource("/calculator_64.png")).getImage();
		lbl_icon.setIcon(new ImageIcon(icon2));
		
		
		lbl_title= new JLabel("False Position Method (Regula Falsi)");
		lbl_title.setFont(new Font("Dialog",Font.BOLD,22));
		
		lbl_function= new JLabel("Function: ");
		lbl_function.setFont(new Font("Tahoma", Font.BOLD, 12));	
		
		lbl_1stguess=new JLabel("Lower: ");
		lbl_1stguess.setFont(new Font("Tahoma", Font.BOLD, 12));	
		
		lbl_2ndguess=new JLabel("Upper: ");
		lbl_2ndguess.setFont(new Font("Tahoma", Font.BOLD, 12));	
		
		
		txt_function=new JTextField("");
		txt_function.setFont(new Font("DialogInput", Font.PLAIN, 14));	
		
		txt_1stguess=new JTextField("");
		txt_1stguess.setFont(new Font("DialogInput", Font.PLAIN, 14));	
		
		txt_2ndguess=new JTextField("");
		txt_2ndguess.setFont(new Font("DialogInput", Font.PLAIN, 14));	
		
		
		txt_results=new JTextArea("");
		txt_results.setEditable(false);
		
		txt_results2=new JTextArea("");
		txt_results2.setEditable(false);
		txt_results2.setFont(new Font("Cambria Math", Font.PLAIN,16));	
		
		txt_results3=new JTextArea("");
		txt_results3.setEditable(false);
		
		btn_find=new JButton("Find");
		btn_find.setBackground(new Color(0,102,204));
		btn_find.setFont(new Font("Dialog", Font.BOLD, 15));	
		btn_find.setForeground(Color.WHITE);
		
		
		btn_clear=new JButton("Clear");
		btn_clear.setBackground(new Color(0,102,204));
		btn_clear.setFont(new Font("Dialog", Font.BOLD, 15));	
		btn_clear.setForeground(Color.WHITE);
		
		
		btn_clear2=new JButton("Clear");
		btn_clear2.setBackground(new Color(0,102,204));
		btn_clear2.setFont(new Font("Dialog", Font.BOLD, 15));	
		btn_clear2.setForeground(Color.WHITE);
		
		btn_help=new JButton("Help");
		btn_help.setBackground(new Color(0,102,204));
		btn_help.setFont(new Font("Dialog", Font.BOLD, 15));	
		btn_help.setForeground(Color.WHITE);
		
		
		
		Image icon1 = new ImageIcon(this.getClass().getResource("/home2_24.png")).getImage();
		btn_exit=new JButton("");
		btn_exit.setIcon(new ImageIcon(icon1));
		btn_exit.setBackground(Color.WHITE);	
		btn_exit.setForeground(Color.BLACK);
		btn_exit.setBorder(null);
	
		
		panel_results=new JPanel();
		panel_results.setBorder(BorderFactory.createTitledBorder("RESULTS"));
		panel_results.setBackground(Color.WHITE);
		panel_results.setFont(new Font("SansSerif", Font.BOLD, 13));	
		
		
		scroller=new JScrollPane(txt_results2);
		scroller.setViewportView(txt_results2);
		scroller.setBorder(null);
		
		
		panel_background1=new JPanel();
		panel_background1.setLayout(null);
		panel_background1.setBackground(new Color(0,102,204));
		
		
		panel_background2=new JPanel();
		panel_background2.setLayout(null);
		panel_background2.setBackground(new Color(0,102,204));
		
		
		panel_background1.add(btn_exit).setBounds(10,10,80,30);
		panel_background1.add(lbl_icon).setBounds(500,0,120,120);
		
		panel_results.add(txt_results2);	
		
		
		pane.add(panel_background1).setBounds(0,0,1150,110);
		pane.add(lbl_title).setBounds(50,115,700,30);
		pane.add(lbl_function).setBounds(50,160,70,25);pane.add(txt_function).setBounds(110,160,300,25);
		pane.add(lbl_1stguess).setBounds(50,190,70,25);pane.add(txt_1stguess).setBounds(110,190,140,25);
		pane.add(lbl_2ndguess).setBounds(50,220,70,25);pane.add(txt_2ndguess).setBounds(110,220,140,25);
		pane.add(btn_find).setBounds(50,250,90,30);pane.add(btn_clear).setBounds(160,250,90,30);pane.add(btn_help).setBounds(320,250,90,30);
		pane.add(panel_results).setBounds(50,310,1000,300);
		pane.add(btn_clear2).setBounds(520,630,100,30);
		pane.add(scroller).setBounds(60,330,980,275);
		
		
		setSize(1120,720);
		setTitle("CALCULATOR");
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		btn_help.addActionListener(this);
		btn_find.addActionListener(this);
		btn_clear.addActionListener(this);
		btn_clear2.addActionListener(this);
		btn_exit.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {//This is where I've placed the function of the buttons when pressing it.
		// TODO Auto-generated method stub
		if(e.getSource().equals(btn_find)) {
			
			
			if(txt_function.getText().isEmpty()||txt_1stguess.getText().isEmpty()||txt_2ndguess.getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(null,"Please input the missing values to proceed");
				
			}
			
			else {
			
			try {
			 String str_lower1="",str_upper1="",str_results1,str_iteration,str_all="",str_conclusion,rounded_lower,rounded_upper,rounded_newx,rounded_fnew,rounded_error,rounded_functionupper,rounded_functionlower,str_function,str_solution = "",str_functionresult;
			 float x_lower=0, x_upper=0, new_x, f0, f1, fnew, re = 100,te=(float) 0.001,rounded_newx_2,rounded_upper_2,rounded_lower_2;
		
			 int iteration = 1;
			
		
			 /* Inputs */
			 str_function=txt_function.getText();
			 
			 str_lower1=txt_1stguess.getText();
			 x_lower=Float.parseFloat(str_lower1);
			
			 
			 str_upper1=txt_2ndguess.getText();
			 x_upper=Float.parseFloat(str_upper1);
			
					 
			 Expression expression1 =new ExpressionBuilder(txt_function.getText()).variables("x")
				      .build()
				      .setVariable("x", x_lower);
			          float lower_function = (float) expression1.evaluate();
				  
			          f0 =lower_function;
			 
		     
		     Expression expression2 =new ExpressionBuilder(txt_function.getText()).variables("x")
				      .build()
				      .setVariable("x", x_upper);
		              float upper_function = (float) expression2.evaluate();
		              
		              f1 = upper_function ;
		
			 /* Checking whether given guesses brackets the root or not. */
			 if( f0*f1 > 0)
			 {
				txt_results2.setText("Here f(a)<0 and f(b)<0\r\n"
				  		+ "\r\n"
				  		+ "So, Solution is not possible. Try Again");
				  
			 }
			 else {
				 str_results1=("\n\nIteration\t x0\t f(x0)\t x1\t f(x1)\t new x\tf(new x)\tRelative Error %"+"\n");
			 
			/* Implementing Regula Falsi or False Position Method */
			 do
			 {
				 rounded_upper = String.format("%.4f", x_upper);
				 rounded_lower = String.format("%.4f",x_lower);
				
				  new_x = x_lower - (x_lower-x_upper) * f0/(f0-f1);
				  
				  Expression expression3 =new ExpressionBuilder(txt_function.getText()).variables("x")
					      .build()
					      .setVariable("x", new_x);
			              float new_function = (float) expression3.evaluate();
			              
				  fnew = new_function;
				  
				  str_iteration = Integer.toString(iteration);
				  
				  rounded_functionupper=String.format("%.4f", f1);
				  rounded_functionlower= String.format("%.4f", f0);
				  rounded_newx = String.format("%.4f", new_x);
				  rounded_fnew = String.format("%.4f", fnew);
				  rounded_error = String.format("%.2f", re);
				  
				  rounded_newx_2=Float.parseFloat(rounded_newx);
				  rounded_lower_2=Float.parseFloat(rounded_lower);
				  rounded_upper_2=Float.parseFloat(rounded_upper);
				  
				  str_functionresult="f(x)= "+str_function+"\n________________________________________________________________________________________________________________________________________";
				  str_all+="\n"+str_iteration+"\t"+rounded_lower+"\t"+rounded_functionlower+"\t"+rounded_upper+"\t"+rounded_functionupper+"\t"+rounded_newx+"\t"+ rounded_fnew +"\t"+rounded_error+"%";
				  
				  
				  if(f0*fnew < 0)
				  {
					  str_solution+="\n\nIteration "+str_iteration+
							  "\nHere f("+rounded_lower+") = "+rounded_functionlower+" > 0 and f("+rounded_upper+") = "+rounded_functionupper+" < 0"+
							  "\n\nNow, the root lies between x0 = "+rounded_lower+" and "+"x1 = "+rounded_upper+"\n"+
							  "\nx"+str_iteration+" = "+" x0 - f(x0) * (x1 - x0 / f(x1) - f(x0))\n"+
						       "\nx"+str_iteration+" = "+rounded_lower+" - "+rounded_functionlower+"*"+"(("+rounded_upper+" - "+rounded_lower+") / ("+rounded_functionupper+" - "+rounded_functionlower+"))"+
						       "\n\nx"+str_iteration+" = "+rounded_newx+
						       "\n\nf(x"+str_iteration+")"+" = f("+rounded_newx+")"+ " = "+rounded_fnew + " < 0\n"+
						       "\nAbsolute Relative Error: \n"+"Ea"+str_iteration+" = |xnew - xold / xnew |* 100\n"+"Ea"+str_iteration+" = "+"|"+rounded_newx+" - "+rounded_upper+ " / "+rounded_newx+"| * 100"+
						       "\nEa"+str_iteration+" = "+ rounded_error+"%"+
						       "\n________________________________________________________________________________________________________________________________________";
					  
					   re=Math.abs((rounded_newx_2-rounded_upper_2)/rounded_newx_2)*100;
					   x_upper = new_x;
					   f1 = fnew;
					   //the upper changes
				  }
				  else {
					  str_solution+= "\n\nIteration "+str_iteration+
							  "\nHere f("+rounded_lower+") = "+rounded_functionlower+" < 0 and f("+rounded_upper+") = "+rounded_functionupper+" > 0"+
							  "\n\nNow, the root lies between x0 = "+rounded_lower+" and "+"x1 = "+rounded_upper+"\n"+
							  "\nx"+str_iteration+" = "+" x0 - f(x0) * (x1 - x0) / (f(x1) - f(x0))\n"+
						       "\nx"+str_iteration+" = "+rounded_lower+"- "+rounded_functionlower+"*"+"(("+rounded_upper+" - "+rounded_lower+") / ("+rounded_functionupper+" - "+rounded_functionlower+"))"+
						       "\n\nx"+str_iteration+" = "+rounded_newx+
						       "\n\nf(x"+str_iteration+")"+" = f("+rounded_newx+")"+ " = "+rounded_fnew + " < 0\n"+
					  		   "\nAbsolute Relative Error: \n"+"Ea"+str_iteration+" = |xnew - xold / xnew| * 100\n"+"Ea"+str_iteration+" = "+"|"+rounded_newx+" - "+rounded_lower+ " / "+rounded_newx+"| * 100"+
						       "\nEa"+str_iteration+" = "+ rounded_error+"%"+
					  		   "\n________________________________________________________________________________________________________________________________________";
					   
					   re=Math.abs((rounded_newx_2-rounded_lower_2)/rounded_newx_2)*100;
					   x_lower = new_x;
					   f0 = fnew;
					   //the lower changes
				  }
				  iteration = iteration + 1;
				 
			 }while(Math.abs(fnew)>te);
			 
			 //this is where I've placed all of the results
		
			 str_conclusion="\n________________________________________________________________________________________________________________________________________"+
			 "\nRoot found on  Iteration "+(iteration-1)+"\n" +
			 "\nApproximate Root: "+rounded_newx +
			 "\nAbsolute Relative Error: "+rounded_error+" %";
			 
			 txt_results2.setText(str_functionresult+str_solution+str_results1+str_all+str_conclusion);
			 scroller.setViewportView(txt_results2);
			 scroller.setBorder(null);
			
			}
			}
			catch(Exception i) {
				JOptionPane.showMessageDialog(null,"Please enter the values correctly");
			}
			}
			}
		
		else if(e.getSource().equals(btn_clear)) {
			txt_function.setText("");
			txt_1stguess.setText("");
			txt_2ndguess.setText("");
	
			}
		else if(e.getSource().equals(btn_help)){
			
			new Help();
			
			
		
		}
		else if(e.getSource().equals(btn_clear2)) {
			txt_results.setText("");
			txt_results2.setText("");
			}
		else if(e.getSource().equals(btn_exit)) {
			dispose();
			new Home();
			}
			}
public static void main (String[]args0) {
	
	new RegulaFalsi();
	
			}
			}
