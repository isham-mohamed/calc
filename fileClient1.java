import java.io.*;
import java.net.*;

class Client1{
	Socket s;
	BufferedReader brs,brk;
	PrintWriter out;
	FileOutputStream fout;
	String str,fname;
	Client1(){
		try{
			s=new Socket("localhost",5050);
			out=new PrintWriter(s.getOutputStream(),true);
			brs=new BufferedReader(new InputStreamReader(s.getInputStream()));
			brk=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Nter File name:");
			fname=brk.readLine();
			out.println(fname);
			System.out.print("Nter File name to be saved:");
			fname=brk.readLine();
			fout=new FileOutputStream(fname);
			while(true){
			try{
				str=brs.readLine();
				if(str.equals("end"))
					System.exit(0);
				byte[] b=str.getBytes();
				fout.write(b);
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
	Client1 b=new Client1();
	}

}