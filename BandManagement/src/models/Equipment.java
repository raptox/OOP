package models;

import java.io.Serializable;
import java.util.Date;

public class Equipment implements Costs, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double credits;
	private Date buyDate;
	private String name;
	
	/*
	 * Konstruktor
	 * Vorb.:name!=null, buyDate!=null, credits!=null
	 */
	public Equipment(String name,Date buyDate,double credits){
		this.name=name;
		this.credits=credits;
		this.buyDate = buyDate;
	}
	/*
	 * Liefert credits zurueck
	 */
	public double getCredits(){
		return credits;
	}
	/*
	 * Liefert das buyDate zurueck
	 */
	public Date getBuyDate(){
		return buyDate;
	}
	/*
	 * Ueberschreibt die toString Methode und liefert den Namen des Equipments zurueck
	 */
	public String toString(){
		return name;
	}

}
