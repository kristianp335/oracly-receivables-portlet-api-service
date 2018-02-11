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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Receivable}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Receivable
 * @generated
 */
@ProviderType
public class ReceivableWrapper implements Receivable, ModelWrapper<Receivable> {
	public ReceivableWrapper(Receivable receivable) {
		_receivable = receivable;
	}

	@Override
	public Class<?> getModelClass() {
		return Receivable.class;
	}

	@Override
	public String getModelClassName() {
		return Receivable.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("fooId", getFooId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dueDate", getDueDate());
		attributes.put("amount", getAmount());
		attributes.put("description", getDescription());
		attributes.put("path", getPath());
		attributes.put("documentId", getDocumentId());
		attributes.put("flag", getFlag());
		attributes.put("supplierName", getSupplierName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long fooId = (Long)attributes.get("fooId");

		if (fooId != null) {
			setFooId(fooId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date dueDate = (Date)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String path = (String)attributes.get("path");

		if (path != null) {
			setPath(path);
		}

		Long documentId = (Long)attributes.get("documentId");

		if (documentId != null) {
			setDocumentId(documentId);
		}

		Integer flag = (Integer)attributes.get("flag");

		if (flag != null) {
			setFlag(flag);
		}

		String supplierName = (String)attributes.get("supplierName");

		if (supplierName != null) {
			setSupplierName(supplierName);
		}
	}

	@Override
	public Receivable toEscapedModel() {
		return new ReceivableWrapper(_receivable.toEscapedModel());
	}

	@Override
	public Receivable toUnescapedModel() {
		return new ReceivableWrapper(_receivable.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _receivable.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _receivable.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _receivable.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _receivable.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Receivable> toCacheModel() {
		return _receivable.toCacheModel();
	}

	@Override
	public int compareTo(Receivable receivable) {
		return _receivable.compareTo(receivable);
	}

	/**
	* Returns the flag of this receivable.
	*
	* @return the flag of this receivable
	*/
	@Override
	public int getFlag() {
		return _receivable.getFlag();
	}

	@Override
	public int hashCode() {
		return _receivable.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _receivable.getPrimaryKeyObj();
	}

	/**
	* Returns the amount of this receivable.
	*
	* @return the amount of this receivable
	*/
	@Override
	public java.lang.Double getAmount() {
		return _receivable.getAmount();
	}

	@Override
	public java.lang.Object clone() {
		return new ReceivableWrapper((Receivable)_receivable.clone());
	}

	/**
	* Returns the description of this receivable.
	*
	* @return the description of this receivable
	*/
	@Override
	public java.lang.String getDescription() {
		return _receivable.getDescription();
	}

	/**
	* Returns the path of this receivable.
	*
	* @return the path of this receivable
	*/
	@Override
	public java.lang.String getPath() {
		return _receivable.getPath();
	}

	/**
	* Returns the supplier name of this receivable.
	*
	* @return the supplier name of this receivable
	*/
	@Override
	public java.lang.String getSupplierName() {
		return _receivable.getSupplierName();
	}

	/**
	* Returns the user name of this receivable.
	*
	* @return the user name of this receivable
	*/
	@Override
	public java.lang.String getUserName() {
		return _receivable.getUserName();
	}

	/**
	* Returns the user uuid of this receivable.
	*
	* @return the user uuid of this receivable
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _receivable.getUserUuid();
	}

	/**
	* Returns the uuid of this receivable.
	*
	* @return the uuid of this receivable
	*/
	@Override
	public java.lang.String getUuid() {
		return _receivable.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _receivable.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _receivable.toXmlString();
	}

	/**
	* Returns the create date of this receivable.
	*
	* @return the create date of this receivable
	*/
	@Override
	public Date getCreateDate() {
		return _receivable.getCreateDate();
	}

	/**
	* Returns the due date of this receivable.
	*
	* @return the due date of this receivable
	*/
	@Override
	public Date getDueDate() {
		return _receivable.getDueDate();
	}

	/**
	* Returns the modified date of this receivable.
	*
	* @return the modified date of this receivable
	*/
	@Override
	public Date getModifiedDate() {
		return _receivable.getModifiedDate();
	}

	/**
	* Returns the company ID of this receivable.
	*
	* @return the company ID of this receivable
	*/
	@Override
	public long getCompanyId() {
		return _receivable.getCompanyId();
	}

	/**
	* Returns the document ID of this receivable.
	*
	* @return the document ID of this receivable
	*/
	@Override
	public long getDocumentId() {
		return _receivable.getDocumentId();
	}

	/**
	* Returns the foo ID of this receivable.
	*
	* @return the foo ID of this receivable
	*/
	@Override
	public long getFooId() {
		return _receivable.getFooId();
	}

	/**
	* Returns the group ID of this receivable.
	*
	* @return the group ID of this receivable
	*/
	@Override
	public long getGroupId() {
		return _receivable.getGroupId();
	}

	/**
	* Returns the primary key of this receivable.
	*
	* @return the primary key of this receivable
	*/
	@Override
	public long getPrimaryKey() {
		return _receivable.getPrimaryKey();
	}

	/**
	* Returns the user ID of this receivable.
	*
	* @return the user ID of this receivable
	*/
	@Override
	public long getUserId() {
		return _receivable.getUserId();
	}

	@Override
	public void persist() {
		_receivable.persist();
	}

	/**
	* Sets the amount of this receivable.
	*
	* @param amount the amount of this receivable
	*/
	@Override
	public void setAmount(java.lang.Double amount) {
		_receivable.setAmount(amount);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_receivable.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this receivable.
	*
	* @param companyId the company ID of this receivable
	*/
	@Override
	public void setCompanyId(long companyId) {
		_receivable.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this receivable.
	*
	* @param createDate the create date of this receivable
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_receivable.setCreateDate(createDate);
	}

	/**
	* Sets the description of this receivable.
	*
	* @param description the description of this receivable
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_receivable.setDescription(description);
	}

	/**
	* Sets the document ID of this receivable.
	*
	* @param documentId the document ID of this receivable
	*/
	@Override
	public void setDocumentId(long documentId) {
		_receivable.setDocumentId(documentId);
	}

	/**
	* Sets the due date of this receivable.
	*
	* @param dueDate the due date of this receivable
	*/
	@Override
	public void setDueDate(Date dueDate) {
		_receivable.setDueDate(dueDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_receivable.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_receivable.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_receivable.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the flag of this receivable.
	*
	* @param flag the flag of this receivable
	*/
	@Override
	public void setFlag(int flag) {
		_receivable.setFlag(flag);
	}

	/**
	* Sets the foo ID of this receivable.
	*
	* @param fooId the foo ID of this receivable
	*/
	@Override
	public void setFooId(long fooId) {
		_receivable.setFooId(fooId);
	}

	/**
	* Sets the group ID of this receivable.
	*
	* @param groupId the group ID of this receivable
	*/
	@Override
	public void setGroupId(long groupId) {
		_receivable.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this receivable.
	*
	* @param modifiedDate the modified date of this receivable
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_receivable.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_receivable.setNew(n);
	}

	/**
	* Sets the path of this receivable.
	*
	* @param path the path of this receivable
	*/
	@Override
	public void setPath(java.lang.String path) {
		_receivable.setPath(path);
	}

	/**
	* Sets the primary key of this receivable.
	*
	* @param primaryKey the primary key of this receivable
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_receivable.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_receivable.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the supplier name of this receivable.
	*
	* @param supplierName the supplier name of this receivable
	*/
	@Override
	public void setSupplierName(java.lang.String supplierName) {
		_receivable.setSupplierName(supplierName);
	}

	/**
	* Sets the user ID of this receivable.
	*
	* @param userId the user ID of this receivable
	*/
	@Override
	public void setUserId(long userId) {
		_receivable.setUserId(userId);
	}

	/**
	* Sets the user name of this receivable.
	*
	* @param userName the user name of this receivable
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_receivable.setUserName(userName);
	}

	/**
	* Sets the user uuid of this receivable.
	*
	* @param userUuid the user uuid of this receivable
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_receivable.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this receivable.
	*
	* @param uuid the uuid of this receivable
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_receivable.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ReceivableWrapper)) {
			return false;
		}

		ReceivableWrapper receivableWrapper = (ReceivableWrapper)obj;

		if (Objects.equals(_receivable, receivableWrapper._receivable)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _receivable.getStagedModelType();
	}

	@Override
	public Receivable getWrappedModel() {
		return _receivable;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _receivable.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _receivable.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_receivable.resetOriginalValues();
	}

	private final Receivable _receivable;
}