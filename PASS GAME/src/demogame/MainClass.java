package demogame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MainClass extends JPanel{
	public void paint(Graphics g){
		//g.setColor(Color.blue);
		//g.setFont(new Font("Helvetica Neue",Font.BOLD,40));
		//g.drawString("PASS",300,70);
		super.paint(g);		//invoke method From the Superclass.
		BufferedImage image=null;
		try {
			image=ImageIO.read(new File("src/NewBrick.png"));
			g.drawImage(image, 1, 1, 692, 592,null);
		}
		catch(IOException e) {
			e.printStackTrace();//printStackTrace() helps the programmer to understand where the actual problem occurred. It helps to trace the exception.
		}

	}
	
	public static void main(String args[]) {
	//private static final Graphics2D Graphics2D = null;
	Level2 L = new Level2();
	javax.swing.JFrame f=new JFrame();//Refrence for JFrame is created.JFrame is used to add a new frame
	f.getContentPane().add(new MainClass());
	GamePlay gamePlay=new GamePlay();//Create a Reference for class Gameplay.
	f.setTitle("BRICK BREAKER");//To set title in title Bar.
	f.setSize(700,600);//Size of window.
	f.setLocationRelativeTo(null);//Location of window in center.
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//The Program should stop working on executing.
	f.setBackground(Color.black);//Background of Window Black.
	f.setVisible(true);//Visibility of window.
	f.setResizable(true);

	
	JButton b1;  //Creates object b1
    JButton b2;
    JButton b3;
    JButton b4;
    
    Font font1;
    font1 = new Font("Aerial Black",Font.ITALIC,26);
    b1 =new JButton("LEVEL 1");//name of the button is added
    b2 = new JButton("LEVEL 2");
    b3 = new JButton("Help");
    b4 = new JButton("Quit");
    b1.setBounds(220,150,250,80);//Set x,y coordinates for Button and also the height and Width.
    b1.setFont(font1);//Sets the FontStyle of the Button.
    b1.setActionCommand("b1");//Sets the command name for the action event fired by this button. By default this action command is set to match the label of the button.
    b1.setBackground(Color.CYAN);//Set Background of the button
    // these next two lines do the magic..
    //b1.setContentAreaFilled(false);
    //b1.setOpaque(true);
    b1.addActionListener(new ActionListener() {     //When b1 is clicked
    	public void actionPerformed(ActionEvent e) {
    		f.setVisible(false);//the frame is not visible
			f.setSize(700,600); 
			f.remove(b1);   //Removes the button from the current Frame.
			f.remove(b2);
			f.remove(b3);
    		f.add(gamePlay); //Adds Gameplay
    		f.setVisible(true);//Sets visibility of Gameplay true.
    		f.setResizable(false);
    	}
    });
    
    b2.setBounds(220,310,250,80);
    b2.setFont(font1);
    b2.setActionCommand("b3");
    b2.setBackground(Color.GRAY);
    b2.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		f.setVisible(false);
			f.setSize(700,600);
			f.remove(b1);
			f.remove(b2);
			f.remove(b3);
    		f.add(L);
    		f.setVisible(true);
    		f.setResizable(false);
    	}
    });
   
    b3.setBounds(20,500,150,50);
    b3.setFont(font1);
    b3.setActionCommand("b2");
    b3.setBackground(Color.YELLOW);
    b3.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		JOptionPane.showMessageDialog(null,"Break all the Bricks and score maximum runs\nD = Dead Ball\n1 = 1 Run\n2 = 2 Runs\n4 = 4 Runs\n6 = 6 Runs");//Show cases a Dialouge Box.
    	}
    });
    
    b4.setBounds(530,500,150,50);
    b4.setFont(font1);
    b4.setActionCommand("b4");
    b4.setBackground(Color.RED);
    b4.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		 System.exit(0);//Closes all the windows and terminate the Program.
    	}
    });
    
	f.add(b1);//adds the button in the Menu.
	f.add(b2);
	f.add(b3);
	f.add(b4);
	}	
}