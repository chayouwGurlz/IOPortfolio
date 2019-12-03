package com.ciaocollect.ioportfolio.ui.work;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.ciaocollect.ioportfolio.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class WorkFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        WorkViewModel workViewModel = ViewModelProviders.of(this).get(WorkViewModel.class);
        View root = inflater.inflate(R.layout.fragment_work, container, false);

        final ArrayList<String> titleWorkList = new ArrayList<>();
        final ArrayList<String> moeWorkList = new ArrayList<>();
        final ArrayList<String> unoWorkList = new ArrayList<>();
        final ArrayList<String> drWorkList = new ArrayList<>();
        final ArrayList<String> pcrWorkList = new ArrayList<>();
        final ArrayList<String> rndWorkList = new ArrayList<>();
        final ArrayList<String> mlpWorkList = new ArrayList<>();
        final ArrayList<String> foodiesWorkList = new ArrayList<>();
        final LinkedHashMap<String, List<String>> expandableListDetail = new LinkedHashMap<String, List<String>>();
        final ExpandableListView expandableListView = (ExpandableListView) root.findViewById(R.id.expandablework);

        workViewModel.getMoeDescription().observe(this, moeDescription -> Collections.addAll(moeWorkList, moeDescription));

        workViewModel.getUnoDescription().observe(this, unoDescription -> Collections.addAll(unoWorkList, unoDescription));

        workViewModel.getDrDescription().observe(this, drDescription -> Collections.addAll(drWorkList, drDescription));

        workViewModel.getPcrDescription().observe(this, pcrDescription -> Collections.addAll(pcrWorkList, pcrDescription));

        workViewModel.getRndDescription().observe(this, rndDescription -> Collections.addAll(rndWorkList, rndDescription));

        workViewModel.getMlpDescription().observe(this, mlpDescription -> Collections.addAll(mlpWorkList, mlpDescription));

        workViewModel.getFoodiesDescription().observe(this, foodiesDescription -> Collections.addAll(foodiesWorkList, foodiesDescription));

        workViewModel.getTitleWork().observe(this, titleWork -> {
            Collections.addAll(titleWorkList, titleWork);

            expandableListDetail.put(titleWorkList.get(0), moeWorkList);
            expandableListDetail.put(titleWorkList.get(1), unoWorkList);
            expandableListDetail.put(titleWorkList.get(2), drWorkList);
            expandableListDetail.put(titleWorkList.get(3), pcrWorkList);
            expandableListDetail.put(titleWorkList.get(4), rndWorkList);
            expandableListDetail.put(titleWorkList.get(5), mlpWorkList);
            expandableListDetail.put(titleWorkList.get(6), foodiesWorkList);

            List<String> expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
            ExpandableListAdapter expandableListAdapter = new WorkAdapter(getContext(), expandableListTitle, expandableListDetail);
            expandableListView.setAdapter(expandableListAdapter);
        });
        return root;
    }
}