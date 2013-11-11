package com.example.ski_4;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ChooseDateEnd extends Fragment implements ICallBackFragmentAdapter{
  
  static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";
    //TextView tvOut;
  
  static int pageNumber;
  int backColor;
    private TabsAdapter tabsAdapter;
    ViewPager vp;
    static DatePicker datePicker2;
  
  static ChooseDateEnd newInstance(int page) {
	  ChooseDateEnd pageFragment = new ChooseDateEnd();
    Bundle arguments = new Bundle();
    arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
    pageFragment.setArguments(arguments);
    Log.w("ChooseDateEnd", "Fragment init");
    return pageFragment;
  }
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);
    
    //Random rnd = new Random();
    //backColor = Color.argb(40, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
  }
  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.activity_choose_date_end, null);
    /*view.setBackgroundColor(Color.CYAN);
    TextView tvPage = (TextView) view.findViewById(R.id.tvPage);
    tvPage.setText("Page " + pageNumber);
    tvPage.setBackgroundColor(backColor);*/
    Log.w("ChooseDateEnd", "Generated view");

      Button button1 = (Button) view.findViewById(R.id.button1);
      button1.setOnClickListener(lsn1);

      Button button2 = (Button) view.findViewById(R.id.button2);
      button2.setOnClickListener(lsn2);




      switch (Constants.ACTIVITY){
          case 1:

              button2.setOnClickListener(new OnClickListener() {
                  public void onClick(View view) {
                      //this.finish();
                      getActivity().finish();
                      Toast.makeText(getActivity(), "Done", Toast.LENGTH_LONG).show();
                  }
              });
              //tvOut.setText("Done");

              break;
          case 0:

              button2.setOnClickListener(lsn2);
              break;
      }


      datePicker2 = (DatePicker) view.findViewById(R.id.datePicker2);


      return view;
  }

    public static  String getDayFromDatePicker2(){

        String day = Integer.toString(datePicker2.getDayOfMonth());

        return day;
    }

    public static String getMonthFromDatePicker2(){
        String month = Integer.toString(datePicker2.getMonth()+1);

        return month;
    }

    public static String getYearFromDatePicker2(){
        String year =  Integer.toString(datePicker2.getYear());

        return year;
    }



    private View.OnClickListener lsn1=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (vp != null) {
                // = tabsAdapter.getViewPager();
                vp.setCurrentItem(vp.getCurrentItem()-1, true);
            }
            else{
                Log.e(this.getClass().getName(),"Error empty vp");
            }        }
    }  ;

    private View.OnClickListener lsn2=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (vp != null) {
                // = tabsAdapter.getViewPager();
                vp.setCurrentItem(vp.getCurrentItem()+1, true);

                Thread t = new Thread(){
                    public void run(){
                        new SendData().execute("");
                    }
                };
                t.start();
            }
            else{
                Log.e(this.getClass().getName(),"Error empty vp");
            }        }
    }  ;

    @Override
    public TabsAdapter getTabsAdapter() {
        return tabsAdapter;
    }

    @Override
    public void setTabsAdapter(TabsAdapter adapter) {
        this.tabsAdapter = adapter;
        this.vp=tabsAdapter.getViewPager();
    }
}

