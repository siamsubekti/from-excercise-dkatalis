import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public class Park {
    public static void main(String[] args) {

        try {
            String file = new String("E:\\Java\\Park\\parking_lot file_inputs.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
//            List<String> slotNumber = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
//            for (String files : file) {
//            }


            while (true) {
                String text = br.readLine();
                if (text == null) {
                    break;
                }


//                System.out.println("Creating parking lot with 6 slots");
//                createParkingLot();
                System.out.println(text.trim().split("\\s+").toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createParkingLot(){
        for (int i=1; i < 7; i++) {
            System.out.println("Allocated slot number : " + i);
        }
    }
}
