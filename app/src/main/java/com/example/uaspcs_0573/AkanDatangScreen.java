package com.example.uaspcs_0573;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.uaspcs_0573.Adapter.AkanDatangAdapter;
import com.example.uaspcs_0573.Models.AkanDatang;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AkanDatangScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akandatang);

        final RecyclerView rcBerlangsung = findViewById(R.id.rcAkandatang);


        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url ="https://www.thesportsdb.com/api/v1/json/1/eventsnextleague.php?id=4331";

        final ArrayList<AkanDatang> akandatang = new ArrayList<AkanDatang>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray events = obj.getJSONArray("events");
                            for(int x=0;x<events.length();x++){
                                JSONObject item = events.getJSONObject(x);
                                String matchTitle = item.getString("strEvent");
                                String date = item.getString("dateEvent");
                                String time = item.getString("strTime");
                                String matchDescription = item.getString("strFilename");
                                String image = item.getString("strThumb");
                                akandatang.add(new AkanDatang(matchTitle,"....","....",date+" "+time,image));

                                AkanDatangAdapter akandatangAdapter = new AkanDatangAdapter(getApplicationContext(), akandatang );

                                rcBerlangsung.setAdapter(akandatangAdapter);
                                rcBerlangsung.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        });


        queue.add(stringRequest);

    }
}
