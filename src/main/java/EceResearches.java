
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * Created by nan on 2016-12-27.
 */
public class EceResearches implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    public void process(Page page) {

        List<String> researchesNames = page.getHtml().xpath("//section[@class='entry-content']/table/tbody/tr/td/ul/li/span/text()").all();
        for (String r : researchesNames) {
            System.out.println("research: " + r.replace(" –", "").replace(", ", "").replace("()", "").replace(" ,", ""));
        }

    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new EceResearches())
                .addUrl(
                        "https://www.ece.utoronto.ca/photonics/photonics-research/",
                        "https://www.ece.utoronto.ca/communications/research/",
                        "https://www.ece.utoronto.ca/biomedical-engineering/research/",
                        "https://www.ece.utoronto.ca/computer/research/",
                        "https://www.ece.utoronto.ca/electromagnetics/research/",
                        "https://www.ece.utoronto.ca/electronics/research/",
                        "https://www.ece.utoronto.ca/energy-systems/energy-research/",
                        "https://www.ece.utoronto.ca/control/control-research/")
                .thread(1).run();
    }

}
