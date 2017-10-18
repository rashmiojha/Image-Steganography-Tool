package package1;
import java.awt.Graphics2D; 	   
import java.awt.image.BufferedImage; 	   
import java.io.*; 	   
import java.net.Socket;
import java.net.UnknownHostException;
import javax.imageio.*;

public class Encode
{
  private Socket client;
   BufferedReader in;
   PrintWriter out;

private BufferedImage image=null,new_image=null; 	   
private int pixels[][]; 	   
private char Data[]; 	   
private int Width,Height; 	   
private int Binary[]=new int[8]; 	   
private int Length=0; 	   
private String name1="";
File fileName1;
public Encode(String name,String str,String strnew)
{
    name1=name;
        try {
                  client=new Socket("localhost",2013);
                  in=new BufferedReader(new InputStreamReader(client.getInputStream()));
                  out=new PrintWriter(client.getOutputStream(),true);

      //out.println("encode");            
      File fileName=new File(str); //original image
      fileName1=new File(strnew); //new image
      try	   
      { 	   
      new_image= ImageIO.read(fileName); 	   
      image=new BufferedImage(new_image.getWidth(), new_image.getHeight(), BufferedImage.TYPE_4BYTE_ABGR); 	   
      Graphics2D graphics = image.createGraphics(); 	   
      graphics.drawRenderedImage(new_image, null); 	   
      graphics.dispose(); 	   
      }
      catch (Exception e) 	   
      { 	   
      e.printStackTrace(); 	   
      } 	   
      pixels= new int[new_image.getWidth()][new_image.getHeight()]; 	   
                 
      Width=new_image.getWidth(); 	   
      Height=new_image.getHeight();
      for(int i=0;i<Width;i++)
      { 	   
      for(int j=0;j<Height;j++)
      {
      pixels[i][j]=new_image.getRGB(i, j); 	   
      } 	   
      }

      //String name= "Morning" + "End";
                      
      name+="$E" ; 
      System.out.println(name.length());
      Length=name.length();
      Data=name.toCharArray();
      WriteLSB(); 	
      //out.println("png");
      try   
      { 	   
      ImageIO.write(image, "png", fileName1); 	   
      } 	   
      catch (IOException e) 	   
      { 	   
      e.printStackTrace(); 	   
      }
      System.out.println("Encoding Completed"); 	   
      //RetreiveData b = new RetreiveData(strnew);
        } catch (UnknownHostException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
} 


private void WriteLSB() throws IOException
{ 	   
        try {
            in=new BufferedReader(new InputStreamReader(client.getInputStream()));
            out=new PrintWriter(client.getOutputStream(),true);
        } catch (IOException ex) {
            System.out.println(ex);
        }
                  
int x=0,p=0,i,j=0; 	   
Bin((int) Data[x]); 	   
x++; 	   
for(i=0;(i<Width && x<Data.length);i++) 	   
{ 	 //  Bin((int) Data[x]); 	   
//x++; 	   
//for(i=0;(i<Width && x<Data.length);i++) 	   
	   
for(j=0;( j<Height && x<Data.length);j++) 	   
{ 	   
int change=0; 	   
for(int k=0;k<4;k++)
{ 	   
if(k==0){change=1;} 	   
else if(k==1){change=256;}
else if(k==2){change=65536;}
else if(k==3){change = 16777216;}
if(Binary[p]==0){pixels[i][j]= pixels[i][j] & ~change;}// ~1 ki all bits 1 hoti ha except LSB
else if(Binary[p]==1){pixels[i][j]= pixels[i][j] | change;} // only LSB ko 1 krna ha 	   
p++; 	   
if(p==8){
	p=0;
	Bin((int) Data[x]); 	   
	x++; 	   
	} 	   
  } 	   
} 	   
}
/*if(x!=Data.length)
{
    
    out.println("error");
    out.println(fileName1.getName());
    String ret=in.readLine();
    if(ret.equals("done"))
    {
        System.out.println("choose a larger image.");
        SelectImage ob=new SelectImage(name1);
        ob.setVisible(true);
    }
    else if(ret.equals("not done"))
    {
        System.out.println("not done");
    }
}
//System.out.println("hey!!");
//if(x!=Data.length)
else
{*/
out.println("encode");
out.println(String.valueOf(Width));
 out.println(String.valueOf(Height));
  //System.out.println("hey!!");  
for(i=0;i<Width;i++) 	   
{ 	   
for(int h=0;h<Height;h++) 	   
{ 	   
image.setRGB(i, h,pixels[i][h]); 
            
            out.println(String.valueOf(pixels[i][h]));
            
  
            

} 	   
} 	   
//                    out.println("Image Complete");
}
//}


private void Bin(int temp)
{ 	   
Binary=null; 	   
Binary= new int[8]; 	   
for(int i=0;i<=7;i++)// cuz character is of 1 byte 	   
{ 	   
Binary[i]=temp%2; 	   
temp/=2; 	   
}
//for(int i=15;i>=0;i--)
//System.out.print(Binary[i]);//
//System.out.println(); 
} 	   
}



