package daily;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main1(String[] args) {
        String[] board = new String[3];
        board[0]="...A";
        board[1]="...A";
        board[2]="...A";
        int R=board.length;
        int C = board[0].length();
        char[][] charBoard = new char[R][C];
        for (int i =0; i< R;i++){
            for (int j=0;j<C;j++){
                charBoard[i][j]=board[i].charAt(j);
            }
        }

        Test1 test1 = new Test1();
        System.out.println(test1.countRectangles(charBoard, R, C));
    }

    public int countRectangles(char[][] charBoard, int R, int C){

        int[][] countA=new int[R+1][C+1];
        int[][] countB=new int[R+1][C+1];

        for (int i =1;i<=R;i++){
            for (int j =1;j<=C;j++){
                countA[i][j]= countA[i-1][j]+countA[i][j-1]-countA[i-1][j-1]+(charBoard[i-1][j-1]=='A'?1:0);
                countB[i][j]= countB[i-1][j]+countB[i][j-1]-countB[i-1][j-1]+(charBoard[i-1][j-1]=='B'?1:0);
            }
        }
        int counter=0;
        for (int i =1;i<=R;i++){
            for(int j=1;j<=C;j++){
                if (countA[i][j]==countB[i][j]){
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) throws ParseException {
        DateTimeFormatter formatterT =
                DateTimeFormatter.ofPattern("MM-dd-yyyy'T'HH:mm:ss");
        System.out.println(convertDateTimezone("12-04-2024T02:30:00", "America/New_York", "US/Eastern", formatterT));
    }



    public static String convertDateTimezone(
            String dateTime, String sourceTz, String destTz, DateTimeFormatter formatter) throws ParseException {
        DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       long countOfTimeBlocks =
                TimeUnit.MILLISECONDS.toMinutes(
                        dfm.parse("2024-11-18 08:00:00").getTime()
                                - dfm.parse("2024-11-18 07:00:00").getTime())
                        / 60;


        double v = Math.ceil((dfm.parse("2024-11-18 08:00:00").getTime() - dfm.parse("2024-11-18 07:00:00").getTime()) / (1000 * 60 * 60)) - (dfm.parse("2024-11-18 08:00:00").getTimezoneOffset() - dfm.parse("2024-11-18 07:00:00").getTimezoneOffset()) / 60;
        System.out.println(v);
        System.out.println(countOfTimeBlocks);
        ZonedDateTime sourceDateTime;
        try {
            sourceDateTime =
                    ZonedDateTime.of(LocalDateTime.parse(dateTime, formatter), ZoneId.of(sourceTz));
        } catch (Exception e) {
            sourceDateTime =
                    ZonedDateTime.of(LocalDateTime.parse(dateTime, formatter), ZoneId.of(sourceTz));
        }

        ZonedDateTime convertedDateTime = sourceDateTime.withZoneSameInstant(ZoneId.of(destTz));
        return convertedDateTime.format(formatter);
    }
}
