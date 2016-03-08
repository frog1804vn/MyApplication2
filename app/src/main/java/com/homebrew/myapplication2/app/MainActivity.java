package com.homebrew.myapplication2.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.Document;
import com.couchbase.lite.Manager;
import com.couchbase.lite.android.AndroidContext;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    public static final String DB_NAME = "couchbaseevents";
    public static final String TAG = "couchbaseevents";
    private static Database database;
    private static Manager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        String docID = createDocument(database);

              // retrieve the document from the database
        Document retrievedDocument = database.getDocument(docID);
// display the retrieved document
        Log.d(TAG, "retrievedDocument=" + String.valueOf(retrievedDocument.getProperties()));
    }
    public Database getDatabaseInstance() throws CouchbaseLiteException {
        if ((database == null) & (manager != null)) {
            database = manager.getDatabase(DB_NAME);
        }
        return database;
    }
    public Manager getManagerInstance() throws IOException {
        if (manager == null) {
            manager = new Manager(new AndroidContext(this), Manager.DEFAULT_OPTIONS);
        }
        return manager;
    }

    private String createDocument(Database database) {
        // Create a new document and add data
        Document document = database.createDocument();
        String documentId = document.getId();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Big Party");
        map.put("location", "My House");
        try {
            // Save the properties to the document
            document.putProperties(map);
        } catch (CouchbaseLiteException e) {
            Log.e(TAG, "Error putting", e);
        }
        return documentId;
    }
    private void init() {
        try {
            getManagerInstance();
            getDatabaseInstance();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CouchbaseLiteException e) {
            e.printStackTrace();
        }



//        Manager manager = null;
//        Database database = null;
//        try {
//            manager = new Manager(new AndroidContext(this), Manager.DEFAULT_OPTIONS);
//            database = manager.getDatabase(DB_NAME);
//        } catch (Exception e) {
//            Log.e(TAG, "Error getting database", e);
//
//        }
        // Create the document
//        String documentId = createDocument(database);
//    /* Get and output the contents */
//        outputContents(database, documentId);
//    /* Update the document and add an attachment */
//        updateDoc(database, documentId);
//        // Add an attachment
//        addAttachment(database, documentId);
//    /* Get and output the contents with the attachment */
//        outputContentsWithAttachment(database, documentId);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
