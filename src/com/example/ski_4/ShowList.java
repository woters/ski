package com.example.ski_4;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

public class ShowList extends Fragment {

    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";

    static int pageNumber;
    int backColor;

    static ChooseDate newInstance(int page) {
        ChooseDate pageFragment = new ChooseDate();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);
        Log.w("ShowList", "Fragment init");
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//    pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);

        //Random rnd = new Random();
        //backColor = Color.argb(40, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_show_list, null);
    /*view.setBackgroundColor(Color.CYAN);
    TextView tvPage = (TextView) view.findViewById(R.id.tvPage);
    tvPage.setText("Page " + pageNumber);
    tvPage.setBackgroundColor(backColor);*/
        Log.w("ShowList", "Generated view");

        return view;
    }
}