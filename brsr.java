import java.io.*;
import java.net.*;

class brsr{
	int i=0;
	ServerSocket ss;
	Thread t;
	Socket s[]=new Socket[10];
	PrintStream ps[]=new PrintStream[10];
	BufferedReader br;
	String str;
	int j;
	brsr(){
	try{	
		t=new Thread(new Thread1());
		t.start();
		ss=new ServerSocket(1250);
		br= new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Nter the message to send");
		while(true){
			try{
				str=br.readLine();
				for (j=0;j<i;j++)
					ps[j].println(str);
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
	brsr b=new brsr();
	}
//}

class Thread1 extends Thread{
	public void run(){
		while(true){
			try{
				s[i]=ss.accept();
				ps[i]=new PrintStream(s[i].getOutputStream(),true);
				i++;
			}
			catch(Exception e){
				System.out.println(e);
			}	
		}
	}
}
}