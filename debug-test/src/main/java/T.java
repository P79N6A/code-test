import com.google.gson.Gson;
import com.iqiyi.ttbrain.debug.DebugDataService;
import com.iqiyi.ttbrain.debug.entity.BasicRequestEntity;
import com.iqiyi.ttbrain.debug.entity.RequestDebugEntity;
import com.iqiyi.ttbrain.debug.entity.related.RelatedRequestEntity;

import java.util.List;

public class T {
    public static void main(String[] args) {
        DebugDataService service = DebugDataService.getInstance();
        /*try {
            service.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<? extends BasicRequestEntity> list = service.getRequestByUid("RELATED",
                "933A85BF-B504-4D0C-8DF2-269B65353734",
                1536768000, 1536850800);

        for (BasicRequestEntity entity : list) {
            RelatedRequestEntity e = (RelatedRequestEntity) entity;
            System.out.println(new Gson().toJson(e));
        }*/
        List<RequestDebugEntity> e2we = service.getRequestByUid("e2we", 231231l, 342342l);
        System.exit(0);
    }
}
