package Linklist;

import Arraylist.ArrL;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
@SuppressWarnings("unchecked")
public class LLOnline<E> implements List {
    ArrL values,links;
    int head;
    int tail;
    int current;
    int curr;
    int list_size;

    public LLOnline(int size) {
        this();
    }
    public LLOnline() {
        curr = tail = head = 0;
        values=new ArrL(10);
        links= new ArrL(10);
        list_size = 0;
    }
    public LLOnline(E parr[], int size)
    {
        list_size= 0;
        curr=0;
        values=new ArrL(size);
        links= new ArrL(size);
        for(int i=0;i< parr.length;i++)
        {
            values.append(parr[i]);
            list_size++;
        }
        for(int i=1;i< parr.length-1;i++)
        {
            links.append(i);
        }
        links.append(-1);
        values.moveToStart();
        links.moveToStart();
        head=values.currPos();
        tail= links.Search(-1);
        curr=head;
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
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
        list_size=0;
        values.clear();
        links.clear();
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
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
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
    public void moveToPos(int pos) {
        assert (pos>=0) && (pos<=list_size) : "Position out of bound";
        values.moveToPos(pos);
        links.moveToPos(pos-1);
        curr=pos;
    }
    public void moveToStart() {
        curr = 0;
    values.moveToStart();
    links.moveToStart();
    }

    public void moveToEnd() { curr = list_size-1;
    values.moveToEnd();
    links.moveToPos(curr-1);}

    public void prev() { if (curr != 0) {
        curr--;
        values.prev();
        links.prev();
    }}

    public void next() { if (curr < list_size) {
        curr++;
        values.next();
        links.next();
    }
    }

    public int length() { return list_size; }

    public int currPos() { return curr; }
    public E getValue() {
        assert (curr>=0) && (curr<list_size) :
                "No current element";
        E temp= (E) values.getValue();
        return temp;
    }
    public void append(E obj) {
       values.append(obj);
       list_size++;
       links.clear();
        for(int i=1;i< list_size-1;i++)
        {
            links.append(i);
        }
        links.append(-1);
    }
    public E remove() {
        if ((curr>=list_size)||(curr<0))
            return null;
        //Out of Bound removal attempt
        E temp = (E) values.remove();
        list_size--;// Storing the to be removed element
        links.clear();
        for(int i=1;i< list_size-1;i++)
        {
            links.append(i);
        }
        links.append(-1);
        curr--;
        return temp;
    }
    public void insert(E obj) {
        //Shifting from end to current one spot forward
        values.insert(obj);
        list_size++;
        links.clear();
        for(int i=1;i< list_size-1;i++)
        {
            links.append(i);
        }
        links.append(-1);
    }
    public int Search(E item)
    {

        int temp=values.Search(item);
        int temp_curr=links.currPos();
        int res=-1;

         if(temp!=-1)
         {
             links.moveToPos(temp-1);
             res= links.currPos()-1;

         }
         links.moveToPos(temp_curr);
        return res;
    }

}
