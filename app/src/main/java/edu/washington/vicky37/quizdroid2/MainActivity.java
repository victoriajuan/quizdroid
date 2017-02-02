package edu.washington.vicky37.quizdroid2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String[] quizesList = {"Math",
            "Physics",
            "Computer Science",
            "Marvel Super Heroes",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, quizesList);

        ListView quizListView = (ListView) findViewById(R.id.quizList);
        quizListView.setAdapter(adapter);

        quizListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        if(position==0){
                            Intent myintent = new Intent(view.getContext(), Main2Activity.class);
                            myintent.putExtra("value", "math");
                            startActivityForResult(myintent, 0);
                        }

                        if(position==1){
                            Intent myintent = new Intent(view.getContext(), Main2Activity.class);
                            myintent.putExtra("value", "physics");
                            startActivityForResult(myintent, 1);
                        }

                        if(position==2){
                            Intent myintent = new Intent(view.getContext(), Main2Activity.class);
                            myintent.putExtra("value", "computer");
                            startActivityForResult(myintent, 2);
                        }

                        if(position==3){
                            Intent myintent = new Intent(view.getContext(), Main2Activity.class);
                            myintent.putExtra("value", "marvel");
                            startActivityForResult(myintent, 3);
                        }
                    }
                }
        );

    }
}
