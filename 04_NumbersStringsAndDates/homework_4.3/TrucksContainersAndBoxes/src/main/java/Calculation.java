public class Calculation {

    public static final int MAX_CONTAINER_VOLUME = 27;
    public static final int MAX_TRUCK_VOLUME = 12;

    private int boxes;

    public Calculation(int boxes) {
        this.boxes = boxes;
    }

    public int getContainerCount() {
        int count = boxes / MAX_CONTAINER_VOLUME;
        if ((boxes % MAX_CONTAINER_VOLUME) > 0) {
            count++;
        }
        return count;
    }

    public int getTruckCount() {
        int count = getContainerCount() / MAX_TRUCK_VOLUME;
        if ((getContainerCount() % MAX_TRUCK_VOLUME) > 0) {
            count++;
        }
        return count;
    }
}
