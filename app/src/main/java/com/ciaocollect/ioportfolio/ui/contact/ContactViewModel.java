package com.ciaocollect.ioportfolio.ui.contact;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ciaocollect.ioportfolio.R;

public class ContactViewModel extends AndroidViewModel {

    private MutableLiveData<String> mTextSubhead;
    private MutableLiveData<String> mTextEmail;
    private MutableLiveData<String> mTextPhone;
    private MutableLiveData<String> mTextWhatsapp;
    private MutableLiveData<String> mTextLinkedin;
    private MutableLiveData<String> mTextGithub;
    private MutableLiveData<String> mTextLocation;
    private MutableLiveData<String> mTextInfo;

    public ContactViewModel(@NonNull Application context) {
        super(context);
        mTextSubhead = new MutableLiveData<>();
        mTextEmail = new MutableLiveData<>();
        mTextPhone = new MutableLiveData<>();
        mTextWhatsapp = new MutableLiveData<>();
        mTextLinkedin = new MutableLiveData<>();
        mTextGithub = new MutableLiveData<>();
        mTextLocation = new MutableLiveData<>();
        mTextInfo = new MutableLiveData<>();

        mTextSubhead.setValue(context.getString(R.string.contact_subhead));
        mTextEmail.setValue(context.getString(R.string.contact_email));
        mTextPhone.setValue(context.getString(R.string.contact_phone));
        mTextWhatsapp.setValue(context.getString(R.string.contact_whatsapp));
        mTextLinkedin.setValue(context.getString(R.string.contact_linkedin));
        mTextGithub.setValue(context.getString(R.string.contact_github));
        mTextLocation.setValue(context.getString(R.string.contact_location));
        mTextInfo.setValue(context.getString(R.string.contact_info));
    }

    LiveData<String> getTextSubhead() {
        return mTextSubhead;
    }
    LiveData<String> getTextEmail() { return mTextEmail; }
    LiveData<String> getTextPhone() { return mTextPhone; }
    LiveData<String> getTextWhatsapp() { return mTextWhatsapp; }
    LiveData<String> getTextLinkedin() { return mTextLinkedin; }
    LiveData<String> getTextGithub() { return mTextGithub; }
    LiveData<String> getTextLocation() { return mTextLocation; }
    LiveData<String> getTextInfo() { return mTextInfo; }
}
