package uz.pdp.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import uz.pdp.entity.BookEntity;
import uz.pdp.entity.UserEntity;

public class HibernateUtil {
    private static final HibernateUtil instance=new HibernateUtil();
    private final SessionFactory sessionFactory;

    public static HibernateUtil getInstance(){
        return instance;
    }

    private HibernateUtil(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml")
                .addAnnotatedClass(UserEntity.class).addAnnotatedClass(BookEntity.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session getSession(){
        return getInstance().sessionFactory.openSession();
    }
}
