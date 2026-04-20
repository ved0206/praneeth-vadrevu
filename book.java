public class Book {
    private String title;
    private String author;
    private int totalPages;
    private int currentPage;

    public Book(String title, String author, int totalPages) {
        this.title = title;
        this.author = author;
        this.totalPages = totalPages;
        this.currentPage = 0;
    }

    public void readPages(int pages) {
        if (pages > 0) {
            currentPage += pages;

            if (currentPage > totalPages) {
                currentPage = totalPages;
            }
        }
    }

    public double getProgress() {
        return ((double) currentPage / totalPages) * 100;
    }

    public boolean isFinished() {
        return currentPage == totalPages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public String toString() {
        return title + " by " + author +
                " | Page " + currentPage + " of " + totalPages +
                " | Progress: " + String.format("%.2f", getProgress()) + "%";
    }

    public static void main(String[] args) {
        Book book1 = new Book("The Alchemist", "Paulo Coelho", 200);
        Book book2 = new Book("Atomic Habits", "James Clear", 300);

        book1.readPages(50);
        book2.readPages(120);

        System.out.println(book1);
        System.out.println(book2);

        book1.readPages(150);

        System.out.println();
        System.out.println("After finishing book1:");
        System.out.println(book1);

        System.out.println("Is book1 finished? " + book1.isFinished());
        System.out.println("Is book2 finished? " + book2.isFinished());
    }
}