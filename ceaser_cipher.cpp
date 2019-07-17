#include<iostream>
#include<stdio.h>
using namespace std;

int main()
	{	
		char PT[100],CT[100];
		int i,key,n;
		
		cout<<"1.Encryption";
		cout<<"2.Decryption";
		cin>>n;
	switch(n)
	{
	case 1:
		cout<<"Enter plain text:\n";
		cin>>PT;
		
		cout<<"enter key;";
		cin>>key;
		key=key%26;

		for(i=0;PT[i]!='\0';i++)
		{
			if(isalpha(PT[i]))
			{ 
             			if(islower(PT[i]))
				{
					CT[i]=(PT[i]+key-'a')%26+'a';
				}			
			
				else
				{	
                			CT[i]=(PT[i]+key-'A')%26+'A';
        			}
			}
			else
			{
           		 CT[i]=PT[i];
			}
		}
    		CT[i]='\0';
    		cout<<"AFTER ENCRYPTION CIPHER..:"<<CT;
			break;

	case 2:
		cout<<"Enter plain text:\n";
		cin>>CT;
		
		cout<<"enter key;";
		cin>>key;
		key=key%26;

		for(i=0;CT[i]!='\0';i++)
		{
			if(isalpha(CT[i]))
			{ 
             			if(islower(CT[i]))
				{
					PT[i]=(CT[i]-key-'a')%26+'a';
				}			
			
				else
				{	
                			PT[i]=(CT[i]-key-'A')%26+'A';
        			}
			}
			else
			{
           		 PT[i]=CT[i];
			}
		}
		PT[i]='\0';
    		cout<<"AFTER DECRYPTION CIPHER..:"<<PT;
			break;
		
	default:
			cout<<"pleace enter text";
			break;

	}

		return 0;
	}

                
    
   
