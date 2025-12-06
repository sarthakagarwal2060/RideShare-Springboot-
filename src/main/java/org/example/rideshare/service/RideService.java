package org.example.rideshare.service;

import org.example.rideshare.dto.CreateRideRequest;
import org.example.rideshare.model.Ride;
import org.example.rideshare.model.User;
import org.example.rideshare.repository.RideRepository;
import org.example.rideshare.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RideService {

    private final RideRepository rideRepository;
    private final UserRepository userRepository;

    public RideService(RideRepository rideRepository,
                       UserRepository userRepository) {
        this.rideRepository = rideRepository;
        this.userRepository = userRepository;
    }

    public Ride requestRide(String username, CreateRideRequest request) {

        User user = userRepository.findByUsername(username);

        Ride ride = new Ride();
        ride.setUserId(user.getId());
        ride.setPickupLocation(request.getPickupLocation());
        ride.setDropLocation(request.getDropLocation());
        ride.setStatus("REQUESTED");
        ride.setCreatedAt(new Date());

        return rideRepository.save(ride);
    }

    public List<Ride> getMyRides(String username) {
        User user = userRepository.findByUsername(username);
        return rideRepository.findByUserId(user.getId());
    }

    public Ride acceptRide(String driver, String rideId) {
        User driverUser = userRepository.findByUsername(driver);
        Ride ride = rideRepository.findById(rideId).orElse(null);

        if (ride == null || !ride.getStatus().equals("REQUESTED"))
            return null;

        ride.setDriverId(driverUser.getId());
        ride.setStatus("ACCEPTED");
        return rideRepository.save(ride);
    }

    public Ride completeRide(String driver, String rideId) {
        User driverUser = userRepository.findByUsername(driver);
        Ride ride = rideRepository.findById(rideId).orElse(null);

        if (ride == null || !ride.getDriverId().equals(driverUser.getId()))
            return null;

        ride.setStatus("COMPLETED");
        return rideRepository.save(ride);
    }
}
