package com.company;

/**
 * Created by petermartinez on 10/12/16.
 */



/*
ID: peterjo1
LANG: JAVA
TASK: gift1
*/
import java.io.*;
        import java.util.*;

class gift1 {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        int np = Integer.parseInt(f.readLine());
        int[] dollars = new int[np];
        String[] names = new String[np];

        for (int i = 0; i < np; i++) {
            names[0] = f.readLine();
        }

        for (int i = 0; i < np; i++) {
            String giver = f.readLine();
            StringTokenizer st = new StringTokenizer(f.readLine());
            int totalGift = Integer.parseInt(st.nextToken());
            int numRecipients = Integer.parseInt(st.nextToken());
            int eachGift = totalGift / numRecipients;


            int giverIndex = i;
            for (int j = 0; j < names.length; j++) {
                if (names[j].equals(giver)) {
                    giverIndex = j;
                    break;
                }
            }
            dollars[giverIndex] = dollars[giverIndex] + totalGift;
            for (int j = 0; j < numRecipients; j++) {
                String recipient = f.readLine();
                int recipientIndex = 0;
                for (int k = 0; k < names.length; k++) {
                    if (names[k].equals(recipient)) {
                        recipientIndex = k;
                        break;
                    }
                }
                dollars[giverIndex] = dollars[giverIndex] - eachGift;
                dollars[recipientIndex] = dollars[recipientIndex] + eachGift;
            }
        }

        for (int i = 0; i < np; i++) {
            out.println(names[i] + " " + dollars[i]);
        }

        out.close();                                  // close the output file

    }
}