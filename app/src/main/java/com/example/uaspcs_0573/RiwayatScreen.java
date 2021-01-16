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
import com.example.uaspcs_0573.Adapter.RiwayatAdapter;
import com.example.uaspcs_0573.Models.Riwayat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RiwayatScreen extends AppCompatActivity {

    RecyclerView rcRiwayat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat);
        rcRiwayat=findViewById(R.id.rcRiwayat);

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url ="https://www.thesportsdb.com/api/v1/json/1/eventspastleague.php?id=4331";

        final ArrayList<Riwayat> riwayat = new ArrayList<Riwayat>();

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
                                String awayScore = item.getString("intAwayScore");
                                String homeScore = item.getString("intHomeScore");
                                String matchDescription = item.getString("strFilename");
                                String image = item.getString("strThumb");
                                String matchId = item.getString("idEvent");
                                riwayat.add(new Riwayat(matchTitle,awayScore,homeScore,matchDescription,image,matchId));

                                RiwayatAdapter riwayatAdapter = new RiwayatAdapter(getApplicationContext(), riwayat);


                                rcRiwayat.setAdapter(riwayatAdapter);
                                rcRiwayat.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

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
