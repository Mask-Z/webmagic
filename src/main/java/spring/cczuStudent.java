package spring;

import summer.ImageDownloader;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Mr丶周 on 2016/11/19.
 *///http://219.230.159.132/images/xszp/13477129.jpg
public class cczuStudent {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = null;
		OutputStream outputStream = null;//134 77 1 29
		String[] classAge = {"114", "124", "134", "144", "154", "164"};
		int zydm = 1;
		int xh = 1;
		String url = "http://219.230.159.132/images/xszp/";
		String urlImg = "";
		URL openurl = null;
		for(String nj:classAge){
		for (zydm=1; zydm < 100; zydm++) {
			for (xh=1; xh < 50; xh++) {
				int flag = 0;
				String tempUrl =nj+ i2s(zydm) + 1 + i2s(xh);
				urlImg = url + tempUrl + ".jpg";
				try {
					openurl = new URL(urlImg);
				} catch (MalformedURLException e) {

					System.out.println("没有此链接 ");
				}
				try {
					inputStream = openurl.openStream();
				} catch (IOException e) {
					System.out.println("无次链接!");
					flag = 1;
				}
				System.out.println("url: " + urlImg);
				if (flag == 0)
					ImageDownloader.writeImg(inputStream, outputStream, tempUrl);
			}

		}
		}
		inputStream.close();

	}

	public static String i2s(int i) {
		if (i < 10)
			return "0" + i;
		else
			return "" + i;
	}
}