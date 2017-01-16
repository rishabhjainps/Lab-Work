#include <graphics.h>
#include<iostream>
#include<cmath>
using namespace std;
int main( )
{
    
 
 	
 	float x1,y1,x2,y2 ,dx,dy ,div ;
 	float start , end;
 	
	x1=2;y1=3;x2=100;y2=200;
 	cin>>x1>>y1>>x2>>y2;
 	dx = abs(x1-x2);
 	dy = abs(y1-y2);
 	
 	div = max(dx,dy);
 	
 	div = floor( log2(div) + 0.5 );
 	div = pow(2,div);
	 	
 	float dx1 , dy1;
 	
 	dx1 = dx/div;
 	dy1 = dy/div;
 	
 	start = x1 + 0.5 , end = y1 + 0.5 ;
 	initwindow(400, 300, "First Sample");
 	while(start<x2){
 		putpixel( floor(start),floor(end),RED  );
 		start+=dx1;
 		end+=dy1;
	 }

    getch();
	      
}
