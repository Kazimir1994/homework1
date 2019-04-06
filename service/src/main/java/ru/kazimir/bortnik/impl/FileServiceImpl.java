package ru.kazimir.bortnik.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.kazimir.bortnik.FileRepository;
import ru.kazimir.bortnik.FileService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileServiceImpl implements FileService {
    private static FileServiceImpl instance;

    private FileServiceImpl() {
    }

    public static FileServiceImpl getInstance() {
        if (instance == null) {
            instance = new FileServiceImpl();
        }
        return instance;
    }

    private FileRepository fileRepository = FileRepositoryImpl.getInstance();
    private Logger logger = LogManager.getLogger(FileServiceImpl.class);
    private static final String PATTERN_LINE = "^(\\d+([:,|\n]))*$";

    @Override
    public String getDataFromFile(File fileRead) {
        try {
            List<String> stringList = fileRepository.readFile(fileRead);
            return stringList.stream().filter(x -> x.matches(PATTERN_LINE)).collect(Collectors.joining());
        } catch (IOException error) {
            logger.error(error.getMessage(), error);
        }
        return null;
    }
}
