//Реализуйте алгоритм сортировки пузырьком числового массива (введён вами), 
//результат после каждой итерации запишите в лог-файл.

package HW2;

import java.util.logging.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;

public class task1 {
    public static void main(String[] args) {
        int[] arr = new int[] {13, 0, -10, 8, 62, -2};
        // int[] arr = new int[] {3, 0, 1};

        logging("initial array: \n" + Arrays.toString(arr));
        loggingToFile("initial array: \n" + Arrays.toString(arr)+ "\n");
        System.out.println("result: \n" + Arrays.toString(sortArray(arr)));
        loggingToFile("result: \n" + Arrays.toString(sortArray(arr)));      
        
    }
    static int[] sortArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1])  {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    
                    logging(Arrays.toString(array));
                    loggingToFile(Arrays.toString(array));
                }
                
            }
        }
        return array;
    }
    static void logging(String message) {
        Logger logger = Logger.getLogger(task1.class.getName());
        logger.setLevel(Level.INFO);
        ConsoleHandler h = new ConsoleHandler();
        logger.addHandler(h);
        XMLFormatter xml = new XMLFormatter();
        h.setFormatter(xml);
        logger.log(Level.INFO, message); 
        System.out.println(
                "-----------------------------------------------");

           
    }  
    static void loggingToFile(String message) {
        String file_name = "logrecord.txt";
        File file = new File(file_name);

        try{
            FileWriter w = new FileWriter(file, true);
            w.write(message + "\n");
            w.close();
            System.out.println("OK");
        }
        catch (Exception e) {
            System.out.println("something is wrong");
        }
    } 
}

