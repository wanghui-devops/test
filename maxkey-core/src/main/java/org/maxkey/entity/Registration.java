/*
 * Copyright [2020] [MaxKey of copyright http://www.maxkey.top]
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 

package org.maxkey.entity;

import javax.persistence.Column;

import org.apache.mybatis.jpa.persistence.JpaBaseEntity;

public class Registration extends JpaBaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4021412077583763378L;
	private String id;
	private String loginName;
	private String workEmail;
	private String company;
	private String workPhone;
	private String nickName;
	private String lastName;//familyName
	private String firstName;//givenName
	private Integer users;
	@Column
	private String instId;

	private String instName;
	
	
	/**
	 * 
	 */
	public Registration() {
		super();
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 * @return the workEmail
	 */
	public String getWorkEmail() {
		return workEmail;
	}
	/**
	 * @param workEmail the workEmail to set
	 */
	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * @return the workPhone
	 */
	public String getWorkPhone() {
		return workPhone;
	}
	/**
	 * @param workPhone the workPhone to set
	 */
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return the users
	 */
	public Integer getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(Integer users) {
		this.users = users;
	}
	
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getInstId() {
		return instId;
	}

	public void setInstId(String instId) {
		this.instId = instId;
	}

	public String getInstName() {
		return instName;
	}

	public void setInstName(String instName) {
		this.instName = instName;
	}

	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Registration [id=");
        builder.append(id);
        builder.append(", loginName=");
        builder.append(loginName);
        builder.append(", workEmail=");
        builder.append(workEmail);
        builder.append(", company=");
        builder.append(company);
        builder.append(", workPhone=");
        builder.append(workPhone);
        builder.append(", nickName=");
        builder.append(nickName);
        builder.append(", lastName=");
        builder.append(lastName);
        builder.append(", firstName=");
        builder.append(firstName);
        builder.append(", users=");
        builder.append(users);
        builder.append("]");
        return builder.toString();
    }
	
}
