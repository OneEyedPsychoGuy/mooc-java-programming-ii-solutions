import java.util.Queue;
import java.util.LinkedList;

public class Pipe<T> {
    private Queue<T> pipe;

    public Pipe() {
        this.pipe = new LinkedList<>();
    }

    public void putIntoPipe(T element) {
        this.pipe.add(element);
    }

    public T takeFromPipe() {
        return this.pipe.poll();
    }

    public boolean isInPipe() {
        return !this.pipe.isEmpty();
    }
}