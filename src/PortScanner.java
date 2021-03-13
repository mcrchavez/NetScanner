
//enables OS socket functionality
import java.net.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PortScanner {
    private String targHostName;
    private InetAddress targIP;
    private Socket target;

    private ArrayList<Integer> openPorts = new ArrayList<Integer>


    /**
     * Initialize Pinger Object with the command line args
     */
    PortScanner(String[] args){

        if(args.length > 0){
            try {
                if (args.length == 1) {
                    System.out.println("First reached");
                    targHostName = InetAddress.getLocalHost().getHostName();
                    targIP = InetAddress.getByName(this.targHostName);
                } else if(args[0].equals("-h") && args.length == 2){
                    //if there are no port specifications
                    System.out.println("Second Reached");
                    targHostName = args[1];
                    this.targIP = InetAddress.getByName(targHostName);
                    this.scan();
                }
                else if(args[0].equals("-h") && args[2].equals("-p")){
                    targHostName = args[1];
                    this.targIP = InetAddress.getByName(targHostName);
                    if(args.length == 4){
                        this.scan(Integer.parseInt(args[3]));
                    }
                    if(args.length == 5){
                        this.scan(Integer.parseInt(args[3]), Integer.parseInt(args[4]));
                    }

                }
                else{
                    throw new Exception();
                }
            }
            catch (Exception e){
                System.out.println(e);
                System.out.println("Invalid Arguement Input");
                System.out.println("PortScanner -h <hostname/IP>");
                System.out.println(args.length);
                System.out.println(args[0]);
            }

        }
        else{
            System.out.println("Invalid Argument Input");
            System.out.println("PortScanner -h <hostname/IP>");
            System.out.println(args.length);
        }



    }
    public void help(){
        System.out.println("PortScanner -h <hostname/IP>");
    }

    /**
     *
     * @param min starting port to scan
     * @param max max port to scan
     */
    private void scan(int min, int max){
        LocalDateTime time = LocalDateTime.now();
        System.out.println(String.format("Scan Started: %s",time.toString()));
        System.out.println(String.format("Scanning %s", this.targHostName));
        for(int i = min;i<=max;i++) {
            try {
                Socket newSock = new Socket(this.targIP,i);
                System.out.println(String.format("Port %d open", i));
                System.out.println("PWN It ;)");
            }
            catch(Exception e){
                System.out.println(e);
                System.out.println(String.format("Port %d closed", i));
            }
        }

    }

    /**
     *
     * @param max max port to scan
     */
    private void scan(int max){
        scan(0, max);
    }

    /**
     * Scans all possible ports
     */
    private void scan(){
        scan(0, 65535);
    }

}
