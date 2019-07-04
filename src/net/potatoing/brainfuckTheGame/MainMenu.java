package net.potatoing.brainfuckTheGame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MainMenu extends JFrame {
	
	public static boolean[] levelFinished = new boolean[8];
	/*static JButton buttons[0];
	static JButton buttons[1];
	static JButton buttons[2];
	static JButton buttons[3];
	static JButton buttons[4];*/
	static JButton[] buttons = new JButton[8];
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JButton btnNext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		boolean showIntro = true;
		if(new File("BrainfuckTheGame/BrainfuckTheGameShowIntro.potato").isFile()) {
		    try {
				Scanner in = new Scanner(new FileReader("BrainfuckTheGame/BrainfuckTheGameShowIntro.potato"));
				while(in.hasNext())
					showIntro = in.nextBoolean();
				in.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
				//JOptionPane.showMessageDialog(null, "ERROR: Failed to load setting data!");
			}
		}
		if(showIntro) {
			JOptionPane.showMessageDialog(null, "☺ <- This is me.");
			JOptionPane.showMessageDialog(null, "And this my job.");
			JOptionPane.showMessageDialog(null, "I'm a programmer.");
			JOptionPane.showMessageDialog(null, "I love proramming,\nbut in this job it's really hard.");
			JOptionPane.showMessageDialog(null, "Perhaps it would be easier,\nif we wouldn't have to use such an\nAicent Technology!");
			JOptionPane.showMessageDialog(null, "TUTORIAL:\nSelect a level and complete set challange using the\nAcient Technology of Brainfuck.\nIf you don't know anything about Brainfuck,\nyou can learn it if you click the \"Help | Credits\" button\nor in under 5 minutes from wikipedia. :)");
			JOptionPane.showMessageDialog(null, "Disclaimer:\nSadly, I ran out of time on this game.\nThat means, that there are some bugs.\nMainly in debug mode and save formatting and Level 1.\nThese are getting fixed in post-compo version.\nYou can follow me on twitter(@PotatoIng_),\nto get notified, when new version comes out:).");
			
			int i = JOptionPane.showConfirmDialog(null, "Show this intro another time?", null, JOptionPane.YES_NO_OPTION);
			if(i != 0) {
				try{
					File file = new File("BrainfuckTheGame/BrainfuckTheGameShowIntro.potato");
					file.getParentFile().mkdirs();
					PrintWriter out = new PrintWriter(file);
					out.println("false");
					out.close();
					System.out.println("Saved.");
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Failed to save/load.");
					System.out.println("ERROR: Failed to save!");
				}
			}
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		
		//load(); //moved to load after buttons are create4d, to avoid null pointer exception.
		
		//open save file and check
		
		setResizable(false);
		setTitle("Brainfuck: The Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		WindowListener exitListener = new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        //Window is closing
		    }
		};
		addWindowListener(exitListener);
		
		JLabel lblBrainfuckTheGame = new JLabel("Level Select:");
		lblBrainfuckTheGame.setHorizontalAlignment(SwingConstants.LEFT);
		lblBrainfuckTheGame.setBounds(115, 11, 152, 15);
		contentPane.add(lblBrainfuckTheGame);
		
		JButton btnLvlSandbox = new JButton("Sandbox");
		btnLvlSandbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Sandbox
				new Sandbox().start();
			}
		});
		btnLvlSandbox.setBounds(50, 289, 200, 25);
		contentPane.add(btnLvlSandbox);
		
		JButton btnLvlHelp = new JButton("Credits | Help");
		btnLvlHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Game made by PotatoIng_ (@PotatoIng_).\nGame was created in 48 hours for LudumDare competition.");
				JOptionPane.showMessageDialog(null, "TUTORIAL:\nSelect a level a complete set challange using the\nAcient Technology of Brainfuck.");
				JOptionPane.showMessageDialog(null, "Any character not \"><+-.,[]\" (excluding quotation marks) is ignored.\n\nBrainfuck is represented by an array with 30,000* cells initialized to zero\nand a data pointer pointing at the current cell.\n\nThere are eight commands:\n+ : Increments the value at the current cell by one.\n- : Decrements the value at the current cell by one.\n> : Moves the data pointer to the next cell (cell on the right).\n< : Moves the data pointer to the previous cell (cell on the left).\n. : Prints the ASCII value at the current cell (i.e. 65 = 'A').\n, : Reads a single input character into the current cell.\n[ : If the value at the current cell is zero, skips to the corresponding ] .\nOtherwise, move to the next instruction.\n] : If the value at the current cell is zero, move to the next instruction.\nOtherwise, move backwards in the instructions to the corresponding [ .\n\n[ and ] form a while loop. Obviously, they must be balanced.\n\n*In this program only 14 cells are present.");
				JOptionPane.showMessageDialog(null, "Let's look at a basic brainfuck program.\n\n++++++ [ > ++++++++++ < - ] > +++++ .\n\nThis program prints out the letter 'A'. First, it increments cell #1 to 6.\nCell #1 will be used for looping. Then, it enters the loop ([) and moves\nto cell #2. It increments cell #2 10 times, moves back to cell #1, and\ndecrements cell #1. This loop happens 6 times (it takes 6 decrements for\ncell #1 to reach 0, at which point it skips to the corresponding ] and\ncontinues on).\n\nAt this point, we're on cell #1, which has a value of 0, while cell #2 has a\nvalue of 60. We move on cell #2, increment 5 times, for a value of 65, and then\nprint cell #2's value. 65 is 'A' in ASCII, so 'A' is printed to the terminal.");
				JOptionPane.showMessageDialog(null, "Protip: Sandbox level has debug mode. Test your programs there:).\n\nThis tutorial was copied (and changed a littlebit) from\nhttps://learnxinyminutes.com/docs/brainfuck/\nOriginally contributed by Prajit Ramachandran.");
			}
		});
		btnLvlHelp.setBounds(50, 325, 200, 25);
		contentPane.add(btnLvlHelp);
		

		buttons[0] = new JButton("Level 0");
		buttons[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Level0().start();
			}
		});
		buttons[0].setBounds(50, 37, 200, 25);
		contentPane.add(buttons[0]);
		
		buttons[1] = new JButton("Level 1");
		buttons[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Level1().start();
			}
		});
		buttons[1].setBounds(50, 73, 200, 25);
		contentPane.add(buttons[1]);
		
		buttons[2] = new JButton("Level 2");
		buttons[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Level2().start();
			}
		});
		buttons[2].setBounds(50, 109, 200, 25);
		contentPane.add(buttons[2]);
		
		buttons[3] = new JButton("Level 3");
		buttons[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Level3().start();
			}
		});
		buttons[3].setBounds(50, 145, 200, 25);
		contentPane.add(buttons[3]);
		
		buttons[4] = new JButton("Level 4");
		buttons[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Level4().start();
			}
		});
		buttons[4].setBounds(50, 181, 200, 25);
		contentPane.add(buttons[4]);
		
		buttons[5] = new JButton("Level 5");
		buttons[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Level5().start();
			}
		});
		buttons[5].setBounds(50, 217, 200, 25);
		contentPane.add(buttons[5]);
		
		JButton btnPrevious = new JButton("<-- Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < buttons.length; i++)
					buttons[i].setBounds(buttons[i].getX() + 300, buttons[i].getY(), buttons[i].getWidth(), buttons[i].getHeight());
				btnNext.setEnabled(true);
				btnPrevious.setEnabled(false);
			}
		});
		btnPrevious.setEnabled(false);
		btnPrevious.setBounds(50, 253, 100, 25);
		contentPane.add(btnPrevious);
		
		btnNext = new JButton("Next -->");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < buttons.length; i++)
					buttons[i].setBounds(buttons[i].getX() - 300, buttons[i].getY(), buttons[i].getWidth(), buttons[i].getHeight());
				btnNext.setEnabled(false);
				btnPrevious.setEnabled(true);
			}
		});
		btnNext.setBounds(150, 253, 100, 25);
		contentPane.add(btnNext);
		
		buttons[6] = new JButton("Level 6");
		buttons[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Level6().start();
			}
		});
		buttons[6].setBounds(350, 37, 200, 25);
		contentPane.add(buttons[6]);
		
		buttons[7] = new JButton("Level 7");
		buttons[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Level7().start();
			}
		});
		buttons[7].setBounds(350, 73, 200, 25);
		contentPane.add(buttons[7]);
		setLocationRelativeTo(null);
		
		/*buttons[7] = new JButton("Level 7");
		buttons[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "For this level:\nTell me how did you enjoy this little game in the ludumdare comments!:)");
				JOptionPane.showMessageDialog(null, "Just kidding, that is not the level.\nI ran out of time:(\nIf you tweet me (@PotatoIng_) that you enjoyed this game,\nI'll be sure to let you know, when it's done!:)");
				levelFinished[7] = true;
				save();
			}
		});
		buttons[7].setBounds(350, 73, 200, 25);
		contentPane.add(buttons[7]);
		setLocationRelativeTo(null);*/
		
		load(); //this code is just spaghetti
	}
	
	public static void save() {
		System.out.println("Saving..");
		
		try{
			File file = new File("BrainfuckTheGame/BrainfuckTheGameSaveFile.potato");
			file.getParentFile().mkdirs();
			PrintWriter out = new PrintWriter(file);
			//PrintWriter out = new PrintWriter("BrainfuckTheGameSaveFile.potato");
			for(int i = 0; i < levelFinished.length; i++) {
				out.println(Boolean.toString(levelFinished[i]));
			}
			out.close();
			System.out.println("Saved.");
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Failed to save/load.");
			System.out.println("ERROR: Failed to save!");
		}
		
		load();
	}
	
	public static void load() {
		if(new File("BrainfuckTheGame/BrainfuckTheGameSaveFile.potato").isFile()) {
		    try {
				Scanner in = new Scanner(new FileReader("BrainfuckTheGame/BrainfuckTheGameSaveFile.potato"));
				int i = 0;
				while (in.hasNext()) {
					//level loaded
					levelFinished[i] = in.nextBoolean();
					i++;
				}
				in.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "ERROR: Failed to load save data!");
			}
		} else {
			for(int i = 0; i < levelFinished.length; i++) {
				levelFinished[i] = false;
			}
		}
		
		//loaded now set the text
		/*if(levelFinished[0] && !buttons[0].getText().endsWith(" - Finished"))
			buttons[0].setText(buttons[0].getText() + " - Finished");
		if(levelFinished[1] && !buttons[1].getText().endsWith(" - Finished"))
			buttons[1].setText(buttons[1].getText() + " - Finished");
		if(levelFinished[2] && !buttons[2].getText().endsWith(" - Finished"))
			buttons[2].setText(buttons[2].getText() + " - Finished");
		if(levelFinished[3] && !buttons[3].getText().endsWith(" - Finished"))
			buttons[3].setText(buttons[3].getText() + " - Finished");
		if(levelFinished[4] && !buttons[4].getText().endsWith(" - Finished"))
			buttons[4].setText(buttons[4].getText() + " - Finished");*/
		for(int i = 0; i < levelFinished.length; i++) {
			if(levelFinished[i] && !buttons[i].getText().endsWith(" - Finished"))
				buttons[i].setText(buttons[i].getText() + " - Finished");
		}
		boolean isFinished = true;
		for(int i = 0; i < levelFinished.length; i++)
			if(!levelFinished[i])
				isFinished = false;
		if(isFinished)
			JOptionPane.showMessageDialog(null, "You finished the game, congratulations! x3\nTweet me (@PotatoIng_) your review of the game!:)");
	}
}
