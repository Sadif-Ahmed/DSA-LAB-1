import java.util.Arrays;

public class ArrStk<E> implements Stack<E>{

    private int max;
    private int tos;
    private E[] holder;
    private int dir;

    ArrStk(){
        tos =0;
        dir =1;
    }

    ArrStk(E[] arr) {
        holder = Arrays.copyOf(arr, arr.length+1);
        max = arr.length;
        tos = arr.length;
    }

    ArrStk(int size){
        holder =  (E[])new Object[size];
        max = size;
        tos = 0;
        dir =1;
    }

    public void clear(){
        tos =0;
    }


    @Override
    public void push(E x) {

        if(dir==1){
            if(tos==max){
                E[] temp = (E[])new Object[max*2];
                max=max*2;
                for (int i = 0; i < tos; i++) {
                    temp[i]=holder[i];
                }
                temp[tos]=x;
                holder=temp;
            }
            holder[tos]=x;
            tos++;
        }
        if(dir==-1){

            if(tos==-1){

                int prev_maxSize= max;
                E[] temp = (E[])new Object[max*2];
                max = max*2;
                int curr_maxSize=max;

                for (int i = curr_maxSize-1,j=prev_maxSize-1; j >tos ; i--,j--) {
                    temp[i]=holder[j];
                }
                tos = max-prev_maxSize-1;

                temp[tos]=x;

                holder =temp;
            }

            holder[tos]=x;

            tos--;
        }

    }

    @Override
    public E pop() {
        if(dir ==1){
            if(tos <1){
                System.out.println("The list is Empty");
                return null;
            }
            return holder[--tos];
        }

        else{
            if(tos +1> max){
                System.out.println("The list is empty");
                return null;
            }
            return holder[++tos];
        }

    }

    @Override
    public int length() {
        if(dir ==1)
            return tos;
        else
            return max - tos -1;
    }

    @Override
    public void set_direction(int x) {
        if(dir==-1 || dir==1){
            this.dir =dir;
            if(dir==-1)
                tos = max -1;
        }
        else
            return;

    }

    @Override
    public E topValue() {

        return holder[tos -1];
    }

}
