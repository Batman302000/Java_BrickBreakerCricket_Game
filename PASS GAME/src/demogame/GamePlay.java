package demogame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;//Fires one or more ActionEvents at specified intervals
public class GamePlay extends JPanel implements ActionListener,KeyListener{
	//private static final Graphics2D Graphics2D = null;
	private boolean play=false;
	private int score=0;        //Initially the score is Zero.
	private int totalBrick=15;
	private Timer timer;
	private int delay=8;
	private int ballposX=120;//Starting Position Of Ball in X Axis
	private int ballposY=230;//Starting Position Of Ball in Y Axis
	private int ballXdir=3;//Displacement of Ball in X direction
	private int ballYdir=4;//Displacement of Ball in Y direction
	private int playerX=200;//Position of Paddle
	private MapGenerator map; //creates a reference for class MapGenerator.
	public GamePlay() {
		addKeyListener(this);               //The Java KeyListener is notified whenever you change the state of key.
		setFocusable(true);					
		timer=new Timer(delay,this);        //Interval for timer or Delay.
		timer.start();     					//Starts the Timer
		map=new MapGenerator(3,5);			//the value of i and j are given through the arguments
	}
	public void paint(Graphics g) {
//The Graphics class provides the framework for all graphics operations within the AWT.	
		super.paint(g);		//invoke method From the Superclass.
		BufferedImage image=null;
		try {
			image=ImageIO.read(new File("src/maidan2.jpg"));
			g.drawImage(image, 1, 1, 692, 592,null);
		}
		catch(IOException e) {
			e.printStackTrace();//printStackTrace() helps the programmer to understand where the actual problem occurred. It helps to trace the exception.
		}

		
		//border
		g.setColor(Color.yellow);
		g.fillRect(0,0, 692, 3);			// position of border
		g.fillRect(0,3,3,592) ;
		g.fillRect(691, 3,3,592);
		//paddle
		g.setColor(Color.white);
		g.fillRect(playerX, 550, 150, 14);	//For Stroke of Bat.
		g.setColor(Color.red);
		g.fillRect(playerX+150, 554, 60, 6);//For Handle of Bat.
		
		//bricks
		map.draw((Graphics2D )g);
		//ball
		g.setColor(Color.red);
		g.fillOval(ballposX, ballposY, 20, 20);
		//score
		g.setColor(Color.black);					//Colour of String
		g.setFont(new Font("RUNS: ",Font.BOLD,35));
		g.drawString("RUNS: " + score, 520,40);
		//gameover
		if(ballposY>=570) {				//When you miss the shot
			play=false;
			ballXdir=0;
			ballYdir=0;
			g.setColor(Color.black);
			g.setFont(new Font("serif",Font.BOLD,40));
			g.drawString("GAME OVER !    :( ",200,250);
			g.setFont(new Font("serif",Font.BOLD,40));
			g.drawString("RUNS:"+ score,200,300);
			g.setFont(new Font("serif",Font.BOLD,30));
			g.drawString("PRESS ENTER TO PLAY :)",200,350);	
		}
		if(totalBrick<=0) {					//when all the blocks are smashed.	
			play=false;
			ballXdir=0;
			ballYdir=0;
			g.setColor(Color.black);
			g.setFont(new Font("Chalkduster",Font.BOLD,40));//Font style
			g.drawString("Congratulations! :) ",200,250);	
			g.setFont(new Font("Chalkduster",Font.BOLD,40));
			g.drawString("RUNS:"+ score,200,300);
			g.setFont(new Font("Chalkduster",Font.BOLD,30));
			g.drawString("You Scored Half Century",200,350);
			g.setFont(new Font("Chalkduster",Font.BOLD,30));
			g.drawString("Press Enter To Score Again",200,400);
		}
	}
	private void moveLeft() {
		play=true;
		playerX-=30;
	}
	private void moveRight() {
		play=true;
		playerX+=30;
	}
	@Override
	public void keyPressed(java.awt.event.KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_A && playerX > 5) {
			if(playerX<=5)
				playerX=5;
				else
					moveLeft();
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_D && playerX < 540) {
			if(playerX>=540)
			playerX=540;
			else
				moveRight();
		}
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(!play)
			{
				score=0;
				totalBrick=15;
				ballposX=122;
				ballposY=230;
				ballXdir=3;
				ballYdir=4;				playerX=320;
				map=new MapGenerator(3,5);
			}
		}
		repaint();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(play) {
			if(ballposX<=0)			//for rebound from the left wall.
			{
				ballXdir=-ballXdir;//Rebounds in opposite Direction.
			}
			if(ballposX>=670)		//for rebound from the right wall 
			{
				ballXdir=-ballXdir;
			}
			if(ballposY<=0)			//for rebound from the top. 
			{
				ballYdir=-ballYdir;
			}
			Rectangle ballRect =new Rectangle(ballposX,ballposY,20,20);
			Rectangle paddleRect=new Rectangle(playerX,550,150,14);
			if(ballRect.intersects(paddleRect))// rebound from panel
			{
				ballYdir=-ballYdir;
			}
			A:for(int i=0;i<map.map.length;i++)
			{
				for(int j=0;j<map.map[0].length;j++)
				{
					if(map.map[i][j]>0) {
						int width=map.brickWidth;
						int height=map.brickHeight;
						int brickXpos=80+j*width;
						int brickYpos=50+i*height;
						Rectangle brickRect=new Rectangle(brickXpos,brickYpos,width,height);
						if(ballRect.intersects(brickRect)) {			//when ball intersect brick ,brick will break.
							map.setBrick(0,i,j);
							totalBrick--;  //Bricks are destroyed
							if(i == 0)			//In the First Row
							{
								score += 6;		//Sixer is alloted to your score.
							}
							else if(i == 1)		//In The Second Row
							{
								if(j == 2)      //if at the Third Coulmn
								{	
									score+=0;   //Deadball
								}
								else			
									score +=4;	//Else its a Boundary
							}
							else
							{
								if(j == 2)
								{	
									score += 0;
								}
								else
									score+=1;
							}
							if(ballposX+19<=brickXpos || ballposX+1>=brickXpos+width) {//Change of Direction when the ball intersects with brick.
								ballXdir=-ballXdir;
							}
							else {
								ballYdir=-ballYdir;
							}
							break A;
						}
					}
				}
			}			
			ballposX+=ballXdir;//Change of position of ball
			ballposY+=ballYdir;
		}
		repaint();//repaint() method is invoked to refresh the viewing area i.e. you call it when you have new things to display.
	}
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
}
