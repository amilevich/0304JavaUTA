
package Q20;

import java.io.*;  
public class Q20Main {  
    public static void main(String args[])throws Exception{    
          FileReader file=new FileReader("./Data.txt");    
          BufferedReader read=new BufferedReader(file);    
  
          String i;    
          while((i=read.readLine()) != null){ 
        	  
        	  String [] s= i.split(":");
        	          	  
         	  System.out.println("Name:" + s[0] +" "+ s[1]); 
         	  System.out.println("Age:" + s[2] + " years");
         	  System.out.println("State:" + s[3]);
         	  System.out.println("");
         	 
         	 
          }  
          read.close();    
          file.close();    
    }    
} 

