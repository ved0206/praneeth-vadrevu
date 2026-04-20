public class Movie {
    private String title;
    private int[] ratings;
    private int ratingCount;

    public Movie(String title) {
        this.title = title;
        this.ratings = new int[10];
        this.ratingCount = 0;
    }

    public void addRating(int rating) {
        if (rating < 1 || rating > 5) {
            System.out.println("Invalid rating. Rating must be between 1 and 5.");
            return;
        }

        if (ratingCount >= ratings.length) {
            System.out.println("Cannot add rating. The ratings list is full.");
            return;
        }

        ratings[ratingCount] = rating;
        ratingCount++;
    }

    public double getAverageRating() {
        if (ratingCount == 0) {
            return 0.0;
        }

        int total = 0;

        for (int i = 0; i < ratingCount; i++) {
            total += ratings[i];
        }

        return (double) total / ratingCount;
    }

    public int getHighestRating() {
        if (ratingCount == 0) {
            return 0;
        }

        int highest = ratings[0];

        for (int i = 1; i < ratingCount; i++) {
            if (ratings[i] > highest) {
                highest = ratings[i];
            }
        }

        return highest;
    }

    public String toString() {
        return title +
                " | Average Rating: " + String.format("%.2f", getAverageRating()) +
                " | Highest Rating: " + getHighestRating();
    }

    public static void main(String[] args) {
        Movie movie1 = new Movie("Inception");
        Movie movie2 = new Movie("Interstellar");

        movie1.addRating(5);
        movie1.addRating(4);
        movie1.addRating(5);
        movie1.addRating(6);

        movie2.addRating(3);
        movie2.addRating(4);
        movie2.addRating(2);
        movie2.addRating(0);

        System.out.println(movie1);
        System.out.println(movie2);

        System.out.println();
        System.out.println("Average rating for " + movie1.title + ": " + movie1.getAverageRating());
        System.out.println("Highest rating for " + movie1.title + ": " + movie1.getHighestRating());

        System.out.println("Average rating for " + movie2.title + ": " + movie2.getAverageRating());
        System.out.println("Highest rating for " + movie2.title + ": " + movie2.getHighestRating());
    }
}