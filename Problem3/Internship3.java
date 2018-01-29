import java.io.*;
import java.util.Random;

public class Internship3
{

	public String input()
	{
		try
		 	{
		 		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		 		String s = bufferRead.readLine();	
		 		return s;	
		 	}
		 	catch(IOException e)
		 	{
		 		e.printStackTrace();
		 	}	
		 	return "";
	}

	public void findCustomers(Taxi taxi)
	{
		System.out.printf("\nCustomers List(%d persons on taxi)\n",taxi.getNumMember());
		Random rand = new Random();
		int i;
		int[] numMembers = new int[3];
		float[] distance = new float[3];
		for (i=0; i<3; i++) 
		{
			numMembers[i] = rand.nextInt(3)+1;
			distance[i] = rand.nextFloat()*1.5f;
			System.out.printf((i+1) + ". numMembers : " + numMembers[i] + ", distance : " + "%.2f" + " km\n",distance[i]);
		}
		System.out.printf("\nChoose 1-3 to receive customers or 4 for continue driving : ");
		String s = input();
		if(s.charAt(0)>='1'&&s.charAt(0)<='3')
		{
			int choose = Integer.parseInt(s)-1;
			if(numMembers[choose] + taxi.getNumMember() > 4)
			{
				System.out.println("Exceed member");
				return;
			}
			taxi.receiveCustomer(numMembers[choose]);
			System.out.printf("Continue Driving : %.2f km ..\n",distance[choose]);
			taxi.drive(distance[choose]);
			System.out.printf("Customers " + s +" received\n");
		}

	}

	public void drive(Taxi taxi)
	{
		System.out.printf("\nEnter distance to drive (km) : ");
		String s = input();
		float distance = Float.parseFloat(s);
		taxi.drive(distance);
		System.out.printf("Drove %.2f km\n",taxi.getMeter());
		int i;
		for (i=0;i<taxi.getNumGroup() ; i++) 
		{
			System.out.printf("Customer's %d distance : %.2f\n",i+1,taxi.customerGroup[i].getDistance());
		}
	}

	public void checkBill(Taxi taxi)
	{
		float oldIncome = taxi.getIncome();
		System.out.printf("\nEnter number of checkbill group form %d groups : ",taxi.getNumGroup());
		String s = input();
		int groupId = Integer.parseInt(s);
		if(groupId<=taxi.getNumGroup())
		{
			taxi.checkbill(groupId);
			int i;
			for (i=0; i<taxi.getNumGroup()&&taxi.customerGroup[i]!=null;i++ ) 
			{
				System.out.printf("Group"+(i+1)+"'s total Fees : %.2f Baht\n",taxi.customerGroup[i].getFees());	
			}
			System.out.printf("Got income : %.2f (total : %.2f)\n",taxi.getIncome()-oldIncome,taxi.getIncome());
		}
		else
			System.out.println("Don't have that group");
		
	}

	public static void main(String[] args) 
	{
		try
		{
			Internship3 obj = new Internship3();
			obj.run(args);
		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void run(String[] args) throws Exception
	{
		 Taxi taxi = new Taxi();
		 while(true)
		 {

		 	System.out.printf("\nPlease Select What You Want To Do : \n");
		 	System.out.println("1. Find Customers");
		 	System.out.println("2. Continue Driving");
		 	if(taxi.getNumGroup()!=0)
		 		System.out.println("3. Check Bill");
		 	System.out.println("any. Exit");

		 	String s = input();

		 	switch(s)
		 	{
		 		case "1" :	findCustomers(taxi);
		 		case "2" :  drive(taxi); break;
		 		case "3" :  checkBill(taxi); break;
		 		default : return;
		 	}
		 	

		 }

	}
}

