package com.mycompany.thread2test1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;

/**
 *
 * @author Henrik
 */
public class Thread1 extends Thread
{
        byteGetter bG = new byteGetter();
        byte[] bis = new byte[4096];
        int sum = 0;
        int finalSum = 0;

        public Thread1(String url) throws IOException
        {

            this.bis = bG.getBytesFromUrl(url);

        }

        public void run()
        {

            for (int i = 0; i < bis.length; i++)
            {

                sum += bis[i];

            }
        
            setSum(sum);

        }

        public void setSum(int newSum)
        {
            finalSum = newSum;
        }

        public int getSum()
        {
            return finalSum;
        }
        

}
