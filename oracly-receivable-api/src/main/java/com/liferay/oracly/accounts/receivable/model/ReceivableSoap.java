/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.oracly.accounts.receivable.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.oracly.accounts.receivable.service.http.ReceivableServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.oracly.accounts.receivable.service.http.ReceivableServiceSoap
 * @generated
 */
@ProviderType
public class ReceivableSoap implements Serializable {
	public static ReceivableSoap toSoapModel(Receivable model) {
		ReceivableSoap soapModel = new ReceivableSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setFooId(model.getFooId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDueDate(model.getDueDate());
		soapModel.setAmount(model.getAmount());
		soapModel.setDescription(model.getDescription());
		soapModel.setPath(model.getPath());
		soapModel.setDocumentId(model.getDocumentId());
		soapModel.setFlag(model.getFlag());
		soapModel.setSupplierName(model.getSupplierName());

		return soapModel;
	}

	public static ReceivableSoap[] toSoapModels(Receivable[] models) {
		ReceivableSoap[] soapModels = new ReceivableSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ReceivableSoap[][] toSoapModels(Receivable[][] models) {
		ReceivableSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ReceivableSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ReceivableSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ReceivableSoap[] toSoapModels(List<Receivable> models) {
		List<ReceivableSoap> soapModels = new ArrayList<ReceivableSoap>(models.size());

		for (Receivable model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ReceivableSoap[soapModels.size()]);
	}

	public ReceivableSoap() {
	}

	public long getPrimaryKey() {
		return _fooId;
	}

	public void setPrimaryKey(long pk) {
		setFooId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getFooId() {
		return _fooId;
	}

	public void setFooId(long fooId) {
		_fooId = fooId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Date getDueDate() {
		return _dueDate;
	}

	public void setDueDate(Date dueDate) {
		_dueDate = dueDate;
	}

	public Double getAmount() {
		return _amount;
	}

	public void setAmount(Double amount) {
		_amount = amount;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getPath() {
		return _path;
	}

	public void setPath(String path) {
		_path = path;
	}

	public long getDocumentId() {
		return _documentId;
	}

	public void setDocumentId(long documentId) {
		_documentId = documentId;
	}

	public int getFlag() {
		return _flag;
	}

	public void setFlag(int flag) {
		_flag = flag;
	}

	public String getSupplierName() {
		return _supplierName;
	}

	public void setSupplierName(String supplierName) {
		_supplierName = supplierName;
	}

	private String _uuid;
	private long _fooId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _dueDate;
	private Double _amount;
	private String _description;
	private String _path;
	private long _documentId;
	private int _flag;
	private String _supplierName;
}