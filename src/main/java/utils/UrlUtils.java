package utils;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nan on 2016-12-22.
 */
public class UrlUtils {
    static private final Logger logger = Logger.getLogger(UrlUtils.class);

    public static List<String> removePeoplePage(List<String> links) {
        List<String> excludedPeople = new ArrayList<String>();
        if (links == null || links.isEmpty()) {
            return excludedPeople;
        }
        for (String link : links) {
            if (!link.contains("people")) {
                excludedPeople.add(link);
            }
        }
        return excludedPeople;
    }
}
