import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpMethods {

	static final Integer PORT = 80;
	static final String GETURL = "http://httpbin.org/get?course=networking&assignment=1";
	static final String POSTURL = "http://httpbin.org/post";

	public static Map<String, String> get(String url) throws IOException {

		Map<String, String> responseMap = new HashMap<>();
		URL urlObject = new URL(url);
		try (Socket socket = new Socket(InetAddress.getByName(urlObject.getHost()), PORT)) {
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			printWriter.println("GET /" + urlObject.getFile() + " HTTP/1.0");
			printWriter.println("Host: " + urlObject.getHost());
			printWriter.println("");
			printWriter.flush();
			try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
				String str;
				StringBuilder response = new StringBuilder();
				boolean header = false;

				while ((str = bufferedReader.readLine()) != null) {
					response.append(str + "\n");
					if (str.isEmpty() && !header) {
						responseMap.put("header", response.toString());
						header = true;
						response = new StringBuilder();
					}
					responseMap.put("body", response.toString());
				}
			}
		} catch (IOException io) {
			//
		}
		return responseMap;
	}

	public static Map<String, String> post(String url, String data) throws IOException {

		BufferedReader bufferedReader = null;

		Map<String, String> responseMap = new HashMap<>();
		URL urlObject = new URL(url);

		try (Socket socket = new Socket(InetAddress.getByName(urlObject.getHost()), PORT);) {
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			printWriter.println("POST /" + urlObject.getFile() + " HTTP/1.0");
			printWriter.println("Host: " + urlObject.getHost());
			printWriter.println("Content-Length: " + data.length());
			printWriter.println();
			printWriter.println(data);
			printWriter.println();
			printWriter.flush();
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String str;
			StringBuilder response = new StringBuilder();
			boolean header = false;

			while ((str = bufferedReader.readLine()) != null) {
				response.append(str + "\n");
				if (str.isEmpty() && !header) {
					responseMap.put("header", response.toString());
					header = true;
					response = new StringBuilder();
				}
			}
			responseMap.put("body", response.toString());
		} catch (IOException io) {
			//
		}
		return responseMap;
	}
}
