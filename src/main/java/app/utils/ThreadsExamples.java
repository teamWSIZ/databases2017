package app.utils;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadsExamples {

    private static void jobToDo(int id, int duration) {
        System.out.println("Rozpoczynamy egzekucje " + id + " na wątku:" +
                Thread.currentThread().getName());
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Koniec egzekucji #" + id);
    }


    public static void main(String[] args) throws Exception {
        Random r = new Random(111);

        //serwis z przygotowanymi 10cioma wątkami
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            Integer ii = i;
            System.out.println("Wrzucamy zadanie nr " + ii + " z wątku " +
                    Thread.currentThread().getName());
            executor.submit(() -> {
                int duration = r.nextInt(1000);
                jobToDo(ii, duration);
            });

        }
        System.out.println("koniec wrzucania zadań");

        executor.awaitTermination(20, TimeUnit.SECONDS);



    }
}
