package demogame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class MapGenerator {
	public int map[][];
	public int brickWidth;
	public int brickHeight;
	public MapGenerator(int row,int col)
	{
		map=new int[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++)
			{
				map[i][j]=1;
			}
		}
		brickWidth=540/col;
		brickHeight=150/row;
	}
	public void setBrick(int value,int r,int c)
	{
		map[r][c]=value;
	}
public void draw(Graphics2D g) {
	
	for(int i=0;i<map.length;i++) {           //For Brick Pattern
		for(int j=0;j<map[0].length;j++) {
			if(map[i][j]>0) {
				if(i== 0)//At 1st Row
				{
				    g.setColor(Color.blue);
					g.fillRect(j*brickWidth+80,i*brickHeight+50,brickWidth,brickHeight);// to fill the colour of the bricks  //define x and y co-ordinates
					g.setColor(Color.black);
					g.setStroke(new BasicStroke(3));// for drawing of the line and width is parameter
					g.drawRect(j*brickWidth+80,i*brickHeight+50,brickWidth,brickHeight);// to draw bounderies of the bricks
					g.setColor(Color.green);
					g.setFont(new Font("serif",Font.BOLD,40));
					g.drawString("6 ",j*brickWidth+80+35,i*brickHeight+50+40);//Display 6 on the brick
				}
				else if(i == 1)//At Second row
				{
					if(j == 2)//and 3rd column 
					{
						g.setColor(Color.gray);
						g.fillRect(j*brickWidth+80,i*brickHeight+50,brickWidth,brickHeight);// to fill the colour of the bricks  //define x and y co-ordinates
						g.setColor(Color.black);
						g.setStroke(new BasicStroke(3));// for drawing of the line and width is parameter
						g.drawRect(j*brickWidth+80,i*brickHeight+50,brickWidth,brickHeight);// to draw bounderies of the bricks
						g.setColor(Color.cyan);
						g.setFont(new Font("serif",Font.BOLD,40));
						g.drawString(" D ",j*brickWidth+80+35,i*brickHeight+50+40);//Display D on the brick
					}
					else
					{
					    g.setColor(Color.yellow);
						g.fillRect(j*brickWidth+80,i*brickHeight+50,brickWidth,brickHeight);// to fill the colour of the bricks  //define x and y co-ordinates
						g.setColor(Color.black);
						g.setStroke(new BasicStroke(3));// for drawing of the line and width is parameter
						g.drawRect(j*brickWidth+80,i*brickHeight+50,brickWidth,brickHeight);// to draw bounderies of the bricks
						g.setColor(Color.DARK_GRAY);
						g.setFont(new Font("serif",Font.BOLD,40));
						g.drawString(" 4 ",j*brickWidth+80+35,i*brickHeight+50+40);
					}
				}
				else
				{
					if(j == 2)
					{
						g.setColor(Color.gray);
						g.fillRect(j*brickWidth+80,i*brickHeight+50,brickWidth,brickHeight);// to fill the colour of the bricks  //define x and y co-ordinates
						g.setColor(Color.black);
						g.setStroke(new BasicStroke(3));// for drawing of the line and width is parameter
						g.drawRect(j*brickWidth+80,i*brickHeight+50,brickWidth,brickHeight);// to draw bounderies of the bricks
						g.setColor(Color.cyan);
						g.setFont(new Font("serif",Font.BOLD,40));
						g.drawString(" D ",j*brickWidth+80+35,i*brickHeight+50+40);
					}
					else
					{
					    g.setColor(Color.orange);
						g.fillRect(j*brickWidth+80,i*brickHeight+50,brickWidth,brickHeight);// to fill the colour of the bricks  //define x and y co-ordinates
						g.setColor(Color.black);
						g.setStroke(new BasicStroke(3));// for drawing of the line and width is parameter
						g.drawRect(j*brickWidth+80,i*brickHeight+50,brickWidth,brickHeight);// to draw bounderies of the bricks
						g.setColor(Color.magenta);
						g.setFont(new Font("serif",Font.BOLD,40));
						g.drawString(" 1 ",j*brickWidth+80+35,i*brickHeight+50+40);
					}
				}
			}
		}
	}
}
}
