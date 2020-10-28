/**
 * @author Toni Fields
 *
 * Student: Toni Fields
 * Student ID: #001307628
 * Course: C195 - Software II
 * Project: Scheduling Application
 */

package utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ConvertToUTC {

        public static String convertLDTtoUTC(LocalDateTime time) {
/*
                ZonedDateTime ldtZoned = date.atZone(ZoneId.systemDefault());
                ZonedDateTime utcZoned = ldtZoned.withZoneSameInstant(ZoneId.of("UTC"));
                System.out.println("ZonedDateTime: " + utcZoned);
                System.out.println("ZonedDateTime to LDT: " + utcZoned.toLocalDateTime());
                System.out.println("ZonedDateTime to LD: " + utcZoned.toLocalDate());
                System.out.println("ZonedDateTime to LD toString: " + utcZoned.toLocalDate().toString());

 */
                ZonedDateTime ldtZoned = time.atZone(ZoneId.systemDefault());
                ZonedDateTime utcZoned = ldtZoned.withZoneSameInstant(ZoneId.of("UTC"));

                return utcZoned.toLocalDate().toString() + " " + utcZoned.toLocalTime().toString();   //may have to convert to local time & convert it to LocalDate & LocalTime
        }

        public static LocalDateTime convertUTCtoLDT(Timestamp time) {

                /*System.out.println("Original: " + time);
                System.out.println("Original to Instant at SystemDefault: " + time.toInstant().atZone(ZoneId.systemDefault()));
                //System.out.println("Original to Instant at SystemDefault: " + time.toInstant().atOffset(ZoneOffset.of()));
                System.out.println("Original to Instant at Offset to LDT: " + time.toInstant().atOffset(ZoneOffset.UTC).toLocalDateTime());
                System.out.println("Original to LDT at systemDefault: " + time.toLocalDateTime().atZone(ZoneId.systemDefault()));
                System.out.println("Original to Instant: " + time.toInstant().atZone(ZoneId.of("UTC")));
                System.out.println("Original to Instant to LDT: " + time.toInstant().atZone(ZoneId.of("UTC")).toLocalDateTime());
                System.out.println("Original to ZDT to LDT: " + time.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());

                 */
                //System.out.println("Instant start: " + start);
                //System.out.println("ZDT utcDateTime: " + utcDateTime.withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime());
                LocalDateTime ldt = time.toLocalDateTime();
                ZonedDateTime zdt = ldt.atZone(ZoneId.of("UTC"));
                ZonedDateTime newZdt = zdt.withZoneSameInstant(ZoneId.systemDefault());
                LocalDateTime newLdt = newZdt.toLocalDateTime();


                return newLdt; //LocalDateTime.of(time.toInstant().atZone(ZoneId.systemDefault()));
        }

}
