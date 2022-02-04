#include<iostream>
#include <bits/stdc++.h>
using namespace std;
long long min_cost_calculator(long long * prices,int plants,int members)
{
    int price_count=0;
    long long result=0;
    sort(prices, prices + plants, greater<long long>());
    for(int i=0; i<plants; i++)
    {
        if(i%members==0)
        {
            price_count++;
        }
        result+=prices[i]*price_count;
    }
    return result;
}
int main()
{
    int n,k;
    cin>>n>>k;
    long long * prices = new long long[n];
    for(int i=0; i<n; i++)
    {
        cin>>prices[i];
    }
    cout<<"Minimum Cost:"<<min_cost_calculator(prices,n,k);
}
