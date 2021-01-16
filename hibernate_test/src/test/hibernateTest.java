package test;


import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class hibernateTest {

    public static void main(String[] args) {
        //        第一步 加载hibernate核心配置文件
        Configuration cfg = new Configuration().configure();
//
//        第二步 创建SessionFactory对象
        SessionFactory sessionFactory =cfg.buildSessionFactory();

//        第三步 使用SessionFactory创建session对象
        Session session=sessionFactory.openSession();
//        第四步 开启事务
        Transaction transaction=session.beginTransaction();
//        第五步 写具体逻辑 crud操作
        User user=new User();
        user.setAge(20);
        user.setId(1);
        user.setName("zhangsan");
        user.setSex("male");
        session.save(user);
//        第六步 提交事务
        transaction.commit();
//        第七步 关闭资源
        session.close();
        sessionFactory.close();
    }

}
