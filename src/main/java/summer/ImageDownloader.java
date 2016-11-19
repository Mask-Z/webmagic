package summer;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import us.codecraft.webmagic.downloader.HttpClientDownloader;

import java.io.*;
import java.net.URL;

/**
 * Created by Mr丶周 on 2016/11/16.
 */
public class ImageDownloader extends HttpClientDownloader {

	@Override
	protected String getContent(String charset, HttpResponse httpResponse) throws IOException {

		byte[] imageByte = EntityUtils.toByteArray(httpResponse.getEntity());
		String iageStr = ImageBase64Utils.GetImageStr(imageByte);
		return iageStr;
	}

	public static void writeImg(String imgName, String imgUrl) throws IOException {

		URL url = new URL(imgUrl);
		DataInputStream dataInputStream = new DataInputStream(url.openStream());
		//String path="";
		FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\webmagic\\cczuBook\\" + imgName + ".jpg"));

		byte[] data = new byte[1024];
		int length;
		while ((length = dataInputStream.read(data)) > 0) {
			fileOutputStream.write(data, 0, length);
		}
		dataInputStream.close();
		fileOutputStream.close();
	}

	public static void writeImg(InputStream inputStream, OutputStream outputStream, String tempUrl) throws IOException {
		//inputStream = new DataInputStream(new URL(imgUrl).openStream());

		outputStream = new FileOutputStream(new File("D:\\webmagic\\cczuBook\\" + tempUrl + ".jpg"));

		byte[] data = new byte[1024];
		int length;
		while ((length = inputStream.read(data)) > 0) {
			outputStream.write(data, 0, length);
		}

		outputStream.close();
	}
}
