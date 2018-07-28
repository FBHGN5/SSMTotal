package org.total.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class OrdersMapperTest {
    @Autowired
    private  OrdersMapper ordersMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Test
    public void selectCustomerById() {
        System.out.println(ordersMapper.selectByPrimaryKey(1).getCustomer());
    }
    @Test
    public void selectOrdersById() {
        System.out.println(customerMapper.selectByPrimaryKey(5).getOrders());
    }
    @Test
    public void selectInfo() {
        System.out.println(customerMapper.selectInfo("八戒222").get(0).getCustomer());
    }
}