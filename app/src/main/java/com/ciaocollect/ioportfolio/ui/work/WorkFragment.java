package com.ciaocollect.ioportfolio.ui.work;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.ciaocollect.ioportfolio.R;

public class WorkFragment extends Fragment {

    private WorkViewModel workViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        workViewModel =
                ViewModelProviders.of(this).get(WorkViewModel.class);
        View root = inflater.inflate(R.layout.fragment_study, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        workViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}