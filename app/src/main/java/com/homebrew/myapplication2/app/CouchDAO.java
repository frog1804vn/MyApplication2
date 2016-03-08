package com.homebrew.myapplication2.app;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.Document;
import com.couchbase.lite.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nguyen on 23/02/16 for MyApplication2.
 */
public class CouchDAO {
    public static final String TAG = "CouchDAO";
//    static String createDocument(Database database) {
//        // Create a new document and add data
//        Document document = database.createDocument();
//        String documentId = document.getId();
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("name", "Big Party");
//        map.put("location", "My House");
//        try {
//            // Save the properties to the document
//            document.putProperties(map);
//        } catch (CouchbaseLiteException e) {
//            Log.e(TAG, "Error putting", e);
//        }
//        return documentId;
//    }
}
