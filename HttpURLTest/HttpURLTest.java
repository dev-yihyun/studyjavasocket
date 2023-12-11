package HttpURLTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLTest {

	public static void main(String[] args) throws Exception{
		HttpURLTest http = new HttpURLTest();
		String site = "https://www.google.com/search?q=java";
		URL url = new URL(site);
		HttpURLConnection conn= (HttpURLConnection) url.openConnection();
		
		conn.setRequestMethod("GET");//Request 방법 설정
		conn.setRequestProperty("User-Agent", "Mozilla/5.0");//Request 방법 설정
		
		int resCode = conn.getResponseCode();//여기서 실제로 웹서버에 데이터가 전송된다.
		
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));//스트림을 연결한다.
		String inputLine;
		StringBuffer output = new StringBuffer();
		
		while ((inputLine = in.readLine())!= null) {
			output.append(inputLine);
		}
		in.close();
		
		System.out.println(output);
	}

}
