//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.itheima.domain;

import java.io.Serializable;

public class GameInfo implements Serializable {
    private static final long serialVersionUID = 5544981119935263973L;
    private int[][] data;
    private int x;
    private int y;
    private String path;
    private int step;

    public GameInfo() {
    }

    public GameInfo(int[][] data, int x, int y, String path, int step) {
        this.data = data;
        this.x = x;
        this.y = y;
        this.path = path;
        this.step = step;
    }

    public int[][] getData() {
        return this.data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getStep() {
        return this.step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String toString() {
        return "GameInfo{data = " + this.data + ", x = " + this.x + ", y = " + this.y + ", path = " + this.path + ", step = " + this.step + "}";
    }
}
