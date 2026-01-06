package proxy;

import services.IService;
import services.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class ProxyCache implements IService {
    private ServiceImpl service = new ServiceImpl();
    private Map<Integer,Double> cache = new HashMap<>();
    @Override
    public double compute(int t) {
        if (service == null){service = new ServiceImpl();}
        if(!cache.containsKey(t)){
            double res = service.compute(t);
            cache.put(t,res);
            return res;
        } else {
        return cache.get(t);
        }
    }
}
