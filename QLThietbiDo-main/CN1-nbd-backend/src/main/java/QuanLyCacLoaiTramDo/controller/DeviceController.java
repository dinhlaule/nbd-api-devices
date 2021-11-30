package QuanLyCacLoaiTramDo.controller;

import QuanLyCacLoaiTramDo.entity.Device;
import QuanLyCacLoaiTramDo.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081/")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping("/devices")
    public ResponseEntity<List<Device>> getAllDevices(@RequestParam(name = "object_TYPE", required = false) String object_TYPE, @RequestParam(name = "object_TYPE_SHORTNAME", required = false) String object_TYPE_SHORTNAME, @RequestParam(name = "is_AUTO", required = false) String is_AUTO) {
        return deviceService.getDevices(object_TYPE, object_TYPE_SHORTNAME, is_AUTO);
    }

    @PostMapping("/devices")
    public ResponseEntity<Device> createDevice(@RequestBody Device device) { return deviceService.addDevice(device); }

    @PutMapping("/devices/{object_TYPE}")
    public ResponseEntity<Device> updateDevice(@Valid @RequestBody Device device, @PathVariable String object_TYPE) { return deviceService.updateDevice(device, object_TYPE); }

}
