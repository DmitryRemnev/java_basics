import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    List<Station> route;
    RouteCalculator calculator = Main.getRouteCalculator();

    @Override
    protected void setUp() throws Exception {
        route = new ArrayList<>();

        Line line1 = new Line(1, "первая");
        Line line2 = new Line(2, "вторая");

        route.add(new Station("Петровская", line1));
        route.add(new Station("Арбузная", line1));
        route.add(new Station("Морковная", line2));
        route.add(new Station("Яблочная", line2));

        super.setUp();
    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 8.5;
        assertEquals(expected, actual);
    }

    public void testGetRouteOnTheLine() {
        List<Station> expected = new ArrayList<>();
        Line line = new Line(1, "Кировско-Выборгская");
        expected.add(new Station("Лесная", line));
        expected.add(new Station("Выборгская", line));
        expected.add(new Station("Площадь Ленина", line));
        expected.add(new Station("Чернышевская", line));
        expected.add(new Station("Площадь Восстания", line));

        List<Station> actual = calculator
                .getShortestRoute(new Station("Лесная", line), new Station("Площадь Восстания", line));

        assertEquals(expected, actual);
    }
}