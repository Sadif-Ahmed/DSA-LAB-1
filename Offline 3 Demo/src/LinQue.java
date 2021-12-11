
public class LinQue<E> implements Queue<E> {

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
    private node<E> front;
    private node<E> rear;
    private int size;

    public LinQue()
    {
        front=rear=new node<E>(null);
        size=0;
    }
    public LinQue(int size)
    {
        front=rear=new node<E>(null);
        size=0;
    }
    @Override
    public void clear() {
        front=rear=new node<E>(null);
        size=0;

    }

    @Override
    public void enqueue(E it) {
        if(size==0)
        {
            rear.setNext(new node<E>(it,null));
            front.setNext(rear);
        }
        rear.setNext(new node<E>(it,null));
        rear=rear.next();
        size++;
    }

    @Override
    public E dequeue() {
        E temp=null;
        if(size==0)
        {
            System.out.println("The Queue is Empty");
        }
        else
        {
            temp=front.next().value();
            front.setNext(front.next().next());
            if(front.next()==null)
            {
                front=rear;
            }
            size--;
        }
        return temp;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public E frontValue() {
        if(size==0)
        {
            System.out.println("The Queue is Empty");
            return null;
        }
        else {
            return front.next().value();
        }
    }

    @Override
    public E rearValue() {
        if(size==0) {
            return null;
        }
        else
        {
            return rear.value();
        }
    }

    @Override
    public E leaveQueue() {
        if(size==0) {
            System.out.println("The Queue is Empty");
            return null;
        }
        else
        {
            E t=rear.value();
            node temp=front;
            while(temp.next().next()!=null)
            {
                temp=temp.next();
            }
            temp.setNext(null);
            rear=temp;
            size--;
           return t;
        }
    }
}
