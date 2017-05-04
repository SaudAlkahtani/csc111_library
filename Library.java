import java.util.Scanner;

public class Library {
	private Book[] libraryBooks;
	private int numOfBooks;
	public static final int MAX_SIZE = 100;

	public Library() {
		libraryBooks = new Book[MAX_SIZE];
		numOfBooks = 0;
	}

	public Library(int Size) {
		libraryBooks = new Book[Size];
		numOfBooks = 0;
	}

	public boolean addBook(int ISBN, String author, String title, String genre, int edition, String publisher) {

		if (numOfBooks < libraryBooks.length && findBook(ISBN) == -1 && Book.verifyISBN(ISBN)) {
			libraryBooks[numOfBooks] = new Book();
			libraryBooks[numOfBooks].setISBN(ISBN);
			libraryBooks[numOfBooks].setAuthor(author);
			libraryBooks[numOfBooks].setTitle(title);
			libraryBooks[numOfBooks].setGenre(genre);
			libraryBooks[numOfBooks].setEdition(edition);
			libraryBooks[numOfBooks].setPublisher(publisher);
			numOfBooks++;
			return true;
		}
		return false;

	}

	public int findBook(int iSBN) {
		for (int i = 0; i < numOfBooks; i++)
			if (libraryBooks[i].getISBN() == iSBN)
				return i;
		return -1;
	}

	public boolean deleteBook(int is) {
		for (int i = 0; i <= numOfBooks; i++)
			if (libraryBooks[i].getISBN() == is) {
				libraryBooks[i] = libraryBooks[numOfBooks];
				libraryBooks[numOfBooks--] = null;
				return true;
			}
		return false;
	}

	public void printAll() {
		for (int i = 0; i < numOfBooks; i++) {
			if (numOfBooks == 0)
				System.out.println();
			else
				System.out.println(libraryBooks[i].PrintBookInfo());
		}
	}

	public void printGenre(String g) {
		for (int i = 0; i < numOfBooks; i++)
			if (libraryBooks[i].getGenre().equals(g))
				System.out.println(libraryBooks[i].PrintBookInfo());
	}

	public int getNumberOfBooksByAuthor(String author) {
		int booksByAuthor = 0;
		for (int i = 0; i < numOfBooks; i++)
			if (libraryBooks[i].getAuthor().equalsIgnoreCase(author)) {
				booksByAuthor++;
				return booksByAuthor;
			}
		return 0;

	}

	public int getNumberofBooks() {
		return numOfBooks;
	}

	public void printBookBaseOnEdition(int e) {
		for (int i = 0; i < numOfBooks; i++)
			if (libraryBooks[i].getEdition() == e)
				System.out.println(libraryBooks[i].PrintBookInfo());
	}

	public static void main(String[] args) {
		int answer = 0;
		Scanner input = new Scanner(System.in);
		Library b1 = new Library();
		do {
			System.out.println("**********************************************************************");
			System.out.println("");
			System.out.println("                   Welcome to KSU Library :) ");
			System.out.println("*                 ---------------------------");
			System.out.println("*        Please enter one of the following options: ");
			System.out.println("*         1) Add a book ");
			System.out.println("*         2) Delete a book");
			System.out.println("*         3) Find a book");
			System.out.println("*         4) List all books");
			System.out.println("*         5) List books for a given genre ");
			System.out.println("*         6) Number of books for a given author");
			System.out.println("*         7) Total number of books");
			System.out.println("*         8) List books for a given edition ");
			System.out.println("*         9) Exit ");
			System.out.println("*");
			System.out.println("**********************************************************************");

			System.out.print("Enter your option:> ");
			answer = input.nextInt();
			if (answer == 1) {
				System.out.print("Please enter the book details #ISBN, author, title,genre,publisher and \n edition :");

				int isbn, edition;
				String author, title, genre, publisher;
				isbn = input.nextInt();
				author = input.next();
				title = input.next();
				genre = input.next();
				publisher = input.next();
				edition = input.nextInt();
				Book book1 = new Book(isbn, author, title, genre, edition, publisher);

				if (b1.addBook(book1.getISBN(), book1.getAuthor(), book1.getTitle(), book1.getGenre(),
						book1.getEdition(), book1.getPublisher()))
					System.out.println("The book has been added.");
				else
					System.out.println("The book already exists.");
			} else if (answer == 2) {
				System.out.print("Enter ISBN:");
				int isbn = input.nextInt();
				if (b1.deleteBook(isbn))
					System.out.println("The book has been deleted.");
				else
					System.out.println("The book has not been deleted");
			} else if (answer == 3) {
				System.out.print("Enter ISBN");
			int isbn = input.nextInt();
			System.out.println(b1.findBook(isbn)); 
			}
			else if (answer==4) {
				b1.printAll();
			}
			else if (answer==5) {
				System.out.print("Enter genre: ");
				String g = input.next();
				b1.printGenre(g);
			}
			else if (answer==6) {
				System.out.print("Enter author:");
				String a = input.next();
				System.out.println(b1.getNumberOfBooksByAuthor(a));
			}
			else if (answer==7) {
				System.out.println(b1.getNumberofBooks());
			}
			else if (answer==8) {
				System.out.print("Enter edition: ");
				int e = input.nextInt();
			    b1.printBookBaseOnEdition(e);
			}
				

		} while (answer != 9);
		
		System.out.println("Thanks. Goodbye!");
	}
}