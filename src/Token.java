
/******************************************************************************
* Savion Sample
* Token Class
* Contains all the information about making a Token. Contains finals representing
* each possible paramater for making a token. This class contains getter methods
* as well a toString method.
******************************************************************************/
public class Token 
{
	// private data
	private int type;
	private double num;
	private int op;
	
	// Empty
	public static final int EMPTY = 0;
	// Types
	public static final int NUMBER = 1;
	public static final int UNARY = 2;
	public static final int BINARY = 3;
	public static final int END = 4;
	// Unary Ops
	public static final int PLUS = 5;
	public static final int MINUS = 6;
	// Binary Ops
	public static final int ADD = 7;
	public static final int SUBTRACT = 8;
	public static final int MULTIPLY = 9;
	public static final int DIVIDE = 10;
	// Extra Ops
	public static final int EXPONENT = 11;
	public static final int SQUAREROOT = 12;
	public static final int LOG = 13;
	
	public Token(int type, double num, int op)
	{
		this.type = type;
		this.num = num;
		this.op = op;
	}

	// getter methods
	public int getType()
	{
		return type;
	}
	
	public double getNum()
	{
		return num;
	}
	
	public int getOp()
	{
		return op;
	}
	
	/**
	 * the Token's values in String format
	 */
	public String toString()
	{
		String total = "";
		
		
		if (type == Token.NUMBER)
		{
			total += "# " + num;
		}
		else if (type == Token.UNARY)
		{
			total += "u ";
			if (op == Token.PLUS)
			{
				total += "+";
			}
			else if (op == Token.MINUS)
			{
				total += "-";
			}
			else if (op == Token.EXPONENT)
			{
				total += "x";
			}
			else if (op == Token.SQUAREROOT)
			{
				total += "s";
			}
			else if (op == Token.LOG)
			{
				total += "l";
			}
		}
		else if (type == Token.BINARY)
		{
			total += "b ";
			if (op == Token.ADD)
			{
				total += "+";
			}
			else if (op == Token.SUBTRACT)
			{
				total += "-";
			}
			else if (op == Token.MULTIPLY)
			{
				total += "*";
			}
			else if (op == Token.DIVIDE)
			{
				total += "/";
			}
		}
		return total;
		
	}

}
