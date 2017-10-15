import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class game extends JFrame {

	private JPanel contentPane;
	JButton[][] buttons=new JButton[3][3];
	boolean bool=true;
	int x=0;
	JButton b1 = new JButton("");
	JButton b2 = new JButton("");
	JButton b3 = new JButton("");
	JButton b4 = new JButton("");
	JButton b5 = new JButton("");
	JButton b6 = new JButton("");
	JButton b7 = new JButton("");
	JButton b8 = new JButton("");
	JButton b9 = new JButton("");
	JButton reset = new JButton("RESET");
	int GameGameArr[][]=new int[3][3];
	int Marker;
	JLabel label = new JLabel("");
	int choice;
	private final JLabel lb = new JLabel("WELCOME TO TIC TOE GAME");
	Timer timer;
	int t=10;
	int z;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					game frame = new game();
					frame.setVisible(true);
					frame.change();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public void logic()
	{
		/*if((b1.getText()==b2.getText()==b3.getText())||(b1.getText()==b5.getText()==b9.getText())||(b1.getText()==b4.getText()==b7.getText())||(b4.getText()==b5.getText()==b6.getText()))
		{
			
		}*/
		if(((b1.getText()=="X")&&(b2.getText()=="X")&&(b3.getText()=="X"))||((b4.getText()=="X")&&(b5.getText()=="X")&&(b6.getText()=="X"))||((b7.getText()=="X")&&(b8.getText()=="X")&&(b9.getText()=="X"))||((b1.getText()=="X")&&(b4.getText()=="X")&&(b7.getText()=="X"))||((b1.getText()=="X")&&(b5.getText()=="X")&&(b9.getText()=="X"))||((b2.getText()=="X")&&(b5.getText()=="X")&&(b8.getText()=="X"))||((b3.getText()=="X")&&(b6.getText()=="X")&&(b9.getText()=="X"))||((b3.getText()=="X")&&(b5.getText()=="X")&&(b7.getText()=="X")))
		{
		label.setText(" Player 1 win");	
		JOptionPane.showMessageDialog(null, "player 1 wins");
		int m=JOptionPane.showConfirmDialog(null, "Do u want to continue");
		if(m==JOptionPane.NO_OPTION)
		{
			this.setVisible(false);
			this.dispose();
		}
		else
			if(m==JOptionPane.YES_OPTION)
			{b1.setText("");
			b2.setText("");	b3.setText("");	b4.setText("");	b5.setText("");	b6.setText("");	b7.setText("");	b8.setText("");	b9.setText("");
				label.setText("");
				bool=true;
			}
		}
		else 
			if(((b1.getText()=="O")&&(b2.getText()=="O")&&(b3.getText()=="O"))||((b4.getText()=="O")&&(b5.getText()=="O")&&(b6.getText()=="O"))||((b7.getText()=="O")&&(b8.getText()=="O")&&(b9.getText()=="O"))||((b1.getText()=="O")&&(b4.getText()=="O")&&(b7.getText()=="O"))||((b1.getText()=="O")&&(b5.getText()=="O")&&(b9.getText()=="O"))||((b2.getText()=="O")&&(b5.getText()=="O")&&(b8.getText()=="O"))||((b3.getText()=="O")&&(b6.getText()=="O")&&(b9.getText()=="O"))||((b3.getText()=="O")&&(b5.getText()=="O")&&(b7.getText()=="O")))
			{
				label.setText(" Player 2 win");	
				JOptionPane.showMessageDialog(null, "player 2 wins");
				int m=JOptionPane.showConfirmDialog(null, "Do u want to continue");
				if(m==JOptionPane.NO_OPTION)
				{
					this.setVisible(false);
					this.dispose();
				}
				else
					if(m==JOptionPane.YES_OPTION)
					{b1.setText("");
					b2.setText("");	b3.setText("");	b4.setText("");	b5.setText("");	b6.setText("");	b7.setText("");	b8.setText("");	b9.setText("");
						label.setText("");
						bool=true;
					}
			}
	
	}
	public void change()
	{
		timer=new Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				z=z+t;
				lb.setBounds(z, 28, 359, 33);
				if(z<0||z>(game.this.getWidth()-200))
				{
				t*=-1;
					
				}
		
					
				
				}}
				
			
		);
		timer.start();
	}
	public game() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		bool=true;
		
		b1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(bool)
				{Marker=1;
					b1.setText("X");
					GameGameArr[0][0]=Marker;
					
				}
				else
					{b1.setText("O");
					Marker=0;
					GameGameArr[0][0]=Marker;
					}
			bool=!bool;
			logic();
			}
		});
		b1.setBounds(11, 173, 171, 41);
		contentPane.add(b1);
		
		
		b2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(bool)
				{Marker=1;
					b2.setText("X");
					GameGameArr[0][1]=Marker;
				}
				else
					{b2.setText("O");
					Marker=0;
				GameGameArr[0][1]=Marker;}
				bool=!bool;
				logic();
			}
				
		});
		b2.setBounds(228, 173, 171, 41);
		contentPane.add(b2);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		b3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(bool)
				{Marker=1;
					b3.setText("X");
					GameGameArr[0][2]=Marker;
				}
				else
					{b3.setText("O");
					Marker=0;GameGameArr[0][2]=Marker;}
				bool=!bool;logic();
			}
		});
		b3.setBounds(425, 173, 171, 41);
		contentPane.add(b3);
		
	
		b4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(bool)
				{
					Marker=1;b4.setText("X");
					GameGameArr[1][0]=Marker;}
				else
					{b4.setText("O");
					Marker=0;GameGameArr[1][0]=Marker;}
				bool=!bool;logic();
			}
		});
		b4.setBounds(11, 242, 171, 41);
		contentPane.add(b4);
		
		
		b5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(bool)
				{Marker=1;
					b5.setText("X");
					GameGameArr[1][1]=Marker;}
				else
					{b5.setText("O");
					Marker=0;GameGameArr[1][1]=Marker;}
				bool=!bool;logic();
			}
		});
		b5.setBounds(228, 242, 171, 41);
		contentPane.add(b5);
		
		
		b6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(bool)
				{Marker=1;
					GameGameArr[1][2]=Marker;
					b6.setText("X");
				}
				else
					{b6.setText("O");
					Marker=0;GameGameArr[1][2]=Marker;}
				bool=!bool;logic();
			}
			
		});
		b6.setBounds(425, 242, 171, 41);
		contentPane.add(b6);
		
		JButton b7 = new JButton("");
		b7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(bool)
				{Marker=1;
					GameGameArr[2][0]=Marker;
					b7.setText("X");
				}
				else
					{b7.setText("O");
					Marker=0;GameGameArr[2][0]=Marker;}
				bool=!bool;logic();
			}
		});
		b7.setBounds(11, 311, 171, 41);
		contentPane.add(b7);
		
		
		b8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(bool)
				{
					Marker=1;GameGameArr[2][1]=Marker;
					b8.setText("X");
				}
				else
					{b8.setText("O");
					Marker=0;GameGameArr[2][1]=Marker;}
				bool=!bool;
				logic();
			}
		});
		b8.setBounds(228, 311, 171, 41);
		contentPane.add(b8);
		
		
		b9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(bool)
				{
					Marker=1;GameGameArr[2][2]=Marker;
					b9.setText("X");
				}
				else
					{b9.setText("O");Marker=0;GameGameArr[2][2]=Marker;}
				bool=!bool;
				logic();
			}
		});
		b9.setBounds(425, 311, 171, 41);
		contentPane.add(b9);
		
		
		reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				b1.setText("");
				b2.setText("");	b3.setText("");	b4.setText("");	b5.setText("");	b6.setText("");	b7.setText("");	b8.setText("");	b9.setText("");
			}
		});
		reset.setBounds(228, 405, 171, 41);
		contentPane.add(reset);
		
		
		label.setBounds(71, 405, 115, 33);
		contentPane.add(label);
		lb.setBounds(11, 28, 377, 56);
	
		
		contentPane.add(lb);
		
	}
}
