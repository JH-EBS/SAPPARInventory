
package com.sap.johnshopkins.sapparinventory;



import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PARCaptureDB {

    // database constants
    public static final String DB_NAME = "PARCapture.db";
    public static final int    DB_VERSION = 1;

    // list of tables required
    // tJHEDID
    // tPlants
    // tPARHeader
    // tPARDetail


    //*-----tJHEDID table---------*
    // tJHEDID  table constants
    public static final String JHEDID_TABLE = "tJHEDID";

    public static final String JHEDID_ID = "JHEDID";
    public static final int    JHEDID_ID_COL = 0;

    public static final String JHEDID_PLANT = "PlantID";
    public static final int    JHEDID_PLANT_COL = 1;

    public static final String JHEDID_PARTEMPLATE = "PARTemplate";
    public static final int    JHEDID_PARTEMPLATE_COL = 2;

    public static final String JHEDID_FLAG = "LastUsedFlag";
    public static final int    JHEDID_FLAG_COL = 3;

    // CREATE and DROP TABLE statements
    public static final String DROP_JHEDID_TABLE =
            "DROP TABLE IF EXISTS " + JHEDID_TABLE;

    public static final String CREATE_JHEDID_TABLE =
            "CREATE TABLE " + JHEDID_TABLE + " (" +
                    JHEDID_ID   + " TEXT PRIMARY KEY , " +
                    JHEDID_PLANT + " TEXT  NOT NULL, " +
                    JHEDID_PARTEMPLATE  + " TEXT NOT NULL, " +
                    JHEDID_FLAG + " TEXT );";




    //*-----tPlants table---------*
    // tPlants  table constants
    public static final String PLANTS_TABLE = "tPlants";

    public static final String PLANTS_ID = "PlantID";
    public static final int    PLANTS_ID_COL = 0;

    public static final String PLANTS_NAME = "TemplateName";
    public static final int    PLANTS_NAME_COL = 1;


    // CREATE and DROP TABLE statements
    public static final String DROP_PLANTS_TABLE =
            "DROP TABLE IF EXISTS " + PLANTS_TABLE;

    public static final String CREATE_PLANTS_TABLE =
            "CREATE TABLE " + PLANTS_TABLE + " (" +
                    PLANTS_ID   + " TEXT PRIMARY KEY , " +
                    PLANTS_NAME + " TEXT PRIMARY KEY);";



    //*-----tPARHeader table---------*
    // tPARHeader  table constants
    public static final String PARHEADER_TABLE = "tPARHeader";

    public static final String PARHEADER_ID = "JHEDID";
    public static final int    PARHEADER_ID_COL = 0;

    public static final String PARHEADER_NAME = "TemplateName";
    public static final int    PARHEADER_NAME_COL = 1;

    public static final String PARHEADER_PLANT = "PlantID";
    public static final int    PARHEADER_PLANT_COL = 2;

    public static final String PARHEADER_STATUS = "Status";
    public static final int    PARHEADER_STATUS_COL = 3;

    public static final String PARHEADER_TOTALITMS = "TotalItems";
    public static final int    PARHEADER_TOTALITMS_COL = 4;

    public static final String PARHEADER_TOTALITMSPSTD = "TotalItemsPosted";
    public static final int    PARHEADER_TOTALITMSPSTD_COL = 5;

    public static final String PARHEADER_TOTALQTY = "TotalQuantity";
    public static final int    PARHEADER_TOTALQTY_COL = 6;

    public static final String PARHEADER_CREATEDT = "CreateDate";
    public static final int    PARHEADER_CREATEDT_COL = 7;

    public static final String PARHEADER_CREATETM = "CreateTime";
    public static final int    PARHEADER_CREATETM_COL = 8;

    public static final String PARHEADER_UPDATEDT = "UpdateDate";
    public static final int    PARHEADER_UPDATEDT_COL = 9;

    public static final String PARHEADER_UPDATETM = "UpdateTime";
    public static final int    PARHEADER_UPDATETM_COL = 10;

    public static final String PARHEADER_SESSIONID = "SessionID";
    public static final int    PARHEADER_SESSIONID_COL = 11;

    // CREATE and DROP TABLE statements
    public static final String DROP_PARHEADER_TABLE =
            "DROP TABLE IF EXISTS " + PARHEADER_TABLE;

    public static final String CREATE_PARHEADER_TABLE =
            "CREATE TABLE " + PARHEADER_TABLE + " (" +
                    PARHEADER_ID   + " TEXT PRIMARY KEY , " +
                    PARHEADER_NAME + " TEXT  NOT NULL, " +
                    PARHEADER_PLANT + " TEXT  NOT NULL, " +
                    PARHEADER_STATUS + " TEXT , " +
                    PARHEADER_TOTALITMS + " INTEGER , " +
                    PARHEADER_TOTALITMSPSTD + " INTEGER , " +
                    PARHEADER_TOTALQTY + " INTEGER , " +
                    PARHEADER_CREATEDT + " TEXT , " +
                    PARHEADER_CREATETM + " TEXT , " +
                    PARHEADER_UPDATEDT + " TEXT , " +
                    PARHEADER_UPDATETM + " TEXT , " +
                    PARHEADER_SESSIONID + " TEXT );";


    //*-----tPARDetail table---------*
    // tPARDetail  table constants
    public static final String PARDETAIL_TABLE = "tPARDetail";

    public static final String PARDETAIL_ID = "JHEDID";
    public static final int    PARDETAIL_ID_COL = 0;

    public static final String PARDETAIL_NAME = "TemplateName";
    public static final int    PARDETAIL_NAME_COL = 1;

    public static final String PARDETAIL_PLANT = "PlantID";
    public static final int    PARDETAIL_PLANT_COL = 2;

    public static final String PARDETAIL_ROWNUM = "RowNum";
    public static final int    PARDETAIL_ROWNUM_COL = 2;

    public static final String PARDETAIL_MATERIAL = "MaterialID";
    public static final int    PARDETAIL_MATERIAL_COL = 2;

    public static final String PARDETAIL_PARQTY = "PARQuantity";
    public static final int    PARDETAIL_PARQTY_COL = 2;

    public static final String PARDETAIL_PARCNT = "PARCount";
    public static final int    PARDETAIL_PARCNT_COL = 2;

    public static final String PARDETAIL_MPART = "MfgPart";
    public static final int    PARDETAIL_MPART_COL = 2;

    public static final String PARDETAIL_MATDESC = "MatlDescription";
    public static final int    PARDETAIL_MATDESC_COL = 2;

    public static final String PARDETAIL_ISSUOM = "IssueUOM";
    public static final int    PARDETAIL_ISSUOM_COL = 2;

    public static final String PARDETAIL_VNDNUM = "VendorNum";
    public static final int    PARDETAIL_VNDNUM_COL = 2;

    public static final String PARDETAIL_PCHRGEIND = "PatientChargeInd";
    public static final int    PARDETAIL_PCHRGEIND_COL = 2;

    public static final String PARDETAIL_UPDATEDT = "UpdateDate";
    public static final int    PARDETAIL_UPDATEDT_COL = 9;

    public static final String PARDETAIL_UPDATETM = "UpdateTime";
    public static final int    PARDETAIL_UPDATETM_COL = 10;

    public static final String PARDETAIL_SESSIONID = "SessionID";
    public static final int    PARDETAIL_SESSIONID_COL = 11;

    // CREATE and DROP TABLE statements
    public static final String DROP_PARDETAIL_TABLE =
            "DROP TABLE IF EXISTS " + PARDETAIL_TABLE;

    public static final String CREATE_PARDETAIL_TABLE =
            "CREATE TABLE " + PARDETAIL_TABLE + " (" +
                    PARDETAIL_ID   + " TEXT PRIMARY KEY , " +
                    PARDETAIL_NAME + " TEXT  NOT NULL, " +
                    PARDETAIL_PLANT + " TEXT  NOT NULL, " +
                    PARDETAIL_ROWNUM + " INTEGER, " +
                    PARDETAIL_MATERIAL + " TEXT NOT NULL, " +
                    PARDETAIL_PARQTY + " INTEGER, " +
                    PARDETAIL_PARCNT + " INTEGER, " +
                    PARDETAIL_MPART + " TEXT, " +
                    PARDETAIL_MATDESC + " TEXT, " +
                    PARDETAIL_ISSUOM + " TEXT  NOT NULL, " +
                    PARDETAIL_VNDNUM + " TEXT  NOT NULL, " +
                    PARDETAIL_PCHRGEIND + " TEXT , " +
                    PARDETAIL_UPDATEDT + " TEXT , " +
                    PARDETAIL_UPDATETM + " TEXT , " +
                    PARDETAIL_SESSIONID + " TEXT );";

    //*-----tPARDetail table---------*


    // task table constants
    public static final String TASK_TABLE = "task";

    public static final String TASK_ID = "_id";
    public static final int    TASK_ID_COL = 0;

    public static final String TASK_LIST_ID = "list_id";
    public static final int    TASK_LIST_ID_COL = 1;

    public static final String TASK_NAME = "task_name";
    public static final int    TASK_NAME_COL = 2;

    public static final String TASK_NOTES = "notes";
    public static final int    TASK_NOTES_COL = 3;

    public static final String TASK_COMPLETED = "date_completed";
    public static final int    TASK_COMPLETED_COL = 4;

    public static final String TASK_HIDDEN = "hidden";
    public static final int    TASK_HIDDEN_COL = 5;


    public static final String CREATE_TASK_TABLE =
            "CREATE TABLE " + TASK_TABLE + " (" +
                    TASK_ID         + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TASK_LIST_ID    + " INTEGER NOT NULL, " +
                    TASK_NAME       + " TEXT    NOT NULL, " +
                    TASK_NOTES      + " TEXT, " +
                    TASK_COMPLETED  + " TEXT, " +
                    TASK_HIDDEN     + " TEXT);";


    public static final String DROP_TASK_TABLE =
            "DROP TABLE IF EXISTS " + TASK_TABLE;







    private static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name,
                        CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // create tables
            db.execSQL(CREATE_JHEDID_TABLE);
            db.execSQL(CREATE_PLANTS_TABLE);
            db.execSQL(CREATE_PARHEADER_TABLE);
            db.execSQL(CREATE_PARDETAIL_TABLE);
            db.execSQL(CREATE_TASK_TABLE);


/*
            // insert default lists
            db.execSQL("INSERT INTO list VALUES (1, 'Personal')");
            db.execSQL("INSERT INTO list VALUES (2, 'Business')");

            // insert sample tasks
            db.execSQL("INSERT INTO task VALUES (1, 1, 'Pay bills', " +
                    "'Rent\nPhone\nInternet', '0', '0')");
            db.execSQL("INSERT INTO task VALUES (2, 1, 'Get hair cut', " +
                    "'', '0', '0')");

*/

        }

        @Override
        public void onUpgrade(SQLiteDatabase db,
                              int oldVersion, int newVersion) {

            Log.d("Task list", "Upgrading db from version "
                    + oldVersion + " to " + newVersion);

            db.execSQL(PARCaptureDB.DROP_JHEDID_TABLE);
            db.execSQL(PARCaptureDB.DROP_PLANTS_TABLE);
            db.execSQL(PARCaptureDB.DROP_PARHEADER_TABLE);
            db.execSQL(PARCaptureDB.DROP_PARDETAIL_TABLE);
            db.execSQL(PARCaptureDB.DROP_TASK_TABLE);
            onCreate(db);
        }
    }

    // database and database helper objects
    private SQLiteDatabase db;
    private DBHelper dbHelper;

    // constructor
    public PARCaptureDB(Context context) {
        dbHelper = new DBHelper(context, DB_NAME, null, DB_VERSION);
    }

    // private methods
    private void openReadableDB() {
        db = dbHelper.getReadableDatabase();
    }

    private void openWriteableDB() {
        db = dbHelper.getWritableDatabase();
    }

    private void closeDB() {
        if (db != null)
            db.close();
    }
