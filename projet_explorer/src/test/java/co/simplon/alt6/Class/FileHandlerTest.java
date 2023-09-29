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
        fileHandler = new FileHandler(path);
        fileSize = 0;
        lastModif = "2023-09-29";
    }

    @Test
    void testProperties() {
        String properties = fileHandler.properties("test.txt");
        assertEquals("Nom du fichier : " + fileName + "\n" + "Taille du fichier : " + fileSize + " octets\n"
                + "Chemin absolu du fichier : " + path + fileName + "\n" + "Derniere modification du fichier : "
                + lastModif, properties);
    }
}
