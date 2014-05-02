package com.example.fieldbook;

import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/*
 * A class file where the database was initialized and defined
 */
public class MySQLiteUserHelper extends SQLiteOpenHelper {

	// Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "DataObjectDB.db";
    //Table Name
    private static final String TABLE_USER = "User";
 /*   private static final String TABLE_DATA = "Data";
    private static final String TABLE_PROPERTY = "Property";
    private static final String TABLE_PROPERTYMETHODASSN = "PropertyMethodAssn";
    private static final String TABLE_METHOD = "Method";
    private static final String TABLE_OUTLIERDATA = "OutlierData";
    private static final String TABLE_DEVICE = "Device";
    private static final String TABLE_VALIDATION = "Validation";
    private static final String TABLE_ORGUNIT = "OrgUnit";
    */
    //For Database declaration
    private SQLiteDatabase db1;
    
    // User Table Column names
    private static final String USER_USERIDNO = "UserIDNo";
    private static final String USER_USERNAME = "Username";
    private static final String USER_PASSWORD = "Password";
    private static final String USER_FIRSTNAME = "FirstName";
    private static final String USER_MIDDLENAME = "MiddleName";
    private static final String USER_LASTNAME = "LastName";
    private static final String USER_ORGUNITID = "OrgUnitID";
    private static final String USER_SEQID = "SeqID";
/*
    // Data Table Column names
    private static final String DATA_DATAID = "DataID";
    private static final String DATA_PROPERTYMETHODASSN = "PropertyMethodAssn";
    private static final String DATA_VALUE = "Value";
    private static final String DATA_USERIDNO = "UserIDNo";
    private static final String DATA_DATETIME = "DateTime";
    private static final String DATA_DEVICEID = "DeviceID";
    private static final String DATA_LONGITUDE = "Longitude";
    private static final String DATA_LATITUDE = "Latitude";
    private static final String DATA_ACTIVE = "Active";
    private static final String DATA_BLOCKED = "Blocked";
    private static final String DATA_SEQID = "SeqID";
    
    // Property Table Column names
    private static final String PROPERTY_PROPERTYID = "PropertyID";
    private static final String PROPERTY_PROPERTYDESCRIPTION = "PropertyDescription";
    private static final String PROPERTY_ACTIVE = "Active";
    private static final String PROPERTY_SEQID = "SeqID";
    
    // PropertyMethodAssn Table Column names
    private static final String PMA_PROPERTYMETHODASSNID = "PropertyMethodAssn";
    private static final String PMA_PROPERTYID= "PropertyID";
    private static final String PMA_METHODID= "MethodID";
    private static final String PMA_VALIDATIONID= "Validation";
    private static final String PMA_SEQID= "SeqID";
    
    // Method Table Column names
    private static final String METHOD_METHODID= "MethodID";
    private static final String METHOD_METHODDESCRIPTION = "MethodDescription";
    private static final String METHOD_ACTIVE = "Active";
    private static final String METHOD_SEQID = "SeqID";
  
    // OutlierData Table Column names
    private static final String OUTLIERDATA_PROPERTYMETHODASSNID= "PropertyMethodAssnID";
    private static final String OUTLIERDATA_VALIDATIONID= "ValidationID";
    private static final String OUTLIERDATA_VALUE= "Value";
    private static final String OUTLIERDATA_SEQID = "SeqID";
    
    // Device Table Column names
    private static final String DEVICE_DEVICEID= "DeviceID";
    private static final String DEVICE_DEVICEDESCRIPTION = "DeviceDescription";
    private static final String DEVICE_ACTIVE = "Active";
    private static final String DEVICE_SEQID = "SeqID";
    
    // Validation Table Column names
    private static final String VALIDATION_VALIDATIONID = "ValidationID";
    private static final String VALIDATION_VALIDATIONDESCRIPTION = "ValidationDescription";
    private static final String VALIDATION_VALIDATIONTYPE= "ValidationType";
    private static final String VALIDATION_VALUES= "Values";
    private static final String VALIDATION_ACTIVE= "Active";
    private static final String VALIDATION_SEQID = "SeqID";
    
    // OrgUnit Table Column names
    private static final String ORGUNIT_ORGUNITID= "OrgUnitID";
    private static final String ORGUNIT_ORGUNITDESCRIPTION = "OrgUnitDescription";
    private static final String ORGUNIT_ORGUNITABBR = "OrgUnitAbbr";
    private static final String ORGUNIT_SEQID = "SeqID";
    */
    //Columns per table
    private static final String[] USER_COLUMNS = {USER_USERIDNO, USER_USERNAME, USER_PASSWORD, USER_FIRSTNAME, 
    											USER_MIDDLENAME, USER_LASTNAME, USER_ORGUNITID, USER_SEQID};
  /*  private static final String[] DATA_COLUMNS = {DATA_DATAID, DATA_PROPERTYMETHODASSN, DATA_VALUE, DATA_USERIDNO, 
    											DATA_DATETIME, DATA_DEVICEID, DATA_LONGITUDE, DATA_LATITUDE, DATA_ACTIVE, 
    											DATA_BLOCKED, DATA_SEQID};
    private static final String[] PROPERTY_COLUMNS = {PROPERTY_PROPERTYID, PROPERTY_PROPERTYDESCRIPTION, PROPERTY_ACTIVE, PROPERTY_SEQID};
    private static final String[] PMA_COLUMNS = {PMA_PROPERTYMETHODASSNID, PMA_PROPERTYID, PMA_METHODID, PMA_VALIDATIONID, PMA_SEQID};
    private static final String[] METHOD_COLUMNS = {METHOD_METHODID, METHOD_METHODDESCRIPTION, METHOD_ACTIVE, METHOD_SEQID};
    private static final String[] OUTLIERDATA_COLUMNS = {OUTLIERDATA_PROPERTYMETHODASSNID, OUTLIERDATA_VALIDATIONID, OUTLIERDATA_VALUE, OUTLIERDATA_SEQID};
    private static final String[] DEVICE_COLUMNS = {DEVICE_DEVICEID, DEVICE_DEVICEDESCRIPTION, DEVICE_ACTIVE, DEVICE_SEQID};
    private static final String[] VALIDATION_COLUMNS = {VALIDATION_VALIDATIONID, VALIDATION_VALIDATIONDESCRIPTION, VALIDATION_VALIDATIONTYPE, 
    											VALIDATION_VALUES, VALIDATION_ACTIVE, VALIDATION_SEQID};
    private static final String[] ORGUNIT_COLUMNS = {ORGUNIT_ORGUNITID, ORGUNIT_ORGUNITDESCRIPTION, ORGUNIT_ORGUNITABBR, ORGUNIT_SEQID};
  */  
    public MySQLiteUserHelper(Context context) { // constructor
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create User table
        String CREATE_USER_TABLE = "CREATE TABLE User ( " +
                "USER_USERIDNO TEXT PRIMARY KEY, " + 
                "USER_USERNAME TEXT,"+
                "USER_PASSWORD TEXT," +
                "USER_FIRSTNAME TEXT,"+
                "USER_MIDDLENAME TEXT,"+
                "USER_LASTNAME TEXT,"+
                "USER_ORGUNITID TEXT,"+
                "USER_SEQID INTEGER UNIQUE)";
  /*      
        // SQL statement to create Data table
        String CREATE_DATA_TABLE = "CREATE TABLE Data ( " +
                "DATA_DATAID TEXT PRIMARY KEY, " + 
                "DATA_PROPERTYMETHODASSN TEXT, "+
                "DATA_VALUE TEXT," +
                "DATA_USERIDNO TEXT,"+
                "DATA_DATETIME TEXT,"+
                "DATA_DEVICEID TEXT,"+
                "DATA_LONGITUDE TEXT,"+
                "DATA_LATITUDE TEXT,"+
                "DATA_ACTIVE TEXT," +
                "DATA_BLOCKED TEXT," +
                "DATA_SEQID INTEGER AUTOINCREMENT)";
        
        // SQL statement to create Property table
        String CREATE_PROPERTY_TABLE = "CREATE TABLE Property ( " +
                "PROPERTY_PROPERTYID TEXT PRIMARY KEY, " + 
                "PROPERTY_PROPERTYDESCRIPTION TEXT, "+
                "PROPERTY_ACTIVE," +
                "PROPERTY_SEQID INTEGER AUTOINCREMENT)";
        
        // SQL statement to create PropertyMethodAssn table
        String CREATE_PMA_TABLE = "CREATE TABLE Property ( " +
                "PMA_PROPERTYMETHODASSNID TEXT PRIMARY KEY, " + 
                "PROPERTY_PROPERTYDESCRIPTION TEXT, "+
                "PMA_ACTIVE TEXT," +
                "PMA_SEQID INTEGER AUTOINCREMENT)";
        
        // SQL statement to create Method table
        String CREATE_METHOD_TABLE = "CREATE TABLE Method ( " +
                "METHOD_METHODID TEXT PRIMARY KEY, " + 
                "METHOD_METHODDESCRIPTION TEXT, "+
                "METHOD_ACTIVE TEXT," +
                "METHOD_SEQID INTEGER AUTOINCREMENT)";
        
        // SQL statement to create OutlierData table
        String CREATE_OUTLIERDATA_TABLE = "CREATE TABLE OutlierData ( " +
                "OUTLIERDATA_PROPERTYMETHODASSNID TEXT PRIMARY KEY, " + 
                "OUTLIERDATA_VALIDATIONID TEXT, "+
                "OUTLIERDATA_VALUE TEXT," +
                "OUTLIER_SEQID INTEGER AUTOINCREMENT)";
        
        // SQL statement to create Device table
        String CREATE_DEVICE_TABLE = "CREATE TABLE Device ( " +
                "DEVICE_DEVICEID TEXT PRIMARY KEY, " + 
                "DEVICE_DEVICEDESCRIPTION TEXT, "+
                "DEVICE_ACTIVE TEXT," +
                "DEVICE_SEQID INTEGER AUTOINCREMENT)";
        
        // SQL statement to create Validation table
        String CREATE_VALIDATION_TABLE = "CREATE TABLE Validation ( " +
                "VALIDATION_VALIDATIONID TEXT PRIMARY KEY, " + 
                "VALIDATION_VALIDATIONDESCRIPTION TEXT, "+
                "VALIDATION_VALIDATIONTYPE TEXT," +
                "VALIDATION_VALUES TEXT," +
                "VALIDATION_ACTIVE TEXT," + 
                "DEVICE_SEQID INTEGER AUTOINCREMENT)";
        
        // SQL statement to create OrgUnit table
        String CREATE_ORGUNIT_TABLE = "CREATE TABLE OrgUnit( " +
                "ORGUNIT_ORGUNITID TEXT PRIMARY KEY, " + 
                "ORGUNIT_DESCRIPTION TEXT, "+
                "ORGUNIT_ORGUNITABBR TEXT," +
                "ORGUNIT_SEQID INTEGER AUTOINCREMENT)";
        
   */     
        this.db1 = db; 
        // create all the tables
        db.execSQL(CREATE_USER_TABLE);
   /*     db.execSQL(CREATE_DATA_TABLE);
        db.execSQL(CREATE_PROPERTY_TABLE);
        db.execSQL(CREATE_PMA_TABLE);
        db.execSQL(CREATE_METHOD_TABLE);
        db.execSQL(CREATE_OUTLIERDATA_TABLE);
        db.execSQL(CREATE_DEVICE_TABLE);
        db.execSQL(CREATE_VALIDATION_TABLE);
        db.execSQL(CREATE_ORGUNIT_TABLE);
     */   
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables if existed
        db.execSQL("DROP TABLE IF EXISTS User");
        // create fresh user table
        this.onCreate(db);
    }
    
