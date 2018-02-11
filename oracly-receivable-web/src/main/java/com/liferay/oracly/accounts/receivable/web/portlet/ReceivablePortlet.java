package com.liferay.oracly.accounts.receivable.web.portlet;

import com.liferay.oracly.accounts.receivable.model.Receivable;
import com.liferay.oracly.accounts.receivable.service.ReceivableLocalService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author kpatefield
 */
@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.sample",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Accounts Receivable",
			"javax.portlet.name=com_liferay_oracly_accounts_receivable_web",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/view.jsp",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
	public class ReceivablePortlet extends MVCPortlet {
		
		@Reference(unbind = "-")
		 protected void receivableLocalService(ReceivableLocalService receivableLocalService) {
			_receivableLocalService = receivableLocalService;
		 }
		private ReceivableLocalService _receivableLocalService;
		
		
		public void doView(
				RenderRequest renderRequest, RenderResponse renderResponse)
					throws IOException, PortletException {
			
		DynamicQuery receivableDynamicQuery = _receivableLocalService.dynamicQuery();
		String pagingString = renderRequest.getParameter("cur1");
		int start = 0;
		int end = 10;
		int pagingVal = 0;
		if (pagingString != null)
		{
			pagingVal = Integer.valueOf(pagingString);
		
		}
		if (pagingVal > 1)
		{
			end = pagingVal * 10;
			start = (pagingVal * 10) - 10;
		}
		
		List<Receivable> receivableList = _receivableLocalService.dynamicQuery(receivableDynamicQuery, start, end);
		int receivableCount = (int) _receivableLocalService.dynamicQueryCount(receivableDynamicQuery);
		renderRequest.setAttribute("receivableList", receivableList);
		renderRequest.setAttribute("receivableCount", receivableCount);
		
		super.doView(renderRequest, renderResponse);
		
		}
		
	}