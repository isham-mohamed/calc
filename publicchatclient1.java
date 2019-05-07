import java.io.*;
import java.net.*;
class client1{
	Socket s;
 	BufferedReader br,br1;
	PrintStream ps;
	Thread t1;
	String str,str1;
	client1(){
	try{
		s=new Socket("localhost",1254);
		ps=new PrintStream(s.getOutputStream(),true);
		br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		br1=new BufferedReader(new InputStreamReader(System.in));
		t1=new Thread(new ThreadMaker());		
		t1.start();
		while(true){
			//System.out.println("while Running");
			str=br1.readLine();
			ps.println(str);
		}
	}
	catch(Exception e){}
	}
	class ThreadMaker extends Thread{
		public void run(){
			while(true){
				try{
					//System.out.println("Thread Runing");
					str1=br.readLine();
					System.out.println(str1);
				}
				catch(Exception e){}
			}
		}
	}
	public static void main(String args[]){
		client1 ccc=new client1();
	}
	
}