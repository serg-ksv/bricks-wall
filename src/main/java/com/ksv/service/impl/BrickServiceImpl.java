package com.ksv.service.impl;

import com.ksv.model.Brick;
import com.ksv.model.Wall;
import com.ksv.service.BrickService;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BrickServiceImpl implements BrickService {
    public List<Integer> getAllFilteredBricks(Map<Brick, Integer> bricks,
                                              Wall wall) {
        return getSortedBricks(bricks).entrySet().stream()
                .filter(e -> isFitBrick(e.getKey(), wall))
                .map(e -> createListOfBricks(e.getKey(), e.getValue()))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private Map<Brick, Integer> getSortedBricks(Map<Brick, Integer> bricks) {
        return bricks.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    private boolean isFitBrick(Brick brick, Wall wall) {
        return brick.getWidth() <= wall.getWidth()
                && brick.getHeight() == 1;
    }

    private List<Integer> createListOfBricks(Brick brick, int count) {
        return IntStream.range(0, count)
                .mapToObj(width -> brick.getWidth())
                .collect(Collectors.toList());
    }
}
