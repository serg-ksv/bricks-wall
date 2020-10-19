package com.ksv.service.impl;

import com.ksv.model.Brick;
import com.ksv.model.Wall;
import com.ksv.service.DataParserService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataParserServiceImpl implements DataParserService {
    public static final int WIDTH = 0;
    public static final int HEIGHT = 1;
    public static final int NUMBER_OF_BRICKS = 2;

    @Override
    public Wall parseWall(List<String> inputLines) {
        var splitedLine = splitLine(inputLines.get(0));
        var width = Integer.parseInt(splitedLine[WIDTH]);
        var height = Integer.parseInt(splitedLine[HEIGHT]);
        int[][] matrix = createMatrix(inputLines, width, height);
        return new Wall(width, height, matrix);
    }

    @Override
    public Map<Brick, Integer> parseBricks(List<String> inputLines) {
        if (Integer.parseInt(inputLines.get(0)) != inputLines.size() - 1) {
            throw new IllegalArgumentException("Incorrect number of bricks!");
        }
        return inputLines.stream()
                .skip(1)
                .map(this::splitLine)
                .collect(Collectors.toMap(this::parseBrick, this::parseNumberOfBricks));
    }

    private int[][] createMatrix(List<String> inputLines, int width, int height) {
        var matrix = new int[height][width];
        for (var i = 0; i < matrix.length; i++) {
            var parts = inputLines.get(i + 1).split("");
            for (var j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = Integer.parseInt(parts[j]);
            }
        }
        return matrix;
    }

    private String[] splitLine(String line) {
        return line.split(" ");
    }

    private Brick parseBrick(String[] parts) {
        var brickWidth = Integer.parseInt(parts[WIDTH]);
        var brickHeight = Integer.parseInt(parts[HEIGHT]);
        return new Brick(brickWidth, brickHeight);
    }

    private int parseNumberOfBricks(String[] parts) {
        return Integer.parseInt(parts[NUMBER_OF_BRICKS]);
    }
}
