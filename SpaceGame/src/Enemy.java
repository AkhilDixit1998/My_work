import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Enemy {
int x;
int y;
public static int WIDTH;
public static int HEIGHT;
public Image image;
public Boolean isVisible;



public Rectangle getrectangle()
{
	Rectangle rectangle=new Rectangle(x, y,WIDTH, HEIGHT);
	return rectangle;
}

public Enemy(int x)
{
	this.x=x;
	
	image=new ImageIcon(Enemy.class.getResource("ufo1.gif")).getImage();
	//img=new ImageIcon(Enemy.class.getResource("bull.gif")).getImage();

	WIDTH=image.getWidth(null);
	HEIGHT=image.getHeight(null);
	isVisible=true;
	
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

public static int getWIDTH() {
	return WIDTH;
}

public static void setWIDTH(int wIDTH) {
	WIDTH = wIDTH;
}

public static int getHEIGHT() {
	return HEIGHT;
}

public static void setHEIGHT(int hEIGHT) {
	HEIGHT = hEIGHT;
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
