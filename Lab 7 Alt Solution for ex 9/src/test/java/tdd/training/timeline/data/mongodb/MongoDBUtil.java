package tdd.training.timeline.data.mongodb;

import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.mockito.Mockito;

public class MongoDBUtil {

    public MongoDBUtil() {
    }

    void loadData(MongoCursor cursor) {
        Mockito.when(cursor.hasNext()).thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(false);


        Document document1 = new Document("message", "I Love TDD").append("timeStamp", System.currentTimeMillis());

        Document document2 = new Document("message", "I Love TDD 2").append("timeStamp", System.currentTimeMillis() - 20000);

        Document document3 = new Document("message", "I Love TDD 3").append("timeStamp", System.currentTimeMillis() - 235000);

        Document document4 = new Document("message", "I Love TDD 4").append("timeStamp", System.currentTimeMillis() - 235000);


        final Document document5 = new Document("message", "I Love TDD 5").append("timeStamp", System.currentTimeMillis() - 256800);
        final Document document6 = new Document("message", "I Love TDD 6").append("timeStamp", System.currentTimeMillis() - 3200);
        final Document document7 = new Document("message", "I Love TDD 7").append("timeStamp", System.currentTimeMillis() - 288);
        final Document document8 = new Document("message", "I Love TDD 8").append("timeStamp", System.currentTimeMillis() - 21230);
        final Document document9 = new Document("message", "I Love TDD 9").append("timeStamp", System.currentTimeMillis() - 10000);
        final Document document10 = new Document("message", "I Love TDD 10").append("timeStamp", System.currentTimeMillis() + 500);
        final Document document11 = new Document("message", "I Love TDD 11").append("timeStamp", System.currentTimeMillis() + 5000);
        final Document document12 = new Document("message", "I Love TDD 12").append("timeStamp", System.currentTimeMillis() + 1500);
        final Document document13 = new Document("message", "I Love TDD 13").append("timeStamp", System.currentTimeMillis() + 25500);
        final Document document14 = new Document("message", "I Love TDD 14").append("timeStamp", System.currentTimeMillis() + 64500);
        final Document document15 = new Document("message", "I Love TDD 15").append("timeStamp", System.currentTimeMillis() + 2900);
        final Document document16 = new Document("message", "I Love TDD 16").append("timeStamp", System.currentTimeMillis() + 287880);
        final Document document17 = new Document("message", "I Love TDD 17").append("timeStamp", System.currentTimeMillis() + 29000);
        final Document document18 = new Document("message", "I Love TDD 18").append("timeStamp", System.currentTimeMillis() + 21000);
        final Document document19 = new Document("message", "I Love TDD 19").append("timeStamp", System.currentTimeMillis() + 90000);
        final Document document20 = new Document("message", "I Love TDD 20").append("timeStamp", System.currentTimeMillis() + 800000);

        Mockito.when(cursor.next()).thenReturn(document1)
                .thenReturn(document2)
                .thenReturn(document3)
                .thenReturn(document4)
                .thenReturn(document5)
                .thenReturn(document6)
                .thenReturn(document7)
                .thenReturn(document8)
                .thenReturn(document9)
                .thenReturn(document10)
                .thenReturn(document11)
                .thenReturn(document12)
                .thenReturn(document13)
                .thenReturn(document14)
                .thenReturn(document15)
                .thenReturn(document16)
                .thenReturn(document17)
                .thenReturn(document18)
                .thenReturn(document19)
                .thenReturn(document20)
                .thenReturn(null);
    }
}