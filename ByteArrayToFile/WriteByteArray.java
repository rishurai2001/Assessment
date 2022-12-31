// Java Program to convert Byte Array to File

// Importing required classes
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

// Main class
public class WriteByteArray {

    // Path of a file
    static String FILEPATH = "byteToFile.txt";
    static File file = new File(FILEPATH);




    // Main driver method


        public static void main(String[] args) {

        String s = "The rain and wind abruptly stopped, but the sky still had the gray swirls of storms in the distance.";
        try {

            byte[] array = s.getBytes();
            ByteArrayInputStream input = new ByteArrayInputStream(array);
            OutputStream os = new FileOutputStream(FILEPATH);
            os.write(array);

            os.close();

        }
        catch(Exception e) {
            e.getStackTrace();
        }

    }


}
