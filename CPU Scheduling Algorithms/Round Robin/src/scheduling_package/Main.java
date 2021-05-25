package Scheduling_Package;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RoundRobin rr = new RoundRobin();
		Scanner input = new Scanner(System.in);
		
		System.out.print("Number of Processes -> ");
		int numberOfProcesses = input.nextInt();
		
		for (int i = 0; i < numberOfProcesses; i++) {
			
			Process p = new Process();
			
			System.out.print("The Name of the Proccess -> ");
                        Scanner inputs = new Scanner(System.in);
			String name = inputs.nextLine();
		p.setName(name);
			
			System.out.print("Burst Time -> ");
			int burstTime = input.nextInt();
			p.setBurstTime(burstTime);
                        p.setRemainingTime(burstTime);
			
			System.out.print("Arrival Time -> ");
			int arrivalTime = input.nextInt();
			p.setArrivalTime(arrivalTime);
		
			rr.setProcesses(p);
		}
		
		System.out.print("Context Switching -> ");
		int contextSwitching = input.nextInt();
                rr.setContextSwitching(contextSwitching);
		
		System.out.println("Round Robin Time Quantum");
		int timeQuantum = input.nextInt();
	rr.setTimeQuantum(timeQuantum);
		
		
		
//		Process p1 = new Process();
//		p1.setName("p1");
//		p1.setArrivalTime(0);
//		p1.setBurstTime(3);
//		p1.setRemainingTime(3);
//		
//		Process p2 = new Process();
//		p2.setName("p2");
//		p2.setArrivalTime(2);
//		p2.setBurstTime(5);
//		p2.setRemainingTime(5);
//		
//		Process p3 = new Process();
//		p3.setName("p3");
//		p3.setArrivalTime(1);
//		p3.setBurstTime(4);
//		p3.setRemainingTime(4);
//		
//		Process p4 = new Process();
//		p4.setName("p4");
//		p4.setArrivalTime(4);
//		p4.setBurstTime(2);
//		p4.setRemainingTime(2);
//		
//		Process p5 = new Process();
//		p5.setName("p5");
//		p5.setArrivalTime(6);
//		p5.setBurstTime(9);
//		p5.setRemainingTime(9);
//		
//		Process p6 = new Process();
//		p6.setName("p6");
//		p6.setArrivalTime(5);
//		p6.setBurstTime(4);
//		p6.setRemainingTime(4);
//		
//		Process p7 = new Process();
//		p7.setName("p7");
//		p7.setArrivalTime(7);
//		p7.setBurstTime(10);
//		p7.setRemainingTime(10);
//		
//		
//		
//		
//		rr.setProcesses(p1);
//		rr.setProcesses(p2);
//		rr.setProcesses(p3);
//		rr.setProcesses(p4);
//		rr.setProcesses(p5);
//		rr.setProcesses(p6);
//		rr.setProcesses(p7);
//		
//
        rr.cpu();
	rr.printData();
		
		
		
		
		/*MultiLevel ml = new MultiLevel();
		
		Process p1 = new Process();
		p1.setName("p1");
		p1.setArrivalTime(0);
		p1.setBurstTime(4);
		p1.setRemainingTime(4);
		ml.setFirstQueue(p1);
		
		
		
		Process p2 = new Process();
		p2.setName("p2");
		p2.setArrivalTime(0);
		p2.setBurstTime(3);
		p2.setRemainingTime(3);
		ml.setFirstQueue(p2);
		
		
		
		Process p3 = new Process();
		p3.setName("p3");
		p3.setArrivalTime(0);
		p3.setBurstTime(8);
		p3.setRemainingTime(8);
		ml.setSecondQueue(p3);
		
		
		
		Process p4 = new Process();
		p4.setName("p4");
		p4.setArrivalTime(10);
		p4.setBurstTime(5);
		p4.setRemainingTime(5);
		ml.setFirstQueue(p4);
		
		
		ml.cpu();*/

	}

}
