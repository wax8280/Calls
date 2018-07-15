package com.example.vincent8280.calls;

import java.io.Serializable;

/**
 * Created by vincent8280 on 2018/7/11.
 */

public class Item implements Serializable {
//可被序列化

    private String yonghubianhao;
    private String yonghumingcheng;
    private float qianfeiqishu;
    private String lianxifangshi;
    private String shoujihaoma;
    private String dianbiaohao;
    private String jiliangdianbianhao;
    private String yingshoudianliang;
    private float yingshoudianfei;
    private String dianfeinianyue;
    private float zongqianfei;
    private String zongdianfei;
    private String qiandianfei;
    private String qianweiyuejin;
    private String qita_charge;
    private String fujiafei_charge;
    private String zhongdashuili_charge;
    private String huandaijijin_charge;
    private String shuikuyimin_charge;
    private String difangshuikuyimin_charge;
    private String zaishengziyuan_charge;
    private String chengshifujia_charge;
    private String chengshigonggongshiye_charge;
    private String laimeijiagong_charge;
    private String chabiedianjia_charge;
    private String ranqiranyoufujia_charge;
    private String nongcundiyaweihu_charge;
    private String jisuanhuhao;
    private String jpsuanhumingcheng;
    private String chaobiaoquduanbianhao;
    private String jiliangdianshunxuhao;
    private String cuishoudengji;
    private String zichanbianhao;
    private String yuanchaobiaohao;
    private String chaobiaoyuan;
    private String cuifeiyuan;
    private String yewuleibie;
    private String jiaofeifangshi;
    private String yongdianleibie;
    private String yongdiandizhi;
    private String zhangzhuangtai;
    private String zhangzhuangtaisuodingleixing;
    private String lianwangyinhang;
    private String yinhangzhanghao;
    private String koukuanjieguo;

    //    call_count是自动的
    private int call_count;
    //    is_call是手动的
    private int is_call;

    public Item(String yonghubianhao, String yonghumingcheng, float qianfeiqishu, String lianxifangshi, String shoujihaoma, String dianbiaohao, String jiliangdianbianhao, String yingshoudianliang, float yingshoudianfei, String dianfeinianyue, String zongdianfei,float zongqianfei, String qiandianfei, String qianweiyuejin, String qita_charge, String fujiafei_charge, String zhongdashuili_charge, String huandaijijin_charge, String shuikuyimin_charge, String difangshuikuyimin_charge, String zaishengziyuan_charge, String chengshifujia_charge, String chengshigonggongshiye_charge, String laimeijiagong_charge, String chabiedianjia_charge, String ranqiranyoufujia_charge, String nongcundiyaweihu_charge, String jipsuanhuhao, String jpsuanhumingcheng, String chaobiaoquduanbianhao, String jiliangdianshunxuhao, String cuishoudengji, String zichanbianhao, String yuanchaobiaohao, String chaobiaoyuan, String cuifeiyuan, String yewuleibie, String jiaofeifangshi, String yongdianleibie, String yongdiandizhi, String zhangzhuangtai, String zhangzhuangtaisuodingleixing, String lianwangyinhang, String yinhangzhanghao, String koukuanjieguo, int call_count, int is_call) {
        this.yonghubianhao = yonghubianhao;
        this.yonghumingcheng = yonghumingcheng;
        this.qianfeiqishu = qianfeiqishu;
        this.lianxifangshi = lianxifangshi;
        this.shoujihaoma = shoujihaoma;
        this.dianbiaohao = dianbiaohao;
        this.jiliangdianbianhao = jiliangdianbianhao;
        this.yingshoudianliang = yingshoudianliang;
        this.yingshoudianfei = yingshoudianfei;
        this.dianfeinianyue = dianfeinianyue;
        this.zongdianfei = zongdianfei;
        this.zongqianfei = zongqianfei;
        this.qiandianfei = qiandianfei;
        this.qianweiyuejin = qianweiyuejin;
        this.qita_charge = qita_charge;
        this.fujiafei_charge = fujiafei_charge;
        this.zhongdashuili_charge = zhongdashuili_charge;
        this.huandaijijin_charge = huandaijijin_charge;
        this.shuikuyimin_charge = shuikuyimin_charge;
        this.difangshuikuyimin_charge = difangshuikuyimin_charge;
        this.zaishengziyuan_charge = zaishengziyuan_charge;
        this.chengshifujia_charge = chengshifujia_charge;
        this.chengshigonggongshiye_charge = chengshigonggongshiye_charge;
        this.laimeijiagong_charge = laimeijiagong_charge;
        this.chabiedianjia_charge = chabiedianjia_charge;
        this.ranqiranyoufujia_charge = ranqiranyoufujia_charge;
        this.nongcundiyaweihu_charge = nongcundiyaweihu_charge;
        this.jisuanhuhao = jipsuanhuhao;
        this.jpsuanhumingcheng = jpsuanhumingcheng;
        this.chaobiaoquduanbianhao = chaobiaoquduanbianhao;
        this.jiliangdianshunxuhao = jiliangdianshunxuhao;
        this.cuishoudengji = cuishoudengji;
        this.zichanbianhao = zichanbianhao;
        this.yuanchaobiaohao = yuanchaobiaohao;
        this.chaobiaoyuan = chaobiaoyuan;
        this.cuifeiyuan = cuifeiyuan;
        this.yewuleibie = yewuleibie;
        this.jiaofeifangshi = jiaofeifangshi;
        this.yongdianleibie = yongdianleibie;
        this.yongdiandizhi = yongdiandizhi;
        this.zhangzhuangtai = zhangzhuangtai;
        this.zhangzhuangtaisuodingleixing = zhangzhuangtaisuodingleixing;
        this.lianwangyinhang = lianwangyinhang;
        this.yinhangzhanghao = yinhangzhanghao;
        this.koukuanjieguo = koukuanjieguo;
        this.call_count = call_count;
        this.is_call = is_call;
    }

