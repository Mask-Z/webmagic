package summer;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import us.codecraft.webmagic.downloader.HttpClientDownloader;

import java.io.IOException;

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
}
