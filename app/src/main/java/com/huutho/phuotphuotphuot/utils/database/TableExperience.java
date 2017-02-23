package com.huutho.phuotphuotphuot.utils.database;

import android.content.ContentValues;

import com.huutho.phuotphuotphuot.ui.entity.ExperienceTravel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuuTho on 2/22/2017.
 */

public class TableExperience extends DbHelper implements DbCommonOperator<ExperienceTravel> {
    @Override
    public ArrayList<ExperienceTravel> getListData(String selection, String[] args, String orderBy) {
        return null;
    }

    @Override
    public ExperienceTravel getItemData(String selection, String[] args) {
        return null;
    }

    @Override
    public int delete(ExperienceTravel experienceTravel) {
        return 0;
    }

    @Override
    public int update(ExperienceTravel experienceTravel) {
        return 0;
    }

    @Override
    public long insert(ExperienceTravel experienceTravel) {
        return 0;
    }

    @Override
    public ContentValues convertObjToContentValues(ExperienceTravel experienceTravel) {
        return null;
    }
}
