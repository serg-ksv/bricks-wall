package com.ksv.service;

import com.ksv.model.Brick;
import com.ksv.model.Wall;
import java.util.List;
import java.util.Map;

public interface DataParserService {
    Wall parseWall(List<String> inputLines);

    Map<Brick, Integer> parseBricks(List<String> inputLines);
}
