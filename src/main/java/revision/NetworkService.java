package revision;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class NetworkService {

    private InputStream is;
    private DataInputStream dis;
    private OutputStream os;
    private DataOutputStream dos;

    public NetworkService(Socket socket) throws IOException{
        this.is = socket.getInputStream();
        this.dis = new DataInputStream(is);
        this.os = socket.getOutputStream();
        this.dos = new DataOutputStream(os);
    }
    
    public String readInput() throws IOException{
        return dis.readUTF();
    }
    
    public void writeOutput(String output) throws IOException {
        dos.writeUTF(output);
        dos.flush();
    }

    public void close() throws IOException{
        dis.close();
        is.close();
        dos.close();
        os.close();
    }
}
