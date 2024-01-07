package com.gft.product.controllers;
import com.gft.product.command.handlers.ProductCommandHandler;
import com.gft.product.command.model.CreateProductCommand;
import com.gft.product.command.model.DeleteProductCommand;
import com.gft.product.command.model.UpdateProductCommand;
import com.gft.product.dto.ProductDTO;
import com.gft.product.queries.handlers.ProductQueryHandler;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

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
        String expected = "Id: 1";
        when(commandHandler.createHandle(command)).thenReturn(1);

        // Act
        ResponseEntity<String> response = controller.createProduct(command);

        //Assert
        Assert.assertNotNull(response);
        Assert.assertEquals(201, response.getStatusCode().value());
        Assert.assertEquals(expected, response.getBody());
    }

    @Test
    public void giveAQuery_WhenCallHandler_ThenReturnAllProducts(){
        // Arrange
        List<ProductDTO> expectedlist = new ArrayList<>();
        ProductDTO expectedProduct = new ProductDTO("Teste", 9.99, (byte) 2, "");
        expectedlist.add(expectedProduct);
        when(queryHandler.getAllProducts()).thenReturn(expectedlist);

        // Act
        ResponseEntity<List<ProductDTO>> response = controller.getAllProducts();

        //Assert
        Assert.assertNotNull(response);
        Assert.assertEquals(expectedlist.size(), response.getBody().size());
        Assert.assertEquals(200, response.getStatusCode().value());
    }

    @Test
    public void giveADeleteCommand_WhenCallHandler_ThenReturnDeletedProductId(){
        // Arrange
        DeleteProductCommand command = new DeleteProductCommand();
        String expected = "Id deletado 1";
        when(commandHandler.deleteHandle(command)).thenReturn(1);

        // Act
        ResponseEntity<String> response = controller.deleteProductById(command);

        //Assert
        Assert.assertNotNull(response.getBody());
        Assert.assertEquals(expected, response.getBody());
        Assert.assertEquals(200, response.getStatusCode().value());
    }

    @Test
    public void giveAUpdateCommand_WhenPassToController_ThenReturnUpdatedProductId(){
        // Arrange
        UpdateProductCommand command = new UpdateProductCommand();
        when(commandHandler.updateHandle(command)).thenReturn(1);

        // Act
        ResponseEntity<String> response = controller.updateProduct(1,command);

        //Assert
        Assert.assertNotNull(response);
        Assert.assertEquals(204, response.getStatusCode().value());
    }

    @Test
    public void giveAQueryGetById_WhenPassIdToController_ThenReturnOneProduct(){
        // Arrange
        Integer productId = 1;
        when(queryHandler.getProductById(productId)).thenReturn(new ProductDTO("Teste", 9.99, (byte) 5, ""));

        // Act
        ResponseEntity<ProductDTO> response = controller.getProductById(productId);

        //Assert
        Assert.assertNotNull(response);
        Assert.assertEquals("Teste", response.getBody().name);
        Assert.assertEquals(9.99, response.getBody().value, 0.01);
        Assert.assertEquals(200, response.getStatusCode().value());
    }
}
