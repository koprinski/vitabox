import com.google.inject.AbstractModule;
import com.omisoft.vitafu.mapping.ModelMapper;
import com.omisoft.vitafu.mapping.ModelMapperImpl;
import com.omisoft.vitafu.test.dao.MovieDAOTestImpl;
import com.omisoft.vitafu.dao.movies.MovieDAO;

/**
 * Created by dido on 11/13/14.
 */
public class FakeDependencyModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(MovieDAO.class).to(MovieDAOTestImpl.class);
        bind(ModelMapper.class).to(ModelMapperImpl.class);


    }
}