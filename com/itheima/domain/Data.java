//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.itheima.domain;

public class Data {
    private String name;
    private String password;

    public Data() {
    }

    public Data(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "name=" + this.name + "&password=" + this.password;
    }
}
