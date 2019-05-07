import java.io.*;
import java.net.*;
class Server1{
	int i,j;
	Socket s[]=new Socket[20];
 	BufferedReader br[]=new BufferedReader[20];
	PrintStream ps[]=new PrintStream[20];
	Thread t,t1;
	String str;
	ServerSocket ss;
	Server1(){
	try{
		ss=new ServerSocket(1254);
		t=new Thread(new ThreadMaker());
		t.start();
	}
	catch(Exception e){}
	}
	class ThreadMaker extends Thread{
		public void run(){
			while(true){
				try{
					System.out.println("Accept thread running");
					s[i]=ss.accept();
					System.out.println("client"+i+"connected");
					ps[i]=new PrintStream(s[i].getOutputStream(),true);
					br[i]=new BufferedReader(new InputStreamReader(s[i].getInputStream()));
					t1=new Thread(new ThreadMaker1(i));
					t1.start();
					i++;
				}
				catch(Exception e){}
			}
		}
	}
	class ThreadMaker1 extends Thread{
		int n,no;
		ThreadMaker1(int i){
			n=i;
			no=n+1;
		}
		public void run(){
			while(true){
				try{
					System.out.println("recieve thread running:"+i);
					str=br[n].readLine();
					System.out.println("recieved:"+str);
					System.out.println(str);
					for(j=0;j<=i;j++){
						if(n!=j){
							System.out.println("data sent to"+j+"client");
							ps[j].println("client"+no+":"+str);	
						}
					}
				}
				catch(Exception e){}
			}
		
		}
	}
	public static void main(String args[]){
		Server1 sss=new Server1();
	}	
	
}