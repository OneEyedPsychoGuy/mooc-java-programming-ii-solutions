public class Book {
    private String title;
    private int recommendedAge;

    public Book(String title, int recommendedAge) {
        this.title = title;
        this.recommendedAge = recommendedAge;
    }

    public String getTitle() {
        return this.title;
    }

    public int getRecommnededAge() {
        return this.recommendedAge;
    }

    @Override
    public String toString() {
        return this.title + " (recommended for " + this.recommendedAge + " year-olds or older)";
    }
}