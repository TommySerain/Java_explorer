package co.simplon.alt6.Class;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Navigate {

    String path;

    public Navigate(String path) {
        this.path = path;
    }

    public String[] ShowFilesList() {
        String[] pathnames;
        File file = new File(this.path);
        pathnames = file.list();

        for (String pathname : pathnames) {
            System.out.println(pathname);
        }
        return pathnames;
    }

    public void Browse() {
        String userInput = "/";

        while (!userInput.equals("exit")) {
            String oldPath = this.path;
            this.ShowFilesList();
            Scanner scanner = new Scanner(System.in);

            System.out.print("(" + this.path + ")" + " => ");

            userInput = scanner.nextLine();

            System.out.println("Vous avez saisi : " + userInput);
            this.path += userInput + "/";

            if (userInput.equals("exit")) {
                scanner.close();
            }
            if (userInput.equals("..")) {
                String newPath = "/";
                String[] pathSplit = this.path.split("/");
                for (int i = 0; i < pathSplit.length - 2; i++) {
                    newPath += pathSplit[i];
                }
                System.out.println(newPath);
                if (!newPath.equals("/")) {
                    this.path = newPath + "/";
                } else {
                    this.path = newPath;
                }
            }

            String[] fileAction = userInput.split("\\s+"); // Diviser sur les espaces

            System.out.println(fileAction.length);
            if (fileAction.length > 1) {
                this.path = oldPath;
                FileHandler fileHandler = new FileHandler(this.path, fileAction[1]);
                if (fileAction[0].equals("touch")) {
                    fileHandler.createFile();
                }
                if (fileAction[0].equals("mkdir")) {
                    fileHandler.createFolder();
                }
                if (fileAction[0].equals("prop")) {
                    fileHandler.properties();
                }
                if (fileAction[0].equals("del")) {
                    fileHandler.deleteFile();
                }
                if (fileAction[0].equals("rmdir")) {
                    fileHandler.deleteFolderAndContents();
                }
                if (fileAction[0].equals("change")) {
                    if (fileAction.length > 2) {
                        fileHandler.updateFileName(fileAction[2]);
                    } else {
                        System.out.println("Veuillez saisir change fichierChoisi fichierDestination");
                    }

                }
            }

        }
    }
}
