package DateServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(9101);//포트 9100번으로 서버 소켓을 만든다.
		try {
			while (true) {
				Socket socket = ss.accept();//클라이언트의 연결을 기다린다.
				try {
					PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
					out.println(new Date().toString());//날짜를 클라이언트로 보낸다.
				} finally {
					socket.close();
				}
			}
		} finally {
			ss.close();
		}
		
	}

}
