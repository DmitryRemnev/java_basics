import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileWriter;

import java.io.IOException;

public class Parsing {
    private static final String CSS_FOR_LINES_LIST = "span[data-line]";
    private static final String CSS_FOR_STATIONS_LIST = "div[data-line]";
    private static final String ATTRIBUTE_KEY_FOR_LINE = "data-line";
    private static final String PATH_FOR_EACH_STATION = ">p>a>span.name";
    private static final String DESTINATION_PATH = "C:\\Users\\IGOR-K\\IdeaProjects\\java_basics\\11_FilesAndNetwork\\homework_11.5\\src\\main\\resources\\map.json";

    public Parsing(String url) {
        try {
            Document document = Jsoup.connect(url).maxBodySize(0).get();
            Elements linesElements = document.select(CSS_FOR_LINES_LIST);
            Elements stationsElements = document.select(CSS_FOR_STATIONS_LIST);

            JSONArray linesArray = new JSONArray();
            linesElements.forEach(element ->
                    {
                        JSONObject line = new JSONObject();
                        line.put("number", element.attr(ATTRIBUTE_KEY_FOR_LINE));
                        line.put("name", element.text());
                        linesArray.add(line);
                    }
            );
            JSONObject linesObject = new JSONObject();
            linesObject.put("lines", linesArray);

            JSONObject stationsObject = new JSONObject();
            stationsElements.forEach(element ->
                    {
                        Elements elements = element.select(PATH_FOR_EACH_STATION);
                        JSONArray stations = new JSONArray();
                        elements.forEach(st ->
                                {
                                    stations.add(st.text());
                                }
                        );
                        stationsObject.put(element.attr(ATTRIBUTE_KEY_FOR_LINE), stations);
                    }
            );

            JSONObject mapObject = new JSONObject();
            mapObject.put("stations", stationsObject);
            mapObject.put("lines", linesArray);

            try (FileWriter file = new FileWriter(DESTINATION_PATH)) {
                file.write(mapObject.toJSONString());
                file.flush();
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}