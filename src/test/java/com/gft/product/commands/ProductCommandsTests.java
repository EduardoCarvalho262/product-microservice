package com.gft.product.commands;

import com.gft.product.command.model.CreateProductCommand;
import com.gft.product.command.model.DeleteProductCommand;
import com.gft.product.command.model.UpdateProductCommand;
import com.gft.product.model.Product;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URL;


@SpringBootTest
public class ProductCommandsTests {

    @Test
    public void GiveCreateACommand_WhenCreate_ThenReturnANewCommand(){
        //Arrange
        CreateProductCommand createProductCommand = new CreateProductCommand();
        String expectedName = "Teste";
        Double expectedValue = 9.99;
        String expectedImage =  String.valueOf(ClassLoader.getSystemResource("assets/imageTest.jpg"));

        //Act
        createProductCommand.setName("Teste");
        createProductCommand.setValue(9.99);
        createProductCommand.setImage(String.valueOf(ClassLoader.getSystemResource("assets/imageTest.jpg")));

        //Assert
        Assert.assertEquals(expectedName, createProductCommand.getName());
        Assert.assertEquals(expectedValue, createProductCommand.getValue());
        Assert.assertEquals(expectedImage, createProductCommand.getImage());
    }

    @Test
    public void GiveDeleteACommand_WhenDelete_ThenReturnANewDeleteCommand(){
        //Arrange
        DeleteProductCommand deleteProductCommand = new DeleteProductCommand();
        Integer expectedId = 1;

        //Act
        deleteProductCommand.setId(1);

        //Assert
        Assert.assertEquals(expectedId, deleteProductCommand.getId());
    }



    @Test
    public void GiveUpdateACommand_WhenUpdate_ThenReturnANewProduct(){
        //Arrange
        String oldImage = String.valueOf(ClassLoader.getSystemResource("assets/imageTest.jpg"));;
        Product oldProduct = new Product(1,"Teste1", 9.99, (byte) 5, oldImage);
        UpdateProductCommand updateProductCommand = new UpdateProductCommand();


        //Act
        updateProductCommand.setId(oldProduct.getId());
        updateProductCommand.setName(oldProduct.getName());
        updateProductCommand.setValue(oldProduct.getValue());
        updateProductCommand.setImage(oldProduct.getImage());

        //Assert
        Assert.assertEquals(oldProduct.getId(), updateProductCommand.getId());
        Assert.assertEquals(oldProduct.getName(), updateProductCommand.getName());
        Assert.assertEquals(oldProduct.getValue(), updateProductCommand.getValue());
        Assert.assertEquals(oldProduct.getImage(), updateProductCommand.getImage());
    }
}