package com.example.john.briskytask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.lang.reflect.Array;
import java.net.*;
import java.util.*;
import org.json.*;

public class MainActivity extends AppCompatActivity {

    private RecyclerView muser;
    private useradupter mAdapter;
    RequestQueue  requestQueue;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Make call to AsyncTask
        //new jasonparse().execute();

        requestQueue = Volley.newRequestQueue(this);
        url = "https://api.myjson.com/bins/gv2on";

        StringRequest getData = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();

                List<user> userlist = Arrays.asList(gson.fromJson(response, user[].class));

                List<user> arraylist = new ArrayList<>();
                for(user model:userlist){
                    arraylist.add(model);
                }

                muser = findViewById(R.id.userList);
                mAdapter = new useradupter(MainActivity.this, arraylist);
                muser.setAdapter(mAdapter);
                muser.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Check Internet Connection", Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(getData);
    }

/*   public void sendjsonrequest(){

        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://api.myjson.com/bins/gv2on", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject json_data) {
                try {



                    muser = findViewById(R.id.userList);
                    mAdapter = new useradupter(MainActivity.this, udata);
                    muser.setAdapter(mAdapter);
                    muser.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                }catch (JSONException e) {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                }

                requestQueue.add(jsonObjectRequest);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

    }
*/
/*    private class jasonparse extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            try {

               URL url = new URL("https://api.myjson.com/bins/gv2on");
               HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                int response_code = conn.getResponseCode();

                // Check if successful connection made
                if (response_code == HttpURLConnection.HTTP_OK) {

                    // Read data sent from server
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }

                    // Pass data to onPostExecute method
                    return (result.toString());

                } else {

                    return ("unsuccessful");
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
                return e.toString();
            } catch (IOException e1) {
                e1.printStackTrace();
                return e1.toString();
            }

        }

        @Override
        protected void onPostExecute(String result) {

            //this method will be running on UI thread
            List<user> udata=new ArrayList<>();

            try {

                JSONArray jArray = new JSONArray(result);

                // Extract data from json and store into ArrayList as class objects
                for(int i=0;i<jArray.length();i++){
                    JSONObject json_data = jArray.getJSONObject(i);
                    user User = new user();
                    User.setName(json_data.getString("name"));
                    User.setUsername(json_data.getString("username"));
                    User.setEmail(json_data.getString("email"));
                    User.setPhone(json_data.getString("phone"));
                    User.setWebsite(json_data.getString("website"));
                    User.setStreet(json_data.getJSONObject("address").getString("street"));
                    User.setSuit(json_data.getJSONObject("address").getString("suite"));
                    User.setCity(json_data.getJSONObject("address").getString("city"));
                    User.setZip(json_data.getJSONObject("address").getString("zipcode"));
                    User.setCname(json_data.getJSONObject("company").getString("name"));
                    User.setCatchpharse(json_data.getJSONObject("company").getString("catchPhrase"));
                    User.setBs(json_data.getJSONObject("company").getString("bs"));
                    udata.add(User);

                }

                // Setup and Handover data to recyclerview
                muser = findViewById(R.id.userList);
                mAdapter = new useradupter(MainActivity.this, udata);
                muser.setAdapter(mAdapter);
                muser.setLayoutManager(new LinearLayoutManager(MainActivity.this));

            } catch (JSONException e) {
                Toast.makeText(MainActivity.this, "Check Internet Connection", Toast.LENGTH_LONG).show();
            }

        }

    }*/

}