package javaCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReadDataToObject {

    private int listSize;

    public int getListSize() {
        return listSize;
    }

    public ArrayList<Tasks> readFile(String path) {
        Path filePath = Paths.get(path);

        ArrayList<String> read = new ArrayList<>();
        try {
            read = (ArrayList) Files.readAllLines(filePath);
        } catch (IOException ex) {
            System.out.println("Brak pliku!");
        }

        ArrayList<Tasks> allTasks = listToObject(read);
        listSize = allTasks.size();
        return allTasks;
    }


    private ArrayList<Tasks> listToObject(ArrayList<String> read) {
        ArrayList<Tasks> tasksObj = new ArrayList<>();
        for (String line : read) {
            String[] l = line.split(",");

            Tasks tasks = new Tasks(
                    l[0], // pl
                    l[1] // ge
            );
            tasksObj.add(tasks);
        }
        return tasksObj;
    }
}

