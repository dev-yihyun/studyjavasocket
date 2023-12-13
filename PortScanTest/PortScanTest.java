package PortScanTest;

import java.io.IOException;
import java.net.ServerSocket;

//ServerSocekt 클래스의 생성자 메서드가 열려잇는 포트를 다시 열려고하면 객체를 생성할 대 IOExceptoin 예외가 발생한다.
//컴퓨터에 이미 열려있는 포트를확인
//실행 시 시간이 소요된다. TCP통신은 연결이 될 때 가지의 어느정도 대기 시간이 있기 때문이다.
public class PortScanTest {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		for(int n = 1;n<65536;++n) {//TCP 포트가 1~65535번까지 있기 떄문에 각각의 포트에 대해 전부 연결을 확인한다.
			try {
				serverSocket = new ServerSocket(n);//n번 포트에 연결. 이미 열려있다면 IOException에서 예외 처리
				serverSocket.close();
			} catch (IOException e) {
				System.out.println(n+"번 TCP 포트가 열려있습니다.");
			}
		}
	}

}
