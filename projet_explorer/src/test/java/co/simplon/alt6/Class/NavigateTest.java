package co.simplon.alt6.Class;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

// Pour effectuer les tests, mdifier le path pour un dossier dans lequel il doit y avoir un fichier test.txt et test2.txt
public class NavigateTest {
    Navigate navigation;

    @Test
    public void testShowFoldersList() {
        navigation = new Navigate(
                "C:/Users/Utilisateur/Desktop/CDA/Simplon/Java/dev/projet_explorateur/projet_explorer/src/test/java/co/simplon/alt6/Class/navigateTest");
        String[] folderList = navigation.ShowFilesList();
        String[] expected = { "test.txt", "test2.txt" };
        assertArrayEquals(expected, folderList);
    }

    @Test
    public void testShowFoldersListIfFolderNotExist() {
        navigation = new Navigate(
                "C:/blob");
        String[] folderList = navigation.ShowFilesList();
        assertArrayEquals(null, folderList);
    }

}
