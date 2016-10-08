package com.devil.designmodel.prototype.deep;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PSP implements Cloneable, Serializable {
	private static final long serialVersionUID = 6401635201114419015L;
	private String color;
	private double price;
	private Account account;
	private int ram;

	@Override
	protected Object clone() {
		PSP psp = null;
		try {
			// 将对象写到流里
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos;
			oos = new ObjectOutputStream(bos);
			oos.writeObject(this);

			// 从流里读回来
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bis);
			psp = (PSP) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
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
