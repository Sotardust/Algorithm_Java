package com.dai.designpattern.factorypattern;

/**
 * created by Administrator on 2018/11/12 14:04
 */
public class ChicagoPizzaStore extends PizzaStore {


    @Override
    protected Pizza createPizza(String type) {

        if ("cheese".equals(type)) {
            return new ChicagoStyleCheesePizza();
        } else if ("veggie".equals(type)) {
            return new ChicagoStyleCheesePizza();
        } else if ("clam".equals(type)) {
            return new ChicagoStyleCheesePizza();
        } else if ("pepperoni".equals(type)) {
            return new ChicagoStyleCheesePizza();
        }
        return null;
    }
}
