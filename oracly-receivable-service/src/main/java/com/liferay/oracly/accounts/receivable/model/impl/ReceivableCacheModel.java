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

package com.liferay.oracly.accounts.receivable.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.oracly.accounts.receivable.model.Receivable;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Receivable in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Receivable
 * @generated
 */
@ProviderType
public class ReceivableCacheModel implements CacheModel<Receivable>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ReceivableCacheModel)) {
			return false;
		}

		ReceivableCacheModel receivableCacheModel = (ReceivableCacheModel)obj;

		if (fooId == receivableCacheModel.fooId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fooId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", fooId=");
		sb.append(fooId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", dueDate=");
		sb.append(dueDate);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", description=");
		sb.append(description);
		sb.append(", path=");
		sb.append(path);
		sb.append(", documentId=");
		sb.append(documentId);
		sb.append(", flag=");
		sb.append(flag);
		sb.append(", supplierName=");
		sb.append(supplierName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Receivable toEntityModel() {
		ReceivableImpl receivableImpl = new ReceivableImpl();

		if (uuid == null) {
			receivableImpl.setUuid(StringPool.BLANK);
		}
		else {
			receivableImpl.setUuid(uuid);
		}

		receivableImpl.setFooId(fooId);
		receivableImpl.setGroupId(groupId);
		receivableImpl.setCompanyId(companyId);
		receivableImpl.setUserId(userId);

		if (userName == null) {
			receivableImpl.setUserName(StringPool.BLANK);
		}
		else {
			receivableImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			receivableImpl.setCreateDate(null);
		}
		else {
			receivableImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			receivableImpl.setModifiedDate(null);
		}
		else {
			receivableImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (dueDate == Long.MIN_VALUE) {
			receivableImpl.setDueDate(null);
		}
		else {
			receivableImpl.setDueDate(new Date(dueDate));
		}

		receivableImpl.setAmount(amount);

		if (description == null) {
			receivableImpl.setDescription(StringPool.BLANK);
		}
		else {
			receivableImpl.setDescription(description);
		}

		if (path == null) {
			receivableImpl.setPath(StringPool.BLANK);
		}
		else {
			receivableImpl.setPath(path);
		}

		receivableImpl.setDocumentId(documentId);
		receivableImpl.setFlag(flag);

		if (supplierName == null) {
			receivableImpl.setSupplierName(StringPool.BLANK);
		}
		else {
			receivableImpl.setSupplierName(supplierName);
		}

		receivableImpl.resetOriginalValues();

		return receivableImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		fooId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		dueDate = objectInput.readLong();

		amount = objectInput.readDouble();
		description = objectInput.readUTF();
		path = objectInput.readUTF();

		documentId = objectInput.readLong();

		flag = objectInput.readInt();
		supplierName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(fooId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(dueDate);

		objectOutput.writeDouble(amount);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (path == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(path);
		}

		objectOutput.writeLong(documentId);

		objectOutput.writeInt(flag);

		if (supplierName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(supplierName);
		}
	}

	public String uuid;
	public long fooId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long dueDate;
	public double amount;
	public String description;
	public String path;
	public long documentId;
	public int flag;
	public String supplierName;
}