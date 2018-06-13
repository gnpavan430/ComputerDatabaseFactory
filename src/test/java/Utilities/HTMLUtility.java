package Utilities;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HTMLUtility {
    public static StringBuffer htmlTemplate=new StringBuffer();
    static String HTML_END = "</BODY></HTML>";
    static String HTML_START = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"><HTML><HEAD>";
    static String filePath ="C:\\Users\\X085271\\Inspire\\HtmlTemplate.html";
    public static void createHTMLTemplate() throws IOException{
        htmlTemplate.append(HTML_START);
        htmlTemplate.append("<body><h1><center>Test Automation Report</h1><br/></body>");
        htmlTemplate.append("<style>table, th, td { border: 1px solid blue;</style>");
        htmlTemplate.append("<table style=\"width:100%\">" +
                "<tr>" +
                "<th>Sl No</th>"+
                "<th>Test Case Name</th>" +
                "<th>Status</th>" +
                "<th>Pass Percentage</th>" +
                "<th>Execution Time</th>" +
                "</tr>");

        //htmlTemplate.append(HTML_END);
		/*FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\X085271\\Inspire\\HtmlTemplate.html");
		fileOutputStream.write(htmlTemplate.toString());*/
        BufferedWriter bwr = new BufferedWriter(new FileWriter(new File(filePath)));

        //write contents of StringBuffer to a file
        bwr.write(htmlTemplate.toString());

        //flush the stream
       // bwr.flush();

        //close the stream
        bwr.close();

    }
    public static void closeHTMLReport() throws IOException {
     htmlTemplate.append(HTML_END);
        BufferedWriter bwr = new BufferedWriter(new FileWriter(new File(filePath)));

        //write contents of StringBuffer to a file
        bwr.write(htmlTemplate.toString());

        //flush the stream
       // bwr.flush();

        //close the stream
        bwr.close();

    }
    public static void testCaseExecutionStatus(int testCasesCount, String testCaseName, String status){
        htmlTemplate.append("<table style=\"width:100%\">" +
                "<tr>" +
                "<th>"+testCasesCount+"</th>"+
                "<th>"+testCaseName+"</th>" +
                "<th>"+status+"</th>" +
                "<th>Pass Percentage</th>" +
                "<th>Execution Time</th>" +
                "</tr>");
        System.out.println("Test case execution count is"+testCasesCount);
        System.out.println("Test case name is"+testCaseName);
        System.out.println("Test case status is"+status);

    }

}
