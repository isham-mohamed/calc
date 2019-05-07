import java.io.*;
import java.net.*;

public class UdpClient1{
DatagramSocket ds;
DatagramPacket dp;
byte[] sendpack,recevpackt;
InetAddress ip;
BufferedReader in;
String str;
public UdpClient1(){
	try{
		in=new BufferedReader(new InputStreamReader(System.in))	;
		ip=InetAddress.getByName("172.16.126.1");
		ds=new DatagramSocket();
		do{
			sendpack=new byte[100];
			System.out.println("Client:");
			str=in.readLine();
			sendpack=str.getBytes();
			dp=new DatagramPacket(sendpack,sendpack.length,ip,1456);
			ds.send(dp);
			if (str.equals("exit"))
 				System.exit(0);
			recevpackt=new byte[100];
			dp=new DatagramPacket(recevpackt,recevpackt.length);
			ds.receive(dp); 
			String data = new String(dp.getData(),0,dp.getLength());
			System.out.println("Server: "+data);
			
		}while(!str.equals("exit"));
	}	
	catch(Exception e){
		System.out.println(e);
	}

}

public static void main(String args[]){
	UdpClient1 uc=new UdpClient1();
}

}