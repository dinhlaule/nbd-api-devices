package QuanLyCacLoaiTramDo.service;

import QuanLyCacLoaiTramDo.entity.LogsAction;
import QuanLyCacLoaiTramDo.entity.LogsValidator;
import QuanLyCacLoaiTramDo.repository.LogsActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LogsActionService {
    @Autowired
    private LogsActionRepository logsActionRepository;

    @Autowired
    private LogsValidator logsValidator;

    public ResponseEntity<LogsAction> addLogs(LogsAction logs) {
        try {
            LogsAction _logs;
            if (logsValidator.isValid(logs)) {
                _logs = logsActionRepository.save(new LogsAction(logs.getIns_PARAM_ID(), "Quản lý loại trạm đo", logs.getAction(), "administrator", logs.getDate_ACT(), "OBJECT_TYPE"));
                return new ResponseEntity<>(_logs, HttpStatus.CREATED);
            } else {
                return null;
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
