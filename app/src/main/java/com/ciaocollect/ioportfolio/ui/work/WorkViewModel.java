package com.ciaocollect.ioportfolio.ui.work;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ciaocollect.ioportfolio.R;

public class WorkViewModel extends AndroidViewModel {

    private MutableLiveData<String[]> moeDescription;
    private MutableLiveData<String[]> unoDescription;
    private MutableLiveData<String[]> drDescription;
    private MutableLiveData<String[]> pcrDescription;
    private MutableLiveData<String[]> rndDescription;
    private MutableLiveData<String[]> mlpDescription;
    private MutableLiveData<String[]> foodiesDescription;
    private MutableLiveData<String[]> titleWork;

    LiveData<String[]> getMoeDescription() {
        return moeDescription;
    }
    LiveData<String[]> getUnoDescription() {
        return unoDescription;
    }
    LiveData<String[]> getDrDescription() {
        return drDescription;
    }
    LiveData<String[]> getPcrDescription() {
        return pcrDescription;
    }
    LiveData<String[]> getRndDescription() {
        return rndDescription;
    }
    LiveData<String[]> getMlpDescription() {
        return mlpDescription;
    }
    LiveData<String[]> getFoodiesDescription() {
        return foodiesDescription;
    }
    LiveData<String[]> getTitleWork() {
        return titleWork;
    }

    public WorkViewModel(Application context) {
        super(context);
        moeDescription = new MutableLiveData<String[]>();
        unoDescription = new MutableLiveData<String[]>();
        drDescription = new MutableLiveData<String[]>();
        pcrDescription = new MutableLiveData<String[]>();
        rndDescription = new MutableLiveData<String[]>();
        mlpDescription = new MutableLiveData<String[]>();
        foodiesDescription = new MutableLiveData<String[]>();
        titleWork = new MutableLiveData<String[]>();

        moeDescription.postValue(context.getResources().getStringArray(R.array.moe_description));
        unoDescription.postValue(context.getResources().getStringArray(R.array.uno_description));
        drDescription.postValue(context.getResources().getStringArray(R.array.dr_description));
        pcrDescription.postValue(context.getResources().getStringArray(R.array.pcr_description));
        rndDescription.postValue(context.getResources().getStringArray(R.array.rnd_description));
        mlpDescription.postValue(context.getResources().getStringArray(R.array.mlp_description));
        foodiesDescription.postValue(context.getResources().getStringArray(R.array.foodies_description));
        titleWork.postValue(context.getResources().getStringArray(R.array.work_title));
    }
}