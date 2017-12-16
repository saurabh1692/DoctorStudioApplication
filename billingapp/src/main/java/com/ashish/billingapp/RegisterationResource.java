package com.ashish.billingapp;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("registration")
public class RegisterationResource {
	//Register a1=new Register();
	Database db=new Database();
	
	
	
	//--1-------OK-------------------- Method Retrive the all data from the database--------------------------------  
	
					@GET
					@Path("get")
					@Produces(MediaType.APPLICATION_JSON)
   
					public List<Register> getRegister(Register r)
					{
						System.out.println("Hiiii.............");
	   
						return  db.getRegister(r);
	   
						}
					
     
   //----2----OK----------------------------- Method get the particuler data by thruogh sub_id-------------------------------

   
						@GET
							@Path("details")
						@Produces(MediaType.APPLICATION_JSON)
   
						public Register  getdetails(@QueryParam("id") int subid)
						{
							return db.getdetails(subid);
						}
   
   
   
   
    
   
	//-3-OK---------------------------- Method Insert data in Database-------------------------------
	
   @GET
   @Path("create")
   @Consumes(MediaType.APPLICATION_JSON)
   //@Produces(MediaType.APPLICATION_XML)
   public String createuser(@QueryParam("user") String username,
	        @QueryParam("pswd") String password,
	        @QueryParam("shop") String shopname,@QueryParam("add") String address,
	        @QueryParam("mnum") String mobilenumber,@QueryParam("email") String emailid,
	        @QueryParam("gstn") String gstnumber,@QueryParam("accl") String accountlock,
	        @QueryParam("sdate") String substartdate,@QueryParam("edate") String subenddate) {
	   
	   System.out.println("sauarbh");
	   
	    Register r1=new Register();
	   
	    
	     r1.setUsername(username);
	     r1.setPassword(password);
	     r1.setShopname(shopname);
	     r1.setAddress(address);;
	     r1.setMobilenumber(mobilenumber);
	     r1.setEmailid(emailid);
	     r1.setGstnumber(gstnumber);
	     r1.setAccountlock(accountlock);
	     r1.setSubstartdate(substartdate);
	     r1.setSubenddate(subenddate);
	  return db.createuser(r1);
	  
   }
	   //db.createuser(username,pswd,shopname,address,mobilenumber,emailid,accountlock,
		//	   gstnumber,substartdate,subenddate);
	   //return "successfully";
	   
   //---4----ok Tested----------------login user-----------------------------
   
   
   
   @GET
   @Path("login")
   //@Consumes(MediaType.APPLICATION_XML)
   @Produces(MediaType.APPLICATION_JSON)
   public Login loginUser(@QueryParam("user") String username,@QueryParam("pswd") String password)
   {
   	//String user=username;
   	//String pswd=password;
   	int flag=0;
   	return db.loginUser(username,password,flag);    
   
   }
   
   //-----5-----ok tested---------------------------forgot password------------------------------------
	   @GET
	   @Path("forgotpass")
	   //@Consumes(MediaType.APPLICATION_XML)
	   @Produces(MediaType.APPLICATION_JSON)
	   public Forgot forgotPassword(@QueryParam("user") String username ) {
		  //Register r=new Register();
		  //r.setUsername(user);
		   return db.forgotPassword(username);
		   
	   }
	   
