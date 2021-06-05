import java.util.Collection;
import java.util.List;

public interface Node {
    Collection<Node> getChildren();

    List<String> getWeather();
}