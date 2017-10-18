

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Decode{
	private BufferedImage image=null; 	   
	private int pixels[][]; 	   
	private char Data[]; 	   
	private int Width,Height; 	   
	private String myString=""; 	   
	
	public Decode(String s) throws IOException
	{ 
	
	try
	{ 	   
	image= ImageIO.read(new File(s));	   
		} 	   
	catch (IOException e) 	   
	{ 	   
	e.printStackTrace(); 	   
	} 	   
	pixels= new int[image.getWidth()][image.getHeight()]; 	   
	Width=image.getWidth(); 	   
	Height=image.getHeight(); 	   
	 	   
	for(int i=0;i<Width;i++) 	   
	{ 	   
	for(int j=0;j<Height;j++) 	   
	{ 	   
	pixels[i][j]=image.getRGB(i, j); 	   
	} 	   
	} 	   
	/*FileWriter fw=null; 	   
	File file=null; 	   
	CharArrayWriter bw=null; 	   
	try	   
	{ 	   
	file = new File(s2);//"C:/Users/sarvottam/Desktop/Retreive.txt"); 	   
	fw = new FileWriter(file); 	   
	bw= new CharArrayWriter(); 	   
	} 	   
	catch (Exception e)
	{
	e.printStackTrace(); 	   
	} */	   
	ReadLSB(); 	   
        String str1="";
        int t=0;
        char ar[] = myString.toCharArray();
        for(int i=0, j=4;i<ar.length;i++)
            {     
             t=(int)ar[i];
             
            if(t==255)
                 t=36;
             
             t-=j;
             str1+=(char)t ;
             j++;
             if(j==8)
             {
                 j=4;
             }
            
        }
       
	/*try
	{ 	   
	bw.write(str1.toCharArray()); 	   
	bw.writeTo(fw);
	fw.close();
	bw.close(); 	   
	} 	   
	catch (IOException e) 	   
	{ 	   
	e.printStackTrace(); 	   
	} */	   
	System.out.println(myString);
        System.out.println(str1);
        Revealed obj=new Revealed(str1);
        obj.setVisible(true);
        RevealFile ob1=new RevealFile();
        ob1.setVisible(false);
        
	}

	private void ReadLSB() 	   
	{ 	   
	int data=0,tempText[]=new int[8],p=0; 	   
	outer:for(int i=0;i<Width;i++) 	   
	{ 	   
	for(int j=0;j<Height;j++) 	   
	{
	 	   
	int change=0;
	for(int k=0;k<4;k++) 	   
	{
	if(k==0){change=1;}
	else if(k==1){change=256;}
	else if(k==2){change=65536;}
	else if(k==3){change = 16777216;}
	if((pixels[i][j] & change)==change)
	{
		tempText[p]=1;
	} 	   
	else
	{
		tempText[p]=0;
	} 	   
	p++; 
	
	if(p==8) 	   
	{
		data = 0;
		for(int q=0; q<=7; q++)
	    {
			
	        if(tempText[q]!=0)
	        {
	        data+=(tempText[q]*Math.pow(2,q));
	        }
	    }
		//System.out.println(data);
		int o = 36;
		if((char)data=='$')
		{

			System.out.println("Done");
			//System.out.println(myString);
			System.out.println(myString.length());
			break outer;
		}
		else{
			myString += (char) data;// convert int to String and storing in String object 	   
			//System.out.println(myString);
			//System.out.println(myString.length());
			p=0; 	   
			
			//tempText=0; 	   
		} }	   
	} 	   
	} 	   
	}
	
}
        /*public static void main(String args[]) throws IOException
        {
            Decode obj=new Decode("G://Images//new.png");
        }*/
}
