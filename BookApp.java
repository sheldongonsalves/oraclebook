import java.util.Scanner;
public class BookApp {



	public static void main(String[] args) {

		int quantity=0;
		String SKU ,title ,author ,description ;
		int result;
		Scanner ac =new Scanner(System.in);

		bookDB book =new bookDB();
		Book book1=new Book();
		System.out.println("Press:\n1.to view a book\n2.update a book\n3.add a book\n4.delete a book");

        result =ac.nextInt();

		switch(result)
		{
		case 1:
		{
			System.out.println("Enter a SKU:");
			SKU =ac.next();
			book1= book.getBookFromDB(SKU);
			System.out.println(book1.getSKU());
			System.out.println(book1.getTitle());
			System.out.println(book1.getAuthor());
			System.out.println(book1.getDescription());
			System.out.println(book1.getPrice());
			break;
		}
		case 2:
		{

			System.out.println("Update a book");
			System.out.println("Enter the title:");
			title=ac.nextLine();
			System.out.println("Enter the SKU:");
			SKU = ac.nextLine();
			book.UpdateBook(title, SKU);
			break;
		}
		case 3:
		{

			System.out.println("Enter a new book:");
			System.out.println("Enter Title:");
			title=ac.nextLine();
			System.out.println("Enter SKU:");
			SKU = ac.nextLine();
			System.out.println("Enter Author:");
			author=ac.nextLine();
			System.out.println("Enter Description:");
			description=ac.nextLine();
			book.InsertBook(title, SKU, author, description);
			break;
		}
		case 4:
		{

			System.out.println("Delete a  book:");
			System.out.println("Enter SKU:");
			SKU = ac.next();
			book.DeleteBook(SKU);
			break;
		}

		}
	}
}
