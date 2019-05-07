import java.io.*;
import java.net.*;

class Server1{
	int i=0;
	ServerSocket ss;
	Thread t;
	Socket s[]=new Socket[10];
	PrintStream ps[]=new PrintStream[10];
	BufferedReader br;
	BufferedReader brp[]=new BufferedReader[20];
	String str;
	File f;
	FileReader fr;
	int j;
	Server1(){
	try{	
		t=new Thread(new Thread1());
		ss=new ServerSocket(5050);
		t.start();
	}
	catch(Exception e){
		//System.out.println(e);
	}
	}
	
	public static void main(String args[]){
	Server1 b=new Server1();
	}
//}

class Thread1 extends Thread{
	public void run(){
		while(true){
			try{
				s[i]=ss.accept();
				ps[i]=new PrintStream(s[i].getOutputStream(),true);
				brp[i]= new BufferedReader(new InputStreamReader(s[j].getInputStream()));
				j=i;
				i++;
				str=brp[j].readLine();
				System.out.println(str);
				f=new File(str);
				if(f.exists()){
					fr=new FileReader(f);
					br= new BufferedReader(fr);
					while((str=br.readLine())!=null){
						ps[j].println(str);
						System.out.println(str);
					}
					ps[j].println("end");
				}
				else
					System.out.println("File Not Exist");
			}
			catch(Exception e){
				//System.out.println(e);
			}	
		}
	}
}
}