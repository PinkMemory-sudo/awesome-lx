package webservice;

import lombok.extern.slf4j.Slf4j;

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

@Slf4j
@WebService(targetNamespace = "http://tempuri.org/")
public class HelloWorldServiceTest {

    @WebMethod
    public String sayHello(@WebParam(name = "user") String name) {
        log.info("name:{}",name);
        return "Hello, " + name + "!";
    }

    public static void main(String[] args) {
        // 发布 Web 服务
        Endpoint.publish("http://localhost:8080/hello", new HelloWorldServiceTest());

        System.out.println("Web服务已启动：http://localhost:8080/hello");
    }
}


