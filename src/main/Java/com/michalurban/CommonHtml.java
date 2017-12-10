package com.michalurban;

public abstract class CommonHtml {

    static String getTopHtml(String title) {

        return "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "   <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />" +
                "   <link rel=\"stylesheet\" href=\"styles.css\" type=\"text/css\">" +
                "   <title>" + title + "</title>" +
                "</head>" +
                "<body>";
    }

    static String getBottomHtml() {

        return "</body>" +
                "</html>";
    }

}
