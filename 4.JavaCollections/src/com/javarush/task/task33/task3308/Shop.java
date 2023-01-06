package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement
@XmlType(name = "shop")
public class Shop {
    public Goods goods = new Goods();
    public int count;
    public double profit;
    public String[] secretData = new String[]{"String1", "String2", "String3", "String4", "String5", "String \"6\"", "String & 7", "String <8>", ""};

    public Shop(int count, double profit, String... goodsNames) {
        this.count = count;
        this.profit = profit;

        this.goods.names.addAll(Arrays.asList(goodsNames));
    }

    public Shop() {
    }

    public static class Goods {
        public List<String> names = new ArrayList<>();

        @Override
        public String toString() {
            return "Goods{" +
                    "names=" + names +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Shop{" +
                "goods=" + goods +
                ", count=" + count +
                ", profit=" + profit +
                ", secretData=" + Arrays.toString(secretData) +
                '}';
    }
}