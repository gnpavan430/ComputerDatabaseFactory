package Utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static Utilities.HTMLUtility.consolidatedReportPath;

public class HTMLFile{
    public static String screenshotsPath=System.getProperty("user.dir") + File.separator + "/screenshots/";
    public static StringBuffer htmlTemplate=new StringBuffer();
    public static void main(String args[]) throws IOException {

       /* File imageDir = new File(screenshotsPath);
        for(File file:imageDir.listFiles()){
            htmlTemplate.append("<html><body>");
            htmlTemplate.append("<center><img src="+file+" alt=\"Girl in a jacket\" width=\"500\" height=\"600\">");
            htmlTemplate.append("<h4>This is H4 heading</h4>");
            htmlTemplate.append("</body></html>");
            BufferedWriter bwr = new BufferedWriter(new FileWriter(new File(consolidatedReportPath)));

            //write contents of StringBuffer to a file
            bwr.write(htmlTemplate.toString());
            bwr.close();

            System.out.println("File names are"+file.getName());
        }*/
       File file = new File("D:\\ComputerDatabasePageFactory\\screenshots\\addComputer\\htmlFile1\\");
       System.out.println("File is"+file);

    }
}


