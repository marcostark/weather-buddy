package com.example.sarai.wheaterhelp;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by sarai on 01/09/16.
 */
public class Colors {
    private String [] cores = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#00E676",  //green
            "#827717",  //brown
            "#B9F6CA", //azul claro
            "#000000", //black
            "#90A4AE", //gray
            "#4FC3F7", // blue light
            "#B388FF" //lilas
    };

    public int getColor(){
        Random r = new Random();
        String  color = cores[r.nextInt(cores.length)];
        int colorAsInt = Color.parseColor(color);

        return colorAsInt;
    }
}
