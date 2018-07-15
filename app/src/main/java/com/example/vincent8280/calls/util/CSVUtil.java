package com.example.vincent8280.calls.util;

import android.provider.ContactsContract;
import android.util.Log;

import com.example.vincent8280.calls.db.OweList;

import org.litepal.crud.DataSupport;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by vincent on 18-7-14.
 */

public class CSVUtil {
    private static final String TAG = "CSVUtil";


    public static ArrayList<String[]> read(String path) {
        File file = new File(path);
        FileInputStream fileInputStream;
        Scanner in;

        ArrayList<String[]> read_arr = new ArrayList<>();

        try {
            fileInputStream = new FileInputStream(file);
            in = new Scanner(fileInputStream, "UTF-8");
            in.nextLine();
            while (in.hasNextLine()) {
                read_arr.add(in.nextLine().split(","));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return read_arr;
    }

    public static void csv_db(ArrayList<String[]> arr, int start) {
        List owedb_list = new ArrayList<>();


        for (int i = start; i < arr.size(); i++) {
//            if (arr.get(i)[0].equals("'307007000899956")) {
//                Log.d(TAG, "csv_db: ");
//            }
//
//            if (i == 351) {
//                Log.d(TAG, "csv_db: ");
//
//            }

//            '"13000000000','13000000000"'
            if (arr.get(i)[5].contains("\"")) {
                String s = arr.get(i)[4].substring(1) + "," + arr.get(i)[5].substring(0, arr.get(i)[5].length() - 1);


                List<String> l = new ArrayList<String>();
                Log.d(TAG, "csv_db: "+arr.get(i).length);
                for (int j = 0; j < arr.get(i).length; j++) {
                    if (j==4){l.add(s);}
                    else{l.add(arr.get(i)[j]);}
                }
                l.remove(5);
                String[] newStr = l.toArray(new String[1]);
                arr.set(i, newStr);
            }
            OweList oweList_db = new OweList();
            oweList_db.setYonghubianhao(arr.get(i)[0]);
            oweList_db.setYonghumingcheng(arr.get(i)[1]);
            oweList_db.setQianfeiqishu(Float.valueOf(arr.get(i)[2]));
            oweList_db.setLianxifangshi(arr.get(i)[3]);
            oweList_db.setShoujihaoma(arr.get(i)[4]);
            oweList_db.setDianbiaohao(arr.get(i)[5]);
            oweList_db.setJiliangdianbianhao(arr.get(i)[6]);
            oweList_db.setYingshoudianliang(arr.get(i)[7]);
            oweList_db.setYingshoudianfei(Float.valueOf(arr.get(i)[8]));
            oweList_db.setDianfeinianyue(arr.get(i)[9]);
            oweList_db.setZongqianfei(Float.valueOf(arr.get(i)[10]));
            oweList_db.setQiandianfei(arr.get(i)[11]);
            oweList_db.setQianweiyuejin(arr.get(i)[12]);
            oweList_db.setQita_charge(arr.get(i)[13]);
            oweList_db.setFujiafei_charge(arr.get(i)[14]);
            oweList_db.setZhongdashuili_charge(arr.get(i)[15]);
            oweList_db.setHuandaijijin_charge(arr.get(i)[16]);
            oweList_db.setShuikuyimin_charge(arr.get(i)[17]);
            oweList_db.setDifangshuikuyimin_charge(arr.get(i)[18]);
            oweList_db.setZaishengziyuan_charge(arr.get(i)[19]);
            oweList_db.setChengshifujia_charge(arr.get(i)[20]);
            oweList_db.setChengshigonggongshiye_charge(arr.get(i)[21]);
            oweList_db.setLaimeijiagong_charge(arr.get(i)[22]);
            oweList_db.setChabiedianjia_charge(arr.get(i)[23]);
            oweList_db.setRanqiranyoufujia_charge(arr.get(i)[24]);
            oweList_db.setNongcundiyaweihu_charge(arr.get(i)[25]);
            oweList_db.setJipsuanhuhao(arr.get(i)[26]);
            oweList_db.setJpsuanhumingcheng(arr.get(i)[27]);
            oweList_db.setChaobiaoquduanbianhao(arr.get(i)[28]);
            oweList_db.setJiliangdianshunxuhao(arr.get(i)[29]);
            oweList_db.setCuishoudengji(arr.get(i)[30]);
            oweList_db.setZichanbianhao(arr.get(i)[31]);
            oweList_db.setYuanchaobiaohao(arr.get(i)[32]);
            oweList_db.setChaobiaoyuan(arr.get(i)[33]);
            oweList_db.setCuifeiyuan(arr.get(i)[34]);
            oweList_db.setYewuleibie(arr.get(i)[35]);
            oweList_db.setJiaofeifangshi(arr.get(i)[36]);
            oweList_db.setYongdianleibie(arr.get(i)[37]);
            oweList_db.setYongdiandizhi(arr.get(i)[38]);
            oweList_db.setZhangzhuangtai(arr.get(i)[39]);
            oweList_db.setZhangzhuangtaisuodingleixing(arr.get(i)[40]);
            oweList_db.setLianwangyinhang(arr.get(i)[41]);
            oweList_db.setYinhangzhanghao(arr.get(i)[42]);
            oweList_db.setKoukuanjieguo(arr.get(i)[43]);
            oweList_db.setCall_count(0);
            oweList_db.setIs_call(0);

            owedb_list.add(oweList_db);
        }

        DataSupport.saveAll(owedb_list);
    }
}