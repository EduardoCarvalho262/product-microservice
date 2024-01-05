package com.gft.product.util;


import com.gft.product.model.Product;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UtilTests {

    @Test
    public void GiveAImagePath_WhenUseMethod_ReturnAStringBase64(){
        //Arrange
        Product product = new Product();
        product.setImage("image.png");

        //Act
        String base64 = Util.imageToBase64(product.getImage());

        //Asserts
        Assert.assertNotNull(base64);
    }
}
