
/**Takahashi, who lives on the number line, is now at coordinate X. He will make exactly K moves of distance D in the positive or negative direction.
More specifically, in one move, he can go from coordinate x to x+D or x−D.
He wants to make K moves so that the absolute value of the coordinate of the destination will be the smallest possible.
Find the minimum possible absolute value of the coordinate of the destination.**/


/**Author Kishore**/
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextLong();
		x=Math.abs(x);
		long k = sc.nextLong();
		long d = sc.nextLong();
		
		long div = x/d;
		if(div>=k){
		    System.out.println(x-k*d);
		}else{
		    k=k-div;
		    x=x-div*d;
		    long z= Math.abs(x-d);
		    if(z<x){
		        k--;
		        if(k%2==0){
		            System.out.println(z);
		        }else{
		            System.out.println(x);
		        }
		    }else{
		        if(k%2==0){
		            System.out.println(x);
		        }else{
		            System.out.println(z);
		        }
		    }
		}
		
	}
}
