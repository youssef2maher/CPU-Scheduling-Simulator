/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sjf;

import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class SJFScheduling {
   private ArrayList<Process>AllProcess=new ArrayList<Process>();
   private int contextSwitching = 0;
   private int currenttime = 0;

	
	
	public int getContextSwitching() 
        {
		return contextSwitching;
	}
	
	public void setContextSwitching(int contextSwitching)
        {
		this.contextSwitching = contextSwitching;
	}
	
	public Process getProcesses(int i) 
        {
		return AllProcess.get(i);
	}
	
	public void setProcesses(Process p) 
        {
		AllProcess.add(p);
	}
        public void sortProcesses() 
        {
		
		AllProcess.sort((o1, o2)-> o1.getArrivalTime().compareTo(o2.getArrivalTime())); 
	}
        
        
        void cpu()
        {
            int gap=0;
            //copy array list
            sortProcesses();
            ArrayList<Process>AllProcess2=new ArrayList<Process>();
            for(int c=0;c<AllProcess.size();c++)
            {
            AllProcess2.add(AllProcess.get(c));
            }
            //copy busrt time 
            ArrayList<Integer>bursttime=new ArrayList<Integer>();
            for(int c=0;c<AllProcess.size();c++)
            {
          bursttime.add(AllProcess.get(c).getBurstTime());
            }
           
        int i=0,j=0;
         currenttime=AllProcess.get(i).getArrivalTime(); 
         for(int c=1;c<AllProcess.size();c++)
            {
                // System.out.println("c"+c);
                if( currenttime==AllProcess.get(c).getArrivalTime() )
                 {
                      if(AllProcess.get(c).getBurstTime()<AllProcess.get(i).getBurstTime())
                         {
                             i=c;
                         }
            
                 }
            }
       
        boolean cout=true;
        System.out.println("Processess execution order");
        System.out.println("--------------------start-------------------------");
        while(!AllProcess.isEmpty())
        {
         
            if(cout==true)
            {
            System.out.print("starttime:"+currenttime+"  "+AllProcess.get(i).getName()+"  ");
            }
             
            cout=false;
            AllProcess.get(i).setBurstTime(AllProcess.get(i).getBurstTime()-1);
            currenttime++;
             
            
        
        
        if(AllProcess.get(i).getBurstTime()!=0)
        {
        for(int c=0;c<AllProcess.size();c++)
        {
           // AllProcess.get(c).setWaitingTime(AllProcess.get(c).getWaitingTime()+1);
            if(i!=c)
            {
                  AllProcess.get(c).setWaitingTime(AllProcess.get(c).getWaitingTime()+1);
            if(currenttime==AllProcess.get(c).getArrivalTime()||currenttime>AllProcess.get(c).getArrivalTime())
             {
                if(AllProcess.get(c).getBurstTime()<AllProcess.get(i).getBurstTime())
                        {
                          i=c;
                          cout=true;
                        }
           
             }
            }
        }
        }
        
         if(AllProcess.get(i).getBurstTime()==0)
         {         
             for(int r=0;r<AllProcess2.size();r++)
             {
             if(AllProcess.get(i).getName()==AllProcess2.get(r).getName())
             {
             AllProcess2.get(r).setCompletionTime(currenttime-AllProcess2.get(r).getArrivalTime());
             AllProcess2.get(r).setWaitingTime(currenttime-AllProcess2.get(r).getArrivalTime()-bursttime.get(r));
             }
             }
             AllProcess.remove(i);
                   for(int c=0;c<AllProcess.size();c++)
          {
             
              if(currenttime==AllProcess.get(c).getArrivalTime()||currenttime>AllProcess.get(c).getArrivalTime())
              {
                i=c;
                cout=true;
                gap=1;
                break;
           
               }
              
             
          }
                  if (AllProcess.size()!=0)
             if(gap==0)
             {
             
             System.out.println("endtime: "+currenttime+" ");
            if(getContextSwitching()!=0)
            System.out.println("contextswitch taking time ...  "+getContextSwitching()+" "+" From:"+currenttime+" To"+(currenttime+getContextSwitching()));
            else
                System.out.println("contextswitch taking time ...  "+getContextSwitching());
            currenttime=AllProcess.get(0).getArrivalTime();
            System.out.print("starttime: "+currenttime+" "+AllProcess.get(i).getName());
             }
             else
             for(int c=0;c<AllProcess.size();c++)
          {
             if(i!=c)
             {
              if(currenttime==AllProcess.get(c).getArrivalTime()||currenttime>AllProcess.get(c).getArrivalTime())
              {
                if(AllProcess.get(c).getBurstTime()<AllProcess.get(i).getBurstTime())
                        {
                          i=c;
                          cout=true;
                        }
           
               }
             }
             
          }
            /* if(gap==0)
             {
             
             System.out.println("endtime: "+currenttime+" ");
            if(getContextSwitching()!=0)
            System.out.println("contextswitch taking time ...  "+getContextSwitching()+" "+" From:"+currenttime+" To"+(currenttime+getContextSwitching()));
            else
                System.out.println("contextswitch taking time ...  "+getContextSwitching());
            currenttime=AllProcess.get(0).getArrivalTime();
             }*/
             
         }
          
           if(cout==true)
            {
            System.out.println("endtime: "+currenttime+" ");
            if(getContextSwitching()!=0)
            System.out.println("contextswitch taking time ...  "+getContextSwitching()+" "+" From:"+currenttime+" To"+(currenttime+getContextSwitching()));
            else
                System.out.println("contextswitch taking time ...  "+getContextSwitching());
            currenttime+=getContextSwitching();
            }
           else if(AllProcess.size()==0)
           {
           System.out.println("endtime:"+currenttime+" ");
            
           }

        
        }
        int avegwaiting=0;
        int avegturnaroundtime=0;
        
        System.out.println("--------------------finsh-------------------------");
        for (int p = 0; p < AllProcess2.size(); p++)
        {
            System.out.println("turnaround time :"+AllProcess2.get(p).getCompletionTime()+"     waiting time:"+AllProcess2.get(p).getWaitingTime()+" for "+AllProcess2.get(p).getName());
            avegwaiting+=AllProcess2.get(p).getWaitingTime();
            avegturnaroundtime+=AllProcess2.get(p).getCompletionTime();
        }
        double result=(double)(avegwaiting/AllProcess2.size());
        double result1=(double)(avegturnaroundtime/AllProcess2.size());
        System.out.println("------------------------");
        System.out.println("avegturnaround time :"+result1+"  avegwaiting time:"+result);

        }
        
        
        
        
        
        
        public void print() {
		sortProcesses();
		for (int i = 0; i < AllProcess.size(); i++) {
			System.out.println(AllProcess.get(i).getName() 
								+ " " + AllProcess.get(i).getArrivalTime()
								+ " " + AllProcess.get(i).getBurstTime()
								);
		}
	}
 
}
