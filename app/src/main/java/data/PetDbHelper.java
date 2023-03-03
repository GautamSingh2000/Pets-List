package data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PetDbHelper extends SQLiteOpenHelper {
    public static final int DATA_BASE_VERSION = 1;
    public static final String DATA_BASE_NAME = "shelter.db";


    public PetDbHelper (Context context)
    {
        super(context,DATA_BASE_NAME,null,DATA_BASE_VERSION);
    }

    //here on create is the abstract function of SQliteOpenHelper class use to
    //initialize the data base if it is not created.
     public void onCreate(SQLiteDatabase db) {
         // Create a String that contains the SQL statement to create the pets table
         String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + PetContract.PetEntry.TABLE_NAME + " ("
                 + PetContract.PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                 + PetContract.PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL, "
                 + PetContract.PetEntry.COLUMN_PET_BREED + " TEXT, "
                 + PetContract.PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL, "
                 + PetContract.PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";
         db.execSQL(SQL_CREATE_PETS_TABLE);
     }


     //this method is abstract method of SQliteOpenHelper class use to update the database for the works
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
