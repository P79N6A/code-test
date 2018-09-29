import com.mchange.v2.c3p0.cfg.C3P0Config;

import java.beans.IntrospectionException;

public class ModuleB {
    public static void main(String[] args){
        System.out.println("hello");
        ModuleA.printA();
        try {
            C3P0Config.bindNamedConfigToBean(new Object(), new String());
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }
}
