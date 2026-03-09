package main.java.com.porado.LogistiQ.backend.serviceImpl;

import com.porado.LogistiQ.backend.model.Driver;
import com.porado.LogistiQ.backend.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Driver addDriver(Driver driver) {
        // Here you could add business logic, like checking if the license is valid
        return driverRepository.save(driver);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }
}