import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonArray;
import com.couchbase.client.java.document.json.JsonObject;

public class CBTest {
    public static void main(String[] args) {
        Cluster cluster = CouchbaseCluster.create("localhost");
        cluster.authenticate("admin", "123456");
        Bucket bucket = cluster.openBucket("mybucket");

        JsonObject jsonObject = JsonObject.create().
                put("name", "xiaobai")
                .put("sex", "male")
                .put("interests", JsonArray.from("basketball", "read", "music"));

        bucket.upsert(JsonDocument.create("stu_xiaobai", jsonObject));
        System.out.println(bucket.get("stu_xiaobai"));
        bucket.close();
        cluster.disconnect();
    }
}
