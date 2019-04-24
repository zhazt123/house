package com.jk.pojo;

import java.io.Serializable;

public class HouseBean implements Serializable {
    private static final long serialVersionUID = -8120097951324978480L;
    private String id;
    private String name;
    private String info;
    private Double price;
    private String houseHuXing; //房屋户型
    private Double houseMianji; //房屋面积
    private String houseNeimianji; //房屋套内面积
    private String houseChaoXiang; //房屋朝向
    private String houseZhuangXiu; //房屋装修
    private String houseGongNuan;  //房屋供暖
    private String houseChanQuan;  //房屋产权
    private String houseLouCen;  //房屋楼层
    private String houseJieGou;  //房子结构
    private String houseLeixing;  //房子类型
    private String houseHuXingJieGou;   //房子户型结构
    private String houseTiHu;//房子梯户结构
    private String yyupTime;//挂牌时间
    private String yyupOneTime;//上一次交易
    private String houseNianXian;//房屋年限
    private String yyDiYa;  //抵押信息
    private String yyQuanShu;  //交易权属
    private String houseYongTu; //房屋用途
    private String yySuoShu;  //产权所属
    private String houseBeiJian;//房屋备件
    private String houseTeSe;//房屋特色
    private String houseXiaoQu;//房屋小区
    private String houseJiaoTong;//房子交通
    private String houseShuiFei;//税费解析
    private String houseHuXingJieShao;//户型介绍
    private String houseXiaoQuName;//小区名称
    private String img;
    private String area;
    private Integer nowdate;
    private Long startPrice;
    private Double danjia;

    private Long endPrice;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getHouseHuXing() {
        return houseHuXing;
    }

    public void setHouseHuXing(String houseHuXing) {
        this.houseHuXing = houseHuXing;
    }

    public Double getHouseMianji() {
        return houseMianji;
    }

    public void setHouseMianji(Double houseMianji) {
        this.houseMianji = houseMianji;
    }

    public String getHouseNeimianji() {
        return houseNeimianji;
    }

    public void setHouseNeimianji(String houseNeimianji) {
        this.houseNeimianji = houseNeimianji;
    }

    public String getHouseChaoXiang() {
        return houseChaoXiang;
    }

    public void setHouseChaoXiang(String houseChaoXiang) {
        this.houseChaoXiang = houseChaoXiang;
    }

    public String getHouseZhuangXiu() {
        return houseZhuangXiu;
    }

    public void setHouseZhuangXiu(String houseZhuangXiu) {
        this.houseZhuangXiu = houseZhuangXiu;
    }

    public String getHouseGongNuan() {
        return houseGongNuan;
    }

    public void setHouseGongNuan(String houseGongNuan) {
        this.houseGongNuan = houseGongNuan;
    }

    public String getHouseChanQuan() {
        return houseChanQuan;
    }

    public void setHouseChanQuan(String houseChanQuan) {
        this.houseChanQuan = houseChanQuan;
    }

    public String getHouseLouCen() {
        return houseLouCen;
    }

    public void setHouseLouCen(String houseLouCen) {
        this.houseLouCen = houseLouCen;
    }

    public String getHouseJieGou() {
        return houseJieGou;
    }

    public void setHouseJieGou(String houseJieGou) {
        this.houseJieGou = houseJieGou;
    }

    public String getHouseLeixing() {
        return houseLeixing;
    }

    public void setHouseLeixing(String houseLeixing) {
        this.houseLeixing = houseLeixing;
    }

    public String getHouseHuXingJieGou() {
        return houseHuXingJieGou;
    }

    public void setHouseHuXingJieGou(String houseHuXingJieGou) {
        this.houseHuXingJieGou = houseHuXingJieGou;
    }

    public String getHouseTiHu() {
        return houseTiHu;
    }

    public void setHouseTiHu(String houseTiHu) {
        this.houseTiHu = houseTiHu;
    }

    public String getYyupTime() {
        return yyupTime;
    }

    public void setYyupTime(String yyupTime) {
        this.yyupTime = yyupTime;
    }

    public String getYyupOneTime() {
        return yyupOneTime;
    }

    public void setYyupOneTime(String yyupOneTime) {
        this.yyupOneTime = yyupOneTime;
    }

    public String getHouseNianXian() {
        return houseNianXian;
    }

    public void setHouseNianXian(String houseNianXian) {
        this.houseNianXian = houseNianXian;
    }

    public String getYyDiYa() {
        return yyDiYa;
    }

    public void setYyDiYa(String yyDiYa) {
        this.yyDiYa = yyDiYa;
    }

