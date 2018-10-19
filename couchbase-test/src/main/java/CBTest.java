import com.couchbase.client.CouchbaseClient;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonArray;
import com.couchbase.client.java.document.json.JsonObject;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;

public class CBTest {
    public static void main(String[] args) {
        /*Cluster cluster = CouchbaseCluster.create("localhost");
        cluster.authenticate("admin", "123456");
        Bucket bucket = cluster.openBucket("mybucket");

        JsonObject jsonObject = JsonObject.create().
                put("name", "xiaobai")
                .put("sex", "male")
                .put("interests", JsonArray.from("basketball", "read", "music"));

        bucket.upsert(JsonDocument.create("stu_xiaobai", jsonObject));
        System.out.println(bucket.get("stu_xiaobai"));
        bucket.close();
        cluster.disconnect();*/

        List<URI> uris = new LinkedList<URI>();
        uris.add(URI.create("http://127.0.0.1:8091/pools"));
        CouchbaseClient client = null;
        try {
            client = new CouchbaseClient(uris, "mybucket", "123456");
        } catch (Exception e) {
            System.err.println("Error connecting to Couchbase: "
                    + e.getMessage());
            System.exit(0);
        }
    }
}
