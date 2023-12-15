package com.gft.product.controllers;
import com.gft.product.command.handlers.ProductCommandHandler;
import com.gft.product.command.model.CreateProductCommand;
import com.gft.product.dto.ProductDTO;
import com.gft.product.queries.handlers.ProductQueryHandler;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ProductControllerTests {

    @Mock
    private ProductCommandHandler commandHandler;

    @Mock
    private ProductQueryHandler queryHandler;

    @InjectMocks
    private ProductController controller;


    @Test
    public void giveAPing_WhenCallMethod_ThenReturnPong(){
        // Arrange
        String expected = "Pong";

        // Act
        String response = controller.Ping();

        //Assert
        Assert.assertNotNull(response);
        Assert.assertEquals(expected, response);
    }

    @Test
    public void giveACommand_WhenCallHandler_ThenReturnProductId(){
        // Arrange
        CreateProductCommand command = new CreateProductCommand();
        command.setName("Teste");
        command.setValue(99.99);
        Integer expected = 1;
        when(commandHandler.handle(command)).thenReturn(1);

        // Act
        Integer response = controller.createProduct(command);

        //Assert
        Assert.assertNotNull(response);
        Assert.assertEquals(expected, response);
    }

    @Test
    public void giveAQuery_WhenCallHandler_ThenReturnAllProducts(){
        // Arrange
        List<ProductDTO> expectedlist = new ArrayList<ProductDTO>();
        ProductDTO expectedProduct = new ProductDTO("Teste", 9.99);
        expectedlist.add(expectedProduct);
        when(queryHandler.getAllProducts()).thenReturn(expectedlist);

        // Act
        List<ProductDTO> response = controller.getAllProducts();

        //Assert
        Assert.assertNotNull(response);
        Assert.assertEquals(expectedlist.size(), response.size());
    }

}
