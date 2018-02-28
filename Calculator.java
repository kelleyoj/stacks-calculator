import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class Calculator extends JFrame {

	//fields for the class
	private JPanel contentPane;
	private JTextField display;
	private JTextPane sideDisplay = new JTextPane();
	private int operation;
	private double answer;

	//used to set answer from arithmetic operations
	private void setAnswer(double answer) {
		this.answer = answer;
	}

	//used to set answer from arithmetic operations
	private double getAnswer() {
		return this.answer;
	}
	
	//reset what's displayed on the calculator
	private void reset() {
		display.setText("");
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator(stack);
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
	public Calculator(Stack stack) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * Customizing the JTextField
		 */
		
		display = new JTextField();
		display.setBackground(Color.WHITE);
		display.setEditable(false);
		display.setBounds(24, 6, 504, 48);
		contentPane.add(display);
		display.setColumns(10);

		sideDisplay.setEditable(false);
		sideDisplay.setBounds(6, 52, 110, 400);
		contentPane.add(sideDisplay);
		
		/*
		 * Adding buttons
		 */

		JButton ln = new JButton("ln(x)");
		JButton logX = new JButton("log(x)");
		JButton btnCe = new JButton("CE");
		JButton pop = new JButton("POP");
		JButton backSpace = new JButton("<----");
		JButton btnX = new JButton("X^2");
		JButton squareRoot = new JButton("\u221A");
		JButton btnEx = new JButton("e^x");
		JButton btnE = new JButton("e");
		JButton pi = new JButton("\u03C0");
		pi.setForeground(Color.BLACK);
		pi.setBackground(Color.WHITE);
		JButton btnXy = new JButton("X^y");
		JButton one = new JButton("1");
		JButton four = new JButton("4");
		JButton seven = new JButton("7");
		seven.setForeground(Color.BLACK);
		seven.setBackground(Color.DARK_GRAY);
		JButton dot = new JButton(".");
		JButton sinX = new JButton("SIN(X)");
		JButton two = new JButton("2");
		JButton five = new JButton("5");
		JButton eight = new JButton("8");
		JButton zero = new JButton("0");
		JButton cosX = new JButton("COS(X)");
		JButton three = new JButton("3");
		JButton six = new JButton("6");
		JButton nine = new JButton("9");
		JButton push = new JButton("PUSH");
		JButton tanX = new JButton("Tan(X)");
		JButton plus = new JButton("+");
		JButton minus = new JButton("-");
		JButton multiply = new JButton("*");
		JButton divide = new JButton("\u00F7");
		
		/*
		 * setting the position of the buttons
		 */
		
		ln.setBounds(128, 52, 83, 66);
		logX.setBounds(212, 52, 83, 66);
		btnCe.setBounds(295, 52, 83, 66);
		pop.setBounds(377, 52, 83, 66);
		backSpace.setBounds(458, 52, 83, 66);
		btnX.setBounds(128, 120, 83, 66);
		squareRoot.setBounds(128, 186, 83, 66);
		btnEx.setBounds(128, 253, 83, 66);
		btnE.setBounds(128, 319, 83, 66);
		pi.setBounds(128, 386, 83, 66);
		btnXy.setBounds(212, 120, 83, 66);
		one.setBounds(212, 186, 83, 66);
		four.setBounds(212, 253, 83, 66);
		seven.setBounds(212, 319, 83, 66);
		dot.setBounds(212, 384, 83, 66);
		sinX.setBounds(295, 120, 83, 66);
		two.setBounds(295, 186, 83, 66);
		five.setBounds(295, 253, 83, 66);
		eight.setBounds(295, 319, 83, 66);
		zero.setBounds(295, 386, 83, 66);
		cosX.setBounds(377, 120, 83, 66);
		three.setBounds(377, 186, 83, 66);
		six.setBounds(377, 253, 83, 66);
		nine.setBounds(377, 319, 83, 66);
		push.setBounds(377, 387, 83, 66);
		tanX.setBounds(458, 120, 83, 66);
		plus.setBounds(458, 186, 83, 66);
		minus.setBounds(458, 253, 83, 66);
		multiply.setBounds(458, 319, 83, 66);
		divide.setBounds(458, 386, 83, 66);
		
		/*
		 * editing font of the buttons
		 */

		logX.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnCe.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		pop.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		backSpace.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnX.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		squareRoot.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnEx.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnE.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		pi.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnXy.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		one.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		four.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		seven.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		dot.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		sinX.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		two.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		five.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		eight.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		zero.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		cosX.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		three.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		six.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		nine.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		tanX.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		plus.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		minus.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		multiply.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		divide.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		divide.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		ln.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		
		/*
		 * Adding the buttons to the JPanel
		 */
		
		contentPane.add(ln);
		contentPane.add(logX);
		contentPane.add(btnCe);
		contentPane.add(pop);
		contentPane.add(backSpace);
		contentPane.add(btnX);
		contentPane.add(squareRoot);
		contentPane.add(btnEx);
		contentPane.add(btnE);
		contentPane.add(pi);
		contentPane.add(btnXy);
		contentPane.add(one);
		contentPane.add(four);
		contentPane.add(seven);
		contentPane.add(dot);
		contentPane.add(sinX);
		contentPane.add(two);
		contentPane.add(five);
		contentPane.add(eight);
		contentPane.add(zero);
		contentPane.add(cosX);
		contentPane.add(three);
		contentPane.add(six);
		contentPane.add(nine);
		contentPane.add(push);
		contentPane.add(tanX);
		contentPane.add(plus);
		contentPane.add(minus);
		contentPane.add(multiply);
		contentPane.add(divide);

		JScrollPane scrollPane = new JScrollPane(sideDisplay);
		scrollPane.setBounds(6, 52, 110, 400);
		contentPane.add(scrollPane);
		sideDisplay.setText(stack.print());

		String pie = "3.141592653589793";
		String euler = "2.718281828459045";
		
		/*
		 * Adding action listeners to the buttons
		 */
		

		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (display.getText().equals(euler) || display.getText().equals(pie)
						|| display.getText().equals(Double.toString(getAnswer())))
					display.setText("");
				String enterNumber = display.getText() + one.getText();
				display.setText(enterNumber);

			}
		});

		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (display.getText().equals(euler) || display.getText().equals(pie)
						|| display.getText().equals(Double.toString(getAnswer())))
					display.setText("");
				String enterNumber = display.getText() + two.getText();
				display.setText(enterNumber);
			}
		});

		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (display.getText().equals(euler) || display.getText().equals(pie)
						|| display.getText().equals(Double.toString(getAnswer())))
					display.setText("");
				String enterNumber = display.getText() + three.getText();
				display.setText(enterNumber);
			}
		});

		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (display.getText().equals(euler) || display.getText().equals(pie)
						|| display.getText().equals(Double.toString(getAnswer())))
					display.setText("");
				String enterNumber = display.getText() + four.getText();
				display.setText(enterNumber);
			}
		});

		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (display.getText().equals(euler) || display.getText().equals(pie)
						|| display.getText().equals(Double.toString(getAnswer())))
					display.setText("");
				String enterNumber = display.getText() + five.getText();
				display.setText(enterNumber);
			}
		});

		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (display.getText().equals(euler) || display.getText().equals(pie)
						|| display.getText().equals(Double.toString(getAnswer())))
					display.setText("");
				String enterNumber = display.getText() + six.getText();
				display.setText(enterNumber);
			}
		});

		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (display.getText().equals(euler) || display.getText().equals(pie)
						|| display.getText().equals(Double.toString(getAnswer())))
					display.setText("");
				String enterNumber = display.getText() + seven.getText();
				display.setText(enterNumber);
			}
		});

		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (display.getText().equals(euler) || display.getText().equals(pie)
						|| display.getText().equals(Double.toString(getAnswer())))
					display.setText("");
				String enterNumber = display.getText() + eight.getText();
				display.setText(enterNumber);
			}
		});

		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (display.getText().equals(euler) || display.getText().equals(pie)
						|| display.getText().equals(Double.toString(getAnswer())))
					display.setText("");
				String enterNumber = display.getText() + nine.getText();
				display.setText(enterNumber);
			}
		});

		zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (display.getText().equals(euler) || display.getText().equals(pie)
						|| display.getText().equals(Double.toString(getAnswer())))
					display.setText("");
				String enterNumber = display.getText() + zero.getText();
				display.setText(enterNumber);
			}
		});

		btnCe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stack.destroy();
				sideDisplay.setText(stack.print());
				reset();
			}
		});

		push.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int on = 1;
				while (on == 1) {
					if (Pattern.matches("[A-Za-z]+", display.getText())) {
						JOptionPane.showMessageDialog(null, "Must enter a number");
						on = 2;
						reset();
					} else if (display.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Error! Did not enter anything to push");
						on = 2;
					} else {
						stack.push(Double.parseDouble(display.getText()));
						sideDisplay.setText(stack.print());
						reset();
						on = 2;
					}
				}
			}
		});

		pop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAnswer(stack.pop());
				display.setText(Double.toString(getAnswer()));
				sideDisplay.setText(stack.print());
			}
		});

		dot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (display.getText().equals("")) {
					String enterNumber = display.getText() + "0.";
					display.setText(enterNumber);
				} else {
					String enterNumber = display.getText() + dot.getText();
					display.setText(enterNumber);
				}
			}
		});

		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stack.isEmpty())
					JOptionPane.showMessageDialog(null, "Stack is empty");
				else if (stack.size() == 1) {
					JOptionPane.showMessageDialog(null, "Stack ONLY has ONE NUMBER to operate on");
				}

				else {
					setAnswer(stack.operation(1));
					display.setText(Double.toString(getAnswer()));
					sideDisplay.setText(stack.print());

				}
			}
		});

		minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stack.isEmpty())
					JOptionPane.showMessageDialog(null, "Stack is empty");

				else if (stack.size() == 1) {
					JOptionPane.showMessageDialog(null, "Stack ONLY has ONE NUMBER to operate on");
				} else {
					setAnswer(stack.operation(2));
					display.setText(Double.toString(getAnswer()));
					sideDisplay.setText(stack.print());
				}
			}
		});

		multiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stack.isEmpty())
					JOptionPane.showMessageDialog(null, "Stack is empty");
				else if (stack.size() == 1) {
					JOptionPane.showMessageDialog(null, "Stack ONLY has ONE NUMBER to operate on");
				} else {

					setAnswer(stack.operation(3));
					display.setText(Double.toString(getAnswer()));
					sideDisplay.setText(stack.print());
				}
			}
		});

		divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stack.isEmpty())
					JOptionPane.showMessageDialog(null, "Stack is empty");
				else if (stack.size() == 1) {
					JOptionPane.showMessageDialog(null, "Stack ONLY has ONE NUMBER to operate on");
				} else {

					setAnswer(stack.operation(4));
					display.setText(Double.toString(getAnswer()));
					sideDisplay.setText(stack.print());
				}
			}
		});

		squareRoot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (stack.isEmpty())
					JOptionPane.showMessageDialog(null, "Stack is empty ");
				else {
					setAnswer(stack.operation(5));
					display.setText(Double.toString(getAnswer()));
					sideDisplay.setText(stack.print());
				}
			}
		});

		sinX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stack.isEmpty())
					JOptionPane.showMessageDialog(null, "Stack is empty");
				else {
					setAnswer(stack.operation(6));
					display.setText(Double.toString(getAnswer()));
					sideDisplay.setText(stack.print());
				}
			}
		});

		cosX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stack.isEmpty())
					JOptionPane.showMessageDialog(null, "Stack is empty");
				else {
					setAnswer(stack.operation(7));
					display.setText(Double.toString(getAnswer()));
					sideDisplay.setText(stack.print());
				}
			}
		});

		tanX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stack.isEmpty())
					JOptionPane.showMessageDialog(null, "Stack is empty");
				else {
					setAnswer(stack.operation(8));
					display.setText(Double.toString(getAnswer()));
					sideDisplay.setText(stack.print());
				}
			}
		});

		pi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double answer = Math.PI;
				display.setText(Double.toString(answer));
			}
		});

		ln.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stack.isEmpty())
					JOptionPane.showMessageDialog(null, "Stack is empty");
				else {
					setAnswer(stack.operation(10));
					display.setText(Double.toString(getAnswer()));
					sideDisplay.setText(stack.print());
				}
			}
		});

		logX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stack.isEmpty())
					JOptionPane.showMessageDialog(null, "Stack is empty");
				else {
					setAnswer(stack.operation(11));
					display.setText(Double.toString(getAnswer()));
					sideDisplay.setText(stack.print());
				}
			}
		});

		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stack.isEmpty())
					JOptionPane.showMessageDialog(null, "Stack is empty");
				else {
					setAnswer(stack.operation(12));
					display.setText(Double.toString(getAnswer()));
					sideDisplay.setText(stack.print());
				}
			}
		});

		btnXy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stack.isEmpty())
					JOptionPane.showMessageDialog(null, "Stack is empty");
				else if (stack.size() == 1) {
					JOptionPane.showMessageDialog(null, "Stack ONLY has ONE NUMBER to operate on");
				} else {
					setAnswer(stack.operation(13));
					display.setText(Double.toString(getAnswer()));
					sideDisplay.setText(stack.print());
				}
			}
		});

		btnEx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stack.isEmpty())
					JOptionPane.showMessageDialog(null, "Stack is empty");
				else {
					setAnswer(stack.operation(14));
					display.setText(Double.toString(getAnswer()));
					sideDisplay.setText(stack.print());
				}
			}
		});

		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double answer = Math.E;
				display.setText(Double.toString(answer));

			}
		});

		backSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (display.getText().equals(""))
					return;
				else {
					display.setText(display.getText().substring(0, display.getText().length() - 1));
				}
			}
		});

	}
}