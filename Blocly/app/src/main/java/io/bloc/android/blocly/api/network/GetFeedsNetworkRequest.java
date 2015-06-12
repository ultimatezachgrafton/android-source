package io.bloc.android.blocly.api.network;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Zach on 6/3/2015.
 */
public class GetFeedsNetworkRequest extends NetworkRequest {


    String [] feedUrls;

    public GetFeedsNetworkRequest(String... feedUrls) {
        this.feedUrls = feedUrls;
    }


    @Override
    public Object performRequest() {
        for (String feedUrlString : feedUrls) {
            InputStream inputStream = openStream(feedUrlString);
            if (inputStream == null) {
                return null;
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                String line = bufferedReader.readLine();

                //make an int countervariable
                int counterVariable = 0;

                while (line != null) {

                    // if you find <item> substring of line string, then increase counter
                    if(line.indexOf("") > 0) {
                        counterVariable++;
                    }

                    //Log the counter variable
                    line = bufferedReader.readLine();
                    Log.v(getClass().getSimpleName(), "Line: " + counterVariable);



                }


                    bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
                setErrorCode(ERROR_IO);
                return null;
            }
        }
        return null;
    }
}
