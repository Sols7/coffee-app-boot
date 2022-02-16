package ru.itsjava.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itsjava.domain.Coffee;

@SpringBootTest
@DisplayName("Класс CoffeeServiceImpl")
public class CoffeeServiceImplTest {
    public static final double PRICE = 100.0;

    @Configuration
    static class MyConfiguration {

        @Bean
        public CoffeeService coffeeService() {
            return new CoffeeServiceImpl();
        }
    }

    @Autowired
    private CoffeeServiceImpl coffeeService;

    @DisplayName(" должен корректно отдавать кофе")
    @Test
    public void shouldHaveCorrectMethodGetCoffeeByPrice() {
        Coffee coffee = coffeeService.getCoffeeByPrice(PRICE);
        Assertions.assertEquals("Latte", coffee.getType());
    }

}
