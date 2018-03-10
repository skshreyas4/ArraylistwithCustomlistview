package com.example.skshr.arraylistcustomlistview;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.skshr.arraylistcustomlistview.R.id.firstname;

public class MainActivity extends AppCompatActivity {
    ArrayList<Abc> arrayList;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList = new ArrayList<>();
        Abc obj = new Abc();
        obj.firstname = "raghav";
        obj.secondname = "dhanjani";
        obj.id = R.drawable.ab;         //for image add r.drawable.image name here
        list = (ListView) findViewById(R.id.listview);
        Abc nobj = new Abc();
        nobj.firstname = "rf";
        nobj.secondname = "kdjkdn";
        nobj.id = R.drawable.ip;
        arrayList.add(obj);
        arrayList.add(nobj);
        int i;
        for (i = 0; i < arrayList.size(); i++) {

            Log.e("Listofarray", arrayList.get(i).id + " " + arrayList.get(i).firstname + " " + arrayList.get(i).secondname);
        }
        Adaptor adaptor = new Adaptor(MainActivity.this, 0);
        list.setAdapter(adaptor);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, Nextactivityfor1.class);
                //Get the value of the item you clicked
                String itemClicked = arrayList.get(i).firstname;
                intent.putExtra("firstname", itemClicked);
                startActivity(intent);

                Toast.makeText(MainActivity.this,"kdsjfkwj",Toast.LENGTH_SHORT).show();
            }
        });





    }

    class Adaptor extends ArrayAdapter {

        public Adaptor(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflator = LayoutInflater.from(MainActivity.this);
            convertView = inflator.inflate(R.layout.adaptor, null);
            TextView firstName, secondName;
            ImageView image;
            firstName = (TextView) convertView.findViewById(firstname);
            secondName = (TextView) convertView.findViewById(R.id.secondname);
            image = (ImageView) convertView.findViewById(R.id.imageView1);

            firstName.setText(arrayList.get(position).firstname);
            secondName.setText(arrayList.get(position).secondname);
            image.setImageResource(arrayList.get(position).id);
            return convertView;

        }
    }

}
class Abc{

    String firstname,secondname;
    int id;
}