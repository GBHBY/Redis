package com.example.redis.bean;

import java.io.Serializable;

/**
 * @author gb
 * @version 1.0
 * description:
 * @date 2021/5/22 0:21
 */

public class RedisBean implements Serializable {
    private String pName;

    private String price;

    private String cName;

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "RedisBean{" +
                "pName='" + pName + '\'' +
                ", price='" + price + '\'' +
                ", cName='" + cName + '\'' +
                '}';
    }
}