/*

    // public methods
    public ArrayList<List> getLists() {
        ArrayList<List> lists = new ArrayList<List>();
        openReadableDB();
        Cursor cursor = db.query(LIST_TABLE,
                null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            List list = new List();
            list.setId(cursor.getInt(LIST_ID_COL));
            list.setName(cursor.getString(LIST_NAME_COL));

            lists.add(list);
        }
        if (cursor != null)
            cursor.close();
        closeDB();

        return lists;
    }


    public List getList(String name) {
        String where = LIST_NAME + "= ?";
        String[] whereArgs = { name };

        openReadableDB();
        Cursor cursor = db.query(LIST_TABLE, null,
                where, whereArgs, null, null, null);
        List list = null;
        cursor.moveToFirst();
        list = new List(cursor.getInt(LIST_ID_COL),
                cursor.getString(LIST_NAME_COL));
        if (cursor != null)
            cursor.close();
        this.closeDB();

        return list;
    }
*/

    public ArrayList<Task> getTasks(String listName) {
        String where =
                TASK_LIST_ID + "= ? AND " +
                        TASK_HIDDEN + "!='1'";
        int listID = getList(listName).getId();
        String[] whereArgs = { Integer.toString(listID) };

        this.openReadableDB();
        Cursor cursor = db.query(TASK_TABLE, null,
                where, whereArgs,
                null, null, null);
        ArrayList<Task> tasks = new ArrayList<Task>();
        while (cursor.moveToNext()) {
            tasks.add(getTaskFromCursor(cursor));
        }
        if (cursor != null)
            cursor.close();
        this.closeDB();

        return tasks;
    }

    public Task getTask(int id) {
        String where = TASK_ID + "= ?";
        String[] whereArgs = { Integer.toString(id) };

        this.openReadableDB();
        Cursor cursor = db.query(TASK_TABLE,
                null, where, whereArgs, null, null, null);
        cursor.moveToFirst();
        Task task = getTaskFromCursor(cursor);
        if (cursor != null)
            cursor.close();
        this.closeDB();

        return task;
    }

    private static Task getTaskFromCursor(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0){
            return null;
        }
        else {
            try {
                Task task = new Task(
                        cursor.getInt(TASK_ID_COL),
                        cursor.getInt(TASK_LIST_ID_COL),
                        cursor.getString(TASK_NAME_COL),
                        cursor.getString(TASK_NOTES_COL),
                        cursor.getString(TASK_COMPLETED_COL),
                        cursor.getString(TASK_HIDDEN_COL));
                return task;
            }
            catch(Exception e) {
                return null;
            }
        }
    }

    public long insertTask(Task task) {
        ContentValues cv = new ContentValues();
        cv.put(TASK_LIST_ID, task.getListId());
        cv.put(TASK_NAME, task.getName());
        cv.put(TASK_NOTES, task.getNotes());
        cv.put(TASK_COMPLETED, task.getCompletedDate());
        cv.put(TASK_HIDDEN, task.getHidden());

        this.openWriteableDB();
        long rowID = db.insert(TASK_TABLE, null, cv);
        this.closeDB();

        return rowID;
    }

    public int updateTask(Task task) {
        ContentValues cv = new ContentValues();
        cv.put(TASK_LIST_ID, task.getListId());
        cv.put(TASK_NAME, task.getName());
        cv.put(TASK_NOTES, task.getNotes());
        cv.put(TASK_COMPLETED, task.getCompletedDate());
        cv.put(TASK_HIDDEN, task.getHidden());

        String where = TASK_ID + "= ?";
        String[] whereArgs = { String.valueOf(task.getId()) };

        this.openWriteableDB();
        int rowCount = db.update(TASK_TABLE, cv, where, whereArgs);
        this.closeDB();

        return rowCount;
    }

    public int deleteTask(long id) {
        String where = TASK_ID + "= ?";
        String[] whereArgs = { String.valueOf(id) };

        this.openWriteableDB();
        int rowCount = db.delete(TASK_TABLE, where, whereArgs);
        this.closeDB();

        return rowCount;
    }
}

