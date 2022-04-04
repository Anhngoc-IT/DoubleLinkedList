package com.vti.DoubleLinkedList;

import java.util.Scanner;

public class Menu {


	private Scanner sc;
	private int lc;
	private Node node;
	private int Data, k;
	private DoubleLinkedList doub;

	public Menu() {

		sc = new Scanner(System.in);
		doub = new DoubleLinkedList();
	}

	public void TableMenu() {
		loadmenu();

	}

	public void loadmenu() {

		while (true) {

			System.out.println(
					"=====================================================================================================");
			System.out.println(
					"==============================Xin Moi Lua Chon Tinh Nang=============================================");
			System.out.println(
					"=====                        1 : Thêm danh sách liên kết.                                   ========");
			System.out.println(
					"=====                        2 : In danh sách liên kết.                                     ========");
			System.out.println(
					"=====                        3 : Tìm kiếm k trong danh sách liên kết.                        =======");
			System.out.println(
					"=====                        4 : Thêm danh sách liên kết.                                    =======");
			System.out.println(
					"=====                        5 : Thêm Node vào đầu danh sách liên kết.                        ======");
			System.out.println(
					"=====                        6 : Thêm Node vào trước khóa k trong danh sách liên kết.         ======");
			System.out.println(
					"=====                        7 : Thêm Node vào sau khóa k trong danh sách liên kết.           ======");
			System.out.println(
					"=====================================================================================================");

			lc = sc.nextInt();
			switch (lc) {
			case 0:
				
				break;
			case 1:
				System.out.println("Nhap vào so lượng Node : ");
				int slData = sc.nextInt();
				
				for(int i = 0; i < slData; i++) {
					System.out.println("Nhập vào Data : ");
					Data = sc.nextInt();
					doub.AddFirst(Data);
				}
				
				break;
			case 2 :
				System.out.println("In danh sách liên kết : ");
				doub.Print();
				break;
			case 3 :
				System.out.println("Nhap khoa k cần tim : ");
				Data = sc.nextInt();
				node = doub.Find(Data);
				if(node == null) {
					System.out.println("không tìm thấy Node có chưa khóa : " + Data);
				}else {
					System.out.println("Tìm thấy Node có chưa khóa k : " + node.Data);
				}
				break;

			default:
				break;
			}
		}

	}

}







































































