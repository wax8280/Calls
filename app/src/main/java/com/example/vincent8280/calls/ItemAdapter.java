package com.example.vincent8280.calls;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vincent8280.calls.db.OweList;

import org.litepal.crud.DataSupport;

import java.util.List;

import javax.xml.validation.Validator;

/**
 * Created by vincent8280 on 2018/7/11.
 */

class ViewHolder {
    TextView item_cuifeicishu;
    TextView item_header;
    TextView item_jiaofeifangshi;
    TextView item_koukuanjieguo;
    TextView item_yingshoudianfei;
    TextView item_yingshoudianliang;
    TextView item_yongdiandizhi;
}

public class ItemAdapter extends ArrayAdapter<Item> {

    private final int textViewResourceId;
    private Item list_item;
    private static final String TAG = "ItemAdapter";

    public ItemAdapter(@NonNull Context context, int textViewResourceId, @NonNull List<Item> objects) {
        super(context, textViewResourceId, objects);
        this.textViewResourceId = textViewResourceId;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //从this.objects里面获取当前项的Fruit实例。position代表第几个list，从0开始。
        list_item = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(this.textViewResourceId, null);
            viewHolder = new ViewHolder();

//                  Holder赋值
            viewHolder.item_cuifeicishu = (TextView) view.findViewById(R.id.item_cuifeicishu);
            viewHolder.item_header = (TextView) view.findViewById(R.id.item_header);
            viewHolder.item_jiaofeifangshi = (TextView) view.findViewById(R.id.item_jiaofeifangshi);
            viewHolder.item_koukuanjieguo = (TextView) view.findViewById(R.id.item_koukuanjieguo);
            viewHolder.item_yingshoudianfei = (TextView) view.findViewById(R.id.item_yingshoudianfei);
            viewHolder.item_yingshoudianliang = (TextView) view.findViewById(R.id.item_yingshoudianliang);
            viewHolder.item_yongdiandizhi = (TextView) view.findViewById(R.id.item_yongdiandizhi);
//                  存储
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = ((ViewHolder) view.getTag());
        }


        TextView item_cuifeicishu = (TextView) view.findViewById(R.id.item_cuifeicishu);
        TextView item_header = (TextView) view.findViewById(R.id.item_header);
        TextView item_jiaofeifangshi = (TextView) view.findViewById(R.id.item_jiaofeifangshi);
        TextView item_koukuanjieguo = (TextView) view.findViewById(R.id.item_koukuanjieguo);
        TextView item_yingshoudianfei = (TextView) view.findViewById(R.id.item_yingshoudianfei);
        TextView item_yingshoudianliang = (TextView) view.findViewById(R.id.item_yingshoudianliang);
        TextView item_yongdiandizhi = (TextView) view.findViewById(R.id.item_yongdiandizhi);

        item_cuifeicishu.setText(String.valueOf(list_item.getCall_count()));
        item_header.setText(list_item.getYonghumingcheng() + "(" + list_item.getYonghubianhao() + ")");
        item_jiaofeifangshi.setText(list_item.getJiaofeifangshi());
        item_koukuanjieguo.setText(list_item.getKoukuanjieguo());
        item_yingshoudianfei.setText(String.valueOf(list_item.getYingshoudianfei()));
        item_yingshoudianliang.setText(list_item.getYingshoudianliang());
        item_yongdiandizhi.setText(list_item.getYongdiandizhi());


//        "更多"按钮
        Button btn_detail = (Button) view.findViewById(R.id.btn_detail);
//        传入position,方便item里面的Button获取外面的数据
        btn_detail.setTag(position);
        btn_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(view);
            }
        });
        return view;
    }

    private void showPopupMenu(final View view) {
        // View当前PopupMenu显示的相对View的位置
        PopupMenu popupMenu = new PopupMenu(getContext(), view);
        // menu布局

        popupMenu.getMenuInflater().inflate(R.menu.detail_menu, popupMenu.getMenu());

        // menu的item点击事件
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int position = (int) view.getTag();
                switch (item.getItemId()) {
                    case R.id.detail_menu_detail:
                        Intent intent = new Intent(getContext(), DetailActivity.class);
                        intent.putExtra("item", getItem(position));
                        getContext().startActivity(intent);
                        break;

                    case R.id.detail_menu_is_call:
                        ContentValues values = new ContentValues();
                        values.put("is_call", 1);
                        DataSupport.updateAll(OweList.class, values, "yonghubianhao = ?", getItem(position).getYonghubianhao());

                        ItemAdapter.this.remove(getItem(position));
                        ItemAdapter.this.notifyDataSetChanged();
                }

                return false;
            }
        });

        // PopupMenu关闭事件
        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu menu) {
//                        Toast.makeText(getContext(), "关闭PopupMenu", Toast.LENGTH_SHORT).show();
            }
        });

        popupMenu.show();
    }
}
