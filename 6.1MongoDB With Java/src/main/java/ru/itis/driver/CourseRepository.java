package ru.itis.driver;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.SneakyThrows;
import org.bson.Document;
import org.bson.types.ObjectId;
import ru.itis.models.Course;
import ru.itis.models.Student;

import java.lang.reflect.Field;
import java.util.Collections;

public class CourseRepository {

    public static void findAll(MongoCollection<Document> collection) {
        collection.find().forEach(document -> System.out.println(document.toJson()));
    }

    public static void save (MongoCollection<Document> collection, Course course) {
        Document document = new Document()
                .append("name", course.getName())
                .append("description", course.getDescription());
        collection.insertOne(document);
    }

    public static void update (MongoCollection<Document> collection,String _id, Course course) {
        Document id = new Document("_id", new ObjectId(_id));
        Document document = new Document()
                .append("name", course.getName())
                .append("description", course.getDescription());

        Document updateQuery = new Document("$set", document);
        collection.updateOne(id, updateQuery);
    }

    public static void delete(MongoCollection<Document> collection,String _id) {
        collection.deleteOne(new Document("_id", new ObjectId(_id)));
    }

    public static void main(String[] args) {

        MongoClient client = MongoClients.create();
        MongoDatabase database = client.getDatabase("jaba");
        MongoCollection<Document> collection = database.getCollection("courses");

        Course course = Course.builder()
                .name("new")
                .description("course")
                .build();

        save(collection, course);

//        course.setName("update");

//        update(collection,"5fc78a0b109aae6eaa0b5365", course);
//        delete(collection, "5fc78ec268a6ca514be7bb4c");
        findAll(collection);
    }
}
