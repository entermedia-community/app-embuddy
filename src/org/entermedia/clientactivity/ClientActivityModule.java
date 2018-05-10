package org.entermedia.clientactivity;

import org.entermediadb.asset.MediaArchive;
import org.entermediadb.asset.modules.BaseMediaModule;
import org.openedit.WebPageRequest;

public class ClientActivityModule extends BaseMediaModule
{
	public void checkActivity(WebPageRequest inReq)
	{
		String catalogid = inReq.findValue("catalogid");
		ClientActivityManager manager = (ClientActivityManager) getModuleManager().getBean(catalogid, "clientActivityManager");
		MediaArchive archive = getMediaArchive(inReq);

		manager.checkClientActivity(archive);
	}
}
