/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multilevel;

import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class Mlscheduling {
     private int rrtimequantam;
     private ArrayList<Process>queue1=new ArrayList<Process>();
     private ArrayList<Process>queue2=new ArrayList<Process>();
     private int currenttime;
     public void setProcesses(Process p) 
        {
		if(p.getqueuenumber()==1)
                    queue1.add(p);
                else
                    queue2.add(p);
	}
     public void setquantmtime(int q)
     {
     
     rrtimequantam=q;
     
     }
     public int getquantmtime()
     {
     return rrtimequantam;
     }
     public void sortProcesses() 
        {
		
		queue1.sort((o1, o2)-> o1.getArrivalTime().compareTo(o2.getArrivalTime())); 
                queue2.sort((o1, o2)-> o1.getArrivalTime().compareTo(o2.getArrivalTime())); 
                
	}
     void cpu()
  { 
      ArrayList<Process>copyqueueONE=new ArrayList<Process>();
      ArrayList<Process>copyqueueTWO=new ArrayList<Process>();
      ArrayList<Integer>burstONE=new ArrayList<Integer>();
      ArrayList<Integer>burstTWO=new ArrayList<Integer>();
      for(int c=0;c<queue1.size();c++)
      {
      copyqueueONE.add(queue1.get(c));
      burstONE.add(queue1.get(c).getBurstTime());
      }
      
          for(int c=0;c<queue2.size();c++)
      {
      copyqueueTWO.add(queue2.get(c));
      burstTWO.add(queue2.get(c).getBurstTime());
      }
      
     if(queue2.get(0).getArrivalTime()<queue1.get(0).getArrivalTime())
     currenttime=queue2.get(0).getArrivalTime();
     else
         currenttime=queue1.get(0).getArrivalTime();
        boolean empty=false;
        boolean cout1=true;
        boolean cout2=true;
        System.out.println("Processess execution order");
        System.out.println("--------------------start-------------------------");
     while(!queue1.isEmpty()||!queue2.isEmpty())
     {
         // System.out.println("while");
         if(!queue1.isEmpty())
         {
      for(int i=0;i<queue1.size();i++)
      {
          
          if(currenttime>=queue1.get(i).getArrivalTime())
          {
             //System.out.println("check");
              if(cout2==false)
              {
              System.out.println("  endtime "+currenttime);
              cout2=true;
              }
            System.out.print("starttime "+currenttime +"  "+queue1.get(i).getName());  
               //currenttime+=rrtimequantam;
               //System.out.println("burst"+queue1.get(i).getBurstTime());  
               if(rrtimequantam<queue1.get(i).getBurstTime())
               {
               currenttime+=rrtimequantam;
                    queue1.get(i).setBurstTime(queue1.get(i).getBurstTime()-rrtimequantam);
               }
        
               else{
                   currenttime+=queue1.get(i).getBurstTime();
               queue1.get(i).setBurstTime(0);
               }
                   
          if(queue1.get(i).getBurstTime()==0)
          {
              for(int c=0;c<copyqueueONE.size();c++)
              {
              if(copyqueueONE.get(c).getName()==queue1.get(i).getName())
              {
                   copyqueueONE.get(c).setCompletionTime(currenttime-copyqueueONE.get(c).getArrivalTime());
              copyqueueONE.get(c).setWaitingTime(currenttime-copyqueueONE.get(c).getArrivalTime()-burstONE.get(c));
              }
              }
System.out.println("  endtime "+currenttime);
              queue1.remove(i);
              i=-1;
          }
          else
          {
              
                
          queue1.add(queue1.get(i));
          queue1.remove(i);
          i=-1;
          System.out.println("  endtime "+currenttime);
          }
          
          }
          else
          empty=true;
          

      }}
         else
             empty=true;
        // System.out.println("check1");
         if(!queue2.isEmpty())
         {
                 if(currenttime>=queue2.get(0).getArrivalTime()&&empty==true)
                   {
                      if(cout2==true)
                      System.out.print("starttime "+currenttime+"  "+queue2.get(0).getName());
                      //System.out.println("burst p3 :"+queue2.get(0).getBurstTime());
                  currenttime++;
                  queue2.get(0).setBurstTime(queue2.get(0).getBurstTime()-1);
                    if(queue2.get(0).getBurstTime()==0)
                    {
                        for(int c=0;c<copyqueueTWO.size();c++)
              {
              if(copyqueueTWO.get(c).getName()==queue2.get(0).getName())
              {
                   copyqueueTWO.get(c).setCompletionTime(currenttime-copyqueueTWO.get(c).getArrivalTime());
              copyqueueTWO.get(c).setWaitingTime(currenttime-copyqueueTWO.get(c).getArrivalTime()-burstTWO.get(c));
              }
              }
                      //  System.out.println("current remove p3"+currenttime);
                      queue2.remove(0);
                    }
                    cout2=false;
                    // System.out.println("here");
                   }
         }
         
         // System.out.println("heress");
     }
     System.out.println("  endtime "+currenttime);
     System.out.println("--------------------finsh-------------------------");
     int avegwaitingQ1=0;
        int avegturnaroundtimeQ1=0;
     System.out.println("  QUEUE  ONE");
     for(int c=0;c<copyqueueONE.size();c++)
              {
                  avegwaitingQ1+=copyqueueONE.get(c).getWaitingTime();
                  avegturnaroundtimeQ1+=copyqueueONE.get(c).getCompletionTime();
              System.out.println("TURNAROUNDTIME: "+copyqueueONE.get(c).getCompletionTime()+" Waiting time: "+ copyqueueONE.get(c).getWaitingTime()+"  for PROCESS:"+copyqueueONE.get(c).getName());
              }
     double result=(double)(avegwaitingQ1/copyqueueONE.size());
        double result1=(double)( avegturnaroundtimeQ1/copyqueueONE.size());
     System.out.println("AVEGTURNAROUNDTIME: "+  result1+"AvegWaiting time: "+result);
      int avegwaitingQ2=0;
        int avegturnaroundtimeQ2=0;
     System.out.println("  QUEUE  TWO");
     for(int c=0;c<copyqueueTWO.size();c++)
              {
                  avegwaitingQ2+=copyqueueTWO.get(c).getWaitingTime();
                  avegturnaroundtimeQ2+=copyqueueTWO.get(c).getCompletionTime();
              System.out.println("TURNAROUNDTIME: "+copyqueueTWO.get(c).getCompletionTime()+" Waiting time: "+ copyqueueTWO.get(c).getWaitingTime()+"  for PROCESS: "+copyqueueTWO.get(c).getName());
              }
     double resultQ2W=(double)(avegwaitingQ2/copyqueueTWO.size());
        double resultQ2T=(double)( avegturnaroundtimeQ2/copyqueueTWO.size());
         System.out.println("AVEGTURNAROUNDTIME: "+  resultQ2T+"AvegWaiting time: "+resultQ2W);
  }
       public void print() {
		sortProcesses();
		for (int i = 0; i < queue1.size(); i++) {
			System.out.println(queue1.get(i).getName() 
								+ " " + queue1.get(i).getArrivalTime()
								+ " " + queue1.get(i).getBurstTime()
								);
		}
                for (int i = 0; i < queue2.size(); i++) {
			System.out.println(queue2.get(i).getName() 
								+ " " + queue2.get(i).getArrivalTime()
								+ " " + queue2.get(i).getBurstTime()
								);
		}
                System.out.println(rrtimequantam);
	}
    
}
