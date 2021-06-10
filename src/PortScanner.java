//enables OS socket functionality
import java.net.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PortScanner {
    private String targHostName;
    private InetAddress targIP;
    private Socket target;
    private ArrayList<Integer> openPorts = new ArrayList<Integer>(0);
    private boolean verbose;


    PortScanner(String targetIP, int[] portRange, boolean verbose){
            try {
                this.verbose = verbose;
                if (targetIP.equals("localhost")){
                    //System.out.println("First reached");
                    targHostName = InetAddress.getLocalHost().getHostName();
                    targIP = InetAddress.getByName(this.targHostName);
                    this.scan();
                } else if (portRange.length == 1){
                    targHostName = targetIP;
                    targIP = InetAddress.getByName(this.targHostName);
                    this.scan(portRange[0]);
                }
                else{
                    targHostName = targetIP;
                    targIP = InetAddress.getByName(this.targHostName);
                    this.scan(portRange[0], portRange[1]);
                }
            }
            catch (Exception e){
                System.out.println("Invalid Argument Input");
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
