package QuanLyCacLoaiTramDo.service;

import QuanLyCacLoaiTramDo.entity.Device;
import QuanLyCacLoaiTramDo.entity.DeviceValidator;
import QuanLyCacLoaiTramDo.entity.LogsAction;
import QuanLyCacLoaiTramDo.repository.DeviceRepository;
import QuanLyCacLoaiTramDo.repository.LogsActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
                        case "Thủ công":
                            String not_Auto = "0";
                            _device = deviceRepository
                                    .save(new Device(device.getObject_TYPE_ID(), device.getObject_TYPE().toUpperCase(), device.getObject_TYPE_SHORTNAME(), not_Auto));
                            break;
                        case "Tự động đo":
                            String is_Auto = "1";
                            _device = deviceRepository
                                    .save(new Device(device.getObject_TYPE_ID(), device.getObject_TYPE().toUpperCase(), device.getObject_TYPE_SHORTNAME(), is_Auto));
                            break;
                        default:
                            _device = deviceRepository
                                    .save(new Device(device.getObject_TYPE_ID(), device.getObject_TYPE().toUpperCase(), device.getObject_TYPE_SHORTNAME(), device.getIs_AUTO()));
                    }
                    Date date = new Date();
                    long time = date.getTime();
                    Timestamp today = new Timestamp(time);
                    logsActionRepository.save(new LogsAction(logsActionRepository.getMaxIDCurrent()+1, "Quản lý loại trạm đo", "ADD", "administrator", today, "OBJECT_TYPE"));
                    return new ResponseEntity<Device>(_device, HttpStatus.CREATED);
                } else return new ResponseEntity<Device>(HttpStatus.ACCEPTED);
            } else return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Device> updateDevice(Device device, String object_TYPE) {
        try {
            Device _device;
            if (deviceValidator.isValid(device)) {
                switch (device.getIs_AUTO()) {
                    case "Thủ công":
                        device.setObject_TYPE(object_TYPE.toUpperCase());
                        device.setObject_TYPE_SHORTNAME(device.getObject_TYPE_SHORTNAME());
                        device.setIs_AUTO("0");
                        _device = deviceRepository.save(device);
                        break;
                    case "Tự động đo":
                        device.setObject_TYPE(object_TYPE.toUpperCase());
                        device.setObject_TYPE_SHORTNAME(device.getObject_TYPE_SHORTNAME());
                        device.setIs_AUTO("1");
                        _device = deviceRepository.save(device);
                        break;
                    default:
                        device.setObject_TYPE(object_TYPE);
                        device.setObject_TYPE_SHORTNAME(device.getObject_TYPE_SHORTNAME());
                        device.setIs_AUTO(device.getIs_AUTO());
                        _device = deviceRepository.save(device);
                }
                Date date = new Date();
                long time = date.getTime();
                Timestamp today = new Timestamp(time);
                logsActionRepository.save(new LogsAction(logsActionRepository.getMaxIDCurrent()+1, "Quản lý loại trạm đo", "UPDATE", "administrator", today, "OBJECT_TYPE"));
                return new ResponseEntity<Device>(_device, HttpStatus.CREATED);
            } else return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
