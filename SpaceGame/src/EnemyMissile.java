import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class EnemyMissile {

	int x;
	int y;
	public Image image;
	public Boolean isVisible;
	int height;
	int width;
	
	public EnemyMissile(int x)
	{
		this.x=x;
		y=0;
		isVisible=true;
		image=new ImageIcon(EnemyMissile.class.getResource("laser.gif")).getImage();
		height=image.getHeight(null);
		width=image.getWidth(null);
		
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

	public Rectangle getlaserrectangle()
	{
		Rectangle laserrect=new Rectangle(x, y, this.getWidth(), this.getHeight());
		return laserrect;
	}
	
	public void move()
	{
		if(y<GameLauncher.BOARD_HEIGHT)
		{
			y++;
		}
		else if(y==GameLauncher.BOARD_HEIGHT)
		{
			y=0;
		}
	}
}