    public String getYyQuanShu() {
        return yyQuanShu;
    }

    public void setYyQuanShu(String yyQuanShu) {
        this.yyQuanShu = yyQuanShu;
    }

    public String getHouseYongTu() {
        return houseYongTu;
    }

    public void setHouseYongTu(String houseYongTu) {
        this.houseYongTu = houseYongTu;
    }

    public String getYySuoShu() {
        return yySuoShu;
    }

    public void setYySuoShu(String yySuoShu) {
        this.yySuoShu = yySuoShu;
    }

    public String getHouseBeiJian() {
        return houseBeiJian;
    }

    public void setHouseBeiJian(String houseBeiJian) {
        this.houseBeiJian = houseBeiJian;
    }

    public String getHouseTeSe() {
        return houseTeSe;
    }

    public void setHouseTeSe(String houseTeSe) {
        this.houseTeSe = houseTeSe;
    }

    public String getHouseXiaoQu() {
        return houseXiaoQu;
    }

    public void setHouseXiaoQu(String houseXiaoQu) {
        this.houseXiaoQu = houseXiaoQu;
    }

    public String getHouseJiaoTong() {
        return houseJiaoTong;
    }

    public void setHouseJiaoTong(String houseJiaoTong) {
        this.houseJiaoTong = houseJiaoTong;
    }

    public String getHouseShuiFei() {
        return houseShuiFei;
    }

    public void setHouseShuiFei(String houseShuiFei) {
        this.houseShuiFei = houseShuiFei;
    }

    public String getHouseHuXingJieShao() {
        return houseHuXingJieShao;
    }

    public void setHouseHuXingJieShao(String houseHuXingJieShao) {
        this.houseHuXingJieShao = houseHuXingJieShao;
    }

    public String getHouseXiaoQuName() {
        return houseXiaoQuName;
    }

    public void setHouseXiaoQuName(String houseXiaoQuName) {
        this.houseXiaoQuName = houseXiaoQuName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getNowdate() {
        return nowdate;
    }

    public void setNowdate(Integer nowdate) {
        this.nowdate = nowdate;
    }

    public Long getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Long startPrice) {
        this.startPrice = startPrice;
    }

    public Long getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(Long endPrice) {
        this.endPrice = endPrice;
    }

    public Double getDanjia() {
        return danjia;
    }

    public void setDanjia(Double danjia) {
        this.danjia = danjia;
    }

    @Override
    public String toString() {
        return "HouseBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", price=" + price +
                ", houseHuXing='" + houseHuXing + '\'' +
                ", houseMianji='" + houseMianji + '\'' +
                ", houseNeimianji='" + houseNeimianji + '\'' +
                ", houseChaoXiang='" + houseChaoXiang + '\'' +
                ", houseZhuangXiu='" + houseZhuangXiu + '\'' +
                ", houseGongNuan='" + houseGongNuan + '\'' +
                ", houseChanQuan='" + houseChanQuan + '\'' +
                ", houseLouCen='" + houseLouCen + '\'' +
                ", houseJieGou='" + houseJieGou + '\'' +
                ", houseLeixing='" + houseLeixing + '\'' +
                ", houseHuXingJieGou='" + houseHuXingJieGou + '\'' +
                ", houseTiHu='" + houseTiHu + '\'' +
                ", yyupTime='" + yyupTime + '\'' +
                ", yyupOneTime='" + yyupOneTime + '\'' +
                ", houseNianXian='" + houseNianXian + '\'' +
                ", yyDiYa='" + yyDiYa + '\'' +
                ", yyQuanShu='" + yyQuanShu + '\'' +
                ", houseYongTu='" + houseYongTu + '\'' +
                ", yySuoShu='" + yySuoShu + '\'' +
                ", houseBeiJian='" + houseBeiJian + '\'' +
                ", houseTeSe='" + houseTeSe + '\'' +
                ", houseXiaoQu='" + houseXiaoQu + '\'' +
                ", houseJiaoTong='" + houseJiaoTong + '\'' +
                ", houseShuiFei='" + houseShuiFei + '\'' +
                ", houseHuXingJieShao='" + houseHuXingJieShao + '\'' +
                ", houseXiaoQuName='" + houseXiaoQuName + '\'' +
                ", img='" + img + '\'' +
                ", area='" + area + '\'' +
                ", nowdate=" + nowdate +
                ", startPrice=" + startPrice +
                ", danjia=" + danjia +
                ", endPrice=" + endPrice +
                '}';
    }
}
