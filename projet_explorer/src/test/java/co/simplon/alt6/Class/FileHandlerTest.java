package co.simplon.alt6.Class;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

// Pour effectuer les tests, mdifier le path pour un dossier dans lequel il doit y avoir un fichier test.txt et test2.txt
// Dans le test 10 "testProperties", modifier la variable lastModif par la date de dernière modification du fichier test.txt
// Attention les tests dépendent les uns des autres, il faut donc les executer dans l'ordre.
public class FileHandlerTest {
    static String path;
    String fileName;
    String name;
    long fileSize;
    static FileHandler fileHandler;
    String lastModif;

    @BeforeEach
    void setUp() {
        path = "C:\\Users\\Utilisateur\\Desktop\\CDA\\Simplon\\Java\\dev\\projet_explorateur\\projet_explorer\\src\\test\\java\\co\\simplon\\alt6\\Class\\navigateTest\\";
        fileHandler = new FileHandler(path);
    }

    @AfterAll
    static void tearDown() {
        fileHandler.updateFileName("testCreateFile.txt", "test2.txt");
    }

    @Test
    @Order(0)
    void testCreateFolder() {
        boolean folderIsCreated = fileHandler.createFolder("testCreate");
        assertEquals(folderIsCreated, true);
    }

    @Test
    @Order(1)
    void testCreateFolderFalse() {
        boolean folderIsCreated = fileHandler.createFolder("testCreate*");
        assertEquals(folderIsCreated, false);
    }

    @Test
    @Order(2)
    void createFile() {
        boolean fileIsCreated = fileHandler.createFile("testCreateFile.txt");
        assertEquals(fileIsCreated, true);
    }

    @Test
    @Order(3)
    void createFileFalse() {
        boolean fileIsCreated = fileHandler.createFile("testCreateFile*.txt");
        assertEquals(fileIsCreated, false);
    }

    @Test
    @Order(4)
    void testUpdateFileName() {
        boolean folderIsModified = fileHandler.updateFileName("test2.txt", "testupdate.txt");
        assertEquals(folderIsModified, true);
    }

    @Test
    @Order(5)
    void testUpdateFileNameFalse() {
        boolean folderIsModified = fileHandler.updateFileName("testupdate.txt", "testCreateFile*.txt");
        assertEquals(folderIsModified, false);
    }

    @Test
    @Order(6)
    void testDeleteFolder() {
        boolean folderIsDelete = fileHandler.deleteFolderAndContents("testCreate");
        assertEquals(folderIsDelete, true);
    }

    @Test
    @Order(7)
    void testDeleteFolderFalse() {
        boolean folderIsDelete = fileHandler.deleteFolderAndContents("testUnknownFolder");
        assertEquals(folderIsDelete, false);
    }

    @Test
    @Order(8)
    void testDeleteFile() {
        boolean folderIsDelete = fileHandler.deleteFolderAndContents("testupdate.txt");
        assertEquals(folderIsDelete, true);
    }

    @Test
    @Order(9)
    void testDeleteFileFalse() {
        boolean folderIsDelete = fileHandler.deleteFolderAndContents("testUnknownFile.txt");
        assertEquals(folderIsDelete, false);
    }

    @Test
    @Order(10)
    void testProperties() {
        fileName = "test.txt";
        fileSize = 0;
        lastModif = "2023-09-29";
        String properties = fileHandler.properties("test.txt");
        assertEquals("Nom du fichier : " + fileName + "\n" + "Taille du fichier : " + fileSize + " octets\n"
                + "Chemin absolu du fichier : " + path + fileName + "\n" + "Derniere modification du fichier : "
                + lastModif, properties);
    }

    @Test
    @Order(11)
    void testPropertiesFalse() {
        fileName = "mauvaisNom.txt";
        fileSize = 0;
        lastModif = "2023-09-29";
        String mauvaisFichier = "Nom du fichier : " + fileName + "\n" + "Taille du fichier : " + fileSize + " octets\n"
                + "Chemin absolu du fichier : " + path + fileName + "\n" + "Derniere modification du fichier : "
                + lastModif;
        String properties = fileHandler.properties("test.txt");
        boolean isEqual;
        if (mauvaisFichier == properties) {
            isEqual = true;
        } else {
            isEqual = false;
        }
        assertEquals(isEqual, false);
    }
}
