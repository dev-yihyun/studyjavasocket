package DateServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class DateClient {

	public static void main(String[] args) throws IOException {
		Socket s = new Socket("localhost",9101);//포트번호9100번으로 연결을 시도한다.
		BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));//소켓으로부터 스트림을 얻는다.
		String res = input.readLine();
		System.out.println(res);
		
		System.exit(0);
		
	}

}
