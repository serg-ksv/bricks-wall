package com.ksv.service.impl;

import com.ksv.service.FileService;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FileServiceImplTest {
    private static final String FILE_PATH = "src/test/resources/input.txt";
    private FileService fileService;

    @Before
    public void setUp() {
        fileService = new FileServiceImpl();
    }

    @Test
    public void readFileRelativePath() {
        Path path = Paths.get(FILE_PATH);
        Assert.assertTrue(Files.exists(path));
    }

    @Test
    public void readFileOk() {
        List<String> expected = List.of("6 3", "101101", "111111", "111111",
                 "4", "1 1 4", "2 1 6", "1 3 1", "3 4 5");
        List<String> actual = fileService.readFile(FILE_PATH);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void readFileWrongPath() {
        String pathFile = "src/test/wrong-path/test.txt";
        fileService.readFile(pathFile);
    }

    @Test(expected = NullPointerException.class)
    public void readFileNullValue() {
        fileService.readFile(null);
    }
}
