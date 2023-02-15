package sr.unasat.scheduleweb;

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

        // Register the CustomJsonProvider
        classes.add(CustomJsonProvider.class);

        return classes;
    }
}
