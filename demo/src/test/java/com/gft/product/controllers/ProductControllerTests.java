package com.gft.product.controllers;
import org.junit.Assert;
import org.junit.Test;

public class ProductControllerTests {

    @Test
    public void giveAPing_WhenCallMethod_ThenReturnPong(){
        // Arrange
        ProductController controller = new ProductController();
        String expected = "Pong";

        // Act
        String response = controller.Ping();

        //Assert
        Assert.assertNotNull(response);
        Assert.assertEquals(expected, response);
    }

}
