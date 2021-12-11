import java.util.Queue;
import java.util.Scanner;

public class Test {
        static void print(LinQue Qu)
        {
            int len = Qu.length();
            Object[] temp = new Object[Qu.length()];

            for (int i = 0; i < len; i++) {
                temp[i] = Qu.dequeue();
            }

            System.out.print("<");

            for (int i = 0; i <len; i++)
            {
                System.out.print(temp[i]+" ");
                if (i < len - 1)
                    System.out.print(" ");
            }

            System.out.print(">");
            System.out.println();

            for (int i = 0; i < len; i++)
                Qu.enqueue(temp[i]);
        }
    static void print(ArrQue Qu)
    {
        int len = Qu.length();
        Object[] temp = new Object[Qu.length()];

        for (int i = 0; i < len; i++) {
            temp[i] = Qu.dequeue();
        }

        System.out.print("<");

        for (int i = 0; i <len; i++)
        {
            System.out.print(temp[i]+" ");
            if (i < len - 1)
                System.out.print(" ");
        }

        System.out.print(">");
        System.out.println();

        for (int i = 0; i < len; i++)
            Qu.enqueue(temp[i]);
    }
        public static void main(String[] args) {
            Scanner inp = new Scanner(System.in);
            int SSize= inp.nextInt();
           // LinQue Que= new LinQue(SSize);
            ArrQue Que = new ArrQue(SSize);
            for (int i = 0; i < SSize; i++) {
                Que.enqueue(inp.nextInt());
            }
            print(Que);
            int fn;
            Object par, ret;
            while (inp.hasNext())

            {

                fn = inp.nextInt();
                if (fn == 0)
                    System.exit(0);
                else if (fn == 1) {
                    ret = -1;
                    par = inp.nextInt();
                    Que.clear();
                    print(Que);
                    System.out.println(ret);
                } else if (fn == 2) {
                    ret = -1;
                    par = inp.nextInt();
                    Que.enqueue(par);
                    print(Que);
                    System.out.println(ret);
                } else if (fn == 3) {
                    ret = -1;
                    par = inp.nextInt();
                    ret=Que.dequeue();
                    print(Que);
                    System.out.println(ret);
                }
                else if (fn == 4) {
                    ret = -1;
                    par = inp.nextInt();
                    ret=Que.length();
                    print(Que);
                    System.out.println(ret);
                }
                else if (fn == 5) {
                    ret = -1;
                    par = inp.nextInt();
                    ret=Que.frontValue();
                    print(Que);
                    System.out.println(ret);
                }
                else if (fn == 6) {
                    ret = -1;
                    par = inp.nextInt();
                    ret=Que.rearValue();
                    print(Que);
                    System.out.println(ret);
                }
                else if(fn==7)
                {
                    ret=-1;
                    par = inp.nextInt();
                    ret=Que.leaveQueue();
                    print(Que);
                    System.out.println(ret);
                }

            }

        }

}
