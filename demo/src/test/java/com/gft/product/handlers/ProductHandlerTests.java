package com.gft.product.handlers;
import com.gft.product.command.handlers.ProductCommandHandler;
import com.gft.product.command.model.CreateProductCommand;
import com.gft.product.command.model.DeleteProductCommand;
import com.gft.product.command.model.UpdateProductCommand;
import com.gft.product.model.Product;
import com.gft.product.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ProductHandlerTests {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductCommandHandler commandHandler;


    @Test
    public void GiveACommand_WhenPassAHandler_ReturnAInteger(){
        //Arrange
        CreateProductCommand newCommand = new CreateProductCommand();
        newCommand.setValue(9.99);
        newCommand.setName("Cadeira");
        when(productRepository.save(Mockito.any(Product.class)))
                .thenReturn(new Product(1, newCommand.getName(), newCommand.getValue()));

        //Act
         Integer response = commandHandler.createHandle(newCommand);

        //Assert
        Assert.assertNotNull(response);
    }

    @Test
    public void GiveADeleteCommand_WhenPassAHandler_ReturnAInteger(){
        //Arrange
        DeleteProductCommand mockedCommand = mock(DeleteProductCommand.class);
        mockedCommand.setId(1);
        when(productRepository.findById(Mockito.any(Integer.class)))
                .thenReturn(Optional.of(new Product(1, "Teste", 9.99)));

        //Act
        Integer response = commandHandler.deleteHandle(mockedCommand);

        //Assert
        Assert.assertNotNull(response);
    }


    @Test
    public void GiveAUpdateCommand_WhenPassACommandToHandler_ReturnAIdUpdated(){
        //Arrange
        UpdateProductCommand updateCommand = new UpdateProductCommand();
        when(productRepository.save(Mockito.any(Product.class)))
                .thenReturn(new Product(1, updateCommand.getName(), updateCommand.getValue()));

        //Act
        Integer response = commandHandler.updateHandle(updateCommand);

        //Assert
        Assert.assertNotNull(response);
    }
}
