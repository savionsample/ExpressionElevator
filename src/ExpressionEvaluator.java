import java.util.Scanner;



public class ExpressionEvaluator 
{
	public static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) 
	{	
		while (true)
		{
			ExpressionTree expressionTree = generateExpressionTree();
			System.out.println(expressionTree.toStringPostOrder());
			//expressionTree.evaluate();

		}
	}
	
	public static ExpressionTree generateExpressionTree() 
	{
		Stack stack = new Stack(0);
		Token t = getToken();
		while (true)
		{
			if (t == null)
			{
				System.out.println("Error, invalid token");
			}
			else if (t.getType() == Token.NUMBER)
			{
				stack.push(new ExpressionTree(t, null, null));
			}
			else if (t.getType() == Token.UNARY)
			{
				ExpressionTree popped = (ExpressionTree) stack.pop();
				stack.push(new ExpressionTree(t, popped, null));
			}
			else if (t.getType() == Token.BINARY)
			{
				ExpressionTree pop1 = (ExpressionTree) stack.pop();
				ExpressionTree pop2 = (ExpressionTree) stack.pop();
				stack.push(new ExpressionTree(t, pop1, pop2));
			}
			else if (t.getType() == Token.END)
			{
				return (ExpressionTree) stack.pop();
			}
			else
			{
				System.out.println("Error");
				return null;
			}
		}
	}
	
	
	public static Token getToken()
	{
		String type = "";
		
		do
		{
			System.out.println("Please enter a 'b', 'u', '#' or 'e' "); // #, b, u, e
			type = sc.nextLine();
		}
		while (type == "");
		
		if (type.equals("#"))
		{
			return numberToken();
		}
		else if (type.equals("u"))
		{
			return unaryToken();
		}
		else if (type.equals("b"))
		{
			return binaryToken();
		}
		else
		{
			System.out.println("Error");
			return new Token(Token.EMPTY, Token.EMPTY, Token.EMPTY);
		}
	}
	
	private static Token numberToken()
	{
		System.out.println("Please enter the number");
		double num = sc.nextDouble();
		System.out.println(num);
		return new Token(Token.NUMBER, num, Token.EMPTY);	
	}
	
	private static Token unaryToken()
	{
		System.out.println("Please enter the operator");
		String op = sc.nextLine();
		System.out.println(op);
		
		if (op.equals("+"))
		{
			return new Token(Token.UNARY, Token.EMPTY, Token.PLUS);
		}
		else if (op.equals("-"))
		{
			return new Token(Token.UNARY, Token.EMPTY, Token.MINUS);
		}
		else
		{
			return null;
		}
	}
	
	private static Token binaryToken()
	{
		System.out.println("Please enter the operator");
		String op = sc.nextLine();
		System.out.println(op);
		
		if (op.equals("+"))
		{
			return new Token(Token.BINARY, Token.EMPTY, Token.ADD);
		}
		else if (op.equals("-"))
		{
			return new Token(Token.BINARY, Token.EMPTY, Token.SUBTRACT);
		}
		else if (op.equals("*"))
		{
			return new Token(Token.BINARY, Token.EMPTY, Token.MULTIPLY);
		}
		else if (op.equals("/"))
		{
			return new Token(Token.BINARY, Token.EMPTY, Token.DIVIDE);
		}
		else
		{
			return null;
		}
	}

}
