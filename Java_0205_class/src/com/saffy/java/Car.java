package com.saffy.java;

public class Car {
	private String carName;
	private String calColor;
	private String maker;
	private int speed;
	

	public Car () {
		this("SM5", "���", "�Ｚ", 500);
		
	}
	
	public Car(String carName) {
//		this.carName = carName;
		this(carName, "���", "�Ｚ", 300);
	}
	
	public Car(String carName, String calColor, String maker, int speed) {
		super();				//super�� ������??
		this.carName = carName;
		this.calColor = calColor;
		this.maker = maker;
		this.speed = speed;
	}
//	public Car(String carName, String calColor, String maker, int speed) {
//		super();				//super�� ������??
//		this(carName,calColor, maker, speed);	//�־ȵ���?
//	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCalColor() {
		return calColor;
	}

	public void setCalColor(String calColor) {
		this.calColor = calColor;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void speedUp() {
		speed += 10;
	}
	
	public int speedUp(int speed) {
		this.speed += speed;
		return this.speed;
	}
	
	public void speedDown() {
		speed -=10;
		if(speed < 0 )
			stop();
	}
	
	public void stop() {
		speed = 0;
	}

	@Override
	public String toString() {
		return "Car [carName=" + carName + ", calColor=" + calColor + ", maker=" + maker + ", speed=" + speed + "]";
	}
	
	public void isCar() {
		System.out.println(">>> ���Դϴ�.");
	}
	
	
}
