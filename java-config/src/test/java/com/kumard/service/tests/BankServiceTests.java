package com.kumard.service.tests;

import com.kumard.config.ApplicationConfig;
import com.kumard.config.InfrastructureConfig;
import com.kumard.service.BankService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.jdbc.Sql;

import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;


@Sql({"classpath:dbscripts.sql"})
public class BankServiceTests {

    private BankService bankService;


    @Before
    public void init() throws Exception {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class, InfrastructureConfig.class);
        /*ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("main-config.xml");*/
        bankService = ctx.getBean("bankService", BankService.class);
    }

    @Test
    public void testTransfer() throws SQLException {

        Long transactionId = bankService.transfer(new Long(1), new Long(2), 5000);
        assertNotNull(transactionId);
    }

}
