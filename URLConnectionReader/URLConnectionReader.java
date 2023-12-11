package URLConnectionReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionReader {

	public static void main(String[] args) throws Exception{
		URL site = new URL("http://www.naver.com/");//URL 클래스의 객체를 생성
		URLConnection url = site.openConnection();//연결 객체를 오픈
		BufferedReader in = new BufferedReader(
							new InputStreamReader(url.getInputStream()));//스트림 연결
		String inline;
		while((inline = in.readLine())!=null) {
			System.out.println(inline);
		}
		in.close();
	}

}
