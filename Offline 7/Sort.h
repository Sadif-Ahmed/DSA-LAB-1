#include<iostream>
using namespace std;

void  insertion_sort(int *ar,int n)
{
    int in,out;
    for(out=1; out<n; out++) //out is the dividing line
    {
        double temp=ar[out];//storing the marker
        in=out;//starting shift at out
        while((in>0)&&(ar[in-1]>=temp))//until one is smaller
        {

            ar[in]=ar[in-1];//shift items right
            --in;//go left one position
        }
        ar[in]=temp;//inserting marked item
    }
}
int array_partition(int *ar,int left,int right,int pivot,int pivot_idx)
{
    int leftptr=left-1;
    int rightptr=right;
    while(true)
    {
        while(ar[++leftptr]<pivot)
        {

        }
        while((rightptr>0)&&(ar[--rightptr]>pivot))
        {

        }
        if(leftptr>=rightptr)
        {
            break;
        }
        else
        {
            swap(ar[leftptr],ar[rightptr]);
        }
    }
    swap(ar[leftptr],ar[pivot_idx]);
    return leftptr;
}
void rec_quick_sort(int *ar,int left,int right)
{
    if(right-left<=0)
    {
        return;
    }
    else
    {
        int pivot= ar[right];
        int pivot_idx=right;
        int part=array_partition(ar,left,right,pivot,pivot_idx);
        rec_quick_sort(ar,left,part-1);
        rec_quick_sort(ar,part+1,right);
    }
}
void quick_sort(int *ar,int n)
{
    rec_quick_sort(ar,0,n-1);
}
void rec_rand_quick_sort(int *ar,int left,int right)
{
    if(right-left<=0)
    {
        return;
    }
    else
    {
        int pivot_idx=left+rand()%(right-left);
        int pivot=ar[pivot_idx];
        swap(ar[pivot_idx],ar[right]);
        pivot_idx=right;
        int part=array_partition(ar,left,right,pivot,pivot_idx);
        rec_rand_quick_sort(ar,left,part-1);
        rec_rand_quick_sort(ar,part+1,right);
    }
}
void rand_quick_sort(int *ar,int n)
{
    rec_rand_quick_sort(ar,0,n-1);
}
void array_merge(int *ar,int * holder,int low,int high,int up_bound)
{
    int j=0;
    int low_bound=low;
    int mid=high-1;
    int n=up_bound-low_bound+1;
    while(low<=mid && high<=up_bound)
    {
        if(ar[low]<ar[high])
        {
            holder[j++]=ar[low++];
        }
        else
        {
            holder[j++]=ar[high++];
        }
    }
    while(low<=mid)
    {
        holder[j++]=ar[low++];
    }
    while(high<=up_bound)
    {
        holder[j++]=ar[high++];
    }
    for(j=0; j<n; j++)
    {
        ar[low_bound+j]=holder[j];
    }
}
void rec_merge_sort(int *ar,int * holder,int low_bound,int up_bound)
{
    if(low_bound==up_bound)
    {
        return;
    }
    else
    {
        int mid=(low_bound+up_bound)/2;
        rec_merge_sort(ar,holder,low_bound,mid);
        rec_merge_sort(ar,holder,mid+1,up_bound);
        array_merge(ar,holder,low_bound,mid+1,up_bound);
    }
}
void merge_sort(int *ar,int n)
{
    int * holder = new int [n];
    rec_merge_sort(ar,holder,0,n-1);
    delete [] holder;
}
