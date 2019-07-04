package net.potatoing.brainfuckTheGame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

public class Level4 extends JFrame {

	int step = 0;
	String codeStep = "";
	int currentCellStep;
	int[] cellsStep;
	Stack<Integer> loopsStep;
	String outputStep;
	boolean setCell = true;
	int rnd1Step;
	int rnd2Step;
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level4 frame = new Level4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void initStep() {
		currentCellStep = 0;
		cellsStep = new int[15];
		loopsStep = new Stack<Integer>();
		outputStep = "Output: ";
		setCell = true;
		
		for(int i = 0; i < cellsStep.length; i++)
			cellsStep[i] = 0;
		System.out.println(cellsStep[currentCellStep]);
	}
	
	/**
	 * Create the frame.
	 */
	public Level4() {
		initStep();
		
		setTitle("Brainfuck: The Game | Level 4");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 435, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblWork = new JLabel("Set value of Cell 2 to be the sum of cells 0 and 1. Click here for hint.");
		lblWork.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(lblWork.getText().equals("Set value of Cell 2 to be the sum of cells 0 and 1. Click here for hint."))
					lblWork.setText("Hint: Copy cells 1 and 2 into Cell 3.");
				else
					lblWork.setText("Set value of Cell 2 to be the sum of cells 0 and 1. Click here for hint.");
			}
		});
		lblWork.setBounds(10, 11, 410, 14);
		contentPane.add(lblWork);
		
		JLabel lblCell0 = new JLabel("0");
		lblCell0.setHorizontalAlignment(SwingConstants.CENTER);
		lblCell0.setBounds(10, 36, 23, 14);
		contentPane.add(lblCell0);
		Random rn = new Random(); //set random value to cell 0
		int i = rn.nextInt(127 - 1 + 1) + 1;
		lblCell0.setText(Integer.toString(i));
		
		JLabel lblCell1 = new JLabel("0");
		lblCell1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCell1.setBounds(38, 36, 23, 14);
		contentPane.add(lblCell1);
		int i2 = rn.nextInt(127 - 1 + 1) + 1;
		lblCell1.setText(Integer.toString(i2));
		
		JLabel lblCell2 = new JLabel("0");
		lblCell2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCell2.setBounds(66, 36, 23, 14);
		contentPane.add(lblCell2);
		
		JLabel lblCell3 = new JLabel("0");
		lblCell3.setHorizontalAlignment(SwingConstants.CENTER);
		lblCell3.setBounds(94, 36, 23, 14);
		contentPane.add(lblCell3);
		
		JLabel lblCell4 = new JLabel("0");
		lblCell4.setHorizontalAlignment(SwingConstants.CENTER);
		lblCell4.setBounds(122, 36, 23, 14);
		contentPane.add(lblCell4);
		
		JLabel lblCell5 = new JLabel("0");
		lblCell5.setHorizontalAlignment(SwingConstants.CENTER);
		lblCell5.setBounds(150, 36, 23, 14);
		contentPane.add(lblCell5);
		
		JLabel lblCell6 = new JLabel("0");
		lblCell6.setHorizontalAlignment(SwingConstants.CENTER);
		lblCell6.setBounds(178, 36, 23, 14);
		contentPane.add(lblCell6);
		
		JLabel lblCell7 = new JLabel("0");
		lblCell7.setHorizontalAlignment(SwingConstants.CENTER);
		lblCell7.setBounds(206, 36, 23, 14);
		contentPane.add(lblCell7);
		
		JLabel lblCell8 = new JLabel("0");
		lblCell8.setHorizontalAlignment(SwingConstants.CENTER);
		lblCell8.setBounds(234, 36, 23, 14);
		contentPane.add(lblCell8);
		
		JLabel lblCell9 = new JLabel("0");
		lblCell9.setHorizontalAlignment(SwingConstants.CENTER);
		lblCell9.setBounds(262, 36, 23, 14);
		contentPane.add(lblCell9);
		
		JLabel lblCell10 = new JLabel("0");
		lblCell10.setHorizontalAlignment(SwingConstants.CENTER);
		lblCell10.setBounds(290, 36, 23, 14);
		contentPane.add(lblCell10);
		
		JLabel lblCell11 = new JLabel("0");
		lblCell11.setHorizontalAlignment(SwingConstants.CENTER);
		lblCell11.setBounds(323, 36, 23, 14);
		contentPane.add(lblCell11);
		
		JLabel lblCell12 = new JLabel("0");
		lblCell12.setHorizontalAlignment(SwingConstants.CENTER);
		lblCell12.setBounds(346, 36, 23, 14);
		contentPane.add(lblCell12);
		
		JLabel lblCell13 = new JLabel("0");
		lblCell13.setHorizontalAlignment(SwingConstants.CENTER);
		lblCell13.setBounds(374, 36, 23, 14);
		contentPane.add(lblCell13);
		
		JLabel lblCell14 = new JLabel("0");
		lblCell14.setHorizontalAlignment(SwingConstants.CENTER);
		lblCell14.setBounds(402, 36, 23, 14);
		contentPane.add(lblCell14);
		
		JLabel lblOutput = new JLabel("Output: ");
		lblOutput.setBounds(10, 61, 410, 14);
		contentPane.add(lblOutput);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 120, 409, 140);
		contentPane.add(scrollPane);
		
		JTextArea txtrCode = new JTextArea();
		txtrCode.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		//try to load level, if save file exists
		if(new File("BrainfuckTheGame/BrainfuckTheGameLevel4.potato").isFile()) { 
		    txtrCode.setText("");
		    try {
				Scanner in = new Scanner(new FileReader("BrainfuckTheGame/BrainfuckTheGameLevel4.potato"));
				while (in.hasNext()) {
					txtrCode.append(in.next());
					txtrCode.append("\n");
				}
				in.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "ERROR: Failed to load save data!");
			}
		} else
			txtrCode.setText("Code:");
		scrollPane.setViewportView(txtrCode);
		
		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//set thingis //init
				step = 0;
				//reset shit, yo
				codeStep = "";
				currentCellStep = 0;
				cellsStep = new int[15];
				loopsStep = new Stack<Integer>();
				outputStep = "Output: ";
				setCell = true;
				
				for(int i = 0; i < cellsStep.length; i++)
					cellsStep[i] = 0;
				
				lblCell0.setText(Integer.toString(cellsStep[0]));
				lblCell1.setText(Integer.toString(cellsStep[1]));
				lblCell2.setText(Integer.toString(cellsStep[2]));
				lblCell3.setText(Integer.toString(cellsStep[3]));
				lblCell4.setText(Integer.toString(cellsStep[4]));
				lblCell5.setText(Integer.toString(cellsStep[5]));
				lblCell6.setText(Integer.toString(cellsStep[6]));
				lblCell7.setText(Integer.toString(cellsStep[7]));
				lblCell8.setText(Integer.toString(cellsStep[8]));
				lblCell9.setText(Integer.toString(cellsStep[9]));
				lblCell10.setText(Integer.toString(cellsStep[10]));
				lblCell11.setText(Integer.toString(cellsStep[11]));
				lblCell12.setText(Integer.toString(cellsStep[12]));
				lblCell13.setText(Integer.toString(cellsStep[13]));
				lblCell14.setText(Integer.toString(cellsStep[14]));
				
				lblCell0.setEnabled(true);
				lblCell1.setEnabled(true);
				lblCell2.setEnabled(true);
				lblCell3.setEnabled(true);
				lblCell4.setEnabled(true);
				lblCell5.setEnabled(true);
				lblCell6.setEnabled(true);
				lblCell7.setEnabled(true);
				lblCell8.setEnabled(true);
				lblCell9.setEnabled(true);
				lblCell10.setEnabled(true);
				lblCell11.setEnabled(true);
				lblCell12.setEnabled(true);
				lblCell13.setEnabled(true);
				lblCell14.setEnabled(true);
				
				txtrCode.getHighlighter().removeAllHighlights();
				
				//save
				
				try{
					File file = new File("BrainfuckTheGame/BrainfuckTheGameLevel4.potato");
					file.getParentFile().mkdirs();
					PrintWriter out = new PrintWriter(file);
					//PrintWriter out = new PrintWriter("BrainfuckTheGameLevel4.potato");
					out.print(txtrCode.getText());
					out.close();
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Failed to save/load.");
					System.out.println("ERROR: Failed to save!");
				}
				
				int success = 0;
				for(int k = 0; k < 3; k++) {
					//Run code and test for output
					//setup:
					String code = txtrCode.getText();
					int currentCell = 0;
					int[] cells = new int[15];

					String output = "Output: ";
					Stack<Integer> loops = new Stack<Integer>();
					for(int i = 0; i < cells.length; i++)
						cells[i] = 0;
					
					Random rn = new Random(); //set random value to cell 0
					int rnd1 = rn.nextInt(127 - 1 + 1) + 1;
					int rnd2 = rn.nextInt(127 - 1 + 1) + 1;
					cells[0] = rnd1;
					cells[1] = rnd2;
					System.out.println(cells[0] + "|" + cells[1]);
					
					//interpretor
					for(int i = 0; i < code.length(); i++) {
						switch(code.charAt(i)) {
							case '>':
								currentCell++;
								if(currentCell > 14) {
									JOptionPane.showMessageDialog(null, "ERROR: Trying to access unexisting (>14) cell.\nTerminating program..");
									i = code.length();
								}
								break;
							case '<':
								currentCell--;
								if(currentCell < 0) {
									JOptionPane.showMessageDialog(null, "ERROR: Trying to access unexisting (<0) cell.\nTerminating program..");
									i = code.length();
								}
								break;
							case '+':
								cells[currentCell]++;
								if(cells[currentCell] == 256)
									cells[currentCell] = 0;
								break;
							case '-':
								cells[currentCell]--;
								if(cells[currentCell] == -1)
									cells[currentCell] = 255;
								break;
							case '.':
								output += Character.toString ((char)cells[currentCell]);
								break;
							case ',':
								try {
									cells[currentCell] = (int)(JOptionPane.showInputDialog("Your program asks for a input:").charAt(0));
								} catch(Exception ex) {
									cells[currentCell] = 0;
								}
								break;
							case '[':
								if(cells[currentCell] == 0) {
									//Scan to the next ']'
									int tmp = 0;
									while(tmp != -1) {
										i++;
										if(code.charAt(i) == '[')
											tmp++;
										if(code.charAt(i) == ']')
											tmp--;
									}
									break;
								} else {
									//loopy stuff
									loops.push(i);
								}
								break;
							case ']':
								//loopy stuff
								if(cells[currentCell] == 0)
									loops.pop(); //maybe will have to do i-- here. not really sure :(
								else {
									i = loops.pop();
									i--;
								}
									
								break;
							default:
								break;
						}
					}
					
					lblCell0.setText(Integer.toString(cells[0]));
					lblCell1.setText(Integer.toString(cells[1]));
					lblCell2.setText(Integer.toString(cells[2]));
					lblCell3.setText(Integer.toString(cells[3]));
					lblCell4.setText(Integer.toString(cells[4]));
					lblCell5.setText(Integer.toString(cells[5]));
					lblCell6.setText(Integer.toString(cells[6]));
					lblCell7.setText(Integer.toString(cells[7]));
					lblCell8.setText(Integer.toString(cells[8]));
					lblCell9.setText(Integer.toString(cells[9]));
					lblCell10.setText(Integer.toString(cells[10]));
					lblCell11.setText(Integer.toString(cells[11]));
					lblCell12.setText(Integer.toString(cells[12]));
					lblCell13.setText(Integer.toString(cells[13]));
					lblCell14.setText(Integer.toString(cells[14]));
					
					lblOutput.setText(output);
					
					if(cells[2] == rnd1 + rnd2) {
						success++;
						System.out.println(success);
					} else {
						JOptionPane.showMessageDialog(null, "Your code doesn't work, if Cell 0 is " + rnd1 + " and Cell 1 is " + rnd2 + "!\nTry again.");
						k = 2;
					}
				}
				
				int size = 0;
				for(int i = 0; i < txtrCode.getText().length(); i++)
					if(txtrCode.getText().charAt(i) == '-' | txtrCode.getText().charAt(i) == '+' | txtrCode.getText().charAt(i) == '<' | txtrCode.getText().charAt(i) == '>' | txtrCode.getText().charAt(i) == '[' | txtrCode.getText().charAt(i) == ']' | txtrCode.getText().charAt(i) == ',' | txtrCode.getText().charAt(i) == '.')
						size++;
				
				int memoryCells = 1;
				int cellsUsed = 1;
				for(int i = 0; i < txtrCode.getText().length(); i++) {
					if(txtrCode.getText().charAt(i) == '>')
						memoryCells++;
					if(txtrCode.getText().charAt(i) == '<')
						memoryCells--;
					if(memoryCells > cellsUsed)
						cellsUsed = memoryCells;
				}
				
				if(success == 3) {
					JOptionPane.showMessageDialog(null, "You finished this level. Congratulations!\n\nTarget program size: 15B\nYour program size: " + size + "B" + "\nTarget program used 3 cell(s).\nYour program used " + cellsUsed + " cell(s).");
					MainMenu.levelFinished[4] = true;
					MainMenu.save();
				}
			}
		});
		btnRun.setBounds(10, 86, 205, 23);
		contentPane.add(btnRun);
		
		JButton btnStep = new JButton("Step");
		btnStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//init
				lblCell0.setEnabled(true);
				lblCell1.setEnabled(true);
				lblCell2.setEnabled(true);
				lblCell3.setEnabled(true);
				lblCell4.setEnabled(true);
				lblCell5.setEnabled(true);
				lblCell6.setEnabled(true);
				lblCell7.setEnabled(true);
				lblCell8.setEnabled(true);
				lblCell9.setEnabled(true);
				lblCell10.setEnabled(true);
				lblCell11.setEnabled(true);
				lblCell12.setEnabled(true);
				lblCell13.setEnabled(true);
				lblCell14.setEnabled(true);
				
				if(currentCellStep == 0) {
					lblCell0.setEnabled(false);
				}
				if(currentCellStep == 1) {
					lblCell1.setEnabled(false);
				}
				if(currentCellStep == 2) {
					lblCell2.setEnabled(false);
				}
				if(currentCellStep == 3) {
					lblCell3.setEnabled(false);
				}
				if(currentCellStep == 4) {
					lblCell4.setEnabled(false);
				}
				if(currentCellStep == 5) {
					lblCell5.setEnabled(false);
				}
				if(currentCellStep == 6) {
					lblCell6.setEnabled(false);
				}
				if(currentCellStep == 7) {
					lblCell7.setEnabled(false);
				}
				if(currentCellStep == 8) {
					lblCell8.setEnabled(false);
				}
				if(currentCellStep == 9) {
					lblCell9.setEnabled(false);
				}
				if(currentCellStep == 10) {
					lblCell10.setEnabled(false);
				}
				if(currentCellStep == 11) {
					lblCell11.setEnabled(false);
				}
				if(currentCellStep == 12) {
					lblCell12.setEnabled(false);
				}
				if(currentCellStep == 13) {
					lblCell13.setEnabled(false);
				}
				if(currentCellStep == 14) {
					lblCell14.setEnabled(false);
				}
				
				//btnRun.setEnabled(false);
				Highlighter highlighter = txtrCode.getHighlighter();
				HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
				int p0 = step;
				if(p0 < 0)
					p0 = 0;
				int p1 = p0 + 1;
				try {
					txtrCode.getHighlighter().removeAllHighlights();
					highlighter.addHighlight(p0, p1, painter );
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
				//save
				
				try{
					File file = new File("BrainfuckTheGame/BrainfuckTheGameSandbox.potato");
					file.getParentFile().mkdirs();
					PrintWriter out = new PrintWriter(file);
					//PrintWriter out = new PrintWriter("BrainfuckTheGameSandbox.potato");
					out.print(txtrCode.getText());
					out.close();
					System.out.println("Saved.");
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Failed to save/load.");
					System.out.println("ERROR: Failed to save!");
				}
				
				//Run code and test for output
				//setup:
				if(codeStep == "")
					codeStep = txtrCode.getText();
				
				if(cellsStep[0] == 0 && cellsStep[1] == 0 && setCell == true) {
					Random rn = new Random(); //set random value to cell 0
					rnd1Step = rn.nextInt(127 - 1 + 1) + 1;
					rnd2Step = rn.nextInt(127 - 1 + 1) + 1;
					cellsStep[0] = rnd1Step;
					cellsStep[1] = rnd2Step;
					setCell = false;
				}
				
				//interpretor
				//interpretor
				boolean isNotBrainfuck = true;
				while(isNotBrainfuck) {
					switch(codeStep.charAt(step)) {
					case '>':
						currentCellStep++;
						if(currentCellStep > 14) {
							JOptionPane.showMessageDialog(null, "ERROR: Trying to access unexisting (>14) cell.\nTerminating program..");
							step = codeStep.length();
						} else {
							lblCell0.setEnabled(true);
							lblCell1.setEnabled(true);
							lblCell2.setEnabled(true);
							lblCell3.setEnabled(true);
							lblCell4.setEnabled(true);
							lblCell5.setEnabled(true);
							lblCell6.setEnabled(true);
							lblCell7.setEnabled(true);
							lblCell8.setEnabled(true);
							lblCell9.setEnabled(true);
							lblCell10.setEnabled(true);
							lblCell11.setEnabled(true);
							lblCell12.setEnabled(true);
							lblCell13.setEnabled(true);
							lblCell14.setEnabled(true);
							
							if(currentCellStep == 0) {
								lblCell0.setEnabled(false);
							}
							if(currentCellStep == 1) {
								lblCell1.setEnabled(false);
							}
							if(currentCellStep == 2) {
								lblCell2.setEnabled(false);
							}
							if(currentCellStep == 3) {
								lblCell3.setEnabled(false);
							}
							if(currentCellStep == 4) {
								lblCell4.setEnabled(false);
							}
							if(currentCellStep == 5) {
								lblCell5.setEnabled(false);
							}
							if(currentCellStep == 6) {
								lblCell6.setEnabled(false);
							}
							if(currentCellStep == 7) {
								lblCell7.setEnabled(false);
							}
							if(currentCellStep == 8) {
								lblCell8.setEnabled(false);
							}
							if(currentCellStep == 9) {
								lblCell9.setEnabled(false);
							}
							if(currentCellStep == 10) {
								lblCell10.setEnabled(false);
							}
							if(currentCellStep == 11) {
								lblCell11.setEnabled(false);
							}
							if(currentCellStep == 12) {
								lblCell12.setEnabled(false);
							}
							if(currentCellStep == 13) {
								lblCell13.setEnabled(false);
							}
							if(currentCellStep == 14) {
								lblCell14.setEnabled(false);
							}
						}
						isNotBrainfuck = false;
						break;
					case '<':
						currentCellStep--;
						if(currentCellStep < 0) {
							JOptionPane.showMessageDialog(null, "ERROR: Trying to access unexisting (<0) cell.\nTerminating program..");
							step = codeStep.length();
						}
						isNotBrainfuck = false;
						break;
					case '+':
						System.out.println(cellsStep[0]);
						cellsStep[currentCellStep]++;
						if(cellsStep[currentCellStep] == 256)
							cellsStep[currentCellStep] = 0;
						isNotBrainfuck = false;
						break;
					case '-':
						cellsStep[currentCellStep]--;
						if(cellsStep[currentCellStep] == -1)
							cellsStep[currentCellStep] = 255;
						isNotBrainfuck = false;
						break;
					case '.':
						outputStep += Character.toString ((char)cellsStep[currentCellStep]);
						isNotBrainfuck = false;
						break;
					case ',':
						try {
							cellsStep[currentCellStep] = (int)(JOptionPane.showInputDialog("Your program asks for a input:").charAt(0));
						} catch(Exception ex) {
							cellsStep[currentCellStep] = 0;
						}
						isNotBrainfuck = false;
						break;
					case '[':
						if(cellsStep[currentCellStep] == 0) {
							//Scan to the next ']'
							int tmp = 0;
							while(tmp != -1) {
								step++;
								if(codeStep.charAt(step) == '[')
									tmp++;
								if(codeStep.charAt(step) == ']')
									tmp--;
							}
							isNotBrainfuck = false;
							break;
						} else {
							//loopy stuff
							loopsStep.push(step);
						}
						isNotBrainfuck = false;
						break;
					case ']':
						//loopy stuff
						if(cellsStep[currentCellStep] == 0)
							loopsStep.pop(); //maybe will have to do i-- here. not really sure :(
						else {
							step = loopsStep.pop();
							step--;
						}
						isNotBrainfuck = false;
						break;
					default:
						step++;
						//isNotBrainfuck = true;
						break;
					}
				}
				
				//highlighter = txtrCode.getHighlighter();
				//painter = new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
				p0 = step;
				if(p0 < 0)
					p0 = 0;
				p1 = p0 + 1;
				try {
					txtrCode.getHighlighter().removeAllHighlights();
					highlighter.addHighlight(p0, p1, painter );
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
				
				lblCell0.setText(Integer.toString(cellsStep[0]));
				lblCell1.setText(Integer.toString(cellsStep[1]));
				lblCell2.setText(Integer.toString(cellsStep[2]));
				lblCell3.setText(Integer.toString(cellsStep[3]));
				lblCell4.setText(Integer.toString(cellsStep[4]));
				lblCell5.setText(Integer.toString(cellsStep[5]));
				lblCell6.setText(Integer.toString(cellsStep[6]));
				lblCell7.setText(Integer.toString(cellsStep[7]));
				lblCell8.setText(Integer.toString(cellsStep[8]));
				lblCell9.setText(Integer.toString(cellsStep[9]));
				lblCell10.setText(Integer.toString(cellsStep[10]));
				lblCell11.setText(Integer.toString(cellsStep[11]));
				lblCell12.setText(Integer.toString(cellsStep[12]));
				lblCell13.setText(Integer.toString(cellsStep[13]));
				lblCell14.setText(Integer.toString(cellsStep[14]));
				
				lblOutput.setText(outputStep);
				
				int size = 0;
				for(int i = 0; i < codeStep.length(); i++)
					if(codeStep.charAt(i) == '-' | codeStep.charAt(i) == '+' | codeStep.charAt(i) == '<' | codeStep.charAt(i) == '>' | codeStep.charAt(i) == '[' | codeStep.charAt(i) == ']' | codeStep.charAt(i) == ',' | codeStep.charAt(i) == '.')
						size++;
				if(step == size) {
					btnRun.setEnabled(true);
					step = 0;
					//reset shit, yo
					codeStep = "";
					currentCellStep = 0;
					cellsStep = new int[15];
					loopsStep = new Stack<Integer>();
					outputStep = "Output: ";
					
					for(int i = 0; i < cellsStep.length; i++)
						cellsStep[i] = 0;
					
					lblCell0.setText(Integer.toString(cellsStep[0]));
					lblCell1.setText(Integer.toString(cellsStep[1]));
					lblCell2.setText(Integer.toString(cellsStep[2]));
					lblCell3.setText(Integer.toString(cellsStep[3]));
					lblCell4.setText(Integer.toString(cellsStep[4]));
					lblCell5.setText(Integer.toString(cellsStep[5]));
					lblCell6.setText(Integer.toString(cellsStep[6]));
					lblCell7.setText(Integer.toString(cellsStep[7]));
					lblCell8.setText(Integer.toString(cellsStep[8]));
					lblCell9.setText(Integer.toString(cellsStep[9]));
					lblCell10.setText(Integer.toString(cellsStep[10]));
					lblCell11.setText(Integer.toString(cellsStep[11]));
					lblCell12.setText(Integer.toString(cellsStep[12]));
					lblCell13.setText(Integer.toString(cellsStep[13]));
					lblCell14.setText(Integer.toString(cellsStep[14]));
					
					lblCell0.setEnabled(true);
					lblCell1.setEnabled(true);
					lblCell2.setEnabled(true);
					lblCell3.setEnabled(true);
					lblCell4.setEnabled(true);
					lblCell5.setEnabled(true);
					lblCell6.setEnabled(true);
					lblCell7.setEnabled(true);
					lblCell8.setEnabled(true);
					lblCell9.setEnabled(true);
					lblCell10.setEnabled(true);
					lblCell11.setEnabled(true);
					lblCell12.setEnabled(true);
					lblCell13.setEnabled(true);
					lblCell14.setEnabled(true);
					
					if(cellsStep[2] == rnd1Step + rnd2Step) {
						JOptionPane.showMessageDialog(null, "Your program seems to be working,\nbut in order to finish the level,\nit you need to press the \"Run\" button.");
						setCell = true;
					}
				}
				else
					step++;
			}
		});
		btnStep.setBounds(215, 86, 205, 23);
		contentPane.add(btnStep);
	}
}
