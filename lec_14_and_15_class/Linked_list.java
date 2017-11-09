package lec_14_and_15_class;

public class Linked_list {
	private class node {
		int data;
		node next;

		node(int item, node next) {
			this.data = item;
			this.next = next;
		}
	}

	private int size;
	private node head;
	private node tail;

	Linked_list() {
		this.head = null;
		this.tail = null;
	}

	public int size() {
		return this.size;
	}

	public boolean isempty() {
		return this.size == 0;
	}

	public void addfirst(int item) {
		node temp = new node(item, this.head);
		this.head = temp;
		if (isempty()) {
			this.tail = temp;
		}
		this.size++;
	}

	public void addlast(int item) {
		node temp = new node(item, null);
		if (isempty()) {
			this.head = temp;
			this.tail = temp;
		} else {
			this.tail.next = temp;
			this.tail = temp;
		}
		this.size++;
	}

	public void addat(int item, int index) throws Exception {
		if (index < 0 || index > this.size) {
			throw new Exception("Index out of bound");
		}
		if (index == this.size) {
			this.addlast(item);
		} else if (index == 0) {
			this.addfirst(item);
		} else {
			node temp = get_node_at(index - 1);
			node Node = new node(item, temp.next);
			temp.next = Node;
			this.size++;
		}

	}

