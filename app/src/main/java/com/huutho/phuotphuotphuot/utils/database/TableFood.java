package com.huutho.phuotphuotphuot.utils.database;

import android.content.ContentValues;
import android.database.Cursor;

import com.huutho.phuotphuotphuot.ui.entity.Food;

import java.util.ArrayList;

/**
 * Created by HuuTho on 2/22/2017.
 */

public class TableFood extends DbHelper implements DbCommonOperator<Food> {

    private static TableFood mInstance;

    public static synchronized TableFood getInstance() {
        if (mInstance == null) {
            mInstance = new TableFood();
        }
        return mInstance;
    }

    private TableFood() {

    }

    @Override
    public ArrayList<Food> getListData(String selection, String[] args, String orderBy) {
        ArrayList<Food> foods = new ArrayList<>();
        Cursor cursor = null;
        openDb();
        try {
            cursor = mSqlDatabase.query(DbContracts.TableFood.TABLE_FOOD, null, selection + "=?", args, null, null, orderBy);
            cursor.moveToFirst();
            int indexFoodId = cursor.getColumnIndex(DbContracts.TableFood.FOOD_ID);
            int indexFoodPlaceId = cursor.getColumnIndex(DbContracts.TableFood.FOOD_ID_PLACE);
            int indexFoodName = cursor.getColumnIndex(DbContracts.TableFood.FOOD_NAME);
            int indexFoodUrlImg = cursor.getColumnIndex(DbContracts.TableFood.FOOD_URL_IMAGE);
            int indexFoodIntro = cursor.getColumnIndex(DbContracts.TableFood.FOOD_INTRO);

            while (!cursor.isAfterLast()) {
                Food food = new Food();
                food.mIdFood = cursor.getString(indexFoodId);
                food.mIdPlace = cursor.getString(indexFoodPlaceId);
                food.mImageFood = cursor.getString(indexFoodUrlImg);
                food.mNameFood = cursor.getString(indexFoodName);
                food.mIntroFood = cursor.getString(indexFoodIntro);
                foods.add(food);
                cursor.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeDb();
        if (cursor != null && !cursor.isClosed()) cursor.close();
        return foods;
    }

    @Override
    public Food getItemData(String selection, String[] args) {
        Food food = null;
        Cursor cursor = null;
        openDb();
        try {
            cursor = mSqlDatabase.query(DbContracts.TableFood.TABLE_FOOD, null, selection + "=?", args, null, null, null);
            cursor.moveToFirst();
            int indexFoodId = cursor.getColumnIndex(DbContracts.TableFood.FOOD_ID);
            int indexFoodPlaceId = cursor.getColumnIndex(DbContracts.TableFood.FOOD_ID_PLACE);
            int indexFoodName = cursor.getColumnIndex(DbContracts.TableFood.FOOD_NAME);
            int indexFoodUrlImg = cursor.getColumnIndex(DbContracts.TableFood.FOOD_URL_IMAGE);
            int indexFoodIntro = cursor.getColumnIndex(DbContracts.TableFood.FOOD_INTRO);

            food = new Food();
            food.mIdFood = cursor.getString(indexFoodId);
            food.mIdPlace = cursor.getString(indexFoodPlaceId);
            food.mImageFood = cursor.getString(indexFoodUrlImg);
            food.mNameFood = cursor.getString(indexFoodName);
            food.mIntroFood = cursor.getString(indexFoodIntro);

        } catch (Exception e) {
            e.printStackTrace();
        }
        closeDb();
        if (cursor != null && !cursor.isClosed()) cursor.close();
        return food;
    }

    @Override
    public int delete(Food food) {
        return 0;
    }

    @Override
    public int update(Food food) {
        return 0;
    }

    @Override
    public long insert(Food food) {
        return 0;
    }

    @Override
    public ContentValues convertObjToContentValues(Food food) {
        ContentValues values = new ContentValues();
        values.put(DbContracts.TableFood.FOOD_ID, food.mIdFood);
        values.put(DbContracts.TableFood.FOOD_ID_PLACE, food.mIdPlace);
        values.put(DbContracts.TableFood.FOOD_INTRO, food.mIntroFood);
        values.put(DbContracts.TableFood.FOOD_NAME, food.mNameFood);
        values.put(DbContracts.TableFood.FOOD_URL_IMAGE, food.mImageFood);
        return null;
    }
}
