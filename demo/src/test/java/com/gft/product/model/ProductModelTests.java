package com.gft.product.model;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ProductModelTests {


    @Test
    public void GiveAObject_WhenCreate_ThenReturnAProductObject() {
        //Arrange
        Product product = new Product("Mouse", 9.99);
        String expectedName = "Mouse";
        Double expectedValue = 9.99;

        //Act
        String nameResponse = product.getName();
        Double valueResponse = product.getValue();


        //Assert
        Assert.assertNotNull(nameResponse);
        Assert.assertNotNull(valueResponse);
        Assert.assertEquals(expectedName, nameResponse);
        Assert.assertEquals(expectedValue, valueResponse);
    }

    @Test
    public void GiveAObject_WhenCallField_ThenReturnValueOfFields() {
        //Arrange
        Product product = new Product("Mouse", 9.99);

        //Assert
        Assert.assertNotNull(product.getName());
        Assert.assertNotNull(product.getValue());
    }
}