    public SQLiteDatabase getDB(){
    	return this.db1;
    }
    
    public void addUser(User User){
        //for logging
    	Log.d("addUser", User.toString()); 

    	// 1. get reference to writable DB
    	SQLiteDatabase db = this.getWritableDatabase();
    	Log.i("TRACE", "umabot dito");
    	// 2. create ContentValues to add key "column"/value
    	ContentValues values = new ContentValues();
		values.put(USER_USERIDNO, User.getUserIDNo());   
		values.put(USER_USERNAME, User.getUsername()); 
		values.put(USER_PASSWORD, User.getPassword());  
		values.put(USER_FIRSTNAME, User.getFirstName()); 
		values.put(USER_MIDDLENAME, User.getMiddleName()); 
		values.put(USER_LASTNAME, User.getLastName());  
		values.put(USER_ORGUNITID, User.getOrgUnitID());
		
		// 3. insert
		db.insert(TABLE_USER, // table
		        null, //nullColumnHack
		        values); // key/value -> keys = column names/ values = column values
		
		// 4. close
		db.close(); 
    	}
    
    public User getUser(String USER_SEQID){
    	 
        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();
     
        // 2. build query
        Cursor cursor = 
                db.query(TABLE_USER, // a. table
                USER_COLUMNS, // b. column names
                " USER_SEQID = ?", // c. selections 
                new String[] { String.valueOf(USER_SEQID) }, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
     
        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build user object
        User User = new User();
        
        User.setUserIDNo(cursor.getString(0));
        User.setUsername(cursor.getString(1));
        User.setPassword(cursor.getString(2));
        User.setFirstName(cursor.getString(3));
        User.setMiddleName(cursor.getString(4));
        User.setLastName(cursor.getString(5));
        User.setOrgUnitID(cursor.getString(6));
        User.setSeqID(Integer.parseInt(cursor.getString(7)));
        
        //log 
        Log.d("getUser("+ USER_SEQID +")", User.toString());
     
        // 5. return User
        return User;
    }
    
    public List<User> getAllUsers() {
        List<User> Users = new LinkedList<User>();
        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_USER;
  
        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
  
        // 3. go over each row, build user and add it to list
        User User = null;
        if (cursor.moveToFirst()) {
            do {
            	User = new User();
            	
            	User.setUserIDNo(cursor.getString(0));
                User.setUsername(cursor.getString(1));
                User.setPassword(cursor.getString(2));
                User.setFirstName(cursor.getString(3));
                User.setMiddleName(cursor.getString(4));
                User.setLastName(cursor.getString(5));
                User.setOrgUnitID(cursor.getString(6));
                User.setSeqID(Integer.parseInt(cursor.getString(7)));
  
                // Add user to users
                Users.add(User);
            } while (cursor.moveToNext());
        }
  
        Log.d("getAllUsers()", User.toString()); //logcat
  
        // return Users
        return Users;
    }
    
    public int updateUser(User User) {
    	 
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
     
        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
		values.put(USER_USERIDNO, User.getUserIDNo());   
		values.put(USER_USERNAME, User.getUsername()); 
		values.put(USER_PASSWORD, User.getPassword());  
		values.put(USER_FIRSTNAME, User.getFirstName()); 
		values.put(USER_MIDDLENAME, User.getMiddleName()); 
		values.put(USER_LASTNAME, User.getLastName());  
		values.put(USER_ORGUNITID, User.getOrgUnitID());
		values.put(USER_SEQID, User.getSeqID()); 
		
        // 3. updating row
        int i = db.update(TABLE_USER, //table
                values, // column/value
                USER_SEQID+" = ?", // selections
                new String[] { String.valueOf(User.getSeqID()) }); //selection args
     
        // 4. close
        db.close();
     
        return i;
    }
    
    public void deleteUser(User User) {
    	 
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
 
        // 2. delete
        db.delete(TABLE_USER, //table name
                USER_SEQID+ " = ?",  // selections
                new String[] { String.valueOf(User.getSeqID()) }); //selections args
 
        // 3. close
        db.close();
 
        //log
        Log.d("deleteUser", User.toString());
    }
    
    public boolean Login(String USER_USERNAME, String USER_PASSWORD) throws SQLException{ // validation if the user input a valid account
    	SQLiteDatabase db = this.getWritableDatabase();
    	Cursor mCursor = db.rawQuery("SELECT * FROM " + TABLE_USER + " WHERE USER_USERNAME = ? AND USER_PASSWORD = ?", new String[]{USER_USERNAME, USER_PASSWORD});
    		if (mCursor != null) {
    			if(mCursor.getCount() > 0){
    				return true;
    			}
    		}
    		return false;
    	}
}