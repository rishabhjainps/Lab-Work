#include<stdio.h>
#include<iostream>
using namespace std;

int main()
{


FILE *ptr = fopen("f.txt","r");
char c;
int flag=0,noc=0,now=0,nol=1,nod=0;

if(ptr== NULL)
{
	printf("\nFile Do Not Exists");
 }
 else
 {
 	c= fgetc(ptr);
 	while(c!=EOF)
	 {
	 	flag=0;
	 	
		if(c>='a'&&c<='z'||c>='A'&&c<='Z')
		noc++;		 
		
		if(c>='0'&&c<='9')
		nod++;
		
		if(c==' ')
		now++;
		
		if(c=='\n')
		{
			nol++;
			c=fgetc(ptr);
			if(c>='a'&&c<='z'||c>='A'&&c<='Z')
			{
				flag=1;
				now+=2;
			}
			else
			{
				now++;
			}
			
		}
		
		if(flag==0)
		c=fgetc(ptr);
		
		
	 }	
 } 
cout<<"\nFILE CONTENTS :\n";
cout<<"This is a file\nA big File45";

cout<<"\n\nNo. of characters :"<<noc;
cout<<"\nNo. of digits :"<<nod;
cout<<"\nNo. of words :"<<now;
cout<<"\nNo. of lines :"<<nol;
fclose(ptr);
return 0;
}
