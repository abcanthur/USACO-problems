package com.company;



/*
ID: peterjo1
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st1 = new StringTokenizer(f.readLine()); //Let's fix these StringTokenizers
        StringTokenizer st2 = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int comet = 1;
        int group = 1;
        String cString = st1.nextToken();
        String gString = st2.nextToken();
        //out.println(cString + " " + gString);

        for(int x = 0; x < cString.length(); x++){
            int c = (int) (cString.charAt(x));
            c = c - 64;
            //out.println(c);
            comet = comet * c;
        }
        for(int y = 0; y < gString.length(); y++){
            int g = (int) (gString.charAt(y));
            g = g - 64;
            //out.println(g);
            group = group * g;
        }
        //out.println(comet + " " + group);
        if( (comet % 47) == (group % 47)) {
            out.println("GO");
        } else {
            out.println("STAY");// output result
        }
        out.close();                                  // close the output file
    }
}