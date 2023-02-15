import com.chen.config.DbConfig;
import com.chen.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**声明式事务
 * @Author @Chenxc
 * @Date 2023/2/15 11:55
 */
public class ShengmingTransaction {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(DbConfig.class);
        context.refresh();
        UserService userService = context.getBean(UserService.class);
        userService.insert();
    }

}
