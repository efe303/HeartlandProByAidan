package com.ets.utilities;

import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

public class MethodsUtil {

    /**
     * To generate Random Alpha Numeric String
     */

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";




    public static String randomInvoiceNumber(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    public static String randomInvoiceNum() {
        Random rnd = new Random();
        int n = 100000 + rnd.nextInt(900000);
        String invoiceNum = Integer.toString(n);
        return invoiceNum;
    }

    /**
     * To generate Random Numeric String
     */
    public static String getAmount() {
        double x = (Math.random() * ((100 - 1) + 1)) + 1;
        String amount = String.format("%.2f", x);
        return amount;

    }

    /**
     * To generate current date
     */
    public static String currentDateToString() {
        Calendar calendar = Calendar.getInstance();
        Date currentDateTime = calendar.getTime();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String testDateString = df.format(currentDateTime);
        return testDateString;

    }


    public static String getDate(Calendar cal){
        return "" +
                (cal.get(Calendar.MONTH)+1) + "/" +cal.get(Calendar.DATE) +"/" + cal.get(Calendar.YEAR);
    }

    public static String currentDateTitleForExceTakingPreviousDatel() {

        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("EST"));

        cal.add(Calendar.DATE, -3);
//        System.out.println("date before 2 days : " + getDate(cal));

        return getDate(cal)+"*";


    }
    public static String TakingPreviousDatelforALongTime(int i) {

        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("EST"));
        cal.add(Calendar.DATE, i);
        return getDate(cal)+"*";

    }
    public static String currentDateTitleForExceTakingCurrentDate() {

        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("EST"));

        cal.add(Calendar.DATE,0);
//        System.out.println(getDate(cal)+"*");
        return getDate(cal)+"*";

    }

    public void Login(){


        BrowserUtils.waitFor(2);
        String title=Driver.getDriver().getTitle();

        Assert.assertTrue(Driver.getDriver().getTitle().equals("Accounts View | EMoney Enterprise Suite"));
    }

}
