package com.neusoft.zhubo.bean;

import java.util.Date;

public class ZhuBo {
	private String userId;//主播id
	private String zhuBoName;//主播名字
	private String zhuBoRealName;//主播真实名字
	private String gender;//性别
	private Date birth;//主播生日
	private String introduce;//主播介绍
	private String imgdir;//图片介绍地址
	private String zhuBoGroup;//主播组
	private String ifVaild;//是否有效
	private String url;//直播地址
	private String keyWord;//关键字
	private Date addDate;//新增时间
	private Date modifDate;//修改时间
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getZhuBoName() {
		return zhuBoName;
	}
	public void setZhuBoName(String zhuBoName) {
		this.zhuBoName = zhuBoName;
	}
	public String getZhuBoRealName() {
		return zhuBoRealName;
	}
	public void setZhuBoRealName(String zhuBoRealName) {
		this.zhuBoRealName = zhuBoRealName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getImgdir() {
		return imgdir;
	}
	public void setImgdir(String imgdir) {
		this.imgdir = imgdir;
	}
	public String getZhuBoGroup() {
		return zhuBoGroup;
	}
	public void setZhuBoGroup(String zhuBoGroup) {
		this.zhuBoGroup = zhuBoGroup;
	}
	public String getIfVaild() {
		return ifVaild;
	}
	public void setIfVaild(String ifVaild) {
		this.ifVaild = ifVaild;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
	public Date getAddDate() {
		return addDate;
	}
	
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	
	public Date getModifDate() {
		return modifDate;
	}
	
	public void setModifDate(Date modifDate) {
		this.modifDate = modifDate;
	}
	
	public ZhuBo(String userId, String zhuBoName, String zhuBoRealName,
			String gender, Date birth, String introduce, String imgdir,
			String zhuBoGroup, String ifVaild, String url, String keyWord,
			Date addDate, Date modifDate) {
		super();
		this.userId = userId;
		this.zhuBoName = zhuBoName;
		this.zhuBoRealName = zhuBoRealName;
		this.gender = gender;
		this.birth = birth;
		this.introduce = introduce;
		this.imgdir = imgdir;
		this.zhuBoGroup = zhuBoGroup;
		this.ifVaild = ifVaild;
		this.url = url;
		this.keyWord = keyWord;
		this.addDate = addDate;
		this.modifDate = modifDate;
	}
	public ZhuBo(){}
	@Override
	public String toString() {
		return "ZhuBo [userId=" + userId + ", zhuBoName=" + zhuBoName
				+ ", zhuBoRealName=" + zhuBoRealName + ", gender=" + gender
				+ ", birth=" + birth + ", introduce=" + introduce + ", imgdir="
				+ imgdir + ", zhuBoGroup=" + zhuBoGroup + ", ifVaild="
				+ ifVaild + ", url=" + url + ", keyWord=" + keyWord
				+ ", addDate=" + addDate + ", modifDate=" + modifDate + "]";
	}
}
