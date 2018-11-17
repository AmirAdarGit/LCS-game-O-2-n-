
package algorithms;
import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
public class LCS_game_best_time_complacity {


	public static void main(String[] args) {
		game_Lcs();
	}


	public static void game_Lcs() {
		Scanner sc = new Scanner(System.in);
		System.out.println("welcome to LCS game!");
		System.out.println("you need to choos t srring one after one: ");
		System.out.println("enter the first String: ");
		String s1=sc.nextLine();
		System.out.println("the first String is ---> "+s1);
		System.out.println("enter the second String: ");
		String s2=sc.nextLine();
		System.out.println("the second String is ---> "+s2);
		System.out.println("the Longest common subsequence is :"+lcs(s1,s2));
	}
	public static StringBuffer lcs(String x,String y)
	{

		int arr[][]=build_arr_2d(x, y);
		for(int i=2;i<arr.length;i++)
		{
			for(int j=2;j<arr[0].length;j++)
			{
				if(arr[0][j]==arr[i][0])
				{
					arr[i][j]=arr[i-1][j-1]+1;
				}
				else
				{
					arr[i][j]=Math.max(arr[i-1][j],arr[i][j-1]);
				}
			}
		}
		StringBuffer a = new StringBuffer(print_the_lcs(arr));
		a.reverse();
		return a;
	}

	public static String print_the_lcs(int arr[][])
	{
		String s="";
		for(int i=arr.length-1;i>=0;i--)
		{
			for(int j=arr[0].length-1;j>=0;j--)
			{
				if((i==1||j==1)||(i==0||j==0))
				{
					continue;
				}
				if(arr[0][j]==arr[i][0])
				{
					char c= (char)arr[i][0];
					s+=c;
					i--;
				}
				else
				{
					if(arr[i-1][j]<arr[i][j-1])
					{
						continue;
					}
					else
					{
						i--;
						j++;
					}
				}
			}
		}
		return s;
	}

	public static int[][] build_arr_2d (String x,String y)
	{

		int arr[][]=new int[y.length()+2][x.length()+2];
		for(int i=2;i<arr[0].length;i++)
		{
			arr[0][i]=x.charAt(i-2);
		}

		for(int j=2;j<arr.length;j++)
		{
			arr[j][0]=y.charAt(j-2);

		}
		return arr;
	}
}