package InetAddressTest_0;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) {
		InetAddress local_addr = null;
		InetAddress remote_addr = null;
		try {
			local_addr = InetAddress.getLocalHost();
			remote_addr = InetAddress.getByName("naver.com");
			
		} catch (UnknownHostException e) {
			System.out.println("유효하지 않은 도메인 입니다ㅣ");
		
			System.exit(-1);
		}
		
		System.out.println("local_addr = "+local_addr.getHostAddress());
		System.out.println("remote_addr = "+remote_addr.getHostAddress());
		
		
	}

}
