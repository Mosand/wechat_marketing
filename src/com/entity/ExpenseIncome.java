package com.entity;

public class ExpenseIncome {

	private String ym;
	private int YEAR;
	private int MONTH;
	private double income;
	private double expense;
	
	private ExpenseIncome(){
		
	}
	
	private ExpenseIncome(String ym,int YEAR,int MONTH,double income,double expense){
		super();
		this.YEAR = YEAR;
		this.MONTH = MONTH;
		this.income = income;
		this.ym = ym;
		this.expense = expense;
	}

	

	public int getYEAR() {
		return YEAR;
	}

	public void setYEAR(int yEAR) {
		YEAR = yEAR;
	}

	public int getMONTH() {
		return MONTH;
	}

	public void setMONTH(int mONTH) {
		MONTH = mONTH;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public double getExpense() {
		return expense;
	}

	public void setExpense(double expense) {
		this.expense = expense;
	}

	public String getYm() {
		return ym;
	}

	public void setYm(String ym) {
		this.ym = ym;
	}
	
	
}


