package baylinux.sagliktest;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;







public class Dao {
	private static String Host="localhost";
	private static String MySqlPort="3306";
	private static String MariaDBPort="3306";
	private static String PostgreSqlPort="5432";
	private static String Port="";
	private static String PrefSchema="testmanagement";
	
	private static String MySqlClassName="com.mysql.cj.jdbc.Driver";
	private static String MySqlEmptyUrl="jdbc:mysql://"+Host+":"+Port+"/";
	private static String MySqlUrl="jdbc:mysql://"+Host+":"+Port+"/"+PrefSchema;
	private static String MySqlUname="root";
	private static String MySqlPass= "myPass";
	
	private static String MariaDBClassName="org.mariadb.jdbc.Driver";
	private static String MariaDBEmptyUrl="jdbc:mariadb://"+Host+":"+Port+"/";
	private static String MariaDBUrl="jdbc:mariadb://"+Host+":"+Port+"/"+PrefSchema;
	private static String MariaDBUname="root";
	private static String MariaDBPass= "myPass";
	
	private static String SqliteDBClassName="org.sqlite.JDBC";
	private static String SqliteDBEmptyUrl="jdbc:sqlite";
	private static String SqliteDBUrl="jdbc:sqlite:"+PrefSchema+".sqlite";
	
	private static String PostgreClassName="org.postgresql.Driver";
	private static String PostgreEmptyUrl="jdbc:postgresql://"+Host+":"+Port+"/";
	private static String PostgreUrl=
	"jdbc:postgresql://"+Host+":"+Port+"/postgres?currentSchema="+PrefSchema;
	private static String PostgreUname="postgres";
	private static String PostgrePass="myPass";
	
	private static String className=SqliteDBClassName;
	private static String emptyUrl=SqliteDBEmptyUrl;
	private static String url=SqliteDBUrl;
	private static String uname=MySqlUname;
	private static String pass=MySqlPass;
	//DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
	private static Connection con=null;
	public static String getHost() {
		return Host;
	}

	public static void setHost(String host) {
		Host = host;
	}

	public static String getMySqlPort() {
		return MySqlPort;
	}

	public static void setMySqlPort(String mySqlPort) {
		MySqlPort = mySqlPort;
	}

	public static String getMariaDBPort() {
		return MariaDBPort;
	}

	public static void setMariaDBPort(String mariaDBPort) {
		MariaDBPort = mariaDBPort;
	}

	public static String getPostgreSqlPort() {
		return PostgreSqlPort;
	}

	public static void setPostgreSqlPort(String postgreSqlPort) {
		PostgreSqlPort = postgreSqlPort;
	}

	public static String getPort() {
		return Port;
	}

	public static void setPort(String port) {
		Port = port;
	}

	public static String getPrefSchema() {
		return PrefSchema;
	}

	public static void setPrefSchema(String prefSchema) {
		PrefSchema = prefSchema;
	}

	public static String getMySqlClassName() {
		return MySqlClassName;
	}

	public static void setMySqlClassName(String mySqlClassName) {
		MySqlClassName = mySqlClassName;
	}

	public static String getMySqlEmptyUrl() {
		return MySqlEmptyUrl;
	}

	public static void setMySqlEmptyUrl(String mySqlEmptyUrl) {
		MySqlEmptyUrl = mySqlEmptyUrl;
	}

	public static String getMySqlUrl() {
		return MySqlUrl;
	}

	public static void setMySqlUrl(String mySqlUrl) {
		MySqlUrl = mySqlUrl;
	}

	public static String getMySqlUname() {
		return MySqlUname;
	}

	public static void setMySqlUname(String mySqlUname) {
		MySqlUname = mySqlUname;
	}

	public static String getMySqlPass() {
		return MySqlPass;
	}

	public static void setMySqlPass(String mySqlPass) {
		MySqlPass = mySqlPass;
	}

	public static String getMariaDBClassName() {
		return MariaDBClassName;
	}

	public static void setMariaDBClassName(String mariaDBClassName) {
		MariaDBClassName = mariaDBClassName;
	}

	public static String getMariaDBEmptyUrl() {
		return MariaDBEmptyUrl;
	}

	public static void setMariaDBEmptyUrl(String mariaDBEmptyUrl) {
		MariaDBEmptyUrl = mariaDBEmptyUrl;
	}

	public static String getMariaDBUrl() {
		return MariaDBUrl;
	}

	public static void setMariaDBUrl(String mariaDBUrl) {
		MariaDBUrl = mariaDBUrl;
	}

	public static String getMariaDBUname() {
		return MariaDBUname;
	}

	public static void setMariaDBUname(String mariaDBUname) {
		MariaDBUname = mariaDBUname;
	}

	public static String getMariaDBPass() {
		return MariaDBPass;
	}

	public static void setMariaDBPass(String mariaDBPass) {
		MariaDBPass = mariaDBPass;
	}

	public static String getSqliteDBClassName() {
		return SqliteDBClassName;
	}

	public static void setSqliteDBClassName(String sqliteDBClassName) {
		SqliteDBClassName = sqliteDBClassName;
	}

	public static String getSqliteDBEmptyUrl() {
		return SqliteDBEmptyUrl;
	}

	public static void setSqliteDBEmptyUrl(String sqliteDBEmptyUrl) {
		SqliteDBEmptyUrl = sqliteDBEmptyUrl;
	}

	public static String getSqliteDBUrl() {
		return SqliteDBUrl;
	}

	public static void setSqliteDBUrl(String sqliteDBUrl) {
		SqliteDBUrl = sqliteDBUrl;
	}

	public static String getPostgreClassName() {
		return PostgreClassName;
	}

	public static void setPostgreClassName(String postgreClassName) {
		PostgreClassName = postgreClassName;
	}

	public static String getPostgreEmptyUrl() {
		return PostgreEmptyUrl;
	}

	public static void setPostgreEmptyUrl(String postgreEmptyUrl) {
		PostgreEmptyUrl = postgreEmptyUrl;
	}

	public static String getPostgreUrl() {
		return PostgreUrl;
	}

	public static void setPostgreUrl(String postgreUrl) {
		PostgreUrl = postgreUrl;
	}

	public static String getPostgreUname() {
		return PostgreUname;
	}

	public static void setPostgreUname(String postgreUname) {
		PostgreUname = postgreUname;
	}

	public static String getPostgrePass() {
		return PostgrePass;
	}

	public static void setPostgrePass(String postgrePass) {
		PostgrePass = postgrePass;
	}

	public static String getClassName() {
		return className;
	}

	public static void setClassName(String className) {
		Dao.className = className;
	}

	public static String getEmptyUrl() {
		return emptyUrl;
	}

	public static void setEmptyUrl(String emptyUrl) {
		Dao.emptyUrl = emptyUrl;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		Dao.url = url;
	}

	public static String getUname() {
		return uname;
	}

	public static void setUname(String uname) {
		Dao.uname = uname;
	}

	public static String getPass() {
		return pass;
	}

	public static void setPass(String pass) {
		Dao.pass = pass;
	}

	public static Connection getCon1() {
		return con1;
	}

	public static void setCon1(Connection con1) {
		Dao.con1 = con1;
	}

	public static void setCon(Connection con) {
		Dao.con = con;
	}
	private static Connection con1=null;
	public static Connection getEmptyCon() throws ClassNotFoundException, SQLException {
		Class.forName(className);
		Connection con;
		if(className.equals(SqliteDBClassName))
		 con= DriverManager.getConnection(url);
		else
			con=DriverManager.getConnection(emptyUrl,uname,pass);
//		Connection con = DriverManager.getConnection(url,uname,pass);
		return con;
	}
	public static Connection getCon() throws ClassNotFoundException, SQLException {
		Class.forName(className);
		Connection con;
		if(className.equals(SqliteDBClassName))
		 con= DriverManager.getConnection(url);
		else
			con=DriverManager.getConnection(url,uname,pass);
//		Connection con = DriverManager.getConnection(url,uname,pass);
		return con;
	}
	
	public void createDatabase(String databasename) throws SQLException, ClassNotFoundException 
	{
		String query1="create database if not exists ?";
				//String query1=" CREATE DATABASE [?]";
		
		try {
			con=getEmptyCon();
//			Connection con1 = DriverManager.getConnection(emptyUrl,uname,pass);
			
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setString(1, databasename);
			st1.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
	}
	
	public void createDefaultDBInformationTable() throws SQLException
	{

		
		
		String query1="Create table DefaultDBInformationTable" +
                "(" +
				"defaultDB text primary key,"+
                "defaultHost text,"+
                 "defaultPort text,"+
                 "defaultSchema text,"+
                  "defaultUsername text,"+
                  "defaultPassword text);";

		
		
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
	}
	public void createPrefDBInformationTable() throws SQLException
	{

		
		
		String query1="Create table PrefDBInformationTable" +
                "(" +
				"Id integer primary key,"+
				"PrefDB text,"+
                "PrefHost text,"+
                 "PrefPort text,"+
                 "PrefSchema text,"
                 + "PrefUsername text,"
                 + "PrefPassword text);";
		
		
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
	
		}
		
	}
	public int insertIntoDefaultDBInformationTable(String database, String host, String port, 
			String schema,String username,String password ) throws SQLException
	{
		
		
		String query1="Insert into DefaultDBInformationTable"+
				 " (defaultDB, defaultHost,defaultPort,defaultSchema,defaultUsername,defaultPassword)"+
				 " values (?,?,?,?,?,?)";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setString(1, database);
			st1.setString(2, host);
			st1.setString(3, port);
			st1.setString(4, schema);
			st1.setString(5, username);
			st1.setString(6, password);
			result=st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
		}
		
