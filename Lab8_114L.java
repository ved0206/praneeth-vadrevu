import java.util.ArrayList;

class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getDetails() {
        return title + " by " + author + " | ISBN: " + isbn + " | Available: " + isAvailable;
    }

    public void checkOut() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been checked out.");
        } else {
            System.out.println(title + " is already checked out.");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println(title + " has been returned.");
    }
}

class Member {
    private String name;
    private String memberId;
    private ArrayList<Book> borrowedBooks;

    Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }

    public void borrowBook(Book b) {
        if (borrowedBooks.size() >= 3) {
            System.out.println(name + " has reached the borrow limit.");
            return;
        }

        if (b.isAvailable()) {
            b.checkOut();
            borrowedBooks.add(b);
        } else {
            System.out.println(b.getTitle() + " is not available.");
        }
    }

    public void returnBook(Book b) {
        if (borrowedBooks.contains(b)) {
            b.returnBook();
            borrowedBooks.remove(b);
        } else {
            System.out.println(name + " did not borrow " + b.getTitle() + ".");
        }
    }

    public void listBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println(name + " has no borrowed books.");
        } else {
            System.out.println(name + "'s borrowed books:");
            for (Book b : borrowedBooks) {
                System.out.println("- " + b.getTitle());
            }
        }
    }
}

class Library {
    private ArrayList<Book> books;

    Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book b) {
        books.add(b);
        System.out.println(b.getTitle() + " has been added to the library.");
    }

    public Book findByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }

        System.out.println("Book not found: " + title);
        return null;
    }

    public void listAvailable() {
        System.out.println("Available books:");
        boolean foundAvailable = false;

        for (Book b : books) {
            if (b.isAvailable()) {
                System.out.println("- " + b.getDetails());
                foundAvailable = true;
            }
        }

        if (!foundAvailable) {
            System.out.println("No books are currently available.");
        }
    }
}

public class Lab8_114L {
    public static void main(String[] args) {
        Library library = new Library();

        Book b1 = new Book("The Alchemist", "Paulo Coelho", "978-0062315007");
        Book b2 = new Book("1984", "George Orwell", "978-0451524935");
        Book b3 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084");
        Book b4 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565");

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);
        library.addBook(b4);

        System.out.println();
        library.listAvailable();

        Member member1 = new Member("Ved", "M001");

        System.out.println();
        member1.borrowBook(b1);
        member1.borrowBook(b2);
        member1.borrowBook(b3);
        member1.borrowBook(b4);

        System.out.println();
        member1.listBorrowedBooks();

        System.out.println();
        library.listAvailable();

        System.out.println();
        member1.returnBook(b2);

        System.out.println();
        member1.listBorrowedBooks();

        System.out.println();
        library.listAvailable();

        System.out.println();
        Book foundBook = library.findByTitle("1984");
        if (foundBook != null) {
            System.out.println("Found book: " + foundBook.getDetails());
        }
    }
}
