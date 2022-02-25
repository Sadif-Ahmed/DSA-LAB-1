#include<iostream>
using namespace std;
int main()
{
    long long n,step=0;
    cin>>n;
    long long ar[n];
    long long tempar[n];
    for(long long i=0;i<n;i++)
    {
        cin>>ar[i];
        tempar[ar[i]-1]=i+1;
    }
    for(long long i=0;i<n;i++)
    {
        if(tempar[i]<tempar[i-1])
        {
            step++;
        }
    }
    cout<<step;

}
