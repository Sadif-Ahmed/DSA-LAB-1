
public class LinStk<E> implements Stack<E> {
    class node<E> {
        private E value; // Value for this node
        private node<E> nxt; // Pointer to next node in list
        // Constructors
        node(E it, node<E> nxtval)
        { value = it; nxt = nxtval; }
        node(node<E> nxtval) { nxt = nxtval; }
        node<E> next() { return nxt; } // Return next field
        node<E> setNext(node<E> nxtval) // Set next field
        { return nxt = nxtval; } // Return element field
        E value() { return value; } // Set element field
        E setvalue(E it) { return value = it; }
    }
    private node<E> top;
    private int size;
    public LinStk() { top = null; size = 0; }
    public LinStk(int size) { top = null; size = 0; }
    @Override
    public void clear() {
        top=null;
        size=0;

    }

    @Override
    public E pop() {
        if(size==0)
        {
            return null;
        }
        else {
            E temp = top.value();
            top = top.next();
            size--;
            return temp;
        }
    }

    @Override
    public E topValue() {
        assert top != null : "Stack is empty";
        return top.value();
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public void set_direction(int x) {
    }

    @Override
    public void push(Object item) {
        top= new node<E>((E) item,top);
        size++;
    }
}
