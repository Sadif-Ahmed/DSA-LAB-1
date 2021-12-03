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

        LinStk<DishWasher> Dish_Stack = new LinStk<>();
        LinStk<Integer> Done_Time = new LinStk<>();
        LinStk<Integer> Full_Course = new LinStk<>();

        DishWasher Dish;
        Dish=input();
        Dish_Stack.push(Dish);
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
            Dish_Stack.pop();
            Dish=input();
            Dish_Stack.push(Dish);
            if(Dish_Stack.topValue().getCourse_tag()==x)
            {
                Full_Course.push(Dish_Stack.topValue().getInvite_id());
            }
            if(Dish_Stack.topValue().getInvite_id()==0)
            {
                int [] cleaning_times= new int[Done_Time.length()];
                System.out.println(Done_Time.length());
                System.out.println("");
                if(Full_Course.length()!=0)
                {
                    System.out.println("Y");
                    System.out.println(Full_Course.length());
                    if(Full_Course.length()!=1) {
                        for (int i = 0; i < Full_Course.length() - 1; i++) {
                            System.out.print(Full_Course.pop() + " , ");
                        }
                    }
                    System.out.println(Full_Course.pop());
                }
                break;
            }

        }
    }
}
