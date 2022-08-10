package servlet;

import com.j16.pojo.Detail;
import com.j16.service.impl.DetailServiceImpl;
import com.j16.service.impl.TypeServiceImpl;

import java.lang.reflect.Type;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Detail> detail = new DetailServiceImpl().showFlowers();
        detail.forEach(System.out ::println);

    }
}
