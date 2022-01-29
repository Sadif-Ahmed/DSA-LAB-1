#include <iostream>
#include <fstream>
#include <chrono>
#include <algorithm>
#include <iomanip>
#include "Sort.h"
using namespace std;
const int seed = 15;
void array_builder(int * ar,int n)
{
    for(int i=0;i<n;i++)
    {
        ar[i]=rand();
    }
}
double stl_sort_timer(int size,int num_of_tests)
{
    int *holder= new int [size];
    array_builder(holder,size);
    double result=0.000;
    for(int i=0;i<num_of_tests;i++)
    {
        int *temp = new int[size];
        copy(holder, holder + size, temp);

        auto start = std::chrono::high_resolution_clock::now();
        std::sort(temp, temp + size);
        result += double(std::chrono::duration_cast<std::chrono::nanoseconds>(
                            std::chrono::high_resolution_clock::now() - start)
                            .count() /
                            1000000.0);
                            delete[]temp;
    }
    delete [] holder;
    return result/num_of_tests;
}
double merge_sort_timer(int size,int num_of_tests)
{
    int *holder= new int [size];
    array_builder(holder,size);
    double result=0.000;
    for(int i=0;i<num_of_tests;i++)
    {
        int *temp = new int[size];
        copy(holder, holder + size, temp);

        auto start = std::chrono::high_resolution_clock::now();
        merge_sort(temp,size);
        result += double(std::chrono::duration_cast<std::chrono::nanoseconds>(
                            std::chrono::high_resolution_clock::now() - start)
                            .count() /
                            1000000.0);
                            delete[]temp;
    }
    delete [] holder;
    return result/num_of_tests;
}
double quick_sort_timer(int size,int num_of_tests,int state)
{
    int *holder= new int [size];
    array_builder(holder,size);
    double result=0.000;
    if(state)
    {
        quick_sort(holder,size);
    }
    for(int i=0;i<num_of_tests;i++)
    {
        int *temp = new int[size];
        copy(holder, holder + size, temp);

        auto start = std::chrono::high_resolution_clock::now();
        quick_sort(temp,size);
        result += double(std::chrono::duration_cast<std::chrono::nanoseconds>(
                            std::chrono::high_resolution_clock::now() - start)
                            .count() /
                            1000000.0);
                            delete[]temp;
    }
    delete [] holder;
    return result/num_of_tests;
}
double rand_quick_sort_timer(int size,int num_of_tests,int state)
{
    int *holder= new int [size];
    array_builder(holder,size);
    double result=0.000;
    if(state)
    {
        quick_sort(holder,size);
    }
    for(int i=0;i<num_of_tests;i++)
    {
        int *temp = new int[size];
        copy(holder, holder + size, temp);

        auto start = std::chrono::high_resolution_clock::now();
        rand_quick_sort(temp,size);
        result += double(std::chrono::duration_cast<std::chrono::nanoseconds>(
                            std::chrono::high_resolution_clock::now() - start)
                            .count() /
                            1000000.0);
                            delete[]temp;
    }
    delete [] holder;
    return result/num_of_tests;
}
double insertion_sort_timer(int size,int num_of_tests)
{
    int *holder= new int [size];
    array_builder(holder,size);
    double result=0.000;
    for(int i=0;i<num_of_tests;i++)
    {
        int *temp = new int[size];
        copy(holder, holder + size, temp);

        auto start = std::chrono::high_resolution_clock::now();
        insertion_sort(temp,size);
        result += double(std::chrono::duration_cast<std::chrono::nanoseconds>(
                            std::chrono::high_resolution_clock::now() - start)
                            .count() /
                            1000000.0);
                            delete[]temp;
    }
    delete [] holder;
    return result/num_of_tests;
}
int main()
{
   /* std::srand(seed);

    //file output part
    std::ofstream outputFileStream("result.csv", std::ios::out);
    std::streambuf *stream_buffer_file_out = outputFileStream.rdbuf();

    // Backup streambuffers of cin cout
    std::streambuf *stream_buffer_cout = std::cout.rdbuf();

    //redirection part
    std::cout.rdbuf(stream_buffer_file_out);

    //csv headers
    std::cout << ",Time required in ms,,,,,,"
              << "\n";
    std::cout << "n,Merge Sort,Quicksort,Randomized Quicksort,Insertion Sort,Quicksort with Sorted Input,Randomized Quicksort with Sorted Input,STL sort() function"
              << "\n";

    //testing part

    int n[] = {5, 10, 100, 1000, 10000, 100000};

    int tests=20;
    for (int i=1;i<=6;i++)
    {
        std::cout << std::fixed << std::setw(10) << std::setprecision(10)
                  << n[i-1]
                  << "," << merge_sort_timer(n[i-1],tests)
                  << "," << quick_sort_timer(n[i-1],tests,0)
                  << "," << rand_quick_sort_timer(n[i-1],tests,0)
                  << "," << insertion_sort_timer(n[i-1],tests)
                  << "," << quick_sort_timer(n[i-1],tests,1)
                  << "," << rand_quick_sort_timer(n[i-1],tests,1)
                  << "," << stl_sort_timer(n[i-1],tests)
                  << "\n";
    }

    // sets couts streambuffer and returns the old
    std::cout.rdbuf(stream_buffer_cout);
    //close file
    outputFileStream.close();
    */
    int n;
    cin>>n;
    int *ar= new int[n];
    array_builder(ar,n);
    rand_quick_sort(ar,n);
    for(int i=0;i<n;i++)
    {
        cout<<ar[i]<<" ";
    }
}
