import java.net.*;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class PingSweeper {
    private String baseIP;

    public PingSweeper(String[] args){
        if(args.length > 0){
            try{
                this.baseIP = "";
                if(args.length == 1 && args[0].equals("-P")){
                    String localHost = InetAddress.getLocalHost().getHostAddress();
                    System.out.println(localHost);
                    String[] subArray = localHost.split("\\.");
                    //System.out.println(subArray.length);
                    //System.out.println(subArray[0]);
                    for(int i = 0;i<subArray.length - 1;i++){
                        this.baseIP += subArray[i] + ".";
                    }
                    System.out.println(this.baseIP);
                    sweep(this.baseIP);



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

    private void sweep(String baseIP){
        String base = baseIP;
        for(int i = 0;i<= 255;i++){
            try{
                this.ping(baseIP + i);
            }
            catch(Exception e){
                System.out.println("sweep failed");
                System.out.println(e);
            }

        }
    }
}
