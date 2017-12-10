package com.michalurban;

public abstract class CommonHtml {

    static String getTopHtml(String title) {

        return "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "   <title>" + title + "</title>" +
                "   <link rel=\"stylesheet\" href=\"styles.css\" type=\"text/css\">" +
                "</head>" +
                "<body>";
    }

    static String getBottomHtml() {

        return "</body>" +
                "</html>";
    }
}
