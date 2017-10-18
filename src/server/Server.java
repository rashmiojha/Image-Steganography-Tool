package server;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Server extends javax.swing.JFrame implements Runnable {
    ServerSocket server1;
    Socket client;
    BufferedReader in;
    PrintWriter out;
    Connection con;
    Statement stmt;    
    ResultSet rs;
    Thread t;
static String s14="";
static String filepath="F:/Steganography/";

    public Server() throws IOException, ClassNotFoundException {
        initComponents();
                t=new Thread(this);
t.start();

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Running server...");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(280, 20, 200, 40);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 70, 700, 390);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/package1/Pictures/Grey-website-background.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 760, 470);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
                Thread t = new Thread();
t.start();
        //Set the Nimbus look and feel
try
        {
for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
if ("Nimbus".equals(info.getName()))
                {
javax.swing.UIManager.setLookAndFeel(info.getClassName());
break;
                }
            }
        }
catch (ClassNotFoundException ex)
        {java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
catch (InstantiationException ex)
        {java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
catch (IllegalAccessException ex)
        {java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
catch (javax.swing.UnsupportedLookAndFeelException ex)
        {java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try
                {                    
new Server().setVisible(true);
                }
catch (IOException ex) {
Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
catch (ClassNotFoundException ex)
                {
Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
    public void run() {
try
    {
        server1 =new ServerSocket(2013);
do
        {
jTextArea1.append("Waiting for client");
client=server1.accept();
in=new BufferedReader(new InputStreamReader(client.getInputStream()));
out=new PrintWriter(client.getOutputStream(),true);
            String str = in.readLine();     
switch(str)
            {
case "login":
try
                {
jTextArea1.append(String.valueOf(client));
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con= DriverManager.getConnection("jdbc:odbc:projectdb1");
stmt=con.createStatement();                            
                    String str1=in.readLine(); //password
                    String str2=in.readLine(); //username                    
rs=stmt.executeQuery("select`Username`,`Password` from `Users`");
boolean flag=false;               
while(rs.next())          
                    {                
                       String s1=rs.getString("Username"), s2=rs.getString("Password");
if(s1.equals(str2))
                       {                   
if(s2.equals(str1))
                        {                   
flag=true;
out.println("login success");
break;
                        }         
                       } 
                    }               
if(!flag)
out.println("login failed");       
rs.close();
stmt.close();
con.close();      
                }       
catch(Exception e)
                {
jTextArea1.append(String.valueOf(e));
                }
break;//end of case "login"

case "register":                
jTextArea1.append(String.valueOf(client));
                String s1=in.readLine();
                String s2=in.readLine();
                String s3=in.readLine();
                String s4=in.readLine();
                String s5=in.readLine();
                String s6=in.readLine();
                String s7=in.readLine();
                String s8=in.readLine();
                String s9=in.readLine();
                String s10=in.readLine();
                String s11=in.readLine();
try
                {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con= DriverManager.getConnection("jdbc:odbc:projectdb1");
stmt=con.createStatement();        
                    stmt.executeUpdate("insert into `Users`(`Names`,`Username`,`Password`,`dd`,`mm`,`yy`,`Nationality`,`MobileNo`,`Address`,`Gender`,`emailID`) values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"','"+s10+"','"+s11+"')");
                } 
catch (SQLException ex) 
                {
out.println("error");
jTextArea1.append(String.valueOf(ex));
break;
                }
out.println("complete");
break;  //end of case "register"

case "hide":     
jTextArea1.append(String.valueOf(client));
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                s14=in.readLine(); //name of image
                String path=filepath+s14+".png";            
                String s15=in.readLine(); //password
try
                {
con= DriverManager.getConnection("jdbc:odbc:projectdb1");
stmt=con.createStatement();    
stmt.executeUpdate("insert into`Hide`(`Filename`,`Password`) values('"+path+"','"+s15+"')");                     
                }
catch (SQLException ex)
                {
jTextArea1.append(String.valueOf(ex));
out.println("error");
break;
                }
out.println("success");
break; //end of case hide

case "encode":
                String s160=in.readLine(); //width
                String s170=in.readLine(); //height
                String s="";
int W=Integer.parseInt(s160), H=Integer.parseInt(s170);   
int pix[][]=new int[W][H];
                BufferedImage im=new BufferedImage(W,H, BufferedImage.TYPE_4BYTE_ABGR); 
for(int i=0;i<W;i++) 	
                { 	
for(int h=0;h<H;h++) 	
                    {
                        s=in.readLine();
pix[i][h]=Integer.parseInt(s);
im.setRGB(i, h,pix[i][h]); 
                    }
                 }
                 String path1=filepath+s14+".png";
                 File f11=new File(path1);
ImageIO.write(im, "png",f11); 	
break;  //end of case encode

case "reveal":
jTextArea1.append(String.valueOf(client));       
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
try
                {
con= DriverManager.getConnection("jdbc:odbc:projectdb1");
stmt=con.createStatement();
                    String s16=in.readLine();  //password
rs=stmt.executeQuery("select`Filename`,`Password` from `Hide`");
boolean flag=false;
                    BufferedImage im2=null;
int pixels[][];
int Width, Height;
while(rs.next())          
                    {               
                        String str1=rs.getString("Filename"), str2=rs.getString("Password");
if(s16.equals(str2))
                        {
flag=true;
                            File fi=new File(str1);
try
                            { 
                                im2= ImageIO.read(fi); 
                            } 	
catch (IOException e) 	
                            { 		
jTextArea1.append(String.valueOf(e));     
                            }
pixels= new int[im2.getWidth()][im2.getHeight()]; 	
                            Width=im2.getWidth(); 	
                            Height=im2.getHeight(); 
out.println(String.valueOf(Width));
out.println(String.valueOf(Height));
for(int i=0;i<Width;i++) 	
                            { 	
for(int j=0;j<Height;j++) 	
                            { 	
pixels[i][j]=im2.getRGB(i, j);
out.println(String.valueOf(pixels[i][j]));
                            } 	
                            } 	
out.println("success");
break;
                        }
                    }
if(!(flag))
out.println("failed");
                }
catch (SQLException ex)
                {
jTextArea1.append(String.valueOf(ex));
                }
break; //end of case reveal

default:
jTextArea1.append("Wrong input");
        }
}while(true);
    }
catch(Exception e)
{}
}

}
