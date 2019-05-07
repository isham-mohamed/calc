import java.io.*;
import java.net.*;
import java.util.*;
 
public class UdpServer1{
DatagramSocket ds;
DatagramPacket dp;
BufferedReader in;
InetAddress ip;
int port;
byte[] rp,sendpackt;
String str;
public UdpServer1(){
	try{
		in=new BufferedReader(new InputStreamReader(System.in));
		ds=new DatagramSocket(3000);
		ip=InetAddress.getByName("localhost");
		rp=new byte[100];
		do{
			dp=new DatagramPacket(rp,rp.length);
			ds.receive(dp);
			ip=dp.getAddress();
			port=dp.getPort();
			str=new String(dp.getData(),0,dp.getLength());
			System.out.println("Client="+str);
			if (str.equals("exit"))
				System.exit(0);
			sendpackt=new byte[100];
			System.out.print("Server: ");
			str=in.readLine();
			sendpackt=str.getBytes();
			dp=new DatagramPacket(sendpackt,sendpackt.length,ip,port);
			ds.send(dp);
		}while(!str.equals("exit"));
	}
	catch(Exception e){
	System.out.println(e);
	}

}
public static void main(String args[]){
UdpServer1 s=new UdpServer1();
}

}