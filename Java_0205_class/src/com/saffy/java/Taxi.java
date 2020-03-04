package com.saffy.java;

public class Taxi extends Car{
	private int price;
	private int totalprice;
	
	public Taxi(String carName, String calColor, String maker, int speed, int price, int totalprice) {
		super(carName, calColor, maker, speed);
		//this.carName= carName;
		this.price = price;
		this.totalprice = totalprice;
	}
	
	public int carPrice(int km) {
		initPrice();
		price += km*100;
		totalprice();
		return price;
	}
	
	private void totalprice() {
		totalprice += price;
	}
	
	private void initPrice() {
		price = 3300;
	}

	@Override
	public String toString() {
		return super.toString() + " >>>> 택시";
	}
	
	@Override
	public int speedUp(int speed) {
		int sp = super.speedUp(speed);
		if(sp>170) 
			setSpeed(170);
		return getSpeed();
	}
	
	public void isCar() {
		System.out.println(">>택시입니다.");
	}
	
}
