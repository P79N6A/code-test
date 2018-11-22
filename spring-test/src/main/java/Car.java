import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by siyunfei on 2018/11/21.
 */
public class Car implements FactoryBean, InitializingBean, Closeable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public Object getObject() throws Exception {
        return new Student("xiaobai");
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("car afterPropertiesSet");
    }
}
