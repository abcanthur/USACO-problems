
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
        int totalGift;
        int numRecipients;
        int eachGift;


        for (int i = 0; i < np; i++) {
            names[i] = f.readLine();
        }

        for (int i = 0; i < np; i++) {
            String giver = f.readLine();
            StringTokenizer st = new StringTokenizer(f.readLine());
            totalGift = Integer.parseInt(st.nextToken());
            numRecipients = Integer.parseInt(st.nextToken());
            if(numRecipients > 0) {
                eachGift = totalGift / numRecipients;
            } else {
                eachGift = 0;
            }



            int giverIndex = i;
            for (int j = 0; j < names.length; j++) {
                if (names[j].equals(giver)) {
                    giverIndex = j;
                    break;
                }
            }

//            out.println(giver + " had " + dollars[giverIndex]);
            dollars[giverIndex] = dollars[giverIndex] - totalGift + (totalGift - eachGift * numRecipients);
//            out.println(giver + " has " + dollars[giverIndex]);
//            dollars[giverIndex] = dollars[giverIndex] - (eachGift * numRecipients);

            for (int j = 0; j < numRecipients; j++) {
                String recipient = f.readLine();
                int recipientIndex = 0;
                for (int k = 0; k < names.length; k++) {
                    if (names[k].equals(recipient)) {
                        recipientIndex = k;
                        break;
                    }
                }
//                dollars[giverIndex] = dollars[giverIndex] - eachGift;
                dollars[recipientIndex] = dollars[recipientIndex] + eachGift;
//                out.println(giver + " gave " + eachGift + " to " + recipient + ", " + giver + " has " + dollars[giverIndex] + ", " + names[recipientIndex] + " has " + dollars[recipientIndex]);
            }
        }

        for (int i = 0; i < np; i++) {
            out.println(names[i] + " " + dollars[i]);
        }

        out.close();                                  // close the output file

    }
}