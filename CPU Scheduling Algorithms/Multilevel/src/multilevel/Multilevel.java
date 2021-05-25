/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multilevel;

import java.util.Scanner;

/**
 *
 * @author hp
 */
public class Multilevel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        int numprocess,burst,arrival,numofqueue,rrround;
        String name;
        Mlscheduling z=new Mlscheduling();
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
          System.out.println("Enter num queue of process");
         numofqueue=input.nextInt();
         x1.setqeueuenumber(numofqueue);
         z.setProcesses(x1);

        }
         System.out.println("Round robin Time Quantum");
         rrround=input.nextInt();
         z.setquantmtime(rrround);
         z.cpu();
       
  //z.print();
        // TODO code application logic here
    }
    
}
