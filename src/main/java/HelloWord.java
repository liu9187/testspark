
import bean.MyMessage;
import util.JsonTransformer;

import static spark.Spark.*;

public class HelloWord {
    public static void main(String[] args) {
        //配置
        //connection 在所有路由映射之前完成
      //  secure(keystoreFile, keystorePassword, truststoreFile, truststorePassword);

        staticFileLocation("/public");
        externalStaticFileLocation("/var/www/public");
        //端口号配置
        port(7926);
        before("/hello/*",(req,res)->{
            boolean istrue=true;
            if (istrue){
                System.out.println("------前置过滤器------");
            }
        });
        //等待服务器初始化
       // awaitInitialization();
//        get("/",(req,res)->"Hello Word");
//        get("/hello/:name",(req,res)-> "hello: "+req.params(":name"));
//       // get("/say/*/hello/*",(req,res)->"Number of splat  parameters :"+req.splat().length);
//        get("/say/*/hello/*",(req,res)->"Number of splat  parameters :"+req.port());

        get("/hello/liu","application/json",(req,res)-> new MyMessage("hello word &&"), new JsonTransformer());
//        int maxThreads = 8;
//        threadPool(maxThreads);

        after("/hello/*",(req,res)->{
            System.out.println("---------后置过滤器");
        });

    }
}
