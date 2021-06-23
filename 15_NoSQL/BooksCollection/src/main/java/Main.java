import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.function.Consumer;

import static com.mongodb.client.model.Sorts.ascending;

public class Main {

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);

        MongoDatabase database = mongoClient.getDatabase("local");

        MongoCollection<Document> collection = database.getCollection("BooksCollection");
        collection.drop();

        Document firstBook = new Document()
                .append("Title", "Бойцовский клуб")
                .append("AuthorName", "Чак Паланик")
                .append("Year", 1996);

        Document secondBook = new Document()
                .append("Title", "Удушье")
                .append("AuthorName", "Чак Паланик")
                .append("Year", 2001);

        Document thirdBook = new Document()
                .append("Title", "Лезвие бритвы")
                .append("AuthorName", "Иван Ефремов")
                .append("Year", 1963);

        Document fourthBook = new Document()
                .append("Title", "Черная Стрела")
                .append("AuthorName", "Роберт Стивенсон")
                .append("Year", 1888);

        Document fifthBook = new Document()
                .append("Title", "Я, Клавдий")
                .append("AuthorName", "Роберт Грейвз")
                .append("Year", 1934);

        collection.insertOne(firstBook);
        collection.insertOne(secondBook);
        collection.insertOne(thirdBook);
        collection.insertOne(fourthBook);
        collection.insertOne(fifthBook);

        Bson sort = ascending("Year");
        collection.find().sort(sort).limit(1).forEach((Consumer<Document>) System.out::println);

        BsonDocument query = BsonDocument.parse("{AuthorName: {$eq: 'Чак Паланик'}}");
        collection.find(query).forEach((Consumer<Document>) System.out::println);
    }
}