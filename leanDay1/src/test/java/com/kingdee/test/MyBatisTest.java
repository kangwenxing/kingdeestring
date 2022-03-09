package com.kingdee.test;

import com.kingdee.dao.IUserDao;
import com.kingdee.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    public static void main(String[] args) {
//1.创建sqlSessionBuilder 对象

        SqlSessionFactoryBuilder sqlSeBuilder=new SqlSessionFactoryBuilder();
        //2.获得sqlsessionFactory 对象
        try {
            InputStream mybatisMappingInput= Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory sessionFac=sqlSeBuilder.build(mybatisMappingInput);
            //3.获得sqlSession对象
            SqlSession sqlSession=sessionFac.openSession();
            System.out.println(sqlSession);

            //4.获得UserDao接口动态代理对象
            IUserDao userMapper=sqlSession.getMapper(IUserDao.class) ;
            List<User> userList=userMapper.findAll();//调用查询方法
            for (User user : userList) {
                System.out.println(user);
            }
            sqlSession.close();
            mybatisMappingInput.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
