#include<iostream>
using namespace std;
class list{
    public:
int data;
list *next;
}*head;

void insert(int d,int pos)
{
    list *temp=new list;
    temp->data=d;
    list *curr=head;
    if(pos==1)
    {
        temp->next=head;
        head=temp;

    }
    else
    {
        for(int i=2; i<pos; i++)
        {
            if(curr!=NULL)
            {    curr=curr->next;}


        }
          temp->next=curr->next;
            curr->next=temp;

    }

}


void delet(int pos)
{
     list *temp=head;
     list *curr=head;
    if(pos==1)
    {
            head=head->next;
            delete temp;
    }
    else
    {
        for(int i=2; i<pos; i++)
        {
            curr=curr->next;
        }
        temp=curr->next;
        curr->next=curr->next->next;
        delete temp;

    }

}
void display()
{
   list *temp=head;
   cout<<"\n DISPLAY : ";
   while(temp!=NULL)
   {
    cout<<temp->data<<" ";
    temp=temp->next;
   }
	cout<<"\n";
}


int main()
{
	int choice;
	int item,n,i;
	printf("\n \n 1. Insertion \n 2. Deletion\n 3. Display\n 4. EXIT\n");
	do
	{
		printf("\n Enter choice :");
		scanf("%d", &choice);
		switch(choice)
		{
			case 1:
				
				printf("\n Enter the number to be inserted : ");
				scanf("%d",&item);
				printf("\n Enter the position after which you want to insert : ");
				scanf("%d",&n);
				insert(item,n);
				break;
			case 2:
				printf("\n Enter the position you want to delete : ");
				scanf("%d",&n);
				delet(n);
				break;
			case 3:
				display();
				break;
			case 4:
				break;
			default:
				printf("\n Enter the right choice!");
				break;
		}
		
	}while(choice!=4);


return 0;
}
