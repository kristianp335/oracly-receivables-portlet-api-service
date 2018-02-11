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

package com.liferay.oracly.accounts.receivable.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Receivable. This utility wraps
 * {@link com.liferay.oracly.accounts.receivable.service.impl.ReceivableLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ReceivableLocalService
 * @see com.liferay.oracly.accounts.receivable.service.base.ReceivableLocalServiceBaseImpl
 * @see com.liferay.oracly.accounts.receivable.service.impl.ReceivableLocalServiceImpl
 * @generated
 */
@ProviderType
public class ReceivableLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.oracly.accounts.receivable.service.impl.ReceivableLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the receivable to the database. Also notifies the appropriate model listeners.
	*
	* @param receivable the receivable
	* @return the receivable that was added
	*/
	public static com.liferay.oracly.accounts.receivable.model.Receivable addReceivable(
		com.liferay.oracly.accounts.receivable.model.Receivable receivable) {
		return getService().addReceivable(receivable);
	}

	/**
	* Creates a new receivable with the primary key. Does not add the receivable to the database.
	*
	* @param fooId the primary key for the new receivable
	* @return the new receivable
	*/
	public static com.liferay.oracly.accounts.receivable.model.Receivable createReceivable(
		long fooId) {
		return getService().createReceivable(fooId);
	}

	/**
	* Deletes the receivable from the database. Also notifies the appropriate model listeners.
	*
	* @param receivable the receivable
	* @return the receivable that was removed
	*/
	public static com.liferay.oracly.accounts.receivable.model.Receivable deleteReceivable(
		com.liferay.oracly.accounts.receivable.model.Receivable receivable) {
		return getService().deleteReceivable(receivable);
	}

	/**
	* Deletes the receivable with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fooId the primary key of the receivable
	* @return the receivable that was removed
	* @throws PortalException if a receivable with the primary key could not be found
	*/
	public static com.liferay.oracly.accounts.receivable.model.Receivable deleteReceivable(
		long fooId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteReceivable(fooId);
	}

	public static com.liferay.oracly.accounts.receivable.model.Receivable fetchReceivable(
		long fooId) {
		return getService().fetchReceivable(fooId);
	}

	/**
	* Returns the receivable matching the UUID and group.
	*
	* @param uuid the receivable's UUID
	* @param groupId the primary key of the group
	* @return the matching receivable, or <code>null</code> if a matching receivable could not be found
	*/
	public static com.liferay.oracly.accounts.receivable.model.Receivable fetchReceivableByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchReceivableByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the receivable with the primary key.
	*
	* @param fooId the primary key of the receivable
	* @return the receivable
	* @throws PortalException if a receivable with the primary key could not be found
	*/
	public static com.liferay.oracly.accounts.receivable.model.Receivable getReceivable(
		long fooId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getReceivable(fooId);
	}

	/**
	* Returns the receivable matching the UUID and group.
	*
	* @param uuid the receivable's UUID
	* @param groupId the primary key of the group
	* @return the matching receivable
	* @throws PortalException if a matching receivable could not be found
	*/
	public static com.liferay.oracly.accounts.receivable.model.Receivable getReceivableByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getReceivableByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the receivable in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param receivable the receivable
	* @return the receivable that was updated
	*/
	public static com.liferay.oracly.accounts.receivable.model.Receivable updateReceivable(
		com.liferay.oracly.accounts.receivable.model.Receivable receivable) {
		return getService().updateReceivable(receivable);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of receivables.
	*
	* @return the number of receivables
	*/
	public static int getReceivablesCount() {
		return getService().getReceivablesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oracly.accounts.receivable.model.impl.ReceivableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oracly.accounts.receivable.model.impl.ReceivableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the receivables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oracly.accounts.receivable.model.impl.ReceivableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of receivables
	* @param end the upper bound of the range of receivables (not inclusive)
	* @return the range of receivables
	*/
	public static java.util.List<com.liferay.oracly.accounts.receivable.model.Receivable> getReceivables(
		int start, int end) {
		return getService().getReceivables(start, end);
	}

	/**
	* Returns all the receivables matching the UUID and company.
	*
	* @param uuid the UUID of the receivables
	* @param companyId the primary key of the company
	* @return the matching receivables, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.oracly.accounts.receivable.model.Receivable> getReceivablesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getReceivablesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of receivables matching the UUID and company.
	*
	* @param uuid the UUID of the receivables
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of receivables
	* @param end the upper bound of the range of receivables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching receivables, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.oracly.accounts.receivable.model.Receivable> getReceivablesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.oracly.accounts.receivable.model.Receivable> orderByComparator) {
		return getService()
				   .getReceivablesByUuidAndCompanyId(uuid, companyId, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ReceivableLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ReceivableLocalService, ReceivableLocalService> _serviceTracker =
		ServiceTrackerFactory.open(ReceivableLocalService.class);
}