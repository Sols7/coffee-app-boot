package ru.itsjava.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itsjava.domain.Coffee;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("Класс CoffeeHouseImpl")
public class CoffeeHouseImplTest {

    @Configuration
    static class MyConfiguration {
        public static final double PRICE = 100.0;

        @Bean
        public IOService ioService() {
            IOServiceImpl mockIOService = Mockito.mock(IOServiceImpl.class);
            when(mockIOService.inputPrice()).thenReturn(PRICE);
            return mockIOService;
        }

        @Bean
        public CoffeeService coffeeService() {
            CoffeeServiceImpl mockNotebookService = mock(CoffeeServiceImpl.class);
            when(mockNotebookService.getCoffeeByPrice(PRICE)).thenReturn(new Coffee("Latte"));
            return mockNotebookService;
        }

        @Bean
        public CoffeeHouse coffeeHouse(CoffeeService coffeeService, IOService ioService) {
            return new CoffeeHouseImpl(coffeeService, ioService);
        }
    }

    @Autowired
    private CoffeeHouse coffeeHouse;

    @DisplayName(" корректный метод buyCoffee")
    @Test
    public void shouldHaveCorrectBuyCoffee() {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        coffeeHouse.buyCoffee();
        assertEquals("Hello! \r\n" +
                "Our coffee menu: \n" +
                "Americano - 70 \n" +
                "Latte - 100 \n" +
                "Cappuccino - 120\r\n" +
                "Enter your price: \r\n" +
                "Your coffee: Coffee{Latte}\r\n", out.toString());
    }

}
