import java.util.*;

class Playfair
{
	public static void main(String a[])
	{
		char[][] tab=new char[5][5];
		String cp=a[1].replace('J','I');
		StringBuffer alp=new StringBuffer("ABCDEFGHIKLMNOPQRSTUVWXYZ");
		int m=0;
		System.out.println("Enter 1 for encryption or 2 for decryption:\n");
		Scanner s=new Scanner(System.in);
		int c=s.nextInt();
		StringBuffer ans=new StringBuffer();
		StringBuffer tmp=new StringBuffer(cp);
		for(int i=0;i<tmp.length();i++)
		{
			for(int j=i+1;j<tmp.length();j++)
			{
				if(tmp.charAt(i)==tmp.charAt(j))
					tmp.deleteCharAt(j);
			}
		}
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(m<tmp.length())
				{		
						tab[i][j]=tmp.charAt(m);
						int l=alp.indexOf(Character.toString(tab[i][j]));
						alp.deleteCharAt(l);
						m++;
				}
				else
				{
					tab[i][j]=alp.charAt(0);
					alp.deleteCharAt(0);
				}
			}
		}
		int i;
		for(i=0;i<a[0].length();i++)
		{
			alp.append(a[0].charAt(i));
			if(i!=a[0].length()-1 && a[0].charAt(i)==a[0].charAt(i+1) && alp.length()%2!=0)
				alp.append("X");
		}
		if(alp.length()%2!=0)
			alp.append("X");
		String st=new String();
		if(c==1)
		st=alp.toString();
		else
		st=a[0];
		for(i=0;i<st.length();i=i+2)
		{
			ans.append(findInd(st.charAt(i),st.charAt(i+1),tab,c));
		}
		if(c==1)
			System.out.println("Encrypted text: "+ans);
		else
		{
			st=ans.toString().replace("X","");
			System.out.println("Decrypted text: "+st);
		}
	}
	public static String findInd(char a,char b,char[][] tab,int c)
	{
		int[] i=new int[2];
		int[] j=new int[2];
		for(int m=0;m<5;m++)
		{
			for(int n=0;n<5;n++)
			{
				if(tab[m][n]==a)
				{
					i[0]=m;
					i[1]=n;
				}
				else if(tab[m][n]==b)
				{
					j[0]=m;
					j[1]=n;
				}
			}
		}
		int k;
		StringBuffer sb=new StringBuffer();
		if(c==1)
			k=1;
		else
			k=4;
		if(i[0]==j[0])
		{
			sb.append(tab[i[0]][(i[1]+k)%5]);
			sb.append(tab[j[0]][(j[1]+k)%5]);
		}
		else if(i[1]==j[1])
		{
			sb.append(tab[(i[0]+k)%5][i[1]]);
			sb.append(tab[(j[0]+k)%5][j[1]]);
		}
		else
		{
			sb.append(tab[i[0]][j[1]]);
			sb.append(tab[j[0]][i[1]]);
		}
		return sb.toString();
	}
}