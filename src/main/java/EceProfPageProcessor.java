import org.apache.log4j.Logger;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import utils.UrlUtils;

import java.util.List;

/**
 * Created by nan on 2016-12-22.
 */
public class EceProfPageProcessor implements PageProcessor {
    static final private Logger logger = Logger.getLogger(EceProfPageProcessor.class);

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    public void process(Page page) {
        List<String> profList = page.getHtml().css("nav.page-navigation").links().regex(".*ece.utoronto.ca/people/page/[0-9]+.*").all();
        page.addTargetRequests(profList);
        List<String> profEcePages = page.getHtml().css("h3.h2").links().regex(".*ece.utoronto.ca/people/.*").all();
        page.addTargetRequests(profEcePages);
        List<String> profPersonalPages = UrlUtils.removePeoplePage(page.getHtml().$("p").links().regex(".*utoronto.ca/.*").all());
        if (profPersonalPages.size() == 1) {
            System.out.print(profPersonalPages.size() + "    " + profPersonalPages);
        } else if (profPersonalPages.size() > 1) {
            logger.error("found more than one prof's personal page url in page: " + page.getRequest().getUrl() + "/n" +
            "found these urls: " + profPersonalPages);
        }
    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new EceProfPageProcessor()).addUrl("https://www.ece.utoronto.ca/people/").thread(5).run();
    }
}
