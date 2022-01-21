

import java.io.*;
import java.util.*;

public class Snakes_Ladders {
    class Node_Manager
    {
        int vertice;
        int distance;
        int [] parent;
        Node_Manager(int n)
        {
            parent= new int[n];
        }
        int getVertice()
        {
            return vertice;
        }
        int getDistance()
        {
            return distance;
        }
        int getParent(int x)
        {
            return parent[x];
        }
        void setVertice(int vertice)
        {
            this.vertice = vertice;
        }
        void setDistance(int distance)
        {
            this.distance=distance;
        }
        void setParent(int vertice,int index) {
            this.parent[index] = vertice;
        }
    }
    int [] move_holder;
    int [] visited_holder;
    int dice;
    Node_Manager temp;
    int result=0;

    Snakes_Ladders(int [] moves, int dice)
    {
        move_holder= Arrays.copyOf(moves,moves.length+1);
        visited_holder= new int[moves.length+1];
        this.dice=dice;
        temp= new Node_Manager(moves.length+1);
    }
    int min_throws(int[] moves,int size)
    {
        Node_Manager tmp= new Node_Manager(size);
        Queue<Node_Manager> holder = new LinkedList<>();
        int node;
        tmp.setVertice(1);
        tmp.setParent(-1,1);
        tmp.setDistance(0);
        holder.add(tmp);
        visited_holder[1]=1;
        while(holder.size()!=0)
        {
            tmp=holder.remove();
            node=tmp.getVertice();
            if(node==size-1)
            {
                result=tmp.getDistance();
            }
            for(int i=node+1;(i<= node+dice)&&(i<size);++i)
            {
                if(visited_holder[i]==0)
                {
                    Node_Manager visit = new Node_Manager(size);
                    visited_holder[i]=1;
                    visit.setDistance(tmp.getDistance()+1);
                    if(moves[i]!=-1)
                    {
                        temp.setParent(node,i);
                        visit.setVertice(moves[i]);
                        visited_holder[moves[i]]=1;
                        temp.setParent(i,moves[i]);
                    }
                    else if(temp.getParent(i)==0)
                    {
                        temp.setParent(node,i);
                        visit.setVertice(i);
                    }
                    holder.add(visit);
                }
            }

        }
        if(visited_holder[size-1]==0)
        {
           result=-1;
        }
        return result;
    }
    Stack path_sequence(int size)
    {
        Stack<Integer> Back_track = new Stack<>();
        if(visited_holder[size-1]!=0) {
            Back_track.push(size - 1);
            for (int i = size - 1; i != 1; ) {
                Back_track.push(temp.getParent(i));
                i = temp.getParent(i);
            }
        }
            return Back_track;
    }
    Queue Reachable_Vertices(int size)
    {
         Queue<Integer> Unreachables = new LinkedList<>();
            for(int i=1;i<size;i++)
            {
                if(visited_holder[i]==0)
                {
                    Unreachables.add(i);
                }
            }
       return Unreachables;
    }

    public static void main(String[] args) throws IOException {
        File obj = new File("C:\\Users\\ahmed\\Desktop\\Offline 6\\input.txt");
        FileWriter writer = new FileWriter("C:\\Users\\ahmed\\Desktop\\Offline 6\\output.txt");
        Scanner reader = new Scanner(obj);
        int test = Integer.parseInt(reader.nextLine());

        while(test!=0){
            String x = reader.nextLine();
            String[] s = x.split(" ");
            int N = Integer.parseInt(s[1]) +1;

            int[] moves = new int[N];
            for (int i = 1; i < N; i++)
                moves[i] = -1;
            int dice = Integer.parseInt(s[0]);
            int ladders = Integer.parseInt(reader.nextLine());
            for (int i = 0; i < ladders; i++) {
                String data = reader.nextLine();

                String[] str = data.split(" ");
                moves[Integer.parseInt(str[0])] = Integer.parseInt(str[1]);
            }
            int snakes = Integer.parseInt(reader.nextLine());
            for (int i = 0; i < snakes; i++) {
                String data = reader.nextLine();

                String[] str = data.split(" ");
                moves[Integer.parseInt(str[0])] = Integer.parseInt(str[1]);
            }
            Snakes_Ladders match= new Snakes_Ladders(moves,dice);
            Stack<Integer> Sequence_result;
            Queue<Integer> Unreachables;
            int Minimum_Throws=match.min_throws(moves, N);
            Sequence_result= match.path_sequence(N);
            Unreachables=match.Reachable_Vertices(N);
            writer.write("Minimum Dice Throws Required To Reach The Goal Is:  ");
            writer.write(""+Minimum_Throws);
            writer.write("\n");
            if(Sequence_result.size()!=0)
            {
              writer.write(""+Sequence_result.pop());


                while(Sequence_result.size()!=0)
                {
                    writer.write(" -> "+Sequence_result.pop());
                }
                writer.write("\n");
            }
            else
            {
                writer.write("No Solution");
                writer.write("\n");
            }
            if(Unreachables.size()!=0)
            {
                writer.write("Unreachable Vertices: ");
                while(Unreachables.size()!=0)
                {
                    writer.write(Unreachables.remove() + " ");

                }
            }
            else
            {
                writer.write("All Reachable");
            }
            writer.write("\n");
            writer.write("\n");
            test--;
        }
        reader.close();
        writer.close();

    }
}
