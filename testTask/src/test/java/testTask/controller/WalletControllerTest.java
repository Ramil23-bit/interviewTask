package testTask.controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class WalletControllerTest {

    private static SessionFactory sessionFactory;

    @BeforeAll
    public static void openSession() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @AfterAll
    public static void existSession(){
        if(sessionFactory != null){
            sessionFactory.close();
        }
    }
}
