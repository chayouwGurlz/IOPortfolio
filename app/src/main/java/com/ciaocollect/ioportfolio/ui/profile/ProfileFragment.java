package com.ciaocollect.ioportfolio.ui.profile;

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

public class ProfileFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel profileViewModel = ViewModelProviders.of(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        final TextView tvName = root.findViewById(R.id.profile_name);
        final TextView tvSummary = root.findViewById(R.id.profile_summary);

        profileViewModel.getTextName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tvName.setText(s);
            }
        });

        profileViewModel.getTextSummary().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tvSummary.setText(s);
            }
        });

        return root;
    }
}