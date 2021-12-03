public class ArrStk<E> implements Stack<E>{
    private static final int defaultSize = 50;
    private int max; // Maximum size of stack
    private int top; // Index for top Object
    private E [] holder;// Array holding stack
    private int listsize;
    private int dir=1;
    /** Constructors */
    ArrStk() { this(defaultSize); }
    @SuppressWarnings("unchecked") // Generic array allocation
    ArrStk(int size) {
        max = size;
        top = 0;
        listsize=0;
        holder = (E[])new Object[size]; // Create listArray
    }
    public void extender()
    {   max=max+max;
        E[] temp=holder;
        int tempsize=length();
        holder = (E[])new Object[max];
        listsize=0;
        for(int i=0;i<tempsize;i++)
        {
            holder[i]=temp[i];
            listsize++;
        }

    }
    public void rightshifter(E [] store,int stacksize)
    {
        for (int i = stacksize; i < 0; i--)
            store[i]=store[i-1];
    }
    public void leftshifter(E [] store,int stacksize)
    {
        for (int i = 0; i < stacksize; i++)
            store[i]=store[i+1];
    }
    @Override
    public void clear() {
        top=0;
        listsize=0;
    }

    @Override
    public void push(E it) {
        if(dir==1)
        {
            if(listsize+1==max)
            {
                extender();
            }
            holder[top++] = it;
            listsize++;
        }
        else
        {
         if(listsize+1==max)
         {
             extender();
         }
         else
         {
             rightshifter(holder,listsize);
             holder[top]=it;
             listsize++;
         }
        }
    }

    @Override
    public E pop() {
        if(dir==1)
        {
            if(listsize==0)
            {
                return null;
            }
            return holder[--top];
        }
        else
        {
           E temp= holder[top];
           leftshifter(holder,listsize);
           listsize--;
           return temp;
        }
    }

    @Override
    public E topValue() {
       if(dir==1)
       {
           if(listsize==0)
           {
               return null;
           }
           return holder[--top];
       }
       else
       {
           return holder[top];
       }
    }

    @Override
    public int length() {
        return listsize;
    }

    @Override
    public void set_direction(int x) {
        if(listsize!=0)
        {
            this.dir=dir;
        }

    }
}
