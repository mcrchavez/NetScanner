//syntax for compliation/running
//java -cp "C:\PersonalProjects\NetScanner\lib\picocli-4.6.1.jar" NetScanner.java main --font-size=24
//https://picocli.info/quick-guide.html

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name="NetScanner", version = ".01 improved cmdline prototype", mixinStandardHelpOptions = true, description = "Network Enumeration Framework")
public class NetScanner {
    @Command(name="-P", description = "Sweep network for targets using ping protocol",  mixinStandardHelpOptions = true)
    void pingSweepSubCommand(@Option(names={"-t", "--host", "--target"}, description = "Specify target IP for ping sweep", defaultValue = "localhost") String target,@Option(names = {"-r", "--range"}, description = "Specify range of IP addresses to ping", split = " ", defaultValue = "0 255") int[] ipRange, @Option(names = {"-v"},
            description = "Enable Verbose output of results", defaultValue = "false") boolean verbosity){
        PingSweeper sweep = new PingSweeper(target, ipRange, verbosity);
    }
    @Command(name="-Ps", description = "Scan specified device/IP on network for open ports", mixinStandardHelpOptions = true)
    void PortScanSubCommand(@Option(names = {"-t", "--host", "--target"}, description = "Specify target IP/hostname for port scan", defaultValue = "localhost") String target, @Option(names = {"-r", "--range"}, description = "Specify range of ports on host to probe", split = " ", defaultValue = "0 65535") int[] portRange, @Option(names = {"-v"},
    description = "Enable verbose output of results", defaultValue = "false") boolean verbosity){

    }






    public static void main(String[] args) throws InterruptedException {
        int exitCode = new CommandLine(new NetScanner()).execute(args);
        //System.out.println("test");
        System.exit(exitCode);
    }
}
