package com.ksv.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Brick implements Comparable<Brick> {
    private int width;
    private int height;

    @Override
    public int compareTo(Brick otherBrick) {
        return Integer.compare(width, otherBrick.getWidth());
    }
}
