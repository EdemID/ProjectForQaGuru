package guru.qa.api.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.util.List;

public class JSOUPParser {

    public static String parsingJavascriptElement(String stackoverflowPostAsHtml) {
        Document DOM = Jsoup.parse(stackoverflowPostAsHtml);
        Element element = DOM.body().selectXpath("//script[@data-module-name='Shared/options.mod']").first();
        List<Node> childNodes = element.childNodes();
        Node scriptContent = childNodes.get(0);

        return scriptContent.toString();
    }
}
