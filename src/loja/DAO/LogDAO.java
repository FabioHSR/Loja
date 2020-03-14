package loja.DAO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import loja.Loja;

public class LogDAO {
    static String path = "/Log.txt";
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");

    public static void writeFile(String dados) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(Loja.rootpath + path,true));
            pw.println((sdf.format(new Date()))+" - "+dados);
            pw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}