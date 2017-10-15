import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel{

	private Timer timer;
	Ship ship=new Ship();
	Enemy enemy;
	int DELAY=2;
	
	public ArrayList<Enemy> enemylist=new ArrayList<>();
	public ArrayList<EnemyMissile> enemymissilelist=new  ArrayList<>();
	public void enemyPositions()
	{
		
		int arr[]={0,250,500,900,1200};
		for(int i=0;i<arr.length;i++)
		{
			//this.laserlist.add(e)
		this.enemylist.add(new Enemy(arr[i]));
		this.enemymissilelist.add(new EnemyMissile(arr[i]));
	}}
	public Board()
	{
		
		this.enemyPositions();
		
		
		
		
		
		ship=new Ship();
		this.setFocusable(true);
		
		this.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e)
			{
				ship.moveShip(e);
				
			}
			public void keyReleased(KeyEvent e)
			{
				ship.donotmove();
			}
			
			
		});
		timer=new Timer(DELAY, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ship.move();
				repaint();
				
			}
		});
		timer.start();
	/*	
		Timer time=new Timer(500,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Missile missile=new Missile();
			    missile.movemissile();
			    repaint();
				
			}
		});
		*/
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D twod= (Graphics2D) g;
	//	twod.drawImage(new ImageIcon(Board.class.getResource("sky3.gif")).getImage(), 0, 0, this);
		twod.setFont(new Font("Arial",Font.BOLD,40));
		twod.setColor(Color.WHITE);
		twod.drawString("Enemy left "+this.enemylist.size(),700, 1500);
		//twod.drawImage(new ImageIcon(boom.class.getResource("boom.gif")).getImage(),500, 500, this);
		if(this.enemylist.size()==0  &&ship.isVisible)
		{twod.setFont(new Font("Arial",Font.BOLD,100));
			twod.setColor(Color.WHITE);
			twod.drawString("WIN", 400, 400);
			timer.stop();
			
		}
		if(ship.isVisible)
		{
		twod.drawImage(ship.getImage(), ship.getX(), ship.getY(), this);
		}
		for(int i=0;i<ship.getMissilelist().size();i++)
		{
			Missile missile= ship.missilelist.get(i);
			
			if(missile.isVisible)
			{
				
			
			missile.movemissile();
			twod.drawImage(missile.getImage(), missile.getX(), missile.getY(),this);
			}
		}
		//Print enemy
		
		for(int i=0;i<this.enemylist.size();i++)
		{
			Enemy enemy= this.enemylist.get(i);
			if(enemy.isVisible)
			{
				twod.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), this);
			}
		}
		
		//Print laser
		//timer=new Timer(500, new ActionListener() {
			

				
		
		
		
	//	}});
		
	
		
		
		
		
		//Collisions
		//1.missile with enemy
		for(int i=0;i<ship.getMissilelist().size();i++)
		{
			for(int j=0;j<this.enemylist.size();j++)
			{
				Missile missile=ship.getMissilelist().get(i);
				Enemy enemy=this.enemylist.get(j);
				if(missile.getrectangle().intersects(enemy.getrectangle()))
				{   boom boom1=new boom();
				int x=enemy.getX();
				int y=enemy.getY();
				boom1.setIsVisible(true);
				enemy.setIsVisible(false);
				missile.setIsVisible(false);
	
				
				if(boom1.getIsVisible())
{
					
	//twod.drawImage(boom1.getImage(), enemy.getX()+500, enemy.getY()+500, this);
	twod.drawImage(new ImageIcon(boom.class.getResource("boom1.gif")).getImage(), x, y,this);
	Toolkit.getDefaultToolkit().beep();
}
				/*	twod.drawImage( new ImageIcon(Enemy.class.getResource("boom.gif")).getImage()
							, enemy.getX(), enemy.getY(), this);*/
					
					//ship.missilelist.remove(i);
					this.enemylist.remove(j);
					
					
				}
			}
		}
		//Collision of enemy missile with ship
		for(int i=0;i<enemymissilelist.size();i++)
		{ 
			EnemyMissile enemymissile=this.enemymissilelist.get(i);
			if(ship.getRectangle().intersects(enemymissile.getlaserrectangle()) && enemymissile.isVisible)
			{
				ship.setIsVisible(false);
				enemymissile.setIsVisible(false);
				
			}
		}
		//Prints laser enemy
		for(int i=0;i<this.enemylist.size();i++)
		//{
		//	for(int j=0;j<this.enemymissilelist.size();j++)
			{
				
			Enemy enemy=this.enemylist.get(i);
			EnemyMissile missile= this.enemymissilelist.get(i);
			if(enemy.getIsVisible()&&missile.getIsVisible())
			{
				missile.move();
				twod.drawImage(missile.getImage(), missile.getX(), missile.getY(), this);
				
				
			
			}
			else
			{
		//this.enemymissilelist.remove(i);
			}
		}
		}
	//}
}
