package ru.itsjava.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Класс Coffee должен: ")
public class CoffeeTest {
    public static final String TYPE = "Latte";

    @DisplayName(" корректно создаваться конструктором")
    @Test
    public void shouldHaveCorrectConstructor() {
        Coffee coffee = new Coffee(TYPE);
        assertEquals(TYPE, coffee.getType());
    }

    @DisplayName(" корректно выполнять метод toString")
    @Test
    public void shouldHaveCorrectMethodToString() {
        Coffee coffee = new Coffee(TYPE);
        assertEquals("Coffee{" + TYPE + "}", coffee.toString());
    }

}
