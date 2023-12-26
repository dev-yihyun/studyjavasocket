package TCPServerTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//실행하면 서버는 클라이언트로부터 입력이 있을 때 까지 대기한다.
//해당 포트가 열려있다는 메시지가 나타난다면 포트번호를 바꿔야함
public class MyServerTest {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(12345);//현재 컴퓨터의 1234번 포트를서버용으로 개설
			System.out.println("Server Ready...");
			
			Socket socket = serverSocket.accept();
			//accept() : serverSocket 객체에서 설정한 12345번 포트를 감시하고 있다가 어떤 요청이 감지되면 요청한 사용자의 소켓 정보를 가져온다.
			//이를 통해 서버와 해당 클라이언트는 통신이 가능하다.
			System.out.println("접속자 정보 : "+socket);
			
		} catch (IOException e) {
			System.err.println("해당 포트가 열려있습니다.");
			System.exit(-1);
		}
	}

}
