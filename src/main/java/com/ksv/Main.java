package com.ksv;

import com.ksv.service.BrickService;
import com.ksv.service.DataParserService;
import com.ksv.service.WallService;
import com.ksv.service.impl.BrickServiceImpl;
import com.ksv.service.impl.DataParserServiceImpl;
import com.ksv.service.impl.WallServiceImpl;
import com.ksv.util.ConsoleHandler;

public class Main {
    public static final ConsoleHandler CONSOLE_HANDLER = new ConsoleHandler();
    public static final DataParserService DATA_PARSER_SERVICE = new DataParserServiceImpl();
    public static final WallService WALL_SERVICE = new WallServiceImpl();
    public static final BrickService BRICK_SERVICE = new BrickServiceImpl();

    public static void main(String[] args) {
        CONSOLE_HANDLER.showMenu();
        var choice = CONSOLE_HANDLER.getUsersChoice();
        var inputData = CONSOLE_HANDLER.getData(choice);
        var wall = DATA_PARSER_SERVICE.parseWall(inputData);
        var bricks = DATA_PARSER_SERVICE
                .parseBricks(inputData.subList(wall.getHeight() + 1, inputData.size()));
        var wallParts = WALL_SERVICE.getListFromWallMatrix(wall.getMatrix());
        var allFilteredBricks = BRICK_SERVICE.getAllFilteredBricks(bricks, wall);
        CONSOLE_HANDLER.printAnswer(WALL_SERVICE.isEnoughBricks(allFilteredBricks, wallParts));
    }
}
