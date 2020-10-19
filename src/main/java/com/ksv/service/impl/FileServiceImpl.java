package com.ksv.service.impl;

import com.ksv.service.FileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> readFile(String filePath) {
        var path = Paths.get(filePath);
        if (Files.notExists(path)) {
            throw new IllegalArgumentException("There is no such file!");
        }
        try (var reader = Files.newBufferedReader(path)) {
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
    }
}
