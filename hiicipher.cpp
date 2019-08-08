#include<iostream>
using namespace std;

void getkeymatrix(string key,int keymatrix[][3])
{
int k=0;
for(int i=0;i<3;i++)
{
	for(int j=0;j<3;j++)
	{
		keymatrix[i][j]=(key[k])%65;
		k++;
	}
}
}
void encrypt(int ciphermatrix[][1],int keymatrix[][3],int msgvector[][1])
{
	int i,j,x;
	for(i=0;i<3;i++)
	{
		for(j=0;j<1;j++)
		{
			ciphermatrix[i][j]=0;
			for(x=0;x<3;x++)
			{
				ciphermatrix[i][j]+=keymatrix[i][x]*msgvector[x][j];
			}
			ciphermatrix[i][j]=ciphermatrix[i][j]%26;

		}
		
	}
}
void HillCipher(string message,string key)
{
	int keymatrix[3][3];
	getkeymatrix(key,keymatrix);

	int msgvector[3][1];
	for(int i=0;i<3;i++)
	{
		msgvector[i][0]=message[i]%56;
	}
	int ciphermatrix[3][1];
	encrypt(ciphermatrix,keymatrix,msgvector);
	
	string ciphertext;
	for(int i=0;i<3;i++)
	{
	ciphertext+=ciphermatrix[i][0] + 65;
	}
	cout<<ciphertext;
}


int main()
{
	string message="act";
	string key="gybnqkarp";
	
	HillCipher(message,key);
	return 0;
}
