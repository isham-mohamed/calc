import java.io.*;
import java.net.*;

public class tcpclient
{   
	public static void main(String args[]) throws IOException
		{
			System.out.println("TCP Client");
			System.out.println("Enter name of host to connect:");
			BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
			String str = inp.readLine();
			Socket clientsoc = new Socket(str,5050);
			PrintWriter out = new PrintWriter(clientsoc.getOutputStream(),true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientsoc.getInputStream()));
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			String inputline;

			try
				{
					while(true)
						{				
							System.out.println("Server Says:"+in.readLine());
							inputline = stdin.readLine();
							out.println(inputline);
							out.flush();
							if(inputline.equals("exit"))
								System.exit(0);
						}
				}
			
			catch(Exception e)
				{
					System.exit(0);
				}
		}
			
}