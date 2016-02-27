
public class Token {
	
	private int type;
	private double num;
	private int op;
	
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
	
	
	
	public Token(int type, double num, int op)
	{
		this.type = type;
		this.num = num;
		this.op = op;
	}

	
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
	
	public String toString()
	{
		String total = "";
		
		
		if (type == 1)
		{
			total += "# " + num;
		}
		else if (type == 2)
		{
			total += "u ";
			if (op == 5)
			{
				total += "+";
			}
			else if (op == 5)
			{
				total += "-";
			}
		}
		else if (type == 3)
		{
			total += "b ";
			if (op == 7)
			{
				total += "+";
			}
			else if (op == 8)
			{
				total += "-";
			}
			else if (op == 9)
			{
				total += "*";
			}
			else if (op == 10)
			{
				total += "/";
			}
		}
		
		return total;
		
	}

}
