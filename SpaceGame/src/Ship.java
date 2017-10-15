import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Ship {

	int height;
	public int width;
	public Image image;
	public String IMAGE_NAME="ship.gif";
	public int x;
	public int y;
	public int MoveX;
	public int MoveY;
	public Boolean isVisible;
	public ArrayList<Missile> missilelist=new ArrayList<>();
	public Missile missile;
	public void launchMissile()
	{
		missile=new Missile();
		missile.setX(this.getX());
		missile.setY(this.getY());
		this.missilelist.add(missile);
		
		Toolkit.getDefaultToolkit().beep();
	}
	public Rectangle getRectangle()
	{
		Rectangle rectangle=new Rectangle(x, y, width, height);
		return rectangle;
	}
	
	
	
	public Ship()
	{
		image=new ImageIcon(Ship.class.getResource("HeroSpaceship.gif")).getImage();
		width=image.getWidth(null);
		height=image.getHeight(null);
		x=400;
		y=400;
		isVisible=true;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public String getIMAGE_NAME() {
		return IMAGE_NAME;
	}
	public void setIMAGE_NAME(String iMAGE_NAME) {
		IMAGE_NAME = iMAGE_NAME;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getMoveX() {
		return MoveX;
	}
	public void setMoveX(int moveX) {
		MoveX = moveX;
	}
	public int getMoveY() {
		return MoveY;
	}
	public void setMoveY(int moveY) {
		MoveY = moveY;
	}
	
	public void setIsVisible(Boolean isVisible) {
		this.isVisible = isVisible;
	}
	public void moveShip(KeyEvent e)
	{
		int keycode=e.getKeyCode();
		if(keycode==KeyEvent.VK_SPACE)
		{
			launchMissile();
		}
		if(keycode==KeyEvent.VK_LEFT)
		{
			MoveX=-1;
		}
		if(keycode==KeyEvent.VK_RIGHT)
		{
			MoveX=1;
		}
		if(keycode==KeyEvent.VK_UP)
		{
			MoveY=-1;
		}
		if(keycode==KeyEvent.VK_DOWN)
		{
			MoveY=1;
		}
	}
	public ArrayList<Missile> getMissilelist() {
		return missilelist;
	}
	public void setMissilelist(ArrayList<Missile> missilelist) {
		this.missilelist = missilelist;
	}
	public Missile getMissile() {
		return missile;
	}
	public void setMissile(Missile missile) {
		this.missile = missile;
	}
	public void move()
	{
		x+=MoveX;
		y+=MoveY;
	}
	public void donotmove()
	{
		MoveX=0;
		MoveY=0;
	}
	
}
