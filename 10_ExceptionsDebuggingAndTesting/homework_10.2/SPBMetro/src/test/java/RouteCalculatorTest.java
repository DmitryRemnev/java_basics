import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    RouteCalculator calculator;
    List<Station> routeDuration;
    List<Station> expectedOneLine;
    List<Station> expectedTwoLines;
    List<Station> expectedThreeLines;
    Line line1;
    Line line2;
    Line line3;
    Line line5;

    @Override
    protected void setUp() throws Exception {
        routeDuration = new ArrayList<>();

        line1 = new Line(1, "Кировско-Выборгская");
        line2 = new Line(2, "Московско-Петроградская");
        line3 = new Line(3, "Невско-Василеостровская");
        line5 = new Line(5, "Фрунзенско-Приморская");

        Station station1 = new Station("Чернышевская", line1);
        Station station2 = new Station("Площадь Восстания", line1);
        Station station3 = new Station("Владимирская", line1);
        Station station4 = new Station("Пушкинская", line1);
        Station station5 = new Station("Технологический институт", line1);
        Station station6 = new Station("Балтийская", line1);

        Station station7 = new Station("Горьковская", line2);
        Station station8 = new Station("Невский проспект", line2);
        Station station9 = new Station("Сенная площадь", line2);
        Station station10 = new Station("Технологический институт", line2);
        Station station11 = new Station("Фрунзенская", line2);

        Station station12 = new Station("Василеостровская", line3);
        Station station13 = new Station("Гостиный двор", line3);

        Station station14 = new Station("Адмиралтейская", line5);
        Station station15 = new Station("Садовая", line5);

        routeDuration.add(station1);
        routeDuration.add(station2);
        routeDuration.add(station7);
        routeDuration.add(station8);

        StationIndex stationIndex = new StationIndex();
        stationIndex.addLine(line1);
        stationIndex.addLine(line2);

        line1.addStation(station1);
        line1.addStation(station2);
        line1.addStation(station3);
        line1.addStation(station4);
        line1.addStation(station5);
        line1.addStation(station6);

        line2.addStation(station7);
        line2.addStation(station8);
        line2.addStation(station9);
        line2.addStation(station10);
        line2.addStation(station11);

        line3.addStation(station12);
        line3.addStation(station13);

        line5.addStation(station14);
        line5.addStation(station15);

        stationIndex.addStation(station1);
        stationIndex.addStation(station2);
        stationIndex.addStation(station3);
        stationIndex.addStation(station4);
        stationIndex.addStation(station5);
        stationIndex.addStation(station6);
        stationIndex.addStation(station7);
        stationIndex.addStation(station8);
        stationIndex.addStation(station9);
        stationIndex.addStation(station10);
        stationIndex.addStation(station11);
        stationIndex.addStation(station12);
        stationIndex.addStation(station13);
        stationIndex.addStation(station14);
        stationIndex.addStation(station15);

        List<Station> connectionTwoLines = new ArrayList<>();
        connectionTwoLines.add(station5);
        connectionTwoLines.add(station9);

        List<Station> connection2and3 = new ArrayList<>();
        connection2and3.add(station8);
        connection2and3.add(station13);

        List<Station> connection2and5 = new ArrayList<>();
        connection2and5.add(station9);
        connection2and5.add(station15);

        stationIndex.addConnection(connectionTwoLines);
        stationIndex.addConnection(connection2and3);
        stationIndex.addConnection(connection2and5);

        calculator = new RouteCalculator(stationIndex);

        expectedOneLine = new ArrayList<>();
        expectedOneLine.add(station1);
        expectedOneLine.add(station2);
        expectedOneLine.add(station3);
        expectedOneLine.add(station4);
        expectedOneLine.add(station5);

        expectedTwoLines = new ArrayList<>();
        expectedTwoLines.add(station6);
        expectedTwoLines.add(station5);
        expectedTwoLines.add(station9);

        expectedThreeLines = new ArrayList<>();
        expectedThreeLines.add(station12);
        expectedThreeLines.add(station13);
        expectedThreeLines.add(station8);
        expectedThreeLines.add(station9);
        expectedThreeLines.add(station15);
        expectedThreeLines.add(station14);

        super.setUp();
    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(routeDuration);
        double expected = 8.5;
        assertEquals(expected, actual);
    }

    public void testGetRouteOnTheLine() {
        List<Station> actual = calculator
                .getShortestRoute(new Station("Чернышевская", line1), new Station("Технологический институт", line1));

        assertEquals(expectedOneLine, actual);
    }

    public void testGetRouteWithOneConnection() {
        List<Station> actual = calculator
                .getShortestRoute(new Station("Балтийская", line1), new Station("Сенная площадь", line2));

        assertEquals(expectedTwoLines, actual);
    }

    public void testGetRouteWithTwoConnections() {
        List<Station> actual = calculator
                .getShortestRoute(new Station("Василеостровская", line3), new Station("Адмиралтейская", line5));

        assertEquals(expectedThreeLines, actual);
    }
}