package co.simplon.alt6.Class;

import java.io.File;
import java.util.Scanner;

public class Navigate {

    String path;

    public Navigate(String path) {
        this.path = path;
    }

    public void ShowFilesList() {
        String[] pathnames;
        File f = new File(this.path);
        pathnames = f.list();

        for (String pathname : pathnames) {
            System.out.println(pathname);
        }
    }

    public void Browse() {
        String userInput = "/";

        while (!userInput.equals("exit")) {
            String oldPath = this.path;
            this.ShowFilesList();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Entrez le nom d'un dossier : ");
            // Lisez l'entrée de l'utilisateur
            userInput = scanner.nextLine();

            // Affichez ce que l'utilisateur a saisi
            System.out.println("Vous avez saisi : " + userInput);
            this.path += userInput + "/";

            if (userInput.equals("exit")) {
                scanner.close();
            }

            String[] fileAction = userInput.split("\\s+"); // Diviser sur les espaces

            System.out.println(fileAction.length);
            if (fileAction.length > 1) {
                this.path = oldPath;
                FileHandler fileHandler = new FileHandler(this.path, fileAction[1]);
                if (fileAction[0].equals("touch")) {
                    fileHandler.create();
                }
                if (fileAction[0].equals("del")) {
                    fileHandler.delete();
                }
                if (fileAction[0].equals("change")) {
                    // FileHandler.updateFileName();
                }
            }

        }
    }
}
