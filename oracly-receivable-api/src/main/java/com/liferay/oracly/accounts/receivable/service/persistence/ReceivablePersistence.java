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

package com.liferay.oracly.accounts.receivable.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.oracly.accounts.receivable.exception.NoSuchReceivableException;
import com.liferay.oracly.accounts.receivable.model.Receivable;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the receivable service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.oracly.accounts.receivable.service.persistence.impl.ReceivablePersistenceImpl
 * @see ReceivableUtil
 * @generated
 */
@ProviderType
public interface ReceivablePersistence extends BasePersistence<Receivable> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ReceivableUtil} to access the receivable persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the receivables where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching receivables
	*/
	public java.util.List<Receivable> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the receivables where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReceivableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of receivables
	* @param end the upper bound of the range of receivables (not inclusive)
	* @return the range of matching receivables
	*/
	public java.util.List<Receivable> findByUuid(java.lang.String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the receivables where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReceivableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of receivables
	* @param end the upper bound of the range of receivables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching receivables
	*/
	public java.util.List<Receivable> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Receivable> orderByComparator);

	/**
	* Returns an ordered range of all the receivables where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReceivableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of receivables
	* @param end the upper bound of the range of receivables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching receivables
	*/
	public java.util.List<Receivable> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Receivable> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first receivable in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching receivable
	* @throws NoSuchReceivableException if a matching receivable could not be found
	*/
	public Receivable findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Receivable> orderByComparator)
		throws NoSuchReceivableException;

	/**
	* Returns the first receivable in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching receivable, or <code>null</code> if a matching receivable could not be found
	*/
	public Receivable fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Receivable> orderByComparator);

	/**
	* Returns the last receivable in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching receivable
	* @throws NoSuchReceivableException if a matching receivable could not be found
	*/
	public Receivable findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Receivable> orderByComparator)
		throws NoSuchReceivableException;

	/**
	* Returns the last receivable in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching receivable, or <code>null</code> if a matching receivable could not be found
	*/
	public Receivable fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Receivable> orderByComparator);

	/**
	* Returns the receivables before and after the current receivable in the ordered set where uuid = &#63;.
	*
	* @param fooId the primary key of the current receivable
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next receivable
	* @throws NoSuchReceivableException if a receivable with the primary key could not be found
	*/
	public Receivable[] findByUuid_PrevAndNext(long fooId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Receivable> orderByComparator)
		throws NoSuchReceivableException;

	/**
	* Removes all the receivables where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of receivables where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching receivables
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the receivable where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchReceivableException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching receivable
	* @throws NoSuchReceivableException if a matching receivable could not be found
	*/
	public Receivable findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchReceivableException;

	/**
	* Returns the receivable where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching receivable, or <code>null</code> if a matching receivable could not be found
	*/
	public Receivable fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the receivable where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching receivable, or <code>null</code> if a matching receivable could not be found
	*/
	public Receivable fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the receivable where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the receivable that was removed
	*/
	public Receivable removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchReceivableException;

	/**
	* Returns the number of receivables where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching receivables
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the receivables where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching receivables
	*/
	public java.util.List<Receivable> findByUuid_C(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of all the receivables where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReceivableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of receivables
	* @param end the upper bound of the range of receivables (not inclusive)
	* @return the range of matching receivables
	*/
	public java.util.List<Receivable> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the receivables where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReceivableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of receivables
	* @param end the upper bound of the range of receivables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching receivables
	*/
	public java.util.List<Receivable> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Receivable> orderByComparator);

	/**
	* Returns an ordered range of all the receivables where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReceivableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of receivables
	* @param end the upper bound of the range of receivables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching receivables
	*/
	public java.util.List<Receivable> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Receivable> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first receivable in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching receivable
	* @throws NoSuchReceivableException if a matching receivable could not be found
	*/
	public Receivable findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Receivable> orderByComparator)
		throws NoSuchReceivableException;

	/**
	* Returns the first receivable in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching receivable, or <code>null</code> if a matching receivable could not be found
	*/
	public Receivable fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Receivable> orderByComparator);

	/**
	* Returns the last receivable in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching receivable
	* @throws NoSuchReceivableException if a matching receivable could not be found
	*/
	public Receivable findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Receivable> orderByComparator)
		throws NoSuchReceivableException;

	/**
	* Returns the last receivable in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching receivable, or <code>null</code> if a matching receivable could not be found
	*/
	public Receivable fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Receivable> orderByComparator);

	/**
	* Returns the receivables before and after the current receivable in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param fooId the primary key of the current receivable
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next receivable
	* @throws NoSuchReceivableException if a receivable with the primary key could not be found
	*/
	public Receivable[] findByUuid_C_PrevAndNext(long fooId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Receivable> orderByComparator)
		throws NoSuchReceivableException;

	/**
	* Removes all the receivables where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of receivables where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching receivables
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the receivables where amount = &#63;.
	*
	* @param amount the amount
	* @return the matching receivables
	*/
	public java.util.List<Receivable> findByFindByAmount(
		java.lang.Double amount);

	/**
	* Returns a range of all the receivables where amount = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReceivableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param amount the amount
	* @param start the lower bound of the range of receivables
	* @param end the upper bound of the range of receivables (not inclusive)
	* @return the range of matching receivables
	*/
	public java.util.List<Receivable> findByFindByAmount(
		java.lang.Double amount, int start, int end);

	/**
	* Returns an ordered range of all the receivables where amount = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReceivableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param amount the amount
	* @param start the lower bound of the range of receivables
	* @param end the upper bound of the range of receivables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching receivables
	*/
	public java.util.List<Receivable> findByFindByAmount(
		java.lang.Double amount, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Receivable> orderByComparator);

	/**
	* Returns an ordered range of all the receivables where amount = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReceivableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param amount the amount
	* @param start the lower bound of the range of receivables
	* @param end the upper bound of the range of receivables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching receivables
	*/
	public java.util.List<Receivable> findByFindByAmount(
		java.lang.Double amount, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Receivable> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first receivable in the ordered set where amount = &#63;.
	*
	* @param amount the amount
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching receivable
	* @throws NoSuchReceivableException if a matching receivable could not be found
	*/
	public Receivable findByFindByAmount_First(java.lang.Double amount,
		com.liferay.portal.kernel.util.OrderByComparator<Receivable> orderByComparator)
		throws NoSuchReceivableException;

	/**
	* Returns the first receivable in the ordered set where amount = &#63;.
	*
	* @param amount the amount
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching receivable, or <code>null</code> if a matching receivable could not be found
	*/
	public Receivable fetchByFindByAmount_First(java.lang.Double amount,
		com.liferay.portal.kernel.util.OrderByComparator<Receivable> orderByComparator);

	/**
	* Returns the last receivable in the ordered set where amount = &#63;.
	*
	* @param amount the amount
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching receivable
	* @throws NoSuchReceivableException if a matching receivable could not be found
	*/
	public Receivable findByFindByAmount_Last(java.lang.Double amount,
		com.liferay.portal.kernel.util.OrderByComparator<Receivable> orderByComparator)
		throws NoSuchReceivableException;

	/**
	* Returns the last receivable in the ordered set where amount = &#63;.
	*
	* @param amount the amount
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching receivable, or <code>null</code> if a matching receivable could not be found
	*/
	public Receivable fetchByFindByAmount_Last(java.lang.Double amount,
		com.liferay.portal.kernel.util.OrderByComparator<Receivable> orderByComparator);

	/**
	* Returns the receivables before and after the current receivable in the ordered set where amount = &#63;.
	*
	* @param fooId the primary key of the current receivable
	* @param amount the amount
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next receivable
	* @throws NoSuchReceivableException if a receivable with the primary key could not be found
	*/
	public Receivable[] findByFindByAmount_PrevAndNext(long fooId,
		java.lang.Double amount,
		com.liferay.portal.kernel.util.OrderByComparator<Receivable> orderByComparator)
		throws NoSuchReceivableException;

	/**
	* Removes all the receivables where amount = &#63; from the database.
	*
	* @param amount the amount
	*/
	public void removeByFindByAmount(java.lang.Double amount);

	/**
	* Returns the number of receivables where amount = &#63;.
	*
	* @param amount the amount
	* @return the number of matching receivables
	*/
	public int countByFindByAmount(java.lang.Double amount);

	/**
	* Caches the receivable in the entity cache if it is enabled.
	*
	* @param receivable the receivable
	*/
	public void cacheResult(Receivable receivable);

	/**
	* Caches the receivables in the entity cache if it is enabled.
	*
	* @param receivables the receivables
	*/
	public void cacheResult(java.util.List<Receivable> receivables);

	/**
	* Creates a new receivable with the primary key. Does not add the receivable to the database.
	*
	* @param fooId the primary key for the new receivable
	* @return the new receivable
	*/
	public Receivable create(long fooId);

	/**
	* Removes the receivable with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fooId the primary key of the receivable
	* @return the receivable that was removed
	* @throws NoSuchReceivableException if a receivable with the primary key could not be found
	*/
	public Receivable remove(long fooId) throws NoSuchReceivableException;

	public Receivable updateImpl(Receivable receivable);

	/**
	* Returns the receivable with the primary key or throws a {@link NoSuchReceivableException} if it could not be found.
	*
	* @param fooId the primary key of the receivable
	* @return the receivable
	* @throws NoSuchReceivableException if a receivable with the primary key could not be found
	*/
	public Receivable findByPrimaryKey(long fooId)
		throws NoSuchReceivableException;

	/**
	* Returns the receivable with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param fooId the primary key of the receivable
	* @return the receivable, or <code>null</code> if a receivable with the primary key could not be found
	*/
	public Receivable fetchByPrimaryKey(long fooId);

	@Override
	public java.util.Map<java.io.Serializable, Receivable> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the receivables.
	*
	* @return the receivables
	*/
	public java.util.List<Receivable> findAll();

	/**
	* Returns a range of all the receivables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReceivableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of receivables
	* @param end the upper bound of the range of receivables (not inclusive)
	* @return the range of receivables
	*/
	public java.util.List<Receivable> findAll(int start, int end);

	/**
	* Returns an ordered range of all the receivables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReceivableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of receivables
	* @param end the upper bound of the range of receivables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of receivables
	*/
	public java.util.List<Receivable> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Receivable> orderByComparator);

	/**
	* Returns an ordered range of all the receivables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReceivableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of receivables
	* @param end the upper bound of the range of receivables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of receivables
	*/
	public java.util.List<Receivable> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Receivable> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the receivables from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of receivables.
	*
	* @return the number of receivables
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}