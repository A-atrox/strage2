package smt.io.BIO;

import org.apache.commons.net.telnet.TelnetClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author guoyf
 * @Date 2020/7/30
 * @describe
 */
public class BioTelnet {
    private TelnetClient telnetClient = null;

    BioTelnet(String tremtype, int timeout, String addr, int port) {
        try {
            telnetClient = new TelnetClient(tremtype);
            telnetClient.setDefaultTimeout(timeout);
            telnetClient.connect(addr, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        BioTelnet bioTelnet = new BioTelnet("vt200", 5000, "localhost", 12345);
        InputStream inputStream = bioTelnet.telnetClient.getInputStream();
        PrintStream printStream = new PrintStream(bioTelnet.telnetClient.getOutputStream());
        byte[] b = new byte[1024];
        int size;
        StringBuffer stringBuffer = new StringBuffer(300);
        System.out.println(stringBuffer.toString());
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.equals("exit")){
                break;
            }
            printStream.print(s);
            printStream.flush(); //将命令发送到telnet Server
            //写命令

        }
        printStream.close();
        bioTelnet.telnetClient.disconnect();
    }
}
