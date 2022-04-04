package com.vti.DoubleLinkedList;

public class DoubleLinkedList {

	Node head;
	Node tail;

	public DoubleLinkedList() {

		head = tail = null;
	}

	public DoubleLinkedList(Node node) {
		Add(node);
	}

	// Thêm Node
	public void Add(Node node) {

		if (head == null) {
			head = tail = null;
		} else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}

	}

	// Truyền Data to tìm Node

	public Node Find(int Data) {
		Node now = head;

		while (now != null) {
			if (now.Data == Data) {

				now = now.next;

			}
			return now;
		}
		;
		return null;

	}

	// Tim Node
	public Node Find(Node node) {
		return this.Find(node.Data);
	}

	// Thêm Node vào đầu danh sách
	public void AddFirst(Node node) {
		node.next = head;
		node.prev = node;
		head = node;
	}

	// Truyền Data vào Node
	public void AddFirst(int Data) {

		@SuppressWarnings("unused")
		Node node = new Node(Data);
		this.AddFirst(node);

	}

	// Thêm Node vào trước khóa k
	public void AddFirst(int k, int Data) {

		Node node = new Node(Data);

		this.AddFirst(k, node);
	}

	public void AddFirst(int k, Node node) {

		if (head == null) {
			System.out.println("Danh sach rỗng.");
			return;
		}
		;

		if (head.Data == k) {
			this.AddFirst(node);
			return;
		}

		Node nodek = this.Find(k);
		if (nodek == null) {
			System.out.println("Khong tim thay khoa K");
			return;
		}

		nodek.prev.next = node;
		node.prev = nodek.prev;
		node.next = nodek;
		nodek.prev = node;

	}

	// Thêm Node vào sau khóa k
	public void AddAfterk(int k, Node node) {
		Node nodek = this.Find(k);

		if (nodek == null) {
			System.out.println("không tìm thấy khóa k");
			return;
		}

		if (nodek.next == null) {
			this.Add(node);
			return;
		}

		node.next = nodek.next;
		nodek.next.prev = node;
		nodek.next = node;
		node.prev = nodek;

		if (node.next != null) {
			tail = node;
		}
	}

	//
	public void Deletek(int k) {
		Node node = new Node(k);
		this.Deletek(node);
	}

	// Xóa phần tử có khóa K
	public void Deletek(Node k) {
		if (head == null) {
			System.out.println("Danh sách rỗng.");
			return;
		}
		;
		if (head.Data == k.Data) {
			this.DeleteFirst();
			return;
		}
		Node nodek = this.Find(k);
		if (nodek == null) {
			System.out.println("Không tìm thấy khoá k");
			return;
		}
		if (nodek.next == null) {
			this.DeleteAfter();
			return;
		}
		nodek.prev.next = nodek.next;
		nodek.next.prev = nodek.prev;
	}

	// Xóa phần tử đầu
	public void DeleteFirst() {
		if (head == null)
			return;
		head = head.next;
		if (head == null)
			tail = null;
	}

	// Xóa phần tử trước phần tử k
	public void DeleteFirstk(int k) {
		Node node = new Node(k);
		this.DeleteFirstk(node);
	}

	public void DeleteFirstk(Node node) {
		if (head == null)
			return;
		if (head.Data == node.Data)
			return;
		if (head.next.Data == node.Data) {
			this.DeleteFirst();
			return;
		}
		Node nodek = this.Find(node);
		nodek.prev.prev.next = nodek;
		nodek.prev = nodek.prev.prev;
	}

     // dk check
	public void DeleteAfter() {
		if (head == null)
			return;
		if (head.next == null) {
			this.DeleteFirst();
			return;
		}
		tail.prev.next = null;
		tail = tail.prev;
	}

	public void Delete() {
		head = tail = null;
	}

	// xóa phần tử cuối cùng
	public void DeleteAfterk(Node node) {
		Node k = this.Find(node);
		if (k == null) {
			System.out.println("Không tìm thấy khoá k");
			return;
		}
		if (k.next == null) {
			System.out.println("k không có phần tử phía sau.");
			return;
		}
		if (k.next.next == null) {
			this.DeleteAfter();
			return;
		}
		k.next = k.next.next;
		k.next.prev = k;
	}

	public void Print() {

		if (head == null) {
			System.out.println("Danh sách liên kết rỗng, không thể in ra !!!");
			return;
		}

		System.out.println("Danh sách liên kết : ");
		Node now = head;
		while (now != null) {
			now.Print();
			now = now.next;
		}

	}

}
