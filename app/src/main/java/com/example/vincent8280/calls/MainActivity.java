package com.example.vincent8280.calls;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vincent8280.calls.db.OweList;
import com.example.vincent8280.calls.util.CSVUtil;
import com.example.vincent8280.calls.util.Uri2Path;

import org.litepal.crud.DataSupport;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private List<Item> data = new ArrayList<>();
    private CharSequence[] select_sort = {"默认", "按户名", "按户名(降序)", "按户号", "按户号(降序)", "按电费", "按电费(降序)", "催费次数", "催费次数(降序)"};//对话框中显示的条目内容
    private AlertDialog.Builder alertDialog_builder;
    private AlertDialog alertDialog;
    private DrawerLayout mDrawerLayout;
    private ListView listView;
    private NavigationView navigationView;
    private Button btn_sort_btn;
    private Button btn_nav_menu;
    private Uri csv_uri;
    private String csv_path;
    private List<OweList> owelist;
    private ItemAdapter itemAdapter;
    private boolean is_selsect_called = false;
    private int nav_last_selected = R.id.nav_not_call;
    private AlertDialog phone_alertDialog;
    private AlertDialog.Builder phone_alertDialog_builder;
    private Button nav_search_btn;
    private TextView tv_title_city;
    private EditText search_edittext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Init函数
        permision_check();

