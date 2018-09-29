import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.rocks.BreadthCrawler;

/**
 * Created by siyunfei on 2018/9/29.
 */
public class DemoAutoNewsCrawler extends BreadthCrawler {

    public DemoAutoNewsCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        this.addSeed("https://blog.github.com/");
        for (int pageIndex = 2; pageIndex <= 5; pageIndex++) {
            String seedUrl = String.format("https://blog.github.com/page/%d/", pageIndex);
            this.addSeed(seedUrl);
        }
        this.addRegex("https://blog.github.com/[0-9]{4}-[0-9]{2}-[0-9]{2}-[^/]+/");

        this.setThreads(50);
        this.getConf().setTopN(100);
    }

    @Override
    public void visit(Page page, CrawlDatums crawlDatums) {
        String url = page.url();
        if (page.matchUrl("https://blog.github.com/[0-9]{4}-[0-9]{2}-[0-9]{2}-[^/]+/")) {
            String title = page.select("h1[class=lh-condensed]").first().text();
            String content = page.selectText("div.content.markdown-body");

            System.out.println("URL:\n" + url);
            System.out.println("title:\n" + title);
            System.out.println("content:\n" + content);
        }
    }

    public static void main(String[] args) {
        try {
            new DemoAutoNewsCrawler("crawl", true).start(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
