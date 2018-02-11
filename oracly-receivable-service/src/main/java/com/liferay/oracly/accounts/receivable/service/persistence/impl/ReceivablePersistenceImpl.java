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

package com.liferay.oracly.accounts.receivable.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.oracly.accounts.receivable.exception.NoSuchReceivableException;
import com.liferay.oracly.accounts.receivable.model.Receivable;
import com.liferay.oracly.accounts.receivable.model.impl.ReceivableImpl;
import com.liferay.oracly.accounts.receivable.model.impl.ReceivableModelImpl;
import com.liferay.oracly.accounts.receivable.service.persistence.ReceivablePersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the receivable service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReceivablePersistence
 * @see com.liferay.oracly.accounts.receivable.service.persistence.ReceivableUtil
 * @generated
 */
@ProviderType
public class ReceivablePersistenceImpl extends BasePersistenceImpl<Receivable>
	implements ReceivablePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ReceivableUtil} to access the receivable persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ReceivableImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ReceivableModelImpl.ENTITY_CACHE_ENABLED,
			ReceivableModelImpl.FINDER_CACHE_ENABLED, ReceivableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ReceivableModelImpl.ENTITY_CACHE_ENABLED,
			ReceivableModelImpl.FINDER_CACHE_ENABLED, ReceivableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ReceivableModelImpl.ENTITY_CACHE_ENABLED,
			ReceivableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ReceivableModelImpl.ENTITY_CACHE_ENABLED,
			ReceivableModelImpl.FINDER_CACHE_ENABLED, ReceivableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ReceivableModelImpl.ENTITY_CACHE_ENABLED,
			ReceivableModelImpl.FINDER_CACHE_ENABLED, ReceivableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ReceivableModelImpl.UUID_COLUMN_BITMASK |
			ReceivableModelImpl.DUEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ReceivableModelImpl.ENTITY_CACHE_ENABLED,
			ReceivableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the receivables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching receivables
	 */
	@Override
	public List<Receivable> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Receivable> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Receivable> findByUuid(String uuid, int start, int end,
		OrderByComparator<Receivable> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Receivable> findByUuid(String uuid, int start, int end,
		OrderByComparator<Receivable> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Receivable> list = null;

		if (retrieveFromCache) {
			list = (List<Receivable>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Receivable receivable : list) {
					if (!Objects.equals(uuid, receivable.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_RECEIVABLE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ReceivableModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Receivable>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Receivable>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first receivable in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receivable
	 * @throws NoSuchReceivableException if a matching receivable could not be found
	 */
	@Override
	public Receivable findByUuid_First(String uuid,
		OrderByComparator<Receivable> orderByComparator)
		throws NoSuchReceivableException {
		Receivable receivable = fetchByUuid_First(uuid, orderByComparator);

		if (receivable != null) {
			return receivable;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReceivableException(msg.toString());
	}

	/**
	 * Returns the first receivable in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receivable, or <code>null</code> if a matching receivable could not be found
	 */
	@Override
	public Receivable fetchByUuid_First(String uuid,
		OrderByComparator<Receivable> orderByComparator) {
		List<Receivable> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last receivable in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receivable
	 * @throws NoSuchReceivableException if a matching receivable could not be found
	 */
	@Override
	public Receivable findByUuid_Last(String uuid,
		OrderByComparator<Receivable> orderByComparator)
		throws NoSuchReceivableException {
		Receivable receivable = fetchByUuid_Last(uuid, orderByComparator);

		if (receivable != null) {
			return receivable;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReceivableException(msg.toString());
	}

	/**
	 * Returns the last receivable in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receivable, or <code>null</code> if a matching receivable could not be found
	 */
	@Override
	public Receivable fetchByUuid_Last(String uuid,
		OrderByComparator<Receivable> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Receivable> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Receivable[] findByUuid_PrevAndNext(long fooId, String uuid,
		OrderByComparator<Receivable> orderByComparator)
		throws NoSuchReceivableException {
		Receivable receivable = findByPrimaryKey(fooId);

		Session session = null;

		try {
			session = openSession();

			Receivable[] array = new ReceivableImpl[3];

			array[0] = getByUuid_PrevAndNext(session, receivable, uuid,
					orderByComparator, true);

			array[1] = receivable;

			array[2] = getByUuid_PrevAndNext(session, receivable, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Receivable getByUuid_PrevAndNext(Session session,
		Receivable receivable, String uuid,
		OrderByComparator<Receivable> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RECEIVABLE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ReceivableModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(receivable);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Receivable> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the receivables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Receivable receivable : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(receivable);
		}
	}

	/**
	 * Returns the number of receivables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching receivables
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RECEIVABLE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "receivable.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "receivable.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(receivable.uuid IS NULL OR receivable.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ReceivableModelImpl.ENTITY_CACHE_ENABLED,
			ReceivableModelImpl.FINDER_CACHE_ENABLED, ReceivableImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ReceivableModelImpl.UUID_COLUMN_BITMASK |
			ReceivableModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ReceivableModelImpl.ENTITY_CACHE_ENABLED,
			ReceivableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the receivable where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchReceivableException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching receivable
	 * @throws NoSuchReceivableException if a matching receivable could not be found
	 */
	@Override
	public Receivable findByUUID_G(String uuid, long groupId)
		throws NoSuchReceivableException {
		Receivable receivable = fetchByUUID_G(uuid, groupId);

		if (receivable == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchReceivableException(msg.toString());
		}

		return receivable;
	}

	/**
	 * Returns the receivable where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching receivable, or <code>null</code> if a matching receivable could not be found
	 */
	@Override
	public Receivable fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the receivable where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching receivable, or <code>null</code> if a matching receivable could not be found
	 */
	@Override
	public Receivable fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Receivable) {
			Receivable receivable = (Receivable)result;

			if (!Objects.equals(uuid, receivable.getUuid()) ||
					(groupId != receivable.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_RECEIVABLE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Receivable> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Receivable receivable = list.get(0);

					result = receivable;

					cacheResult(receivable);

					if ((receivable.getUuid() == null) ||
							!receivable.getUuid().equals(uuid) ||
							(receivable.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, receivable);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Receivable)result;
		}
	}

	/**
	 * Removes the receivable where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the receivable that was removed
	 */
	@Override
	public Receivable removeByUUID_G(String uuid, long groupId)
		throws NoSuchReceivableException {
		Receivable receivable = findByUUID_G(uuid, groupId);

		return remove(receivable);
	}

	/**
	 * Returns the number of receivables where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching receivables
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RECEIVABLE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "receivable.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "receivable.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(receivable.uuid IS NULL OR receivable.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "receivable.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ReceivableModelImpl.ENTITY_CACHE_ENABLED,
			ReceivableModelImpl.FINDER_CACHE_ENABLED, ReceivableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ReceivableModelImpl.ENTITY_CACHE_ENABLED,
			ReceivableModelImpl.FINDER_CACHE_ENABLED, ReceivableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ReceivableModelImpl.UUID_COLUMN_BITMASK |
			ReceivableModelImpl.COMPANYID_COLUMN_BITMASK |
			ReceivableModelImpl.DUEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ReceivableModelImpl.ENTITY_CACHE_ENABLED,
			ReceivableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the receivables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching receivables
	 */
	@Override
	public List<Receivable> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Receivable> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Receivable> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<Receivable> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Receivable> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<Receivable> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Receivable> list = null;

		if (retrieveFromCache) {
			list = (List<Receivable>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Receivable receivable : list) {
					if (!Objects.equals(uuid, receivable.getUuid()) ||
							(companyId != receivable.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_RECEIVABLE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ReceivableModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Receivable>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Receivable>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Receivable findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Receivable> orderByComparator)
		throws NoSuchReceivableException {
		Receivable receivable = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (receivable != null) {
			return receivable;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReceivableException(msg.toString());
	}

	/**
	 * Returns the first receivable in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receivable, or <code>null</code> if a matching receivable could not be found
	 */
	@Override
	public Receivable fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Receivable> orderByComparator) {
		List<Receivable> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Receivable findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Receivable> orderByComparator)
		throws NoSuchReceivableException {
		Receivable receivable = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (receivable != null) {
			return receivable;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReceivableException(msg.toString());
	}

	/**
	 * Returns the last receivable in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receivable, or <code>null</code> if a matching receivable could not be found
	 */
	@Override
	public Receivable fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Receivable> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Receivable> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Receivable[] findByUuid_C_PrevAndNext(long fooId, String uuid,
		long companyId, OrderByComparator<Receivable> orderByComparator)
		throws NoSuchReceivableException {
		Receivable receivable = findByPrimaryKey(fooId);

		Session session = null;

		try {
			session = openSession();

			Receivable[] array = new ReceivableImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, receivable, uuid,
					companyId, orderByComparator, true);

			array[1] = receivable;

			array[2] = getByUuid_C_PrevAndNext(session, receivable, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Receivable getByUuid_C_PrevAndNext(Session session,
		Receivable receivable, String uuid, long companyId,
		OrderByComparator<Receivable> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_RECEIVABLE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ReceivableModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(receivable);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Receivable> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the receivables where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Receivable receivable : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(receivable);
		}
	}

	/**
	 * Returns the number of receivables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching receivables
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RECEIVABLE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "receivable.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "receivable.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(receivable.uuid IS NULL OR receivable.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "receivable.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FINDBYAMOUNT =
		new FinderPath(ReceivableModelImpl.ENTITY_CACHE_ENABLED,
			ReceivableModelImpl.FINDER_CACHE_ENABLED, ReceivableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindByAmount",
			new String[] {
				Double.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYAMOUNT =
		new FinderPath(ReceivableModelImpl.ENTITY_CACHE_ENABLED,
			ReceivableModelImpl.FINDER_CACHE_ENABLED, ReceivableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFindByAmount",
			new String[] { Double.class.getName() },
			ReceivableModelImpl.AMOUNT_COLUMN_BITMASK |
			ReceivableModelImpl.DUEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FINDBYAMOUNT = new FinderPath(ReceivableModelImpl.ENTITY_CACHE_ENABLED,
			ReceivableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFindByAmount",
			new String[] { Double.class.getName() });

	/**
	 * Returns all the receivables where amount = &#63;.
	 *
	 * @param amount the amount
	 * @return the matching receivables
	 */
	@Override
	public List<Receivable> findByFindByAmount(Double amount) {
		return findByFindByAmount(amount, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Receivable> findByFindByAmount(Double amount, int start, int end) {
		return findByFindByAmount(amount, start, end, null);
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
	@Override
	public List<Receivable> findByFindByAmount(Double amount, int start,
		int end, OrderByComparator<Receivable> orderByComparator) {
		return findByFindByAmount(amount, start, end, orderByComparator, true);
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
	@Override
	public List<Receivable> findByFindByAmount(Double amount, int start,
		int end, OrderByComparator<Receivable> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYAMOUNT;
			finderArgs = new Object[] { amount };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FINDBYAMOUNT;
			finderArgs = new Object[] { amount, start, end, orderByComparator };
		}

		List<Receivable> list = null;

		if (retrieveFromCache) {
			list = (List<Receivable>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Receivable receivable : list) {
					if (!Objects.equals(amount, receivable.getAmount())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_RECEIVABLE_WHERE);

			query.append(_FINDER_COLUMN_FINDBYAMOUNT_AMOUNT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ReceivableModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(amount.doubleValue());

				if (!pagination) {
					list = (List<Receivable>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Receivable>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first receivable in the ordered set where amount = &#63;.
	 *
	 * @param amount the amount
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receivable
	 * @throws NoSuchReceivableException if a matching receivable could not be found
	 */
	@Override
	public Receivable findByFindByAmount_First(Double amount,
		OrderByComparator<Receivable> orderByComparator)
		throws NoSuchReceivableException {
		Receivable receivable = fetchByFindByAmount_First(amount,
				orderByComparator);

		if (receivable != null) {
			return receivable;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("amount=");
		msg.append(amount);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReceivableException(msg.toString());
	}

	/**
	 * Returns the first receivable in the ordered set where amount = &#63;.
	 *
	 * @param amount the amount
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receivable, or <code>null</code> if a matching receivable could not be found
	 */
	@Override
	public Receivable fetchByFindByAmount_First(Double amount,
		OrderByComparator<Receivable> orderByComparator) {
		List<Receivable> list = findByFindByAmount(amount, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last receivable in the ordered set where amount = &#63;.
	 *
	 * @param amount the amount
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receivable
	 * @throws NoSuchReceivableException if a matching receivable could not be found
	 */
	@Override
	public Receivable findByFindByAmount_Last(Double amount,
		OrderByComparator<Receivable> orderByComparator)
		throws NoSuchReceivableException {
		Receivable receivable = fetchByFindByAmount_Last(amount,
				orderByComparator);

		if (receivable != null) {
			return receivable;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("amount=");
		msg.append(amount);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReceivableException(msg.toString());
	}

	/**
	 * Returns the last receivable in the ordered set where amount = &#63;.
	 *
	 * @param amount the amount
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receivable, or <code>null</code> if a matching receivable could not be found
	 */
	@Override
	public Receivable fetchByFindByAmount_Last(Double amount,
		OrderByComparator<Receivable> orderByComparator) {
		int count = countByFindByAmount(amount);

		if (count == 0) {
			return null;
		}

		List<Receivable> list = findByFindByAmount(amount, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Receivable[] findByFindByAmount_PrevAndNext(long fooId,
		Double amount, OrderByComparator<Receivable> orderByComparator)
		throws NoSuchReceivableException {
		Receivable receivable = findByPrimaryKey(fooId);

		Session session = null;

		try {
			session = openSession();

			Receivable[] array = new ReceivableImpl[3];

			array[0] = getByFindByAmount_PrevAndNext(session, receivable,
					amount, orderByComparator, true);

			array[1] = receivable;

			array[2] = getByFindByAmount_PrevAndNext(session, receivable,
					amount, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Receivable getByFindByAmount_PrevAndNext(Session session,
		Receivable receivable, Double amount,
		OrderByComparator<Receivable> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RECEIVABLE_WHERE);

		query.append(_FINDER_COLUMN_FINDBYAMOUNT_AMOUNT_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ReceivableModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(amount.doubleValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(receivable);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Receivable> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the receivables where amount = &#63; from the database.
	 *
	 * @param amount the amount
	 */
	@Override
	public void removeByFindByAmount(Double amount) {
		for (Receivable receivable : findByFindByAmount(amount,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(receivable);
		}
	}

	/**
	 * Returns the number of receivables where amount = &#63;.
	 *
	 * @param amount the amount
	 * @return the number of matching receivables
	 */
	@Override
	public int countByFindByAmount(Double amount) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FINDBYAMOUNT;

		Object[] finderArgs = new Object[] { amount };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RECEIVABLE_WHERE);

			query.append(_FINDER_COLUMN_FINDBYAMOUNT_AMOUNT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(amount.doubleValue());

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FINDBYAMOUNT_AMOUNT_2 = "receivable.amount = ?";

	public ReceivablePersistenceImpl() {
		setModelClass(Receivable.class);
	}

	/**
	 * Caches the receivable in the entity cache if it is enabled.
	 *
	 * @param receivable the receivable
	 */
	@Override
	public void cacheResult(Receivable receivable) {
		entityCache.putResult(ReceivableModelImpl.ENTITY_CACHE_ENABLED,
			ReceivableImpl.class, receivable.getPrimaryKey(), receivable);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { receivable.getUuid(), receivable.getGroupId() },
			receivable);

		receivable.resetOriginalValues();
	}

	/**
	 * Caches the receivables in the entity cache if it is enabled.
	 *
	 * @param receivables the receivables
	 */
	@Override
	public void cacheResult(List<Receivable> receivables) {
		for (Receivable receivable : receivables) {
			if (entityCache.getResult(
						ReceivableModelImpl.ENTITY_CACHE_ENABLED,
						ReceivableImpl.class, receivable.getPrimaryKey()) == null) {
				cacheResult(receivable);
			}
			else {
				receivable.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all receivables.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ReceivableImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the receivable.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Receivable receivable) {
		entityCache.removeResult(ReceivableModelImpl.ENTITY_CACHE_ENABLED,
			ReceivableImpl.class, receivable.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ReceivableModelImpl)receivable);
	}

	@Override
	public void clearCache(List<Receivable> receivables) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Receivable receivable : receivables) {
			entityCache.removeResult(ReceivableModelImpl.ENTITY_CACHE_ENABLED,
				ReceivableImpl.class, receivable.getPrimaryKey());

			clearUniqueFindersCache((ReceivableModelImpl)receivable);
		}
	}

	protected void cacheUniqueFindersCache(
		ReceivableModelImpl receivableModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					receivableModelImpl.getUuid(),
					receivableModelImpl.getGroupId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				receivableModelImpl);
		}
		else {
			if ((receivableModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						receivableModelImpl.getUuid(),
						receivableModelImpl.getGroupId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					receivableModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ReceivableModelImpl receivableModelImpl) {
		Object[] args = new Object[] {
				receivableModelImpl.getUuid(), receivableModelImpl.getGroupId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((receivableModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					receivableModelImpl.getOriginalUuid(),
					receivableModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new receivable with the primary key. Does not add the receivable to the database.
	 *
	 * @param fooId the primary key for the new receivable
	 * @return the new receivable
	 */
	@Override
	public Receivable create(long fooId) {
		Receivable receivable = new ReceivableImpl();

		receivable.setNew(true);
		receivable.setPrimaryKey(fooId);

		String uuid = PortalUUIDUtil.generate();

		receivable.setUuid(uuid);

		receivable.setCompanyId(companyProvider.getCompanyId());

		return receivable;
	}

	/**
	 * Removes the receivable with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fooId the primary key of the receivable
	 * @return the receivable that was removed
	 * @throws NoSuchReceivableException if a receivable with the primary key could not be found
	 */
	@Override
	public Receivable remove(long fooId) throws NoSuchReceivableException {
		return remove((Serializable)fooId);
	}

	/**
	 * Removes the receivable with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the receivable
	 * @return the receivable that was removed
	 * @throws NoSuchReceivableException if a receivable with the primary key could not be found
	 */
	@Override
	public Receivable remove(Serializable primaryKey)
		throws NoSuchReceivableException {
		Session session = null;

		try {
			session = openSession();

			Receivable receivable = (Receivable)session.get(ReceivableImpl.class,
					primaryKey);

			if (receivable == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchReceivableException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(receivable);
		}
		catch (NoSuchReceivableException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Receivable removeImpl(Receivable receivable) {
		receivable = toUnwrappedModel(receivable);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(receivable)) {
				receivable = (Receivable)session.get(ReceivableImpl.class,
						receivable.getPrimaryKeyObj());
			}

			if (receivable != null) {
				session.delete(receivable);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (receivable != null) {
			clearCache(receivable);
		}

		return receivable;
	}

	@Override
	public Receivable updateImpl(Receivable receivable) {
		receivable = toUnwrappedModel(receivable);

		boolean isNew = receivable.isNew();

		ReceivableModelImpl receivableModelImpl = (ReceivableModelImpl)receivable;

		if (Validator.isNull(receivable.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			receivable.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (receivable.getCreateDate() == null)) {
			if (serviceContext == null) {
				receivable.setCreateDate(now);
			}
			else {
				receivable.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!receivableModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				receivable.setModifiedDate(now);
			}
			else {
				receivable.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (receivable.isNew()) {
				session.save(receivable);

				receivable.setNew(false);
			}
			else {
				receivable = (Receivable)session.merge(receivable);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ReceivableModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((receivableModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						receivableModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { receivableModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((receivableModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						receivableModelImpl.getOriginalUuid(),
						receivableModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						receivableModelImpl.getUuid(),
						receivableModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((receivableModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYAMOUNT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						receivableModelImpl.getOriginalAmount()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FINDBYAMOUNT, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYAMOUNT,
					args);

				args = new Object[] { receivableModelImpl.getAmount() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FINDBYAMOUNT, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYAMOUNT,
					args);
			}
		}

		entityCache.putResult(ReceivableModelImpl.ENTITY_CACHE_ENABLED,
			ReceivableImpl.class, receivable.getPrimaryKey(), receivable, false);

		clearUniqueFindersCache(receivableModelImpl);
		cacheUniqueFindersCache(receivableModelImpl, isNew);

		receivable.resetOriginalValues();

		return receivable;
	}

	protected Receivable toUnwrappedModel(Receivable receivable) {
		if (receivable instanceof ReceivableImpl) {
			return receivable;
		}

		ReceivableImpl receivableImpl = new ReceivableImpl();

		receivableImpl.setNew(receivable.isNew());
		receivableImpl.setPrimaryKey(receivable.getPrimaryKey());

		receivableImpl.setUuid(receivable.getUuid());
		receivableImpl.setFooId(receivable.getFooId());
		receivableImpl.setGroupId(receivable.getGroupId());
		receivableImpl.setCompanyId(receivable.getCompanyId());
		receivableImpl.setUserId(receivable.getUserId());
		receivableImpl.setUserName(receivable.getUserName());
		receivableImpl.setCreateDate(receivable.getCreateDate());
		receivableImpl.setModifiedDate(receivable.getModifiedDate());
		receivableImpl.setDueDate(receivable.getDueDate());
		receivableImpl.setAmount(receivable.getAmount());
		receivableImpl.setDescription(receivable.getDescription());
		receivableImpl.setPath(receivable.getPath());
		receivableImpl.setDocumentId(receivable.getDocumentId());
		receivableImpl.setFlag(receivable.getFlag());
		receivableImpl.setSupplierName(receivable.getSupplierName());

		return receivableImpl;
	}

	/**
	 * Returns the receivable with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the receivable
	 * @return the receivable
	 * @throws NoSuchReceivableException if a receivable with the primary key could not be found
	 */
	@Override
	public Receivable findByPrimaryKey(Serializable primaryKey)
		throws NoSuchReceivableException {
		Receivable receivable = fetchByPrimaryKey(primaryKey);

		if (receivable == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchReceivableException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return receivable;
	}

	/**
	 * Returns the receivable with the primary key or throws a {@link NoSuchReceivableException} if it could not be found.
	 *
	 * @param fooId the primary key of the receivable
	 * @return the receivable
	 * @throws NoSuchReceivableException if a receivable with the primary key could not be found
	 */
	@Override
	public Receivable findByPrimaryKey(long fooId)
		throws NoSuchReceivableException {
		return findByPrimaryKey((Serializable)fooId);
	}

	/**
	 * Returns the receivable with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the receivable
	 * @return the receivable, or <code>null</code> if a receivable with the primary key could not be found
	 */
	@Override
	public Receivable fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ReceivableModelImpl.ENTITY_CACHE_ENABLED,
				ReceivableImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Receivable receivable = (Receivable)serializable;

		if (receivable == null) {
			Session session = null;

			try {
				session = openSession();

				receivable = (Receivable)session.get(ReceivableImpl.class,
						primaryKey);

				if (receivable != null) {
					cacheResult(receivable);
				}
				else {
					entityCache.putResult(ReceivableModelImpl.ENTITY_CACHE_ENABLED,
						ReceivableImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ReceivableModelImpl.ENTITY_CACHE_ENABLED,
					ReceivableImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return receivable;
	}

	/**
	 * Returns the receivable with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fooId the primary key of the receivable
	 * @return the receivable, or <code>null</code> if a receivable with the primary key could not be found
	 */
	@Override
	public Receivable fetchByPrimaryKey(long fooId) {
		return fetchByPrimaryKey((Serializable)fooId);
	}

	@Override
	public Map<Serializable, Receivable> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Receivable> map = new HashMap<Serializable, Receivable>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Receivable receivable = fetchByPrimaryKey(primaryKey);

			if (receivable != null) {
				map.put(primaryKey, receivable);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ReceivableModelImpl.ENTITY_CACHE_ENABLED,
					ReceivableImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Receivable)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_RECEIVABLE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Receivable receivable : (List<Receivable>)q.list()) {
				map.put(receivable.getPrimaryKeyObj(), receivable);

				cacheResult(receivable);

				uncachedPrimaryKeys.remove(receivable.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ReceivableModelImpl.ENTITY_CACHE_ENABLED,
					ReceivableImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the receivables.
	 *
	 * @return the receivables
	 */
	@Override
	public List<Receivable> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Receivable> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Receivable> findAll(int start, int end,
		OrderByComparator<Receivable> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Receivable> findAll(int start, int end,
		OrderByComparator<Receivable> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Receivable> list = null;

		if (retrieveFromCache) {
			list = (List<Receivable>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RECEIVABLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RECEIVABLE;

				if (pagination) {
					sql = sql.concat(ReceivableModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Receivable>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Receivable>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the receivables from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Receivable receivable : findAll()) {
			remove(receivable);
		}
	}

	/**
	 * Returns the number of receivables.
	 *
	 * @return the number of receivables
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RECEIVABLE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ReceivableModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the receivable persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ReceivableImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_RECEIVABLE = "SELECT receivable FROM Receivable receivable";
	private static final String _SQL_SELECT_RECEIVABLE_WHERE_PKS_IN = "SELECT receivable FROM Receivable receivable WHERE fooId IN (";
	private static final String _SQL_SELECT_RECEIVABLE_WHERE = "SELECT receivable FROM Receivable receivable WHERE ";
	private static final String _SQL_COUNT_RECEIVABLE = "SELECT COUNT(receivable) FROM Receivable receivable";
	private static final String _SQL_COUNT_RECEIVABLE_WHERE = "SELECT COUNT(receivable) FROM Receivable receivable WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "receivable.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Receivable exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Receivable exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ReceivablePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "path"
			});
}