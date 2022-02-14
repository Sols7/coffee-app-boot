package ru.itsjava.services;

import org.springframework.stereotype.Service;
import ru.itsjava.domain.Coffee;

@Service
public class CoffeeServiceImpl implements CoffeeService {

    @Override
    public Coffee getCoffeeByPrice(double price) {
        if (price == 70.0) {
            return new Coffee("Americano");
        } else if (price == 100.0) {
            return new Coffee("Latte");
        } else if (price == 120.0) {
            return new Coffee("Cappuccino");
        } else {
            return new Coffee("No Coffee for you price");
        }
    }
}
