package com.example.ski_4;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class EnterName extends Fragment implements ICallBackFragmentAdapter{
  
  static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";

    private TabsAdapter tabsAdapter;
    ViewPager vp;
  static int pageNumber;
  int backColor;
    static EditText editText1;
    static EditText editText2;
  
  static EnterName newInstance(int page) {
	  EnterName pageFragment = new EnterName();
    Bundle arguments = new Bundle();
   // arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
    pageFragment.setArguments(arguments);
    Log.w("EnterName", "Fragment init");
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
    View view = inflater.inflate(R.layout.activity_enter_name, null);
    /*view.setBackgroundColor(Color.CYAN);
    TextView tvPage = (TextView) view.findViewById(R.id.tvPage);
    tvPage.setText("Page " + pageNumber);
    tvPage.setBackgroundColor(backColor);*/
    Log.w("EnterName", "Generated view");

      Button button1 = (Button) view.findViewById(R.id.button1);
      button1.setOnClickListener(lsn1);

      Button button2 = (Button) view.findViewById(R.id.button2);
      button2.setOnClickListener(lsn2);

      editText1 = (EditText) view.findViewById(R.id.editText1);
      editText2 = (EditText) view.findViewById(R.id.editText2);



      return view;
  }

    public static String getName(){
        String name = editText1.getText().toString();
        return name;
    }

    public static String getPhone(){
        String phone = editText2.getText().toString();
        return phone;
    }

    private View.OnClickListener lsn1=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getActivity().finish() ;
        }
    };


    private View.OnClickListener lsn2=new View.OnClickListener() {
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
