import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Missile {

	
	int x;
	int y;
	public static int height;
	public static int width;
	public Image image;
	public Boolean isVisible;
	public Missile()
	{
		image=new ImageIcon(Missile.class.getResource("mainmissile.gif")).getImage();
		height=image.getHeight(null);
		width=image.getWidth(null);
		isVisible=true;
	}
	public Rectangle getrectangle()
	{
		Rectangle rectangle= new Rectangle(x, y, width, height);
		return rectangle;
	}
	public  void movemissile()
	{
		if(y>0)
		{
			y--;
		}
		if (y==0)
		{
			isVisible=false;
		}
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x+75;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public static int getHeight() {
		return height;
	}
	public static void setHeight(int height) {
		Missile.height = height;
	}
	public static int getWidth() {
		return width;
	}
	public static void setWidth(int width) {
		Missile.width = width;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public Boolean getIsVisible() {
		return isVisible;
	}
	public void setIsVisible(Boolean isVisible) {
		this.isVisible = isVisible;
	}
}
