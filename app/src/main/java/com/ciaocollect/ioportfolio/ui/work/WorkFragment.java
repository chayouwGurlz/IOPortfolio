package com.ciaocollect.ioportfolio.ui.work;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.ciaocollect.ioportfolio.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WorkFragment extends Fragment {

    private WorkViewModel workViewModel;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListFoodiesTitle;
    HashMap<String, List<String>> expandableListFoodiesDetail;
    private String[] foodiesImplement;
    private ArrayList<String> foodiesImplementList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        workViewModel =
                ViewModelProviders.of(this).get(WorkViewModel.class);
        View root = inflater.inflate(R.layout.fragment_work, container, false);
        /*final TextView textView = root.findViewById(R.id.text_notifications);
        workViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        expandableListView = (ExpandableListView) root.findViewById(R.id.expandable_foodies);
        foodiesImplement = getResources().getStringArray(R.array.foodies_implement);
        Log.d("irin", "foodiesImplement.length " + foodiesImplement.length);
        foodiesImplementList = new ArrayList<>();
        for(int i = 0; i<foodiesImplement.length; i++)
        {
            Log.d("irin", "foodiesImplement["+i+"] " + foodiesImplement[i]);
            foodiesImplementList.add(foodiesImplement[i]);
        }
        boolean isfoodiesImplementList;
        if(foodiesImplementList == null){
            isfoodiesImplementList = false;
        }
        else
            isfoodiesImplementList = true;
        Log.d("irin", "isfoodiesImplementList " + isfoodiesImplementList);
        expandableListFoodiesDetail = new HashMap<String, List<String>>();
        expandableListFoodiesDetail.put("Foodies Implement", foodiesImplementList);
        expandableListFoodiesTitle = new ArrayList<String>(expandableListFoodiesDetail.keySet());
        expandableListAdapter = new CustomExpandableWorkListAdapter(getContext(), expandableListFoodiesTitle, expandableListFoodiesDetail);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getActivity().getApplicationContext(), expandableListFoodiesTitle.get(groupPosition)+ "List expanded.", Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getActivity().getApplicationContext(), expandableListFoodiesTitle.get(groupPosition)+ "List collapsed.", Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getActivity().getApplicationContext(), expandableListFoodiesTitle.get(groupPosition)+ " -> " + expandableListFoodiesDetail.get(expandableListFoodiesTitle.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return root;
    }
}