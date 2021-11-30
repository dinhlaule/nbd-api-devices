package com.example.quanlycacloaitramdo.service;

import com.example.quanlycacloaitramdo.entity.LogsAction;
import com.example.quanlycacloaitramdo.entity.LogsValidator;
import com.example.quanlycacloaitramdo.repository.LogsActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogsActionService {
    @Autowired
    private LogsActionRepository logsActionRepository;

    @Autowired
    private LogsValidator logsValidator;

    public ResponseEntity<List<LogsAction>> getLogs() {
        try {
            List<LogsAction> logs = new ArrayList<LogsAction>();

            logsActionRepository.findAll().forEach(logs::add);

            if (logs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(logs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    public ResponseEntity<LogsAction> addLogs(LogsAction logs) {
//        try {
//            LogsAction _logs;
//            if (logsValidator.isValid(logs)) {
//                _logs = logsActionRepository.save(new LogsAction(logs.getIns_PARAM_ID(), "Quản lý loại trạm đo", logs.getAction(), "administrator", logs.getDate_ACT(), "OBJECT_TYPE"));
//                return new ResponseEntity<>(_logs, HttpStatus.CREATED);
//            } else {
//                return null;
//            }
//
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}

