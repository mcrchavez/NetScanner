import java.net.*;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class PingSweeper {
    private String localHostBase;
    private boolean verbose;

    public PingSweeper(String[] args){
        if(args.length > 0){
            try{
                this.localHostBase = "";
                this.verbose = false;
                if(args.length <=2 && args[0].equals("-P")){
                    if(args.length == 2 && args[1].equals("-v")){
                        this.verbose = true;
                    }
                    String localHost = InetAddress.getLocalHost().getHostAddress();
                    //System.out.println(localHost);
                    String[] subArray = localHost.split("\\.");
                    //System.out.println(subArray.length);
                    //System.out.println(subArray[0]);
                    for(int i = 0;i<subArray.length - 1;i++){
                        this.localHostBase += subArray[i] + ".";
                    }
                    //System.out.println(this.localHostBase);
                    sweep("192.168.21.");
                }

            }
            catch(Exception e){
                System.out.println(e);
                System.out.println("Invalid Argument Input");
                System.out.println("NetScanner -P");
                System.out.println(args.length);
            }

        }
        else{
            System.out.println("Invalid Argument Input");
            System.out.println("NetScanner -P");
            System.out.println(args.length);
        }

    }

    /**
     *
     * @param IP provided string to fetch target IP address from
     * @return returns true if the ping was successful
     */
    private boolean ping(String IP){
        try {
            InetAddress target = InetAddress.getByName(IP);
            //timeout for tcp ping
            if(target.isReachable(5000)) {
                return true;
            }
        }
        catch(Exception e){
            System.out.println(e);
            System.out.println("Invalid IP Address Provided");
        }
        return false;
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
                }
            }
            catch(Exception e){
                System.out.println("sweep failed");
                System.out.println(e);
            }
        }
        System.out.println(String.format("Sweep Completed: %s", time.toString()));
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
