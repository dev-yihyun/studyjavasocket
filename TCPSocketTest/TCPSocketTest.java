package TCPSocketTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

//텔넷 설정 후 실행
/*실행결과
 해당 페이지의 HTML 문서가보인다.
 특정 서버에 TCP 통신으로 연결할수 있도록 socket을사용
 IP주소와 연려있는 포트만 알면 TCP 통신으로 연결할 수있다.
 */
public class TCPSocketTest {

	public static void main(String[] args) {
		InetAddress remote_addr = null;
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		
		try {
			remote_addr = InetAddress.getByName("www.daum.net");//다음 서버의 InetAddress 객체 생성
			socket = new Socket(remote_addr,80);//remote_addr 객체에 저장된 IP주소의 80번 포트로 연결 요청 한 후 연결된 객체를 생성
			
			//연결된 객체를 사용해 출력 스트림 객체를 생성, 이 개겣를 사용하여 다음 서버에 데이터를 전송
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
			//연결된 객체를사용해 입력 스트림 객체를 생서. 이 객체를 사용하여 다음서버에서 데이터를 전송 받는다.
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			System.err.println("연결 오류 : " + e.getLocalizedMessage());
			System.exit(-1);
		}
		
		try {
			out.println("GET http://www.daum.net/ HTTP/1.0\r\n\n");//요청 형식에 맞추어 다음서버의 메인 페이지의 문서 내용을 요청
			out.flush();//요청하는 내용을 버퍼를 비우면서 서버로 전송
			
			while (true) {//입력 스트림을 사용해 다음서버로 부터 전송 받는 내용을 한 줄씩 받아 화면에 출력//데이터를 모두 전송 받으면 'null'이 수신되어 종료
							
				String str = in.readLine();
				if(str==null)break;
				System.out.println(str);
			}
			//연결된 객체를 사용해 ㅛ생성한 입출력 스트림 객체들을 닫는다.
			
			socket.shutdownOutput();
			socket.shutdownInput();
			socket.close();//연결된 객체를 닫아 연결을 종료
			
		}catch (IOException e) {
			
		}
	}

}
