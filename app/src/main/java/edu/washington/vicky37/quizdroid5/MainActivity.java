package edu.washington.vicky37.quizdroid5;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity{

    QuizApp quizApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();
        this.quizApp = new QuizApp();

        if(isAirplaneModeOn(context)){
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Airplane Mode is on. Would you like to go to turn it off?");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            AlertDialog dialog = builder.create();
        }

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetWork = connectivityManager.getActiveNetworkInfo();
        if(activeNetWork != null){
            if(activeNetWork.getType() == ConnectivityManager.TYPE_WIFI){

            }else if(activeNetWork.getType() == ConnectivityManager.TYPE_MOBILE){

            }else {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Wifi is not connected. No downloads will be made");
                AlertDialog dialog = builder.create();
            }
        }


        quizApp = new QuizApp();
        final String[] names = new String[3];
        final String[] descs = new String[3];
        for(int i=0; i<quizApp.getTopicList().size(); i++){
            names[i] = quizApp.getTopicList().get(i);
            System.out.println(quizApp.getTopicList().get(i));
        }
        for(int i=0; i<quizApp.getDesdList().size(); i++){
            descs[i] = quizApp.getDesdList().get(i);
        }
//        System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        System.err.println(Arrays.toString(names));
//        final String[] names = {quizApp.getTopicList().get(0), quizApp.getTopicList().get(1), quizApp.getTopicList().get(2)};
//        final String[] descs = {quizApp.getDesdList().get(0), quizApp.getDesdList().get(1), quizApp.getDesdList().get(2)};
        ArrayList<Map<String, String>> jsonData = new ArrayList<>();
        for(int i=0; i<names.length; i++){
            Map<String, String> jsonMap = new HashMap<>(2);
            jsonMap.put("names", names[i]);
            jsonMap.put("desc", descs[i]);
            jsonData.add(jsonMap);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, jsonData, android.R.layout.simple_list_item_2, new String[] {"names", "desc"}, new int[] {android.R.id.text1, android.R.id.text2});
        final ListView listView = (ListView) findViewById(R.id.ListView);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =  new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("name", names[position]);
                intent.putExtra("desc", descs[position]);
                startActivity(intent);
            }
        });


//        quizApp.addTopic(new Topic("Math", "Math is a science", "Math is a the study of topics such as quantity, structure, space and change. "));
//        quizApp.addTopic(new Topic("Physics", "Physics is a science", "Physics is the natural science that involves the study of matter and its motion and behavior through space and time"));
//        quizApp.addTopic(new Topic("Marvel Hero", "Marvel Heroes are characters", "Marvel Heroes are characters from the movies made by marvel comic "));
//        Button button = (Button) findViewById(R.id.mathToQuestion);
//        button.setOnClickListener(this);
//        TextView textView = (TextView) findViewById(R.id.mathDesc);
//        textView.setText(quizApp.getShortDesc("Math"));
//        button = (Button) findViewById(R.id.physicsToQuestion);
//        button.setOnClickListener(this);
//        textView = (TextView) findViewById(R.id.physicsDesc);
//        textView.setText(quizApp.getShortDesc("Physics"));
//        button = (Button) findViewById(R.id.marvelToQuestion);
//        button.setOnClickListener(this);
//        textView = (TextView) findViewById(R.id.marvelDesc);
//        textView.setText(quizApp.getShortDesc("Marvel Hero"));
    }

    /**
     * Gets the state of Airplane Mode.
     *
     * @param context
     * @return true if enabled.
     */
    private static boolean isAirplaneModeOn(Context context) {

        return Settings.System.getInt(context.getContentResolver(),
                Settings.Global.AIRPLANE_MODE_ON, 0) != 0;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    public void onClick(View view){
//        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
//        ArrayList<String> choices = new ArrayList<String>();
//        Topic topic;
//        switch (view.getId()){
//            case R.id.mathToQuestion:
//                topic = quizApp.getTopic("Math");
//                choices = new ArrayList<>();
//                choices.add("67");
//                choices.add("66");
//                choices.add("69");
//                choices.add("68");
//                topic.addQuestion(new Quiz("12 + 56", choices, "68"));
//                choices = new ArrayList<>();
//                choices.add("23");
//                choices.add("22");
//                choices.add("24");
//                choices.add("21");
//                topic.addQuestion(new Quiz("90 - 67", choices, "23"));
//                quizApp.replaceTopic(quizApp.TopicSpot("Math"), topic);
//                quizApp.setTopic("Math");
//                break;
//            case R.id.physicsToQuestion:
//                topic = quizApp.getTopic("Physics");
//                choices = new ArrayList<>();
//                choices.add("100 km/h ");
//                choices.add("200 km/h ");
//                choices.add("150 km/h ");
//                choices.add("50 km/h ");
//                topic.addQuestion(new Quiz("Two identical cars collide head on. Each car is traveling at 100 km/h. The impact force on each car is the same as hitting a solid wall at: ", choices, "100 km/h "));
//                choices = new ArrayList<>();
//                choices.add("Vector");
//                choices.add("Frame of reference");
//                choices.add("Resultant");
//                choices.add("Scalar");
//                topic.addQuestion(new Quiz("Which of the following is a physical quantity that has a magnitude but no direction?", choices, "Scalar"));
//                quizApp.replaceTopic(quizApp.TopicSpot("Physics"), topic);
//                quizApp.setTopic("Physics");
//                break;
//            case R.id.marvelToQuestion:
//                topic = quizApp.getTopic("Marvel Hero");
//                choices = new ArrayList<>();
//                choices.add("Stark Tower");
//                choices.add("Fantastic Headquarters");
//                choices.add("Baxter Building");
//                choices.add("Xavier Institute");
//                choices = new ArrayList<>();
//                topic.addQuestion(new Quiz("The Fantastic Four have the headquarters in what building?", choices, "Baxter Building"));
//                choices.add("The Daily Planet");
//                choices.add("The Daily Bugle");
//                choices.add("The New York Times");
//                choices.add("The Rolling Stone");
//                topic.addQuestion(new Quiz("Peter Parker works as a photographer for:", choices, "The Daily Bugle"));
//                quizApp.replaceTopic(quizApp.TopicSpot("Marvel Hero"), topic);
//                quizApp.setTopic("Marvel Hero");
//                break;
//        }
//        startActivity(intent);
//        finish();
//    }

}
