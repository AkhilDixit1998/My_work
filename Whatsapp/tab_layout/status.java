package com.example.akhildixit.tab_layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Akhil Dixit on 6/15/2017.
 */

public class status extends Fragment {

    Integer images[]={R.drawable.batman,R.drawable.hero,R.drawable.stud,
            R.drawable.skitty,R.drawable.smile,R.drawable.batman,R.drawable.hero,R.drawable.stud,
            R.drawable.skitty,R.drawable.smile};
    String data[]={"Akhil ","Akhil ","Akhil ","Akhil ","Akhil ","Akhil ","Akhil ","Akhil ","Akhil ","Akhil "};
    String time[]={"Today, 11:58 am","Today, 11:58 am","Today, 11:58 am","Today, 11:58 am","Today, 11:58 am","Today, 11:58 am","Today, 11:58 am","Today, 11:58 am","Today, 11:58 am","Today, 11:58 am"};

    ListView recentUpdates,viewedUpdates;

    View rootview;

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {
        rootview=inflater.inflate(R.layout.status,container,false);
        recentUpdates=(ListView)rootview.findViewById(R.id.status_recent_update_listview);
        viewedUpdates=(ListView)rootview.findViewById(R.id.some);

        return rootview;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recentUpdates.setAdapter(new CustomiseList_Status(getContext(),images,data,time));
        viewedUpdates.setAdapter(new CustomiseList_Status(getContext(),images,data,time));

        ListUtils.setDynamicHeight(recentUpdates);
        ListUtils.setDynamicHeight(viewedUpdates);

    }
    public static class ListUtils {
        public static void setDynamicHeight(ListView mListView) {
            ListAdapter mListAdapter = mListView.getAdapter();
            if (mListAdapter == null) {
                // when adapter is null
                return;
            }
            int height = 0;
            int desiredWidth = View.MeasureSpec.makeMeasureSpec(mListView.getWidth(), View.MeasureSpec.UNSPECIFIED);
            for (int i = 0; i < mListAdapter.getCount(); i++) {
                View listItem = mListAdapter.getView(i, null, mListView);
                listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
                height += listItem.getMeasuredHeight();
            }
            ViewGroup.LayoutParams params = mListView.getLayoutParams();
            params.height = height + (mListView.getDividerHeight() * (mListAdapter.getCount() - 1));
            mListView.setLayoutParams(params);
            mListView.requestLayout();
        }
    }



}
