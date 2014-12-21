package controllers;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import com.avaje.ebean.ExpressionList;

import models.People;
import play.*;
import play.mvc.*;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.data.*;
import views.html.*;
import static play.data.Form.*;
import java.util.Date;
public class Application extends Controller {
 
	static List<People> person ; 
	public static Form<People> peoples = Form.form(People.class);
    public static Result index() {
       /*
return ok(views.html.index.render());*/
/* return ok(index.render("Your new application is ready."));
*/
  
/*Result htmlResult = ok("<h1>Hello World!</h1>").as("text/html");
        return htmlResult;*/
    	 return redirect(routes.Application.register());
    }
    
   /* public static Result login(){
    	
    	return ok(login.render(form(Login.class)));
    }*/
    public static Result searchTicket(){
    	
    	return ok(trainticket.render());
    }
    public static Result create(){
    	
    	return ok(register.render(peoples));
    }
    
    public static Result register() throws NoSuchAlgorithmException, IOException{
    	Form<People> filledForm = peoples.bindFromRequest();
    	   	

  /*	
   * ATTACH IMAGE 
   *    MultipartFormData body = request().body().asMultipartFormData();
  	   FilePart picture = body.getFile("picture");
  	  
  	  
  	    String fileName = picture.getFilename();
  	    String contentType = picture.getContentType(); 
  	    File file = picture.getFile();
    	
  	  ByteArrayOutputStream ous = null;
      InputStream ios = null;
      try {
          byte[] buffer = new byte[4096];
          ous = new ByteArrayOutputStream();
          ios = new FileInputStream(file);
          int read = 0;
          while ( (read = ios.read(buffer)) != -1 ) {
              ous.write(buffer, 0, read);
          }
      } finally { 
          try {
               if ( ous != null ) 
                   ous.close();
          } catch ( IOException e) {
          }

          try {
               if ( ios != null ) 
                    ios.close();
          } catch ( IOException e) {
          }
      }
  	    
      byte array[]=ous.toByteArray();*/
  	  /*  return ok("File uploaded name:"+fileName);
  	  } else {
  	    flash("error", "Missing file");
  	    	return redirect(routes.Application.index());    
  	  }*/
    	
    	
    	List<People> p = People.find.where().like("email",filledForm.get().email).findList();
    	if(!p.isEmpty())
    		return badRequest("Email already registered...");
    	People ppl=filledForm.get();
    	// Hashing Password 
    	String passToMail=ppl.password;
    	String emailtoMail=ppl.email;
    	ppl.password=ToMD5.convertToMD5(ppl.password);
    	
    	ppl.registerdate=new Date();   // Registration Date 
    	People.create(ppl);
    	
    	
    /*	SendMailBitsService.sendingMailPlay("  Hello, "+ppl.name+",<br> Please log in using these email and Password ." +
    			" <br> <br> Your Email: "+emailtoMail+ 
    			"<br> <br> Your Password:"+passToMail,emailtoMail,"mdashfak.chowdhury@bracits.com",fileName,array);
    	*/
    //	return ok("Successfully Registered and sent a mail consisting your credentials, Please check your email !");
    	return ok(views.html.completeregis.render());
    	
    }

    public static Result loginForm(){
    	return ok(loginform.render());
    	//return TODO;
    }

    public static Result loginWithEmailPass() throws NoSuchAlgorithmException, UnsupportedEncodingException{
    	Form<People> f = peoples.bindFromRequest();
    	
    	
    	/*if(f.hasErrors()) {
    	    //Just for this test task, should have another error handling..
    	    return ok("@Required annotation kicked in..");
    	}*/
    	
    	f.get().password=ToMD5.convertToMD5(f.get().password);
    	
    	List<People> p =People.find.where().like("email",f.get().email).findList();
    	
    	
    	if(checkUser(f.get().email,f.get().password))
    		return ok(views.html.userprofile.render(p));
    		
    	else
    		return ok("Invalid");
    	//return TODO;
    }
    public static Result showAllPeople(){
    	
    	List<People> ppl = People.all();
    	
    	
    	return ok(views.html.list.render(ppl));
    }
    public static Result reorder(String orderby){
    	
    	//List<People> ppl = People.sort(fdt,tdt);
    	List<People> ppl = People.sort(orderby);
    	
    	return ok(views.html.list.render(ppl));
    }
    public static boolean checkUser(String email, String pass){
    	
    	//person = People.find.where().eq("email",email).findList();
    	People p=People.find.where().eq("email",email).eq("password",pass).findUnique();
    	//List<People> person1 = People.find.where().like("password",pass).findList();
    	if(p==null)
    		return false;
    	else
    		return true;
    }
public static Result process(){

	Result htmlResult = ok("<h1>Hello World!</h1>").as("text/html");
        return htmlResult;
}

public static Result signup(){
	return ok(views.html.index.render());
}

public static Result filterbydate(){
	final Map<String,String[]> data =request().body().asFormUrlEncoded(); 
	
	String from = data.get("from")[0];
	String to=data.get("to")[0];
	
	
	
	return ok(views.html.list.render(People.findByDate(from,to)));
}

public static Result authenticate() {
    Form<Login> loginForm = form(Login.class).bindFromRequest();
    if(loginForm.get().email=="")
    	return ok("Email cannot be NULL");
    if(People.find.fetch(loginForm.get().email)!=null)
    	return ok("Email Already Exist");
    
    flash("success", "Computer has been deleted");
 //   return GO_HOME;
    return ok(loginForm.get().email);
}

/*public static Result upload() {
	//  MultipartFormData body = request().body().asMultipartFormData();
	  
	  MultipartFormData body = request().body().asMultipartFormData();
	  FilePart picture = body.getFile("picture");
	  
//	  FilePart picture = body.getFile("picture");
	  if (picture != null) {
	    String fileName = picture.getFilename();
	    String contentType = picture.getContentType(); 
	    File file = picture.getFile();
	    return ok("File uploaded name:"+fileName);
	  } else {
	    flash("error", "Missing file");
	    return redirect(routes.Application.index());    
	  }
}*/

public static Result profile(int page, String sortBy, String order, String filter) {
   /* return ok(
        profile.render(
            People.page(page, 10, sortBy, order, filter),
            sortBy, order, filter
        )
    );*/
	Result htmlResult = ok("<h1>Hello World!</h1>").as("text/html");
    return htmlResult;
}

public static class Login {

    public String email;
    public String password;

}
  
}
