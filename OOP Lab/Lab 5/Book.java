import java.util.Scanner;


class Book {
    private String title;
    private String author;
    private int edition;

    
    public Book(String title, String author, int edition) {
        this.title = title;
        this.author = author;
        this.edition = edition;
    }

   
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    
    public void display() {
        System.out.println("Title: " + title + ", Author: " + author + ", Edition: " + edition);
    }
}


public class BookManager {
    public static void main(String[] args) {
        
        Book[] books = new Book[6];
        books[0] = new Book("Effective Java", "Joshua Bloch", 3);
        books[1] = new Book("Clean Code", "Robert Martin", 1);
        books[2] = new Book("Design Patterns", "Erich Gamma", 1);
        books[3] = new Book("Refactoring", "Martin Fowler", 2);
        books[4] = new Book("Java Concurrency in Practice", "Brian Goetz", 1);
        books[5] = new Book("Introduction to Algorithms", "Thomas H. Cormen", 3);

       
        for (int i = 0; i < books.length - 1; i++) {
            for (int j = 0; j < books.length - i - 1; j++) {
                if (books[j].getTitle().compareTo(books[j + 1].getTitle()) > 0) {
                    // Swap the books
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }

      
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the author's name: ");
        String inputAuthor = scanner.nextLine();
 
        System.out.println("\nBooks by " + inputAuthor + ":");
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(inputAuthor)) {
                book.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found by the author " + inputAuthor);
        }
    }
}
