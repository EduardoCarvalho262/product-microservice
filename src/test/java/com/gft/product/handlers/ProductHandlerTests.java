package com.gft.product.handlers;
import com.gft.product.command.handlers.ProductCommandHandler;
import com.gft.product.command.model.CreateProductCommand;
import com.gft.product.command.model.DeleteProductCommand;
import com.gft.product.command.model.UpdateProductCommand;
import com.gft.product.dto.ProductDTO;
import com.gft.product.model.Product;
import com.gft.product.queries.handlers.ProductQueryHandler;
import com.gft.product.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ProductHandlerTests {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductCommandHandler commandHandler;


    @InjectMocks
    private ProductQueryHandler queryHandler;


    @Test
    public void GiveACommand_WhenPassAHandler_ReturnAInteger(){
        //Arrange
        CreateProductCommand newCommand = new CreateProductCommand();
        newCommand.setValue(9.99);
        newCommand.setName("Cadeira");
        when(productRepository.save(Mockito.any(Product.class)))
                .thenReturn(new Product(1, newCommand.getName(), newCommand.getValue(), (byte) 4, ""));

        //Act
        ResponseEntity<String>  response = commandHandler.createHandle(newCommand);

        //Assert
        Assert.assertNotNull(response);
    }

    @Test
    public void GiveADeleteCommand_WhenPassAHandler_ReturnAInteger(){
        //Arrange
        DeleteProductCommand mockedCommand = mock(DeleteProductCommand.class);
        mockedCommand.setId(1);
        when(productRepository.findById(Mockito.any(Integer.class)))
                .thenReturn(Optional.of(new Product(1, "Teste", 9.99, (byte) 4, "")));

        //Act
        ResponseEntity<String> response = commandHandler.deleteHandle(mockedCommand);

        //Assert
        Assert.assertNotNull(response);
    }


    @Test
    public void GiveAUpdateCommand_WhenPassACommandToHandler_ReturnAIdUpdated(){
        //Arrange
        UpdateProductCommand updateCommand = new UpdateProductCommand();
        when(productRepository.save(Mockito.any(Product.class)))
                .thenReturn(new Product(1, updateCommand.getName(), updateCommand.getValue(),(byte) 4, ""));

        //Act
        ResponseEntity<String>  response = commandHandler.updateHandle(updateCommand, 1);

        //Assert
        Assert.assertNotNull(response);
    }

    @Test
    public void GiveAProductId_WhenPassAQueryToHandler_ReturnAProduct(){
        //Arrange
        Integer productId = 1;
        when(productRepository.findById(Mockito.any(Integer.class)))
                .thenReturn(Optional.of(new Product(1, "Teste", 9.99, (byte) 4, "")));

        //Act
        ResponseEntity<ProductDTO> response = queryHandler.getProductById(productId);

        //Assert
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        Assert.assertEquals("Teste", response.getBody().name);
        Assert.assertEquals(Optional.of(9.99).get(), response.getBody().value);
    }
}
