package proDoRaBe.model;

import org.springframework.stereotype.Service;
import proDoRaBe.db.DbReportRepository;

import java.util.List;

@Service
public class ReportService {

    public ReportService(DbReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    private final DbReportRepository reportRepository;

    public List<String> getAll(){
        return  reportRepository.getAll();
    }
}
