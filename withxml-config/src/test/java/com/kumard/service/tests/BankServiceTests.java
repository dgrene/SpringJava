package com.kumard.service.tests;

import com.kumard.service.BankService;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;


public class BankServiceTests {


    BasicDataSource dataSource;
    private BankService bankService;

    @Before
    public void init() throws Exception {


        ApplicationContext ctx = new ClassPathXmlApplicationContext("main-config.xml");
        dataSource = ctx.getBean("dataSource", BasicDataSource.class);

        bankService = ctx.getBean("bankService", BankService.class);
    }

    public void destroy() {

    }

    @Test
    public void testTransfer() throws SQLException {

        Long transactionId = bankService.transfer(new Long(1), new Long(2), 5000);
        assertNotNull(transactionId);
    }
}
