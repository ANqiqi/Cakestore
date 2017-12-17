package com.bear.cakeonline.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
		private int adminId;
		private String adminName;
		private String password;
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		public int getAdminId() {
			return adminId;
		}
		public void setAdminId(int adminId) {
			this.adminId = adminId;
		}
		public String getAdminName() {
			return adminName;
		}
		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

}
