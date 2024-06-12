package bbl.recursive;

public class LinearRecurcionMethods
{
	public static int factorial(int n)
	{
		if(n<0)
		{
			throw new IllegalArgumentException("n cannot be negative");
		}
		int res=1;
		if(n!=0) res=n*factorial(n-1);
		return res;
	}
	
	public static int pow1(int a,int b)
	{
		if(b<0)
		{
			throw new IllegalArgumentException("n cannot be negative");
		}
		int res=1;
		if(b!=0) res=a*pow1(a,b-1);
		return res;
	}

	/**
	 * 
	 * @param a - any integer number
	 * @param b - positive integer number
	 * @return a ^ b
	 * no cycles
	 * only arithmetic operations +, -
	 * additional functions if any with the same limitations
	 */
	public static int pow(int a, int b)
	{
		if(b<0)
		{
			throw new IllegalArgumentException("n cannot be negative");
		}
		int res=1;
		int resPow=1;
		if(b!=0)
		{
			if(b>1) 
			{
				resPow=pow(a,b-1);
				res=mult(a,resPow);
			}
			else res=a;
		}
		return res;
	}
	
	public static int mult(int a,int b)
	{
		int res=0;
		int nowa=a;
		int nowb=b;
		if(a<0) nowa=-a;
		if(b<0) nowb=-b;
		
		if(a!=0)
		{
			if(nowb==1) res=nowa;
			else res=nowa+mult(nowa,nowb-1);
		}
		if(a>0 != b>0) res=0-res; 
		return res;
	}
	
	public static void displayArray(int[] array)
	{
		displayArray(0, array, false);
	}
	
	public static void displayArrayReversed(int[] array)
	{
		displayArray(0, array, true);
	}

	private static void displayArray(int index, int[] array, boolean isReversed)
	{
		if(index<array.length)
		{
			if(isReversed)
			{
				displayArray(index+1,array,true);
				System.out.print(array[index]+" ");
			}
			else
			{
				System.out.print(array[index]+" ");
				displayArray(index+1,array,false);
				
			}
		}
	}
	
	public static int sum(int [] array)
	{
		return sum(0,array);
	}
	
	public static int sum(int index,int [] array)
	{
		int res=0;
		if(index<array.length)
		{
			res=array[index]+sum(index+1,array);
		}
		return res;
	}
	
	public static void reverse(int [] array)
	{
		reverse(0,array.length-1,array);
	}

	private static void reverse(int left, int right, int[] array)
	{
		if(left<right)
		{
			int tmp=array[left];
			array[left]=array[right];
			array[right]=tmp;
			reverse(left+1,right-1,array);
		}
		
	}
	
	/**
	 * 
	 * @param x - any integer number
	 * @return x ^ 2
	 * no cycles
	 * allowed only arithmetic operations +, -
	 * no additional functions allowed
	 * no static fields
	 */
	public static int square(int x)
	{
		int res=1;
		if(x<0) x=-x;
		if(x>1) res=square(x-1)+x+x-1;
		return res;
	}
	
	/**
	 * 
	 * @param str - string
	 * @param substr - substring
	 * @return true if substr is a substring of a string, false otherwise
	 * no cycles
	 * allowed only three String methods are charAt(int index);substring(int beginIndex);
	 * length()
	 */
	public static boolean isSubstring(String str,String substr)
	{
		boolean res=false;
		int substrLen=substr.length();
		int strLen=str.length();
			if( (strLen>0) && (substrLen>0) && (strLen>substrLen) )
			{
				res=isSubstring(str,substr,0);
				if(!res)
				{
					String newStr=str.substring(1);
					res=isSubstring(newStr,substr);
				}
			}		
		return res;
	}
	
	private static boolean isSubstring(String str,  String substr, int index)
	{
		boolean res=true;
		if( (substr.length() - index) >0)
		{
			if(str.charAt(index)==substr.charAt(index))
			{
				index=index+1;
				res= isSubstring(str,substr,index);
			}
			else res=false;
		}
		return res;
	}
	
	
	
}

