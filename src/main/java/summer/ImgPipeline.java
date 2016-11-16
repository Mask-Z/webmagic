package summer;

import org.apache.http.annotation.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.File;

/**
 * Created by Mr丶周 on 2016/11/16.
 */
@ThreadSafe
public class ImgPipeline extends FilePipeline implements Pipeline{
	private Logger logger = LoggerFactory.getLogger(getClass());
	private static int count=0;
	public ImgPipeline() {
		setPath("/data/webmagic/");
	}

	public ImgPipeline(String path) {
		setPath(path);
	}


	@Override
	public void process(ResultItems resultItems, Task task) {

			String imageStr = resultItems.get("imageStr");
			String bianhao = resultItems.get("bianhao");
			String url = resultItems.get("url");
			String path = this.path + task.getUUID() + "/";
			String path2 = path + count++;//U2F.convert(bianhao, url);
			path2 = path2.substring(0, path2.lastIndexOf("/")) + File.separator;
			checkAndMakeParentDirecotry(path2);
			boolean saveSucess = ImageBase64Utils.GenerateImage(path, count++ +"", imageStr);
			if (saveSucess) {
				System.out.println("==================================成功");

		}
	}
}
