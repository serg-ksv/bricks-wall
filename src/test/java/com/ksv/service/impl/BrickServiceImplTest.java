package com.ksv.service.impl;

import com.ksv.model.Brick;
import com.ksv.model.Wall;
import com.ksv.service.BrickService;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BrickServiceImplTest {
    private BrickService brickService;

    @Before
    public void setUp() {
        brickService = new BrickServiceImpl();
    }

    @Test
    public void getAllFilteredBricksOk() {
        var brick1 = new Brick(1, 1);
        var brick2 = new Brick(6, 1);
        var brick3 = new Brick(2, 1);
        Map<Brick, Integer> bricks = Map.of(brick1, 4, brick2, 6, brick3, 2);
        var wall = new Wall();
        wall.setWidth(6);
        wall.setHeight(3);
        List<Integer> expected = List.of(6, 6, 6, 6, 6, 6, 2, 2, 1, 1, 1, 1);
        List<Integer> actual = brickService.getAllFilteredBricks(bricks, wall);
        Assert.assertEquals(expected, actual);
    }
}
