import com.ppc.entity.Goods;
import com.ppc.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*.xml")
public class test {
    @Autowired
    GoodsService goodsService;
    @Test
    public void myTest(){
        Goods goods = goodsService.getById(1);
        System.out.println("goods = " + goods);

    }
}
