package TCPServerTest;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class MyClientServer {

	public static void main(String[] args) {
		InetAddress remote_addr = null;
		 Socket socket = null;
		 try {
			 //서버도 로컬에 있고 클라이언트도 로컬에 있기 때문에 getLocalhost사용
			 //실제 원격지에 있는 서버와 연결을 검증하려면 getByName()과 같은 메서드를 사용해 도메인으로 주소를 가져와 InetAddress 클래스의 객체를 새엇ㅇ
			remote_addr = InetAddress.getLocalHost();
			//remote_addr 객체에 지정된 주소의 1234번 포트으ㅔ 연결을 요청하여 연결된 객체를 생성
			//요청이 오면 accept()메서드는 이클라이언트와 통신할 수 있는 Socket 클래스의 객체를 자동으로 생성한다.
			socket = new Socket(remote_addr,12345);
			System.out.println("접속 요청완료");
			
		} catch (IOException e) {
			System.err.println("서버 접속 오류 : "+e.getLocalizedMessage());
			System.exit(-1);
		}
	}

}
