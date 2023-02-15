package sr.unasat.scheduleweb;

import org.glassfish.jersey.jackson.JacksonFeature;
import sr.unasat.scheduleweb.controller.BreakTimeController;
import sr.unasat.scheduleweb.controller.CustomJsonProvider;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class MyApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();

        // Add your resource classes here
        classes.add(BreakTimeController.class);

        // Add the CustomJsonProvider to serialize/deserialize Java 8 Date/Time API objects
        classes.add(CustomJsonProvider.class);

        return classes;
    }
}


