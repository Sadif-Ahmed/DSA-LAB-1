package Linklist;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@SuppressWarnings("unchecked")
public class LinList<E> implements List<E> {
    private class node<E> {
        private E value;
        private node<E> nxt;
        // Constructors
        node(E it, node<E> nxtval)
        { value = it; nxt = nxtval; }
        node(node<E> nxtval) { nxt = nxtval; }
        node<E> next() { return nxt; }
        node<E> setNext(node<E> nxtval)
        { return nxt = nxtval; }
        E value() { return value; }
        E setvalue(E it) { return value = it; }
    }

    private node<E> head;
    private node<E> tail;
    protected node<E> curr;
    private int size;

   //Constructors
   public LinList(int size) {
        this();
    } //Size is not needed to initialize linked list

    public LinList() {
        curr = tail = head = new node<E>(null); // All in one node for empty linked list
        size = 0;
    }
    public LinList(E parr[], int size)
    {
        this.size=parr.length;
        curr = tail = head = new node<E>(null); // Dummy head
        head.setNext(new node<E>(parr[0], null));//Setting the first element of array as nxt element of head
        curr=head;
        tail=head.next();
        for(int i=1;i< parr.length;i++)
        {
            tail.setNext(new node<E>(parr[i], null));
            tail=tail.next();
        }
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    /**
     * Remove all elements
     */
    public void clear() {
        head.setNext(null);
        curr = tail = head = new node<E>(null); //Recreating all in one node after making the node of previous head null
        size = 0;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    /**
     * Insert "it" at current position
     */
    public void insert(E obj) {
        //Setting the next node of current as the inserting object and setting the next node of the inserting obj as the current obj next

        curr.setNext(new node<E>(obj, curr.next()));
        if (tail == curr) tail = curr.next();// Inserting as new tail
        size++;
    }


    public void append(E obj) {
        tail = tail.setNext(new node<E>(obj, null));
        size++;
    }

    public E remove() {
        if (curr.next() == null)
            return null; // Nothing to remove
       E it = curr.next().value(); // Storing the value of to be removed element
        if ( curr.next() == tail) {
            if(head==curr)
                tail =curr;
            else {
                node<E> temp = head;
                while (temp.next() != curr)
                    temp = temp.next();
                tail = curr;
                curr = temp;
            }
        }                   // Removed last
        else
            curr.setNext(curr.next().next()); // Remove from list
        size--; // Decrement count
        return it; // Return value
    }


    public void moveToStart() {
        curr = head;
    }

    public void moveToEnd() {
        curr = tail;
        prev();

    }

    public void prev() {
        if (curr == head) return; // At start
        node<E> temp = head;
        while (temp.next() != curr) temp = temp.next();//Stopping
        curr = temp;
    }


    public void next() {
        if (curr != tail) curr = curr.next();
    }


    public int length() {
        return size;
    }


    public int currPos() {
        node<E> temp = head;
        int i;
        for (i = 0; curr != temp; i++)
            temp = temp.next();
        if(i>=size)
            i=-1;
        return i;
    }


    public void moveToPos(int pos) {
        assert (pos >= 0) && (pos <= size) : "Position out of range";
        curr = head;
        for (int i = 0; i < pos; i++) curr = curr.next();
    }


    public E getValue() {
        if (curr.next() == null) return null;
        return (E)curr.next().value();
    }
    public int Search(E item)
    {
        int res=-1;
        node temp = head.next();
        for(int i=0;i<size;i++)
        {
            if(temp.value().equals(item))
            {
                return i;
            }
            temp=temp.next();
        }
        return res;
    }
}


