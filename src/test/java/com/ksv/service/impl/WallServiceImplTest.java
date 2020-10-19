package com.ksv.service.impl;

import com.ksv.service.WallService;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WallServiceImplTest {
    private WallService wallService;

    @Before
    public void setUp() {
        wallService = new WallServiceImpl();
    }

    @Test
    public void getListFromWallMatrixOk() {
        int[][] wallMatrix = {
                {1, 0, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}
        };
        List<Integer> expected = List.of(1, 2, 1, 6, 6);
        List<Integer> actual = wallService.getListFromWallMatrix(wallMatrix);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isEnoughBricksOk() {
        List<Integer> filteredBricks = List.of(2, 2, 2, 2, 2, 2, 1, 1, 1, 1);
        List<Integer> wallParts = List.of(1, 2, 1, 6, 6);
        boolean enoughBricks = wallService.isEnoughBricks(filteredBricks, wallParts);
        Assert.assertTrue(enoughBricks);
    }

    @Test
    public void isNotEnoughBricksOk() {
        List<Integer> filteredBricks = List.of(2, 2, 2, 2, 2, 1, 1, 1, 1);
        List<Integer> wallParts = List.of(1, 2, 1, 6, 6);
        boolean enoughBricks = wallService.isEnoughBricks(filteredBricks, wallParts);
        Assert.assertFalse(enoughBricks);
    }
}
