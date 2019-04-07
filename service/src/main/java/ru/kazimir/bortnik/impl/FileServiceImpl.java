package ru.kazimir.bortnik.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.kazimir.bortnik.FileRepository;
import ru.kazimir.bortnik.FileService;

import java.io.File;
import java.util.List;
import java.util.stream.Stream;

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
    private static final String PATTERN_LINE = "^(\\d+([:,\\n|])){0,2}$";

    @Override
    public String getDataFromFile(File fileRead) {
        validate(fileRead);
        List<String> stringList = fileRepository.readFile(fileRead);
        String line = stringList.stream().reduce("", (element1, element2) -> element1 + element2);
        return Stream.of(line)
                .filter(x -> x.matches(PATTERN_LINE))
                .findAny()
                .orElse("");

    }

    private void validate(File fileRead) {
        if (!fileRead.exists()) {
            logger.error("File doesn't exist" );
            throw new RuntimeException("File doesn't exist");
        }
    }
}
