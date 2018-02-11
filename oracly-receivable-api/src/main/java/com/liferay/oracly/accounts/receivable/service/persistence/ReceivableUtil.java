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

import com.liferay.oracly.accounts.receivable.model.Receivable;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the receivable service. This utility wraps {@link com.liferay.oracly.accounts.receivable.service.persistence.impl.ReceivablePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReceivablePersistence
 * @see com.liferay.oracly.accounts.receivable.service.persistence.impl.ReceivablePersistenceImpl
 * @generated
 */
@ProviderType
public class ReceivableUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Receivable receivable) {
		getPersistence().clearCache(receivable);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Receivable> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Receivable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Receivable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Receivable> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Receivable update(Receivable receivable) {
		return getPersistence().update(receivable);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Receivable update(Receivable receivable,
		ServiceContext serviceContext) {
		return getPersistence().update(receivable, serviceContext);
	}

	/**
	* Returns all the receivables where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching receivables
	*/
	public static List<Receivable> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<Receivable> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<Receivable> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Receivable> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<Receivable> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Receivable> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first receivable in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching receivable
	* @throws NoSuchReceivableException if a matching receivable could not be found
	*/
	public static Receivable findByUuid_First(java.lang.String uuid,
		OrderByComparator<Receivable> orderByComparator)
		throws com.liferay.oracly.accounts.receivable.exception.NoSuchReceivableException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first receivable in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching receivable, or <code>null</code> if a matching receivable could not be found
	*/
	public static Receivable fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Receivable> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last receivable in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching receivable
	* @throws NoSuchReceivableException if a matching receivable could not be found
	*/
	public static Receivable findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Receivable> orderByComparator)
		throws com.liferay.oracly.accounts.receivable.exception.NoSuchReceivableException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last receivable in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching receivable, or <code>null</code> if a matching receivable could not be found
	*/
	public static Receivable fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Receivable> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the receivables before and after the current receivable in the ordered set where uuid = &#63;.
	*
	* @param fooId the primary key of the current receivable
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next receivable
	* @throws NoSuchReceivableException if a receivable with the primary key could not be found
	*/
	public static Receivable[] findByUuid_PrevAndNext(long fooId,
		java.lang.String uuid, OrderByComparator<Receivable> orderByComparator)
		throws com.liferay.oracly.accounts.receivable.exception.NoSuchReceivableException {
		return getPersistence()
				   .findByUuid_PrevAndNext(fooId, uuid, orderByComparator);
	}

