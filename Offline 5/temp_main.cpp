
#include<iostream>
#include "heap.h"
#include<vector>
using namespace std;
int main()
{
    int ar[]={1,2,100,4,5,499,7,8,123,10};
    vector<int> temp;
    Heap XD(10);
    for(int i=0;i<10;i++)
    {
        XD.insert(ar[i]);
        temp.push_back(ar[i]);
    }
    heapsort(temp);
    for(int i=0;i<10;i++)
    {
        cout<<temp.back()<<" ";
        temp.pop_back();
    }

}
