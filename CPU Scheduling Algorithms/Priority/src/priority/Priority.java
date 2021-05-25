/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priority;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Priority {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int numprocess,burst,arrival,priority;
        String name;
        priorityschedualing z=new priorityschedualing();
        System.out.println("Enter number of process");
        numprocess=input.nextInt();
        for(int i=0;i<numprocess;i++)
        {
           Process x1=new Process();
         System.out.println("Enter name of process");
         Scanner input1 = new Scanner(System.in);
         name=input1.nextLine();
         x1.setName(name);
         System.out.println("Enter Arrival time of process");
        
         arrival=input.nextInt();
         x1.setArrivalTime(arrival);
         System.out.println("Enter Brust time of process");
         burst=input.nextInt();
         x1.setBurstTime(burst);
          System.out.println("Enter priority of process");
         priority=input.nextInt();
         x1.setprioritynum(priority);
         z.setProcesses(x1);

        }
        
       
         z.cpu();
       /* Process o1=new Process();
        Process o2=new Process();
        Process o3=new Process();
        Process o4=new Process();
        Process o5=new Process();
        priorityschedualing o6=new priorityschedualing();
        o1.setName("p1");
        o2.setName("p2");
        o3.setName("p3");
        o4.setName("p4");
        o5.setName("p5");
        o1.setArrivalTime(0);
        o2.setArrivalTime(0);
        o3.setArrivalTime(0);
        o4.setArrivalTime(0);
        o5.setArrivalTime(0);
        o1.setprioritynum(3);
        o2.setprioritynum(1);
        o3.setprioritynum(4);
o4.setprioritynum(5);
o5.setprioritynum(2);
o1.setBurstTime(10);
o2.setBurstTime(1);
o3.setBurstTime(2);
o4.setBurstTime(1);
o5.setBurstTime(5);

          o6.setProcesses(o1);
          o6.setProcesses(o2);
          o6.setProcesses(o3);
          o6.setProcesses(o4);
          o6.setProcesses(o5);
          
          o6.cpu();*/
//o6.print();

        
    }
    
}
