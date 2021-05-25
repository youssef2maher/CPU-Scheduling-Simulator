package Scheduling_Package;

import java.util.ArrayList;

public class RoundRobin {

	private ArrayList<Process> processes = new ArrayList<Process>();
	private ArrayList<Process> processesBackup = new ArrayList<Process>();
	private int timeQuantum = 2;
	private int contextSwitching = 1;
	private int time = 0;
	
	public int getTimeQuantum() {
		return timeQuantum;
	}
	
	public void setTimeQuantum(int timeQuantum) {
		this.timeQuantum = timeQuantum;
	}
	
	public int getContextSwitching() {
		return contextSwitching;
	}
	
	public void setContextSwitching(int contextSwitching) {
		this.contextSwitching = contextSwitching;
	}
	
	public Process getProcesses(int i) {
		return processes.get(i);
	}
	
	public void setProcesses(Process p) {
		processes.add(p);
	}
	
	public void removeProcess(int i) {
		processes.remove(i);
	}
	
	public boolean isEmpty() {
		return processes.isEmpty();
	}
	
	public int getSize() {
		return processes.size();
	}
	
	
	
	
	public void backup() {
		
		for (int i = 0; i < processes.size(); i++) {
			processesBackup.add(processes.get(i));
		}
	}
	
	
	
	
	public void sortProcesses() {
		
		processes.sort((o1, o2) 
                -> o1.getArrivalTime().compareTo( 
                    o2.getArrivalTime())); 
		
//		for (int i = 0; i < processes.size(); i++) {
//			System.out.println(processes.get(i).getName() + " " + processes.get(i).getArrivalTime());
//		}
	}
	
	
	
	
	
	public void cpu() {
		
		sortProcesses();
		backup();
		
		System.out.println("-------------------------- Start --------------------------");
		
		int i = 0;
		while(!processes.isEmpty()) {

			
			if (processes.get(i).getArrivalTime() <= time) {
				
				int processRemainingTime = processes.get(i).getRemainingTime();
				
				if (processRemainingTime > timeQuantum) {
					
					System.out.print("starttime: " + time);
					System.out.print("	" + processes.get(i).getName());
//					System.out.println("Burst Time - > " + processes.get(i).getBurstTime());
//					System.out.println("Remaining Time - > " + processes.get(i).getRemainingTime());
//					System.out.println("Arrival Time - > " + processes.get(i).getArrivalTime());
//					System.out.println("Completion Time - > " + processes.get(i).getCompletionTime());
//					System.out.println("Turnarround Time - > " + processes.get(i).getTurnarroundTime());
//					System.out.println("Waiting Time - > " + processes.get(i).getWaitingTime());
//					System.out.println("");
					
					
					processes.get(i).setRemainingTime(processRemainingTime - timeQuantum);
					time += (timeQuantum);
					
				
					System.out.print("	   endtime: " + time);
					System.out.println("	" + processes.get(i).getName());
					System.out.println("contextswitch taking time ... " + contextSwitching + "   From: " + time + " To: " + (contextSwitching + time));
					
//					System.out.println("Burst Time - > " + processes.get(i).getBurstTime());
//					System.out.println("Remaining Time - > " + processes.get(i).getRemainingTime());
//					System.out.println("Arrival Time - > " + processes.get(i).getArrivalTime());
//					System.out.println("Completion Time - > " + processes.get(i).getCompletionTime());
//					System.out.println("Turnarround Time - > " + processes.get(i).getTurnarroundTime());
//					System.out.println("Waiting Time - > " + processes.get(i).getWaitingTime());
//					System.out.println("\n\n");
//					
					time += (contextSwitching);
					
					if (i < processes.size()-1) {
						
						if (processes.get(i+1).getArrivalTime() <= time) {
							i++;
						}
						
					} else {
						i = 0;
					}
				}
				
				else {
					
					System.out.print("starttime: " + time);
					System.out.print("	" + processes.get(i).getName());
//					System.out.println("Burst Time - > " + processes.get(i).getBurstTime());
//					System.out.println("Remaining Time - > " + processes.get(i).getRemainingTime());
//					System.out.println("Arrival Time - > " + processes.get(i).getArrivalTime());
//					System.out.println("Completion Time - > " + processes.get(i).getCompletionTime());
//					System.out.println("Turnarround Time - > " + processes.get(i).getTurnarroundTime());
//					System.out.println("Waiting Time - > " + processes.get(i).getWaitingTime());
//					System.out.println("");
					
					
					processes.get(i).setRemainingTime(0);
					time += (processRemainingTime);
					processes.get(i).setCompletionTime(time);
					processes.get(i).clacWaitingTime();
					processes.get(i).calcTurnarroundTime();
					
					System.out.print("	   endtime: " + time);
					System.out.println("	" + processes.get(i).getName());
					System.out.println("contextswitch taking time ... " + contextSwitching + "   From: " + time + " To: " + (contextSwitching + time));
//					System.out.println("Remaining Time - > " + processes.get(i).getRemainingTime());
//					System.out.println("Arrival Time - > " + processes.get(i).getArrivalTime());
//					System.out.println("Completion Time - > " + processes.get(i).getCompletionTime());
//					System.out.println("Turnarround Time - > " + processes.get(i).getTurnarroundTime());
//					System.out.println("Waiting Time - > " + processes.get(i).getWaitingTime());
//					System.out.println("\n\n");
					
					time += (contextSwitching);
					processes.remove(i);
					
					if (i > processes.size()-1) {
						i = 0;
					}
					
				}
				
			} else {
				time++;
			}
			

			
			
//			for (int j = 0; j < 1000000000; j++) {
//				for (int j2 = 0; j2 < 1000000000; j2++) {
//					
//				}
//			}
		}
		
		System.out.println("-------------------------- Finish --------------------------");
	}
	
	
	
	
	
	public void printData() {
		
		int sumTurnarroundTime = 0;
		int sumWaitingTime = 0;
		
		System.out.println("--------------------------  Data  --------------------------");
		for (int i = 0; i < processesBackup.size(); i++) {
			
			System.out.println("Process " + processesBackup.get(i).getName() 
								+ "		" + "Turnarround Time: " + processesBackup.get(i).getTurnarroundTime() 
								+ "		" + "Waiting Time: " + processesBackup.get(i).getWaitingTime());
			sumTurnarroundTime += processesBackup.get(i).getTurnarroundTime();
			sumWaitingTime += processesBackup.get(i).getWaitingTime();
		}
		System.out.println("----------------------------------------------------------");
		System.out.println("Avg Turnarround Time: " +(double) sumTurnarroundTime/processesBackup.size() 
						+ "	Avg Waiting Time: " +(double) sumWaitingTime/processesBackup.size());
	}
	
	
	
	
	
	public void print1() {
		
		
		for (int i = 0; i < processes.size(); i++) {
			System.out.println("B: " + processes.get(i).getName() 
					+ " " + processes.get(i).getArrivalTime()
					+ " " + processes.get(i).getCompletionTime() 
					+ " " + processes.get(i).getWaitingTime()
					+ " " + processes.get(i).getRemainingTime());
		}
		
		
	}
	
	
	
	
}