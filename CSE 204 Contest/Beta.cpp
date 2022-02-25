#include<iostream>
#include<climits>
using namespace std;
int main()
{
    int n;
    cin>>n;
    int store[n+1];
    store[0]=0;
    for(int i=1;i<=n;i++)
    {
            store[i]=INT32_MAX;
    }
    for(int i=0;i<=n;i++)
    {
        for(int j=1;j<=n&&((i+(j*j))<=n);j++)
        {
                if(store[i+j*j]>store[i]+1)
                {
                    store[i+j*j]=store[i]+1;
                }
        }
    }
    cout<<store[n];
}
