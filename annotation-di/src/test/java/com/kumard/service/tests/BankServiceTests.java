package com.kumard.service.tests;

import com.kumard.service.BankService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;


public class BankServiceTests {


    private BankService bankService;

    @Before
    public void init() throws Exception {


        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("main-config.xml");
        bankService = ctx.getBean("bankService", BankService.class);
        ctx.close();
    }

    @Test
    public void testTransfer() throws SQLException {

        Long transactionId = bankService.transfer(new Long(1), new Long(2), 5000);
        assertNotNull(transactionId);
    }

}
