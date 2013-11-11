package com.example.ski_4;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Locale;


public class MainActivity extends Activity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }



    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        //return true;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_search:
                //GoToChooseDateBuy(View view);
                return true;
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/

    /** Called when the user clicks the Sell button */
	/*public void GoToChooseDateBuy(View view) {
		Intent intentBuy = new Intent(this, ChooseDate.class);
		intentBuy.putExtra("runner", Constants.ACTIVITY_BUY);
		startActivity(intentBuy);
	}

	public void GoToChooseDateSell(View view) {
		Intent intentSell = new Intent(this, ChooseDate.class);
		intentSell.putExtra("runner", Constants.ACTIVITY_SELL);
		startActivity(intentSell);
	}*/

    public void GoToBuy(View view) {
        Intent intent = new Intent(this, Container_Buy.class);
        //intent.putExtra("runner", Constants.ACTIVITY_BUY);
        Constants.ACTIVITY=0;
        startActivity(intent);
    }

    public void GoToSell(View view) {
        Intent intent = new Intent(this, Container_Sell.class);
        //intent.putExtra("runner", Constants.ACTIVITY_SELL);
        Constants.ACTIVITY=1;
        startActivity(intent);
        //	ft.replace(R.id.your_placehodler, new YourFragment());
        //ft.commit();
    }

}