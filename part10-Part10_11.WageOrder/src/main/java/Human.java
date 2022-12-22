public class Human implements Comparable<Human> {
    private String name;
    private int wage;

    public Human(String name, int wage) {
        this.name = name;
        this.wage = wage;
    }

    public String getName() {
        return name;
    }

    public int getWage() {
        return wage;
    }

    @Override
    public String toString() {
        return name + " " + wage;
    }

    @Override
    public int compareTo(Human human) {
        return human.wage - this.wage;
    }
}