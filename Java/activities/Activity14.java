package src.activities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import  org.apache.commons.io.FileUtils;

public class Activity14 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\saswa\\Downloads\\Java\\Result\\filename.txt");
        if (file.createNewFile())
            System.out.println("File created");
        else
            System.out.println("File not created");

        FileWriter writer = new FileWriter("C:\\Users\\saswa\\Downloads\\Java\\Result\\filename.txt");
        writer.write("My name is Saswati");
        writer.close();

        File fileUtil = FileUtils.getFile("C:\\Users\\saswa\\Downloads\\Java\\Result\\filename.txt");
        System.out.println("Data in file: " + FileUtils.readFileToString(fileUtil, "UTF8"));

        File destDir = new File("resources");
        FileUtils.copyFileToDirectory(file, destDir);

        File newFile = FileUtils.getFile("C:\\Users\\saswa\\Downloads\\Java\\resources\\", "filename.txt");
        String newFileData = FileUtils.readFileToString(newFile, "UTF8");
        System.out.println("Data in new file: " + newFileData);

    }
}
