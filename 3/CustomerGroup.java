public class CustomerGroup
{
 private int numMember;
 private int groupNo;
 private int fees;
private float distance;
private float lastMeter;

 public CustomerGroup(int numMember,int groupNo)
 {
  this.numMember = numMember;
  this.groupNo = groupNo;
 this.lastMeter = 0;
  this.fees = 10;
 this.distance = 0;
 }

 public int getNumMember()
 {
  return this.numMember;
 }
 
 public void setGroupNo(int groupNo)
 {
  this.groupNo = groupNo;
 }

 public int getGroupNo()
 {
  return this.groupNo;
 }

 public void setFees(int fees)
 {
  this.fees = fees;
 }

 public int getFees()
 {
  return this.fees;
 }

public void setDistance(float distance)
{
 this.distance = distance;
}

public float getDistance()
{
 return this.distance;
}

public void setLastMeter(float lastMeter)
{
 this.lastMeter = lastMeter;
}

public float getLastMeter()
{
 return this.lastMeter;
}

}