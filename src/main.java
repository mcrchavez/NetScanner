import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class main {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        if(args.length > 0){
            switch(args[0]){
                case "-h":
                case "--help":
                    System.out.print(String.format("-P ping sweeper:\n-v verbose\n-r specify range of ips for ping\n\n" +
                            "-Ps port scanner:\n-h specify target hostname or ip\n-p specify range of ports to query"));
                    break;
                case "-P":
                    PingSweeper ping = new PingSweeper(args);
                    break;
                case "-Ps":
                    PortScanner scan = new PortScanner(args);
                    break;
                default:
                    System.out.println("Invalid argument");
                    System.out.print(String.format("-P ping sweeper:\n-v verbose\n-r specify range of ips for ping\n\n" +
                            "-Ps port scanner:\n-h specify target hostname or ip\n-p specify range of ports to query"));
                    break;
            }

        }
        if(args.length == 0){
            System.out.print(String.format("-P ping sweeper:\n-v verbose\n-r specify range of ips for ping\n\n" +
                    "-Ps port scanner:\n-h specify target hostname or ip\n-p specify range of ports to query"));
        }
    }
}
