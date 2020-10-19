package com.ksv.service.impl;

import com.ksv.service.WallService;
import java.util.ArrayList;
import java.util.List;

public class WallServiceImpl implements WallService {
    public List<Integer> getListFromWallMatrix(int[][] matrix) {
        List<Integer> partsOfWall = new ArrayList<>();
        int solidPart = 0;
        for (int[] row : matrix) {
            for (int i : row) {
                if (i == 1) {
                    solidPart++;
                } else {
                    if (solidPart > 0) {
                        partsOfWall.add(solidPart);
                        solidPart = 0;
                    }
                }
            }
            if (solidPart > 0) {
                partsOfWall.add(solidPart);
                solidPart = 0;
            }
        }
        return partsOfWall;
    }

    public boolean isEnoughBricks(List<Integer> bricks, List<Integer> wallParts) {
        var wallSize = wallParts.stream().reduce(0, Integer::sum);
        for (int i = 0; i < bricks.size(); i++) {
            var currentBrick = bricks.get(i);
            if (currentBrick > 0) {
                for (int j = 0; j < wallParts.size(); j++) {
                    var currentWallPart = wallParts.get(j);
                    if (currentBrick <= currentWallPart) {
                        wallParts.set(j, currentWallPart - currentBrick);
                        bricks.set(i, 0);
                        wallSize -= currentBrick;
                        if (wallSize == 0) {
                            return true;
                        } else {
                            return isEnoughBricks(bricks, wallParts);
                        }
                    }
                }
            }
        }
        return false;
    }
}
