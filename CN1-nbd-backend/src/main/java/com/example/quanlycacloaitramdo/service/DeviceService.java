package com.example.quanlycacloaitramdo.service;

import com.example.quanlycacloaitramdo.entity.Device;
import com.example.quanlycacloaitramdo.entity.DeviceValidator;
import com.example.quanlycacloaitramdo.entity.LogsAction;
import com.example.quanlycacloaitramdo.repository.DeviceRepository;

import com.example.quanlycacloaitramdo.repository.LogsActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private DeviceValidator deviceValidator;

    @Autowired
    private LogsActionRepository logsActionRepository;

    public ResponseEntity<List<Device>> getDevices(String object_TYPE, String object_TYPE_SHORTNAME, String is_AUTO) {
        try {
            List<Device> devices = new ArrayList<Device>();

            if (object_TYPE == null && object_TYPE_SHORTNAME == null && is_AUTO == null)
                deviceRepository.findAll().forEach(devices::add);
            else
                deviceRepository.findByContain(object_TYPE.toUpperCase(), object_TYPE_SHORTNAME.toUpperCase(), is_AUTO).forEach(devices::add);
            if (devices.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(devices, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Device> addDevice(Device device) {
        try {
            Device _device;
            if (deviceValidator.isValid(device)) {
                if (deviceRepository.findByObjectTYPE(device.getObject_TYPE().toUpperCase()) == 0) {
                    switch (device.getIs_AUTO()) {
                        case "Th??? c??ng":
                            String not_Auto = "0";
                            _device = deviceRepository
                                    .save(new Device(device.getObject_TYPE_ID(), device.getObject_TYPE().toUpperCase(), device.getObject_TYPE_SHORTNAME(), not_Auto));
                            break;
                        case "T??? ?????ng ??o":
                            String is_Auto = "1";
                            _device = deviceRepository
                                    .save(new Device(device.getObject_TYPE_ID(), device.getObject_TYPE().toUpperCase(), device.getObject_TYPE_SHORTNAME(), is_Auto));
                            break;
                        default:
                            _device = deviceRepository
                                    .save(new Device(device.getObject_TYPE_ID(), device.getObject_TYPE().toUpperCase(), device.getObject_TYPE_SHORTNAME(), device.getIs_AUTO()));
                    }
                    String today = "26-NOV-21 04.51.00.000000000 PM";
                    logsActionRepository.save(new LogsAction(10077, "Qu???n l?? lo???i tr???m ??o", "ADD", "administrator", today, "OBJECT_TYPE"));
                    return new ResponseEntity<Device>(_device, HttpStatus.CREATED);
                } else return new ResponseEntity<Device>(HttpStatus.ACCEPTED);
            } else return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Device> updateDevice(Device device) {
        try {
            Device _device = null;
            if (deviceValidator.isValid(device)) {
                switch (device.getIs_AUTO()) {
                    case "Th??? c??ng":
                        _device.setObject_TYPE(device.getObject_TYPE());
                        _device.setObject_TYPE_SHORTNAME(device.getObject_TYPE_SHORTNAME());
                        _device.setIs_AUTO("0");
                        deviceRepository.save(_device);
                        break;
                    case "T??? ?????ng ??o":
                        _device.setObject_TYPE(device.getObject_TYPE().toUpperCase());
                        _device.setObject_TYPE_SHORTNAME(device.getObject_TYPE_SHORTNAME());
                        _device.setIs_AUTO("1");
                        deviceRepository.save(_device);
                        break;
                    default:
                        _device.setObject_TYPE(device.getObject_TYPE().toUpperCase());
                        _device.setObject_TYPE_SHORTNAME(device.getObject_TYPE_SHORTNAME());
                        _device.setIs_AUTO(device.getIs_AUTO());
                        deviceRepository.save(_device);
                }
                String today = "26-NOV-21 04.55.00.000000000 PM";
                logsActionRepository.save(new LogsAction(10779, "Qu???n l?? lo???i tr???m ??o", "UPDATE", "administrator", today, "OBJECT_TYPE"));
                return new ResponseEntity<Device>(_device, HttpStatus.CREATED);
            } else return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
