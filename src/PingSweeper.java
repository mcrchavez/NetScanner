import java.net.*;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class PingSweeper{

    private String localHostBase;
    private boolean verbose;
    private ArrayList<String> activeIPs;

    public PingSweeper(String target, int[] range, boolean verbose){
            try{
                this.localHostBase = "";
                this.verbose = verbose;
                this.activeIPs = new ArrayList<String>(0);
                    String localHost = InetAddress.getLocalHost().getHostAddress();
                    //System.out.println(localHost);
                    String[] subArray = localHost.split("\\.");
                    //System.out.println(subArray.length);
                    //System.out.println(subArray[0]);
                    for(int i = 0;i<subArray.length - 1;i++){
                        this.localHostBase += subArray[i] + ".";
                    }

                    System.out.println(localHostBase);
                    if(!(target=="localhost")) {
                        this.localHostBase = target;
                    }
                    //System.out.println(this.localHostBase);
                    sweep(this.localHostBase, range[0], range[1]);


                }
            catch(Exception e){
                System.out.println(e);
                System.out.println("Invalid Argument Input");
                //System.out.println("NetScanner -P");
                //System.out.println(args.length);
            }

        }


    /**
     *
     * @param IP provided string to fetch target IP address from
     * @return returns true if the ping was successful
     */

    private boolean ping(String IP, int timeout){
        try {
            InetAddress target = InetAddress.getByName(IP);
            //timeout for tcp ping
            if(target.isReachable(timeout)) {
                return true;
            }
        }
        catch(Exception e){
            System.out.println(e);
            System.out.println("Invalid IP Address Provided");
        }
        return false;

    }
    private boolean ping(String IP){
        return ping(IP, 5000);
    }


    /**
     *
     * @param baseIP provide the baseIP onto which i will be appended up to 255
     */
    private void sweep(String baseIP, int min, int max){
        LocalDateTime time = LocalDateTime.now();
        System.out.println(String.format("Sweep Started: %s",time.toString()));
        String base = baseIP;
        if(max > 255){
            System.out.println("Maximum is 255");
        }
        for(int i = min;i<= max;i++){
            try{
                if(this.verbose == true) {
                    System.out.println(String.format("Scanning %s", baseIP + i));
                }
                if( this.ping(baseIP + i) == true){
                    System.out.println(String.format("%s is up Hostname: %s", baseIP + i, this.getName(baseIP + i)));
                    this.activeIPs.add(baseIP + i);
                }
            }
            catch(Exception e){
                System.out.println("sweep failed");
                System.out.println(e);
            }
        }
        System.out.println(String.format("Sweep Completed: %s", time.toString()));

        if(this.activeIPs.size() > 0) {
            String activeString = "\n";
            for (String x : this.activeIPs) {
                activeString += x + " " + getName(x) + "\n";

            }
            System.out.println(String.format("Active IP Addresses: %s", activeString));
        }
        else{
            System.out.println("No Active Devices Found");
        }
    }

    private void sweep(String baseIP, int single){
        this.sweep(baseIP, single, single);
    }
    private void sweep(String baseIP){
        this.sweep(baseIP, 1, 255);
    }
    private String getName(String IP){
        String hostName = null;
        try {
            InetAddress targ = InetAddress.getByName(IP);
            hostName = targ.getHostName();
        }
        catch(Exception e){
            System.out.println("getName failed");
            System.out.println(e);
        }
        return hostName;

    }
}
