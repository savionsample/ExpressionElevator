
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
	
	// evaluates through post order
	private double auxEvaluate(TreeNode t)
	{
		
	}
	
	public String toStringPostOrder( )
	{
		return auxToStringPostOrder(root);
	}
	
	private String auxToStringPostOrder(TreeNode t)
	{
		if (t == null)
		{
			return "";
		}
		else
		{
			return auxToStringPostOrder(t.getLeft()) + auxToStringPostOrder(t.getRight()) + t.getValue() + "\n";
		}
		
	}
}
















