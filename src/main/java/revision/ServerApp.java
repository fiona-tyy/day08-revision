package revision;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerApp {

    public static void main(String[] args) throws IOException {

        int port = 12345; // default port
        
        if(args.length >0){

            if(args[0].equalsIgnoreCase("kill")){
                System.out.println("Ending program");
                System.exit(0);
            } else {
                port = Integer.parseInt(args[0]);
                System.out.println("Port = " + port);
            }
        }

        // Create server socket
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started at " + port);

        while(true){

            // Server socket to accept client
            Socket sock = server.accept();
            NetworkService netSvc = new NetworkService(sock);
            IdiomService idiomSvc = new IdiomService();
            List<String> idioms = null;

            while (true){

                String dataFromClient = netSvc.readInput();
                switch(dataFromClient){
                    case "1":
                    // cannot instantiate IdiomService class here; must do at class level
                        idioms = new ArrayList<>();
                        idioms = idiomSvc.readFile("/Users/Fiona/Documents/TFIP/day08-revision/src/main/java/revision/day08data/idioms.txt");
                        System.out.println("File read");
                        netSvc.writeOutput(">> Idioms.txt file read");
                        break;
                    case "2":
                        String randomIdiom = idiomSvc.randomIdiom(idioms);
                        System.out.println(randomIdiom);
                        netSvc.writeOutput(">> " + randomIdiom);
                        break;
                    case "3":
                        idiomSvc.showAllIdioms(idioms);
                        break;
                    case "Q":
                    case "q":
                        System.out.println("Bye... bye...");
                        server.close();
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            }

            
        }
    }
    
}
