/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sjf;

import java.io.BufferedReader;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author hp
 */
public class Sjf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
    
      Scanner input = new Scanner(System.in);
        int numprocess,burst,arrival,context;
        String name;
        SJFScheduling z=new SJFScheduling();
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
         z.setProcesses(x1);

        }
        
        System.out.println("Enter the context switch of process");
        context=input.nextInt();
        z.setContextSwitching(context);
 
        z.print();
        z.cpu();
    // TODO code application logic here
    }
    
}
