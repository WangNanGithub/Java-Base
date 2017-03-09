package com.devil.network.inet;

import java.net.*;

public class SpamCheck {

	public static final String BLACKHOLE = "sbl.spamhaus.org";

	public static void main(String[] args) throws UnknownHostException {
		String arg = "130.130.130.130";
		if (isSpammer(arg)) {
			System.out.println(arg + " is a known spammer.");
		} else {
			System.out.println(arg + " appears legitimate.");
		}
	}

	private static boolean isSpammer(String arg) {
		try {
			InetAddress address = InetAddress.getByName(arg);
			byte[] quad = address.getAddress();
			String query = BLACKHOLE;
			for (byte octet : quad) {
				int unsignedByte = octet < 0 ? octet + 256 : octet;
				query = unsignedByte + "." + query;
			}
			InetAddress.getByName(query);
			return true;
		} catch (UnknownHostException e) {
			return false;
		}
	}
}