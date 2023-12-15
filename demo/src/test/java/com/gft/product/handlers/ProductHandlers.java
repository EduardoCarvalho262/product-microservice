package com.gft.product.handlers;
import com.gft.product.command.handlers.ProductCommandHandler;
import com.gft.product.command.model.CreateProductCommand;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;

@SpringBootTest
public class ProductHandlers {
    @Test
    public void GiveACommand_WhenPassforAHandler_ReturnALong(){
        //Arrange
        ProductCommandHandler handler = new ProductCommandHandler();
        CreateProductCommand mockedCommand = mock(CreateProductCommand.class);
        mockedCommand.setValue(9.99);
        mockedCommand.setName("Cadeira");

        //Act
         Long response = Long.valueOf(handler.handle(mockedCommand));

        //Assert
        Assert.assertNotNull(response);
    }
}
