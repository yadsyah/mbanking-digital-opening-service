package id.co.diansetiyadi.digitalopeningservice.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DigitalOpeningHelper {


    public static String generateReffCode(String cif) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy");
        Random random = new Random(4);
        return "PB"+simpleDateFormat.format(new Date())+random;
    }
}
