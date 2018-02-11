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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Receivable service. Represents a row in the &quot;Oracly_Receivable&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ReceivableModel
 * @see com.liferay.oracly.accounts.receivable.model.impl.ReceivableImpl
 * @see com.liferay.oracly.accounts.receivable.model.impl.ReceivableModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.oracly.accounts.receivable.model.impl.ReceivableImpl")
@ProviderType
public interface Receivable extends ReceivableModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.oracly.accounts.receivable.model.impl.ReceivableImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Receivable, Long> FOO_ID_ACCESSOR = new Accessor<Receivable, Long>() {
			@Override
			public Long get(Receivable receivable) {
				return receivable.getFooId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Receivable> getTypeClass() {
				return Receivable.class;
			}
		};
}