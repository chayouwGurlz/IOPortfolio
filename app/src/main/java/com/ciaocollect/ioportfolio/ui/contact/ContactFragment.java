package com.ciaocollect.ioportfolio.ui.contact;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ciaocollect.ioportfolio.R;

import java.util.Objects;

public class ContactFragment extends Fragment {

    public static ContactFragment newInstance() {
        return new ContactFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ContactViewModel mViewModel = ViewModelProviders.of(this).get(ContactViewModel.class);

        final TextView tvTitle = Objects.requireNonNull(getActivity()).findViewById(R.id.contact_title);
        final TextView tvEmail = getActivity().findViewById(R.id.contact_email);
        final TextView tvPhone = getActivity().findViewById(R.id.contact_phone);
        final TextView tvWhatsapp = getActivity().findViewById(R.id.contact_whatsapp);
        final TextView tvLinkedin = getActivity().findViewById(R.id.contact_linkedin);
        final TextView tvGithub = getActivity().findViewById(R.id.contact_github);
        final TextView tvLocation = getActivity().findViewById(R.id.contact_location);

        mViewModel.getTextSubhead().observe(this, tvTitle::setText);
        mViewModel.getTextEmail().observe(this, tvEmail::setText);
        mViewModel.getTextPhone().observe(this, tvPhone::setText);
        mViewModel.getTextWhatsapp().observe(this, tvWhatsapp::setText);
        mViewModel.getTextLinkedin().observe(this, tvLinkedin::setText);
        mViewModel.getTextGithub().observe(this, tvGithub::setText);
        mViewModel.getTextLocation().observe(this, tvLocation::setText);

        tvEmail.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "irineoctaviana@yahoo.com", null));
            startActivity(intent);
        });

        tvPhone.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+6285755258855", null));
            startActivity(intent);
        });

        tvWhatsapp.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://api.whatsapp.com/send?phone=+6285755258855&text="+"Hello..."));
            startActivity(intent);
        });

        tvLinkedin.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/irine-octaviana-b95293a2/"));
            startActivity(intent);
        });

        tvGithub.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/chayouwGurlz/"));
            startActivity(intent);
        });

        tvLocation.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.google.co.id/maps?q=kos putri parkit 4"));
            startActivity(intent);
        });
    }

}
