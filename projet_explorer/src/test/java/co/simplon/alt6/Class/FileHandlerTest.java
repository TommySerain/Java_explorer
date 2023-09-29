package co.simplon.alt6.Class;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
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
        fileHandler.updateFileName("testUpdate.txt", "test2.txt");
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
        boolean folderIsDelete = fileHandler.deleteFolderAndContents("testCreateFile.txt");
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
        String properties = fileHandler.properties("test.txt");
        assertEquals("Nom du fichier : " + fileName + "\n" + "Taille du fichier : " + fileSize + " octets\n"
                + "Chemin absolu du fichier : " + path + fileName + "\n" + "Derniere modification du fichier : "
                + lastModif, properties);
    }
}
