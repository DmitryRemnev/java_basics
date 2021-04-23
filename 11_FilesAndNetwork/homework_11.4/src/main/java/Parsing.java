import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;

public class Parsing {
    private static final String FOLDER_PATH = "C:\\Users\\IGOR-K\\IdeaProjects\\java_basics\\11_FilesAndNetwork\\homework_11.4\\images";

    public Parsing(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            Elements photos = document.select("img");

            for (Element photo : photos) {
                System.out.println(photo.attr("abs:src"));
                downloadImage(photo.attr("abs:src"));
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void downloadImage(String src) {
        try {
            URL url = new URL(src);
            InputStream in = url.openStream();
            OutputStream out = new BufferedOutputStream(new FileOutputStream(FOLDER_PATH + getName(src)));

            for (int b; (b = in.read()) != -1; ) {
                out.write(b);
            }

            out.close();
            in.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private String getName(String src) {
        int indexName = src.lastIndexOf("/");

        if (indexName == src.length()) {
            src = src.substring(1, indexName);
        }

        indexName = src.lastIndexOf("/");

        return src.substring(indexName);
    }
}