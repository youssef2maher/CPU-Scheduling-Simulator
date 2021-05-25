/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priority;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class priorityschedualing {
    private int curtime;
    private int aging;
        private ArrayList <Process> array = new ArrayList <Process>();
        priorityschedualing()
        {
        aging=5;
        curtime=0;
        }
        public Process getProcesses(int i) 
        {
		return array.get(i);
	}
	
	public void setProcesses(Process p) 
        {
		array.add(p);
	}
        
       public void print ()
        {
            for(int i=0; i<array.size();i++)
            {
                System.out.println("Name"+array.get(i).getName()+"Arrival Time"+ array.get(i).getArrivalTime()+"brust"+array.get(i).getBurstTime()+"p num"+array.get(i).getprioritynum());
            
            
            }
        
        }
       public void sortProcesses() 
        {
		
		array.sort((o1, o2)-> o1.getArrivalTime().compareTo(o2.getArrivalTime())); 
                
	}
        public void cpu()
        {
            sortProcesses();
            ArrayList <Process> array2 = new ArrayList <Process>();
            ArrayList <Integer> bursttime = new ArrayList <Integer>();

            for(int i=0; i<array.size(); i++)
            {
                bursttime.add(array.get(i).getBurstTime());
                array2.add(array.get(i));

            
            }
            int x=0;
            int temp=array.get(0).getprioritynum();
            int temp2=array.get(0).getArrivalTime();
            for(int i=1; i<array.size(); i++)
            {
               if(array.get(i).getArrivalTime() == temp2)
               {
                   if(array.get(i).getprioritynum()<temp)
                   {
                       x=i;
                       temp=array.get(i).getprioritynum();
                   
                   }   
                   
               }
            }
               boolean cout=true;
            curtime=array.get(x).getArrivalTime();
            System.out.println("Processess execution order");
        System.out.println("--------------------start-------------------------");
            while (!array.isEmpty())
            {
                //starvation problem
                    if(curtime>aging)
                        
            {
                
            for(int i=0; i<array.size(); i++)
            {
              //  System.out.println(" prio"+array.get(i).getprioritynum());
            if(array.get(i).getArrivalTime() <= curtime)
            {
            if(array.get(i).getprioritynum()!=1)
            {
                if(curtime-array.get(i).getArrivalTime()>=aging)
            array.get(i).setprioritynum(array.get(i).getprioritynum()-1);
            }
            
            }
            }
            aging+=5;
            }
                    
                if(cout==true)
                {
                    System.out.print("startTime: "+curtime+"   "+array.get(x).getName());
                
                }
            cout=false;
            array.get(x).setBurstTime(array.get(x).getBurstTime()-1);
            curtime++;
            if(array.get(x).getBurstTime()!=0)
            {
            for(int i=0; i<array.size(); i++)
            {
                if (i!= x)
                {
               if(array.get(i).getArrivalTime() <= curtime)
               {
                   if(array.get(x).getprioritynum()> array.get(i).getprioritynum())
                   {
                       x=i;
                       cout=true;
                   }
                   
               }
                }
            }
            }
            if(array.get(x).getBurstTime()==0)
            {
                for(int r=0;r<array2.size();r++)
             {
             if(array.get(x).getName()==array2.get(r).getName())
             {
               // System.out.println("r= "+r);
             array2.get(r).setCompletionTime(curtime-array2.get(r).getArrivalTime());
             array2.get(r).setWaitingTime(curtime-array2.get(r).getArrivalTime()-bursttime.get(r));
             }
             }
              //  System.out.println("the current time is "+curtime+"arraival  "+array2.get(x).getArrivalTime()+"burst "+ bursttime.get(x) );
                array.remove(x);
                cout=true;
                
                for(int i=0; i<array.size(); i++)
            {
                
                
               if(array.get(i).getArrivalTime() <= curtime)
               {
                   
                       x=i;
                       cout=true;
                   break;
                   
               }
                
            }
                
                 for(int i=0; i<array.size(); i++)
            {
                
                
               if(array.get(i).getArrivalTime() <= curtime)
               {
                   if(array.get(x).getprioritynum()> array.get(i).getprioritynum())
                   {
                       x=i;
                       cout=true;
                   }
                   
               }
                
            }

            }
            if(cout==true)
                {
                    System.out.println("   endTime: "+curtime);
                
                }
        
            }
            System.out.println("--------------------finsh-------------------------");
            int avewaiting=0;
            int aveturn=0;
        for(int i=0; i<array2.size();i++)
        {
            System.out.println("WaitingTime Is: "+ array2.get(i).getWaitingTime()+" turnaroundTime Is: "+ array2.get(i).getCompletionTime()+"    for"+array2.get(i).getName());
            //System.out.println("The complete Time Is: "+ array2.get(i).getCompletionTime());
             avewaiting+=array2.get(i).getWaitingTime();
             aveturn+=array2.get(i).getCompletionTime();
        
        }
        //double result=(double)avewaiting/array2.size();
         //System.out.println("ave waitning: "+avewaiting+"size"+array2.size());
        System.out.println("ave waitning time: "+(double)avewaiting/array2.size());
        System.out.println("ave turnariund time: "+(double)(aveturn/array2.size()));

        }

    
}
