import java.util.Scanner;
import Linklist.LinList;
import Arraylist.ArrL;


public class TNL {
    static void print(ArrL list) {
        int temp=list.currPos();
        list.moveToStart();
        for(int i=0;i<list.length();i++)
        {
            if(list.getValue().equals(1)||list.getValue().equals(2)||list.getValue().equals(3))
            {
                System.out.print(i);
            }
            if(i<list.length()-1)
            {
                System.out.print(",");
            }
            list.next();
        }
        System.out.println();
        list.moveToStart();
        for(int i=0;i<list.length();i++) {
            if (list.getValue().equals(2) || list.getValue().equals(3)) {
                System.out.print(i);
            }
            if (i < list.length() - 1) {
                System.out.print(",");
            }
            list.next();
        }
            System.out.println();
            list.moveToStart();

            for (int i = 0; i < list.length(); i++)
            {
                if (list.getValue().equals(3)) {
                    System.out.print(i);
                }
                if (i < list.length() - 1) {
                    System.out.print(",");
                }
                list.next();
            }
            list.moveToPos(temp);
        }

    static void print(LinList list) {

        int temp=list.currPos();
        list.moveToStart();
        for(int i=0;i<list.length();i++)
        {
            if(list.getValue().equals(1)||list.getValue().equals(2)||list.getValue().equals(3))
            {
                System.out.print(i);
            }
            if(i<list.length()-1)
            {
                System.out.print(",");
            }
            list.next();
        }
        System.out.println();
        list.moveToStart();
        for(int i=0;i<list.length();i++) {
            if (list.getValue().equals(2) || list.getValue().equals(3)) {
                System.out.print(i);
            }
            if (i < list.length() - 1) {
                System.out.print(",");
            }
            list.next();
        }
        System.out.println();
        list.moveToStart();

        for (int i = 0; i < list.length(); i++)
        {
            if (list.getValue().equals(3)) {
                System.out.print(i);
            }
            if (i < list.length() - 1) {
                System.out.print(",");
            }
            list.next();
        }
        list.moveToPos(temp);
    }    public static void main(String[] args) {
        int K,L,M;
        Scanner inp = new Scanner(System.in);
        K=inp.nextInt();
        L=inp.nextInt();
       int [] BL  = new int[L];

        for(int i=0;i<L;i++)
        {
            BL[i]=inp.nextInt();
        }
        M=inp.nextInt();
        int [] TL = new int[M];
        for(int i=0;i<M;i++)
        {
            TL[i]=inp.nextInt();
        }
       // ArrL Store = new ArrL(K);
        LinList Store= new LinList(K);
        for(int i=0;i<K;i++)
        {  int temp=1;
            for(int j=0;j<L;j++)
            {
                if(i==BL[j])
                {
                    temp++;
                }
            }
            for(int k=0;k<M;k++)
            {
                if(i==TL[k])
                {
                    temp++;
                }
            }
            Store.append(temp);
            Store.next();
        }

        while(inp.hasNext())
        {
           int task=0;
           task=inp.nextInt();
           if(task==0)
           {
               System.exit(0);
           }
           if(task==1)
           {
               print(Store);
               Store.moveToStart();
           }
        }



    }
}
