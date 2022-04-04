package com.vti.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class program {

	public static void main(String[] args) {

		// khai báo 1 danh sách liên kết linkedList có kiểu String

		LinkedList<String> listString = new LinkedList<>();

		// add các phẩn tử vào

		listString.add("Orange");
		listString.add("banana");
		listString.add("mango");
		listString.add("chili");
		
		listString.add(3, "apple");
		
//		listString.addFirst("Cherry");
//		listString.addLast("Apricot");

		// khai báo Iterotor có kiểu dl là String

//		Iterator<String> iterator1 = listString.iterator();
//
//		// hiển thị danh sách các phần tử của linked list
//		// bàng cách sử dụng itorator
//
//		while (iterator1.hasNext()) {
//			System.out.println(iterator1.next() + "\t");
//		}
		
		LinkedList<String> listStrings = new LinkedList<>();
		listStrings.add("Cherry");
		listStrings.add("Aricot");
		
		listString.addAll(listStrings);
		
		ListIterator<String> iterator = listString.listIterator();
		
		System.out.println("Duyệt pt theo chiều từ đầu tới cuối danh sách : ");
		while(iterator.hasNext()) {
			System.out.println(iterator.next() + "\t");
		}
		
		System.out.println("Duyệt pt theo chiều từ cuối lên đầu danh sách :");
		while(iterator.hasPrevious()) {
			System.out.println(iterator.previous() + "\t");
		}
		
	}

}
