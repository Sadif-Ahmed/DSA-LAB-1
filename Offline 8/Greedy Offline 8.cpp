#include<iostream>
#include <bits/stdc++.h>
using namespace std;
int main()
{
    int n,k,price_count=0,result=0;
    cin>>n>>k;
    int * prices = new int[n];
    for(int i=0; i<n; i++)
    {
        cin>>prices[i];
    }
    sort(prices, prices + n, greater<int>());
    for(int i=0; i<n; i++)
    {
        if(i%k==0)
        {
            price_count++;
        }
        result+=prices[i]*price_count;
    }
    cout<<result;
}
