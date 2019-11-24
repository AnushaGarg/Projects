package DynamicProgramming;

public class TowerOfHanoi {

	public static void main(String[] args) {
		TowerOfHanoiMeth('A','C','B',5);
	}
	static void TowerOfHanoiMeth(char from,char to, char aux,int n)
	{

		if(n==1)
			System.out.println("Move "+ n + " from "+from+" to "+to);
		if(n > 1)
		{
			TowerOfHanoiMeth(from,aux,to,n-1);
			System.out.println("Move " + n + " from " + from + " to "+to);
			TowerOfHanoiMeth(aux,to,from,n-1);
		}
	}
}
