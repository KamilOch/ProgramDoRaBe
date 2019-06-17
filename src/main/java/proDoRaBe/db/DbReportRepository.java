package proDoRaBe.db;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import proDoRaBe.model.ReportRepository;


import java.util.List;

@Repository
@Profile("!demo")
public class DbReportRepository implements ReportRepository {

    private final JdbcTemplate jdbcTemplate;

    public DbReportRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

   public List<String> getAll(){
       return  jdbcTemplate.queryForList("SELECT klient FROM public.reports", String.class);
   }
}
