#include<iostream>
using namespace std;

float area(float side)
{
    return side*side;
}

float area(float l,float b)
{
    return l*b;
}

float area(int radius)
{
    return 3.14*radius*radius;
}

float perimeter(float side)
{
    return 4*side;
}

float perimeter(float l,float b)
{
    return 2*(l+b);
}

float perimeter(float a,float b,float c)
{
   return a+b+c;
}

float perimeter(int radius)
{
    return 2*3.14*radius;
}

int main()
{
    float a,b,c;
    int r;
    int choice1,choice2;
    char ch;
    do
    {
        cout<<"Choose : -\n";
        cout<<"1.Calculate Area\n";
        cout<<"2.Calculate Perimeter\n";
        cin>>choice1;
        switch(choice1)
        {
        case 1:
            {
                cout<<"Choose:-\n";
                cout<<"1.Square\n";
                cout<<"2.Rectangle\n";
                cout<<"3.Circle\n";
                cin>>choice2;
                switch(choice2)
                {
                case 1:
                    cout<<"Enter side : ";
                    cin>>a;
                    cout<<"Area : "<<area(a);
                    break;
                case 2:
                    cout<<"Enter sides : ";
                    cin>>a>>b;
                    cout<<"Area : "<<area(a,b)<<"\n";
                    break;
                case 3:
                    cout<<"Enter radius : ";
                    cin>>r;
                    cout<<"Area : "<<area(r);
                    break;
                }
                break;
            }
        case 2:
            {
                cout<<"Choose:-\n";
                cout<<"1.Square\n";
                cout<<"2.Rectangle\n";
                cout<<"3.Circle\n";
                cin>>choice2;
                switch(choice2)
                {
                case 1:
                    cout<<"Enter side : ";
                    cin>>a;
                    cout<<"Perimeter : "<<perimeter(a);
                    break;
                case 2:
                    cout<<"Enter sides : ";
                    cin>>a>>b;
                    cout<<"Perimeter : "<<perimeter(a,b)<<"\n";
                    break;
                case 3:
                    cout<<"Enter radius : ";
                    cin>>r;
                    cout<<"Perimeter : "<<perimeter(r);
                    break;
                case 4:
                    cout<<"Enter sides : ";
                    cin>>a>>b>>c;
                    cout<<"Perimeter : "<<perimeter(a,b,c);
                    break;
                }
                break;
            }
        }
        cout<<"Continue (y/n) : ";
        cin>>ch;
    }while(ch=='y'||ch=='Y');
}
