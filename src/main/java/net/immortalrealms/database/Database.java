package net.immortalrealms.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Database {
    public static MongoCollection<Document> getUserDatabase() {
        String uri = "mongodb+srv://immortalrealmsadmin:immortalrealmsadmin@users-y16v3.mongodb.net/test";
        MongoClientURI clientURI = new MongoClientURI(uri);
        MongoClient mongoClient = new MongoClient(clientURI);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("ImmortalRealmsDB");

        return mongoDatabase.getCollection("users");
    }
}
