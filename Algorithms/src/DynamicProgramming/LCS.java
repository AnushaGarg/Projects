package DynamicProgramming;
import java.util.*;
class Nodeinfo
{
	int c;
	char seq;
	Nodeinfo()
	{
		c=0;
	}
}

public class LCS {
	public static void main(String[] args)
	{
		int n,m;
		String str1,str2;
		Scanner s =new Scanner(System.in);
		str1= s.nextLine();
		str2=s.nextLine();
		n=str1.length();
		m=str2.length();
		Nodeinfo node[][] = new Nodeinfo[n+1][m+1];
		for(int i=0;i<n+1;i++)
			node[i][0]=new Nodeinfo();
		for(int j=0;j<m+1;j++)
			node[0][j]=new Nodeinfo();
		for(int i=1;i<n+1;i++)
			for(int j=1;j<m+1;j++)
			{
				node[i][j]=new Nodeinfo();
				if(str1.charAt(i-1) == str2.charAt(j-1))
				{
					node[i][j].c= 1 + node[i-1][j-1].c;
					node[i][j].seq= '`';
				}else
				{
					if(node[i-1][j].c > node[i][j-1].c)
					{
						node[i][j].c=node[i-1][j].c;
						node[i][j].seq = '<';
					}else
					{
						node[i][j].c=node[i][j-1].c;
						node[i][j].seq = '^';
					}
				}
			}
		PrintSeq(node,str1,n,m);
		s.close();
	}
	static void PrintSeq(Nodeinfo node[][],String str1,int n,int m)
	{
		if (n!=0 && m!=0)
		{
			if(node[n][m].seq == '`')
			{
				PrintSeq(node,str1,n-1,m-1);
				System.out.print(str1.charAt(n-1));
			}else if(node[n][m].seq == '<')
			{
				PrintSeq(node,str1,n-1,m);
			}
			else
			{
				PrintSeq(node,str1,n,m-1);
			}
		}			
	}
}