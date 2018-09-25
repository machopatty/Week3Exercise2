package com.markkump.datetag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateTag extends SimpleTagSupport{
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();

        Date date= new Date();
        int hours = date.getHours();
        LocalDateTime localDateTime = LocalDateTime.now();

        String holidayDate;

        holidayDate = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH).format(localDateTime);

        if (holidayDate.equals("10-31-2018")){
            out.println("Happy Halloween and ");
        } else if (holidayDate.equals("12-25-2018")) {
            out.println("Merry Xmas and ");
        }


        if (hours < 12) {
            out.println("Good morning!");
        } else if (hours >= 12 && hours < 17) {
            out.println("Afternoon!");
        } else if (hours >= 17) {
            out.println("Goodnight!");
        }


    }
}
