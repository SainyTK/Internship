import java.io.*;

public class Internship2
{
	public boolean checkInput(String[] sArr)
	{
		//check num of input
		if(sArr.length != 2)
		{
			System.out.println("Please input 2 argument only.");
			return false;
		}
		//check type of 1st input
		int i;
		boolean chk = true;
		for(i=0;i<sArr[0].length();i++)
			if(sArr[0].charAt(i)<'0'||sArr[0].charAt(i)>'9')
				chk = false;
		if(!chk)
		{
			System.out.println("Please input number in 1st argument.");
			return false;
		}
		//check input format
		int countX = 0;
		for (i=0; i<sArr[1].length();i++)
			if(sArr[1].charAt(i) == 'X')
				countX++;
		if(countX != sArr[0].length())
		{
			System.out.println("Please use input format correctly.");
			return false;
		}
		return true;
	}

	public String changeFormat(String[] sArr)
	{
		String s1,s2;
		int i,j=0;
		s1 = sArr[0];
		s2 = sArr[1];
		char[] s3 = s2.toCharArray();
		for(i=0;i<s2.length();i++)
		{
			if(s2.charAt(i)=='X')
			{
				s3[i] = s1.charAt(j);
				j++;
			}
		}
		String ans = String.valueOf(s3);
		return ans;
	}

	public static void main(String args[])
	{
		try
		{
			Internship2 obj = new Internship2();
			obj.run(args);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void run(String[] args) throws Exception
	{
		if(checkInput(args))
		{
			System.out.println(changeFormat(args));
		}
		
	}
}