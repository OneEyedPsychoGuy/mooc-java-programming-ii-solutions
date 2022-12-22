public class List<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private E[] elements;
    private int size;

    public List() {
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean contains(E element) {
        return this.indexOf(element) >= 0;
    }

    public E get(int index) {
        if(index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " outiside of [0, " + this.size + "]");
        }

        return this.elements[index];
    }

    public boolean add(E element) {
        if(this.size == this.elements.length) {
            this.grow();
        }

        this.elements[this.size++] = element;
        return true;
    }

    public boolean remove(E element) {
        int index = this.indexOf(element);

        if(index < 0) {
            return false;
        }

        this.size--;
        this.moveToTheLeft(index);
        return true;
    }

    public E remove(int index) {
        if(index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " outiside of [0, " + this.size + "]");
        }

        E removed = this.elements[index];
        this.size--;
        this.moveToTheLeft(index);
        return removed;
    }

    public int indexOf(E e) {
        for(int i = 0; i < this.size; i++) {
            if(e.equals(this.elements[i])) {
                return i;
            }
        }
        return -1;
    }

    private void grow() {
        int newSize = this.elements.length + this.elements.length / 2;
        E[] newElements = (E[]) new Object[newSize];
        
        for(int i = 0; i < this.elements.length; i++) {
            newElements[i] = this.elements[i];
        }

        this.elements = newElements;
    }

    private void moveToTheLeft(int index) {
        for(int i = index; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
    }
}