package revision;

import java.io.Console;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientApp {

    public static void main(String[] args) throws UnknownHostException, IOException {
        String hostname = "localhost";
        int port = 12345;
    
        if (args.length > 0){
            hostname = args[0].split(":")[0];
            port = Integer.parseInt(args[0].split(":")[1]);
        }

        try{
            // Create socket
            Socket sock = new Socket(hostname,port);
    
            Console cons = System.console();
            String userSelection = "";
            NetworkService netSvc = new NetworkService(sock);
    
            while (!userSelection.equalsIgnoreCase("Q")){
                displayMenu();
                userSelection = cons.readLine("Enter your selection: ");
                netSvc.writeOutput(userSelection);
    
                String replyFromServer = netSvc.readInput();
                System.out.println(replyFromServer);
    
            }

        } catch (EOFException e){
            System.out.println("Disconnected");
        } 
        
    }

    public static void displayMenu(){
        message("Welcome to My App");
        message("===========================");
        message("1. Read Idioms File");
        message("2. Pick an idiom randomly");
        message("3. List all idioms");
        message("Q Quit the program");
    }

    public static void message(String line){
        System.out.println(line);
    }
    
}
