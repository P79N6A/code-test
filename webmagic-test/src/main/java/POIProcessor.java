import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * Created by siyunfei on 2018/9/29.
 */
public class POIProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

    public void process(Page page) {
        List<String> links = page.getHtml().links().regex("http://www.poi86.com/poi/amap/\\d+.html").all();
        page.addTargetRequests(links);
        String name = page.getHtml().xpath("//div[@class='panel-heading']/h1/text()").toString();
        page.putField("name", name);
    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider spider = Spider.create(new POIProcessor());
        for (int pageIndex = 1; pageIndex <=5 ; pageIndex++) {
            String url = String.format("http://www.poi86.com/poi/amap/district/110102/%d.html", pageIndex);
            spider.addUrl(url);
        }
        spider.thread(20).addPipeline(new ConsolePipeline()).run();
    }
}
