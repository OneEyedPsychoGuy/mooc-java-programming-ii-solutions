public class Cat extends Animal {
    public Cat() {
        super("Cat");
    }

    public Cat(String name) {
        super(name);
    }

    public void purr() {
        System.out.println(this.getName() + " purrs");
    }
}