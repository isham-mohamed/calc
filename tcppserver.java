import java.io.*;
import java.net.*;
public class server
{ 
public static void main(String args[]) throws Exception
{
System.out.println("Tcp server:");
System.out.println("Server is ready to connect:");
ServerSocket serversoc=new ServerSocket(5050);
Socket clientsoc=serversoc.accept();
PrintWriter out=new PrintWriter(clientsoc.getOutputStream(),true);
BufferedReader in=new BufferedReader(new InputStreamReader(clientsoc.getInputStream()));
String inputline;
BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
try
{
while(true)
{
inputline=stdin.readLine();
out.println(inputline);
if(inputline.equals("exit"))
System.exit(0);
System.out.println("client Says:"+in.readLine());
out.flush();
}
}
catch(Exception e)
{
System.exit(0);
}
}
}