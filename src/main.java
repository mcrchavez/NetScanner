import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

//syntax for compliation/running
//java -cp "C:\PersonalProjects\NetScanner\lib\picocli-4.6.1.jar" main.java main --font-size=24
//https://picocli.info/quick-guide.html



import picocli.CommandLine;
import picocli.CommandLine.*;

@Command(name="NetScanner", version = ".01 improved cmdline prototype", mixinStandardHelpOptions = true, description = "Network Enumeration Framework")
public class main{
    @Command(name="-P", description = "Sweep network for targets using ping protocol",  mixinStandardHelpOptions = true)
    void pingSweepSubCommand(@Option(names={"-t", "--host", "--target"}, description = "Specify hostname or target IP for sweep", defaultValue = "0") String target){
    }





    public static void main(String[] args) throws InterruptedException {
        int exitCode = new CommandLine(new main()).execute(args);
        //System.out.println("test");
        System.exit(exitCode);


        /*
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

         */
    }
}
