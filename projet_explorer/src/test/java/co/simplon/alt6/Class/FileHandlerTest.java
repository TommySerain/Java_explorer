package co.simplon.alt6.Class;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileHandlerTest {
    String path;
    String fileName;
    String name;
    long fileSize;
    FileHandler fileHandler;
    String lastModif;

    @BeforeEach
    void setUp() {
        path = "C:\\Users\\Utilisateur\\Desktop\\CDA\\Simplon\\Java\\dev\\projet_explorateur\\projet_explorer\\src\\test\\java\\co\\simplon\\alt6\\Class\\navigateTest\\";
        fileName = "test.txt";
        fileHandler = new FileHandler(path, fileName);
        fileSize = 0;
        lastModif = "2023-09-28";
    }

    @Test
    void testProperties() {
        FileProperties properties = fileHandler.properties();
        String tms = properties.getLastModified().toString();
        assertEquals(fileName, properties.getFileName());
        assertEquals(fileSize, properties.getFileSize());
        assertEquals(path + fileName, properties.getAbsolutePath());
        assertEquals(lastModif, tms);
        // assertTrue(lastModif.compareTo(tms) == 0);
    }
}
