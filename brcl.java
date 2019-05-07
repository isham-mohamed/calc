import java.io.*;
import java.net.*;

class brcl{
	int i=0;
	Socket s;
	BufferedReader br;
	String str;
	brcl(){
	try{
		s=new Socket("localhost",1250);
		br= new BufferedReader(new InputStreamReader(s.getInputStream()));
		while(true){
			try{
				str=br.readLine();
				System.out.println(str);
				if(str.equals("exit"))
					System.exit(0);
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}
	catch(Exception e){
		System.out.println(e);
	}
	}
	
	public static void main(String args[]){
	brcl b=new brcl();
	}



}