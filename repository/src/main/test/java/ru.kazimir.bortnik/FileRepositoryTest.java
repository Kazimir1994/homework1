package ru.kazimir.bortnik;

import org.junit.Assert;
import org.junit.Test;
import ru.kazimir.bortnik.impl.FileRepositoryImpl;

import java.io.File;
import java.util.List;

public class FileRepositoryTest {

    @Test(expected = RuntimeException.class)
    public void checkForNonExistentFile() {
        FileRepository fileRepository = FileRepositoryImpl.getInstance();
        fileRepository.readFile(null);
    }

    @Test(expected = RuntimeException.class)
    public void checkForNullExistentFile() {
        FileRepository fileRepository = FileRepositoryImpl.getInstance();
        File file = new File("dfeata.txt");
        fileRepository.readFile(file);
    }

    @Test
    public void returnTest() {
        FileRepository fileRepository = FileRepositoryImpl.getInstance();
        File file = new File("DataTest.txt");
        List<String> stringList = fileRepository.readFile(file);
        Assert.assertEquals(1, stringList.size());
    }
}
