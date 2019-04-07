package ru.kazimir.bortnik.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.kazimir.bortnik.FileService;
import ru.kazimir.bortnik.MathematicalService;
import ru.kazimir.bortnik.impl.FileServiceImpl;
import ru.kazimir.bortnik.impl.MathematicalServiceImpl;

import java.io.File;

public class Main {

    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        File file = new File("Data.txt");
        FileService fileService = FileServiceImpl.getInstance();
        String data = fileService.getDataFromFile(file);
        logger.info("Received data " + data);
        MathematicalService mathematicalService = MathematicalServiceImpl.getInstance();
        int sum = mathematicalService.add(data);
        logger.info("Work result {SUM = " + sum + "}");

    }
}
