package edu.washington.vicky37.quizdroid5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by victoriajuan on 2/26/17.
 */

public class Receiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            URL url = new URL("http://tednewardsandbox.site44.com/questions.json");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(true);
            urlConnection.connect();
            File SDCardRoot = new File("/Users/victoriajuan/AndroidStudioProjects/quizdroid/app/src/main/java/edu/washington/vicky37/quizdroid5");
            File file = new File(SDCardRoot, "data.json");
            FileOutputStream fileOutput = new FileOutputStream(file);
            InputStream inputStream = urlConnection.getInputStream();
            int totalSize = urlConnection.getContentLength();
            int downloadedSize = 0;
            byte[] buffer = new byte[1024];
            int bufferLength = 0;
            while ((bufferLength = inputStream.read(buffer)) > 0) {
                fileOutput.write(buffer, 0, bufferLength);
                downloadedSize += bufferLength;
                int progress = (int) (downloadedSize * 100 / totalSize);
            }
            fileOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
