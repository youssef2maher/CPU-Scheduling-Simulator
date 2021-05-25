package Scheduling_Package;

public class Process {

	
	private String name;
	private int burstTime;
	private int remainingTime;
	private Integer arrivalTime;
	private int waitingTime;
	private int completionTime;
	private int turnarroundTime;
	
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
	
	public int getRemainingTime() {
		return remainingTime;
	}
	
	public void setRemainingTime(int remainingTime) {
		this.remainingTime = remainingTime;
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
	
	public int getTurnarroundTime() {
		return turnarroundTime;
	}
	
	public void setTurnarroundTime(int turnarroundTime) {
		this.turnarroundTime = turnarroundTime;
	}
	
	
	
	
	public void clacWaitingTime() {
		waitingTime = completionTime - arrivalTime - burstTime;
	}
	
	
	
	
	public void calcTurnarroundTime() {
		turnarroundTime = waitingTime + burstTime;
	}
	
	
	
	
}
