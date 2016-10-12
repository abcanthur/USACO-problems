package com.company;



/*
ID: peterjo1
LANG: JAVA
TASK: ride
*/
import java.io.*;
        import java.util.*;

class test {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st1 = new StringTokenizer(f.readLine());
        StringTokenizer st2 = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int comet = 1;
        int group = 1;
        for(int i = 0; i < 6; i++){
            comet = comet * Integer.parseInt(st1.nextToken());
            group = group * Integer.parseInt(st2.nextToken());
        }
        if( (comet % 47) == (group % 47)) {
            out.println("GO");
        } else {
            out.println("STAY");// output result
        }
        out.close();                                  // close the output file
    }
}