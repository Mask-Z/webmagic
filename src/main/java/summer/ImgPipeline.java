package summer;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.output.*;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.http.annotation.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.utils.FilePersistentBase;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import static us.codecraft.webmagic.utils.FilePersistentBase.PATH_SEPERATOR;

/**
 * Created by Mr丶周 on 2016/11/16.
 */
@ThreadSafe
public class ImgPipeline extends FilePersistentBase implements Pipeline{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public ImgPipeline() {
		this.setPath("/data/webmagic/");
	}

	public ImgPipeline(String path) {
		this.setPath(path);
	}

	public void process(ResultItems resultItems, Task task) {
		String path = this.path + PATH_SEPERATOR + task.getUUID() + PATH_SEPERATOR;

		String imgName=DigestUtils.md5Hex(resultItems.getRequest().getUrl())+".jpg";
		String imgUrl=resultItems.getRequest().getUrl();
//		try {
//			writeImg(imgName,imgUrl);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//		try {
//			PrintWriter e = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.getFile(path + DigestUtils.md5Hex(resultItems.getRequest().getUrl()) + ".html")), "UTF-8"));
//			e.println("imgUrl:\t" + resultItems.getRequest().getUrl());
//			Iterator i$ = resultItems.getAll().entrySet().iterator();
//
//			while(true) {
//				while(i$.hasNext()) {
//					Map.Entry entry = (Map.Entry)i$.next();
//					if(entry.getValue() instanceof Iterable) {
//						Iterable value = (Iterable)entry.getValue();
//						e.println((String)entry.getKey() + ":");
//						Iterator i$1 = value.iterator();
//
//						while(i$1.hasNext()) {
//							Object o = i$1.next();
//							e.println(o);
//						}
//					} else {
//						e.println((String)entry.getKey() + ":\t" + entry.getValue());
//					}
//				}
//
//				e.close();
//				break;
//			}
//		} catch (IOException var10) {
//			this.logger.warn("write file error", var10);
//		}

	}

//	public void writeImg(String imgName,String imgUrl) throws IOException {
//	//	String str="";
//		URL url=new URL(imgUrl);
//		DataInputStream dataInputStream=new DataInputStream(url.openStream());
//		//String path="";
//		FileOutputStream fileOutputStream=new FileOutputStream(imgName);
//
//		byte[] data=new byte[1024];
//		int length;
//		while ((length=dataInputStream.read(data))>0){
//			fileOutputStream.write(data,0,length);
//		}
//		dataInputStream.close();
//		fileOutputStream.close();
//	}
}
