import java.util.EmptyStackException;

import javax.swing.JOptionPane;

/*
 * creating the stack below
 */

public class Stack
{
	private class Node
	{
		private double data;
		private Node next;
		
		private Node(double data)
		{
			this.data = data;
			this.next = null;
		}
		
		//getting the data in the stacks
		private double getData()
		{
			return this.data;
		}
		
		//setting the next
		private void setNext(Node next)
		{
			this.next = next;
		}
		
		//getting the next
		private Node getNext()
		{
			return this.next;
		}
	}
	
	private Node root;
	private String theString = "";
	private double arg1,arg2;
	
	//constructor
	public Stack()
	{
		this.root = null;
	}
	
	/*
	 * below are the getters and setters. That will be used in the 
	 * Arithmetic calculation of the calculator
	 */
	private void setArg1(double arg1)
	{
		this.arg1 = arg1;
	}
	
	private double getArg1()
	{
		return this.arg1;
	}
	
	private void setArg2(double arg2)
	{
		this.arg2 = arg2;
	}
	
	private double getArg2()
	{
		return this.arg2;
	}
	
	private void setRoot(Node root)
	{
		this.root = root;
	}
	
	private Node getRoot()
	{
		return this.root;
	}
	
	//checking if the stack is empty
	public boolean isEmpty()
	{
		return getRoot() == null;
	}
	
	//getting size of the stack
	public int size()
	{
		int counter = 0;
		
		Node sizer = getRoot();
		
		while(sizer != null)
		{
			counter++;
			sizer = sizer.getNext();
		}
		
		return counter;
	}
	
	//push method
	public void push(double data)
	{
		Node newNode = new Node(data);
		
		if(isEmpty())
		{
			setRoot(newNode);
		}
		else
		{
			newNode.setNext(getRoot());
			setRoot(newNode);
		}

	}
	
	//look what's at the top of the stack
	public double peek()
	{
		if(isEmpty())
		{
			return 0;
		}
		else
		{
			return getRoot().getData();
		}
	}
	
	//pop the top item on the stack
	public double pop()
	{
		double temp;
		
		if(isEmpty())
		{
			return 0;
		}
		else if(size() == 1)
		{
			temp = getRoot().getData();
			destroy();
			return temp;
		}
		else
		{
			temp = getRoot().getData();
			setRoot(getRoot().getNext());
			return temp;
			
		}
		
	}
	
	//method used to correctly print onto the calculator
	public String print()
	{
		theString = "Stack contents"+ "\n" + "------------"+ 
                "\n"+ " "+"\n";
		if(isEmpty())
			return "Stack is empty!";
		else
		{
			Node curr = getRoot(); 
			
			theString +="-->" + curr.getData()+ "\n";
			curr = curr.getNext();
			
			while(curr != null)
			{
				theString +=("   " + curr.getData()) + "\n";
				curr = curr.getNext();
			}
			
			
		}
		return theString;
	}
	
	/*
	 * Calculate the Arithmetic operations for
	 * the calculator
	 */
	public double operation (int operation)
	{

		double temp = 0;
	    setArg1(this.pop());
	    if(operation == 5 || operation == 6 || operation == 7 || operation == 8
	    		|| operation == 10 || operation == 11 || operation == 12 || operation == 14 )
	    	setArg2(0);
	    else
	    	setArg2(this.pop());
		
		switch(operation)
		{
		//addition
		case 1:
				temp= getArg1()+getArg2();
			break;
		case 2:
		//subtraction
			if(getArg1()>getArg2())
				temp =getArg1()-getArg2();
			else
			{
				temp =getArg2()-getArg1();
			}
			 break;
		case 3:
		//multiplication
			temp= getArg1()*getArg2();
		    break;
		case 4:
		//division
			if(getArg1() == 0)
				JOptionPane.showMessageDialog(null, "Error division by zero");
			else
			{
				temp = getArg2()/getArg1();
			}
		    break;
		case 5:
		//square root
			temp = Math.sqrt(getArg1());
			break;
		case 6:
		//sin
			temp = Math.sin(getArg1());
			break;
		case 7:
		//cos
			temp = Math.cos(getArg1());
			break;
		case 8:
		//tan
			temp = Math.tan(getArg1());
			break;
		case 9://pi
			temp = Math.PI;
			break;
		case 10://ln
			temp = Math.log(getArg1());
			break;
		case 11:
		//log base 10
			temp = Math.log10(getArg1());
			break;
		case 12:
		//to power of 2
			temp = Math.pow(getArg1(), 2);
			break;
		case 13:
		//user entered exponent
			temp = Math.pow(getArg2(), getArg1());
			break;
		case 14:
			temp = Math.exp(getArg1());
			break;
				
		}
		return temp;
	}
	
	//destroy the stack
	public void destroy()
	{
		setRoot(null);
	}
}