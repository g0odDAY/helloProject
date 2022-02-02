package com.micol.prj.member.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberVO {
	private String id;
	private String password;
	private String name;
	private String tel;
	private String address;
	private String author;
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", tel=" + tel + ", address="
				+ address + ", author=" + author + "]";
	}
	
}
