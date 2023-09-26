package co.simplon.alt6.Class;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

            // Vérifier si "touch" est le premier mot
            if (fileAction.length > 0 && fileAction[0].equals("touch")) {
                try {
                    this.path = oldPath;
                    String name = this.path + fileAction[1];
                    // Créez un objet File pour représenter le fichier
                    File file = new File(name);
                    if (!file.exists()) {
                        // Créez le fichier
                        if (file.createNewFile()) {
                            System.out.println("Le fichier a été créé avec succès.");
                        } else {
                            System.out.println("Impossible de créer le fichier.");
                        }
                    } else {
                        System.out.println("Le fichier existe déjà.");
                    }
                } catch (Exception e) {
                    System.err.println("Une erreur s'est produite lors de la création du fichier : " + e.getMessage());
                }
            }
        }
    }
}
