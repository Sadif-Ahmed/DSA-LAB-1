import java.util.Scanner;

public class DishWasher {
    private int invite_id;
    private int push_time;
    private int course_tag;
    DishWasher(int k,int t,int s)
    {
        invite_id=k;
        push_time=t;
        course_tag=s;
    }
    DishWasher()
    {

    }


    public int getInvite_id() {
        return invite_id;
    }

    public void setInvite_id(int invite_id) {
        this.invite_id = invite_id;
    }

    public int getPush_time() {
        return push_time;
    }

    public void setPush_time(int push_time) {
        this.push_time = push_time;
    }

    public int getCourse_tag() {
        return course_tag;
    }

    public void setCourse_tag(int course_tag) {
        this.course_tag = course_tag;
    }

    @Override
    public String toString() {
        return "DishWasher{" +
                "invite_id=" + invite_id +
                ", push_time=" + push_time +
                ", course_tag=" + course_tag +
                '}';
    }

}
class Implementations{
    static DishWasher input()
    {   Scanner inp = new Scanner(System.in);
        int k,t,s;
        k=inp.nextInt();
        t=inp.nextInt();
        s=inp.nextInt();
        DishWasher temp_dish = new DishWasher(k,t,s);
        return temp_dish;
    }
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n,x;
        n=inp.nextInt();
        x=inp.nextInt();
        int [] course_times=new int[x];
        for(int i=0;i<x;i++)
        {
            course_times[i]=inp.nextInt();
        }
        int timer=-1;
        int temp_time;
/*
        LinStk<DishWasher> Dish_Stack = new LinStk<>();
        LinStk<Integer> Done_Time = new LinStk<>();
        LinStk<Integer> Full_Course = new LinStk<>();
 */
        ArrStk<DishWasher> Dish_Stack = new ArrStk<>(10);
        ArrStk<Integer> Done_Time = new ArrStk<>(10);
        ArrStk<Integer> Full_Course = new ArrStk<>(10);

        DishWasher Dish;
        Dish=input();
        Dish_Stack.push(Dish);

        while(true)
        {
            temp_time=Dish_Stack.topValue().getPush_time();
            if(Dish_Stack.topValue().getCourse_tag()==x)
            {
                Full_Course.push(Dish_Stack.topValue().getInvite_id());
            }
            if(timer==temp_time){
                while(Dish_Stack.length()>0)
                {
                    temp_time=Dish_Stack.topValue().getPush_time();
                    if(timer==temp_time)
                    {
                        timer=Dish_Stack.topValue().getPush_time();
                        timer+=course_times[Dish_Stack.topValue().getCourse_tag()-1];
                        Dish_Stack.pop();
                        Done_Time.push(timer);
                    }
                    else if(timer<temp_time)
                    {
                        timer=Dish_Stack.topValue().getPush_time();
                        timer+=(course_times[Dish_Stack.topValue().getCourse_tag()-1]-1);
                        Dish_Stack.pop();
                        Done_Time.push(timer);
                    }
                    else
                    {
                        timer+=course_times[Dish_Stack.topValue().getCourse_tag()-1];
                        Dish_Stack.pop();
                        Done_Time.push(timer);
                    }
                }
            }
            else if(timer<temp_time)
            {
                while(Dish_Stack.length()>0)
                {
                    timer=Dish_Stack.topValue().getPush_time();
                    timer+=(course_times[Dish_Stack.topValue().getCourse_tag()-1]-1);
                    Dish_Stack.pop();
                    Done_Time.push(timer);
                }
            }
            else if(timer>temp_time)
            {
                Dish=input();
                Dish_Stack.push(Dish);
                if(Dish_Stack.topValue().getCourse_tag()==x)
                {
                    Full_Course.push(Dish_Stack.topValue().getInvite_id());
                }
                continue;
            }
            Dish=input();
            Dish_Stack.push(Dish);
            if(Dish_Stack.topValue().getCourse_tag()==x)
            {
                Full_Course.push(Dish_Stack.topValue().getInvite_id());
            }
            if(Dish_Stack.topValue().getInvite_id()==0)
            {
                int [] cleaning_times= new int[Done_Time.length()];
                int counter=0;
                while(Done_Time.length()>0)
                {
                   cleaning_times[counter++]= Done_Time.pop();
                }
                System.out.println(cleaning_times[0]);
                for(int j=counter-1;j>0;j--)
                {
                    System.out.print(cleaning_times[j]+" , ");
                }
                System.out.print(cleaning_times[0]);
                System.out.println("");

                    int [] arr= new int[Full_Course.length()];
                    int count=0,full_eaters=0;
                    while(Full_Course.length()>0)
                    {
                        arr[count++]= Full_Course.pop();
                    }
                for(int i=0;i<count;i++)
                {   int flag=0;
                    for(int j=i+1;j<count;j++)
                    {
                        if((arr[i]==arr[j])||(arr[i]==0))
                        {
                            flag=1;
                        }
                    }
                    if(flag==0)
                    {
                       full_eaters++;
                    }
                }
                if(full_eaters==n) {
                    System.out.println("Y");
                }
                else
                {
                    System.out.println("N");
                }
                for (int i = 0; i < count; i++) {
                        int flag = 0;
                        for (int j = i + 1; j < count; j++) {
                            if ((arr[i] == arr[j]) || (arr[i] == 0)) {
                                flag = 1;
                            }
                        }
                        if (flag == 0) {
                            System.out.print(arr[i] + ",");
                        }
                    }
                    System.out.print("\b");
                          break;
                    }


            }

        }
    }

