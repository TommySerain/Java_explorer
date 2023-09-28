package co.simplon.alt6.Class;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NavigateTest {
    Navigate navigation;

    @BeforeEach
    void setUp() {
        navigation = new Navigate(
                "C:/Users/Utilisateur/Desktop/CDA/Simplon/Java/dev/projet_explorateur/projet_explorer/src/test/java/co/simplon/alt6/Class/navigateTest");
    }

    @Test
    public void testShowFoldersList() {

        String[] folderList = navigation.ShowFilesList();
        String[] expected = { "test.txt", "testNavigate" };
        assertArrayEquals(expected, folderList);
    }
}