//        Find部分
        listView = (ListView) findViewById(R.id.list_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        btn_sort_btn = (Button) findViewById(R.id.nav_sort_btn);
        btn_nav_menu = (Button) findViewById(R.id.nav_menu_button);
        nav_search_btn = (Button) findViewById(R.id.nav_search_btn);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        tv_title_city = (TextView) findViewById(R.id.tv_title_city);
        search_edittext = (EditText) findViewById(R.id.search_edittext);

//        ListView设置
        itemAdapter = new ItemAdapter(MainActivity.this, R.layout.item, data);
        listView.setAdapter(itemAdapter);

//        Set Listener部分
        init_date(0);
        init_sort_toolbar();
        init_btn();
        init_listview();
        init_nav();


    }


    private void init_btn() {
        btn_sort_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog = alertDialog_builder.show();
            }
        });

        btn_nav_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        search_edittext.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    tv_title_city.setVisibility(View.VISIBLE);
                    btn_sort_btn.setVisibility(View.VISIBLE);
                    search_edittext.setVisibility(View.GONE);
                }
            }
        });

        nav_search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(search_edittext.getVisibility()==View.GONE) {
                    tv_title_city.setVisibility(View.GONE);
                    btn_sort_btn.setVisibility(View.GONE);
                    search_edittext.setVisibility(View.VISIBLE);

                    search_edittext.setFocusable(true);
                    search_edittext.setFocusableInTouchMode(true);
                    search_edittext.requestFocus();
                    InputMethodManager imm = (InputMethodManager)MainActivity.this.getSystemService(MainActivity.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                }else{
                    tv_title_city.setVisibility(View.VISIBLE);
                    btn_sort_btn.setVisibility(View.VISIBLE);
                    search_edittext.setVisibility(View.GONE);
                }




            }
        });
    }

    private void init_listview() {
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {


                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String lianxifangshi = data.get(position).getLianxifangshi();
                        String shoujihaoma = data.get(position).getShoujihaoma();
                        String[] shoujihaoma_array = {};

                        List<String> phone_arrary = new ArrayList<>();

                        if (shoujihaoma.contains(",")) {
                            shoujihaoma_array = shoujihaoma.split(",");
                        }

//                拨打电话
                        if (lianxifangshi.isEmpty()) {
                            if (shoujihaoma_array.length > 0) {
//                        0,2
                                Collections.addAll(phone_arrary, shoujihaoma_array);
                            } else if (shoujihaoma.isEmpty()) {
//                        0,0
                            } else {
//                        0,1
                                ContentValues values = new ContentValues();
                                int call_count = data.get(position).getCall_count();
                                values.put("call_count", call_count + 1);
                                DataSupport.updateAll(OweList.class, values, "yonghubianhao = ?", data.get(position).getYonghubianhao());

                                Intent Intent = new Intent(android.content.Intent.ACTION_DIAL, Uri.parse("tel:" + shoujihaoma));
                                startActivity(Intent);
                            }
                        } else {
                            if (shoujihaoma_array.length > 0) {
//                        1,2
                                Collections.addAll(phone_arrary, shoujihaoma_array);
                                phone_arrary.add(lianxifangshi);

                            } else if (shoujihaoma.isEmpty()) {
//                        1,0
                                ContentValues values = new ContentValues();
                                int call_count = data.get(position).getCall_count();
                                values.put("call_count", call_count + 1);
                                DataSupport.updateAll(OweList.class, values, "yonghubianhao = ?", data.get(position).getYonghubianhao());

                                Intent Intent = new Intent(android.content.Intent.ACTION_DIAL, Uri.parse("tel:" + lianxifangshi));
                                startActivity(Intent);
                            } else {
//                        1,1
                                phone_arrary.add(lianxifangshi);
                                phone_arrary.add(shoujihaoma);
                            }
                        }

                        if (!phone_arrary.isEmpty()) {
//                            String[] numlist = new String[phone_arrary.size()];
                            final CharSequence [] num_list =phone_arrary.toArray(new CharSequence[phone_arrary.size()]);

//                    显示alertDialog提供选择
                            phone_alertDialog_builder = new AlertDialog.Builder(MainActivity.this).
                                    setTitle("选择号码").setSingleChoiceItems(num_list, 0, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent Intent = new Intent(android.content.Intent.ACTION_DIAL, Uri.parse("tel:" + num_list[i]));
                                    startActivity(Intent);
                                    alertDialog.dismiss();
                                }
                            });
                            phone_alertDialog = phone_alertDialog_builder.show();
                        }

                    }
                }
        );
    }


    private void init_nav() {
        navigationView.setCheckedItem(nav_last_selected);   //默认勾选
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_import_csv:
//                        TODO:more
                        showFileChooser();
                        break;
                    case R.id.nav_done_call:
                        nav_last_selected = R.id.nav_done_call;
                        is_selsect_called = true;
                        init_date(0);
                        itemAdapter.notifyDataSetChanged();
                        break;
                    case R.id.nav_not_call:
                        nav_last_selected = R.id.nav_not_call;
                        is_selsect_called = false;
                        init_date(0);
                        itemAdapter.notifyDataSetChanged();
                        break;


                }
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }


    private void init_sort_toolbar() {
        alertDialog_builder = new AlertDialog.Builder(MainActivity.this).
                setTitle("排序").setSingleChoiceItems(select_sort, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                init_date(i);
                itemAdapter.notifyDataSetChanged();
                listView.setSelection(0);
                alertDialog.dismiss();
            }
        });

    }


    private void init_date(int sort_type) {

        if (is_selsect_called) {
            switch (sort_type) {
                case 0:
//                默认
                    owelist = DataSupport.where("is_call = ?", "1").find(OweList.class);
                    break;
                case 1:
//                户名
                    owelist = DataSupport.where("is_call = ?", "1").order("yonghumingcheng collate localized").find(OweList.class);
                    break;
                case 2:
//                户名
                    owelist = DataSupport.where("is_call = ?", "1").order("yonghumingcheng collate localized desc").find(OweList.class);
                    break;

                case 3:
//                户号
                    owelist = DataSupport.where("is_call = ?", "1").order("yonghubianhao").find(OweList.class);
                    break;
                case 4:
//                户号
                    owelist = DataSupport.where("is_call = ?", "1").order("yonghubianhao desc").find(OweList.class);
                    break;

                case 5:
//                应收电费
                    owelist = DataSupport.where("is_call = ?", "1").order("yingshoudianfei").find(OweList.class);
                    break;
                case 6:
//                应收电费
                    owelist = DataSupport.where("is_call = ?", "1").order("yingshoudianfei desc").find(OweList.class);
                    break;
                case 7:
//                催费次数
                    owelist = DataSupport.where("is_call = ?", "1").order("call_count").find(OweList.class);
                    break;
                case 8:
//                催费次数
                    owelist = DataSupport.where("is_call = ?", "1").order("call_count desc").find(OweList.class);
                    break;
            }
        } else {
            switch (sort_type) {
                case 0:
//                默认
                    owelist = DataSupport.where("is_call = ?", "0").find(OweList.class);
                    break;
                case 1:
//                户名
                    owelist = DataSupport.where("is_call = ?", "0").order("yonghumingcheng collate localized").find(OweList.class);
                    break;
                case 2:
//                户名
                    owelist = DataSupport.where("is_call = ?", "0").order("yonghumingcheng collate localized desc").find(OweList.class);
                    break;

                case 3:
//                户号
                    owelist = DataSupport.where("is_call = ?", "0").order("yonghubianhao").find(OweList.class);
                    break;
                case 4:
//                户号
                    owelist = DataSupport.where("is_call = ?", "0").order("yonghubianhao desc").find(OweList.class);
                    break;

                case 5:
//                应收电费
                    owelist = DataSupport.where("is_call = ?", "0").order("yingshoudianfei").find(OweList.class);
                    break;
                case 6:
//                应收电费
                    owelist = DataSupport.where("is_call = ?", "0").order("yingshoudianfei desc").find(OweList.class);
                    break;
                case 7:
//                催费次数
                    owelist = DataSupport.where("is_call = ?", "0").order("call_count").find(OweList.class);
                    break;
                case 8:
//                催费次数
                    owelist = DataSupport.where("is_call = ?", "0").order("call_count desc").find(OweList.class);
                    break;
            }
        }


        data.clear();
        for (
                OweList x : owelist
                )

        {
            data.add(new Item(
                    x.getYonghubianhao(), x.getYonghumingcheng(), x.getQianfeiqishu(), x.getLianxifangshi(),
                    x.getShoujihaoma(), x.getDianbiaohao(), x.getJiliangdianbianhao(), x.getYingshoudianliang(),
                    x.getYingshoudianfei(), x.getDianfeinianyue(), x.getZongdianfei(), x.getZongqianfei(), x.getQiandianfei(),
                    x.getQianweiyuejin(), x.getQita_charge(), x.getFujiafei_charge(), x.getZhongdashuili_charge(),
                    x.getHuandaijijin_charge(), x.getShuikuyimin_charge(), x.getDifangshuikuyimin_charge(),
                    x.getZaishengziyuan_charge(), x.getChengshifujia_charge(), x.getChengshigonggongshiye_charge(),
                    x.getLaimeijiagong_charge(), x.getChabiedianjia_charge(), x.getRanqiranyoufujia_charge(),
                    x.getNongcundiyaweihu_charge(), x.getJipsuanhuhao(), x.getJpsuanhumingcheng(), x.getChaobiaoquduanbianhao(),
                    x.getJiliangdianshunxuhao(), x.getCuishoudengji(), x.getZichanbianhao(), x.getYuanchaobiaohao(), x.getChaobiaoyuan(),
                    x.getCuifeiyuan(), x.getYewuleibie(), x.getJiaofeifangshi(), x.getYongdianleibie(), x.getYongdiandizhi(),
                    x.getZhangzhuangtai(), x.getZhangzhuangtaisuodingleixing(), x.getLianwangyinhang(), x.getYinhangzhanghao(),
                    x.getKoukuanjieguo(), x.getCall_count(), x.getIs_call()));
        }

    }


    private void permision_check() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //申请WRITE_EXTERNAL_STORAGE权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
        }
    }


    private void showFileChooser() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        try {
            startActivityForResult(Intent.createChooser(intent, "请选择一个题库文件"), 0);
        } catch (android.content.ActivityNotFoundException ex) {
            // Potentially direct the user to the Market with a Dialog
            Toast.makeText(MainActivity.this, "请安装文件管理器", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        switch (requestCode) {
            case 0:
                csv_uri = data.getData();
                csv_path = Uri2Path.getPathByUri4kitkat(MainActivity.this, csv_uri);
                ArrayList<String[]> read = CSVUtil.read(csv_path);
                CSVUtil.csv_db(read, 1);
                init_date(0);
                itemAdapter.notifyDataSetChanged();
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
