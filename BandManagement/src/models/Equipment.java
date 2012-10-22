package models;

import java.util.Date;

public class Equipment implements Costs{
	private double credits;
	private Date buyDate;
	private String name;
	
	public Equipment(String name,Date buyDate,double credits){
		this.name=name;
		this.credits=credits;
		this.buyDate = buyDate;
	}
	public double getCredits(){
		return credits;
	}
	public Date getBuyDate(){
		return buyDate;
	}
	public String toString(){
		return name;
	}

}
