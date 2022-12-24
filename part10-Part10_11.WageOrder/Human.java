public class Human implements Comparable<Human> {
    private String name;
    private int wage;

    public Human(String name, int wage) {
        this.name = name;
        this.wage = wage;
    }

    public String getName() {
        return this.name;
    }

    public int getWage() {
        return this.wage;
    }

    @Override
    public int compareTo(Human human) {
        return human.wage - this.wage;
    }

    @Override
    public String toString() {
        return this.name + " " + this.wage;
    }
}