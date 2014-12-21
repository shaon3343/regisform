package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

/**
 * Computer entity managed by Ebean
 */
@Entity
@Table (name="peoples")
public class People extends Model {
	
	
   
	@Id
    public Long id;
	
	public String name;
	public String occupation;
	public String address;
	public String mobile;
	
	
	public Date registerdate;
   
    public String email;
    
    
    public String password;
    
    /*@Formats.DateTime(pattern="yyyy-MM-dd")
    public Date introduced;
    
    @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date discontinued;
*/    
   /* @ManyToOne
    public Company company;*/
    
    /**
     * Generic query helper for entity Computer with id Long
     */
    
   
    
    public static Finder<String,People> find = new Finder<String,People>(String.class, People.class); 
  
    public static Finder<Date,People> findDate = new Finder<Date,People>(Date.class, People.class);
    
    public static List<People> findByDate(String from , String to){
    	
    	
    	from=from+" 00:00:00.000";
    	to+=" 23:59:59.000";

    //	System.out.println(from+" ++++++++++__________========="+to);
    	
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	
    	Date From=new Date();
    	Date To=new Date();
    	
		try {
			From = formatter.parse(from);
			To = formatter.parse(to);
			
		//	System.out.println(formatter.format(From));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  //  	System.out.println(From.toString());
    //	System.out.println(from+"========++++++-----------=======  "+to);
    	
    	List<People> p=findDate.where().between("registerdate",From,To).findList();
    //	System.out.println(p.isEmpty());
    	return  p;
    }
    
  /*  public static List<People> dataBetweenDate(String frmdt, String todt,String vendorID){
    	return find.where().between("DE13",fdt, tdt).eq("tranSource",vendorID).findList();

    	}*/
    
    
    public static List<People> all() {
  	  return find.all();
  	}
   /* public static List<People> byEmailPass(String email,String pass){
    	return find.where().ilike("email","%"+email+"%").findList();
    	
    }*/
    public static void create(People people){
    	people.save();
    	
    }
    
    
    public static List<People> filter(String email) {

    	return find.where().eq("email", email).findList();

    	}
    public static List<People> sort(String orderby) {
    	List<People> list = new ArrayList<People>();
    	
    	list=People.find.orderBy(orderby+" asc").findList();
    	
    	System.out.println(list.isEmpty());
    	return list;
    	
    }
    
    

   /* public static List<People> sort(String fdt,String tdt){
    	
    	
    	
    	
    	List<People> p =People.find.orderBy("name").findList();
    	return p;
    	
    //	return find.where().between("PEOPLES",fdt, tdt).findList();

    }*/
    /**
     * Return a page of People
     *
     * @param page Page to display
     * @param pageSize Number of computers per page
     * @param sortBy Computer property used for sorting
     * @param order Sort order (either or asc or desc)
     * @param filter Filter applied on the name column
     */
  /*  public static Page<People> page(int page, int pageSize, String sortBy, String order, String filter) {
        return 
            find.where()
                .ilike("email", "%" + filter + "%")
                .orderBy(sortBy + " " + order)
                .fetch("email")
                .findPagingList(pageSize)
                .getPage(page);
    }*/
    
}

