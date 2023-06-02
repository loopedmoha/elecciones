package mgg.code.controller;

import mgg.code.model.CP;
import mgg.code.model.Key;
import mgg.code.repository.CPRepository;
import mgg.code.service.CPService;


import java.io.IOException;
import java.util.List;

public class CPController {
    private static CPController controller = null;
    private final CPService service;

    private CPController(CPService service) {
        this.service = service;
    }

    public static CPController getInstance() {
        if (controller == null) {
            controller = new CPController(new CPService(new CPRepository()));
        }
        return controller;
    }

    public List<CP> getAllCPs() {
        return service.getAllCPs();
    }
    public void getAllCPsInCsv() throws IOException {
        service.getAllCPsInCsv();
    }

    public CP getCPById(Key id) {
        return service.getCPById(id);
    }
    public void getCPByIdInCsv(Key id) throws IOException {service.getCPByIdInCsv(id);}

    public CP postCP(CP cp) {
        return service.postCP(cp);
    }

    public CP updateCP(CP cp) {
        return service.updateCP(cp);
    }

    public CP deleteCP(CP cp) {
        return service.deleteCP(cp);
    }
}
