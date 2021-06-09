//enables OS socket functionality
import java.net.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PortScanner {
    private String targHostName;
    private InetAddress targIP;
    private Socket target;
    private ArrayList<Integer> openPorts = new ArrayList<Integer>(0);


    /**
     * Initialize Pinger Object with the command line args
     */
    PortScanner(String[] args){

        if(args.length > 0 && args[0].equals("-Ps")){
            try {
                if (args.length == 1 && args[0].equals("-Ps")) {
                    //System.out.println("First reached");
                    targHostName = InetAddress.getLocalHost().getHostName();
                    targIP = InetAddress.getByName(this.targHostName);
                    this.scan();
                } else if(args[1].equals("-h") && args.length == 3){
                    //if there are no port specifications
                    //System.out.println("Second Reached");
                    targHostName = args[2];
                    this.targIP = InetAddress.getByName(targHostName);
                    this.scan();
                }
                else if(args[1].equals("-h") && args[3].equals("-p")){
                    targHostName = args[2];
                    this.targIP = InetAddress.getByName(targHostName);
                    if(args.length == 5){
                        this.scan(Integer.parseInt(args[4]));
                    }
                    if(args.length == 6){
                        this.scan(Integer.parseInt(args[4]), Integer.parseInt(args[5]));
                    }

                }
                else{
                    throw new Exception();
                }
            }
            catch (Exception e){
                System.out.println(e);
                System.out.println("Invalid Argument Input");
                //System.out.println("NetScanner -Ps -h <hostname/IP>");
                //System.out.println(args.length);
                //System.out.println(args[1]);
            }

        }
        else{
            System.out.println("Invalid Argument Input");
            //System.out.println("NetScanner -Ps -h <hostname/IP>");
            //System.out.println(args.length);
        }



    }
    public void help(){
        System.out.println("NetScanner -Ps -h <hostname/IP>");
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
                this.openPorts.add(i);
            }
            catch(Exception e){
                //System.out.println(e);
                System.out.println(String.format("Port %d closed", i));
            }
        }
        System.out.println(String.format("Scan Completed: %s", time.toString()));
        String portString = "";
        if(this.openPorts.size() > 0) {
            for (Integer x : this.openPorts) {
                portString += x + " ";

            }
            System.out.println(String.format("Open Ports: %s", portString));
        }
        else{
            System.out.println("No Open Ports Found");
        }


    }

    /**
     *
     * @param port single port to scan
     */
    private void scan(int port){
        scan(port, port);
    }

    /**
     * Scans all possible ports
     */
    private void scan(){
        scan(0, 65535);
    }

    /**
     *
     * @return the arraylist object with all open ports
     */
    public ArrayList<Integer> getOpenPorts(){
        return this.openPorts;
    }

}
