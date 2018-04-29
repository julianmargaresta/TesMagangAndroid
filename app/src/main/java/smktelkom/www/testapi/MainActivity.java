package smktelkom.www.testapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import smktelkom.www.testapi.Adapter.AdapterPost;
import smktelkom.www.testapi.Model.ModelPost;

public class MainActivity extends AppCompatActivity {
    List<ModelPost> postList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.RecycleView);
        recyclerView.setAdapter(adapter);
        getVolley();
    }

    private void getVolley() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://jsonplaceholder.typicode.com/posts", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                getData(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error Data", Toast.LENGTH_LONG);
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void getData(String response) {
        try {
            JSONArray jsonArray = new JSONArray(response);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject data = jsonArray.getJSONObject(i);
                ModelPost post = new ModelPost(data.getInt("id"), data.getString("title"), data.getString("body"));
                postList.add(post);
                adapter = new AdapterPost(postList);
                LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
