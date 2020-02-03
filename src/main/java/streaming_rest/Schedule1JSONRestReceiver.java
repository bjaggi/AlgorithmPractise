package streaming_rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.logging.LogManager;

import org.apache.http.client.HttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;
import org.apache.spark.storage.StorageLevel;
import org.apache.spark.streaming.receiver.Receiver;

import com.sun.research.ws.wadl.Response;
public class Schedule1JSONRestReceiver extends Receiver<String> implements Serializable{

    private String url;

    //Logger logger=Logger.getLogger(WcReceiver.class);

    public Schedule1JSONRestReceiver(String url)
    {
        super(StorageLevel.MEMORY_AND_DISK_2());
        this.url=url;


    }

    public Schedule1JSONRestReceiver(StorageLevel storageLevel) {
        super(storageLevel);
    }

    @Override
    public void onStart() {
        new Thread(){
            @Override public void run()
            {
                receive();
            }
        }.start();
    }

    @Override
    public void onStop() {
    }

    private void receive()
    {

        try {
            HttpGet get = new HttpGet(url);
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response=httpclient.execute(get);
            BufferedReader br=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            System.out.println(" Got Message from Rest call "+br.readLine());
            store(br.readLine());
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
