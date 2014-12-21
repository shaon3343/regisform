package controllers;
import java.rmi.RemoteException;


import org.tempuri.ServiceSoapProxy;
public class SendMailBitsService
{
   public static void main(String [] args)
   {    
      
   }
   public static void sendingMailPlay(String body, String to , String From,String filename,byte[] array) throws RemoteException{
	   	ServiceSoapProxy ssp = new ServiceSoapProxy();
	   	ssp.sendMail(From,to,null, null,"Account Created",body,array,filename,null, null, null, null);
	   
   }
}