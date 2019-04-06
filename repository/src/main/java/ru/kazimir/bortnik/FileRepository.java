package ru.kazimir.bortnik;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileRepository {
    List<String> readFile(File fileRead) throws IOException;
}
