package com.huutho.phuotphuotphuot.utils.database;

import android.content.ContentValues;
import android.database.Cursor;

import com.huutho.phuotphuotphuot.ui.entity.ExperienceTravel;

import java.util.ArrayList;

/**
 * Created by HuuTho on 2/22/2017.
 */

public class TableExperience extends DbHelper implements DbCommonOperator<ExperienceTravel> {

    private static TableExperience mInstance;

    public synchronized static TableExperience getInstance() {
        if (mInstance == null) {
            mInstance = new TableExperience();
        }
        return mInstance;
    }

    private TableExperience() {

    }

    @Override
    public ArrayList<ExperienceTravel> getListData(String selection, String[] args, String orderBy) {
        ArrayList<ExperienceTravel> experienceTravels = new ArrayList<>();
        Cursor cursor = null;
        try {
            openDb();

            if (selection == null && args == null) {
                cursor = mSqlDatabase.query(DbContracts.TableExperience.TABLE_EXPERIENCE, null, null, null, null, null, null);
            } else {
                cursor = mSqlDatabase.query(DbContracts.TableExperience.TABLE_EXPERIENCE, null, selection + "=?", args, null, null, orderBy);
            }

            int indexId = cursor.getColumnIndex(DbContracts.TableExperience.EXPERIENCE_ID);
            int indexName = cursor.getColumnIndex(DbContracts.TableExperience.EXPERIENCE_NAME);
            int indexDesc = cursor.getColumnIndex(DbContracts.TableExperience.EXPERIENCE_DESC);
            int indexImage = cursor.getColumnIndex(DbContracts.TableExperience.EXPERIENCE_URL_IMAGE);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {

                experienceTravels.add(new
                        ExperienceTravel.Builder()
                        .setId(cursor.getString(indexId))
                        .setName(cursor.getString(indexName))
                        .setImage(cursor.getString(indexImage))
                        .setDesc(cursor.getString(indexDesc))
                        .build());

                cursor.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        closeDb();
        return experienceTravels;
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