		return result;
		
	}
	public int insertIntoPrefDBInformationTable(String prefDatabase, 
			String prefHost, String prefPort, 
			String prefSchema,String prefUsername,String prefPassword ) throws SQLException
	{
		
		
		String query1="Insert into PrefDBInformationTable (Id,PrefDB,PrefHost,PrefPort,"
				+ "PrefSchema,PrefUsername,PrefPassword)"
				+ "values (?,?,?,?,?,?,?)";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setLong(1, 1);
			st1.setString(2, prefDatabase);
			st1.setString(3, prefHost);
			st1.setString(4, prefPort);
			st1.setString(5, prefSchema);
			st1.setString(6, prefUsername);
			st1.setString(7, prefPassword);
			result=st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
		}
		
		return result;
		
	}
	public int clearPrefDBInformationTable() throws SQLException 
	{
		String query1="Delete From PrefDBInformationTable";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			result= st1.executeUpdate();
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
		return result;
		
	}
	public int clearDefaultDBInformationTable() throws SQLException 
	{
		String query1="Delete From DefaultDBInformationTable";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			result= st1.executeUpdate();
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
		return result;
		
	}
	public int updatePrefDBInformationTable(String prefDatabase, 
			String prefHost, String prefPort, 
			String prefSchema,String prefUsername,String prefPassword ) throws SQLException
	{
		
		String query1="Update PrefDBInformationTable "
				+ "Set PrefHost=?, PrefPort=?, PrefSchema=?,"
				+ "PrefUsername=?,PrefPassword=?, PrefDB=? where Id=?";
		
		
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setString(1, prefHost);
			st1.setString(2, prefPort);
			st1.setString(3, prefSchema);
			st1.setString(4, prefUsername);
			st1.setString(5, prefPassword);
			st1.setString(6, prefDatabase);
			st1.setLong(7, 1);
			result=st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
		}
		
		return result;
		
	}
	public DefaultDBInformation getDefaultDBInformation(String databaseName) throws SQLException
	{
		String query="Select * From DefaultDBInformationTable where defaultDB=?";
		DefaultDBInformation p=new DefaultDBInformation();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setString(1, databaseName);
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				p.setDatabase(rs.getString("defaultDB"));
				p.setHost(rs.getString("defaultHost"));
				p.setPort(rs.getString("defaultPort"));
				p.setSchema(rs.getString("defaultSchema"));
				p.setUsername(rs.getString("defaultUsername"));
				p.setPassword(rs.getString("defaultPassword"));
			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return p;
	}
	public PrefDBInformation getPrefDBInformation(String databaseName) throws SQLException
	{
		String query="Select * From PrefDBInformationTable where DB=?";
		PrefDBInformation p=new PrefDBInformation();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setString(1, databaseName);
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				p.setPrefDatabase(rs.getString("PrefDB"));
				p.setPrefHost(rs.getString("PrefHost"));
				p.setPrefPort(rs.getString("PrefPort"));
				p.setPrefSchema(rs.getString("PrefSchema"));
				p.setPrefUsername(rs.getString("PrefUsername"));
				p.setPrefPassword(rs.getString("PrefPassword"));
			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return p;
	}
	public PrefDBInformation getPrefDBInformation() throws SQLException
	{
		String query="Select * From PrefDBInformationTable";
		PrefDBInformation p=new PrefDBInformation();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				p.setPrefDatabase(rs.getString("PrefDB"));
				p.setPrefHost(rs.getString("PrefHost"));
				p.setPrefPort(rs.getString("PrefPort"));
				p.setPrefSchema(rs.getString("PrefSchema"));
				p.setPrefUsername(rs.getString("PrefUsername"));
				p.setPrefPassword(rs.getString("PrefPassword"));
			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return p;
	}
	
	
	public int createExamTable() throws SQLException
	{

		String query1="";
		if(className.equals(MySqlClassName))
		{
			query1="Create table ExamTable" +
					"(" +
					"id integer primary key auto_increment, "
					+ "name text unique not null, "
					+ "on1 text,"
					+ "on2 text,"
					+ "on3 text,"
					+ "on4 text,"
					+ "on5 text,"
					+ "on6 text,"
					+ "on7 text,"
					+ "on8 text,"
					+ "on9 text,"
					+ "on10 text,"
					+ "on11 text,"
					+ "on12 text,"
					+ "on13 text,"
					+ "on14 text,"
					+ "on15 text,"
					+ "on16 text,"
					+ "on17 text,"
					+ "on18 text,"
					+ "on19 text,"
					+ "on20 text,"
					+ "on21 text,"
					+ "on22 text,"
					+ "on23 text,"
					+ "on24 text,"
					+ "on25 text,"
					+ "on26 text,"
					+ "on27 text,"
					+ "on28 text,"
					+ "on29 text,"
					+ "on30 text,"
					+ "son1 text,"
					+ "son2 text,"
					+ "son3 text,"
					+ "son4 text,"
					+ "son5 text,"
					+ "son6 text,"
					+ "son7 text,"
					+ "son8 text,"
					+ "son9 text,"
					+ "son10 text,"
					+ "son11 text,"
					+ "son12 text,"
					+ "son13 text,"
					+ "son14 text,"
					+ "son15 text,"
					+ "son16 text,"
					+ "son17 text,"
					+ "son18 text,"
					+ "son19 text,"
					+ "son20 text,"
					+ "son21 text,"
					+ "son22 text,"
					+ "son23 text,"
					+ "son24 text,"
					+ "son25 text,"
					+ "son26 text,"
					+ "son27 text,"
					+ "son28 text,"
					+ "son29 text,"
					+ "son30 text"
					+ ");";
		}
		else if(className.equals(MariaDBClassName))
		{
			query1="Create table ExamTable" +
					"(" +
					"id integer primary key auto_increment, "
					+ "name text unique not null, "
					+ "on1 text,"
					+ "on2 text,"
					+ "on3 text,"
					+ "on4 text,"
					+ "on5 text,"
					+ "on6 text,"
					+ "on7 text,"
					+ "on8 text,"
					+ "on9 text,"
					+ "on10 text,"
					+ "on11 text,"
					+ "on12 text,"
					+ "on13 text,"
					+ "on14 text,"
					+ "on15 text,"
					+ "on16 text,"
					+ "on17 text,"
					+ "on18 text,"
					+ "on19 text,"
					+ "on20 text,"
					+ "on21 text,"
					+ "on22 text,"
					+ "on23 text,"
					+ "on24 text,"
					+ "on25 text,"
					+ "on26 text,"
					+ "on27 text,"
					+ "on28 text,"
					+ "on29 text,"
					+ "on30 text,"
					+ "son1 text,"
					+ "son2 text,"
					+ "son3 text,"
					+ "son4 text,"
					+ "son5 text,"
					+ "son6 text,"
					+ "son7 text,"
					+ "son8 text,"
					+ "son9 text,"
					+ "son10 text,"
					+ "son11 text,"
					+ "son12 text,"
					+ "son13 text,"
					+ "son14 text,"
					+ "son15 text,"
					+ "son16 text,"
					+ "son17 text,"
					+ "son18 text,"
					+ "son19 text,"
					+ "son20 text,"
					+ "son21 text,"
					+ "son22 text,"
					+ "son23 text,"
					+ "son24 text,"
					+ "son25 text,"
					+ "son26 text,"
					+ "son27 text,"
					+ "son28 text,"
					+ "son29 text,"
					+ "son30 text"
					+ ");";
		}
		else if(className.equals(SqliteDBClassName))
		{
			query1="Create table ExamTable" +
					"(" +
					"id integer primary key autoincrement, "
					+ "name text unique not null, "
					+ "on1 text,"
					+ "on2 text,"
					+ "on3 text,"
					+ "on4 text,"
					+ "on5 text,"
					+ "on6 text,"
					+ "on7 text,"
					+ "on8 text,"
					+ "on9 text,"
					+ "on10 text,"
					+ "on11 text,"
					+ "on12 text,"
					+ "on13 text,"
					+ "on14 text,"
					+ "on15 text,"
					+ "on16 text,"
					+ "on17 text,"
					+ "on18 text,"
					+ "on19 text,"
					+ "on20 text,"
					+ "on21 text,"
					+ "on22 text,"
					+ "on23 text,"
					+ "on24 text,"
					+ "on25 text,"
					+ "on26 text,"
					+ "on27 text,"
					+ "on28 text,"
					+ "on29 text,"
					+ "on30 text,"
					+ "son1 text,"
					+ "son2 text,"
					+ "son3 text,"
					+ "son4 text,"
					+ "son5 text,"
					+ "son6 text,"
					+ "son7 text,"
					+ "son8 text,"
					+ "son9 text,"
					+ "son10 text,"
					+ "son11 text,"
					+ "son12 text,"
					+ "son13 text,"
					+ "son14 text,"
					+ "son15 text,"
					+ "son16 text,"
					+ "son17 text,"
					+ "son18 text,"
					+ "son19 text,"
					+ "son20 text,"
					+ "son21 text,"
					+ "son22 text,"
					+ "son23 text,"
					+ "son24 text,"
					+ "son25 text,"
					+ "son26 text,"
					+ "son27 text,"
					+ "son28 text,"
					+ "son29 text,"
					+ "son30 text"
					+ ");";
		}
		else if(className.equals(PostgreClassName))
		{
			query1="Create table ExamTable" +
					"(" +
					"id integer primary key generated by default as identity, "
					+ "name text unique not null, "
					+ "on1 text,"
					+ "on2 text,"
					+ "on3 text,"
					+ "on4 text,"
					+ "on5 text,"
					+ "on6 text,"
					+ "on7 text,"
					+ "on8 text,"
					+ "on9 text,"
					+ "on10 text,"
					+ "on11 text,"
					+ "on12 text,"
					+ "on13 text,"
					+ "on14 text,"
					+ "on15 text,"
					+ "on16 text,"
					+ "on17 text,"
					+ "on18 text,"
					+ "on19 text,"
					+ "on20 text,"
					+ "on21 text,"
					+ "on22 text,"
					+ "on23 text,"
					+ "on24 text,"
					+ "on25 text,"
					+ "on26 text,"
					+ "on27 text,"
					+ "on28 text,"
					+ "on29 text,"
					+ "on30 text,"
					+ "son1 text,"
					+ "son2 text,"
					+ "son3 text,"
					+ "son4 text,"
					+ "son5 text,"
					+ "son6 text,"
					+ "son7 text,"
					+ "son8 text,"
					+ "son9 text,"
					+ "son10 text,"
					+ "son11 text,"
					+ "son12 text,"
					+ "son13 text,"
					+ "son14 text,"
					+ "son15 text,"
					+ "son16 text,"
					+ "son17 text,"
					+ "son18 text,"
					+ "son19 text,"
					+ "son20 text,"
					+ "son21 text,"
					+ "son22 text,"
					+ "son23 text,"
					+ "son24 text,"
					+ "son25 text,"
					+ "son26 text,"
					+ "son27 text,"
					+ "son28 text,"
					+ "son29 text,"
					+ "son30 text"
					+ ");";
			
		}
                
		
		
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			result=st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally 
		{
			if(con!=null)
			{
				con.close();
			}
		
		}
		return result;
		
	}
	
	public int createParticipantAnswerTable() throws SQLException
	{

		String query1="";
		if(className.equals(MySqlClassName))
		{
			query1="Create table ParticipantAnswerTable" +
					"(" 
					+"id integer primary key auto_increment, "
					+ "exam_id integer references ExamTable(id) "
					+ "on delete set null on update cascade,"
					+ "test_type text, "
					+ "name_surname text, "
					+ "file_name text, "
					+"participant_answer_1 text,"
					+"participant_answer_2 text,"
					+"participant_answer_3 text,"
					+"participant_answer_4 text,"
					+"participant_answer_5 text,"
					+"participant_answer_6 text,"
					+"participant_answer_7 text,"
					+"participant_answer_8 text,"
					+"participant_answer_9 text,"
					+"participant_answer_10 text,"
					+"participant_answer_11 text,"
					+"participant_answer_12 text,"
					+"participant_answer_13 text,"
					+"participant_answer_14 text,"
					+"participant_answer_15 text,"
					+"participant_answer_16 text,"
					+"participant_answer_17 text,"
					+"participant_answer_18 text,"
					+"participant_answer_19 text,"
					+"participant_answer_20 text,"
					+"participant_answer_21 text,"
					+"participant_answer_22 text,"
					+"participant_answer_23 text,"
					+"participant_answer_24 text,"
					+"participant_answer_25 text,"
					+"participant_answer_26 text,"
					+"participant_answer_27 text,"
					+"participant_answer_28 text,"
					+"participant_answer_29 text,"
					+"participant_answer_30 text,"
					+"answer_correctness_1 text,"
					+"answer_correctness_2 text,"
					+"answer_correctness_3 text,"
					+"answer_correctness_4 text,"
					+"answer_correctness_5 text,"
					+"answer_correctness_6 text,"
					+"answer_correctness_7 text,"
					+"answer_correctness_8 text,"
					+"answer_correctness_9 text,"
					+"answer_correctness_10 text,"
					+"answer_correctness_11 text,"
					+"answer_correctness_12 text,"
					+"answer_correctness_13 text,"
					+"answer_correctness_14 text,"
					+"answer_correctness_15 text,"
					+"answer_correctness_16 text,"
					+"answer_correctness_17 text,"
					+"answer_correctness_18 text,"
					+"answer_correctness_19 text,"
					+"answer_correctness_20 text,"
					+"answer_correctness_21 text,"
					+"answer_correctness_22 text,"
					+"answer_correctness_23 text,"
					+"answer_correctness_24 text,"
					+"answer_correctness_25 text,"
					+"answer_correctness_26 text,"
					+"answer_correctness_27 text,"
					+"answer_correctness_28 text,"
					+"answer_correctness_29 text,"
					+"answer_correctness_30 text,"
					+"number_of_correct_answers_over_30 int,"
					+"total_point_over_30 int,"
					+"number_of_correct_answers_over_25 int,"
					+"total_point_over_25 int"
					+ ");";
		}
		else if(className.equals(MariaDBClassName))
		{
			query1="Create table ParticipantAnswerTable" +
					"(" 
					+"id integer primary key auto_increment, "
					+ "exam_id integer references ExamTable(id) "
					+ "on delete set null on update cascade,"
					+ "test_type text, "
					+ "name_surname text, "
					+ "file_name text, "
					+"participant_answer_1 text,"
					+"participant_answer_2 text,"
					+"participant_answer_3 text,"
					+"participant_answer_4 text,"
					+"participant_answer_5 text,"
					+"participant_answer_6 text,"
					+"participant_answer_7 text,"
					+"participant_answer_8 text,"
					+"participant_answer_9 text,"
					+"participant_answer_10 text,"
					+"participant_answer_11 text,"
					+"participant_answer_12 text,"
					+"participant_answer_13 text,"
					+"participant_answer_14 text,"
					+"participant_answer_15 text,"
					+"participant_answer_16 text,"
					+"participant_answer_17 text,"
					+"participant_answer_18 text,"
					+"participant_answer_19 text,"
					+"participant_answer_20 text,"
					+"participant_answer_21 text,"
					+"participant_answer_22 text,"
					+"participant_answer_23 text,"
					+"participant_answer_24 text,"
					+"participant_answer_25 text,"
					+"participant_answer_26 text,"
					+"participant_answer_27 text,"
					+"participant_answer_28 text,"
					+"participant_answer_29 text,"
					+"participant_answer_30 text,"
					+"answer_correctness_1 text,"
					+"answer_correctness_2 text,"
					+"answer_correctness_3 text,"
					+"answer_correctness_4 text,"
					+"answer_correctness_5 text,"
					+"answer_correctness_6 text,"
					+"answer_correctness_7 text,"
					+"answer_correctness_8 text,"
					+"answer_correctness_9 text,"
					+"answer_correctness_10 text,"
					+"answer_correctness_11 text,"
					+"answer_correctness_12 text,"
					+"answer_correctness_13 text,"
					+"answer_correctness_14 text,"
					+"answer_correctness_15 text,"
					+"answer_correctness_16 text,"
					+"answer_correctness_17 text,"
					+"answer_correctness_18 text,"
					+"answer_correctness_19 text,"
					+"answer_correctness_20 text,"
					+"answer_correctness_21 text,"
					+"answer_correctness_22 text,"
					+"answer_correctness_23 text,"
					+"answer_correctness_24 text,"
					+"answer_correctness_25 text,"
					+"answer_correctness_26 text,"
					+"answer_correctness_27 text,"
					+"answer_correctness_28 text,"
					+"answer_correctness_29 text,"
					+"answer_correctness_30 text,"
					+"number_of_correct_answers_over_30 int,"
					+"total_point_over_30 int,"
					+"number_of_correct_answers_over_25 int,"
					+"total_point_over_25 int"
					+ ");";
		
		}
		else if(className.equals(SqliteDBClassName))
		{
			query1="Create table ParticipantAnswerTable" +
					"(" 
					+"id integer primary key autoincrement, "
					+ "exam_id integer references ExamTable(id) "
					+ "on delete set null on update cascade,"
					+ "test_type text, "
					+ "name_surname text, "
					+ "file_name text, "
					+"participant_answer_1 text,"
					+"participant_answer_2 text,"
					+"participant_answer_3 text,"
					+"participant_answer_4 text,"
					+"participant_answer_5 text,"
					+"participant_answer_6 text,"
					+"participant_answer_7 text,"
					+"participant_answer_8 text,"
					+"participant_answer_9 text,"
					+"participant_answer_10 text,"
					+"participant_answer_11 text,"
					+"participant_answer_12 text,"
					+"participant_answer_13 text,"
					+"participant_answer_14 text,"
					+"participant_answer_15 text,"
					+"participant_answer_16 text,"
					+"participant_answer_17 text,"
					+"participant_answer_18 text,"
					+"participant_answer_19 text,"
					+"participant_answer_20 text,"
					+"participant_answer_21 text,"
					+"participant_answer_22 text,"
					+"participant_answer_23 text,"
					+"participant_answer_24 text,"
					+"participant_answer_25 text,"
					+"participant_answer_26 text,"
					+"participant_answer_27 text,"
					+"participant_answer_28 text,"
					+"participant_answer_29 text,"
					+"participant_answer_30 text,"
					+"answer_correctness_1 text,"
					+"answer_correctness_2 text,"
					+"answer_correctness_3 text,"
					+"answer_correctness_4 text,"
					+"answer_correctness_5 text,"
					+"answer_correctness_6 text,"
					+"answer_correctness_7 text,"
					+"answer_correctness_8 text,"
					+"answer_correctness_9 text,"
					+"answer_correctness_10 text,"
					+"answer_correctness_11 text,"
					+"answer_correctness_12 text,"
					+"answer_correctness_13 text,"
					+"answer_correctness_14 text,"
					+"answer_correctness_15 text,"
					+"answer_correctness_16 text,"
					+"answer_correctness_17 text,"
					+"answer_correctness_18 text,"
					+"answer_correctness_19 text,"
					+"answer_correctness_20 text,"
					+"answer_correctness_21 text,"
					+"answer_correctness_22 text,"
					+"answer_correctness_23 text,"
					+"answer_correctness_24 text,"
					+"answer_correctness_25 text,"
					+"answer_correctness_26 text,"
					+"answer_correctness_27 text,"
					+"answer_correctness_28 text,"
					+"answer_correctness_29 text,"
					+"answer_correctness_30 text,"
					+"number_of_correct_answers_over_30 int,"
					+"total_point_over_30 int,"
					+"number_of_correct_answers_over_25 int,"
					+"total_point_over_25 int"
					+ ");";
		
		}
		else if(className.equals(PostgreClassName))
		{
			query1="Create table ParticipantAnswerTable" +
					"(" 
					+"id integer primary key generated by default as identity, "
					+ "exam_id integer references ExamTable(id) "
					+ "on delete set null on update cascade,"
					+ "test_type text, "
					+ "name_surname text, "
					+ "file_name text, "
					+"participant_answer_1 text,"
					+"participant_answer_2 text,"
					+"participant_answer_3 text,"
					+"participant_answer_4 text,"
					+"participant_answer_5 text,"
					+"participant_answer_6 text,"
					+"participant_answer_7 text,"
					+"participant_answer_8 text,"
					+"participant_answer_9 text,"
					+"participant_answer_10 text,"
					+"participant_answer_11 text,"
					+"participant_answer_12 text,"
					+"participant_answer_13 text,"
					+"participant_answer_14 text,"
					+"participant_answer_15 text,"
					+"participant_answer_16 text,"
					+"participant_answer_17 text,"
					+"participant_answer_18 text,"
					+"participant_answer_19 text,"
					+"participant_answer_20 text,"
					+"participant_answer_21 text,"
					+"participant_answer_22 text,"
					+"participant_answer_23 text,"
					+"participant_answer_24 text,"
					+"participant_answer_25 text,"
					+"participant_answer_26 text,"
					+"participant_answer_27 text,"
					+"participant_answer_28 text,"
					+"participant_answer_29 text,"
					+"participant_answer_30 text,"
					+"answer_correctness_1 text,"
					+"answer_correctness_2 text,"
					+"answer_correctness_3 text,"
					+"answer_correctness_4 text,"
					+"answer_correctness_5 text,"
					+"answer_correctness_6 text,"
					+"answer_correctness_7 text,"
					+"answer_correctness_8 text,"
					+"answer_correctness_9 text,"
					+"answer_correctness_10 text,"
					+"answer_correctness_11 text,"
					+"answer_correctness_12 text,"
					+"answer_correctness_13 text,"
					+"answer_correctness_14 text,"
					+"answer_correctness_15 text,"
					+"answer_correctness_16 text,"
					+"answer_correctness_17 text,"
					+"answer_correctness_18 text,"
					+"answer_correctness_19 text,"
					+"answer_correctness_20 text,"
					+"answer_correctness_21 text,"
					+"answer_correctness_22 text,"
					+"answer_correctness_23 text,"
					+"answer_correctness_24 text,"
					+"answer_correctness_25 text,"
					+"answer_correctness_26 text,"
					+"answer_correctness_27 text,"
					+"answer_correctness_28 text,"
					+"answer_correctness_29 text,"
					+"answer_correctness_30 text,"
					+"number_of_correct_answers_over_30 int,"
					+"total_point_over_30 int,"
					+"number_of_correct_answers_over_25 int,"
					+"total_point_over_25 int"
					+ ");";
		
			
		}
                
		
		
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			result=st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally 
		{
			if(con!=null)
			{
				con.close();
			}
	
		}
		return result;
		
	}
	
	
	public List<Exam> getAllExams() throws SQLException
	{
		String query="Select * From ExamTable";
		List<Exam> examsInDb=new ArrayList<Exam>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				Exam p=new Exam();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setOn1(rs.getString("on1"));
				p.setOn2(rs.getString("on2"));
				p.setOn3(rs.getString("on3"));
				p.setOn4(rs.getString("on4"));
				p.setOn5(rs.getString("on5"));
				p.setOn6(rs.getString("on6"));
				p.setOn7(rs.getString("on7"));
				p.setOn8(rs.getString("on8"));
				p.setOn9(rs.getString("on9"));
				p.setOn10(rs.getString("on10"));
				p.setOn11(rs.getString("on11"));
				p.setOn12(rs.getString("on12"));
				p.setOn13(rs.getString("on13"));
				p.setOn14(rs.getString("on14"));
				p.setOn15(rs.getString("on15"));
				p.setOn16(rs.getString("on16"));
				p.setOn17(rs.getString("on17"));
				p.setOn18(rs.getString("on18"));
				p.setOn19(rs.getString("on19"));
				p.setOn20(rs.getString("on20"));
				p.setOn21(rs.getString("on21"));
				p.setOn22(rs.getString("on22"));
				p.setOn23(rs.getString("on23"));
				p.setOn24(rs.getString("on24"));
				p.setOn25(rs.getString("on25"));
				p.setOn26(rs.getString("on26"));
				p.setOn27(rs.getString("on27"));
				p.setOn28(rs.getString("on28"));
				p.setOn29(rs.getString("on29"));
				p.setOn30(rs.getString("on30"));
				p.setSon1(rs.getString("son1"));
				p.setSon2(rs.getString("son2"));
				p.setSon3(rs.getString("son3"));
				p.setSon4(rs.getString("son4"));
				p.setSon5(rs.getString("son5"));
				p.setSon6(rs.getString("son6"));
				p.setSon7(rs.getString("son7"));
				p.setSon8(rs.getString("son8"));
				p.setSon9(rs.getString("son9"));
				p.setSon10(rs.getString("son10"));
				p.setSon11(rs.getString("son11"));
				p.setSon12(rs.getString("son12"));
				p.setSon13(rs.getString("son13"));
				p.setSon14(rs.getString("son14"));
				p.setSon15(rs.getString("son15"));
				p.setSon16(rs.getString("son16"));
				p.setSon17(rs.getString("son17"));
				p.setSon18(rs.getString("son18"));
				p.setSon19(rs.getString("son19"));
				p.setSon20(rs.getString("son20"));
				p.setSon21(rs.getString("son21"));
				p.setSon22(rs.getString("son22"));
				p.setSon23(rs.getString("son23"));
				p.setSon24(rs.getString("son24"));
				p.setSon25(rs.getString("son25"));
				p.setSon26(rs.getString("son26"));
				p.setSon27(rs.getString("son27"));
				p.setSon28(rs.getString("son28"));
				p.setSon29(rs.getString("son29"));
				p.setSon30(rs.getString("son30"));
				
				
				examsInDb.add(p);
				
				
			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return examsInDb;
	}
	public List<ParticipantAnswer> getParticipantAnswersByExam(Exam exam) throws SQLException
	{
		String query="Select * From ParticipantAnswerTable where exam_id=?";
		List<ParticipantAnswer> participantAnswersInDb=new ArrayList<ParticipantAnswer>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setInt(1, exam.getId());
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				ParticipantAnswer pa=new ParticipantAnswer();
				   
					pa.setId(rs.getInt("id"));
				 	pa.setExam_id(rs.getInt("exam_id"));                   
				 	pa.setTest_type(rs.getString("test_type"));                 
				 	pa.setName_surname(rs.getString("name_surname"));              
				 	pa.setFile_name(rs.getString("file_name"));                 
				 	pa.setParticipant_answer_1(rs.getString("participant_answer_1"));      
				 	pa.setParticipant_answer_2(rs.getString("participant_answer_2"));      
				 	pa.setParticipant_answer_3(rs.getString("participant_answer_3"));      
				 	pa.setParticipant_answer_4(rs.getString("participant_answer_4"));      
				 	pa.setParticipant_answer_5(rs.getString("participant_answer_5"));      
				  pa.setParticipant_answer_6(rs.getString("participant_answer_6"));        
				  pa.setParticipant_answer_7(rs.getString("participant_answer_7"));        
				  pa.setParticipant_answer_8(rs.getString("participant_answer_8"));        
				  pa.setParticipant_answer_9(rs.getString("participant_answer_9"));        
				  pa.setParticipant_answer_10(rs.getString("participant_answer_10"));       
				  pa.setParticipant_answer_11(rs.getString("participant_answer_11"));       
				  pa.setParticipant_answer_12(rs.getString("participant_answer_12"));       
				  pa.setParticipant_answer_13(rs.getString("participant_answer_13"));       
				  pa.setParticipant_answer_14(rs.getString("participant_answer_14"));       
				  pa.setParticipant_answer_15(rs.getString("participant_answer_15"));       
				  pa.setParticipant_answer_16(rs.getString("participant_answer_16"));       
				  pa.setParticipant_answer_17(rs.getString("participant_answer_17"));       
				  pa.setParticipant_answer_18(rs.getString("participant_answer_18"));       
				  pa.setParticipant_answer_19(rs.getString("participant_answer_19"));       
				  pa.setParticipant_answer_20(rs.getString("participant_answer_20"));       
				  pa.setParticipant_answer_21(rs.getString("participant_answer_21"));       
				  pa.setParticipant_answer_22(rs.getString("participant_answer_22"));       
				  pa.setParticipant_answer_23(rs.getString("participant_answer_23"));       
				  pa.setParticipant_answer_24(rs.getString("participant_answer_24"));       
				  pa.setParticipant_answer_25(rs.getString("participant_answer_25"));       
				  pa.setParticipant_answer_26(rs.getString("participant_answer_26"));       
				  pa.setParticipant_answer_27(rs.getString("participant_answer_27"));       
				  pa.setParticipant_answer_28(rs.getString("participant_answer_28"));       
				  pa.setParticipant_answer_29(rs.getString("participant_answer_29"));       
				  pa.setParticipant_answer_30(rs.getString("participant_answer_30"));       
				  pa.setAnswer_correctness_1(rs.getString("answer_correctness_1"));        
				  pa.setAnswer_correctness_2(rs.getString("answer_correctness_2"));        
				  pa.setAnswer_correctness_3(rs.getString("answer_correctness_3"));        
				  pa.setAnswer_correctness_4(rs.getString("answer_correctness_4"));        
				  pa.setAnswer_correctness_5(rs.getString("answer_correctness_5"));        
				  pa.setAnswer_correctness_6(rs.getString("answer_correctness_6"));        
				  pa.setAnswer_correctness_7(rs.getString("answer_correctness_7"));        
				  pa.setAnswer_correctness_8(rs.getString("answer_correctness_8"));        
				  pa.setAnswer_correctness_9(rs.getString("answer_correctness_9"));        
				  pa.setAnswer_correctness_10(rs.getString("answer_correctness_10"));                
				  pa.setAnswer_correctness_11(rs.getString("answer_correctness_11"));       
				  pa.setAnswer_correctness_12(rs.getString("answer_correctness_12"));       
				  pa.setAnswer_correctness_13(rs.getString("answer_correctness_13"));       
				  pa.setAnswer_correctness_14(rs.getString("answer_correctness_14"));       
				  pa.setAnswer_correctness_15(rs.getString("answer_correctness_15"));       
				  pa.setAnswer_correctness_16(rs.getString("answer_correctness_16"));       
				  pa.setAnswer_correctness_17(rs.getString("answer_correctness_17"));       
				  pa.setAnswer_correctness_18(rs.getString("answer_correctness_18"));       
				  pa.setAnswer_correctness_19(rs.getString("answer_correctness_19"));       
				  pa.setAnswer_correctness_20(rs.getString("answer_correctness_20"));       
				  pa.setAnswer_correctness_21(rs.getString("answer_correctness_21"));       
				  pa.setAnswer_correctness_22(rs.getString("answer_correctness_22"));       
				  pa.setAnswer_correctness_23(rs.getString("answer_correctness_23"));       
				  pa.setAnswer_correctness_24(rs.getString("answer_correctness_24"));       
				  pa.setAnswer_correctness_25(rs.getString("answer_correctness_25"));       
				  pa.setAnswer_correctness_26(rs.getString("answer_correctness_26"));       
				  pa.setAnswer_correctness_27(rs.getString("answer_correctness_27"));       
				  pa.setAnswer_correctness_28(rs.getString("answer_correctness_28"));       
				  pa.setAnswer_correctness_29(rs.getString("answer_correctness_29"));       
				  pa.setAnswer_correctness_30(rs.getString("answer_correctness_30"));       
				 pa.setNumber_of_correct_answers_over_30(rs.getInt("number_of_correct_answers_over_30")); 
				 pa.setTotal_point_over_30(rs.getInt("total_point_over_30"));
				 pa.setNumber_of_correct_answers_over_25(rs.getInt("number_of_correct_answers_over_25")); 
				 pa.setTotal_point_over_25(rs.getInt("total_point_over_25")); 
				                                        
				 
				
				participantAnswersInDb.add(pa);
				
				
			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return participantAnswersInDb;
	}
	public List<ParticipantAnswer> getONTESTParticipantAnswersByExam(Exam exam) throws SQLException
	{
		String query="Select * From ParticipantAnswerTable where exam_id=? and test_type=?";
		List<ParticipantAnswer> participantAnswersInDb=new ArrayList<ParticipantAnswer>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setInt(1, exam.getId());
			st.setString(2, "ON TEST");
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				ParticipantAnswer pa=new ParticipantAnswer();
				   
					pa.setId(rs.getInt("id"));
				 	pa.setExam_id(rs.getInt("exam_id"));                   
				 	pa.setTest_type(rs.getString("test_type"));                 
				 	pa.setName_surname(rs.getString("name_surname"));              
				 	pa.setFile_name(rs.getString("file_name"));                 
				 	pa.setParticipant_answer_1(rs.getString("participant_answer_1"));      
				 	pa.setParticipant_answer_2(rs.getString("participant_answer_2"));      
				 	pa.setParticipant_answer_3(rs.getString("participant_answer_3"));      
				 	pa.setParticipant_answer_4(rs.getString("participant_answer_4"));      
				 	pa.setParticipant_answer_5(rs.getString("participant_answer_5"));      
				  pa.setParticipant_answer_6(rs.getString("participant_answer_6"));        
				  pa.setParticipant_answer_7(rs.getString("participant_answer_7"));        
				  pa.setParticipant_answer_8(rs.getString("participant_answer_8"));        
				  pa.setParticipant_answer_9(rs.getString("participant_answer_9"));        
				  pa.setParticipant_answer_10(rs.getString("participant_answer_10"));       
				  pa.setParticipant_answer_11(rs.getString("participant_answer_11"));       
				  pa.setParticipant_answer_12(rs.getString("participant_answer_12"));       
				  pa.setParticipant_answer_13(rs.getString("participant_answer_13"));       
				  pa.setParticipant_answer_14(rs.getString("participant_answer_14"));       
				  pa.setParticipant_answer_15(rs.getString("participant_answer_15"));       
				  pa.setParticipant_answer_16(rs.getString("participant_answer_16"));       
				  pa.setParticipant_answer_17(rs.getString("participant_answer_17"));       
				  pa.setParticipant_answer_18(rs.getString("participant_answer_18"));       
				  pa.setParticipant_answer_19(rs.getString("participant_answer_19"));       
				  pa.setParticipant_answer_20(rs.getString("participant_answer_20"));       
				  pa.setParticipant_answer_21(rs.getString("participant_answer_21"));       
				  pa.setParticipant_answer_22(rs.getString("participant_answer_22"));       
				  pa.setParticipant_answer_23(rs.getString("participant_answer_23"));       
				  pa.setParticipant_answer_24(rs.getString("participant_answer_24"));       
				  pa.setParticipant_answer_25(rs.getString("participant_answer_25"));       
				  pa.setParticipant_answer_26(rs.getString("participant_answer_26"));       
				  pa.setParticipant_answer_27(rs.getString("participant_answer_27"));       
				  pa.setParticipant_answer_28(rs.getString("participant_answer_28"));       
				  pa.setParticipant_answer_29(rs.getString("participant_answer_29"));       
				  pa.setParticipant_answer_30(rs.getString("participant_answer_30"));       
				  pa.setAnswer_correctness_1(rs.getString("answer_correctness_1"));        
				  pa.setAnswer_correctness_2(rs.getString("answer_correctness_2"));        
				  pa.setAnswer_correctness_3(rs.getString("answer_correctness_3"));        
				  pa.setAnswer_correctness_4(rs.getString("answer_correctness_4"));        
				  pa.setAnswer_correctness_5(rs.getString("answer_correctness_5"));        
				  pa.setAnswer_correctness_6(rs.getString("answer_correctness_6"));        
				  pa.setAnswer_correctness_7(rs.getString("answer_correctness_7"));        
				  pa.setAnswer_correctness_8(rs.getString("answer_correctness_8"));        
				  pa.setAnswer_correctness_9(rs.getString("answer_correctness_9"));        
				  pa.setAnswer_correctness_10(rs.getString("answer_correctness_10"));                
				  pa.setAnswer_correctness_11(rs.getString("answer_correctness_11"));       
				  pa.setAnswer_correctness_12(rs.getString("answer_correctness_12"));       
				  pa.setAnswer_correctness_13(rs.getString("answer_correctness_13"));       
				  pa.setAnswer_correctness_14(rs.getString("answer_correctness_14"));       
				  pa.setAnswer_correctness_15(rs.getString("answer_correctness_15"));       
				  pa.setAnswer_correctness_16(rs.getString("answer_correctness_16"));       
				  pa.setAnswer_correctness_17(rs.getString("answer_correctness_17"));       
				  pa.setAnswer_correctness_18(rs.getString("answer_correctness_18"));       
				  pa.setAnswer_correctness_19(rs.getString("answer_correctness_19"));       
				  pa.setAnswer_correctness_20(rs.getString("answer_correctness_20"));       
				  pa.setAnswer_correctness_21(rs.getString("answer_correctness_21"));       
				  pa.setAnswer_correctness_22(rs.getString("answer_correctness_22"));       
				  pa.setAnswer_correctness_23(rs.getString("answer_correctness_23"));       
				  pa.setAnswer_correctness_24(rs.getString("answer_correctness_24"));       
				  pa.setAnswer_correctness_25(rs.getString("answer_correctness_25"));       
				  pa.setAnswer_correctness_26(rs.getString("answer_correctness_26"));       
				  pa.setAnswer_correctness_27(rs.getString("answer_correctness_27"));       
				  pa.setAnswer_correctness_28(rs.getString("answer_correctness_28"));       
				  pa.setAnswer_correctness_29(rs.getString("answer_correctness_29"));       
				  pa.setAnswer_correctness_30(rs.getString("answer_correctness_30"));       
				  pa.setNumber_of_correct_answers_over_30(rs.getInt("number_of_correct_answers_over_30")); 
				  pa.setTotal_point_over_30(rs.getInt("total_point_over_30"));
				  pa.setNumber_of_correct_answers_over_25(rs.getInt("number_of_correct_answers_over_25")); 
				  pa.setTotal_point_over_25(rs.getInt("total_point_over_25"));               
				                                        
				
				
				participantAnswersInDb.add(pa);
				
				
			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return participantAnswersInDb;
	}
	public List<ParticipantAnswer> getSONTESTParticipantAnswersByExam(Exam exam) throws SQLException
	{
		String query="Select * From ParticipantAnswerTable where exam_id=? and test_type=?";
		List<ParticipantAnswer> participantAnswersInDb=new ArrayList<ParticipantAnswer>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setInt(1, exam.getId());
			st.setString(2, "SON TEST");
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				ParticipantAnswer pa=new ParticipantAnswer();
				   
					pa.setId(rs.getInt("id"));
				 	pa.setExam_id(rs.getInt("exam_id"));                   
				 	pa.setTest_type(rs.getString("test_type"));                 
				 	pa.setName_surname(rs.getString("name_surname"));              
				 	pa.setFile_name(rs.getString("file_name"));                 
				 	pa.setParticipant_answer_1(rs.getString("participant_answer_1"));      
				 	pa.setParticipant_answer_2(rs.getString("participant_answer_2"));      
				 	pa.setParticipant_answer_3(rs.getString("participant_answer_3"));      
				 	pa.setParticipant_answer_4(rs.getString("participant_answer_4"));      
				 	pa.setParticipant_answer_5(rs.getString("participant_answer_5"));      
				  pa.setParticipant_answer_6(rs.getString("participant_answer_6"));        
				  pa.setParticipant_answer_7(rs.getString("participant_answer_7"));        
				  pa.setParticipant_answer_8(rs.getString("participant_answer_8"));        
				  pa.setParticipant_answer_9(rs.getString("participant_answer_9"));        
				  pa.setParticipant_answer_10(rs.getString("participant_answer_10"));       
				  pa.setParticipant_answer_11(rs.getString("participant_answer_11"));       
				  pa.setParticipant_answer_12(rs.getString("participant_answer_12"));       
				  pa.setParticipant_answer_13(rs.getString("participant_answer_13"));       
				  pa.setParticipant_answer_14(rs.getString("participant_answer_14"));       
				  pa.setParticipant_answer_15(rs.getString("participant_answer_15"));       
				  pa.setParticipant_answer_16(rs.getString("participant_answer_16"));       
				  pa.setParticipant_answer_17(rs.getString("participant_answer_17"));       
				  pa.setParticipant_answer_18(rs.getString("participant_answer_18"));       
				  pa.setParticipant_answer_19(rs.getString("participant_answer_19"));       
				  pa.setParticipant_answer_20(rs.getString("participant_answer_20"));       
				  pa.setParticipant_answer_21(rs.getString("participant_answer_21"));       
				  pa.setParticipant_answer_22(rs.getString("participant_answer_22"));       
				  pa.setParticipant_answer_23(rs.getString("participant_answer_23"));       
				  pa.setParticipant_answer_24(rs.getString("participant_answer_24"));       
				  pa.setParticipant_answer_25(rs.getString("participant_answer_25"));       
				  pa.setParticipant_answer_26(rs.getString("participant_answer_26"));       
				  pa.setParticipant_answer_27(rs.getString("participant_answer_27"));       
				  pa.setParticipant_answer_28(rs.getString("participant_answer_28"));       
				  pa.setParticipant_answer_29(rs.getString("participant_answer_29"));       
				  pa.setParticipant_answer_30(rs.getString("participant_answer_30"));       
				  pa.setAnswer_correctness_1(rs.getString("answer_correctness_1"));        
				  pa.setAnswer_correctness_2(rs.getString("answer_correctness_2"));        
				  pa.setAnswer_correctness_3(rs.getString("answer_correctness_3"));        
				  pa.setAnswer_correctness_4(rs.getString("answer_correctness_4"));        
				  pa.setAnswer_correctness_5(rs.getString("answer_correctness_5"));        
				  pa.setAnswer_correctness_6(rs.getString("answer_correctness_6"));        
				  pa.setAnswer_correctness_7(rs.getString("answer_correctness_7"));        
				  pa.setAnswer_correctness_8(rs.getString("answer_correctness_8"));        
				  pa.setAnswer_correctness_9(rs.getString("answer_correctness_9"));        
				  pa.setAnswer_correctness_10(rs.getString("answer_correctness_10"));                
				  pa.setAnswer_correctness_11(rs.getString("answer_correctness_11"));       
				  pa.setAnswer_correctness_12(rs.getString("answer_correctness_12"));       
				  pa.setAnswer_correctness_13(rs.getString("answer_correctness_13"));       
				  pa.setAnswer_correctness_14(rs.getString("answer_correctness_14"));       
				  pa.setAnswer_correctness_15(rs.getString("answer_correctness_15"));       
				  pa.setAnswer_correctness_16(rs.getString("answer_correctness_16"));       
				  pa.setAnswer_correctness_17(rs.getString("answer_correctness_17"));       
				  pa.setAnswer_correctness_18(rs.getString("answer_correctness_18"));       
				  pa.setAnswer_correctness_19(rs.getString("answer_correctness_19"));       
				  pa.setAnswer_correctness_20(rs.getString("answer_correctness_20"));       
				  pa.setAnswer_correctness_21(rs.getString("answer_correctness_21"));       
				  pa.setAnswer_correctness_22(rs.getString("answer_correctness_22"));       
				  pa.setAnswer_correctness_23(rs.getString("answer_correctness_23"));       
				  pa.setAnswer_correctness_24(rs.getString("answer_correctness_24"));       
				  pa.setAnswer_correctness_25(rs.getString("answer_correctness_25"));       
				  pa.setAnswer_correctness_26(rs.getString("answer_correctness_26"));       
				  pa.setAnswer_correctness_27(rs.getString("answer_correctness_27"));       
				  pa.setAnswer_correctness_28(rs.getString("answer_correctness_28"));       
				  pa.setAnswer_correctness_29(rs.getString("answer_correctness_29"));       
				  pa.setAnswer_correctness_30(rs.getString("answer_correctness_30"));       
				  pa.setNumber_of_correct_answers_over_30(rs.getInt("number_of_correct_answers_over_30")); 
				  pa.setTotal_point_over_30(rs.getInt("total_point_over_30"));
				  pa.setNumber_of_correct_answers_over_25(rs.getInt("number_of_correct_answers_over_25")); 
				  pa.setTotal_point_over_25(rs.getInt("total_point_over_25"));              
				                                        
				
				
				participantAnswersInDb.add(pa);
				
				
			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return participantAnswersInDb;
	}
	public List<ParticipantAnswer> getTESTParticipantAnswersByExam(Exam exam) throws SQLException
	{
		String query="Select * From ParticipantAnswerTable where exam_id=? and test_type not in (?,?)";
		List<ParticipantAnswer> participantAnswersInDb=new ArrayList<ParticipantAnswer>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setInt(1, exam.getId());
			st.setString(2, "ON TEST");
			st.setString(3, "SON TEST");
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				ParticipantAnswer pa=new ParticipantAnswer();
				   
					pa.setId(rs.getInt("id"));
				 	pa.setExam_id(rs.getInt("exam_id"));                   
				 	pa.setTest_type(rs.getString("test_type"));                 
				 	pa.setName_surname(rs.getString("name_surname"));              
				 	pa.setFile_name(rs.getString("file_name"));                 
				 	pa.setParticipant_answer_1(rs.getString("participant_answer_1"));      
				 	pa.setParticipant_answer_2(rs.getString("participant_answer_2"));      
				 	pa.setParticipant_answer_3(rs.getString("participant_answer_3"));      
				 	pa.setParticipant_answer_4(rs.getString("participant_answer_4"));      
				 	pa.setParticipant_answer_5(rs.getString("participant_answer_5"));      
				  pa.setParticipant_answer_6(rs.getString("participant_answer_6"));        
				  pa.setParticipant_answer_7(rs.getString("participant_answer_7"));        
				  pa.setParticipant_answer_8(rs.getString("participant_answer_8"));        
				  pa.setParticipant_answer_9(rs.getString("participant_answer_9"));        
				  pa.setParticipant_answer_10(rs.getString("participant_answer_10"));       
				  pa.setParticipant_answer_11(rs.getString("participant_answer_11"));       
				  pa.setParticipant_answer_12(rs.getString("participant_answer_12"));       
				  pa.setParticipant_answer_13(rs.getString("participant_answer_13"));       
				  pa.setParticipant_answer_14(rs.getString("participant_answer_14"));       
				  pa.setParticipant_answer_15(rs.getString("participant_answer_15"));       
				  pa.setParticipant_answer_16(rs.getString("participant_answer_16"));       
				  pa.setParticipant_answer_17(rs.getString("participant_answer_17"));       
				  pa.setParticipant_answer_18(rs.getString("participant_answer_18"));       
				  pa.setParticipant_answer_19(rs.getString("participant_answer_19"));       
				  pa.setParticipant_answer_20(rs.getString("participant_answer_20"));       
				  pa.setParticipant_answer_21(rs.getString("participant_answer_21"));       
				  pa.setParticipant_answer_22(rs.getString("participant_answer_22"));       
				  pa.setParticipant_answer_23(rs.getString("participant_answer_23"));       
				  pa.setParticipant_answer_24(rs.getString("participant_answer_24"));       
				  pa.setParticipant_answer_25(rs.getString("participant_answer_25"));       
				  pa.setParticipant_answer_26(rs.getString("participant_answer_26"));       
				  pa.setParticipant_answer_27(rs.getString("participant_answer_27"));       
				  pa.setParticipant_answer_28(rs.getString("participant_answer_28"));       
				  pa.setParticipant_answer_29(rs.getString("participant_answer_29"));       
				  pa.setParticipant_answer_30(rs.getString("participant_answer_30"));       
				  pa.setAnswer_correctness_1(rs.getString("answer_correctness_1"));        
				  pa.setAnswer_correctness_2(rs.getString("answer_correctness_2"));        
				  pa.setAnswer_correctness_3(rs.getString("answer_correctness_3"));        
				  pa.setAnswer_correctness_4(rs.getString("answer_correctness_4"));        
				  pa.setAnswer_correctness_5(rs.getString("answer_correctness_5"));        
				  pa.setAnswer_correctness_6(rs.getString("answer_correctness_6"));        
				  pa.setAnswer_correctness_7(rs.getString("answer_correctness_7"));        
				  pa.setAnswer_correctness_8(rs.getString("answer_correctness_8"));        
				  pa.setAnswer_correctness_9(rs.getString("answer_correctness_9"));        
				  pa.setAnswer_correctness_10(rs.getString("answer_correctness_10"));                
				  pa.setAnswer_correctness_11(rs.getString("answer_correctness_11"));       
				  pa.setAnswer_correctness_12(rs.getString("answer_correctness_12"));       
				  pa.setAnswer_correctness_13(rs.getString("answer_correctness_13"));       
				  pa.setAnswer_correctness_14(rs.getString("answer_correctness_14"));       
				  pa.setAnswer_correctness_15(rs.getString("answer_correctness_15"));       
				  pa.setAnswer_correctness_16(rs.getString("answer_correctness_16"));       
				  pa.setAnswer_correctness_17(rs.getString("answer_correctness_17"));       
				  pa.setAnswer_correctness_18(rs.getString("answer_correctness_18"));       
				  pa.setAnswer_correctness_19(rs.getString("answer_correctness_19"));       
				  pa.setAnswer_correctness_20(rs.getString("answer_correctness_20"));       
				  pa.setAnswer_correctness_21(rs.getString("answer_correctness_21"));       
				  pa.setAnswer_correctness_22(rs.getString("answer_correctness_22"));       
				  pa.setAnswer_correctness_23(rs.getString("answer_correctness_23"));       
				  pa.setAnswer_correctness_24(rs.getString("answer_correctness_24"));       
				  pa.setAnswer_correctness_25(rs.getString("answer_correctness_25"));       
				  pa.setAnswer_correctness_26(rs.getString("answer_correctness_26"));       
				  pa.setAnswer_correctness_27(rs.getString("answer_correctness_27"));       
				  pa.setAnswer_correctness_28(rs.getString("answer_correctness_28"));       
				  pa.setAnswer_correctness_29(rs.getString("answer_correctness_29"));       
				  pa.setAnswer_correctness_30(rs.getString("answer_correctness_30"));       
				  pa.setNumber_of_correct_answers_over_30(rs.getInt("number_of_correct_answers_over_30")); 
				  pa.setTotal_point_over_30(rs.getInt("total_point_over_30"));
				  pa.setNumber_of_correct_answers_over_25(rs.getInt("number_of_correct_answers_over_25")); 
				  pa.setTotal_point_over_25(rs.getInt("total_point_over_25"));               
				                                        
				
				
				participantAnswersInDb.add(pa);
				
				
			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return participantAnswersInDb;
	}
	public Exam getExamById(int id) throws SQLException
	{
		String query="Select * From ExamTable where id=?";
		
		Exam p=null;
		
		try 
		{
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setInt(1, (int)id);
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				p=new Exam();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setOn1(rs.getString("on1"));
				p.setOn2(rs.getString("on2"));
				p.setOn3(rs.getString("on3"));
				p.setOn4(rs.getString("on4"));
				p.setOn5(rs.getString("on5"));
				p.setOn6(rs.getString("on6"));
				p.setOn7(rs.getString("on7"));
				p.setOn8(rs.getString("on8"));
				p.setOn9(rs.getString("on9"));
				p.setOn10(rs.getString("on10"));
				p.setOn11(rs.getString("on11"));
				p.setOn12(rs.getString("on12"));
				p.setOn13(rs.getString("on13"));
				p.setOn14(rs.getString("on14"));
				p.setOn15(rs.getString("on15"));
				p.setOn16(rs.getString("on16"));
				p.setOn17(rs.getString("on17"));
				p.setOn18(rs.getString("on18"));
				p.setOn19(rs.getString("on19"));
				p.setOn20(rs.getString("on20"));
				p.setOn21(rs.getString("on21"));
				p.setOn22(rs.getString("on22"));
				p.setOn23(rs.getString("on23"));
				p.setOn24(rs.getString("on24"));
				p.setOn25(rs.getString("on25"));
				p.setOn26(rs.getString("on26"));
				p.setOn27(rs.getString("on27"));
				p.setOn28(rs.getString("on28"));
				p.setOn29(rs.getString("on29"));
				p.setOn30(rs.getString("on30"));
				p.setSon1(rs.getString("son1"));
				p.setSon2(rs.getString("son2"));
				p.setSon3(rs.getString("son3"));
				p.setSon4(rs.getString("son4"));
				p.setSon5(rs.getString("son5"));
				p.setSon6(rs.getString("son6"));
				p.setSon7(rs.getString("son7"));
				p.setSon8(rs.getString("son8"));
				p.setSon9(rs.getString("son9"));
				p.setSon10(rs.getString("son10"));
				p.setSon11(rs.getString("son11"));
				p.setSon12(rs.getString("son12"));
				p.setSon13(rs.getString("son13"));
				p.setSon14(rs.getString("son14"));
				p.setSon15(rs.getString("son15"));
				p.setSon16(rs.getString("son16"));
				p.setSon17(rs.getString("son17"));
				p.setSon18(rs.getString("son18"));
				p.setSon19(rs.getString("son19"));
				p.setSon20(rs.getString("son20"));
				p.setSon21(rs.getString("son21"));
				p.setSon22(rs.getString("son22"));
				p.setSon23(rs.getString("son23"));
				p.setSon24(rs.getString("son24"));
				p.setSon25(rs.getString("son25"));
				p.setSon26(rs.getString("son26"));
				p.setSon27(rs.getString("son27"));
				p.setSon28(rs.getString("son28"));
				p.setSon29(rs.getString("son29"));
				p.setSon30(rs.getString("son30"));
				
			
			}
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			if(con!=null)
			{
				con.close();
			}
		
		}
		return p;
	}
	
	public int deleteExamById(int id) throws SQLException
	{
		this.deleteParticipantAnswersByExamId(id);
		String query="Delete From ExamTable where id=?";
		
		int result=0;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setInt(1, id);
			result=st.executeUpdate();
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return result;
	}
	
	public int deleteParticipantAnswerById(int id) throws SQLException
	{
		String query="Delete From ParticipantAnswerTable where id=?";
		
		int result=0;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setInt(1, id);
			result=st.executeUpdate();
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return result;
	}
	public int deleteParticipantAnswersByExamId(int exam_id) throws SQLException
	{
		String query="Delete From ParticipantAnswerTable where exam_id=?";
		
		int result=0;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			
			st.setInt(1, exam_id);
			
			result=st.executeUpdate();
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return result;
	}
	public int deleteParticipantAnswersByExamIdAndTestType(int exam_id,String test_type) throws SQLException
	{
		String query="Delete From ParticipantAnswerTable where exam_id=? and test_type=?";
		
		int result=0;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			
			st.setInt(1, exam_id);
			st.setString(2, test_type);
			result=st.executeUpdate();
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return result;
	}
	
	public int insertIntoParticipantAnswerTable(ParticipantAnswer pa) throws SQLException
	{
		
		
		String query1="Insert into ParticipantAnswerTable "
				+ "("
				+ "exam_id,"
				+ "test_type,"
				+ "name_surname,"
				+ "file_name,"
				+ "participant_answer_1,"
				+ "participant_answer_2,"
				+ "participant_answer_3,"
				+ "participant_answer_4,"
				+ "participant_answer_5,"
				+ "participant_answer_6,"
				+ "participant_answer_7,"
				+ "participant_answer_8,"
				+ "participant_answer_9,"
				+ "participant_answer_10,"
				+ "participant_answer_11,"
				+ "participant_answer_12,"
				+ "participant_answer_13,"
				+ "participant_answer_14,"
				+ "participant_answer_15,"
				+ "participant_answer_16,"
				+ "participant_answer_17,"
				+ "participant_answer_18,"
				+ "participant_answer_19,"
				+ "participant_answer_20,"
				+ "participant_answer_21,"
				+ "participant_answer_22,"
				+ "participant_answer_23,"
				+ "participant_answer_24,"
				+ "participant_answer_25,"
				+ "participant_answer_26,"
				+ "participant_answer_27,"
				+ "participant_answer_28,"
				+ "participant_answer_29,"
				+ "participant_answer_30,"
				+ "answer_correctness_1,"
				+ "answer_correctness_2,"
				+ "answer_correctness_3,"
				+ "answer_correctness_4,"
				+ "answer_correctness_5,"
				+ "answer_correctness_6,"
				+ "answer_correctness_7,"
				+ "answer_correctness_8,"
				+ "answer_correctness_9,"
				+ "answer_correctness_10,"
				+ "answer_correctness_11,"
				+ "answer_correctness_12,"
				+ "answer_correctness_13,"
				+ "answer_correctness_14,"
				+ "answer_correctness_15,"
				+ "answer_correctness_16,"
				+ "answer_correctness_17,"
				+ "answer_correctness_18,"
				+ "answer_correctness_19,"
				+ "answer_correctness_20,"
				+ "answer_correctness_21,"
				+ "answer_correctness_22,"
				+ "answer_correctness_23,"
				+ "answer_correctness_24,"
				+ "answer_correctness_25,"
				+ "answer_correctness_26,"
				+ "answer_correctness_27,"
				+ "answer_correctness_28,"
				+ "answer_correctness_29,"
				+ "answer_correctness_30,"
				+"number_of_correct_answers_over_30," 
				+"total_point_over_30,"
				+"number_of_correct_answers_over_25,"
				+"total_point_over_25" 
				+ ")"
				+ "values ("
				+ "?,"  //exam_id
				+ "?,"	//test_type
				+ "?,"	//name_surname
				+ "?,"	//file_name
				+ "?,"	//participant_answer_1
				+ "?,"	//participant_answer_2
				+ "?,"	//participant_answer_3
				+ "?,"	//participant_answer_4
				+ "?,"	//participant_answer_5
				+ "?,"	//participant_answer_6
				+ "?,"	//participant_answer_7
				+ "?,"	//participant_answer_8
				+ "?,"	//participant_answer_9
				+ "?,"	//participant_answer_10
				+ "?,"	//participant_answer_11
				+ "?,"	//participant_answer_12
				+ "?,"	//participant_answer_13
				+ "?,"	//participant_answer_14
				+ "?,"	//participant_answer_15
				+ "?,"	//participant_answer_16
				+ "?,"	//participant_answer_17
				+ "?,"	//participant_answer_18
				+ "?,"	//participant_answer_19
				+ "?,"	//participant_answer_20
				+ "?,"	//participant_answer_21
				+ "?,"	//participant_answer_22
				+ "?,"	//participant_answer_23
				+ "?,"	//participant_answer_24
				+ "?,"	//participant_answer_25
				+ "?,"	//participant_answer_26
				+ "?,"	//participant_answer_27
				+ "?,"	//participant_answer_28
				+ "?,"	//participant_answer_29
				+ "?,"	//participant_answer_30
				+ "?,"	//answer_correctness_1
				+ "?,"	//answer_correctness_2
				+ "?,"	//answer_correctness_3
				+ "?,"	//answer_correctness_4
				+ "?,"	//answer_correctness_5
				+ "?,"	//answer_correctness_6
				+ "?,"	//answer_correctness_7
				+ "?,"	//answer_correctness_8
				+ "?,"	//answer_correctness_9
				+ "?,"	//answer_correctness_10
				+ "?,"	//answer_correctness_11
				+ "?,"	//answer_correctness_12
				+ "?,"	//answer_correctness_13
				+ "?,"	//answer_correctness_14
				+ "?,"	//answer_correctness_15
				+ "?,"	//answer_correctness_16
				+ "?,"	//answer_correctness_17
				+ "?,"	//answer_correctness_18
				+ "?,"	//answer_correctness_19
				+ "?,"	//answer_correctness_20
				+ "?,"	//answer_correctness_21
				+ "?,"	//answer_correctness_22
				+ "?,"	//answer_correctness_23
				+ "?,"	//answer_correctness_24
				+ "?,"	//answer_correctness_25
				+ "?,"	//answer_correctness_26
				+ "?,"	//answer_correctness_27
				+ "?,"	//answer_correctness_28
				+ "?,"	//answer_correctness_29
				+ "?,"	//answer_correctness_30
				+ "?,"	//number_of_correct_answers_over_30
				+ "?,"	//total_point_over_30
				+ "?,"	//number_of_correct_answers_over_25
				+ "?"	//total_point_over_25
				+ ")";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setInt(1, 		pa.getExam_id());
			st1.setString(2, 	pa.getTest_type());
			st1.setString(3, 	pa.getName_surname());
			st1.setString(4, 	pa.getFile_name());
			st1.setString(5, 	pa.getParticipant_answer_1());
			st1.setString(6, 	pa.getParticipant_answer_2());
			st1.setString(7, 	pa.getParticipant_answer_3());
			st1.setString(8, 	pa.getParticipant_answer_4());
			st1.setString(9, 	pa.getParticipant_answer_5());
			st1.setString(10, pa.getParticipant_answer_6());
			st1.setString(11, pa.getParticipant_answer_7());
			st1.setString(12, pa.getParticipant_answer_8());
			st1.setString(13, pa.getParticipant_answer_9());
			st1.setString(14, pa.getParticipant_answer_10());
			st1.setString(15, pa.getParticipant_answer_11());
			st1.setString(16, pa.getParticipant_answer_12());
			st1.setString(17, pa.getParticipant_answer_13());
			st1.setString(18, pa.getParticipant_answer_14());
			st1.setString(19, pa.getParticipant_answer_15());
			st1.setString(20, pa.getParticipant_answer_16());
			st1.setString(21, pa.getParticipant_answer_17());
			st1.setString(22, pa.getParticipant_answer_18());
			st1.setString(23, pa.getParticipant_answer_19());
			st1.setString(24, pa.getParticipant_answer_20());
			st1.setString(25, pa.getParticipant_answer_21());
			st1.setString(26, pa.getParticipant_answer_22());
			st1.setString(27, pa.getParticipant_answer_23());
			st1.setString(28, pa.getParticipant_answer_24());
			st1.setString(29, pa.getParticipant_answer_25());
			st1.setString(30, pa.getParticipant_answer_26());
			st1.setString(31, pa.getParticipant_answer_27());
			st1.setString(32, pa.getParticipant_answer_28());
			st1.setString(33, pa.getParticipant_answer_29());
			st1.setString(34, pa.getParticipant_answer_30());
			st1.setString(35, pa.getAnswer_correctness_1());
			st1.setString(36, pa.getAnswer_correctness_2());
			st1.setString(37, pa.getAnswer_correctness_3());
			st1.setString(38, pa.getAnswer_correctness_4());
			st1.setString(39, pa.getAnswer_correctness_5());
			st1.setString(40, pa.getAnswer_correctness_6());
			st1.setString(41, pa.getAnswer_correctness_7());
			st1.setString(42, pa.getAnswer_correctness_8());
			st1.setString(43, pa.getAnswer_correctness_9());
			st1.setString(44, pa.getAnswer_correctness_10());
			st1.setString(45, pa.getAnswer_correctness_11());
			st1.setString(46, pa.getAnswer_correctness_12());
			st1.setString(47, pa.getAnswer_correctness_13());
			st1.setString(48, pa.getAnswer_correctness_14());
			st1.setString(49, pa.getAnswer_correctness_15());
			st1.setString(50, pa.getAnswer_correctness_16());
			st1.setString(51, pa.getAnswer_correctness_17());
			st1.setString(52, pa.getAnswer_correctness_18());
			st1.setString(53, pa.getAnswer_correctness_19());
			st1.setString(54, pa.getAnswer_correctness_20());
			st1.setString(55, pa.getAnswer_correctness_21());
			st1.setString(56, pa.getAnswer_correctness_22());
			st1.setString(57, pa.getAnswer_correctness_23());
			st1.setString(58, pa.getAnswer_correctness_24());
			st1.setString(59, pa.getAnswer_correctness_25());
			st1.setString(60, pa.getAnswer_correctness_26());
			st1.setString(61, pa.getAnswer_correctness_27());
			st1.setString(62, pa.getAnswer_correctness_28());
			st1.setString(63, pa.getAnswer_correctness_29());
			st1.setString(64, pa.getAnswer_correctness_30());
			st1.setInt(65, 		pa.getNumber_of_correct_answers_over_30());
			st1.setInt(66, 		pa.getTotal_point_over_30());
			st1.setInt(67, 		pa.getNumber_of_correct_answers_over_25());
			st1.setInt(68, 		pa.getTotal_point_over_25());
			
			result=st1.executeUpdate();
			
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally 
		{
			if(con!=null)
			{
				con.close();
			}
		}
		
		return result;
		
	}
	public int insertIntoExamTable(Exam exam) throws SQLException
	{
		
		
		String query1="Insert into ExamTable "
				+ "("
				+ "name,"
				+ "on1,"
				+ "on2,"
				+ "on3,"
				+ "on4,"
				+ "on5,"
				+ "on6,"
				+ "on7,"
				+ "on8,"
				+ "on9,"
				+ "on10,"
				+ "on11,"
				+ "on12,"
				+ "on13,"
				+ "on14,"
				+ "on15,"
				+ "on16,"
				+ "on17,"
				+ "on18,"
				+ "on19,"
				+ "on20,"
				+ "on21,"
				+ "on22,"
				+ "on23,"
				+ "on24,"
				+ "on25,"
				+ "on26,"
				+ "on27,"
				+ "on28,"
				+ "on29,"
				+ "on30,"
				+ "son1,"
				+ "son2,"
				+ "son3,"
				+ "son4,"
				+ "son5,"
				+ "son6,"
				+ "son7,"
				+ "son8,"
				+ "son9,"
				+ "son10,"
				+ "son11,"
				+ "son12,"
				+ "son13,"
				+ "son14,"
				+ "son15,"
				+ "son16,"
				+ "son17,"
				+ "son18,"
				+ "son19,"
				+ "son20,"
				+ "son21,"
				+ "son22,"
				+ "son23,"
				+ "son24,"
				+ "son25,"
				+ "son26,"
				+ "son27,"
				+ "son28,"
				+ "son29,"
				+ "son30"
				+ ")"
				+ "values "
				+ "("
				+ "?,?,?,?,?,"
				+ "?,?,?,?,?,"
				+ "?,?,?,?,?,"
				+ "?,?,?,?,?,"
				+ "?,?,?,?,?,"
				+ "?,?,?,?,?,"
				+ "?,?,?,?,?,"
				+ "?,?,?,?,?,"
				+ "?,?,?,?,?,"
				+ "?,?,?,?,?,"
				+ "?,?,?,?,?,"
				+ "?,?,?,?,?,"
				+ "?"
				+ ")";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setString(1, exam.getName());
			st1.setString(2, exam.getOn1());
			st1.setString(3, exam.getOn2());
			st1.setString(4, exam.getOn3());
			st1.setString(5, exam.getOn4());
			st1.setString(6, exam.getOn5());
			st1.setString(7, exam.getOn6());
			st1.setString(8, exam.getOn7());
			st1.setString(9, exam.getOn8());
			st1.setString(10, exam.getOn9());
			st1.setString(11, exam.getOn10());
			st1.setString(12, exam.getOn11());
			st1.setString(13, exam.getOn12());
			st1.setString(14, exam.getOn13());
			st1.setString(15, exam.getOn14());
			st1.setString(16, exam.getOn15());
			st1.setString(17, exam.getOn16());
			st1.setString(18, exam.getOn17());
			st1.setString(19, exam.getOn18());
			st1.setString(20, exam.getOn19());
			st1.setString(21, exam.getOn20());
			st1.setString(22, exam.getOn21());
			st1.setString(23, exam.getOn22());
			st1.setString(24, exam.getOn23());
			st1.setString(25, exam.getOn24());
			st1.setString(26, exam.getOn25());
			st1.setString(27, exam.getOn26());
			st1.setString(28, exam.getOn27());
			st1.setString(29, exam.getOn28());
			st1.setString(30, exam.getOn29());
			st1.setString(31, exam.getOn30());
			st1.setString(32, exam.getSon1());
			st1.setString(33, exam.getSon2());
			st1.setString(34, exam.getSon3());
			st1.setString(35, exam.getSon4());
			st1.setString(36, exam.getSon5());
			st1.setString(37, exam.getSon6());
			st1.setString(38, exam.getSon7());
			st1.setString(39, exam.getSon8());
			st1.setString(40, exam.getSon9());
			st1.setString(41, exam.getSon10());
			st1.setString(42, exam.getSon11());
			st1.setString(43, exam.getSon12());
			st1.setString(44, exam.getSon13());
			st1.setString(45, exam.getSon14());
			st1.setString(46, exam.getSon15());
			st1.setString(47, exam.getSon16());
			st1.setString(48, exam.getSon17());
			st1.setString(49, exam.getSon18());
			st1.setString(50, exam.getSon19());
			st1.setString(51, exam.getSon20());
			st1.setString(52, exam.getSon21());
			st1.setString(53, exam.getSon22());
			st1.setString(54, exam.getSon23());
			st1.setString(55, exam.getSon24());
			st1.setString(56, exam.getSon25());
			st1.setString(57, exam.getSon26());
			st1.setString(58, exam.getSon27());
			st1.setString(59, exam.getSon28());
			st1.setString(60, exam.getSon29());
			st1.setString(61, exam.getSon30());
			
			

			result=st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
		}
		
		return result;
		
	}
	
	public int updateParticipantAnswer(ParticipantAnswer pa) throws SQLException
	{

		
		
		String query1="Update ParticipantAnswerTable "
				+ "Set "
				+ "test_type=?,"
				+ "name_surname=?,"
				+ "participant_answer_1=?,"
				+ "participant_answer_2=?,"
				+ "participant_answer_3=?,"
				+ "participant_answer_4=?,"
				+ "participant_answer_5=?,"
				+ "participant_answer_6=?,"
				+ "participant_answer_7=?,"
				+ "participant_answer_8=?,"
				+ "participant_answer_9=?,"
				+ "participant_answer_10=?,"
				+ "participant_answer_11=?,"
				+ "participant_answer_12=?,"
				+ "participant_answer_13=?,"
				+ "participant_answer_14=?,"
				+ "participant_answer_15=?,"
				+ "participant_answer_16=?,"
				+ "participant_answer_17=?,"
				+ "participant_answer_18=?,"
				+ "participant_answer_19=?,"
				+ "participant_answer_20=?,"
				+ "participant_answer_21=?,"
				+ "participant_answer_22=?,"
				+ "participant_answer_23=?,"
				+ "participant_answer_24=?,"
				+ "participant_answer_25=?,"
				+ "participant_answer_26=?,"
				+ "participant_answer_27=?,"
				+ "participant_answer_28=?,"
				+ "participant_answer_29=?,"
				+ "participant_answer_30=?,"
				+ "answer_correctness_1=?,"
				+ "answer_correctness_2=?,"
				+ "answer_correctness_3=?,"
				+ "answer_correctness_4=?,"
				+ "answer_correctness_5=?,"
				+ "answer_correctness_6=?,"
				+ "answer_correctness_7=?,"
				+ "answer_correctness_8=?,"
				+ "answer_correctness_9=?,"
				+ "answer_correctness_10=?,"
				+ "answer_correctness_11=?,"
				+ "answer_correctness_12=?,"
				+ "answer_correctness_13=?,"
				+ "answer_correctness_14=?,"
				+ "answer_correctness_15=?,"
				+ "answer_correctness_16=?,"
				+ "answer_correctness_17=?,"
				+ "answer_correctness_18=?,"
				+ "answer_correctness_19=?,"
				+ "answer_correctness_20=?,"
				+ "answer_correctness_21=?,"
				+ "answer_correctness_22=?,"
				+ "answer_correctness_23=?,"
				+ "answer_correctness_24=?,"
				+ "answer_correctness_25=?,"
				+ "answer_correctness_26=?,"
				+ "answer_correctness_27=?,"
				+ "answer_correctness_28=?,"
				+ "answer_correctness_29=?,"
				+ "answer_correctness_30=?,"
				+ "number_of_correct_answers_over_30=?,"
				+ "total_point_over_30=?,"
				+ "number_of_correct_answers_over_25=?,"
				+ "total_point_over_25=?"
				+ "where id=?";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			
			
			st1.setString(1, pa.getTest_type());
			st1.setString(2, pa.getName_surname());
			st1.setString(3, pa.getParticipant_answer_1());
			st1.setString(4, pa.getParticipant_answer_2());
			st1.setString(5, pa.getParticipant_answer_3());
			st1.setString(6, pa.getParticipant_answer_4());
			st1.setString(7, pa.getParticipant_answer_5());
			st1.setString(8, pa.getParticipant_answer_6());
			st1.setString(9, pa.getParticipant_answer_7());
			st1.setString(10, pa.getParticipant_answer_8());
			st1.setString(11, pa.getParticipant_answer_9());
			st1.setString(12, pa.getParticipant_answer_10());
			st1.setString(13, pa.getParticipant_answer_11());
			st1.setString(14, pa.getParticipant_answer_12());
			st1.setString(15, pa.getParticipant_answer_13());
			st1.setString(16, pa.getParticipant_answer_14());
			st1.setString(17, pa.getParticipant_answer_15());
			st1.setString(18, pa.getParticipant_answer_16());
			st1.setString(19, pa.getParticipant_answer_17());
			st1.setString(20, pa.getParticipant_answer_18());
			st1.setString(21, pa.getParticipant_answer_19());
			st1.setString(22, pa.getParticipant_answer_20());
			st1.setString(23, pa.getParticipant_answer_21());
			st1.setString(24, pa.getParticipant_answer_22());
			st1.setString(25, pa.getParticipant_answer_23());
			st1.setString(26, pa.getParticipant_answer_24());
			st1.setString(27, pa.getParticipant_answer_25());
			st1.setString(28, pa.getParticipant_answer_26());
			st1.setString(29, pa.getParticipant_answer_27());
			st1.setString(30, pa.getParticipant_answer_28());
			st1.setString(31, pa.getParticipant_answer_29());
			st1.setString(32, pa.getParticipant_answer_30());
			st1.setString(33, pa.getAnswer_correctness_1());
			st1.setString(34, pa.getAnswer_correctness_2());
			st1.setString(35, pa.getAnswer_correctness_3());
			st1.setString(36, pa.getAnswer_correctness_4());
			st1.setString(37, pa.getAnswer_correctness_5());
			st1.setString(38, pa.getAnswer_correctness_6());
			st1.setString(39, pa.getAnswer_correctness_7());
			st1.setString(40, pa.getAnswer_correctness_8());
			st1.setString(41, pa.getAnswer_correctness_9());
			st1.setString(42, pa.getAnswer_correctness_10());
			st1.setString(43, pa.getAnswer_correctness_11());
			st1.setString(44, pa.getAnswer_correctness_12());
			st1.setString(45, pa.getAnswer_correctness_13());
			st1.setString(46, pa.getAnswer_correctness_14());
			st1.setString(47, pa.getAnswer_correctness_15());
			st1.setString(48, pa.getAnswer_correctness_16());
			st1.setString(49, pa.getAnswer_correctness_17());
			st1.setString(50, pa.getAnswer_correctness_18());
			st1.setString(51, pa.getAnswer_correctness_19());
			st1.setString(52, pa.getAnswer_correctness_20());
			st1.setString(53, pa.getAnswer_correctness_21());
			st1.setString(54, pa.getAnswer_correctness_22());
			st1.setString(55, pa.getAnswer_correctness_23());
			st1.setString(56, pa.getAnswer_correctness_24());
			st1.setString(57, pa.getAnswer_correctness_25());
			st1.setString(58, pa.getAnswer_correctness_26());
			st1.setString(59, pa.getAnswer_correctness_27());
			st1.setString(60, pa.getAnswer_correctness_28());
			st1.setString(61, pa.getAnswer_correctness_29());
			st1.setString(62, pa.getAnswer_correctness_30());
			st1.setInt(63, pa.getNumber_of_correct_answers_over_30());
			st1.setInt(64, pa.getTotal_point_over_30());
			st1.setInt(65, pa.getNumber_of_correct_answers_over_25());
			st1.setInt(66, pa.getTotal_point_over_25());
			st1.setInt(67, pa.getId());
			
			result=st1.executeUpdate();
		
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally 
		{
			if(con!=null)
			{
				con.close();
			}
		}
		return result;
		
	}
	
	

	public int updateExam(Exam exam) throws SQLException
	{

		
		
		String query1="Update ExamTable "
				+ "set "
				+ "name=?,"
				+ "on1=?,"
				+ "on2=?,"
				+ "on3=?,"
				+ "on4=?,"
				+ "on5=?,"
				+ "on6=?,"
				+ "on7=?,"
				+ "on8=?,"
				+ "on9=?,"
				+ "on10=?,"
				+ "on11=?,"
				+ "on12=?,"
				+ "on13=?,"
				+ "on14=?,"
				+ "on15=?,"
				+ "on16=?,"
				+ "on17=?,"
				+ "on18=?,"
				+ "on19=?,"
				+ "on20=?,"
				+ "on21=?,"
				+ "on22=?,"
				+ "on23=?,"
				+ "on24=?,"
				+ "on25=?,"
				+ "on26=?,"
				+ "on27=?,"
				+ "on28=?,"
				+ "on29=?,"
				+ "on30=?,"
				+ "son1=?,"
				+ "son2=?,"
				+ "son3=?,"
				+ "son4=?,"
				+ "son5=?,"
				+ "son6=?,"
				+ "son7=?,"
				+ "son8=?,"
				+ "son9=?,"
				+ "son10=?,"
				+ "son11=?,"
				+ "son12=?,"
				+ "son13=?,"
				+ "son14=?,"
				+ "son15=?,"
				+ "son16=?,"
				+ "son17=?,"
				+ "son18=?,"
				+ "son19=?,"
				+ "son20=?,"
				+ "son21=?,"
				+ "son22=?,"
				+ "son23=?,"
				+ "son24=?,"
				+ "son25=?,"
				+ "son26=?,"
				+ "son27=?,"
				+ "son28=?,"
				+ "son29=?,"
				+ "son30=?"
				+ " where id=?";
		
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			
			
			st1.setString(1, exam.getName());
			st1.setString(2, exam.getOn1());
			st1.setString(3, exam.getOn2());
			st1.setString(4, exam.getOn3());
			st1.setString(5, exam.getOn4());
			st1.setString(6, exam.getOn5());
			st1.setString(7, exam.getOn6());
			st1.setString(8, exam.getOn7());
			st1.setString(9, exam.getOn8());
			st1.setString(10, exam.getOn9());
			st1.setString(11, exam.getOn10());
			st1.setString(12, exam.getOn11());
			st1.setString(13, exam.getOn12());
			st1.setString(14, exam.getOn13());
			st1.setString(15, exam.getOn14());
			st1.setString(16, exam.getOn15());
			st1.setString(17, exam.getOn16());
			st1.setString(18, exam.getOn17());
			st1.setString(19, exam.getOn18());
			st1.setString(20, exam.getOn19());
			st1.setString(21, exam.getOn20());
			st1.setString(22, exam.getOn21());
			st1.setString(23, exam.getOn22());
			st1.setString(24, exam.getOn23());
			st1.setString(25, exam.getOn24());
			st1.setString(26, exam.getOn25());
			st1.setString(27, exam.getOn26());
			st1.setString(28, exam.getOn27());
			st1.setString(29, exam.getOn28());
			st1.setString(30, exam.getOn29());
			st1.setString(31, exam.getOn30());
			st1.setString(32, exam.getSon1());
			st1.setString(33, exam.getSon2());
			st1.setString(34, exam.getSon3());
			st1.setString(35, exam.getSon4());
			st1.setString(36, exam.getSon5());
			st1.setString(37, exam.getSon6());
			st1.setString(38, exam.getSon7());
			st1.setString(39, exam.getSon8());
			st1.setString(40, exam.getSon9());
			st1.setString(41, exam.getSon10());
			st1.setString(42, exam.getSon11());
			st1.setString(43, exam.getSon12());
			st1.setString(44, exam.getSon13());
			st1.setString(45, exam.getSon14());
			st1.setString(46, exam.getSon15());
			st1.setString(47, exam.getSon16());
			st1.setString(48, exam.getSon17());
			st1.setString(49, exam.getSon18());
			st1.setString(50, exam.getSon19());
			st1.setString(51, exam.getSon20());
			st1.setString(52, exam.getSon21());
			st1.setString(53, exam.getSon22());
			st1.setString(54, exam.getSon23());
			st1.setString(55, exam.getSon24());
			st1.setString(56, exam.getSon25());
			st1.setString(57, exam.getSon26());
			st1.setString(58, exam.getSon27());
			st1.setString(59, exam.getSon28());
			st1.setString(60, exam.getSon29());
			st1.setString(61, exam.getSon30());
			st1.setInt(62, exam.getId());
			
			result=st1.executeUpdate();
		
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally 
		{
			if(con!=null)
			{
				con.close();
			}
		}
		return result;
		
	}
	
	
	
	public void createDefaultSettingsTable() throws SQLException
	{

		String query1="";
		if(className.equals(MySqlClassName))
		{
			query1="Create table DefaultSettingsTable" +
					"(" 
					+"id integer primary key, "
					+ "tesseract_data_path text, "
					+ "tesseract_language text, "
					+ "tesseract_page_seg_mode int,"
					+ "tesseract_ocr_engine_mode int,"
					+ "min_area_threshold_for_noise_for_title int,"
					+ "min_area_threshold_for_noise_for_table int,"
					+ "x_start int,"
					+ "y_start int,"
					+ "width_percentage_to_be_cut int,"
					+ "height_percentage_to_be_cut int,"
					+ "white_ratio_limit_value double int,"
					+ "row_number int,"
					+ "column_number int,"
					+ "dont_read_first_row int,"
					+ "dont_read_first_column int,"
					+ "erosion_degree int,"
					+ "dilation_degree int,"
					+ "horizontal_kernel_length_division_factor int,"
					+ "vertical_kernel_length_division_factor int,"
					+ "horizontal_erosion_iteration_number int,"
					+ "vertical_erosion_iteration_number int,"
					+ "horizontal_dilation_iteration_number int,"
					+ "vertical_dilation_iteration_number int,"
					+ "max_y_dif_for_intersection_points int,"
					+ "cell_mat_width_crop_degree_factor int,"
					+ "margin_x_left int,"
					+ "margin_x_right int,"
					+ "margin_y_up int,"
					+ "margin_y_down int,"
					+ "near_words text,"
					+ "resized_width_for_title int,"					
					+ "resized_height_for_title int,"					
					+ "resized_width_for_table int,"					
					+ "resized_height_for_table int,"
					+ "draw_contours_thickness_for_title int,"
					+ "draw_contours_thickness_for_table int,"
					+ "cell_mat_downscale_factor int"
					+ ");";
		}
		else if(className.equals(MariaDBClassName))
		{
			query1="Create table DefaultSettingsTable" +
					"(" 
					+"id integer primary key, "
					+ "tesseract_data_path text, "
					+ "tesseract_language text, "
					+ "tesseract_page_seg_mode int,"
					+ "tesseract_ocr_engine_mode int,"
					+ "min_area_threshold_for_noise_for_title int,"
					+ "min_area_threshold_for_noise_for_table int,"
					+ "x_start int,"
					+ "y_start int,"
					+ "width_percentage_to_be_cut int,"
					+ "height_percentage_to_be_cut int,"
					+ "white_ratio_limit_value double int,"
					+ "row_number int,"
					+ "column_number int,"
					+ "dont_read_first_row int,"
					+ "dont_read_first_column int,"
					+ "erosion_degree int,"
					+ "dilation_degree int,"
					+ "horizontal_kernel_length_division_factor int,"
					+ "vertical_kernel_length_division_factor int,"
					+ "horizontal_erosion_iteration_number int,"
					+ "vertical_erosion_iteration_number int,"
					+ "horizontal_dilation_iteration_number int,"
					+ "vertical_dilation_iteration_number int,"
					+ "max_y_dif_for_intersection_points int,"
					+ "cell_mat_width_crop_degree_factor int,"
					+ "margin_x_left int,"
					+ "margin_x_right int,"
					+ "margin_y_up int,"
					+ "margin_y_down int,"
					+ "near_words text,"
					+ "resized_width_for_title int,"					
					+ "resized_height_for_title int,"					
					+ "resized_width_for_table int,"					
					+ "resized_height_for_table int,"
					+ "draw_contours_thickness_for_title int,"
					+ "draw_contours_thickness_for_table int,"
					+ "cell_mat_downscale_factor int"
					+ ");";
		}
		else if(className.equals(SqliteDBClassName))
		{
			query1="Create table DefaultSettingsTable" +
					"(" 
					+"id integer primary key, "
					+ "tesseract_data_path text, "
					+ "tesseract_language text, "
					+ "tesseract_page_seg_mode int,"
					+ "tesseract_ocr_engine_mode int,"
					+ "min_area_threshold_for_noise_for_title int,"
					+ "min_area_threshold_for_noise_for_table int,"
					+ "x_start int,"
					+ "y_start int,"
					+ "width_percentage_to_be_cut int,"
					+ "height_percentage_to_be_cut int,"
					+ "white_ratio_limit_value double int,"
					+ "row_number int,"
					+ "column_number int,"
					+ "dont_read_first_row int,"
					+ "dont_read_first_column int,"
					+ "erosion_degree int,"
					+ "dilation_degree int,"
					+ "horizontal_kernel_length_division_factor int,"
					+ "vertical_kernel_length_division_factor int,"
					+ "horizontal_erosion_iteration_number int,"
					+ "vertical_erosion_iteration_number int,"
					+ "horizontal_dilation_iteration_number int,"
					+ "vertical_dilation_iteration_number int,"
					+ "max_y_dif_for_intersection_points int,"
					+ "cell_mat_width_crop_degree_factor int,"
					+ "margin_x_left int,"
					+ "margin_x_right int,"
					+ "margin_y_up int,"
					+ "margin_y_down int,"
					+ "near_words text,"
					+ "resized_width_for_title int,"					
					+ "resized_height_for_title int,"					
					+ "resized_width_for_table int,"					
					+ "resized_height_for_table int,"
					+ "draw_contours_thickness_for_title int,"
					+ "draw_contours_thickness_for_table int,"
					+ "cell_mat_downscale_factor int"
					+ ");";
		}
		else if(className.equals(PostgreClassName))
		{
			query1="Create table DefaultSettingsTable" +
					"(" 
					+"id integer primary key, "
					+ "tesseract_data_path text, "
					+ "tesseract_language text, "
					+ "tesseract_page_seg_mode int,"
					+ "tesseract_ocr_engine_mode int,"
					+ "min_area_threshold_for_noise_for_title int,"
					+ "min_area_threshold_for_noise_for_table int,"
					+ "x_start int,"
					+ "y_start int,"
					+ "width_percentage_to_be_cut int,"
					+ "height_percentage_to_be_cut int,"
					+ "white_ratio_limit_value double int,"
					+ "row_number int,"
					+ "column_number int,"
					+ "dont_read_first_row int,"
					+ "dont_read_first_column int,"
					+ "erosion_degree int,"
					+ "dilation_degree int,"
					+ "horizontal_kernel_length_division_factor int,"
					+ "vertical_kernel_length_division_factor int,"
					+ "horizontal_erosion_iteration_number int,"
					+ "vertical_erosion_iteration_number int,"
					+ "horizontal_dilation_iteration_number int,"
					+ "vertical_dilation_iteration_number int,"
					+ "max_y_dif_for_intersection_points int,"
					+ "cell_mat_width_crop_degree_factor int,"
					+ "margin_x_left int,"
					+ "margin_x_right int,"
					+ "margin_y_up int,"
					+ "margin_y_down int,"
					+ "near_words text,"
					+ "resized_width_for_title int,"					
					+ "resized_height_for_title int,"					
					+ "resized_width_for_table int,"					
					+ "resized_height_for_table int,"
					+ "draw_contours_thickness_for_title int,"
					+ "draw_contours_thickness_for_table int,"
					+ "cell_mat_downscale_factor int"
					+ ");";
			
		}
                
		
		
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
	}
	public void createPreferredSettingsTable() throws SQLException
	{

		String query1="";
		if(className.equals(MySqlClassName))
		{
			query1="Create table PreferredSettingsTable" +
					"(" 
					+"id integer primary key, "
					+ "tesseract_data_path text, "
					+ "tesseract_language text, "
					+ "tesseract_page_seg_mode int,"
					+ "tesseract_ocr_engine_mode int,"
					+ "min_area_threshold_for_noise_for_title int,"
					+ "min_area_threshold_for_noise_for_table int,"
					+ "x_start int,"
					+ "y_start int,"
					+ "width_percentage_to_be_cut int,"
					+ "height_percentage_to_be_cut int,"
					+ "white_ratio_limit_value double int,"
					+ "row_number int,"
					+ "column_number int,"
					+ "dont_read_first_row int,"
					+ "dont_read_first_column int,"
					+ "erosion_degree int,"
					+ "dilation_degree int,"
					+ "horizontal_kernel_length_division_factor int,"
					+ "vertical_kernel_length_division_factor int,"
					+ "horizontal_erosion_iteration_number int,"
					+ "vertical_erosion_iteration_number int,"
					+ "horizontal_dilation_iteration_number int,"
					+ "vertical_dilation_iteration_number int,"
					+ "max_y_dif_for_intersection_points int,"
					+ "cell_mat_width_crop_degree_factor int,"
					+ "margin_x_left int,"
					+ "margin_x_right int,"
					+ "margin_y_up int,"
					+ "margin_y_down int,"
					+ "near_words text,"
					+ "resized_width_for_title int,"					
					+ "resized_height_for_title int,"					
					+ "resized_width_for_table int,"					
					+ "resized_height_for_table int,"
					+ "draw_contours_thickness_for_title int,"
					+ "draw_contours_thickness_for_table int,"
					+ "cell_mat_downscale_factor int"
					+ ");";
		}
		else if(className.equals(MariaDBClassName))
		{
			query1="Create table PreferredSettingsTable" +
					"(" 
					+"id integer primary key, "
					+ "tesseract_data_path text, "
					+ "tesseract_language text, "
					+ "tesseract_page_seg_mode int,"
					+ "tesseract_ocr_engine_mode int,"
					+ "min_area_threshold_for_noise_for_title int,"
					+ "min_area_threshold_for_noise_for_table int,"
					+ "x_start int,"
					+ "y_start int,"
					+ "width_percentage_to_be_cut int,"
					+ "height_percentage_to_be_cut int,"
					+ "white_ratio_limit_value double int,"
					+ "row_number int,"
					+ "column_number int,"
					+ "dont_read_first_row int,"
					+ "dont_read_first_column int,"
					+ "erosion_degree int,"
					+ "dilation_degree int,"
					+ "horizontal_kernel_length_division_factor int,"
					+ "vertical_kernel_length_division_factor int,"
					+ "horizontal_erosion_iteration_number int,"
					+ "vertical_erosion_iteration_number int,"
					+ "horizontal_dilation_iteration_number int,"
					+ "vertical_dilation_iteration_number int,"
					+ "max_y_dif_for_intersection_points int,"
					+ "cell_mat_width_crop_degree_factor int,"
					+ "margin_x_left int,"
					+ "margin_x_right int,"
					+ "margin_y_up int,"
					+ "margin_y_down int,"
					+ "near_words text,"
					+ "resized_width_for_title int,"					
					+ "resized_height_for_title int,"					
					+ "resized_width_for_table int,"					
					+ "resized_height_for_table int,"
					+ "draw_contours_thickness_for_title int,"
					+ "draw_contours_thickness_for_table int,"
					+ "cell_mat_downscale_factor int"
					+ ");";
		}
		else if(className.equals(SqliteDBClassName))
		{
			query1="Create table PreferredSettingsTable" +
					"(" 
					+"id integer primary key , "
					+ "tesseract_data_path text, "
					+ "tesseract_language text, "
					+ "tesseract_page_seg_mode int,"
					+ "tesseract_ocr_engine_mode int,"
					+ "min_area_threshold_for_noise_for_title int,"
					+ "min_area_threshold_for_noise_for_table int,"
					+ "x_start int,"
					+ "y_start int,"
					+ "width_percentage_to_be_cut int,"
					+ "height_percentage_to_be_cut int,"
					+ "white_ratio_limit_value double int,"
					+ "row_number int,"
					+ "column_number int,"
					+ "dont_read_first_row int,"
					+ "dont_read_first_column int,"
					+ "erosion_degree int,"
					+ "dilation_degree int,"
					+ "horizontal_kernel_length_division_factor int,"
					+ "vertical_kernel_length_division_factor int,"
					+ "horizontal_erosion_iteration_number int,"
					+ "vertical_erosion_iteration_number int,"
					+ "horizontal_dilation_iteration_number int,"
					+ "vertical_dilation_iteration_number int,"
					+ "max_y_dif_for_intersection_points int,"
					+ "cell_mat_width_crop_degree_factor int,"
					+ "margin_x_left int,"
					+ "margin_x_right int,"
					+ "margin_y_up int,"
					+ "margin_y_down int,"
					+ "near_words text,"
					+ "resized_width_for_title int,"					
					+ "resized_height_for_title int,"					
					+ "resized_width_for_table int,"					
					+ "resized_height_for_table int,"
					+ "draw_contours_thickness_for_title int,"
					+ "draw_contours_thickness_for_table int,"
					+ "cell_mat_downscale_factor int"
					+ ");";
		}
		else if(className.equals(PostgreClassName))
		{
			query1="Create table PreferredSettingsTable" +
					"(" 
					+"id integer primary key, "
					+ "tesseract_data_path text, "
					+ "tesseract_language text, "
					+ "tesseract_page_seg_mode int,"
					+ "tesseract_ocr_engine_mode int,"
					+ "min_area_threshold_for_noise_for_title int,"
					+ "min_area_threshold_for_noise_for_table int,"
					+ "x_start int,"
					+ "y_start int,"
					+ "width_percentage_to_be_cut int,"
					+ "height_percentage_to_be_cut int,"
					+ "white_ratio_limit_value double int,"
					+ "row_number int,"
					+ "column_number int,"
					+ "dont_read_first_row int,"
					+ "dont_read_first_column int,"
					+ "erosion_degree int,"
					+ "dilation_degree int,"
					+ "horizontal_kernel_length_division_factor int,"
					+ "vertical_kernel_length_division_factor int,"
					+ "horizontal_erosion_iteration_number int,"
					+ "vertical_erosion_iteration_number int,"
					+ "horizontal_dilation_iteration_number int,"
					+ "vertical_dilation_iteration_number int,"
					+ "max_y_dif_for_intersection_points int,"
					+ "cell_mat_width_crop_degree_factor int,"
					+ "margin_x_left int,"
					+ "margin_x_right int,"
					+ "margin_y_up int,"
					+ "margin_y_down int,"
					+ "near_words text,"
					+ "resized_width_for_title int,"					
					+ "resized_height_for_title int,"					
					+ "resized_width_for_table int,"					
					+ "resized_height_for_table int,"
					+ "draw_contours_thickness_for_title int,"
					+ "draw_contours_thickness_for_table int,"
					+ "cell_mat_downscale_factor int"
					+ ");";
			
		}
                
		
		
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
	}
	public int insertIntoDefaultSettingsTable() throws SQLException
	{
				String os = System.getProperty("os.name").toLowerCase();
				String tessdataPath="";
				if (os.contains("win")) 
				 {
				    
				    Path klasorYolu = Paths.get("C:/Program Files/Tesseract-OCR/tessdata");

			        if (Files.exists(klasorYolu) && Files.isDirectory(klasorYolu)) 
			        {
			            tessdataPath="C:/Program Files/Tesseract-OCR/tessdata";
			        } 
			        else 
			        {
			            tessdataPath=System.getProperty("user.home")
			            				+"/AppData/Local/Tesseract-OCR/tessdata";
			        }
				 } 
				 else if (os.contains("mac")) 
				 {
				     

				 } 
				 else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) 
				 {
				     // Linux / Unix
					 tessdataPath="/usr/share/tesseract-ocr/5/tessdata";
					 
				 }
				
				String query1="Insert into DefaultSettingsTable "
						+ "("
						+ "id,"											//1
						+ "tesseract_data_path," 						//2
						+ "tesseract_language,"	 						//3
						+ "tesseract_page_seg_mode," 					//4
						+ "tesseract_ocr_engine_mode," 					//5
						+ "min_area_threshold_for_noise_for_title,"  	//6
						+ "min_area_threshold_for_noise_for_table,"  	//7
						+ "x_start,"									//8
						+ "y_start,"									//9
						+ "width_percentage_to_be_cut,"					//10
						+ "height_percentage_to_be_cut,"				//11
						+ "white_ratio_limit_value,"					//12
						+ "row_number,"									//13
						+ "column_number,"								//14
						+ "dont_read_first_row,"						//15
						+ "dont_read_first_column,"						//16
						+ "erosion_degree,"								//17
						+ "dilation_degree,"							//18
						+ "horizontal_kernel_length_division_factor,"	//19
						+ "vertical_kernel_length_division_factor,"		//20
						+ "horizontal_erosion_iteration_number,"		//21
						+ "vertical_erosion_iteration_number,"			//22
						+ "horizontal_dilation_iteration_number,"		//23
						+ "vertical_dilation_iteration_number,"			//24
						+ "max_y_dif_for_intersection_points,"			//25
						+ "cell_mat_width_crop_degree_factor,"			//26
						+ "margin_x_left,"								//27
						+ "margin_x_right,"								//28
						+ "margin_y_up,"								//29
						+ "margin_y_down,"								//30
						+ "near_words,"									//31
						+ "resized_width_for_title,"					//32										
						+ "resized_height_for_title,"					//33					
						+ "resized_width_for_table,"					//34				
						+ "resized_height_for_table,"					//35
						+ "draw_contours_thickness_for_title,"			//36
						+ "draw_contours_thickness_for_table,"			//37
						+ "cell_mat_downscale_factor"					//38
						+ ")"
						+ "values ("
						+ "?,"  //1
						+ "?,"	//2
						+ "?,"	//3
						+ "?,"	//4
						+ "?,"	//5
						+ "?,"	//6
						+ "?,"	//7
						+ "?,"	//8
						+ "?,"	//9
						+ "?,"	//10
						+ "?,"	//11
						+ "?,"	//12
						+ "?,"	//13
						+ "?,"	//14
						+ "?,"	//15
						+ "?,"	//16
						+ "?,"	//17
						+ "?,"	//18
						+ "?,"	//19
						+ "?,"	//20
						+ "?,"	//21
						+ "?,"	//22
						+ "?,"	//23
						+ "?,"	//24
						+ "?,"	//25
						+ "?,"	//26
						+ "?,"	//27
						+ "?,"	//28
						+ "?,"	//29
						+ "?,"	//30
						+ "?,"	//31
						+ "?,"	//32
						+ "?,"	//33
						+ "?,"	//34
						+ "?,"	//35
						+ "?,"	//36
						+ "?,"	//37
						+"?"	//38
						+ ")";
				int result=-1;
				try {
				//Class.forName(className);
				//con = DriverManager.getConnection(url);
				//con = DriverManager.getConnection(url,uname,pass);
				con=getCon();
				PreparedStatement st1= con.prepareStatement(query1);
				st1.setInt(1, 1);
				st1.setString(2, tessdataPath);
				st1.setString(3, "eng");
				st1.setInt(4, 11);
				st1.setInt(5, 1);
				st1.setInt(6, 75);
				st1.setInt(7, 100);
				st1.setInt(8, 0);
				st1.setInt(9, 0);
				st1.setInt(10, 100);
				st1.setInt(11, 20);
				st1.setInt(12, 200);
				st1.setInt(13, 31);
				st1.setInt(14, 5);
				st1.setInt(15, 1);
				st1.setInt(16, 1);
				st1.setInt(17, 1);
				st1.setInt(18, 1);
				st1.setInt(19, 32);
				st1.setInt(20, 32);
				st1.setInt(21, 1);
				st1.setInt(22, 1);
				st1.setInt(23, 1);
				st1.setInt(24, 1);
				st1.setInt(25, 5);
				st1.setInt(26, 20);
				st1.setInt(27, 0);
				st1.setInt(28, 0);
				st1.setInt(29, 0);
				st1.setInt(30, 0);
				st1.setString(31, "İSİM-SOYİSİM");
				st1.setInt(32, 3120);
				st1.setInt(33, 4160);
				st1.setInt(34, 3120);
				st1.setInt(35, 4160);
				st1.setInt(36, -1);
				st1.setInt(37, -1);
				st1.setInt(38, 65);
				
				result=st1.executeUpdate();
				
				} 
				catch (ClassNotFoundException e) 
				{
				// TODO Auto-generated catch block
				e.printStackTrace();
				} 
				catch (SQLException e) 
				{
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				}
				finally 
				{
				if(con!=null)
				{
				con.close();
				}
				}
				
				return result;
				
	}
	public int insertIntoPreferredSettingsTable(DefaultSettings ds) throws SQLException
			{
			
			
		String query1="Insert into PreferredSettingsTable "
				+ "("
				+ "id,"											//1
				+ "tesseract_data_path," 						//2
				+ "tesseract_language,"	 						//3
				+ "tesseract_page_seg_mode," 					//4
				+ "tesseract_ocr_engine_mode," 					//5
				+ "min_area_threshold_for_noise_for_title,"  	//6
				+ "min_area_threshold_for_noise_for_table,"  	//7
				+ "x_start,"									//8
				+ "y_start,"									//9
				+ "width_percentage_to_be_cut,"					//10
				+ "height_percentage_to_be_cut,"				//11
				+ "white_ratio_limit_value,"					//12
				+ "row_number,"									//13
				+ "column_number,"								//14
				+ "dont_read_first_row,"						//15
				+ "dont_read_first_column,"						//16
				+ "erosion_degree,"								//17
				+ "dilation_degree,"							//18
				+ "horizontal_kernel_length_division_factor,"	//19
				+ "vertical_kernel_length_division_factor,"		//20
				+ "horizontal_erosion_iteration_number,"		//21
				+ "vertical_erosion_iteration_number,"			//22
				+ "horizontal_dilation_iteration_number,"		//23
				+ "vertical_dilation_iteration_number,"			//24
				+ "max_y_dif_for_intersection_points,"			//25
				+ "cell_mat_width_crop_degree_factor,"			//26
				+ "margin_x_left,"								//27
				+ "margin_x_right,"								//28
				+ "margin_y_up,"								//29
				+ "margin_y_down,"								//30
				+ "near_words,"									//31
				+ "resized_width_for_title,"					//32										
				+ "resized_height_for_title,"					//33					
				+ "resized_width_for_table,"					//34				
				+ "resized_height_for_table,"					//35
				+ "draw_contours_thickness_for_title,"			//36
				+ "draw_contours_thickness_for_table,"			//37
				+ "cell_mat_downscale_factor"					//38
				+ ")"
				+ "values ("
				+ "?,"  //1
				+ "?,"	//2
				+ "?,"	//3
				+ "?,"	//4
				+ "?,"	//5
				+ "?,"	//6
				+ "?,"	//7
				+ "?,"	//8
				+ "?,"	//9
				+ "?,"	//10
				+ "?,"	//11
				+ "?,"	//12
				+ "?,"	//13
				+ "?,"	//14
				+ "?,"	//15
				+ "?,"	//16
				+ "?,"	//17
				+ "?,"	//18
				+ "?,"	//19
				+ "?,"	//20
				+ "?,"	//21
				+ "?,"	//22
				+ "?,"	//23
				+ "?,"	//24
				+ "?,"	//25
				+ "?,"	//26
				+ "?,"	//27
				+ "?,"	//28
				+ "?,"	//29
				+ "?,"	//30
				+ "?,"	//31
				+ "?,"	//32
				+ "?,"	//33
				+ "?,"	//34
				+ "?,"	//35
				+ "?,"	//36
				+ "?,"	//37
				+"?"	//38
				+ ")";
			int result=-1;
			try {
			//Class.forName(className);
			//con = DriverManager.getConnection(url);
			//con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setInt(1, 1);
			st1.setString(2, ds.getTesseract_data_path());
			st1.setString(3, ds.getTesseract_language());
			st1.setInt(4, ds.getTesseract_page_seg_mode());
			st1.setInt(5, ds.getTesseract_ocr_engine_mode());
			st1.setInt(6, ds.getMin_area_threshold_for_noise_for_title());
			st1.setInt(7, ds.getMin_area_threshold_for_noise_for_table());
			st1.setInt(8, ds.getX_start());
			st1.setInt(9, ds.getY_start());
			st1.setInt(10, ds.getWidth_percentage_to_be_cut());
			st1.setInt(11, ds.getHeight_percentage_to_be_cut());
			st1.setInt(12, ds.getWhite_ratio_limit_value());
			st1.setInt(13, ds.getRow_number());
			st1.setInt(14, ds.getColumn_number());
			st1.setInt(15, ds.getDont_read_first_row());
			st1.setInt(16, ds.getDont_read_first_column());
			st1.setInt(17, ds.getErosion_degree());
			st1.setInt(18, ds.getDilation_degree());
			st1.setInt(19, ds.getHorizontal_kernel_length_division_factor());
			st1.setInt(20, ds.getVertical_kernel_length_division_factor());
			st1.setInt(21, ds.getHorizontal_erosion_iteration_number());
			st1.setInt(22, ds.getVertical_erosion_iteration_number());
			st1.setInt(23, ds.getHorizontal_dilation_iteration_number());
			st1.setInt(24, ds.getVertical_dilation_iteration_number());
			st1.setInt(25, ds.getMax_y_dif_for_intersection_points());
			st1.setInt(26, ds.getCell_mat_width_crop_degree_factor());
			st1.setInt(27, ds.getMargin_x_left());
			st1.setInt(28, ds.getMargin_x_right());
			st1.setInt(29, ds.getMargin_y_up());
			st1.setInt(30, ds.getMargin_y_down());
			st1.setString(31, ds.getNearWords());
			st1.setInt(32, ds.getResized_width_for_title());
			st1.setInt(33, ds.getResized_height_for_title());
			st1.setInt(34, ds.getResized_width_for_table());
			st1.setInt(35, ds.getResized_height_for_table());
			st1.setInt(36, ds.getDraw_contours_thickness_for_title());
			st1.setInt(37, ds.getDraw_contours_thickness_for_table());
			st1.setInt(38, ds.getCell_mat_downscale_factor());
			result=st1.executeUpdate();
			
			} 
			catch (ClassNotFoundException e) 
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			} 
			catch (SQLException e) 
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			}
			finally 
			{
			if(con!=null)
			{
			con.close();
			}
			}
			
			return result;
			
	}
	public int insertIntoPreferredSettingsTable(PreferredSettings ps) throws SQLException
	{
	
	
			String query1="Insert into PreferredSettingsTable "
					+ "("
					+ "id,"											//1
					+ "tesseract_data_path," 						//2
					+ "tesseract_language,"	 						//3
					+ "tesseract_page_seg_mode," 					//4
					+ "tesseract_ocr_engine_mode," 					//5
					+ "min_area_threshold_for_noise_for_title,"  	//6
					+ "min_area_threshold_for_noise_for_table,"  	//7
					+ "x_start,"									//8
					+ "y_start,"									//9
					+ "width_percentage_to_be_cut,"					//10
					+ "height_percentage_to_be_cut,"				//11
					+ "white_ratio_limit_value,"					//12
					+ "row_number,"									//13
					+ "column_number,"								//14
					+ "dont_read_first_row,"						//15
					+ "dont_read_first_column,"						//16
					+ "erosion_degree,"								//17
					+ "dilation_degree,"							//18
					+ "horizontal_kernel_length_division_factor,"	//19
					+ "vertical_kernel_length_division_factor,"		//20
					+ "horizontal_erosion_iteration_number,"		//21
					+ "vertical_erosion_iteration_number,"			//22
					+ "horizontal_dilation_iteration_number,"		//23
					+ "vertical_dilation_iteration_number,"			//24
					+ "max_y_dif_for_intersection_points,"			//25
					+ "cell_mat_width_crop_degree_factor,"			//26
					+ "margin_x_left,"								//27
					+ "margin_x_right,"								//28
					+ "margin_y_up,"								//29
					+ "margin_y_down,"								//30
					+ "near_words,"									//31
					+ "resized_width_for_title,"					//32										
					+ "resized_height_for_title,"					//33					
					+ "resized_width_for_table,"					//34			
					+ "resized_height_for_table,"					//35
					+ "draw_contours_thickness_for_title,"			//36
					+ "draw_contours_thickness_for_table,"			//37
					+ "cell_mat_downscale_factor"					//38
					+ ")"
					+ "values ("
					+ "?,"  //1
					+ "?,"	//2
					+ "?,"	//3
					+ "?,"	//4
					+ "?,"	//5
					+ "?,"	//6
					+ "?,"	//7
					+ "?,"	//8
					+ "?,"	//9
					+ "?,"	//10
					+ "?,"	//11
					+ "?,"	//12
					+ "?,"	//13
					+ "?,"	//14
					+ "?,"	//15
					+ "?,"	//16
					+ "?,"	//17
					+ "?,"	//18
					+ "?,"	//19
					+ "?,"	//20
					+ "?,"	//21
					+ "?,"	//22
					+ "?,"	//23
					+ "?,"	//24
					+ "?,"	//25
					+ "?,"	//26
					+ "?,"	//27
					+ "?,"	//28
					+ "?,"	//29
					+ "?,"	//30
					+ "?,"	//31
					+ "?,"	//32
					+ "?,"	//33
					+ "?,"	//34
					+ "?,"	//35
					+ "?,"	//36
					+ "?,"	//37
					+"?"	//38
					+ ")";
				int result=-1;
				try {
				//Class.forName(className);
				//con = DriverManager.getConnection(url);
				//con = DriverManager.getConnection(url,uname,pass);
				con=getCon();
				PreparedStatement st1= con.prepareStatement(query1);
				st1.setInt(1, 1);
				st1.setString(2, ps.getTesseract_data_path());
				st1.setString(3, ps.getTesseract_language());
				st1.setInt(4, ps.getTesseract_page_seg_mode());
				st1.setInt(5, ps.getTesseract_ocr_engine_mode());
				st1.setInt(6, ps.getMin_area_threshold_for_noise_for_title());
				st1.setInt(7, ps.getMin_area_threshold_for_noise_for_table());
				st1.setInt(8, ps.getX_start());
				st1.setInt(9, ps.getY_start());
				st1.setInt(10, ps.getWidth_percentage_to_be_cut());
				st1.setInt(11, ps.getHeight_percentage_to_be_cut());
				st1.setInt(12, ps.getWhite_ratio_limit_value());
				st1.setInt(13, ps.getRow_number());
				st1.setInt(14, ps.getColumn_number());
				st1.setInt(15, ps.getDont_read_first_row());
				st1.setInt(16, ps.getDont_read_first_column());
				st1.setInt(17, ps.getErosion_degree());
				st1.setInt(18, ps.getDilation_degree());
				st1.setInt(19, ps.getHorizontal_kernel_length_division_factor());
				st1.setInt(20, ps.getVertical_kernel_length_division_factor());
				st1.setInt(21, ps.getHorizontal_erosion_iteration_number());
				st1.setInt(22, ps.getVertical_erosion_iteration_number());
				st1.setInt(23, ps.getHorizontal_dilation_iteration_number());
				st1.setInt(24, ps.getVertical_dilation_iteration_number());
				st1.setInt(25, ps.getMax_y_dif_for_intersection_points());
				st1.setInt(26, ps.getCell_mat_width_crop_degree_factor());
				st1.setInt(27, ps.getMargin_x_left());
				st1.setInt(28, ps.getMargin_x_right());
				st1.setInt(29, ps.getMargin_y_up());
				st1.setInt(30, ps.getMargin_y_down());
				st1.setString(31, ps.getNearWords());
				st1.setInt(32, ps.getResized_width_for_title());
				st1.setInt(33, ps.getResized_height_for_title());
				st1.setInt(34, ps.getResized_width_for_table());
				st1.setInt(35, ps.getResized_height_for_table());
				st1.setInt(36, ps.getDraw_contours_thickness_for_title());
				st1.setInt(37, ps.getDraw_contours_thickness_for_table());
				st1.setInt(38, ps.getCell_mat_downscale_factor());
				
				result=st1.executeUpdate();
				
				} 
				catch (ClassNotFoundException e) 
				{
				// TODO Auto-generated catch block
				e.printStackTrace();
				} 
				catch (SQLException e) 
				{
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				}
				finally 
				{
				if(con!=null)
				{
				con.close();
				}
				}
				
				return result;
	
}
	public int clearDefaultSettingsTable() throws SQLException 
	{
		String query1="Delete From DefaultSettingsTable";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			result= st1.executeUpdate();
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
		return result;
		
	}
	public int clearPreferredSettingsTable() throws SQLException 
	{
		String query1="Delete From PreferredSettingsTable";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			result= st1.executeUpdate();
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
		return result;
		
	}
	public int dropExamTable() throws SQLException 
	{
		String query1="Drop Table ExamTable";
		int result=-1;
		try 
		{
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			result= st1.executeUpdate();
			
		
		} 
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		finally 
		{
			if(con!=null)
			{
				con.close();
			}
		
		}
		
		return result;
		
	}
	public int dropParticipantAnswerTable() throws SQLException 
	{
		String query1="Drop Table ParticipantAnswerTable";
		int result=-1;
		try 
		{
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			result= st1.executeUpdate();
			
		
		} 
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		finally 
		{
			if(con!=null)
			{
				con.close();
			}
		
		}
		
		return result;
		
	}
	
	public int clearProgramTables() throws SQLException 
	{ 
		int result=1;
		int r1=-1;
		int r2=-1;
		int r3=-1;
		int r4=-1;
		int r5=-1;
		
		try 
		{
			r1=dropExamTable();
			
			
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		if(r1<result)
		{
			result=r1;
		}
		try 
		{
			r2=dropParticipantAnswerTable();
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		if(r2<result)
		{
			result=r2;
		}
		try 
		{
			r4=createExamTable();
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		if(r4<result)
		{
			result=r4;
		}
		try 
		{
			r5=createParticipantAnswerTable();
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		if(r5<result)
		{
			result=r5;
		}
		
		
		return result;
		
	}
	
	public DefaultSettings getDefaultSettings() throws SQLException
	{
		String query="Select * From DefaultSettingsTable where id=1";
		DefaultSettings p=new DefaultSettings();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				p.setY_start(rs
						.getInt("x_start")); 										
				p.setY_start(rs
						.getInt("y_start")); 										
				p.setWidth_percentage_to_be_cut(rs
						.getInt("width_percentage_to_be_cut"));
				p.setHeight_percentage_to_be_cut(rs
						.getInt("height_percentage_to_be_cut"));
				p.setWhite_ratio_limit_value(rs
						.getInt("white_ratio_limit_value"));
				p.setVertical_kernel_length_division_factor(rs
						.getInt("vertical_kernel_length_division_factor"));
				p.setHorizontal_kernel_length_division_factor(rs
						.getInt("horizontal_kernel_length_division_factor"));
				p.setHorizontal_erosion_iteration_number(rs
						.getInt("horizontal_erosion_iteration_number"));
				p.setVertical_erosion_iteration_number(rs
						.getInt("vertical_erosion_iteration_number"));
				p.setHorizontal_dilation_iteration_number(rs
						.getInt("horizontal_dilation_iteration_number"));
				p.setVertical_dilation_iteration_number(rs
						.getInt("vertical_dilation_iteration_number"));
				p.setTesseract_page_seg_mode(rs
						.getInt("tesseract_page_seg_mode"));
				p.setTesseract_ocr_engine_mode(rs
						.getInt("tesseract_ocr_engine_mode"));
				p.setTesseract_data_path(rs
						.getString("tesseract_data_path"));
				p.setTesseract_language(rs
						.getString("tesseract_language"));
				p.setRow_number(rs
						.getInt("row_number"));
				p.setColumn_number(rs
						.getInt("column_number"));
				p.setErosion_degree(rs
						.getInt("erosion_degree"));
				p.setDilation_degree(rs
						.getInt("dilation_degree"));
				p.setCell_mat_width_crop_degree_factor(rs
						.getInt("cell_mat_width_crop_degree_factor"));
				p.setDont_read_first_column(rs
						.getInt("dont_read_first_column"));
				p.setDont_read_first_row(rs
						.getInt("dont_read_first_row"));
				p.setMargin_x_left(rs
						.getInt("margin_x_left"));
				p.setMargin_x_right(rs
						.getInt("margin_x_right"));
				p.setMargin_y_up(rs
						.getInt("margin_y_up"));
				p.setMargin_y_down(rs
						.getInt("margin_y_down"));
				p.setMax_y_dif_for_intersection_points(rs
						.getInt("max_y_dif_for_intersection_points"));
				p.setMin_area_threshold_for_noise_for_title(rs
						.getInt("min_area_threshold_for_noise_for_title"));
				p.setMin_area_threshold_for_noise_for_table(rs
						.getInt("min_area_threshold_for_noise_for_table"));
				p.setNearWords(rs
						.getString("near_words"));
				p.setResized_width_for_title(rs.getInt("resized_width_for_title"));
				p.setResized_height_for_title(rs.getInt("resized_height_for_title"));
				p.setResized_width_for_table(rs.getInt("resized_width_for_table"));
				p.setResized_height_for_table(rs.getInt("resized_height_for_table"));
				p.setDraw_contours_thickness_for_title(rs.getInt("draw_contours_thickness_for_title"));
				p.setDraw_contours_thickness_for_table(rs.getInt("draw_contours_thickness_for_table"));
				p.setCell_mat_downscale_factor(rs.getInt("cell_mat_downscale_factor"));
			}
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return p;
	}
	public PreferredSettings getPreferredSettings() throws SQLException
	{
		String query="Select * From PreferredSettingsTable where id=1";
		PreferredSettings p=new PreferredSettings();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				p.setY_start(rs
						.getInt("x_start")); 										
				p.setY_start(rs
						.getInt("y_start")); 										
				p.setWidth_percentage_to_be_cut(rs
						.getInt("width_percentage_to_be_cut"));
				p.setHeight_percentage_to_be_cut(rs
						.getInt("height_percentage_to_be_cut"));
				p.setWhite_ratio_limit_value(rs
						.getInt("white_ratio_limit_value"));
				p.setVertical_kernel_length_division_factor(rs
						.getInt("vertical_kernel_length_division_factor"));
				p.setHorizontal_kernel_length_division_factor(rs
						.getInt("horizontal_kernel_length_division_factor"));
				p.setHorizontal_erosion_iteration_number(rs
						.getInt("horizontal_erosion_iteration_number"));
				p.setVertical_erosion_iteration_number(rs
						.getInt("vertical_erosion_iteration_number"));
				p.setHorizontal_dilation_iteration_number(rs
						.getInt("horizontal_dilation_iteration_number"));
				p.setVertical_dilation_iteration_number(rs
						.getInt("vertical_dilation_iteration_number"));
				p.setTesseract_page_seg_mode(rs
						.getInt("tesseract_page_seg_mode"));
				p.setTesseract_ocr_engine_mode(rs
						.getInt("tesseract_ocr_engine_mode"));
				p.setTesseract_data_path(rs
						.getString("tesseract_data_path"));
				p.setTesseract_language(rs
						.getString("tesseract_language"));
				p.setRow_number(rs
						.getInt("row_number"));
				p.setColumn_number(rs
						.getInt("column_number"));
				p.setErosion_degree(rs
						.getInt("erosion_degree"));
				p.setDilation_degree(rs
						.getInt("dilation_degree"));
				p.setCell_mat_width_crop_degree_factor(rs
						.getInt("cell_mat_width_crop_degree_factor"));
				p.setDont_read_first_column(rs
						.getInt("dont_read_first_column"));
				p.setDont_read_first_row(rs
						.getInt("dont_read_first_row"));
				p.setMargin_x_left(rs
						.getInt("margin_x_left"));
				p.setMargin_x_right(rs
						.getInt("margin_x_right"));
				p.setMargin_y_up(rs
						.getInt("margin_y_up"));
				p.setMargin_y_down(rs
						.getInt("margin_y_down"));
				p.setMax_y_dif_for_intersection_points(rs
						.getInt("max_y_dif_for_intersection_points"));
				p.setMin_area_threshold_for_noise_for_title(rs
						.getInt("min_area_threshold_for_noise_for_title"));
				p.setMin_area_threshold_for_noise_for_table(rs
						.getInt("min_area_threshold_for_noise_for_table"));
				p.setNearWords(rs
						.getString("near_words"));
				p.setResized_width_for_title(rs.getInt("resized_width_for_title"));
				p.setResized_height_for_title(rs.getInt("resized_height_for_title"));
				p.setResized_width_for_table(rs.getInt("resized_width_for_table"));
				p.setResized_height_for_table(rs.getInt("resized_height_for_table"));
				p.setDraw_contours_thickness_for_title(rs.getInt("draw_contours_thickness_for_title"));
				p.setDraw_contours_thickness_for_table(rs.getInt("draw_contours_thickness_for_table"));
				p.setCell_mat_downscale_factor(rs.getInt("cell_mat_downscale_factor"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return p;
	}
	
	
	
	
}
