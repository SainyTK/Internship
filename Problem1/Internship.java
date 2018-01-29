import java.io.*;

public class Internship{

	public boolean isVowel(char c)
	{
		char[] vowels = {'a','e','i','o','u'};
		int i;
		for (i=0;i<5; i++) 
		{
			if(c==vowels[i])
				return true;	
		}
		return false;
	}

	public boolean isLowerCase(char c)
	{
		return c>='a'&&c<='z';
	}

	public boolean isUpperCase(char c)
	{
		return c>='A'&&c<='Z';
	}

	public boolean isDigit(char c)
	{
		return c>='0'&&c<='9';
	}

	public int vowelCount(String s)
	{
		int i,count = 0;
		for (i=0;i<s.length();i++) 
		{
			if(isVowel(s.charAt(i)))
			{
				count++;
			}
		}
		return count;
	}

	public int lowercaseCount(String s)
	{
		int i,count = 0;
		for (i=0;i<s.length();i++) 
		{
			if(isLowerCase(s.charAt(i)))
			count++;
		}
		return count;
	}

	public int uppercaseCount(String s)
	{
		int i,count = 0;
		for (i=0;i<s.length();i++) 
		{
			if(isUpperCase(s.charAt(i)))
				count++;
		}
		return count;
	}

	public int digitCount(String s)
	{
		int i,count = 0;
		for (i=0;i<s.length();i++) 
		{
			if(isDigit(s.charAt(i)))
				count++;
		}
		return count;
	}

	public int alphabetCount(String s)
	{
		int i,count = 0;
		for (i=0; i<s.length(); i++) 
		{
			if((isUpperCase(s.charAt(i))||isLowerCase(s.charAt(i)))&&!isVowel(s.charAt(i)))
				count++;	
		}
		return count;
	}

	public static void main (String[] args)
	{
    	try
    	{
        	Internship obj = new Internship ();
        	obj.run (args);
    	}
    	catch (Exception e)
    	{
        	e.printStackTrace ();
    	}
	}

// instance variables here

public void run (String[] args) throws Exception
{
    if (args.length != 2) 
		{
			System.out.println("Please input 2 arguments only.");
		}
		else
		{
			String s = args[0];
			String s2 = args[1];
			switch (s) 
			{
				case "vowel" :	System.out.println(vowelCount(s2)); break;
				case "alphabet" : System.out.println(alphabetCount(s2)); break;
				case "digit" : System.out.println(digitCount(s2)); break;
				case "lowercase" : System.out.println(lowercaseCount(s2)); break;
				case "uppercase" :	System.out.println(uppercaseCount(s2)); break;
				default : System.out.println("Wrong input in 1st arguement."); break;
			}
		}
	}
}