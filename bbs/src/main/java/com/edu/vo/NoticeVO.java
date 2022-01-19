package com.edu.vo;

public class NoticeVO {
private String noticeId;
private String noticeTitle;
private String noticeContent;
private String noticeDate;
private int noticeHit;

public NoticeVO() {
	
}
public String getNoticeId() {
	return noticeId;
}
public void setNoticeId(String noticeId) {
	this.noticeId = noticeId;
}
public String getNoticeTitle() {
	return noticeTitle;
}
public void setNoticeTitle(String noticeTitle) {
	this.noticeTitle = noticeTitle;
}
public String getNoticeContent() {
	return noticeContent;
}
public void setNoticeContent(String noticeContent) {
	this.noticeContent = noticeContent;
}
public String getNoticeDate() {
	return noticeDate;
}
public void setNoticeDate(String noticeDate) {
	this.noticeDate = noticeDate;
}
public int getNoticeHit() {
	return noticeHit;
}
public void setNoticeHit(int noticeHit) {
	this.noticeHit = noticeHit;
}
@Override
public String toString() {
	return "NoticeVO [noticeId=" + noticeId + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
			+ ", noticeDate=" + noticeDate + ", noticeHit=" + noticeHit + "]";
}


}
