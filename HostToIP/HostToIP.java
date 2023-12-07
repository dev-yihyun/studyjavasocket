package HostToIP;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostToIP {

	public static void main(String[] args) throws IOException {
		String hostname = "www.google.com";
		try {
			InetAddress address = InetAddress.getByName(hostname);
			System.out.println("IP주소 : "+address.getHostAddress());
			
		} catch (UnknownHostException e) {
			// TODO: handle exception
			System.out.println(hostname+"의 IP 주소를 찾을 수 없습니다.");
		}
	}

}
