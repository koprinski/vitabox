package com.omisoft.vitafu.themoviedbapi;

import org.apache.commons.lang3.StringUtils;
import com.omisoft.vitafu.themoviedbapi.model.Collection;
import com.omisoft.vitafu.themoviedbapi.model.Company;
import com.omisoft.vitafu.themoviedbapi.model.core.ResultsPage;
import com.omisoft.vitafu.themoviedbapi.tools.ApiUrl;

import java.util.List;


public class TmdbCompany extends AbstractTmdbApi {

    public static final String TMDB_METHOD_COMPANY = "company";


    TmdbCompany(TmdbApi tmdbApi) {
        super(tmdbApi);
    }


    /**
     * This method is used to retrieve the basic information about a production company on TMDb.
     *
     * @param companyId
     */
    public Company getCompanyInfo(int companyId) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_COMPANY, companyId);

        return mapJsonResult(apiUrl, Company.class);
    }


    /**
     * This method is used to retrieve the movies associated with a company.
     * <p/>
     * These movies are returned in order of most recently released to oldest. The default response will return 20
     * movies per page.
     * <p/>
     * TODO: Implement more than 20 movies
     *
     * @param companyId
     * @param language
     * @param page
     */
    public List<Collection> getCompanyMovies(int companyId, String language, Integer page) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_COMPANY, companyId, "movies");

        if (StringUtils.isNotBlank(language)) {
            apiUrl.addParam(PARAM_LANGUAGE, language);
        }

        if (page != null && page > 0) {
            apiUrl.addParam(PARAM_PAGE, page);
        }

        return mapJsonResult(apiUrl, CollectionResults.class).getResults();
    }


    private static class CollectionResults extends ResultsPage<Collection> {

    }
}
