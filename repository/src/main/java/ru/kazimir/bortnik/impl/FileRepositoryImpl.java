package ru.kazimir.bortnik.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.kazimir.bortnik.FileRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileRepositoryImpl implements FileRepository {
    private static FileRepositoryImpl instance;

    private FileRepositoryImpl() {
    }

    public static FileRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new FileRepositoryImpl();
        }
        return instance;
    }

    private Logger logger = LogManager.getLogger(FileRepositoryImpl.class);
    private final static String FORMAT_INFO_FILE = "[File Name= %s, File Path to the file= %s, File size= %s byte]";

    @Override
    public List<String> readFile(File fileRead) {
        validate(fileRead);
        List<String> dataFile = new ArrayList<>();
        logger.info("Attempt to read file " + String.format(FORMAT_INFO_FILE, fileRead.getName(), fileRead.getAbsolutePath(), fileRead.length()));

        try (Stream<String> lines = Files.lines(Paths.get(fileRead.getAbsolutePath()))) {
            dataFile = lines.map(x -> x + "\n").collect(Collectors.toList());

            logger.info("File[" + fileRead.getName() + "] successfully read ");
        } catch (IOException error) {
            logger.error(error.getMessage(), error);
        }
        return dataFile;
    }

    private void validate(File fileRead) {
        if (fileRead == null || !fileRead.exists()) {
            logger.error("File doesn't exist" );
            throw new RuntimeException("File doesn't exist");
        }
    }
}
