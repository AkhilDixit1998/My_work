import javax.swing.JFrame;

public class GameLauncher extends JFrame {

	public static final int BOARD_WIDTH=2000;
	public static final int BOARD_HEIGHT=2000;
	public GameLauncher()
	{
		Board board = new Board();
		this.add(board);
		this.setVisible(true);
		
		this.setResizable(false);
		this.setSize(BOARD_WIDTH, BOARD_HEIGHT);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
GameLauncher gamelauncher=new GameLauncher();
	}

}
