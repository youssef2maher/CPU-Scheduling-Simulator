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
public class fcfs {
    private ArrayList<Process>AllProcess=new ArrayList<Process>();
   private int currenttime = 0;
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
            sortProcesses() ;
            currenttime=AllProcess.get(0).getArrivalTime();
        for(int i=0;i<AllProcess.size();i++)
        {
           System.out.println("starttime"+currenttime+" name"+ AllProcess.get(i).getName());
          currenttime+=AllProcess.get(i).getBurstTime();
          
          AllProcess.get(i).setWaitingTime(currenttime-AllProcess.get(i).getArrivalTime()-AllProcess.get(i).getBurstTime());
          AllProcess.get(i).setCompletionTime(currenttime);
          System.out.println("endtime"+currenttime);
        
        }
        for(int i=0;i<AllProcess.size();i++)
        
        {
         System.out.println("waiting"+AllProcess.get(i).getWaitingTime());
        }
        
        }
        
        
    
}
