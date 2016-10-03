package com.lap.MyLog;

import java.io.*;

/**
 * Created by lapte on 28.06.2016.
 */
//Образец логирования.


public class MyLog {

    public static void main(String[] args) throws Exception {
        //Создаём файл "log.txt", в который будем записывать log-и.
        System.setErr(new PrintStream(new File("log.txt")));

        for (int i = 0; i < 10; i++) {
            //вывод информации в консоль
            System.out.println("i = " + i);

            //вывод информации в файл "log.txt"
            System.err.println("i = " + i);
        }

        // Создадим ситуацию с исключением и запишем исключение в файл "log.txt".
        // В результате все ошибки (System.err.println()) и исключения будут печататься в
        // файл "log.txt". При каждом запуске программы файл обновляется.

        System.setErr(new PrintStream(new FileOutputStream(new File("log.txt"),true)));
        // Теперь при каждом запуске программы файл не обновляется, а дописывается.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your name");
        String str = br.readLine();
        if (str.length()<2){
            throw new Exception("Wrong name");
        }

    }
}
