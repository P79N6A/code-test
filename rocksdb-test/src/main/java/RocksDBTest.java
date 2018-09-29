import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;

public class RocksDBTest {
    static {
        RocksDB.loadLibrary();
    }

    public static void main(String[] args) throws RocksDBException {
        RocksDB rocksDB = RocksDB.open("D:\\rocksDBFile");
        rocksDB.put("name".getBytes(), "tracy".getBytes());
        System.out.println(new String(rocksDB.get("name".getBytes())));
    }
}
