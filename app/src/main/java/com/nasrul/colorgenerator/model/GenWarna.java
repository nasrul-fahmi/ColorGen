package com.nasrul.colorgenerator.model;

import android.graphics.Color;

import java.util.Random;

public class GenWarna {
    private String textwarna;
    private Random rnd = new Random();

    public int getWarna() {
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    public String getTextwarna() {
        textwarna = Integer.toHexString(getWarna());
        return textwarna;
    }
}
