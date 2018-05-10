package org.entermedia.clientactivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.entermediadb.asset.MediaArchive;
import org.openedit.Data;
import org.openedit.MultiValued;
import org.openedit.data.Searcher;

public class ClientActivityManager
{
	private static final Log log = LogFactory.getLog(ClientActivityManager.class);

	public void checkClientActivity(MediaArchive inArchive)
	{
		log.info("starting scan");
		Searcher sites = inArchive.getSearcher("monitoredsitesspeedcheckLog");
		Collection<Data> clients = sites.query().all().search();

		for (Data it : clients)
		{
			MultiValued real = (MultiValued) sites.loadData(it);

			try
			{
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/ddhh:mm:sss");
				Date parsedDate = formatter.parse(real.get("lastchecked"));
				
				if (parsedDate != null)
				{
					log.info(parsedDate.getTime());
				}
			}
			catch (ParseException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
