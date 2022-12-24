public class Hideout<T> {
    private T hiding;

    public void putIntoHideout(T hiding) {
        this.hiding = hiding;
    }

    public T takeFromHideout() {
        T taken = this.hiding;
        this.hiding = null;
        return taken;
    }

    public boolean isInHideout() {
        return this.hiding != null;
    }
}