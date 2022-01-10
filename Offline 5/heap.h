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
        holder= new int [s+1];
        max_size=s;
        curr_size=0;
    }
    left(int index)
    {
        return holder[2*index];
    }
    right(int index)
    {
        return holder[2*index+1];
    }
    parent(int index)
    {
        return holder[index/2];
    }
    void tickle_up(int index)
    {
        if(index>0)
        {   int bottom=holder[index];
            while((index>1)&&(parent(index)<holder[index]))
            {
              holder[index]=holder[index/2];
              index=index/2;
            }
            holder[index]=bottom;
        }

    }
    void tickle_down(int index)
    {
        int larger;
        int temp=holder[index];
        while(index<curr_size/2)
        {
            larger=(right(index)>left(index))?2*index+1:2*index;
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
         curr_size++;
        holder[curr_size]=x;
        tickle_up(curr_size);
      }
    }
    int getMax()
    {
     return holder[1];
    }
    void deleteKey()
    {
      if(curr_size==0)
        {
            cout<<"Empty Heap"<<'\n';
        }
      else
      {
          holder[1]=holder[curr_size];
          curr_size--;
          tickle_down(1);
      }

          }
};
void heapsort(vector<int>&v)
    {

    }
