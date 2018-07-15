package com.example.vincent8280.calls;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "DetailActivity";
    private TextView table_yonghubianhao;
    private TextView table_yonghumingcheng;
    private TextView table_shoujihaoma;
    private TextView table_lianxifangshi;
    private TextView table_dianbiaohao;
    private TextView table_yingshoudianfei;
    private TextView table_yingshoudianliang;
    private TextView table_zongqianfei;
    private TextView table_zongdianfei;
    private TextView table_qianweiyuejin;
    private TextView table_qianqita;
    private TextView table_qianfujiafei;
    private TextView table_qianzhongdashuili;
    private TextView table_qianhuandaijijin;
    private TextView table_qiandifangshuikuyimin;
    private TextView table_qiankezaishengnengyuan;
    private TextView table_qianchengshifujia;
    private TextView table_dianfeinianyue;
    private TextView table_jiesuanhuhao;
    private TextView table_jiesuanhuming;
    private TextView table_chaobiaoquduan;
    private TextView table_jiliangdianchaobiaoshunxuhao;
    private TextView table_cuishoudengji;
    private TextView table_zichanbianhao;
    private TextView table_yuanchaobiaohao;
    private TextView table_chaobiaoyuan;
    private TextView table_cuifeiyuan;
    private TextView table_jiaofeifangshi;
    private TextView table_yongdianleibie;
    private TextView table_yongdiandizhi;
    private TextView table_zhangzhuantai;
    private TextView table_suodingleixing;
    private TextView table_lianwangyinhang;
    private TextView table_yinhangzhanghao;
    private TextView table_koukuanjieguo;
    private Item return_item;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);

        table_yonghubianhao = (TextView) findViewById(R.id.table_yonghubianhao);
        table_yonghumingcheng = (TextView) findViewById(R.id.table_yonghumingcheng);
        table_shoujihaoma = (TextView) findViewById(R.id.table_shoujihaoma);
        table_lianxifangshi = (TextView) findViewById(R.id.table_lianxifangshi);
        table_dianbiaohao = (TextView) findViewById(R.id.table_dianbiaohao);
        table_yingshoudianfei = (TextView) findViewById(R.id.table_yingshoudianfei);
        table_yingshoudianliang = (TextView) findViewById(R.id.table_yingshoudianliang);
        table_zongqianfei = (TextView) findViewById(R.id.table_zongqianfei);
        table_zongdianfei = (TextView) findViewById(R.id.table_zongdianfei);
        table_qianweiyuejin = (TextView) findViewById(R.id.table_qianweiyuejin);
        table_qianqita = (TextView) findViewById(R.id.table_qianqita);
        table_qianfujiafei = (TextView) findViewById(R.id.table_qianfujiafei);
        table_qianzhongdashuili = (TextView) findViewById(R.id.table_qianzhongdashuili);
        table_qianhuandaijijin = (TextView) findViewById(R.id.table_qianhuandaijijin);
        table_qiandifangshuikuyimin = (TextView) findViewById(R.id.table_qiandifangshuikuyimin);
        table_qiankezaishengnengyuan = (TextView) findViewById(R.id.table_qiankezaishengnengyuan);
        table_qianchengshifujia = (TextView) findViewById(R.id.table_qianchengshifujia);
        table_dianfeinianyue = (TextView) findViewById(R.id.table_dianfeinianyue);
        table_jiesuanhuhao = (TextView) findViewById(R.id.table_jiesuanhuhao);
        table_jiesuanhuming = (TextView) findViewById(R.id.table_jiesuanhuming);
        table_chaobiaoquduan = (TextView) findViewById(R.id.table_chaobiaoquduan);
        table_jiliangdianchaobiaoshunxuhao = (TextView) findViewById(R.id.table_jiliangdianchaobiaoshunxuhao);
        table_cuishoudengji = (TextView) findViewById(R.id.table_cuishoudengji);
        table_zichanbianhao = (TextView) findViewById(R.id.table_zichanbianhao);
        table_yuanchaobiaohao = (TextView) findViewById(R.id.table_yuanchaobiaohao);
        table_chaobiaoyuan = (TextView) findViewById(R.id.table_chaobiaoyuan);
        table_cuifeiyuan = (TextView) findViewById(R.id.table_cuifeiyuan);
        table_jiaofeifangshi = (TextView) findViewById(R.id.table_jiaofeifangshi);
        table_yongdianleibie = (TextView) findViewById(R.id.table_yongdianleibie);
        table_yongdiandizhi = (TextView) findViewById(R.id.table_yongdiandizhi);
        table_zhangzhuantai = (TextView) findViewById(R.id.table_zhangzhuantai);
        table_suodingleixing = (TextView) findViewById(R.id.table_suodingleixing);
        table_lianwangyinhang = (TextView) findViewById(R.id.table_lianwangyinhang);
        table_yinhangzhanghao = (TextView) findViewById(R.id.table_yinhangzhanghao);
        table_koukuanjieguo = (TextView) findViewById(R.id.table_koukuanjieguo);

        intent = getIntent();
        return_item = (Item) intent.getSerializableExtra("item");

        table_yonghubianhao.setText(return_item.getYonghubianhao());
        table_yonghumingcheng.setText(return_item.getYonghumingcheng());
        table_shoujihaoma.setText(return_item.getShoujihaoma());
        table_lianxifangshi.setText(return_item.getLianxifangshi());
        table_dianbiaohao.setText(return_item.getDianbiaohao());
        table_yingshoudianfei.setText(String.valueOf(return_item.getYingshoudianfei()));
        table_yingshoudianliang.setText(return_item.getYingshoudianliang());
        table_zongqianfei.setText(String.valueOf(return_item.getZongqianfei()));
        table_zongdianfei.setText(return_item.getQiandianfei());
        table_qianweiyuejin.setText(return_item.getQianweiyuejin());
        table_qianqita.setText(return_item.getQita_charge());
        table_qianfujiafei.setText(return_item.getFujiafei_charge());
        table_qianzhongdashuili.setText(return_item.getZhongdashuili_charge());
        table_qianhuandaijijin.setText(return_item.getHuandaijijin_charge());
        table_qiandifangshuikuyimin.setText(return_item.getDifangshuikuyimin_charge());
        table_qiankezaishengnengyuan.setText(return_item.getZaishengziyuan_charge());
        table_qianchengshifujia.setText(return_item.getChengshifujia_charge());
        table_dianfeinianyue.setText(return_item.getDianfeinianyue());
        table_jiesuanhuhao.setText(return_item.getJisuanhuhao());
        table_jiesuanhuming.setText(return_item.getJpsuanhumingcheng());
        table_chaobiaoquduan.setText(return_item.getChaobiaoquduanbianhao());
        table_jiliangdianchaobiaoshunxuhao.setText(return_item.getJiliangdianshunxuhao());
        table_cuishoudengji.setText(return_item.getCuishoudengji());
        table_zichanbianhao.setText(return_item.getZichanbianhao());
        table_yuanchaobiaohao.setText(return_item.getYuanchaobiaohao());
        table_chaobiaoyuan.setText(return_item.getChaobiaoyuan());
        table_cuifeiyuan.setText(return_item.getCuifeiyuan());
        table_jiaofeifangshi.setText(return_item.getJiaofeifangshi());
        table_yongdianleibie.setText(return_item.getYongdianleibie());
        table_yongdiandizhi.setText(return_item.getYongdiandizhi());
        table_zhangzhuantai.setText(return_item.getZhangzhuangtai());
        table_suodingleixing.setText(return_item.getZhangzhuangtaisuodingleixing());
        table_lianwangyinhang.setText(return_item.getLianwangyinhang());
        table_yinhangzhanghao.setText(return_item.getYinhangzhanghao());
        table_koukuanjieguo.setText(return_item.getKoukuanjieguo());
        
    }

}
