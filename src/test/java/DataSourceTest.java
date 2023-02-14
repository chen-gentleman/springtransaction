import com.chen.DataSourceUtils;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

/**
 * @Author @Chenxc
 * @Date 2023/2/14 10:49
 */
public class DataSourceTest {
    private static JdbcTemplate template;

    @Before
    public void before(){
        DataSource dataSource = DataSourceUtils.getDataSource();
        template = new JdbcTemplate(dataSource);
    }


    @Test
    public void test1(){
        List<Map<String, Object>> maps = template.queryForList("select * from t_employee");
        System.out.println(maps);
    }

    @Test
    public void test2(){
        int update = template.update("insert into t_employee (emp_name,team_id) values ('陈杏昌',4)");
        System.out.println("影响行数："+update);
    }


    //获取自增列的值
    @Test
    public void test3(){
        final String sql = "insert into t_employee (emp_name,team_id) values (?,?)";
        KeyHolder holder = new GeneratedKeyHolder();
        template.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,"20230214");
                ps.setInt(2,14);
                return ps;
            }
        },holder);
        System.out.println(holder.getKey().intValue());
    }

}
