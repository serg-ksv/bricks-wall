package com.ksv.service;

import java.util.List;

public interface WallService {
    List<Integer> getListFromWallMatrix(int[][] matrix);

    boolean isEnoughBricks(List<Integer> bricks, List<Integer> wallParts);
}
