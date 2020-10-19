package com.ksv.service.impl;

import com.ksv.model.Brick;
import com.ksv.model.Wall;
import com.ksv.service.DataParserService;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DataParserServiceImplTest {
    private DataParserService dataParserService;

    @Before
    public void setUp() {
        dataParserService = new DataParserServiceImpl();
    }

    @Test
    public void parseWallOk() {
        var expected = new Wall();
        expected.setWidth(6);
        expected.setHeight(3);
        expected.setMatrix(new int[][]{
                {1, 0, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}
        });
        var actual = dataParserService
                .parseWall(List.of("6 3", "101101", "111111", "111111"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void parseBricksOk() {
        var brick1 = new Brick(1, 1);
        var brick2 = new Brick(2, 1);
        Map<Brick, Integer> expected = Map.of(brick1, 4, brick2, 6);
        Map<Brick, Integer> actual = dataParserService
                .parseBricks(List.of("2", "1 1 4", "2 1 6"));
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseBricksWithWrongNumberOfBricks() {
        dataParserService.parseBricks(List.of("4", "1 1 4", "2 1 6"));
    }

    @Test(expected = NullPointerException.class)
    public void parseWallDataNullValue() {
        dataParserService.parseWall(null);
    }

    @Test(expected = NullPointerException.class)
    public void parseBricksDataNullValue() {
        dataParserService.parseBricks(null);
    }
}
