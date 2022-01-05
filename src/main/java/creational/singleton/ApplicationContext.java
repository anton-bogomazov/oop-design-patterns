package creational.singleton;

public class ApplicationContext {

    private static ApplicationContext instance = null;

    private final String classpath;

    private ApplicationContext(String classpath) {
        this.classpath = classpath;
    }

    public static ApplicationContext getInstance() {
        if (instance == null) {
            instance = new ApplicationContext("default");
        }

        return instance;
    }

    public String getClasspath() {
        return classpath;
    }

}
