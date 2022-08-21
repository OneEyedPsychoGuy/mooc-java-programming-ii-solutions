public class Main {
    public static void main(String[] args) {
        Box bigBox = new Box(20);
        Box bookBox = new Box(10);
        Box cdBox = new Box(5);

        bookBox.add(new Book("Fyodor Dostoevsky", "Crime and Punishment", 2)) ;
        bookBox.add(new Book("Robert Martin", "Clean Code", 1));
        bookBox.add(new Book("Kent Beck", "Test Driven Development", 0.7));
    
        cdBox.add(new CD("Pink Floyd", "Dark Side of the Moon", 1973));
        cdBox.add(new CD("Wigwam", "Nuclear Nightclub", 1975));
        cdBox.add(new CD("Rendezvous Park", "Closer to Being Here", 2012));

        bigBox.add(bookBox);
        bigBox.add(cdBox);
    
        System.out.println("Book Box: " + bookBox);
        System.out.println("CD Box: " + cdBox);
        System.out.println("Big Box: " + bigBox);

        //Attempting to add bigBox to itself
        bigBox.add(bigBox);
        System.out.println(bigBox);
    }
}