import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;

public class RocksDBTest {
    static {
        RocksDB.loadLibrary();
    }

    public static void main(String[] args) throws RocksDBException {
        RocksDB rocksDB = RocksDB.open("D:\\rocksDBFile");
        rocksDB.put("name".getBytes(), "tracy".getBytes());
        long start = System.currentTimeMillis();
        byte[] name = rocksDB.get("name".getBytes());
        System.out.println(System.currentTimeMillis() - start);
    }
}
