import java.util.*;
import java.io.*;


// Implement a linked list from the object A2Node
class A2List {

	private static Scanner keyboardInput = new Scanner (System.in);
	public static A2Node head, tail; // head and tail of the linked list
	private static final int MaxInitCount = 10;
	private static final int MaxReqCount = 100;
	public static int initCount;
	public static int reqCount;

	public static int[] reqData = new int[MaxReqCount]; // store the requests, accessible to all methods


	// DO NOT change the main method
	public static void main(String[] args) throws Exception {
		A2Node curr;
		int tmp=-1;
		int[] initData = new int[MaxInitCount];

		initCount = 0;
		reqCount = 0;
		head = null;
		tail = null;

		try {
//			System.out.println();
//			System.out.print("Enter the initial number of files in the cabinet (1-" + MaxInitCount + "): ");
			initCount = keyboardInput.nextInt();
			if (initCount > MaxInitCount || initCount <= 0)
				System.exit(0);
//			System.out.print("Enter the initial file IDs in the cabinet (" + initCount + " different +ve integers): ");
			for (int i=0; i<initCount; i++)
				initData[i] = keyboardInput.nextInt();				
//			System.out.println();
//			System.out.print("Enter the number of file requests (1=" + MaxReqCount + "): ");
			reqCount = keyboardInput.nextInt();
			if (reqCount > MaxReqCount || reqCount <= 0)
				System.exit(0);
//			System.out.print("Enter the request file IDs (" + reqCount + " different +ve integers): ");
			for (int i=0; i<reqCount; i++)
				reqData[i] = keyboardInput.nextInt();				
		}
		catch (Exception e) {
			keyboardInput.next();
			System.exit(0);
		}


		
		try {
			System.out.println("appendIfMiss...");
			// create a list with the input data
			// call appendIfMiss()
			for (int i=initCount-1; i>=0; i--) {
				insertNodeHead(new A2Node(initData[i]));
			}
			appendIfMiss();
		}
		catch (Exception e) {
			System.out.println("appendIfMiss exception! " + e);
		}

		try {
			System.out.println("moveToFront...");
			// empty the previous list and restart with the input data
			// then call moveToFront()
			emptyList();
			for (int i=initCount-1; i>=0; i--) {
				insertNodeHead(new A2Node(initData[i]));
			}
			moveToFront();
		}
		catch (Exception e) {
			System.out.println("moveToFront exception!");
		}

		try {
			System.out.println("freqCount...");
			// empty the previous list and restart with the input data
			// then call freqCount()
			emptyList();
			for (int i=initCount-1; i>=0; i--) {
				insertNodeHead(new A2Node(initData[i]));
			}
			freqCount();
		}
		catch (Exception e) {
			System.out.println("freqCount exception!");
		}		
	}
	
	// append to end of list when miss
	static void appendIfMiss() {
		int hits = 0;
		String costs = "";
		for (int i = 0; i < reqCount; i++){
			int cost  = 0;
			A2Node curr;
			boolean flag = false;
			curr = head;
			while(curr != null && !flag){
				if(curr.data == reqData[i]){
					flag = true;
				}
				else{
					curr = curr.next;
				}
				cost++;
			}
			costs += cost+" ";
			if(flag){
				hits++;
			}
			else{
				A2Node temp = new A2Node(reqData[i]);
				tail.next = temp;
				tail = temp;
			}
		}
		System.out.println(costs);
		System.out.println(hits + " h");
		
		printList();
	}

	// move the file requested to the beginning of the list
	static void moveToFront() {
		int hits = 0;
		String costs = "";
		for (int i = 0; i < reqCount; i++){
			int cost  = 0;
			A2Node curr;
			boolean flag = false;
			curr = head;
			while(curr != null && !flag){
				if(curr.data == reqData[i]){
					flag = true;
				}
				else{
					curr = curr.next;
				}
				cost++;
			}
			costs += cost+" ";
			if(flag){
				hits++;
			}
			else{
				A2Node temp = new A2Node(reqData[i]);
				tail.next = temp;
				tail = temp;
			}
		}
		System.out.println(costs);
		System.out.println(hits + " h");
		
		printList();
	}
	
	// move the file requested so that order is by non-increasing frequency
	static void freqCount() {
		
	}

	static void insertNodeHead(A2Node newNode) {

		newNode.next = head;
		if (head == null)
			tail = newNode;
		head = newNode;
	}

	// DO NOT change this method
	// delete the node at the head of the linked list
	static A2Node deleteHead() {
		A2Node curr;

		curr = head;
		if (curr != null) {
			head = head.next;
			if (head == null)
				tail = null;
		}
		return curr;
	}

	// DO NOT change this method
	// print the content of the list in two orders:
	// from head to tail
	static void printList() {
		A2Node curr;

		System.out.print("List: ");
		curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	
	// DO NOT change this method
	static void emptyList() {
		
		while (head != null)
			deleteHead();
	}

}