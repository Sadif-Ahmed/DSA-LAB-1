package Arraylist;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
@SuppressWarnings("unchecked")
public class ArrL<E> implements List<E> {
    private static final int default_Size = 10;
    private int maxSize;
    private int listSize;
    private int Chunk_size;
    private int curr;
    private E[] arr;

    //Constructors
    ArrL() { this(default_Size); }

    public ArrL(int size) {
        maxSize = size;
        Chunk_size=size;
        listSize = curr = 0;
        arr = (E[])new Object[size]; // Create listArray
    }
    public ArrL(E parr[], int size)
    {
      maxSize= size;
      Chunk_size=size;
      listSize=0;
      curr=0;
      arr = (E[])new Object[size];
      for(int i=0;i< parr.length;i++)
        {
            arr[i]=parr[i];
            listSize++;
        }
    }
    //Dynamically reallocating the whole list when the end is reached
    private void extender()
    {   maxSize=maxSize+Chunk_size;
        E[] temp=arr;
        int tempsize=length();
        arr = (E[])new Object[maxSize];
        listSize=0;
        for(int i=0;i<tempsize;i++)
        {
            arr[i]=temp[i];
            listSize++;
        }

    }

    @Override
    public int size() {
        return listSize;
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

    public void clear()
    { listSize = curr = 0; } //Putting the index of curr to 0 clears our authority over list materials


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



    public void insert(E obj) {
        if (listSize >= maxSize)
        {
            extender();
        }
        //Shifting from end to current one spot forward
        for (int i=listSize; i>curr; i--)
            arr[i] = arr[i-1];
        arr[curr] = obj;
        listSize++;
    }

    public void append(E obj) {
        if (listSize >= maxSize)
        {
            extender();
        }
        arr[listSize] = obj;
        listSize++;
    }
    public E remove() {
        if ((curr>=listSize)||(curr<0))
            return null;
        //Out of Bound removal attempt
        E temp = arr[curr]; // Storing the to be removed element
        for(int i=curr; i<listSize-1; i++) //Shifting from current to the end one step upwards
            arr[i] = arr[i+1];
        if (curr==listSize-1)
        {
            curr--;
        }

       listSize--;
        return temp;
    }
    public void moveToStart() { curr = 0; }

    public void moveToEnd() { curr = listSize-1; }

    public void prev() { if (curr != 0) curr--; }

    public void next() { if (curr < listSize) curr++; }

    public int length() { return listSize; }

    public int currPos() { return curr; }

    public void moveToPos(int pos) {
        assert (pos>=0) && (pos<=listSize) : "Position out of bound";
        curr = pos;
    }

    public E getValue() {
        assert (curr>=0) && (curr<listSize) :
                "No current element";
        return arr[curr];
    }
    public int Search(E item)
    {
        int res=-1;
        for(int i=0;i<listSize;i++)
        {
            if(arr[i].equals(item))
            {
                res=i;
                return res;
            }
        }
            return res;
    }


}
