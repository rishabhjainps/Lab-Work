#include<iostream>
using namespace std;
class Company
{
    string name;
public:
    virtual void getdata()
    {
        cout<<"Enter Company Name : ";
        cin>>name;
    }
    virtual void display()
    {
        cout<<"Company Name : "<<name<<"\n";
    }
};

class Desktop : public Company
{
    string modelName;
    float price;
public:
    void getdata()
    {
        cout<<"Enter Model Name : ";
        cin>>modelName;
        cout<<"Enter Price : ";
        cin>>price;
    }
    void display()
    {
        cout<<"Model Name : "<<modelName<<"\n";
        cout<<"Price : "<<price<<"\n";
    }
};

class Laptop : public Company
{
    string modelName;
    float price;
public:
    void getdata()
    {
        cout<<"Enter Model Name : ";
        cin>>modelName;
        cout<<"Enter Price : ";
        cin>>price;
    }
    void display()
    {
        cout<<"Model Name : "<<modelName<<"\n";
        cout<<"Price : "<<price<<"\n";
    }
};

int main()
{
    Company* cptr;
    Company c1;
    Desktop d1;
    Laptop l1;

    cptr = &c1;
    cptr->getdata();

    cptr = &d1;
    cptr->getdata();

    cptr = &l1;
    cptr->getdata();

    cptr = &c1;
    cptr->display();

    cptr = &d1;
    cptr->display();

    cptr = &l1;
    cptr->display();
    
    return 0;
}
