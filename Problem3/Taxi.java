public class Taxi
{
	private int numMember;
	private int numGroup;
	private float meter;
	private float income;
	public CustomerGroup[] customerGroup = new CustomerGroup[4];

	public Taxi()
	{
		this.numMember = 0;
		this.meter = 0;
		this.numGroup = 0;
		this.income = 0;
	}	

	public int getNumMember()
	{
		return this.numMember;
	}

	public void setNumMember(int numMember)
	{
		this.numMember = numMember;
	}

	public int getNumGroup()
	{
		return this.numGroup;
	}

	public float getIncome()
	{
		return this.income;
	}

	public float getMeter()
	{
		return this.meter;
	}

	public void setMeter(float meter)
	{
		this.meter = meter;
	}

	public void receiveCustomer(int numPerson)
	{
		this.customerGroup[numGroup] = new CustomerGroup(numPerson,this.numGroup);
		this.numGroup++;
		this.numMember+=numPerson;
	}

	public void drive(float distance)
	{
		this.meter += distance;
		int i;
		for (i=0;i<this.numGroup ; i++) 
		{
			this.customerGroup[i].setDistance(this.customerGroup[i].getDistance()+distance);	
		}
	}

	public void checkbill(int groupId)
	{
		float[] resultMeter = new float[this.numGroup];
		resultMeter[0] = this.meter - this.customerGroup[0].getLastMeter();
		int i;
		for (i=1; i<this.numGroup;i++ ) 
		{
			float distanceRatio = this.customerGroup[i].getDistance()/this.customerGroup[0].getDistance();
			resultMeter[i] = resultMeter[0]*distanceRatio;
		}
		float share = 0;
		for(i=this.numGroup-1;i>0;i--)
		{
			float newFees = resultMeter[i]*(i+1)/(i+2)-share;
			float oldFees = this.customerGroup[i].getFees();
			this.customerGroup[i].setFees(newFees+oldFees);
			share += resultMeter[i]*1/(i+2);
		}
		float newFees = resultMeter[i]-share;
		float oldFees = this.customerGroup[0].getFees();
		this.customerGroup[0].setFees(newFees+oldFees);

		this.income += this.customerGroup[groupId-1].getFees();
		this.numMember -= this.customerGroup[groupId-1].getNumMember();

		for(i=groupId-1;i<this.numGroup-1;i++)
		{
			this.customerGroup[i] = this.customerGroup[i+1];
		}
			this.customerGroup[i] = null;
		if(this.customerGroup[0]!=null)
		this.customerGroup[0].setLastMeter(this.meter);

		this.numGroup--;
	}
}