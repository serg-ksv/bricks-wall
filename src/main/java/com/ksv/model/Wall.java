package com.ksv.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wall {
    private int width;
    private int height;
    private int[][] matrix;
}
