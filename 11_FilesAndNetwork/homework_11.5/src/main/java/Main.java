public class Main {
    public static final String URL_MOSCOWMAP = "https://www.moscowmap.ru/metro.html#lines";

    public static void main(String[] args) {
        Parsing parsing = new Parsing(URL_MOSCOWMAP);
        parsing.readFile();
    }
}