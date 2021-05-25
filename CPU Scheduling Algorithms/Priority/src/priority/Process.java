/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priority;

/**
 *
 * @author admin
 */
public class Process {
    
    private String name;
    private int burstTime;
    private Integer arrivalTime;
    private int waitingTime;
    private int completionTime;
    private int prioritynum;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getBurstTime() {
        return burstTime;
    }
    
    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }
    
    public Integer getArrivalTime() {
        return arrivalTime;
    }
    
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    
    public int getWaitingTime() {
        return waitingTime;
    }
    
    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }
    
    public int getCompletionTime() {
        return completionTime;
    }
    
    public void setCompletionTime(int completionTime) {
        this.completionTime = completionTime;
    }
    
    
    public int getprioritynum() {
        return prioritynum;
    }
    
    public void setprioritynum(int prioritynum) {
        this.prioritynum = prioritynum;
    }
    
    
    public void clacWaitingTime() {
        waitingTime = completionTime - arrivalTime - burstTime;
    }
    
    
    
    
}
