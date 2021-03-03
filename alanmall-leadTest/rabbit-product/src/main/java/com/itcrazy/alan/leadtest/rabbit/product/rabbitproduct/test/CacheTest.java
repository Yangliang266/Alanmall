package com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.test;

/**
 * @Auther: mathyoung
 * @description:
 */
public class CacheTest {
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CacheTest{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
