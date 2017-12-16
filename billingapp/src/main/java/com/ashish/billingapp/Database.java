package com.ashish.billingapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Path;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




public class Database
{
	

//------------------------- Database Connection establishment ------------------	
	
	private static final boolean False = false;
	Connection con=null;
	       public Database()
	       {
	    	     
		         String url="jdbc:mysql://localhost:3306/billapp?useUnicode=true&characterEncoding=UTF-8";
		         String username="root";
		         String password="saurabh";
		         try
		           {
		        	 Class.forName("com.mysql.jdbc.Driver");
		        	 con=DriverManager.getConnection(url,username,password);
		       	   }		
		         catch(Exception e)
		           {
			         System.out.println("hello exeception......");
		           }
	}
	       
	       
//-----------------------------Retrive the all data from the database--------------------------------         
	         
	    
	public List<Register> getRegister(Register r)  
	    {  
			List<Register> r1=new ArrayList<>();
			String RegSql="select * from registration";
			
			
			try
			{
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(RegSql);
			
				while(rs.next())  
				{
					Register a =new Register();
					a.setSubid(rs.getInt(1));
					a.setUsername(rs.getString(2));
					a.setPassword(rs.getString(3));
					a.setShopname(rs.getString(4));
					a.setAddress(rs.getString(5));
					a.setMobilenumber(rs.getString(6));
					a.setEmailid(rs.getString(7));
					a.setGstnumber(rs.getString(8));
					a.setAccountlock(rs.getString(9));
					a.setSubstartdate(rs.getString(10));
					a.setSubenddate(rs.getString(11));
					r1.add(a);
				}	
				
			}
			
		catch(Exception e)  
		{
			System.out.println(e);
			//System.out.println("here exception");
		}
		
	return  r1;
	}
	
	
	
//-------------------------------------get the particuler data by thruogh sub_id-------------------------------
	
