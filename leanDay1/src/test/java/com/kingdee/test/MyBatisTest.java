package com.kingdee.test;

import com.kingdee.dao.IUserDao;
import com.kingdee.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    public static void main(String[] args) {
        //1.创建sqlSessionBuilder 对象
        SqlSessionFactoryBuilder sqlSeBuilder=new SqlSessionFactoryBuilder();//构建者模式 优势：把对象的创建细节隐藏，使用者直接调方法拿对象，简化代码
        try {
            //读取配置文件
            InputStream mybatisMappingInput= Resources.getResourceAsStream("SqlMapConfig.xml");
            //2.获得sqlsessionFactory 对象
            SqlSessionFactory sessionFac=sqlSeBuilder.build(mybatisMappingInput);//sqlSeBuilder为构建者
            //3.获得sqlSession对象
            SqlSession sqlSession=sessionFac.openSession();//工厂模式 优势：解耦（降低类之间的依赖关系）
            System.out.println(sqlSession);
            //4.获得UserDao接口动态代理对象 使用代理模式 优势：不改变源码的基础上对已有方法增强
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
    @Test
    public void findOne(){

    }
    public static void getSqlSession(){

    }
}
