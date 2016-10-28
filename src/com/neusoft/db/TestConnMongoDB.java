package com.neusoft.db;

import java.util.ArrayList;
import java.util.List;

import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.Document;
import com.google.gson.Gson;
import com.mongodb.DB;//����MongoDB��java��
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.util.JSON;
public class TestConnMongoDB {
//	public static void main(String[] args) {
////		try {
////			//1.connection MongodateBase services
//			MongoClient client = new MongoClient("mongodb://<xiongshx>:<xsx,.520>@ds041546.mlab.com", 41546);
//			//2.connection MongodataBase
//			  MongoClient mongoClient;
//			  MongoCredential credential = MongoCredential.createCredential("xiongshx", "testDB", xsx,.520);
//			    mongoClient = new MongoClient(new ServerAddress(ip, port), Arrays.asList(credential));
//			MongoDatabase mongoDatabase = client.getDatabase("TestDB");
//			System.out.println("connect mongoDB successfully!");
////			//3.get collocation
////			MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("aaa");
////			System.out.println("get collection successfully!");
////			//4.insert doucment
////			Document document = new Document();
////			document.append("name", "xiaochao").append("age", "32").append("sex","Ů")
////			.append("hight", "165").append("hibber","basketball").append("palce","˳����")
////			.append("tip","come on");
////			List<Document> list = new ArrayList<Document>();
////			list.add(document);
////			//mongoCollection.insertMany(list);
////			System.out.println("insert document successfully!");
////			//6. update document 
////			mongoCollection.updateMany(Filters.eq("name", "xiaochao"), new Document("$set",new Document("name","С��")));
////			
////			//7. delete one document 
////			mongoCollection.deleteOne(Filters.eq("name", "xiaoliu"));
////			//delete many documents
////			mongoCollection.deleteMany(Filters.eq("name","С��"));
//////			mongoCollection.mapReduce("function() { emit(this.user_name,1); }", "function(key, values) {return Array.sum(values)}," 
//////      .{  
//////         query:{status:"active"},  
//////         out:"post_total" 
//////      }")'
////			//5.search all documents
////			/**
////			 * 5.1 get FindIterable
////			 * 5.2 get MongoCursor
////			 */
////			FindIterable<Document> documentAll = mongoCollection.find();
////			MongoCursor<Document> cursor = documentAll.iterator();
////			PersonInfo personInfo = null;
////			while (cursor.hasNext()) {
////				//print every document 
////				//System.out.println(cursor.next());
////				//cursor transfor String
////				 String json = JSON.serialize(cursor.next());
////				 Gson gson = new Gson();
////				//String transfor Javabean
////				personInfo = gson.fromJson(json, PersonInfo.class);
////				System.out.println(json);
////			}
////			System.out.println("print personInfo===="+personInfo.toString());
////		} catch (Exception e) {
////			e.printStackTrace();
//		}
	
	public static void main(String[] args) {
        String mongoUri = "mongodb://<xiongshx>:<xsx,.520>@ds041546.mlab.com:41546/javalearn?authMechanism=SCRAM-SHA-1&authSource=xiongshx";
        // ���� String mongoUri = "mongodb://rwuser:********@10.66.122.28:27017?authMechanism=MONGODB-CR&authSource=admin";
        MongoClientURI connStr = new MongoClientURI(mongoUri);
        MongoClient mongoClient = new MongoClient(connStr);
        try {
            // ʹ����Ϊ someonedb ����ݿ�
            MongoDatabase database = mongoClient.getDatabase("testDB");
            // ȡ�ü���/�� someonetable ���
            MongoCollection<Document> collection = database.getCollection("testDB");

            // ׼��д�����
            Document doc = new Document();
            doc.append("key", "value");
            doc.append("username", "jack");
            doc.append("age", 31);

            // д�����
            collection.insertOne(doc);
            System.out.println("insert document: " + doc);

            // ��ȡ���
            BsonDocument filter = new BsonDocument();
            filter.append("username", new BsonString("username"));
            MongoCursor<Document> cursor = collection.find(filter).iterator();
            while (cursor.hasNext()) {
                System.out.println("find document: " + cursor.next());
            }

        } finally {
            //�ر�����
            mongoClient.close();
        }
    }
		
	}
	
