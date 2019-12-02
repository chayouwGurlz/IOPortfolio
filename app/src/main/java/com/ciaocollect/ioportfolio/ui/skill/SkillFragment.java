package com.ciaocollect.ioportfolio.ui.skill;

import androidx.lifecycle.ViewModelProviders;

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
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.ciaocollect.ioportfolio.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class SkillFragment extends Fragment {

    private SkillViewModel skillViewModel;
    private CollapsingToolbarLayout collapsingToolbar;
    private AppBarLayout appBarLayout;
    private RecyclerView recyclerView;

    private SkillAdapter skillAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        skillViewModel =
                ViewModelProviders.of(this).get(SkillViewModel.class);
        View root = inflater.inflate(R.layout.fragment_skill, container, false);

        appBarLayout = root.findViewById(R.id.skill_appbar);
        collapsingToolbar = root.findViewById(R.id.skill_collapsToolbar);
        collapsingToolbar.setTitle(getString(R.string.title_skill_complete));

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.my_skill);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @SuppressWarnings("ResourceType")
            @Override
            public void onGenerated(Palette palette) {
                int vibrantColor = palette.getVibrantColor(R.color.colorPrimary);
                collapsingToolbar.setContentScrimColor(vibrantColor);
                collapsingToolbar.setStatusBarScrimColor(R.color.black_trans);
            }
        });

        recyclerView = root.findViewById(R.id.skill_scrollView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        skillAdapter = new SkillAdapter(getContext());
        recyclerView.setAdapter(skillAdapter);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                    getActivity().invalidateOptionsMenu();
            }
        });
        return root;
    }
}
