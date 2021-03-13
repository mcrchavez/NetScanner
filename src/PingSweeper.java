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
                        baseIP += subArray[i] + ".";
                    }
                    System.out.println(baseIP);
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
}
