package com.example.quanlycacloaitramdo.controller;

import com.example.quanlycacloaitramdo.entity.Device;
import com.example.quanlycacloaitramdo.entity.LogsAction;
import com.example.quanlycacloaitramdo.service.DeviceService;
import com.example.quanlycacloaitramdo.service.LogsActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081/")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private LogsActionService logsActionService;

    @GetMapping("/devices")
    public ResponseEntity<List<Device>> getAllDevices(@RequestParam(name = "object_TYPE", required = false) String object_TYPE, @RequestParam(name = "object_TYPE_SHORTNAME", required = false) String object_TYPE_SHORTNAME, @RequestParam(name = "is_AUTO", required = false) String is_AUTO) {
        return deviceService.getDevices(object_TYPE, object_TYPE_SHORTNAME, is_AUTO);
    }

    @PostMapping("/devices")
    public ResponseEntity<Device> createDevice(@RequestBody Device device) { return deviceService.addDevice(device); }

    @PutMapping("/devices")
    public ResponseEntity<Device> updateDevice(@RequestBody Device device) { return deviceService.updateDevice(device); }

    @GetMapping("/logs-action-detail")
    public ResponseEntity<List<LogsAction>> getAllLogs() { return logsActionService.getLogs(); }

//    @PostMapping("/logs-action-detail")
//    public ResponseEntity<LogsAction> createLog(@RequestBody LogsAction logsAction) { return logsActionService.addLogs(logsAction); }
}
