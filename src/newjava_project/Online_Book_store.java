package newjava_project;

import java.util.Scanner;

class Book
{
	public int id;
	public String name;
	public int price;
	
}

class BookShop
{
	public Book bookList[];
	public int front;
	public int rear;
	Scanner sc;
	public BookShop()
	{
		bookList = new Book[10];
		front = 0;
		rear = -1;
		sc = new Scanner(System.in);
	}
	
	public void addNewBook()
	{
		
		if(rear == 9)
		{
			return;
		}
		rear++;
		bookList[rear] = new Book();
		
		System.out.println("\n\n:::: Please Enter Book Data :::: ");
		System.out.println("Enter book id : ");
		bookList[rear].id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter Book Name : ");
		bookList[rear].name = sc.nextLine();
		
		System.out.println("Enter price : ");
		bookList[rear].price  = sc.nextInt();
		sc.nextLine();
		
	}
	
	public int bookAvaliable(int id)
	{
		for(int i = 0; i <= rear; i++)
		{
			if(bookList[i].id == id)
			{
				return i;
			}
		}
		return -1;
	}
	
	public void removeBook(int id)
	{
		int i = id;
		for(i = id; i < rear; i++)
		{
			bookList[i] = bookList[i+1];
		}
		rear--;
	}
	public void buyBook()
	{
		System.out.println("Enter book id : ");
		int id = sc.nextInt();
		
		int aval = bookAvaliable(id);
		if(aval != -1)
		{
			System.out.println("\n\nBook has been successfully purchased");
			System.out.println("\nName: " + bookList[aval].name + "\n" + "Price : " + bookList[aval].price + "\n");
			removeBook(aval);
		}
		else
		{
			System.out.println("No such book is avaliable in the list");
		}
	}
	
	
	public void displayBookList()
	{
		if(rear == -1)
		{
			System.out.println("\nNo books avaliable");
			return;
		}
		System.out.println("\n\nHere is list of all books available\n\n");
		System.out.println("Id | Name | Price ");
		for(int i = 0; i <= rear; i++)
		{
			System.out.print(bookList[i].id + "   " + bookList[i].name + "  " + bookList[i].price + "\n");
		}
		System.out.println();
	}
	
}
public class Online_Book_store {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		BookShop shop = new BookShop();
		
		while(choice != 4)
		{
			System.out.println("\n1.Add New Book\n2.Buy a Book\n3.Display Book List\n4.Exit");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1: shop.addNewBook();
					break;
					
			case 2 : shop.buyBook();
					 break;
					 
			case 3 : shop.displayBookList();
					 break;
					 
			case 4 : System.out.println("Have a nice day!!!");
					 break;
			default: System.out.println("Invalid choice");
			}
		}

	}

}

