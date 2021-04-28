import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Parsing {

    public Parsing(String url) {
        try {
            Document document = Jsoup.connect(url).maxBodySize(0).get();
            Element metrodata = document.getElementById("metrodata");
            Elements lines = metrodata.select("[data-depend]");

            for (int i = 0; i < lines.size(); i++) {
                int lineNumber = i + 1;
                System.out.println(lineNumber);
                System.out.println(lines.get(i).text());

                Elements stations = metrodata.select(".js-metro-stations[data-line=1]>p>a>span.name");
                for (Element station : stations) {
                    System.out.println(station.text());
                }
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}