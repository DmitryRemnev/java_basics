import java.util.Random;

public class Hospital {
    public static final int MIN_TEMPERATURE = 32;
    public static final int MAX_TEMPERATURE = 40;
    public static final float MIN_HEALTHY_PERSON_TEMPERATURE = 36.2f;
    public static final float MAX_HEALTHY_PERSON_TEMPERATURE = 36.9f;
    private static int patientsCount;

    public static float[] generatePatientsTemperatures(int patientsCount) {
        setPatientsCount(patientsCount);

        Random random = new Random();
        float[] patientTemperatures = new float[patientsCount];

        for (int i = 0; i < patientsCount; i++) {
            patientTemperatures[i] = random.nextFloat() * (MAX_TEMPERATURE - MIN_TEMPERATURE) + MIN_TEMPERATURE;
        }

        return patientTemperatures;
    }

    public static String getReport(float[] temperatureData) {
        StringBuilder builder = new StringBuilder();

        createListPatientTemperatures(builder, temperatureData);
        calculateArithmeticMeanValueTemperature(builder, temperatureData);
        countNumberHealthyPatients(builder, temperatureData);

        return builder.toString();
    }

    public static void createListPatientTemperatures(StringBuilder builder, float[] temperatureData) {
        builder.append("Температуры пациентов: ");

        for (float item : temperatureData) {
            builder.append(round(item, 1)).append(" ");
        }
    }

    public static void calculateArithmeticMeanValueTemperature(StringBuilder builder, float[] temperatureData) {
        float sum = 0.0f;

        for (float item : temperatureData) {
            sum += item;
        }
        float averageTemperature = sum / getPatientsCount();

        builder.append("\nСредняя температура: ").append(round(averageTemperature, 2));
    }

    public static void countNumberHealthyPatients(StringBuilder builder, float[] temperatureData) {
        int numberHealthyPatients = 0;

        for (float item : temperatureData) {
            if (item >= MIN_HEALTHY_PERSON_TEMPERATURE && item <= MAX_HEALTHY_PERSON_TEMPERATURE) {
                numberHealthyPatients++;
            }
        }

        builder.append("\nКоличество здоровых: ");
        builder.append(numberHealthyPatients);
    }

    public static float round(float value, int numberCharacters) {
        double scale = Math.pow(10, numberCharacters);
        double result = Math.ceil(value * scale) / scale;

        return (float) result;
    }

    public static int getPatientsCount() {
        return patientsCount;
    }

    public static void setPatientsCount(int patientsCount) {
        Hospital.patientsCount = patientsCount;
    }
}