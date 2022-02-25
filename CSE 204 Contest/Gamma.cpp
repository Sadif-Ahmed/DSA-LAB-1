#include<iostream>
using namespace std;

long long array_merge(long long *ar,long long * holder,long long low,long long high,long long up_bound)
{
    long long j=0;
    long long low_bound=low;
    long long mid=high;
    high++;
    long long n=up_bound-low_bound+1;
    long long inv=0;
    while(low<=mid || high<=up_bound)
    {
        if(high>up_bound || (low<=mid && high<=up_bound && ar[low]<=ar[high]))
        {
            holder[j++]=ar[low++];
        }
        else
        {
            holder[j++]=ar[high++];
            inv=inv+(mid+1-low);
        }
    }
    for(j=0; j<n; j++)
    {
        ar[low_bound+j]=holder[j];
    }
    return inv;
}
long long rec_merge_sort(long long *ar,long long * holder,long long low_bound,long long up_bound)
{

        long long mid;
        long long inv=0;
        if(up_bound>low_bound)
        {
        mid=(low_bound+up_bound)/2;
        inv+=rec_merge_sort(ar,holder,low_bound,mid);
        inv+=rec_merge_sort(ar,holder,mid+1,up_bound);
        inv+=array_merge(ar,holder,low_bound,mid,up_bound);
        }
        return inv;
}
long long merge_sort(long long *ar,long long n)
{
    long long * holder = new long long [n];
    long long ans=rec_merge_sort(ar,holder,0,n-1);
    delete [] holder;
    return ans;
}
int main()
{
    long long n,s;
    cin>>n;
    for(long long i = 1 ; i <= n ; i++)
    {
        cin>>s;
        long long arr[s];
        for(long long j = 0 ; j < s ; j++)
        {
            cin>>arr[j];
        }
        cout<<merge_sort(arr,s)<<endl;
    }
    return 0;
}
