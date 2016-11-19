package spring;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.IOException;
import java.util.List;

import static summer.ImageDownloader.writeImg;

/**
 * Created by Mr丶周 on 2016/11/16.
 */
public class TiebaProcessor implements PageProcessor {
	private Site site = Site.me().setSleepTime(1000).setRetryTimes(3);
	private static int count = 0;
	//列表页的正则表达式  http://tieba.baidu.com/p/3466236659?pn=2
	public static final String URL_LIST2 = "http://tieba\\.baidu\\.com/p/3466236659\\?pn=\\d*";
	//	//详情页的正则表达式http://imgsrc.baidu.com/forum/w%3D580/sign=1b51bd882b381f309e198da199004c67/97224f4a20a446238c892ad29b22720e0df3d7c4.jpg
	public static final String URL_PIC = "http://imgsrc\\.baidu\\.com/forum/\\.*";


	@Override
	public Site getSite() {
		return site;
	}

	@Override
	public void process(Page page) {
		//列表页  class="BDE_Image"
		if (page.getUrl().regex(URL_LIST2).match()) {
			List<String> l_post = page.getHtml().xpath("//img[@class='BDE_Image']/@src").all(); //  图片地址
			List<String> l_url = page.getHtml().links().regex(URL_LIST2).all();    //所有的列表


			page.addTargetRequests(l_post);
			page.addTargetRequests(l_url);


			//详情页   page.getHtml().xpath("//div[@id='pin_img']/img/@src").toString()
		} else {
//			String title = page.getHtml().xpath("//div[@class='location']").regex("\\[[\\S|\\s]+\\<").toString();    //匹配标题
//			page.putField("title", title.substring(0, title.length() - 1).trim());
//			page.putField("torrent", page.getHtml().xpath("//p[@class='original download']").links().toString().trim());    //匹配种子
			String urll = page.getUrl().toString();
			try {
				writeImg((count++) + "", urll);
			} catch (IOException e) {
				e.printStackTrace();
			}
			page.putField("URL", urll);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Spider.create(new TiebaProcessor())
				.addUrl("http://tieba.baidu.com/p/3466236659?pn=")    //开始地址
				.addPipeline(new ConsolePipeline()) //打印到控制台
//				.addPipeline(new ImgPipeline("D:\\webmagic\\tiebapic2"))    //保存到文件夹
				.thread(5)  //开启5线程
				.run();
	}


}
