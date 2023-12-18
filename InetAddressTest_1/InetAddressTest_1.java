package InetAddressTest_1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
//IP주소가 여러개인 경우에 배열로 관리하는 방법
public class InetAddressTest_1 {

	public static void main(String[] args) {
		InetAddress[] remote_addr = null;//하나의 도메인에 연결된 여러개의 IP주소들을관리하기위해 배열객체 선언
										//접속자 수가 ㅁ낳거나 처리할 데이터가 많으면 서버에서는 분산처리를한다.
										//이때 스위치를통해 같은 도메인에 요청이 오더라도 여러대의 컴퓨터로 분산해서 처리
										//즉 하나의 도메인에 여러 개의 IP주소가 존재
		try {
			remote_addr = InetAddress.getAllByName("www.naver.com");//www.naver.com에 연결되어잇는 모든 IP주소
		} catch (UnknownHostException e) {
			System.err.println("유효하지 않은 도메인입니다.");
			System.exit(-1);
		}
		
		for(int n = 0;n<remote_addr.length;n++) {//배열이 관리하는 모든  IP주소 출력
			System.out.println("다음 사이트 [ " + n +" ] : " + remote_addr[n].getHostAddress());
		}
	}

}
