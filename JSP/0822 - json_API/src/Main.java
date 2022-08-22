import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.example.AppleSearchResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Main {
	public static void main(String[] args) throws IOException {
//		Jackson Datablind
		// 사람
		// 이름 = 홍길동
		// 나이 = 22
//		json
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.createObjectNode();
		node.put("name", "홍길동");
		node.put("age", 22);
		node.put("boolean", true);

		ObjectNode node2 = mapper.createObjectNode();
		node2.put("이름", "둘리");
		node2.put("나이", 23);

		node.set("bf", node2);

		String json = mapper.writeValueAsString(node);
		System.out.println(json);
		System.out.println("--------------------------------------------------------------");

//		클래스를 만들어서 객체 표현하기
		Person hong = new Person("홍길동", 22);
		ObjectMapper mapperP = new ObjectMapper();
		String jsonP = mapperP.writeValueAsString(hong);
		System.out.println(jsonP);

		String jsonString = "{\"name\":\"둘리\",\"age\":23}";
		Person dooli = mapperP.readValue(jsonString, Person.class);
		System.out.println(dooli.getName());
		System.out.println(dooli.getAge());
		System.out.println("--------------------------------------------------------------");

//		json pojo 를 검색하면 나오는 사이트에서 url에 있는 json을 클래스로 자동으로 바꿔주는 기능이 있다. 활용해보자 (jsonschema2pojo)
//		GET 방식으로 요청해보자 - header
		String apiURL = "https://itunes.apple.com/search?term=";
		String requestURL = apiURL + URLEncoder.encode("아이유", "UTF-8");
		URL url = new URL(requestURL);
		HttpURLConnection conn = null;

		try {
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			int responseCode = conn.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				String respBody = readBody(conn.getInputStream());
				System.out.println(respBody);
//				Json 타입으로 다루고 싶다면 이렇게 바꿔주자
				ObjectMapper mapperJ = new ObjectMapper();
				AppleSearchResult apple = mapperJ.readValue(respBody, AppleSearchResult.class);
				System.out.println(apple.getResultCount());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}

		System.out.println("--------------------------------------------------------------");
//		POST 방식으로 요청해보자 - body에서 전달이 되기 때문에 MediaType(MIME 검색) 을 설정해줘야 한다.
		String apiURLPost = "https://httpbin.org/post";
		URL urlPost = new URL(apiURLPost);
		HttpURLConnection connPost = null;
		try {
			connPost = (HttpURLConnection) urlPost.openConnection();
			connPost.setRequestMethod("POST");
			connPost.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			connPost.setRequestProperty("Accept", "application/json");
			connPost.setDoOutput(true);

			ObjectMapper mapperPost = new ObjectMapper();
			String jsonPost = mapperPost.writeValueAsString(new Person("홍길동", 22));

			byte[] body = jsonPost.getBytes();
			connPost.getOutputStream().write(body, 0, body.length);
			if (connPost.getResponseCode() == HttpURLConnection.HTTP_OK) {
				System.out.println(readBody(connPost.getInputStream()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (connPost != null) {
				connPost.disconnect();
			}
		}

		System.out.println("--------------------------------------------------------------");
//		HttpURLConnection 은 JDK1.1 버전 (옛날에 만들어짐) 이라 사용법이 괴랄하다.
//		그래서 사용법이 편한 라이브러리 okhttp를 사용해보자. GET
		String apiURLOkGet = "https://httpbin.org/get";
		OkHttpClient client = new OkHttpClient();
		Request req = new Request.Builder().url(apiURLOkGet).build();

		try (Response resp = client.newCall(req).execute()) {
			if (resp.code() == 200) {
				System.out.println(resp.body().string());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("--------------------------------------------------------------");
//		그래서 사용법이 편한 라이브러리 okhttp를 사용해보자. POST
		String apiURLOkPost = "https://httpbin.org/post";
		OkHttpClient clientPost = new OkHttpClient();
		RequestBody reqBody = RequestBody.create("일반 텍스트", MediaType.get("text/plain; charset=utf-8"));
		Request reqPost = new Request.Builder().url(apiURLOkPost).post(reqBody).build();

		try (Response respPost = clientPost.newCall(reqPost).execute()) {
			if (respPost.code() == 200) {
				System.out.println(respPost.body().string());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("--------------------------------------------------------------");
//		Jsoup을 이용한 크롤링 URL에서 링크만 뽑아와보자 : 크롤링은 내가 url보고 분석해서 뽑아와야한다. (API랑은 다르게)
		String searchURL = "https://www.saramin.co.kr/zf_user/search?search_area=main&search_done=y&search_optional_item=n&searchType=recently&searchword=java";
		String startString = "/zf_user/jobs/relay/view";

		Document doc = Jsoup.connect(searchURL).timeout(5000).get();
		Elements links = doc.select("a[href]");

		Set<String> set = new HashSet<String>();
		for (Element e : links) {
			String attr = e.attr("href");
			if (attr.startsWith(startString)) {
				set.add("http://www.saramin.co.kr" + attr);
			}
		}
		System.out.println(set);

		System.out.println("--------------------------------------------------------------");
//		head에서 긁어와서 출력
		for (String urlInfo : set) {
			System.out.println(getSaraminInfo(urlInfo));
		}

		System.out.println("--------------------------------------------------------------");
//		위의 방법의 속도를 좀 더 빠르게 긁어오는 방법
		set.parallelStream().map(sea -> {
			try {
				return getSaraminInfo(sea);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return null;
		}).forEach(System.out::println);
	}

	private static String readBody(InputStream inputStream) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		StringBuilder sb = new StringBuilder();

		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}

	private static String getSaraminInfo(String url) throws IOException {
//		링크로 긁어와도 되는데 html - head - meta 태그에서 긁어오는 방법도 있다.
		Document doc = Jsoup.connect(url).timeout(5000).get();
		String info = doc.select("meta[name=description]").first().attr("content");
		return info;
	}
}