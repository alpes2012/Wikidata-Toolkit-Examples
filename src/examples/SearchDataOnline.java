package examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.wikidata.wdtk.datamodel.interfaces.EntityDocument;
import org.wikidata.wdtk.datamodel.interfaces.ItemDocument;
import org.wikidata.wdtk.datamodel.interfaces.PropertyIdValue;
import org.wikidata.wdtk.wikibaseapi.WbSearchEntitiesResult;
import org.wikidata.wdtk.wikibaseapi.WbGetEntitiesSearchData;
import org.wikidata.wdtk.wikibaseapi.WikibaseDataFetcher;
import org.wikidata.wdtk.wikibaseapi.apierrors.MediaWikiApiErrorException;

public class SearchDataOnline {

    public static void main(String[] args) throws MediaWikiApiErrorException {
        WikibaseDataFetcher wbdf = WikibaseDataFetcher.getWikidataDataFetcher();
        ArrayList<WbSearchEntitiesResult> lResult = new ArrayList<WbSearchEntitiesResult>();
        WbGetEntitiesSearchData properties =  new WbGetEntitiesSearchData();
        properties.language = "en";
        properties.limit = (long)50;
        properties.search = "china town";
        properties.type = "item";

        lResult = (ArrayList<WbSearchEntitiesResult>) wbdf.searchEntities(properties);

        System.out.println(String.format("%d", lResult.size()));

        ArrayList<String> lQ = new ArrayList<String>();

        for (WbSearchEntitiesResult wr : lResult) {
            lQ.add(wr.getEntityId());
        }

        Map<String, EntityDocument> results = wbdf.getEntityDocuments(lQ);
        System.out.println(String.format("%d", results.size()));
    }
}

