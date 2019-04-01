package config;
import static spark.Spark.*;
public class DefaulConfig {

    private void config(){
        staticFileLocation("/public");
    }
}
