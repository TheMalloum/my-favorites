package ca.bnc.demo.api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class DemoApplication extends Application {

    private Set < Object > singletons = new HashSet < Object > ();

    public DemoApplication() {
        singletons.add(new HelloWorldResource());
    }

    @Override
    public Set < Object > getSingletons() {
        return singletons;
    }
}