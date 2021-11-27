import java.util.Scanner;
import Arraylist.ArrL;
import Linklist.LLOnline;
import Linklist.LinList;
@SuppressWarnings("unchecked")
public class Test {
    static void print(ArrL list) {
        int curr = list.currPos();
        System.out.print("< ");

        for (list.moveToStart(); list.currPos() < list.length(); list.next()) {
            if (curr == list.currPos())
                System.out.print(" | ");
            System.out.print(list.getValue());
            if (list.currPos() < list.length() - 1)
                System.out.print(" ");
        }

        System.out.println(" >");

        if (curr < list.length())
            list.moveToPos(curr);
    }
    static void print(LinList list) {
        int temp= list.currPos();
        System.out.print("< ");
        list.moveToStart();
        for(int i=0;i< list.length();i++)
        {
            if(i==temp)
            {
                System.out.print(" | ");
            }
            System.out.print(" "+list.getValue()+" ");
            list.next();
        }
        System.out.println(" >");
        list.moveToPos(temp);
    }
    static void print(LLOnline list) {
        int temp= list.currPos();
        System.out.print("< ");
        list.moveToStart();
        for(int i=0;i< list.length();i++)
        {
            if(i==temp)
            {
                System.out.print(" | ");
            }
            System.out.print(" "+list.getValue()+" ");
            list.next();
        }
        System.out.println(" >");
        list.moveToPos(temp);
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int ls, ms;
        ls = inp.nextInt();
        ms = inp.nextInt();
        Object[] ab = new Object[ls];
        for (int i = 0; i < ls; i++) {
            ab[i] = inp.nextInt();
        }
        //ArrL list = new ArrL(ab, ms);
       // LinList list = new LinList(ab,ms);
        LLOnline list= new LLOnline(ab,ms);
        print(list);
        int fn;
        Object par, ret;
        while (inp.hasNext()) {

            fn = inp.nextInt();
            if (fn == 0)
                System.exit(0);
            else if (fn == 1) {
                ret = -1;
                par = inp.nextInt();
                list.clear();
                print(list);
                System.out.println(ret);
            } else if (fn == 2) {
                ret = -1;
                par = inp.nextInt();
                list.insert(par);
                print(list);
                System.out.println(ret);
            } else if (fn == 3){
                ret = -1;
            par = inp.nextInt();
            list.append(par);
            print(list);
            System.out.println(ret);
        }
            else if (fn == 4) {
            ret = -1;
            par = inp.nextInt();
            ret = list.remove();
            print(list);
            System.out.println(ret);
        } else if (fn == 5) {
            ret = -1;
            par = inp.nextInt();
            list.moveToStart();
            print(list);
            System.out.println(ret);
        } else if (fn == 6) {
            ret = -1;
            par = inp.nextInt();
            list.moveToEnd();
            print(list);
            System.out.println(ret);
        } else if (fn == 7) {
            ret = -1;
            par = inp.nextInt();
            list.prev();
                print(list);
            System.out.println(ret);
        } else if (fn == 8) {
            ret = -1;
            par = inp.nextInt();
            list.next();
            print(list);
            System.out.println(ret);
        } else if (fn == 9) {
            ret = -1;
            par = inp.nextInt();
            ret = list.length();
            print(list);
            System.out.println(ret);
        } else if (fn == 10) {
            ret = -1;
            par = inp.nextInt();
            ret = list.currPos();
                print(list);
            System.out.println(ret);
        } else if (fn == 11)
        {
            ret = -1;
        par = inp.nextInt();
        list.moveToPos((Integer) par);
            print(list);
        System.out.println(ret);
    }
        else if(fn==12) {
            ret = -1;
            par = inp.nextInt();
            ret = list.getValue();
                print(list);
            System.out.println(ret);
        }
        else if(fn==13) {
            ret = -1;
            par = inp.nextInt();
            ret = list.Search(par);
            print(list);
            System.out.println(ret);
        }




        }
    }

}
