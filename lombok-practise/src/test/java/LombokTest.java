import cn.itcast.lombok.User;
import org.junit.Test;

public class LombokTest {
    @Test
    public void lombokTest1(){
        User user = new User(1, "zhangsan", 18, "@qq.com", "123456");
        user.setId(2);
        System.out.println(user.getId());
    }
}