    public String getYonghubianhao() {
        return yonghubianhao;
    }

    public void setYonghubianhao(String yonghubianhao) {
        this.yonghubianhao = yonghubianhao;
    }

    public String getYonghumingcheng() {
        return yonghumingcheng;
    }

    public void setYonghumingcheng(String yonghumingcheng) {
        this.yonghumingcheng = yonghumingcheng;
    }

    public float getQianfeiqishu() {
        return qianfeiqishu;
    }

    public void setQianfeiqishu(float qianfeiqishu) {
        this.qianfeiqishu = qianfeiqishu;
    }

    public String getLianxifangshi() {
        return lianxifangshi;
    }

    public void setLianxifangshi(String lianxifangshi) {
        this.lianxifangshi = lianxifangshi;
    }

    public String getShoujihaoma() {
        return shoujihaoma;
    }

    public void setShoujihaoma(String shoujihaoma) {
        this.shoujihaoma = shoujihaoma;
    }

    public String getDianbiaohao() {
        return dianbiaohao;
    }

    public void setDianbiaohao(String dianbiaohao) {
        this.dianbiaohao = dianbiaohao;
    }

    public String getJiliangdianbianhao() {
        return jiliangdianbianhao;
    }

    public void setJiliangdianbianhao(String jiliangdianbianhao) {
        this.jiliangdianbianhao = jiliangdianbianhao;
    }

    public String getYingshoudianliang() {
        return yingshoudianliang;
    }

    public void setYingshoudianliang(String yingshoudianliang) {
        this.yingshoudianliang = yingshoudianliang;
    }

    public float getYingshoudianfei() {
        return yingshoudianfei;
    }

    public void setYingshoudianfei(float yingshoudianfei) {
        this.yingshoudianfei = yingshoudianfei;
    }

    public String getDianfeinianyue() {
        return dianfeinianyue;
    }

    public void setDianfeinianyue(String dianfeinianyue) {
        this.dianfeinianyue = dianfeinianyue;
    }

