package com.example.ski_4;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.DatePicker;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: kvrwa_000
 * Date: 11/1/13
 * Time: 6:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class SendData extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {
        requestURL();
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        // execution of result of Long time consuming operation
    }

    @Override
    protected void onPreExecute() {
        // Things to be done before execution of long running operation. For example showing ProgessDialog
    }

    public SendData () {
    }

    public void requestURL()
    {
        String idbuyt = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

        //String price = "55";
        String price = EnterPrice.getPrice();
        //String date1 = "2001-01-03";
        String date1 =   ChooseDate.getYearFromDatePicker1()+"-"+ChooseDate.getMonthFromDatePicker1()+"-"+ChooseDate.getDayFromDatePicker1();
       // String date2 = "2001-01-04";
        String date2 =  ChooseDateEnd.getYearFromDatePicker2()+"-"+ChooseDateEnd.getMonthFromDatePicker2()+"-"+ChooseDateEnd.getDayFromDatePicker2();
        //String phone = "55";
        //String name = "aaaa";
        String phone = EnterName.getPhone();
        String name = EnterName.getName();
        HttpClient client=new DefaultHttpClient();
        HttpPost post;
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
        //int val = getIntent().getIntExtra("runner", -1);
        switch (Constants.ACTIVITY){
        case 0:
        post = new HttpPost("http://10.10.10.104:8080/ski2/buy");
            nameValuePairs.add(new BasicNameValuePair("date1", date1));
            nameValuePairs.add(new BasicNameValuePair("date2", date2));
        break;
        case 1:
        post = new HttpPost("http://10.10.10.104:8080/ski2/sell");
            nameValuePairs.add(new BasicNameValuePair("idBuyT", idbuyt));
            nameValuePairs.add(new BasicNameValuePair("price", price));
            nameValuePairs.add(new BasicNameValuePair("date1", date1));
            nameValuePairs.add(new BasicNameValuePair("date2", date2));
            nameValuePairs.add(new BasicNameValuePair("phone", phone));
            nameValuePairs.add(new BasicNameValuePair("name", name));
        break;
        default:     post = new HttpPost("http://10.10.10.104:8080/ski2/buy");
            nameValuePairs.add(new BasicNameValuePair("date1", date1));
            nameValuePairs.add(new BasicNameValuePair("date2", date2));
        break;
        }




        try {
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = client.execute(post);
            Log.v("response code", response.getStatusLine().getStatusCode() + "");
            HttpEntity entity = response.getEntity();
            /*

            while (response.getParams()) {
                writer.println("<p>Name: " + rs.getString("Name") + "</p>");
                writer.println("<p>Phone: " + rs.getString("Phone") + "</p>");
            }     */



            String responseText = EntityUtils.toString(entity);
            System.out.println(responseText);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClientProtocolException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }








}
