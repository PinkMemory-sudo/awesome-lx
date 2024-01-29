package webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * WebService服务端案例
 *
 * @author AlanLee
 * @version 2017/06/02
 * 使用@WebService注解标注实现类
 */


@WebService(targetNamespace ="web" )
public class HelloWorldServiceTest {

    @WebMethod
    public String sayHello(@WebParam(name = "name")  String name) {
        return "Hello, " + name + "!";
    }

    public static void main(String[] args) {
        // 发布 Web 服务
        Endpoint.publish("http://localhost:8080/hello", new HelloWorldServiceTest());

        System.out.println("Web服务已启动：http://localhost:8080/hello");
    }
}