    public float getZongqianfei() {
        return zongqianfei;
    }

    public void setZongqianfei(float zongqianfei) {
        this.zongqianfei = zongqianfei;
    }

    public String getQiandianfei() {
        return qiandianfei;
    }

    public void setQiandianfei(String qiandianfei) {
        this.qiandianfei = qiandianfei;
    }

    public String getQianweiyuejin() {
        return qianweiyuejin;
    }

    public void setQianweiyuejin(String qianweiyuejin) {
        this.qianweiyuejin = qianweiyuejin;
    }

    public String getQita_charge() {
        return qita_charge;
    }

    public void setQita_charge(String qita_charge) {
        this.qita_charge = qita_charge;
    }

    public String getFujiafei_charge() {
        return fujiafei_charge;
    }

    public void setFujiafei_charge(String fujiafei_charge) {
        this.fujiafei_charge = fujiafei_charge;
    }

    public String getZhongdashuili_charge() {
        return zhongdashuili_charge;
    }

    public void setZhongdashuili_charge(String zhongdashuili_charge) {
        this.zhongdashuili_charge = zhongdashuili_charge;
    }

    public String getHuandaijijin_charge() {
        return huandaijijin_charge;
    }

    public void setHuandaijijin_charge(String huandaijijin_charge) {
        this.huandaijijin_charge = huandaijijin_charge;
    }

    public String getShuikuyimin_charge() {
        return shuikuyimin_charge;
    }

    public void setShuikuyimin_charge(String shuikuyimin_charge) {
        this.shuikuyimin_charge = shuikuyimin_charge;
    }

    public String getDifangshuikuyimin_charge() {
        return difangshuikuyimin_charge;
    }

    public void setDifangshuikuyimin_charge(String difangshuikuyimin_charge) {
        this.difangshuikuyimin_charge = difangshuikuyimin_charge;
    }

    public String getZaishengziyuan_charge() {
        return zaishengziyuan_charge;
    }

    public void setZaishengziyuan_charge(String zaishengziyuan_charge) {
        this.zaishengziyuan_charge = zaishengziyuan_charge;
    }

    public String getChengshifujia_charge() {
        return chengshifujia_charge;
    }

    public void setChengshifujia_charge(String chengshifujia_charge) {
        this.chengshifujia_charge = chengshifujia_charge;
    }

    public String getChengshigonggongshiye_charge() {
        return chengshigonggongshiye_charge;
    }

    public void setChengshigonggongshiye_charge(String chengshigonggongshiye_charge) {
        this.chengshigonggongshiye_charge = chengshigonggongshiye_charge;
    }

    public String getLaimeijiagong_charge() {
        return laimeijiagong_charge;
    }

    public void setLaimeijiagong_charge(String laimeijiagong_charge) {
        this.laimeijiagong_charge = laimeijiagong_charge;
    }

    public String getChabiedianjia_charge() {
        return chabiedianjia_charge;
    }

    public void setChabiedianjia_charge(String chabiedianjia_charge) {
        this.chabiedianjia_charge = chabiedianjia_charge;
    }

    public String getRanqiranyoufujia_charge() {
        return ranqiranyoufujia_charge;
    }

    public void setRanqiranyoufujia_charge(String ranqiranyoufujia_charge) {
        this.ranqiranyoufujia_charge = ranqiranyoufujia_charge;
    }

    public String getNongcundiyaweihu_charge() {
        return nongcundiyaweihu_charge;
    }

    public void setNongcundiyaweihu_charge(String nongcundiyaweihu_charge) {
        this.nongcundiyaweihu_charge = nongcundiyaweihu_charge;
    }

    public String getJisuanhuhao() {
        return jisuanhuhao;
    }

    public void setJisuanhuhao(String jisuanhuhao) {
        this.jisuanhuhao = jisuanhuhao;
    }

    public String getJpsuanhumingcheng() {
        return jpsuanhumingcheng;
    }

    public void setJpsuanhumingcheng(String jpsuanhumingcheng) {
        this.jpsuanhumingcheng = jpsuanhumingcheng;
    }

