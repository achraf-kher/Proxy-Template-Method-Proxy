import controllers.Client;
import proxy.ProxyCache;
import proxy.SecuredProxy;
import services.IService;
import services.ServiceImpl;

import java.security.Provider;

public class Test {
    public static void main(String[] args) {
        //IService service = new ServiceImpl();
        IService proxy = new ProxyCache();
        //IService service = new ServiceImpl();
        var securedProxy = new SecuredProxy();
        securedProxy.setPassword("1234");
        securedProxy.setTarget(proxy);


        Client client = new Client();
        client.setService(securedProxy);
        System.out.println("RES="+client.perform(23));
        System.out.println("RES="+client.perform(23));
        System.out.println("RES="+client.perform(23));




    }
}
