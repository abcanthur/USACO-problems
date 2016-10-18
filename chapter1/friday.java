
/*
ID: peterjo1
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

class friday {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        int n = Integer.parseInt(f.readLine());

        int[] weekday13Counts = new int[7];
        int weekdayCounter = 0; //primed to Monday, ssmtwtf

        int[] regYear = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] leapYear = new int[] {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for(int i = 0; i < n; i++){
            int[] calendar = regYear;
            if((i + 1900) % 4 == 0){
                calendar = leapYear;
                if((i + 1900) % 100 == 0){
                    calendar = regYear;
                    if((i + 1900) % 400 == 0){
                        calendar = leapYear;
                    }
                }
            }

            for(int j = 0; j < 12; j++){
                for(int k = 0; k < calendar[j]; k++){
                    weekdayCounter++;
                    if(k == 13){
                        weekday13Counts[weekdayCounter % 7]++;
                    }
                }
            }

        }

        String howMany13s = "";
        for(int i = 0; i < 7; i++){
            howMany13s = howMany13s + weekday13Counts[i];
            if(i < 6) {
                howMany13s = howMany13s + " ";
            }
        }
        out.println(howMany13s);
        out.close();

    }
}