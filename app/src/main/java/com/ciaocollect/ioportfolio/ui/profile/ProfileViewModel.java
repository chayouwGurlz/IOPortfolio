package com.ciaocollect.ioportfolio.ui.profile;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ciaocollect.ioportfolio.R;

public class ProfileViewModel extends AndroidViewModel {

    private MutableLiveData<String> mTextName;
    private MutableLiveData<String> mTextSummary;

    public ProfileViewModel(Application context) {
        super(context);
        mTextName = new MutableLiveData<>();
        mTextSummary = new MutableLiveData<>();
        mTextName.setValue(context.getString(R.string.profile_name));
        mTextSummary.setValue(context.getString(R.string.profile_summary));
    }

    public LiveData<String> getTextName() {
        return mTextName;
    }
    public LiveData<String> getTextSummary() { return mTextSummary; }
}