package com.ksv.service;

import com.ksv.model.Brick;
import com.ksv.model.Wall;
import java.util.List;
import java.util.Map;

public interface BrickService {
    List<Integer> getAllFilteredBricks(Map<Brick, Integer> bricks, Wall wall);
}
