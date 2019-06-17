package proDoRaBe.model;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    private final ReportRepository reportRepository;

    public List<String> getAll(){
        return  reportRepository.getAll();
    }
}
