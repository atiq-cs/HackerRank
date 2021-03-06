package Interview;

public class ReverseLinkedList {
	
	private LinkListNode head;
	
	public ReverseLinkedList(){
		head = new LinkListNode(-1);
	}
	
	public static LinkListNode reverseIteratively(LinkListNode node){

		if(node == null){
			return null;
		}
		if(node.getNext() == null){
			return node;
		}
		LinkListNode behind = node;
		LinkListNode curr = node.getNext();
		behind.setNext(null);
		
		while(curr.getNext() != null){
			LinkListNode tempCurr =  new LinkListNode(curr);
			curr.setNext(behind);
			behind = curr;
			curr = tempCurr.getNext();
		}
		
		curr.setNext(behind);
		return curr;
		
	}
	
	public  LinkListNode reverseRecursively(LinkListNode node){
		
		if(node == null){
			return null;
		}
		
		if(node.getNext() == null){
			head = node;
			return node;
		}
		
		LinkListNode tempNextNode = node.getNext();
		node.setNext(null);
		LinkListNode tail = reverseRecursively(tempNextNode);
		tail.setNext(node);
		
		return node;
		
	}
	
	public static LinkListNode reverseItr(LinkListNode node){
		
		if(node == null){
			return null;
		}
		
		if(node.getNext() ==  null){
			return node;
		}
		
		LinkListNode behind = node;
		LinkListNode curNode = node.getNext();
		
		behind.setNext(null);
		
		while(curNode.getNext() != null){
			
			LinkListNode temp = curNode.getNext();
			curNode.setNext(behind);
			behind = curNode;
			curNode = temp;
			
		}
		curNode.setNext(behind);
		
		return curNode;
	}

	public LinkListNode getHead() {
		return head;
	}

	public void setHead(LinkListNode head) {
		this.head = head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkListNode node0 = new LinkListNode(0);
		LinkListNode node1 = new LinkListNode(1);
		LinkListNode node2 = new LinkListNode(2);
		LinkListNode node3 = new LinkListNode(3);
		LinkListNode node4 = new LinkListNode(4);
		
		node0.setNext(node1);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);

		LinkListNode initial = node0;
		while(initial != null){
			System.out.println(initial.getValue());
			initial = initial.getNext();
		}
		
		//LinkListNode node = reverseIteratively(node0);
		LinkListNode node = reverseItr(node0);
		
		while(node!= null){
			System.out.println(node.getValue());
			node = node.getNext();
		}
		
		/*
		ReverseLinkedList reverse = new ReverseLinkedList();
		reverse.reverseRecursively(node0);
		LinkListNode newHead = reverse.getHead();
		while(newHead!= null){
			System.out.println(newHead.getValue());
			newHead = newHead.getNext();
		}
		 */
		
	}

}
