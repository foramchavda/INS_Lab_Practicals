import java.util.*;

class Columnar
{
	public static void main(String a[])
	{
		int l=a[0].length()/a[1].length();
		if(a[0].length()%a[1].length()!=0)
			l++;
		char[][] tmp=new char[l][a[1].length()];
		char[] strArr=a[0].toCharArray();
		int i=0;
		System.out.println("Enter 1 for encryption\nEnter 2 for decryption");
		Scanner s=new Scanner(System.in);
		int c=s.nextInt();
		int d,m,n;
		StringBuffer ans=new StringBuffer();
		if(c==1)
		{
			for(m=0;m<l;m++)
			{
				for(n=0;n<a[1].length();n++)
				{
					if(i<strArr.length)
						tmp[m][n]=strArr[i++];
					else
						tmp[m][n]='-';
				}
			}
			for(i=1;i<=a[1].length();i++)
			{
				d=a[1].indexOf((char)(i+'0'));
				for(int j=0;j<l;j++)
				{
					ans.append(Character.toString(tmp[j][d]));
				}
			}
			System.out.println("Encrypted Text: "+ans);
		}
		else
		{
			m=0;
			for(i=1;i<=a[1].length();i++)
			{
				d=a[1].indexOf((char)(i+'0'));
				for(int j=0;j<l;j++)
				{
					tmp[j][d]=strArr[m++];
				}
			}
			for(n=0;n<l;n++)
			{
				for(m=0;m<a[1].length();m++)
				{
					if(tmp[n][m]=='-')
						break;
					else
						ans.append(tmp[n][m]);
				}
			}
			System.out.println("Decrypted Text: "+ans);
		}
	}
}