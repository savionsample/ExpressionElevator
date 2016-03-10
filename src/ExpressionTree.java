
/******************************************************************************
* Savion Sample
* ExpressionTree Class
* Stores all the information of making an ExpressionTree like evaluating its
* TreeNodes as well as containing a method for a toString
******************************************************************************/

public class ExpressionTree 
{
	
	private TreeNode root;

	public ExpressionTree(Token rootToken, ExpressionTree leftExpr, ExpressionTree rightExpr)
	{
		 if (leftExpr != null && rightExpr != null)
		 {
			 root = new TreeNode(rootToken, leftExpr.root , rightExpr.root);
		 }
		 else if (leftExpr != null && rightExpr == null)
		 {
			 root = new TreeNode(rootToken, leftExpr.root, null);
		 }
		 else if (leftExpr == null && rightExpr != null)
		 {
			 root = new TreeNode(rootToken, null, rightExpr.root);
		 }
		 else
		 {
			 root = new TreeNode(rootToken, null, null);
		 }
	}
	
	public double evaluate( )
	{
		return auxEvaluate(root);
	}
	
	/**
	 * This method evaluates the expression by performing a postorder traversal, performing
	 * the op after evaluating each of its children. 
	 * This method evaluates the TreeNode's left and right children and performs
	 * the right operation on it. 
	 * 
	 * @param t: a pointer to the TreeNode being worked on
	 * @return: the results (double) of the TreeNode evaluated
	 */
	private Double auxEvaluate(TreeNode t)
	{
		if (t == null)
		{
			return 0.0;
		}
		else
		{
			Token val = (Token) t.getValue();
			if (val.getType() == Token.NUMBER)
			{
				return val.getNum();
			}
			else if (val.getType() == Token.UNARY)
			{
				double left = auxEvaluate(t.getLeft());
				if (val.getOp() == Token.PLUS)
				{
					return left;
				}
				else if (val.getOp() == Token.MINUS)
				{
					return -left;
				}
				else if (val.getOp() == Token.EXPONENT)
				{
					return left * left;
				}
				else if (val.getOp() == Token.SQUAREROOT)
				{
					return Math.sqrt(left);
				}
				else if (val.getOp() == Token.LOG)
				{
					if (left > 0)
					{
						return Math.log(left);
					}
					else
					{
						return 0.0;
					}
				}
			}
			else if (val.getType() == Token.BINARY)
			{
				double left = auxEvaluate(t.getLeft());
				double right = auxEvaluate(t.getRight());
				if (val.getOp() == Token.ADD)
				{
					return left + right;
				}
				else if (val.getOp() == Token.SUBTRACT)
				{
					return left - right;
				}
				else if (val.getOp() == Token.MULTIPLY)
				{
					return left * right;
				}
				else if (val.getOp() == Token.DIVIDE)
				{
					return left / right;
				}
				
			}
			return null;
			
		}
	}
	
	public String toStringPostOrder( )
	{
		return auxToStringPostOrder(root);
	}
	
	/**
	 * returns a string of the commands entered by the user
	 * 
	 * @param t: a pointer to the TreeNode being worked on
	 * @return: the entire String of the user's commands
	 */
	private String auxToStringPostOrder(TreeNode t)
	{
		if (t == null)
		{
			return "";
		}
		else
		{
			return auxToStringPostOrder(t.getLeft()) + 
					auxToStringPostOrder(t.getRight()) + 
					t.getValue() + "\n";
		}
		
	}
}