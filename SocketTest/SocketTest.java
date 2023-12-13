package SocketTest;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest {

	public static void main(String[] args) throws IOException {
		try(Socket s= new Socket("time-c.nist.gov",13)){//NIST 서버를 13번 포트로 연결 시도
			InputStream inStream = s.getInputStream();
			Scanner in = new Scanner(inStream);
			
			while (in.hasNext()) {
				String line = in.nextLine();
				System.out.println(line);
			}
			s.close();
		}
		
		
		
	}

}
