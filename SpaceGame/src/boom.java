import java.awt.Image;

import javax.swing.ImageIcon;

public class boom {
	int x;
	int y;
	public Boolean isVisible;
	public Image image;
	public boom()
	{
		isVisible=false;
		image=new ImageIcon(boom.class.getResource("boom1.gif")).getImage();
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
	public Boolean getIsVisible() {
		return isVisible;
	}
	public void setIsVisible(Boolean isVisible) {
		this.isVisible = isVisible;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}

}
