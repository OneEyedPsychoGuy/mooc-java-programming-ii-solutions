public class Hideout<T> {
    private T element;

    public void putIntoHideout(T element) {
        this.element = element;
    }

    public T takeFromHideout() {
        T cur = this.element;
        this.element = null;
        return cur;
    }

    public boolean isInHideout() {
        return this.element != null;
    }
}