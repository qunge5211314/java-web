import cn.itcast.lombok.User;
import org.junit.Test;

public class LombokTest {
    @Test
    public void lombokTest1(){
        User user = new User();
        user.setId(1);
        System.out.println(user.getId());
        System.out.println(user.toString());
    }

    @Test
    public void lombokTest2(){
        User user = User.builder().id(1).name("666").password("123456").age(13).email("@666.com").build();
        System.out.println(user.toString());
    }

    @Test
    public void lombokTest3(){
        User user = User.builder().id(1).name("666").password("123456").age(13).email("@666.com").build();
        System.out.println(user.toString());
    }
}
