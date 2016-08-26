package com.mycompany.thread2test1;

import java.io.IOException;

/**
 *
 * @author Henrik
 */
public class ThreadTester
{

    public static void main(String[] args) throws IOException, InterruptedException
    {

        System.out.println("Avilable Processors: " + Runtime.getRuntime().availableProcessors());

        int newestSum = 0;
        long start = 0;
        long end = 0;

        Thread1 t1 = new Thread1("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png");
        Thread1 t2 = new Thread1("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/folder-image-transp.png");
        Thread1 t3 = new Thread1("https://fronter.com/volY12-cache/cache/img/design_images/Classic/other_images/button_bg.png");
        start = System.nanoTime();
        t1.start();
        t1.join(); // Vi joiner, da ellers ville main thread printe 0 da tråden "Thread1" ikke er færdig med det samme.
        newestSum += t1.getSum();

        t2.start();
        t2.join(); // Vi joiner, da ellers ville main thread printe 0 da tråden "Thread1" ikke er færdig med det samme.
        newestSum += t2.getSum();

        t3.start();
        t3.join(); // Vi joiner, da ellers ville main thread printe 0 da tråden "Thread1" ikke er færdig med det samme.
        newestSum += t3.getSum();
        end = System.nanoTime();
        System.out.println("finished " + newestSum);
        System.out.println("Time Parallel : " + (end - start));

        start = System.nanoTime();
        t1.run();
        t2.run();
        t3.run();

        end = System.nanoTime();
        System.out.println("Time Sequental : " + (end - start));
    }

}
