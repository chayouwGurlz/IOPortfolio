package com.ciaocollect.ioportfolio.ui.skill;

import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ciaocollect.ioportfolio.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.Objects;

public class SkillFragment extends Fragment {

    private CollapsingToolbarLayout collapsingToolbar;
    private RecyclerView recyclerView;

    private SkillAdapter skillAdapter;

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        SkillViewModel skillViewModel = ViewModelProviders.of(this).get(SkillViewModel.class);
        View root = inflater.inflate(R.layout.fragment_skill, container, false);

        AppBarLayout appBarLayout1 = root.findViewById(R.id.skill_appbar);
        collapsingToolbar = root.findViewById(R.id.skill_collapsToolbar);
        collapsingToolbar.setTitle(getString(R.string.title_skill_complete));

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.my_skill);
        Palette.from(bitmap).generate(palette -> {
            int vibrantColor = Objects.requireNonNull(palette).getVibrantColor(R.color.colorPrimary);
            collapsingToolbar.setContentScrimColor(vibrantColor);
            collapsingToolbar.setStatusBarScrimColor(R.color.black_trans);
        });

        recyclerView = root.findViewById(R.id.skill_scrollView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        skillViewModel.getListSkill().observe(this, skills -> {
            skillAdapter = new SkillAdapter(getContext(), skills);
            recyclerView.setAdapter(skillAdapter);
        });

        appBarLayout1.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> Objects.requireNonNull(getActivity()).invalidateOptionsMenu());
        return root;
    }
}
