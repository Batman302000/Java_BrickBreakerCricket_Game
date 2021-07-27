package demogame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class MapLevel2 {
	public int map[][];
	public int brickWidth;
	public int brickHeight;
	public MapLevel2(int row,int col)
	{
		map=new int[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<=i;j++)
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
	
	for(int i=0;i<map.length;i++) {
		for(int j=0;j<map[0].length;j++) {
			if(map[i][j]>0) {
				if(i == 0 || i == 1 || i == 2 || i == 5)
				{
				    g.setColor(Color.blue);
					g.fillRect(j*brickWidth+80,i*brickHeight+50,brickWidth,brickHeight);// to fill the colour of the bricks  //define x and y co-ordinates
					g.setColor(Color.magenta);
					g.setStroke(new BasicStroke(3));// for drawing of the line and width is parameter
					g.drawRect(j*brickWidth+80,i*brickHeight+50,brickWidth,brickHeight);// to draw bounderies of the bricks
					g.setColor(Color.green);
					g.setFont(new Font("serif",Font.BOLD,30));
					g.drawString(" 6 ",j*brickWidth+80+35,i*brickHeight+50+23);
				}
				else if(i==3)
					{
					    g.setColor(Color.orange);
						g.fillRect(j*brickWidth+80,i*brickHeight+50,brickWidth,brickHeight);// to fill the colour of the bricks  //define x and y co-ordinates
						g.setColor(Color.magenta);
						g.setStroke(new BasicStroke(3));// for drawing of the line and width is parameter
						g.drawRect(j*brickWidth+80,i*brickHeight+50,brickWidth,brickHeight);// to draw bounderies of the bricks
						g.setColor(Color.black);
						g.setFont(new Font("serif",Font.BOLD,30));
						g.drawString(" 2 ",j*brickWidth+80+35,i*brickHeight+50+23);
					}
					else
					{
					    g.setColor(Color.cyan);
						g.fillRect(j*brickWidth+80,i*brickHeight+50,brickWidth,brickHeight);// to fill the colour of the bricks  //define x and y co-ordinates
						g.setColor(Color.magenta);
						g.setStroke(new BasicStroke(3));// for drawing of the line and width is parameter
						g.drawRect(j*brickWidth+80,i*brickHeight+50,brickWidth,brickHeight);// to draw bounderies of the bricks
						g.setColor(Color.DARK_GRAY);
						g.setFont(new Font("serif",Font.BOLD,30));
						g.drawString(" 4 ",j*brickWidth+80+35,i*brickHeight+50+23);
					}
				}	
			}
		}
	}
}
