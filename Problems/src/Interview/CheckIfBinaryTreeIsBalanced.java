package Interview;

public class CheckIfBinaryTreeIsBalanced {

	
	public int getHeightOfBinaryTree(Node root){
		
		if(root == null)
			return 0;
		
		int heightLeft = getHeightOfBinaryTree(root.getLeft());
		
		if(heightLeft == -1)
			return -1;
		
		int heightRight = getHeightOfBinaryTree(root.getRight());
		if(heightRight == -1)
			return -1;
		
		if(Math.abs(heightLeft - heightRight) > 1){
			return -1;
		}else{
			return 1 + Math.max(heightLeft, heightRight);
		}
		
	}
	
	public boolean checkIfTreeIsBaclanced(Node root){
		return getHeightOfBinaryTree(root) == -1 ? false:true;
	}
	
	
	
	public static void main(String[] args) {

		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);

		node3.setLeft(node1);
		node1.setRight(node2);

		node3.setRight(node5);
		node5.setLeft(node4);
		node5.setRight(node7);

		node7.setRight(node8);
		node7.setLeft(node6);
		node7.setLeft(node6);

		node8.setRight(node9);

		CheckIfBinaryTreeIsBalanced alg = new CheckIfBinaryTreeIsBalanced();
		System.out.println(alg.checkIfTreeIsBaclanced(node3));
		
		
	}

}
