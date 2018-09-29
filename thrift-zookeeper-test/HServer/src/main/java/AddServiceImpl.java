import org.apache.thrift.TException;
import com.demo.service.AddService;

public class AddServiceImpl implements AddService.Iface {

    @Override
    public int addTwoNumbers(int para1, int para2) throws TException {
        return para1 + para2;
    }

}
