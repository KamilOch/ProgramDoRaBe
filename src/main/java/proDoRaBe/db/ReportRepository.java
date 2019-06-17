package proDoRaBe.db;

import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;

public class ReportRepository {

    private final JdbcTemplate jdbcTemplate;

    public ReportRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

   public List<String> baza (){
       return  jdbcTemplate.queryForList("SELECT klient FROM public.reports", String.class);
   }

}
