import java.util.Random;

public class Die {
    private Random random;
    private int sides;

    public Die(int sides) {
        this.random = new Random();
        this.sides = sides;
    }

    public int throwDie() {
        return random.nextInt(this.sides) + 1;
    }
}