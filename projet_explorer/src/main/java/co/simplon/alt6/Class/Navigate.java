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

            if (userInput.equals("touch")) {
                try {
                    this.path = oldPath;
                    String name = this.path + userInput + ".txt";
                    // Créez un objet File pour représenter le fichier
                    File file = new File(name);

                    // Créez un objet FileWriter pour écrire dans le fichier
                    FileWriter writer = new FileWriter(file);

                    // Écrivez le contenu dans le fichier
                    writer.write("Ceci est le contenu de mon fichier texte.");
                    writer.write("\nVous pouvez ajouter plus de lignes si nécessaire.");

                    // Fermez le FileWriter pour libérer les ressources
                    writer.close();

                    System.out.println("Fichier créé avec succès : " + userInput);
                } catch (IOException e) {
                    System.err.println("Une erreur s'est produite lors de la création du fichier : " + e.getMessage());
                }

            }
        }
    }
}
