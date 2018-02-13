public class Taxi
{
 private int numMember;
 private int numGroup;
 private float income;
 private float distanceMeter;
 private float timeMeter;
 private int meter;
 private int lastMeter;
 public CustomerGroup[] customerGroup = new CustomerGroup[4];

 public Taxi()
 {
  this.numMember = 0;
  this.meter = 0;
  this.numGroup = 0;
  this.income = 0;
  this.distanceMeter = 0;
  this.timeMeter = 0;
  this.lastMeter = 0;
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

 public int getMeter()
 {
  return this.meter;
 }

 public float getDistanceMeter()
 {
  return this.distanceMeter;
 }

  public float getTimeMeter()
 {
  return this.timeMeter;
 }

 public void setMeter(int meter)
 {
  this.meter = meter;
 }
 
 public void receiveCustomer(int numPerson)
 {
  this.customerGroup[this.numGroup] = new CustomerGroup(numPerson,this.numGroup);
  this.numGroup++;
  this.numMember+=numPerson;
 }

 public void drive(float distance,float time)
 {
  this.distanceMeter += distance;
  this.timeMeter += time;
  float tmp = 0;
  float distanceFee = this.distanceMeter;
  float totalDistanceFee = 0;
  float[] level = {1f,1f,10f,20f,40f,60f,80f};
  float[] mul = {5.5f,6.5f,7.5f,8f,9f,10.5f};
  if(distanceFee>0)
    totalDistanceFee = 35;
  for(int i=6;i>=0&&distanceFee>0;i--)
  {
      tmp = distanceFee - level[i];
      if(tmp>0)
      {
        totalDistanceFee += tmp*mul[i-1];
        distanceFee = level[i];
      }
  }
  int ans = (int) Math.round(totalDistanceFee);
  ans = ans + (1-ans%2);

  int ans2 = (int) this.timeMeter;
  ans2 = ans2*2;

  this.meter = ans + ans2;

 int i;
 for (i=0;i<this.numGroup ; i++) 
 {
  this.customerGroup[i].setDistance(this.customerGroup[i].getDistance()+distance); 
 }
 }
 
 public void checkbill(int groupId)
 {
  float[] resultMeter = new float[this.numGroup];
  resultMeter[0] = (float)this.meter - (float)this.lastMeter;
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
   float oldFees = (float)this.customerGroup[i].getFees();
   this.customerGroup[i].setFees((int)Math.ceil(newFees+oldFees));
   share += resultMeter[i]*1/(i+2);
  }
  float newFees = resultMeter[i]-share;
  float oldFees = (float)this.customerGroup[0].getFees();
  this.customerGroup[0].setFees((int)Math.ceil(newFees+oldFees));

  this.income += (float)this.customerGroup[groupId-1].getFees();
  this.numMember -= this.customerGroup[groupId-1].getNumMember();

  for(i=groupId-1;i<this.numGroup-1;i++)
  {
   this.customerGroup[i] = this.customerGroup[i+1];
  }
   this.customerGroup[i] = null;

  this.numGroup--;

  if(this.numGroup==0)
    this.meter = 0;
  this.lastMeter = this.meter;
 }
}