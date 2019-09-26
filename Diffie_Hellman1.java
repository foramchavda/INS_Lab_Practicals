import java.util.*;
 
class Diffie_Hellman1
{
 public static void main(String args[])
 {
 Scanner sc=new Scanner(System.in);
 System.out.println("Enter value of prime number(q)");
 int q=sc.nextInt();
 System.out.println("Enter primitive root of alpha" );
 int alpha=sc.nextInt();
 System.out.println("Choose 1st secret no(Alice)");
 int a=sc.nextInt();
 System.out.println("Choose 2nd secret no(BOB)");
 int b=sc.nextInt();
 
 int A = (int)Math.pow(alpha,a)%q;
 int B = (int)Math.pow(alpha,b)%q;
 
 int Ka = (int)Math.pow(B,a)%q;
 int Kb =(int)Math.pow(A,b)%q; 
 
 if(Ka==Kb)
 {
 System.out.println("ALice and Bob can communicate with each other!!!");
 System.out.println("They share a secret key is = "+Ka); 
 System.out.println("They share a secret key is = "+Kb);
 }
 
 else
 {
 System.out.println("ALice and Bob cannot communicate with each other!!!");
 }
 } 
}