	/**
	* Removes all the receivables where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of receivables where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching receivables
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the receivable where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchReceivableException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching receivable
	* @throws NoSuchReceivableException if a matching receivable could not be found
	*/
	public static Receivable findByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.oracly.accounts.receivable.exception.NoSuchReceivableException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the receivable where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching receivable, or <code>null</code> if a matching receivable could not be found
	*/
	public static Receivable fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the receivable where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching receivable, or <code>null</code> if a matching receivable could not be found
	*/
	public static Receivable fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the receivable where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the receivable that was removed
	*/
	public static Receivable removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.oracly.accounts.receivable.exception.NoSuchReceivableException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of receivables where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching receivables
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the receivables where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching receivables
	*/
	public static List<Receivable> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<Receivable> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<Receivable> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Receivable> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<Receivable> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Receivable> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first receivable in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching receivable
	* @throws NoSuchReceivableException if a matching receivable could not be found
	*/
	public static Receivable findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Receivable> orderByComparator)
		throws com.liferay.oracly.accounts.receivable.exception.NoSuchReceivableException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first receivable in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching receivable, or <code>null</code> if a matching receivable could not be found
	*/
	public static Receivable fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Receivable> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last receivable in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching receivable
	* @throws NoSuchReceivableException if a matching receivable could not be found
	*/
	public static Receivable findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Receivable> orderByComparator)
		throws com.liferay.oracly.accounts.receivable.exception.NoSuchReceivableException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last receivable in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching receivable, or <code>null</code> if a matching receivable could not be found
	*/
	public static Receivable fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Receivable> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static Receivable[] findByUuid_C_PrevAndNext(long fooId,
		java.lang.String uuid, long companyId,
		OrderByComparator<Receivable> orderByComparator)
		throws com.liferay.oracly.accounts.receivable.exception.NoSuchReceivableException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(fooId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the receivables where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of receivables where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching receivables
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the receivables where amount = &#63;.
	*
	* @param amount the amount
	* @return the matching receivables
	*/
	public static List<Receivable> findByFindByAmount(java.lang.Double amount) {
		return getPersistence().findByFindByAmount(amount);
	}

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
	public static List<Receivable> findByFindByAmount(java.lang.Double amount,
		int start, int end) {
		return getPersistence().findByFindByAmount(amount, start, end);
	}

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
	public static List<Receivable> findByFindByAmount(java.lang.Double amount,
		int start, int end, OrderByComparator<Receivable> orderByComparator) {
		return getPersistence()
				   .findByFindByAmount(amount, start, end, orderByComparator);
	}

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
	public static List<Receivable> findByFindByAmount(java.lang.Double amount,
		int start, int end, OrderByComparator<Receivable> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByFindByAmount(amount, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first receivable in the ordered set where amount = &#63;.
	*
	* @param amount the amount
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching receivable
	* @throws NoSuchReceivableException if a matching receivable could not be found
	*/
	public static Receivable findByFindByAmount_First(java.lang.Double amount,
		OrderByComparator<Receivable> orderByComparator)
		throws com.liferay.oracly.accounts.receivable.exception.NoSuchReceivableException {
		return getPersistence()
				   .findByFindByAmount_First(amount, orderByComparator);
	}

	/**
	* Returns the first receivable in the ordered set where amount = &#63;.
	*
	* @param amount the amount
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching receivable, or <code>null</code> if a matching receivable could not be found
	*/
	public static Receivable fetchByFindByAmount_First(
		java.lang.Double amount, OrderByComparator<Receivable> orderByComparator) {
		return getPersistence()
				   .fetchByFindByAmount_First(amount, orderByComparator);
	}

	/**
	* Returns the last receivable in the ordered set where amount = &#63;.
	*
	* @param amount the amount
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching receivable
	* @throws NoSuchReceivableException if a matching receivable could not be found
	*/
	public static Receivable findByFindByAmount_Last(java.lang.Double amount,
		OrderByComparator<Receivable> orderByComparator)
		throws com.liferay.oracly.accounts.receivable.exception.NoSuchReceivableException {
		return getPersistence()
				   .findByFindByAmount_Last(amount, orderByComparator);
	}

	/**
	* Returns the last receivable in the ordered set where amount = &#63;.
	*
	* @param amount the amount
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching receivable, or <code>null</code> if a matching receivable could not be found
	*/
	public static Receivable fetchByFindByAmount_Last(java.lang.Double amount,
		OrderByComparator<Receivable> orderByComparator) {
		return getPersistence()
				   .fetchByFindByAmount_Last(amount, orderByComparator);
	}

	/**
	* Returns the receivables before and after the current receivable in the ordered set where amount = &#63;.
	*
	* @param fooId the primary key of the current receivable
	* @param amount the amount
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next receivable
	* @throws NoSuchReceivableException if a receivable with the primary key could not be found
	*/
	public static Receivable[] findByFindByAmount_PrevAndNext(long fooId,
		java.lang.Double amount, OrderByComparator<Receivable> orderByComparator)
		throws com.liferay.oracly.accounts.receivable.exception.NoSuchReceivableException {
		return getPersistence()
				   .findByFindByAmount_PrevAndNext(fooId, amount,
			orderByComparator);
	}

	/**
	* Removes all the receivables where amount = &#63; from the database.
	*
	* @param amount the amount
	*/
	public static void removeByFindByAmount(java.lang.Double amount) {
		getPersistence().removeByFindByAmount(amount);
	}

	/**
	* Returns the number of receivables where amount = &#63;.
	*
	* @param amount the amount
	* @return the number of matching receivables
	*/
	public static int countByFindByAmount(java.lang.Double amount) {
		return getPersistence().countByFindByAmount(amount);
	}

	/**
	* Caches the receivable in the entity cache if it is enabled.
	*
	* @param receivable the receivable
	*/
	public static void cacheResult(Receivable receivable) {
		getPersistence().cacheResult(receivable);
	}

	/**
	* Caches the receivables in the entity cache if it is enabled.
	*
	* @param receivables the receivables
	*/
	public static void cacheResult(List<Receivable> receivables) {
		getPersistence().cacheResult(receivables);
	}

	/**
	* Creates a new receivable with the primary key. Does not add the receivable to the database.
	*
	* @param fooId the primary key for the new receivable
	* @return the new receivable
	*/
	public static Receivable create(long fooId) {
		return getPersistence().create(fooId);
	}

	/**
	* Removes the receivable with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fooId the primary key of the receivable
	* @return the receivable that was removed
	* @throws NoSuchReceivableException if a receivable with the primary key could not be found
	*/
	public static Receivable remove(long fooId)
		throws com.liferay.oracly.accounts.receivable.exception.NoSuchReceivableException {
		return getPersistence().remove(fooId);
	}

	public static Receivable updateImpl(Receivable receivable) {
		return getPersistence().updateImpl(receivable);
	}

	/**
	* Returns the receivable with the primary key or throws a {@link NoSuchReceivableException} if it could not be found.
	*
	* @param fooId the primary key of the receivable
	* @return the receivable
	* @throws NoSuchReceivableException if a receivable with the primary key could not be found
	*/
	public static Receivable findByPrimaryKey(long fooId)
		throws com.liferay.oracly.accounts.receivable.exception.NoSuchReceivableException {
		return getPersistence().findByPrimaryKey(fooId);
	}

	/**
	* Returns the receivable with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param fooId the primary key of the receivable
	* @return the receivable, or <code>null</code> if a receivable with the primary key could not be found
	*/
	public static Receivable fetchByPrimaryKey(long fooId) {
		return getPersistence().fetchByPrimaryKey(fooId);
	}

	public static java.util.Map<java.io.Serializable, Receivable> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the receivables.
	*
	* @return the receivables
	*/
	public static List<Receivable> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Receivable> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Receivable> findAll(int start, int end,
		OrderByComparator<Receivable> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Receivable> findAll(int start, int end,
		OrderByComparator<Receivable> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the receivables from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of receivables.
	*
	* @return the number of receivables
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ReceivablePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ReceivablePersistence, ReceivablePersistence> _serviceTracker =
		ServiceTrackerFactory.open(ReceivablePersistence.class);
}