	   //---------6--- ok tested---------------Forgot Username-------------------------
	   @GET 	
	   @Path("forgotuser")
	   @Produces(MediaType.APPLICATION_JSON)
	   public Forgot forgotUsername(@QueryParam("email") String emailid) {
		   return db.forgotUsername(emailid);
	   }
	   
	   
	   //-----7----------under process---------------reset Password----------------------------
	   @GET
	   @Path("resetpass")
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)
	   
	   public String resetPass(@QueryParam("user") String username,@QueryParam("pass") String password) {
		   System.out.println("Helllllooooo11.....");
		   return db.resetPass(username,password); 
		   
	   }
	   
	   
	  //-8-OK    tested----------------------------------GST entry in database----------------------------------
	  
	   @GET
	   @Path("gstentry")
	   @Consumes(MediaType.APPLICATION_JSON)
	   public void  gstDetails(@QueryParam("gid") String gstid,@QueryParam("gdesc") String gstdesc,
			             @QueryParam("gper") double gstper,@QueryParam("gstart") String gststartdate, 
			             @QueryParam("gend") String gstenddate,@QueryParam("igst") double igst,
			             @QueryParam("cgst") double cgst,@QueryParam("sgst") double  sgst)
	   {
		   
		  /* GST g=new GST();
		   
		     g.setGstid(gstid);
		     g.setGstdesc(gstdesc);
		     g.setGstper(gstper);
		     g.setGststartdate(gststartdate);
		     g.setGstenddate(gstenddate);
		     g.setIgst(igst);
		     g.setCgst(cgst);
		     g.setSgst(sgst);
		   */
		     db.gstDetails();
		     System.out.println("hi......");
		   
	   }


	   //under process-up
	   /*--------9----ok tested----------------------Show Gstid and Gstdesc  Database---------------------------*/
	   
	   @GET
	   @Path("gstshow")
	   //@Consumes(MediaType.APPLICATION_XML)
	  @Produces(MediaType.APPLICATION_JSON)
	   public String getGSTdetails()
	   {
		   //String gdate=gstenddate;
		   System.out.println("Hey Saurabh attention ..Your api are used by another person what can happen i don't know...");
		   return db.showGstData();
		   
	   }
	   
	   
	   //*---------10-----ok tested--------------------insert Gst Database---------------------------OK
	   @GET
	   @Path("insertgst")
	   @Consumes(MediaType.APPLICATION_JSON)
	   //@Produces(MediaType.APPLICATION_XML)
	   public String insertGST(@QueryParam("id") String gstid,@QueryParam("desc") String gstdesc,
			                 @QueryParam("per") double gstper,@QueryParam("start") String gststartdate,
			                 @QueryParam("end") String gstenddate,@QueryParam("i") double igst,
			                 @QueryParam("c")  double cgst,@QueryParam("s") double sgst)
	   {
		   GstInsert gi=new GstInsert();
		   gi.setGstid(gstid);
		   gi.setGstdesc(gstdesc);
		   gi.setGstper(gstper);
		   gi.setGststartdate(gststartdate);
		   gi.setGstenddate(gstenddate);
		   gi.setIgst(igst);
		   gi.setSgst(sgst);
		   gi.setCgst(cgst);
		   
		   return db.insertGST(gi);
	   }
	   
	   
	   /*--11--OK Tested----------------------------------Update Gst Database---------------------------OK*/
	   @PUT
	   @Path("gstupdate")
	   @Consumes(MediaType.APPLICATION_JSON)

	   public String updateGST(@QueryParam("id") String gstid,@QueryParam("desc") String gstdesc,
			   					@QueryParam("per") double gstper,@QueryParam("start") String gststartdate,
			   					@QueryParam("end") String gstenddate,@QueryParam("i") double igst,
			   					@QueryParam("c") double cgst,@QueryParam("s") double sgst) {
		   
		   return db.updateGST(gstid,gstdesc,gstper,gststartdate,gstenddate,igst,cgst,sgst);
	   }
   


   
//---12-------OK Tested-----------------------conversion unit of Measure---------------------
		/*	@GET
			@Path("measure")
			@Consumes(MediaType.APPLICATION_JSON)
			public void conversionUnit(@QueryParam("id") int convid,@QueryParam("from") String fromconv,
										@QueryParam("to") String toconv,
										@QueryParam("multif") double multiplicationfactor ) {
				/*
				//UnitConversion uc=new UnitConversion();
				uc.setConvid(convid);
				uc.setFormconv(fromconv);
				uc.setToconv(toconv);
				uc.setMultiplicationfactor(multiplicationfactor);
				
				 db.conversionUnit();
			}
			*/
	   
			//--13------Under Process------------------convert to other---------------------------
			
			@GET
			@Path("convert")
			@Produces(MediaType.APPLICATION_JSON)
			public UnitConversion convert(@QueryParam("from") String fromconv) {
				return db.convert(fromconv);
			}
			
			//---14----ok tested ------------ Multiple Language---------------------------------------------
			@GET
			@Path("language")
			@Produces(MediaType.APPLICATION_JSON)
			public String multilang(@QueryParam("a1") String data) {
				return db.getlanguage(data);
			}
			
			//----------------------------------------------Insert languaage------------------
			@GET
			@Path("insert")
			@Consumes(MediaType.APPLICATION_JSON)
			public String insertlanguage(@QueryParam ("a1") String data) {
			return db.insertlanguage(data);
			}
			

			//-----------------------------------------------------------------
			@GET
			@Path("subuser")
			@Consumes(MediaType.APPLICATION_JSON)
			public String createsubUser(@QueryParam("user") String user,@QueryParam("uname") String username,
										@QueryParam("pass") String password,@QueryParam("accl") String accountlocked
										,@QueryParam("access") String access,@QueryParam("sdate") String substartdate,
										@QueryParam("edate") String subenddate)
			{
			return db.createsubUser(user, username, password, accountlocked, access, substartdate, subenddate);	
			}
			
			
			//----------------------------------------------------------------------
			
			@GET
			@Path("shrink")
			@Consumes(MediaType.APPLICATION_JSON)
			public void jsondata() {
				db.jsondata();
			}
}