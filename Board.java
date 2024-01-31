package core_ls_5;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Board {

    public void writeBoard(int[] array) {

        byte[] arr = new byte[3];

        for (int i = 0; i < array.length; i++) {
            arr[i / 4] |= array[i] << ((i % 4) * 2);
        }

        try (FileOutputStream file = new FileOutputStream("file.bin")) {
            file.write(arr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Записано " + Arrays.toString(array));
    }

    public void readBoard() {

        byte[] bytes = new byte[3];

        try (FileInputStream file = new FileInputStream("file.bin")) {
            file.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] arr = new int[9];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (bytes[i / 4] >> ((i % 4) * 2)) & 3;
        }

        System.out.println("Прочитанно " + Arrays.toString(arr));
    }
}
