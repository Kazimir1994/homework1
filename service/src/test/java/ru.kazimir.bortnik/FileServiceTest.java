package ru.kazimir.bortnik;

import org.junit.Test;
import ru.kazimir.bortnik.impl.FileServiceImpl;

import java.io.File;

public class FileServiceTest {
    @Test(expected = RuntimeException.class)
    public void checkForNonExistentFile() {
        FileService fileService = FileServiceImpl.getInstance();
        fileService.getDataFromFile(null);
    }

    @Test(expected = RuntimeException.class)
    public void checkForNullExistentFile() {
        FileService fileService = FileServiceImpl.getInstance();
        File file = new File("data.txt");
        fileService.getDataFromFile(file);
    }

    @Test
    public void returnTest() {
        FileService fileService = FileServiceImpl.getInstance();
        File file = new File("DataTest.txt");
        String data = fileService.getDataFromFile(file);
        assert data.matches("^(\\d+([:,\\n|])){0,2}$");
    }
}
