import java.util.*;

class Caesar
{
	public static void main(String a[])
	{
		int k=Integer.parseInt(a[0]);
		StringBuffer ans=new StringBuffer();
		System.out.println("Enter 1 for encryption\nEnter 2 for decryption");
		Scanner s=new Scanner(System.in);
		int c=s.nextInt();
		char tmp;
		int m;
		if(c==1)
		{
		for(int i=0;i<a[0].length();i++)
		{
				if(Character.isUpperCase(a[0].charAt(i)))
					m=65;
				else
					m=97;
				tmp=(char)((((int)a[0].charAt(i)+k-m)%26)+m);
				ans.append(tmp);	
		}
		System.out.println("Encrypted Text: "+ans);
		}
		else
		{
			for(int i=0;i<a[0].length();i++)
		{
			if(Character.isUpperCase(a[0].charAt(i)))
					m=65;
				else
					m=97;
			if((int)a[0].charAt(i)-k-m>=0)
				tmp=(char)((((int)a[0].charAt(i)-k-m)%26)+m);
			else
				tmp=(char)((int)a[0].charAt(i)-k+26);
				ans.append(tmp);	
		}
			System.out.println("Decrypted Text: "+ans);
		}
		}
}