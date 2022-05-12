import com.hnsoft.po.IdCard;
import com.hnsoft.po.Person;
import com.hnsoft.po.User;
import com.hnsoft.utils.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyBatisTest {
    @Test
    public void selectUserByIdTest() throws  Exception{
//        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = MybatisUtil.getSession();
        com.hnsoft.dao.User user = sqlSession.selectOne("selectUserById", 1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void selectUserByNameTest() throws  Exception{
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
         List<com.hnsoft.dao.User> users =  sqlSession.selectList("selectUserByName", "h");
        System.out.println(users);
        sqlSession.close();
    }
    @Test
    public void addUserTest() throws  Exception{
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        com.hnsoft.dao.User user = new com.hnsoft.dao.User();
        user.setName("laownag");
        user.setPassword("lw11122");
        int row =  sqlSession.insert("com.hnsoft.po.User.insertUser",user);
        if (row>0){
            System.out.println("写入"+row+"条信息");
        }else {
            System.out.println("写入失败！");
        }
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updateUserTest() throws  Exception{
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        com.hnsoft.dao.User user = new com.hnsoft.dao.User();
        user.setId(1);
        user.setName("zhangsan");
        user.setPassword("zhangsan11122");
        int upd =  sqlSession.update("com.hnsoft.po.User.updateUser",user);
        if (upd>0){
            System.out.println("更新"+upd+"条信息");
        }else {
            System.out.println("更新失败！");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deletUserTest() throws  Exception{
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        com.hnsoft.dao.User user = new com.hnsoft.dao.User();
        user.setId(1);
        int upd =  sqlSession.delete("com.hnsoft.po.User.updateUser",user);
        if (upd>0){
            System.out.println("删除"+upd+"条信息");
        }else {
            System.out.println("删除失败！");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectUserByAndTest() throws Exception{

        SqlSession sqlSession = MybatisUtil.getSession();

        User user = new User();
        user.setUsername("张三");
        user.setAge(12);
        user.setSex("男");

        List<User> users = sqlSession.selectList("selectUserByAnd",user );
        System.out.println(users);
        sqlSession.close();

    }

    @Test
    public void selectUserByChoseTest() throws Exception{

        SqlSession sqlSession = MybatisUtil.getSession();

        User user = new User();
        user.setUsername("张三");
        user.setAge(12);
        user.setSex("男");

        List<User> users = sqlSession.selectList("selectUserByChose",user );
        System.out.println(users);
        sqlSession.close();

    }

    @Test
    public void updateUserBysetTest() throws Exception{

        SqlSession sqlSession = MybatisUtil.getSession();

        User user = new User();
        user.setUserid(1);
        user.setUsername("张大三");
        user.setAge(12);
        user.setSex("男");

       int row  = sqlSession.update("updateUserByset",user );
        sqlSession.commit();
        System.out.println(row);
        sqlSession.close();

    }
    @Test
    public void selectUserByInTest() throws Exception{

        SqlSession sqlSession = MybatisUtil.getSession();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(6);


        List<User> users = sqlSession.selectList("selectUserByIn",list );
        System.out.println(users);
        sqlSession.close();

    }

    @Test
    public void selectPersonWithIdCardTest() throws Exception{

        SqlSession sqlSession = MybatisUtil.getSession();
        Person person = sqlSession.selectOne("selectPersonWithIdCard", 1);
        System.out.println(person.getName());
        System.out.println(person.getIdCard().getCode());
        sqlSession.close();

    }
    @Test
    public void selectPersonWithIdCard2Test() throws Exception{

        SqlSession sqlSession =MybatisUtil.getSession();
        Person person = sqlSession.selectOne("selectPersonWithIdCard2", 1);
        System.out.println(person.getName());

        sqlSession.close();

    }
    @Test
    public void selectUserWithOrdersTest() throws Exception{

        SqlSession sqlSession = MybatisUtil.getSession();
        com.hnsoft.po1.User user = sqlSession.selectOne("selectUserWithOrders", 1);
        System.out.println(user);

        sqlSession.close();

    }
    @Test
    public void selectUserWithOrders1Test() throws Exception{

        SqlSession sqlSession = MybatisUtil.getSession();
        com.hnsoft.po1.User user = sqlSession.selectOne("selectUserWithOrders1", 1);
        System.out.println(user);

        sqlSession.close();

    }
}