    public String getChaobiaoquduanbianhao() {
        return chaobiaoquduanbianhao;
    }

    public void setChaobiaoquduanbianhao(String chaobiaoquduanbianhao) {
        this.chaobiaoquduanbianhao = chaobiaoquduanbianhao;
    }

    public String getJiliangdianshunxuhao() {
        return jiliangdianshunxuhao;
    }

    public void setJiliangdianshunxuhao(String jiliangdianshunxuhao) {
        this.jiliangdianshunxuhao = jiliangdianshunxuhao;
    }

    public String getCuishoudengji() {
        return cuishoudengji;
    }

    public void setCuishoudengji(String cuishoudengji) {
        this.cuishoudengji = cuishoudengji;
    }

    public String getZichanbianhao() {
        return zichanbianhao;
    }

    public void setZichanbianhao(String zichanbianhao) {
        this.zichanbianhao = zichanbianhao;
    }

    public String getYuanchaobiaohao() {
        return yuanchaobiaohao;
    }

    public void setYuanchaobiaohao(String yuanchaobiaohao) {
        this.yuanchaobiaohao = yuanchaobiaohao;
    }

    public String getChaobiaoyuan() {
        return chaobiaoyuan;
    }

    public void setChaobiaoyuan(String chaobiaoyuan) {
        this.chaobiaoyuan = chaobiaoyuan;
    }

    public String getCuifeiyuan() {
        return cuifeiyuan;
    }

    public void setCuifeiyuan(String cuifeiyuan) {
        this.cuifeiyuan = cuifeiyuan;
    }

    public String getYewuleibie() {
        return yewuleibie;
    }

    public void setYewuleibie(String yewuleibie) {
        this.yewuleibie = yewuleibie;
    }

    public String getJiaofeifangshi() {
        return jiaofeifangshi;
    }

    public void setJiaofeifangshi(String jiaofeifangshi) {
        this.jiaofeifangshi = jiaofeifangshi;
    }

    public String getYongdianleibie() {
        return yongdianleibie;
    }

    public void setYongdianleibie(String yongdianleibie) {
        this.yongdianleibie = yongdianleibie;
    }

    public String getYongdiandizhi() {
        return yongdiandizhi;
    }

    public void setYongdiandizhi(String yongdiandizhi) {
        this.yongdiandizhi = yongdiandizhi;
    }

    public String getZhangzhuangtai() {
        return zhangzhuangtai;
    }

    public void setZhangzhuangtai(String zhangzhuangtai) {
        this.zhangzhuangtai = zhangzhuangtai;
    }

    public String getZhangzhuangtaisuodingleixing() {
        return zhangzhuangtaisuodingleixing;
    }

    public void setZhangzhuangtaisuodingleixing(String zhangzhuangtaisuodingleixing) {
        this.zhangzhuangtaisuodingleixing = zhangzhuangtaisuodingleixing;
    }

    public String getLianwangyinhang() {
        return lianwangyinhang;
    }

    public void setLianwangyinhang(String lianwangyinhang) {
        this.lianwangyinhang = lianwangyinhang;
    }

    public String getYinhangzhanghao() {
        return yinhangzhanghao;
    }

    public void setYinhangzhanghao(String yinhangzhanghao) {
        this.yinhangzhanghao = yinhangzhanghao;
    }

    public String getKoukuanjieguo() {
        return koukuanjieguo;
    }

    public void setKoukuanjieguo(String koukuanjieguo) {
        this.koukuanjieguo = koukuanjieguo;
    }

    public int getCall_count() {
        return call_count;
    }

    public void setCall_count(int call_count) {
        this.call_count = call_count;
    }

    public int getIs_call() {
        return is_call;
    }

    public void setIs_call(int is_call) {
        this.is_call = is_call;
    }

    public String getZongdianfei() {
        return zongdianfei;
    }

    public void setZongdianfei(String zongdianfei) {
        this.zongdianfei = zongdianfei;
    }
}
