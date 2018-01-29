#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
int n;
bool prime[1000000];

void delete(int i) 
{
    int index;
    for (index = i+1; index <= n ;index++) 
    {
        if (index % i == 0) 
        {
            prime[index] = false;
        }
    }
}

int main(int argc, char* argv[]) {
  n = atoi(argv[1]);
  
  for(int i=2;i<=n;i++)
  {
      prime[i] = true;
  }
  
  for(int i=2;i<=n; i++)
  {
	if (prime[i]==true) 
	    delete(i);
  }
  
  // โชว์ค่าoutput
  for(int i=2;i<=n;i++) 
  {
	if (prime[i]==true)
	{
	    printf("%d " , i);
	}
  }
	
  return 0;
}