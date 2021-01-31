public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        return Math.PI * (Math.abs(radius) * Math.abs(radius));
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        return (4.0 / 3.0) * Math.PI * (Math.abs(radius) * Math.abs(radius) * Math.abs(radius));
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        boolean allSidesGreaterZero = (a > 0) && (b > 0) && (c > 0);
        boolean sumTwoSidesGreaterThird = ((a + b) > c) && ((a + c) > b) && ((b + c) > a);
        return allSidesGreaterZero && sumTwoSidesGreaterThird;
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        if (isTrianglePossible(a, b, c)) {
            double halfPerimeter = (a + b + c) / 2;
            return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
        } else {
            return -1.0;
        }
    }
}
