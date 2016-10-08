package com.devil.designmodel.prototype.simple;

public class PSP implements Cloneable {
	private String color;
	private double price;
	private Account account;
	private int ram;

	@Override
	protected Object clone() {
		PSP psp = null;
		try {
			psp = (PSP) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return psp;
	}

	@Override
	public String toString() {
		return color + "," + ram + "," + price + "," + account;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

}
