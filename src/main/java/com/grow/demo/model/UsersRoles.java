package com.grow.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_roles")
public class UsersRoles {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "user_id")
	private int userid;
	@Column(name = "role_id")
	private int roleid;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	@Override
	public String toString() {
		return "UsersRoles [id=" + id + ", userid=" + userid + ", roleid=" + roleid + "]";
	}

}
