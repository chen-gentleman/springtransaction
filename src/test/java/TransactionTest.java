import com.chen.DataSourceUtils;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @Author @Chenxc
 * @Date 2023/2/14 11:43
 */
public class TransactionTest {
    private JdbcTemplate template;
    private DataSource dataSource;

    @Before
    public void before(){
        dataSource = DataSourceUtils.getDataSource();
        template = new JdbcTemplate(dataSource);
    }


    @Test
    public void test1(){
        //1.定义事务管理器，给其指定一个数据源（可以把事务管理器想象为一个人，这个人来负责事务的控制操作）
        PlatformTransactionManager transactionManager = new  DataSourceTransactionManager(dataSource);
        //2.定义事务属性：TransactionDefinition，TransactionDefinition可以用来配置事务的属性信息，比如事务隔离级别、事务超时时间、事务传播方式、是否是只读事务等等。
        TransactionDefinition definition = new DefaultTransactionDefinition();
        //3.开启事务：调用platformTransactionManager.getTransaction开启事务操作，得到事务状态(TransactionStatus)对象
        TransactionStatus status = transactionManager.getTransaction(definition);
        try{
            System.out.println("before:" + template.queryForList("SELECT * from t_employee"));
            template.update("insert into t_employee (emp_name,team_id) values (?,?)","20",23);
            template.update("insert into t_employee (emp_name,team_id) values (?,?)","02",14);
            //5.提交事务：platformTransactionManager.commit
            transactionManager.commit(status);
        }catch (Exception e){
            //6.回滚事务：platformTransactionManager.rollback
            transactionManager.rollback(status);
        }
        System.out.println("after:" + template.queryForList("SELECT * from t_employee"));
    }
}
