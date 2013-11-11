package com.example.ski_4;

import android.app.FragmentTransaction;
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
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import java.util.Calendar;


public class ChooseDate extends Fragment implements ICallBackFragmentAdapter {

    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";
    private TabsAdapter tabsAdapter;
    ViewPager vp;
    static int pageNumber;
    int backColor;
    FragmentTransaction fTrans;
    static DatePicker datePicker1;

    static ChooseDate newInstance(int page) {
        ChooseDate pageFragment = new ChooseDate();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);
        Log.w("ChooseDate", "Fragment init");
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w(this.getClass().getName(),"Creating11")    ;
//    pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);

        //Random rnd = new Random();
        //backColor = Color.argb(40, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_choose_date, null);
    /*view.setBackgroundColor(Color.CYAN);
    TextView tvPage = (TextView) view.findViewById(R.id.tvPage);
    tvPage.setText("Page " + pageNumber);
    tvPage.setBackgroundColor(backColor);*/
        Log.w("ChooseDate", "Generated view");

        Button button1 = (Button) view.findViewById(R.id.button1);

        switch (Constants.ACTIVITY){
            case 0:
                button1.setOnClickListener(lsn1);
                break;
            case 1:
                button1.setOnClickListener(lsn3);
                break;
            default:
                button1.setOnClickListener(lsn1);
                break;
        }



        Button button2 = (Button) view.findViewById(R.id.button2);
        button2.setOnClickListener(lsn2);

        datePicker1 = (DatePicker) view.findViewById(R.id.datePicker1);

        return view;
    }


    public static  String getDayFromDatePicker1(){

        String day = Integer.toString(datePicker1.getDayOfMonth());

        return day;
    }

    public static String getMonthFromDatePicker1(){
        String month = Integer.toString(datePicker1.getMonth()+1);

        return month;
    }

    public static String getYearFromDatePicker1(){
        String year =  Integer.toString(datePicker1.getYear());

        return year;
    }

    private View.OnClickListener lsn1=new OnClickListener() {
        @Override
        public void onClick(View v) {
            getActivity().finish() ;
        }
    };

    private View.OnClickListener lsn2=new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (vp != null) {
                // = tabsAdapter.getViewPager();
                vp.setCurrentItem(vp.getCurrentItem()+1, true);
            }
            else{
                Log.e(this.getClass().getName(),"Error empty vp");
            }        }
    }  ;

    private View.OnClickListener lsn3=new View.OnClickListener() {
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
    @Override
    public TabsAdapter getTabsAdapter() {
        return tabsAdapter;
    }

    @Override
    public void setTabsAdapter(TabsAdapter tabsAdapter) {
        this.tabsAdapter = tabsAdapter;
        this.vp=tabsAdapter.getViewPager();
        Log.w("Fragment","Adding tabsAdapter"+ tabsAdapter);
    }
}
