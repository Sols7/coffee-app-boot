package ru.itsjava.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("coffeeHouse")
@RequiredArgsConstructor
public class CoffeeHouseImpl implements CoffeeHouse{
    private final CoffeeService coffeeService;
    private final IOService ioService;

    @Override
    public void buyCoffee() {
        System.out.println("Hello! ");
        System.out.println("Our coffee menu: \n" + "Americano - 70 \n" + "Latte - 100 \n" + "Cappuccino - 120");
        System.out.println("Enter your price: ");
        double price = ioService.inputPrice();
        System.out.println("Your coffee: " + coffeeService.getCoffeeByPrice(price));
    }
}
