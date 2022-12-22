import java.util.List;
import java.util.ArrayList;

public class Herd implements Movable {
    private List<Movable> movables;

    public Herd() {
        this.movables = new ArrayList<>();
    }

    public void addToHerd(Movable movable) {
        this.movables.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        this.movables.forEach((movable) -> movable.move(dx, dy));
    }

    @Override
    public String toString() {
        String string = "";
        for(Movable movable : this.movables) {
            string += movable.toString() + "\n";
        }
        return string;
    }
}