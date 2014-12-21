package org.tempuri;

public class ServiceSoapProxy implements org.tempuri.ServiceSoap {
  private String _endpoint = null;
  private org.tempuri.ServiceSoap serviceSoap = null;
  
  public ServiceSoapProxy() {
    _initServiceSoapProxy();
  }
  
  public ServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceSoapProxy();
  }
  
  private void _initServiceSoapProxy() {
    try {
      serviceSoap = (new org.tempuri.ServiceLocator()).getServiceSoap();
      if (serviceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)serviceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)serviceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (serviceSoap != null)
      ((javax.xml.rpc.Stub)serviceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.ServiceSoap getServiceSoap() {
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap;
  }
  
  public java.lang.String sendMail(java.lang.String strSendFrom, java.lang.String strSendTo, java.lang.String strCC, java.lang.String strBcc, java.lang.String strSubject, java.lang.String mailBody, byte[] docbinaryarrayFile1, java.lang.String strdocName1, byte[] docbinaryarrayFile2, java.lang.String strdocName2, byte[] docbinaryarrayFile3, java.lang.String strdocName3) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.sendMail(strSendFrom, strSendTo, strCC, strBcc, strSubject, mailBody, docbinaryarrayFile1, strdocName1, docbinaryarrayFile2, strdocName2, docbinaryarrayFile3, strdocName3);
  }
  
  public java.lang.String sendMailwithImage(java.lang.String strSendFrom, java.lang.String strSendTo, java.lang.String strCC, java.lang.String strBcc, java.lang.String strSubject, java.lang.String mailBody, byte[] docbinaryarrayFile1, java.lang.String strdocName1, byte[] docbinaryarrayFile2, java.lang.String strdocName2, byte[] docbinaryarrayFile3, java.lang.String strdocName3) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.sendMailwithImage(strSendFrom, strSendTo, strCC, strBcc, strSubject, mailBody, docbinaryarrayFile1, strdocName1, docbinaryarrayFile2, strdocName2, docbinaryarrayFile3, strdocName3);
  }
  
  
}