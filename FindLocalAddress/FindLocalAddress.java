package FindLocalAddress;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class FindLocalAddress {

	public static void main(String[] args)throws IOException {
		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println("로컬 장비 IP주소: "+address.getHostAddress());
			System.out.println("로컬 장비 호스트 이름 : "+address.getHostName());
						
		} catch (UnknownHostException e) {
			System.out.println("로컬 장비의 주소를 찾을 수 없습니다.");
		}
	}

}
