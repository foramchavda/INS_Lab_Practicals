import java.util.*;
class RailFence
{
	int depth;
	static String encryption(String plainText,int depth)throws Exception
	{
		int r=depth,len=plainText.length();
		int c=len/depth;
		if((len%depth)!=0)
			c++;
		char mat[][]=new char[r][c];
		int k=0;
		String cipherText="";
		for(int i=0;i< c;i++)
		{
			for(int j=0;j< r;j++)
			{
				if(k!=len)
					mat[j][i]=plainText.charAt(k++);
				else
					mat[j][i]='-';
			}
		}
		for(int i=0;i< r;i++)
		{
			for(int j=0;j< c;j++)
			{
				cipherText+=mat[i][j];
			}
		}
		return cipherText;
	}
	static String decryption(String cipherText,int depth)throws Exception
	{
		int r=depth,len=cipherText.length();
		int c=len/depth;
		char mat[][]=new char[r][c];
		int k=0;
		String plainText="";
		for(int i=0;i< r;i++)
		{
			for(int j=0;j< c;j++)
			{
				mat[i][j]=cipherText.charAt(k++);
			}	
		}
		for(int i=0;i< c;i++)
		{
			for(int j=0;j< r;j++)
			{
				plainText+=mat[j][i];
			}
		}
		return plainText;
	}
	public static void main(String args[])throws Exception
	{
        Scanner sc=new Scanner(System.in);
        int depth;
		String plainText,cipherText,decryptedText;
		System.out.println("Enter 1 for encryption 2 for decryption:");
		int c = sc.nextInt();
		//System.out.println(c);
		if(c==1)
		{
			System.out.println("Enter plain text:");
			plainText=sc.next();
			System.out.println("Enter depth for Encryption:");
			depth=sc.nextInt();
			cipherText=encryption(plainText,depth);
			System.out.println("Encrypted text is:\n"+cipherText);
		}
		else if(c==2)
		{	
			System.out.println("Enter cipher text:");
			cipherText=sc.next();
			System.out.println("Enter depth for Decryption:");
			depth=sc.nextInt();
			decryptedText=decryption(cipherText, depth);
			System.out.println("Decrypted text is:\n"+decryptedText);
		}
		else
		{
			System.out.println("----Please enter valid choice----");
		}
    }
}