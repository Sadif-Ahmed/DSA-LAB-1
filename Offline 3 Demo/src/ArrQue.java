public class ArrQue<E> implements Queue<E> {
    private static final int def_size=10;
    private int front;
    private int rear;
    private int max;
    private E[] holder;
    @SuppressWarnings("unchecked")
    ArrQue()
    {
        this(def_size);
    }
    ArrQue(int size)
    {
        max= size+1;
        holder = (E[]) new Object[max];
        rear=0;
        front=1;
    }
    ArrQue(E[] arr,int size)
    {
        max= size+1;
        holder = arr;
        rear=0;
        front=1;
    }
    public void extender()
    {   max=((max-1)*2)+1;
        E[] temp=holder;
        int temp_size=length();
        holder = (E[])new Object[max];
        for(int i=0;i<=temp_size;i++)
        {
            holder[i]=temp[i];
        }
    }
    @Override
    public void clear() {
        rear=0;
        front=1;
    }

    @Override
    public void enqueue(E it) {
        if((rear+2)%max==front)
        {
            System.out.println("The Queue is full");
            extender();
        }
        rear=(rear+1)%max;
        holder[rear]=it;

    }

    @Override
    public E dequeue() {
        E temp=null;
        if(length()==0) {
            System.out.println("The Queue is Empty");

        }
        else
        {
            temp=holder[front];
            front=(front+1)%max;
        }
        return temp;
    }

    @Override
    public int length() {
        return ((rear+max)-front+1)%max;
    }

    @Override
    public E frontValue() {
        E temp=null;
        if(length()==0)
        {
            System.out.println("The Queue is empty");
        }
        else
        {
            temp=holder[front];
        }
        return temp;
    }

    @Override
    public E rearValue() {
        E temp=null;
        if(length()==0)
        {
            System.out.println("The Queue is empty");
        }
        else
        {
            temp=holder[rear];
        }
        return temp;
    }

    @Override
    public E leaveQueue() {
        E temp=null;
        if(length()==0)
        {
            System.out.println("The Queue is Empty");
        }
        else
        {
            temp=holder[rear];
            rear=(rear-1)%max;
        }
        return temp;
    }
}
