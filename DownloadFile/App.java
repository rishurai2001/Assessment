// Java Program to convert Byte Array to File

// Importing required classes
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

// Main class
public class App {


    static void downloadFile(){
        try (BufferedInputStream inputStream = new BufferedInputStream(new URL("https://algs4.cs.princeton.edu/14analysis/1Mints.txt").openStream());
             FileOutputStream fileOS = new FileOutputStream("textFile.txt")) {
            byte data[] = new byte[1024];
            int byteContent;
            while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
                fileOS.write(data, 0, byteContent);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String args[])
    {


        String string = "There had to be a better way. That's all Nancy could think as she sat at her desk staring at her computer screen. ";
        downloadFile();

    }
}