	public Register getdetails(int subid) {
		String RegSql="select * from Registration where subid="+subid;
		//List<Register> r1=new ArrayList<>();
		Register a =new Register();
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(RegSql);
			
			if(rs.next()) {
				
				//Register a =new Register();
				
				a.setSubid(rs.getInt(1));
				a.setUsername(rs.getString(2));
				a.setPassword(rs.getString(3));
				a.setShopname(rs.getString(4));
				a.setAddress(rs.getString(5));
				
				a.setMobilenumber(rs.getString(6));
				a.setEmailid(rs.getString(7));
				a.setGstnumber(rs.getString(8));
				a.setAccountlock(rs.getString(9));
				a.setSubstartdate(rs.getString(10));
				a.setSubenddate(rs.getString(11));
			//	r1.add(a);

				
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	return a;	
		
	}

	
//----------------------------Insert data in Database-------------------------------
   
 
	       
	public String createuser(Register a1) {
		
		//Register a1=new Register("hasan","hasan","Hasan textiels","Akaberpur",8787889,"hasan@gmail.com",true,
		       //  "bjp07","2017-10-19","2019-1-29");
		
		//Register a1=new Register(username,password,shopname,address,number,email,acc,gst,start,end);
		//insertdb(a1);
	//}
	//public void insertdb(Register a1) {
			int flag=0;
			String login="select * from registration";
	String RegSql="insert into registration(username,password,shopname,address,mobilenumber,emailid,gstnumber,"
		  		+ "accountlock,substartdate,subenddate) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
	String log="insert into logincontrol(username,password,accountlock,access,forchgpwd) values(?,?,?,?,?)";
		
	System.out.println("enter");
	
	try {
			     Statement st=con.createStatement();
			     ResultSet rs=st.executeQuery(login);
					   while(rs.next())
					    if(rs.getString(2).equals(a1.getUsername()))
					         flag=1;
					    if(flag==1)	return "uexist";
					    
					   
					 Statement st1=con.createStatement();
					 ResultSet rs1=st1.executeQuery(login);
					 while(rs1.next()) 
						 if(rs1.getString(6).equals(a1.getMobilenumber()))
							 flag=2;
						 if(flag==2) return "mexist";
						
						 
						 
					 
					 
					 Statement st2=con.createStatement();
					 ResultSet rs2=st2.executeQuery(login);
					 while(rs2.next()) 
						 if(rs2.getString(7).equals(a1.getEmailid()))
							 flag=2;
					 if(flag==2) return "emailexist";
					 
					 
					 
					 
					 Statement st3=con.createStatement();
					 ResultSet rs3=st3.executeQuery(login);
					 while(rs3.next())
						 if(rs3.getString(8).equals(a1.getGstnumber()))
							 flag=3;
					 if(flag==3) return "gst exist";
					 
		}
		
		

		catch(Exception e)
		{
			System.out.println(e);
		}
		
	    
			try {		    
			PreparedStatement pst=con.prepareStatement(RegSql);
			PreparedStatement pst1=con.prepareStatement(log);
			//Date date = new Date(0000-00-00);
				
		     	pst.setString(1, a1.getUsername());
				pst.setString(2, a1.getPassword());
				pst.setString(3, a1.getShopname());
				pst.setString(4, a1.getAddress());
				pst.setString(5,    a1.getMobilenumber());
				pst.setString(6, a1.getEmailid());
				pst.setString(7, a1.getGstnumber());
				pst.setString(8, a1.getAccountlock());
				pst.setString(9, a1.getSubstartdate());
				pst.setString(10, a1.getSubenddate());
				
				pst1.setString(1, a1.getUsername());
				pst1.setString(2, a1.getPassword());
				pst1.setString(3, a1.getAccountlock());
				pst1.setString(4, "15");
				pst1.setString(5, "No");
				
				pst.executeUpdate();
				pst1.executeUpdate();
		}	
		catch(Exception e) {
			System.out.println(e);
		}
		return "Successfully Registration";
	}


//-------------------------------------login user-----------------------------------------
public Login loginUser(String username,String password,int flag) {
	String sqllogin="select * from logincontrol";
	Login l=new Login();
	try {
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sqllogin);
		while(rs.next()) {
			if(rs.getString(1).equals(username)) {
				flag=1;
				if(rs.getString(2).equals(password)) {
					flag=2;
					l.setCheck("Success");
					//l.setAccess("Success");
					l.setAccountlock(rs.getString(3));
					l.setAccess(rs.getString(4));
					l.setForchgpwd(rs.getString(5));
					
									
				}
			}
		}
		
	}
			catch(Exception e)
			{
					System.out.println(e);
				}
			if(flag==0)
			{
				l.setCheck("uincorrect");
				l.setAccountlock(" ");
				l.setForchgpwd("null");
				l.setAccess("null");
				return l;
			}
	
			else if(flag==1)
			{
				l.setCheck("pincorrect");
				l.setAccountlock(" ");
				l.setForchgpwd("null");
				l.setAccess(" null");
				return l;
			}
		
	return l;
}
	//-------------------------forgot username------------------------
		public Forgot forgotUsername(String email) {
			
			Forgot fp=new Forgot();
			String sql="select * from registration";
			
			try {
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(sql);
				while(rs.next()) {
					if(rs.getString(7).equals(email)) {
						
						fp.setUsername(rs.getString(2));
						fp.setMobilenumber(rs.getString(6));
					}
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return fp;
		}
		//----------------------------Reset Password--------------------------
		public String resetPass(String username,String password) {
			int flag=0;
			System.out.println("Helllllooooo.....");
			String str="select username from registration";
			try {
			Statement pst=con.createStatement();
			ResultSet rs=pst.executeQuery(str);
			while(rs.next()) {
				if(rs.getString(1).equals(username)) {	
			
			String sql1="update registration set password=? where username=?";
			String sql2="update logincontrol set password=? ,forchgpwd=? where username=?";
				try {
				PreparedStatement st=con.prepareStatement(sql1);
				PreparedStatement st1=con.prepareStatement(sql2);
				st.setString(1,username);
				st.setString(2,password);
					//	System.out.println(user); 
				//System.out.println(pass);
				
				st1.setString(1,username);
				st1.setString(2,"No");
				st1.setString(3,password);
				
				st.executeUpdate();
				st1.executeUpdate();
			}
				catch(Exception e) {
					flag=1;
					System.out.println(e);			
				}
				if(flag==1)
					return "not Reset";
				return "reset";
				}
			}
			
			  /*----------CHECKING FOR SUB USER-----------*/ 
		    String suser="select childusername from subuserdetails";
		    try
			{
		    	//int flag2=0;
		    	
			Statement st1=con.createStatement();
		    ResultSet rs1=st1.executeQuery(suser);
		  
		    while(rs1.next())
		    	if(rs1.getString(1).equals(username))
		    	{
		    		int flag3=0;
		    		String subtable="update subuserdetails set childpassword=? where childusername=?";
		    		String sublogin="update logincontrol set password=? ,forchgpwd=? where username=?";
		    		
		    		
		    		try
		    		{
		    			//int flag2=0;
		    			
		    			//Statement st3=con.createStatement();
		    		PreparedStatement ps1 = con.prepareStatement(subtable);
		    		PreparedStatement fcp1 = con.prepareStatement(sublogin);
		    		
		    		ps1.setString(1, password);
		    		ps1.setString(2, username);
		    		
		    		fcp1.setString(1, password);
		    		fcp1.setString(2, "NO");
		    		fcp1.setString(3, username);
		    		
		    		ps1.executeUpdate();
		    		fcp1.executeUpdate();
		    	
		    	}
		        catch(Exception e)
		        {
		    	   flag3=1;
		    	   System.out.println(e);
		        }
		    		if(flag3==1)
		    			return "nreset";
		    		return "reset";
		    	 	
			    }
				}
			    catch(Exception e)
			    {
			    	//flag2=1;
			    	System.out.println(e);
			    }
			}
			    /*--------Main Exception-------*/
			catch(Exception e)
			{  // flag=1;
				System.out.println(e);		
}
		    return "error";
			}
//----------------------forgot password-----------------------------------------
public Forgot forgotPassword(String user) {
	
	Forgot fp=new Forgot();
	String sql="select * from Registration";
	//Register a=new Register();
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			
		while(rs.next()) {
				if(rs.getString(2).equals(user))
				//if(rs.getString(9).equals("0"))
				{	
					if(rs.getString(9).equals("False")) 
						{
						fp.setCheck("userYES");
						fp.setAccl("NO");
						fp.setMobilenumber(rs.getString(6));
						fp.setEmail(rs.getString(7));
						return fp;
						}
					fp.setCheck("userYES");
					fp.setAccl("Yes");
					fp.setMobilenumber("NULL");
					fp.setUsername("Null");
					return fp;
				}
					
			}
			
				
			//PreparedStatement st=con.prepareStatement(sql);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		fp.setCheck("userNO");
		fp.setAccl("no");
		fp.setMobilenumber("null");
		fp.setEmail("null");
		return fp;
}	


//----------------------------------insert Gst Database hard code---------------------------


  public void  gstDetails() {
	 
	   
	   Gst g1=new Gst("C1","5 % IGST",5,"2017-07-01","9999-12-31",5,0,0);
	   	getGST(g1);
	   	
	   	Gst g2=new Gst("C2","5 % CGST & SGST",5,"2017-07-01","9999-12-31",0,2.5,2.5);
	   	getGST(g2);		   
	   	
	   	Gst g3=new Gst("C3","12 % IGST",12,"2017-07-01","9999-12-31",12,0,0);
	   	getGST(g3);		   
	   	
	   	Gst g4=new Gst("C4","12 % CGST & SGST",12,"2017-07-01","9999-12-31",0,6,6);
	   	getGST(g4);		   
	   	
	   	Gst g5=new Gst("C5","18 % IGST",18,"2017-07-01","9999-12-31",18,0,0);
	   	getGST(g5);		   
	   	
	   	Gst g6=new Gst("C6","18 % CGST & SGST",18,"2017-07-01","9999-12-31",0,9,9);
	   	getGST(g6);	
	   	
	   	Gst g7=new Gst("C7","28 % IGST",28,"2017-07-01","9999-12-31",28,0,0);
	   	getGST(g7);
	   	
	   	Gst g8=new Gst("C8","28 % CGST & SGST",28,"2017-07-01","9999-12-31",0,14,14);
	   	getGST(g8);		   
	   
   }
   public void  getGST(Gst g) {
	   String gstSQL="insert into GST(gstid,gstdesc,gstper,gststartdate,gstenddate,igst,cgst,sgst)  values(?,?,?,?,?,?,?,?)";
	   try {
		   PreparedStatement st=con.prepareStatement(gstSQL);
		   st.setString(1,g.getGstid());
		   st.setString(2, g.getGstdesc());
		   st.setDouble(3, g.getGstper());
		   st.setString(4, g.getGststartdate());
		   st.setString(5, g.getGstenddate());
		   st.setDouble(6, g.getIgst());
		   st.setDouble(7, g.getCgst());
		   st.setDouble(8, g.getSgst());
		 st.executeUpdate();
   }
	   catch(Exception e) {
		   System.out.println(e);
	   }
	
   }
   
   //----------------------------------Get GSTid and GSTdesc from Gst Database---------------------------
   
   public String showGstData() {
	   //GstInsert g = new GstInsert();
	   String getGst="select  gstdesc  from gst";
	   //List<GstInsert> g1=new ArrayList<>();
	   JSONObject jo=new JSONObject();
	   JSONArray ja=new JSONArray();
	   try {
	   jo.put("gstdesc", ja);
	   }
	   catch(JSONException e)
	   {
		   System.out.println(e);
	   }
	   try {
		
		   Statement st=con.createStatement();
		   ResultSet rs=st.executeQuery(getGst);
		 while(rs.next()) {
			  
		   
			       ja.put(rs.getString(1));
			       //ja.put(rs.getString(2));
			 
			  
			  // g1.add(g);
			  
			   
		   
		   }
		   
	   }
	   catch(Exception e) {
		   System.out.println("error..............");
		  
		   System.out.println(e);
	   }
	  
	   return jo.toString();
   }
   
   
   
   /*----------------------------------insert Gst Database---------------------------*/
   public String insertGST(GstInsert gi) {
	   int flag=0;
	   String sql="insert into GST(gstid,gstdesc,gstper,gststartdate,gstenddate,igst,cgst,sgst) values"
	   		+ "(?,?,?,?,?,?,?,?)";
	  // GSTINSERT gi=new GSTINSERT();
	   try {
		   PreparedStatement st=con.prepareStatement(sql);
		   st.setString(1, gi.getGstid());
		   st.setString(2,gi.getGstdesc());
		   st.setDouble(3, gi.getGstper());
		   st.setString(4, gi.getGststartdate());
		   st.setString(5, gi.getGstenddate());
		   st.setDouble(6, gi.getIgst());
		   st.setDouble(7, gi.getCgst());
		   st.setDouble(8, gi.getSgst());
		   st.executeUpdate();
	   }
	   catch(Exception e) {
		   System.out.println(e);
		   flag=1;
	   }
	   if(flag==1) 
		   return "error";
	   
	   return "sucesfully insert";
   }
   
   
   /*----------------------------------Update Gst Database---------------------------*/
   
   public String updateGST(String gstid,String gstdesc,double gstper,String gststartdate,String gstenddate,double igst,
		   					double cgst,double sgst) {
	   		int flag=0;	
	   		String sql="update GST set gstdesc=?,gstper=?,gststartdate=?,gstenddate=?,igst=?,cgst=?,sgst=? "
	   				+ "where gstid=?";
	   		try {
	   			PreparedStatement st=con.prepareStatement(sql);
	   			
	   			st.setString(1,gstdesc);
	   			st.setDouble(2, gstper);
	   			st.setString(3, gststartdate);
	   			st.setString(4, gstenddate);
	   			st.setDouble(5, igst);
	   			st.setDouble(6, cgst);
	   			st.setDouble(7, sgst);
	   			st.setString(8, gstid);
	   			st.executeUpdate();
	   		}
	   		catch(Exception e) {
	   			System.out.println("Jai shree ram");
	   			flag=1;
	   			System.out.println(e);
	   		}
	   		if(flag==1)
	   			return "no update";
	   		return "Update";
   }



//---------------------------------Conversion unit of measur----------------------------
/*
public void conversionUnit() {
	
	
	//String st="insert into conversion values()"
			UnitConversion uc1=new UnitConversion(1,"KiloGram","Gram",1000);
			getconversion(uc1);
			
			UnitConversion uc2=new UnitConversion(2,"Dozen","Piece",12);
			getconversion(uc2);
			
			UnitConversion uc3=new UnitConversion(3,"Gram","KiloGram",0.001);
			getconversion(uc3);
			
			UnitConversion uc4=new UnitConversion(4,"KiloLiter","Liter",1000);
			getconversion(uc4);
			
			UnitConversion uc5=new UnitConversion(5,"Liter","KiloLiteer",0.001);
			getconversion(uc5);
			
			UnitConversion uc6=new UnitConversion(6,"Piece","Dozen",0.083);
			getconversion(uc6);
			
}

 public void getconversion(UnitConversion uc)
 {
	 String str ="insert into conversion(convid,fromconv,toconv,multiplicationfactor) "
	 		+ "values(?,?,?,?)";
	 try {
		 PreparedStatement st=con.prepareStatement(str);
		 st.setInt(1, uc.getConvid());
		 st.setString(3, uc.getFromconv());
		 st.setString(2,uc.getToconv());
		 st.setDouble(4, uc.getMultiplicationfactor());
		 st.executeUpdate();
		 }
	 catch(Exception e)
	 {
		 System.out.println(e);
	 }
 }
 */
//-------------------------------------unit conversion---------------------------
 public UnitConversion convert(String fromconv) {
	 String str="select multiplicationfactor,fromconv from conversion";
	 /*JSONObject jo=new JSONObject();
	 JSONArray ja=new JSONArray();
	 try {
		 jo.put("multiplicationfactor",ja);
	 }
	 catch(JSONException e) {
		 System.out.println(e);
	 }
	 */
	 UnitConversion uc=new UnitConversion();
	 try {
	 Statement st=con.createStatement();
	 ResultSet rs=st.executeQuery(str);
	 
		 while(rs.next()) { 
			 if(rs.getString(2).equals(fromconv)) {
			 uc.setMultiplicationfactor(rs.getDouble(1));
			 return uc;
		 
			 	}
	 }
	 }
	 catch(Exception e) {
		 System.out.println(e);
	 }
	//return "not match";
	 //return jo.toString();
	 uc.setToconv("not matched");
	 return uc;
 }
 
 
 
 //---------------------------------Language------------------------------
 
 
 public String getlanguage(String a1) {
	 
	 String sql="select *from hindi";
	 
	 JSONObject  jo=new JSONObject();
	 JSONArray ja=new JSONArray();
	 try {
		 jo.put("data",ja);
	 }
	 catch(JSONException e) {
		 System.out.println(e);
	 }
	 try {
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery(sql);
		 
		 while(rs.next()) {
			 ja.put(rs.getString(1));
			 
		 }
	 }
	 catch(Exception e) {
		 System.out.println(e);
	 }
	 return jo.toString();
	 /*
	 try {
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery(sql);
		 while(rs.next()) {
			 if(rs.getString(1).equals(a1)) {
				 return a1;
			 }
		 }
	 }
	 catch(Exception e) {
		 System.out.println(e);
	 }
	 */
	 //return "not check";
	 
 }

	
 

 //-----------------------------------------insert multiple language----------------------------------------------------
 
 
 public String insertlanguage(String insert) {
	 String sql="insert into hindi(data) values(?)";
	 try {
		 PreparedStatement st =con.prepareStatement(sql);
		 st.setString(1,insert);
		 st.executeUpdate();
	 }
	 catch(Exception e) {
		 System.out.println(e);
	 }
	 return "data insert in database";
 }
 
 
 
 //------------------------------Sub User Registration----------------------------
  
 public String createsubUser(String user,String username,String password,String accountlocked,
		 					String access, String substartdate,String subenddate) {
	    int subid=0,flag=0;
	 	String reg="select * from registration where userName="+user;
	 	String subuser="select childusername from subuserdetails";
	 	String su="insert into subuserdetails values(?,?,?,?,?,?)";
	 	String login="insert into logincontrol(username,password,accountlock,access,forchgpwd) "
	 			+ "values(?,?,?,?,?)";
	 	Register r=new Register();
	 	r.setUsername(username);
	 	r.setPassword(password);
	 	r.setSubstartdate(substartdate);
	 	r.setSubenddate(subenddate);
	 	try {
	 		Statement st=con.createStatement();
	 		ResultSet rs=st.executeQuery(subuser);
	 		while(rs.next()) 
	 			if(rs.getString(1).equals(r.getUsername()))
	 					return "subusername is exist";
	 		
	 	}
	 		catch(Exception e)
			{   flag=1;
				System.out.println(e);
			}
	 	if(flag==1)
	 		return "flag 1 error";
	 		try {
	 			System.out.println("helloooo....");
	 			Statement st1=con.createStatement();
	 			ResultSet rs1=st1.executeQuery(reg);
	 			rs1.next();
	 			subid=rs1.getInt(1);
	 			System.out.println("hello.............."+subid);
	 			
	 		}
	 			catch(Exception e) {
	 				flag=3;
	 				System.out.println(e);
	 			}
	 		if(flag==3)
		 		return "flag 3 error..";
	 		
	 				try {
	 					PreparedStatement pst=con.prepareStatement(su);
	 					PreparedStatement pst1=con.prepareStatement(login);
	 					
	 					pst.setInt(1, subid);
	 					pst.setString(2,r.getUsername());
	 					pst.setString(3,r.getPassword());
	 					pst.setString(4,"false");
	 					pst.setString(5,r.getSubstartdate());
	 					pst.setString(6,r.getSubenddate());
	 					
	 					pst1.setString(1,r.getUsername());
	 					pst1.setString(2,r.getPassword());
	 					pst1.setString(3,"false");
	 					pst1.setString(4,access);
	 					pst1.setString(5, "yes");
	 					pst.executeUpdate();
	 					pst1.executeUpdate();
	 				}
	 				catch(Exception e) {
	 					flag=4;
	 					System.out.println(e);
	 				}
	 				if(flag==4) {
	 				return "its Error";
	 				}
	 			                                              
	 		
 
 return "Success";  
} 
 //----------------------------------------------------------------
 
// ------------UP---------ADD ITEM IN TABLE-----------------------------------*/	
	
	public String addItem(int subid,String itemid, String itemname, String itemprice,
						  String measurement,String itemcategory,String gstcategory, 
						  String startdate, String enddate) 
	{
		int flag=0;
		/*String s5="'"+itemid+"'";
		
		    /*--------------Getting subId from registration-----------*/
		/*String regis="select subId from registration where userName="+s5;
		int id=0, flag=0;
		try
		{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(regis); 
			rs.next();
		    id=rs.getInt(1);
		}
		catch(Exception e)
		{   flag=1;
			System.out.println(e);
		}
		if(flag==1)
			return "error1";
			
			
		*/
		
		    /* -----check Item Name and Unit in item table----*/
		
		String itemunit="select  itemName, measurement from itemmain";
		
			try
			{
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(itemunit);
				
				while(rs.next())
				{
					if(rs.getString(1).equals(itemname))
							if(rs.getString(2).equals(measurement))
								return "iexist";
				}
			}
			catch(Exception e)
			{
				flag=1;
				System.out.println(e);
			}
			if(flag==1)
		    return "error1";
		
		
		
		
		/*-------------inserting item into item table---------*/
		
			String add="insert into itemmain values(?,?,?,?,?,?,?,?,?,?,?)";
		
			try
			{
				PreparedStatement st1=con.prepareStatement(add);
		
		
				st1.setInt(1, subid);
				st1.setString(2, itemid);
				st1.setString(3, itemname);
				st1.setString(4, itemprice);
				st1.setString(5, measurement);
				st1.setString(6, itemcategory);
				st1.setString(7, gstcategory);
				st1.setString(8, startdate);
				st1.setString(9, enddate);
				st1.setInt(10, 0);
    
				st1.executeUpdate(); 
		
			}
			catch(Exception e)
			{
				flag=2;
				System.out.println(e);
			}
			if(flag==2)
				return "error2";
		return "success";
	}
	

	
/*13-----------OK---------GET ITEM ID-------------------------------------------*/
	
	public String getItem(String itemid)
	{
		int x=1,i=1,flag=0,id=0;
		
		String s1=itemid;
		String s2="I";
		 String s3=s1.concat(s2);
		 String s4=s3+1;
		String item="select itemId from itemmain";
		
		
		JSONObject jo = new JSONObject();
		
		
		
	    /*--------------Getting subId from registration-----------*/
		    String s6="'"+itemid+"'";
			String regis="select subId from registration where userName="+s6;
	
			try
			{
				Statement st1=con.createStatement();
				ResultSet rs1=st1.executeQuery(regis); 
				rs1.next();
				id=rs1.getInt(1);
				jo.put("subid",id);
			}
			catch(Exception e)
			{  	flag=1;
				System.out.println(e);
			}
			if(flag==1)
				return "error1";
		
		
		
		
		
		
		
		try
		{
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(item); 
			
			
				while(rs.next())
				{	
						s4=s3+i;
						
					if(s4.equals(rs.getString(1)))
					{
						i++;
						flag=1;
						x=2;
					}
			
				}
				 
				if(flag==1)
				{
					String s5=s3+i;
					System.out.println(s5);
					
					jo.put("itemid",s5);
					return jo.toString();
					
				}
				else 
				{
					jo.put("itemid",s4);
					return jo.toString();
				}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.print("s");
		}
		 
		 
		 return  "error2";
	}
	
	
	
 
 
 
 
 //----------------------------------------------------------------
 public void jsondata() {
	 String str= "{\"Number\":[101,102,103,104]}";
	 try {
		 String st1="insert into test values(?)" ;
	 
	 JSONObject jo=new JSONObject(str);
	 JSONArray arr;
	 arr=jo.getJSONArray("Number");
	 for(int i=0;i<arr.length();i++) {
		 //Statement st=con.createStatement();
		 //Resultset rs=st.executeQuery(st1);
		 PreparedStatement st=con.prepareStatement(st1);
		 st.setString(1,arr.getString(i));
		 st.executeUpdate();
		 System.out.println(arr.getString(i));
	 }
	 }
	 catch(Exception e) {
		 System.out.println(e);
	 }
 }
	 
	 	
	 		 		
 }
 
 
 

 
