import java.util.Scanner;

public class Test {
    static void print(Stack stk)
    {
        int len = stk.length();
        Object[] temp = new Object[stk.length()];

        for (int i = 0; i < len; i++)
            temp[i] = stk.pop();

        System.out.print("<");

        for (int i = 0; i < len; i++)
        {
            System.out.print(temp[i]);
            if (i < len - 1)
                System.out.print(" ");
        }

        System.out.print(">");
        System.out.println();

        for (int i = len - 1; i >= 0; i--)
            stk.push(temp[i]);
    }
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int SSize= inp.nextInt();
        //LinStk stk= new LinStk(SSize);
        ArrStk stk= new ArrStk(SSize);
        for (int i = 0; i < SSize; i++) {
            stk.push(inp.nextInt());
        }
        print(stk);
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
            stk.clear();
            print(stk);
            System.out.println(ret);
        } else if (fn == 2) {
            ret = -1;
            par = inp.nextInt();
            stk.push(par);
            print(stk);
            System.out.println(ret);
        } else if (fn == 3) {
            ret = -1;
            par = inp.nextInt();
            ret=stk.pop();
            print(stk);
            System.out.println(ret);
        }
        else if (fn == 4) {
            ret = -1;
            par = inp.nextInt();
            ret=stk.length();
            print(stk);
            System.out.println(ret);
        }
        else if (fn == 5) {
            ret = -1;
            par = inp.nextInt();
            ret=stk.topValue();
            print(stk);
            System.out.println(ret);
        }
        else if (fn == 6) {
            ret = -1;
            par = inp.nextInt();
            stk.set_direction((int)par);
            print(stk);
            System.out.println(ret);
        }
    }

}
}
