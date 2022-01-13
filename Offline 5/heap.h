#include<iostream>
#include<vector>
using namespace std;
class Heap
{
private:
    int * holder;
    int max_size;
    int curr_size;
public :
    Heap(int s)
    {
        holder= new int [s];
        max_size=s;
        curr_size=0;
    }
    Heap(vector <int> &v)
    {
        holder= new int [v.size()];
        max_size=v.size();
        curr_size=0;
        while(!v.empty())
        {
            insert(v.back());
            v.pop_back();
        }
    }
    ~Heap()
    {
        delete [] holder;
    }
    left(int index)
    {
        return holder[2*index+1];
    }
    right(int index)
    {
        return holder[2*index+2];
    }
    parent(int index)
    {
        return holder[(index-1)/2];
    }
    void tickle_up(int index)
    {
            int bottom=holder[index];
            while((index>0)&&(parent(index)<=bottom))
            {
                holder[index]=parent(index);
                index=(index-1)/2;
            }
            holder[index]=bottom;
    }
    void tickle_down(int index)
    {
        int larger;
        int temp=holder[index];
        while(index<curr_size/2)
        {
            larger=(right(index)>=left(index))?2*index+2:2*index+1;
            if(temp>=holder[larger])
                break;
            holder[index]=holder[larger];
            index=larger;
        }
        holder[index]=temp;
    }
    int size()
    {
        return curr_size;
    }
    void insert(int x)
    {
        if(curr_size==max_size)
        {
            cout<<"Heap Full"<<'\n';
        }
        else
        {
            holder[curr_size]=x;
            tickle_up(curr_size++);
        }
    }
    int getMax()
    {
        return holder[0];
    }
    void deleteKey()
    {
        if(curr_size==0)
        {
            cout<<"Empty Heap"<<'\n';
        }
        else
        {
            holder[0]=holder[--curr_size];
            tickle_down(0);
        }

    }
    void print()
    {
        for(int i=0;i<curr_size;i++)
        {
            std::cout<<holder[i]<<" ";
        }
    }
};
void heapsort(vector<int>&v)
{
    Heap temp(v);
   /* temp.print();
    cout<<'\n';
    */
    v.clear();
    int n=temp.size();
    for(int i=0;i<n;i++)
    {
        v.push_back(temp.getMax());
        temp.deleteKey();
    }
}
