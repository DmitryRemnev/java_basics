import au.com.bytecode.opencsv.CSVReader;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.io.FileReader;
import java.util.List;
import java.util.function.Consumer;

import static com.mongodb.client.model.Sorts.ascending;
import static com.mongodb.client.model.Sorts.descending;

public class Main {
    private static final String DATA_FILE = "src/main/resources/mongo.csv";
    private static final String NUMBER_OF_STUDENTS = "Количество студентов: ";
    private static final String OVER_FORTY_YEARS_OLD = "Количество студентов старше 40 лет: ";
    private static final String YOUNGEST_STUDENT = "Самый молодой студент: ";
    private static final String COURSES_OLDEST_STUDENT = "Список курсов самого старого студента: ";

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);

        MongoDatabase database = mongoClient.getDatabase("local");

        MongoCollection<Document> collection = database.getCollection("Students");
        collection.drop();

        try (CSVReader csvReader = new CSVReader(new FileReader(DATA_FILE))) {
            List<String[]> lines = csvReader.readAll();

            for (String[] line : lines) {
                collection.insertOne(new Document()
                        .append("Name", line[0])
                        .append("Age", line[1])
                        .append("Courses", line[2]));
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        System.out.println(NUMBER_OF_STUDENTS + collection.countDocuments());

        BsonDocument query = BsonDocument.parse("{Age: {$gt: 40}}");
        System.out.println(OVER_FORTY_YEARS_OLD + collection.countDocuments(query));

        Bson sortASC = ascending("Age");
        collection.find().sort(sortASC).limit(1).forEach((Consumer<Document>) document -> {
            System.out.println(YOUNGEST_STUDENT + document.get("Name"));
        });

        Bson sortDes = descending("Age");
        collection.find().sort(sortDes).limit(1).forEach((Consumer<Document>) document -> {
            System.out.println(COURSES_OLDEST_STUDENT + document.get("Courses"));
        });
    }
}