package com.atguigu.bean;

public class Color {

    private Car car;

    public Car getCar() {
        return car;
    }

    public Color setCar(Car car) {
        this.car = car;
        return this;
    }

    @Override
    public String toString() {
        return "Color{" +
                "car=" + car +
                '}';
    }
}