	public void display() throws Exception {
		if (isempty()) {
			throw new Exception("List is Empty");
		}
		node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + "=>");
			temp = temp.next;
		}
		System.out.print("END\n");
		System.out.println("**********************");
	}

	public int getfirst() {
		return this.head.data;
	}

	public int getlast() {
		return this.tail.data;
	}

	private node get_node_at(int index) throws Exception {
		if (index < 0 || index >= this.size) {
			throw new Exception("Index out of bound");
		}
		if (isempty()) {
			throw new Exception("List is Empty");
		}
		int counter = 0;
		node temp = this.head;
		while (counter < index) {
			temp = temp.next;
			counter++;
		}
		return temp;
	}

	public int get_at(int index) throws Exception {
		if (index < 0 || index >= this.size) {
			throw new Exception("Index out of bound");
		}
		if (isempty()) {
			throw new Exception("List is Empty");
		}
		if (index == this.size) {
			this.getlast();
		} else if (index == 0) {
			this.getfirst();
		} else {
			int counter = 0;
			node temp = this.head;
			while (counter < index) {
				temp = temp.next;
				counter++;
			}
		}
		int counter = 0;
		node temp = this.head;
		while (counter < index) {
			temp = temp.next;
			counter++;
		}
		return temp.data;
	}

	public int remove_first() throws Exception {
		if (isempty()) {
			throw new Exception("List is Empty");
		}
		node rv = this.head;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		}
		this.head = this.head.next;
		this.size--;
		return rv.data;
	}

	public int remove_last() throws Exception {
		if (isempty()) {
			throw new Exception("List is Empty");
		}
		node rv = this.tail;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			node temp = get_node_at(this.size() - 2);
			temp.next = null;
			this.tail = temp;
		}
		this.size--;
		return rv.data;
	}

	public int remove_at(int index) throws Exception {
		if (isempty()) {
			throw new Exception("List is Empty");
		}
		if (index == 0) {
			return this.remove_first();
		} else if (index == this.size() - 1) {
			return this.remove_last();
		} else {
			node rv = get_node_at(index);
			node temp = get_node_at(index - 1);
			temp.next = temp.next.next;
			this.size--;
			return rv.data;
		}
	}

	public void revDI() throws Exception {
		for (int i = 0; i <= this.size() / 2; i++) {
			node val1 = get_node_at(i);
			node val2 = get_node_at(this.size() - 1 - i);
			int temp = val1.data;
			val1.data = val2.data;
			val2.data = temp;

		}
	}

	public void revDR(int si) throws Exception {
		if (si == this.size() / 2 + 1) {
			return;
		}
		node val1 = get_node_at(si);
		node val2 = get_node_at(this.size() - 1 - si);
		revDR(si + 1);
		int temp = val1.data;
		val1.data = val2.data;
		val2.data = temp;
	}

	public void revPI() throws Exception {
		for (int i = 0; i < this.size() / 2 + 1; i++) {
			node val1 = get_node_at(i);
			node val2 = get_node_at(this.size() - 1 - i);
			node temp = val1.next;
			val1.next = val2.next;
			val2.next = temp;
		}
		node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
	}

	public void revPI_beta() {
		node curr = this.head;
		node prev = null;
		node next = null;
		for (int i = 0; i < this.size(); i++) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		this.head = prev;
	}

	public void revPR(node curr, node prev, node next, int si) {
		if (si == this.size()) {
			this.head = prev;
			return;
		}
		if(si==0){
			curr=this.head;
		}
		next = curr.next;
		curr.next = prev;
		revPR(next, curr, next, si + 1);

	}
	public void revDR_beta(){
		Heapmover left=new Heapmover(this.head);
		revDR_beta(left,this.head,0);
	}
	private void revDR_beta(Heapmover left,node right,int floor){
		if(right==null){
			return;
		}
		revDR_beta(left,right.next,floor+1);
		if(floor>=this.size()/2){
			int temp=left.Node.data;
			left.Node.data=right.data;
			right.data=temp;
			
			left.Node=left.Node.next;
		}
	}
	public int  kthnode_from_end(int k) throws Exception{
		if(k<1||k>this.size()){
			throw new Exception("Invalid Index\n");
		}
		node p1=this.head;
		node p2=this.head;
		for(int i=1;i<k;i++){
			p2=p2.next;
		}
		while(p2.next!=null){
			p1=p1.next;
			p2=p2.next;
		}
		return p1.data;
	}
	public class Heapmover{
		node Node;
		Heapmover(node Node){
			this.Node=Node;
		}
	}
	public Linked_list merge(Linked_list other){
		node ll1p=this.head;
		node ll2p=other.head;
		Linked_list llm=new Linked_list();
		while(ll1p!=null&&ll2p!=null){
			if(ll1p.data<ll2p.data){
				llm.addlast(ll1p.data);
				ll1p=ll1p.next;
			}
			else{
				llm.addlast(ll2p.data);
				ll2p=ll2p.next;
			}
		}
		if(ll1p!=null){
			while(ll1p!=null){
				llm.addlast(ll1p.data);
				ll1p=ll1p.next;
			}
		}
		if(ll2p!=null){
			while(ll2p!=null){
				llm.addlast(ll2p.data);
				ll2p=ll2p.next;
			}
		}
		return llm;
	}
	//turtle and hare algo
	private node get_mid_node_merge(node head,node tail){
		node slow=head,fast=head;
		while(fast.next!=tail&&fast.next.next!=tail){
			fast=fast.next.next;
			slow=slow.next;
		}
		return slow;
	}
	public Linked_list ll_merge_sort(Linked_list ll){
		node low=this.head;
		node high=this.tail;
		return ll_merge_sort( ll, low, high);
	}
	private Linked_list ll_merge_sort(Linked_list ll,node low ,node high){
		if(low==high){
			Linked_list base = new Linked_list();
			base.addfirst(low.data);
			return base;
		}
		node mid=get_mid_node_merge(low,high);
		Linked_list fhalf=ll_merge_sort(ll, low, mid);
		Linked_list shalf=ll_merge_sort(ll, mid.next, high);
		Linked_list fres= fhalf.merge(shalf);
		return fres;
	}
	public int find(int data){
		return find(this.head,data);
	}
	private int find(node Node,int data){
		if(Node==null){
			return -1;
		}
		if(Node.data==data){
			return 0;
		}
		else{
			int rv=find(Node.next,data);
			if(rv==-1){
				return rv;
			}else{
				return rv+1;
			}
		}
	}
}
