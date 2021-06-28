import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.*;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StoreManager {
    MongoCollection<Document> storeCollection;
    MongoCollection<Document> productCollection;

    StoreManager() {
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        MongoDatabase database = mongoClient.getDatabase("local");

        storeCollection = database.getCollection("StoreCollection");
        storeCollection.drop();

        productCollection = database.getCollection("ProductCollection");
        productCollection.drop();
    }

    public void addStore(String storeName) {
        List<Document> list = new ArrayList<>();

        storeCollection.insertOne(new Document()
                .append("Name", storeName)
                .append("Products", list));
    }

    public void addProduct(String productName, int price) {
        productCollection.insertOne(new Document()
                .append("Name", productName)
                .append("Price", price));
    }

    public void productOnSale(String productName, String storeName) {
        Bson product = Filters.eq("Name", productName);
        Bson store = Filters.eq("Name", storeName);
        storeCollection.findOneAndUpdate(store, Updates.addToSet("Products", productCollection.find(product)));
    }

    public void getStatistics() {
        AggregateIterable<Document> result = storeCollection.aggregate(Arrays.asList
                (Aggregates.match(Filters.exists("Products")),
                        Aggregates.unwind("$Products"),
                        Aggregates.group("$Name",
                                Accumulators.avg(Constants.AVERAGE_PRICE_OF_PRODUCTS, "$Products"),
                                Accumulators.sum(Constants.AMOUNT_OF_PRODUCTS, 1),
                                Accumulators.min(Constants.MIN_PRICE_OF_PRODUCTS, "$Products"),
                                Accumulators.max(Constants.MAX_PRICE_OF_PRODUCTS, "$Products"),
                                Accumulators.sum(Constants.AMOUNT_OF_PRODUCTS + " " + Constants.CHEAPER_THAN_100,
                                        Document.parse(Constants.$COND_$LT)))
                ));

        result.forEach((Block<? super Document>) d -> System.out.println(Constants.NAME + " " + d.get(Constants.ID) +
                "\n" + Constants.AMOUNT_OF_PRODUCTS + " " + d.get(Constants.AMOUNT_OF_PRODUCTS) +
                "\n" + Constants.AVERAGE_PRICE_OF_PRODUCTS + " " + d.get(Constants.AVERAGE_PRICE_OF_PRODUCTS) +
                "\n" + Constants.MAX_PRICE_OF_PRODUCTS + " " + d.get(Constants.MAX_PRICE_OF_PRODUCTS) +
                "\n" + Constants.MIN_PRICE_OF_PRODUCTS + " " + d.get(Constants.MIN_PRICE_OF_PRODUCTS) +
                "\n" + Constants.CHEAPER_THAN_100 + " " + d.get(Constants.AMOUNT_OF_PRODUCTS +
                " " + Constants.CHEAPER_THAN_100)));
    }
}