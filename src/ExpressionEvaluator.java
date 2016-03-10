import java.util.Scanner;

/******************************************************************************
 * 
 * Name:		Savion Sample
 * Block:		D
 * Date:		March 8, 2016
 * 
 *  Program #9:	Expression Evaluator
 *  Description:
 *     This program reads in arithmetic expressions in postfix notation, constructs the corresponding 
 *     expression tree, evaluates the expression tree, and then prints the result.  
 *     The program consists of the following classes: Token, TreeNode, ExpressionTree, 
 *     ListNode, Stack and ExpressionEvaluator. All the methods associated with getting
 *     tokens and constructing Expression Trees are included in the main class.
 * 
 ******************************************************************************/

public class ExpressionEvaluator 
{
	public static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		boolean cont = true;
		
		// the main loop of the program that runs until the user asks to quit
		while (cont)
		{
			ExpressionTree expressionTree = generateExpressionTree();
			if (expressionTree != null)
			{
				System.out.println("Answer: " + expressionTree.evaluate());
				System.out.println("To String Post Order:\n" + 
						expressionTree.toStringPostOrder());
			}
			
			System.out.println("Do you want to continue? ('q' to quit)");
			String userInput = sc.nextLine();
			if (userInput.equals("q"))
			{
				cont = false;
			}
		}
	}
	
	/**
	 * using the user's entered Token, this method creates an Expression Tree
	 * out of it an pushes it onto the stack. The possible Token types are:
	 * number (#), unary (u), binary (b) and end (e) which pops off the last
	 * Expression Tree in the stack and returns it.
	 * 
	 * @return ExpressionTree to be evaluated later on
	 */
	public static ExpressionTree generateExpressionTree() 
	{
		Stack stack = new Stack();
		
		while (true)
		{
			Token t = getToken();
			if (t == null)
			{
				System.out.println("Error - invalid operation");
			}
			else if (t.getType() == Token.NUMBER)
			{
				stack.push(new ExpressionTree(t, null, null));
			}
			else if (t.getType() == Token.UNARY)
			{
				ExpressionTree pop = (ExpressionTree) stack.pop();
				stack.push(new ExpressionTree(t, pop, null));
			}
			else if (t.getType() == Token.BINARY)
			{
				ExpressionTree pop1 = (ExpressionTree) stack.pop();
				ExpressionTree pop2 = (ExpressionTree) stack.pop();
				stack.push(new ExpressionTree(t, pop2, pop1));
			}
			else if (t.getType() == Token.END)
			{
				return (ExpressionTree) stack.pop();
			}
			else
			{
				System.out.println("Error - invalid token");
				return null;
			}
		}
	}
	
	/**
	 * Using the user's input, this method creates a Token with a type/value/operator
	 * 
	 * @return the completed Token
	 */
	public static Token getToken()
	{
		String type = "";
		boolean check = false;
		
		do
		{
			System.out.println("Please enter a 'u', 'b', '#' or 'e' ");
			type = sc.nextLine();
			check = checkInput(type);
		}
		while (!check);
		
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
		else if (type.equals("e"))
		{
			return new Token(Token.END, Token.EMPTY, Token.EMPTY);
		}
		else
		{
			System.out.println("Error");
			return new Token(Token.EMPTY, Token.EMPTY, Token.EMPTY);
		}
	}
	
	/**
	 * checks to see if the user has entered a valid command
	 * 
	 * @param type: the user's operator input
	 * @return: whether the input is valid or not
	 */
	private static boolean checkInput(String type)
	{
		return type.equals("u") || type.equals("b") || 
				type.equals("#") || type.equals("e");
	}
	
	/**
	 * prompts the user for a double value and creates a Token with that information
	 * 
	 * @return: the completed Token
	 */
	private static Token numberToken()
	{
		// (reverse) polish notation only allows positive numbers.
		// negative numbers can be done with a unary (-)
		double num;
		do
		{
			System.out.println("Please enter a positive number");
			num = sc.nextDouble();
		}
		while (num < 0);
		sc.nextLine();
		System.out.println(num);
		return new Token(Token.NUMBER, num, Token.EMPTY);	
	}
	
	/**
	 * prompts the user for an operator (+ / -) and creates a Token with that information
	 * 
	 * @return: the completed Token
	 */
	private static Token unaryToken()
	{
		System.out.println("Please enter the operator for unary:  +, -, x (exponent), s (square root), l (natural log)");
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
		else if (op.equals("x"))
		{
			return new Token(Token.UNARY, Token.EMPTY, Token.EXPONENT);
		}
		else if (op.equals("s"))
		{
			return new Token(Token.UNARY, Token.EMPTY, Token.SQUAREROOT);
		}
		else if (op.equals("l"))
		{
			return new Token(Token.UNARY, Token.EMPTY, Token.LOG);
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * prompts the user for an operator and creates a Token with that information
	 * 
	 * @return: the completed Token
	 */
	private static Token binaryToken()
	{
		System.out.println("Please enter the operator: +, -, *, and /");
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
