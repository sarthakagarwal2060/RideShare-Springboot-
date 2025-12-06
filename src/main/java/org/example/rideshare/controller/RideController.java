package org.example.rideshare.controller;

import org.example.rideshare.dto.CreateRideRequest;
import org.example.rideshare.model.Ride;
import org.example.rideshare.service.RideService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rides")
public class RideController {

    private final RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    @PostMapping("/request")
    public ResponseEntity<?> createRide(@RequestBody CreateRideRequest req,
                                        @RequestHeader("username") String username) {
        return ResponseEntity.ok(rideService.requestRide(username, req));
    }

    @GetMapping("/my")
    public ResponseEntity<?> myRides(@RequestHeader("username") String username) {
        return ResponseEntity.ok(rideService.getMyRides(username));
    }

    @PostMapping("/accept/{id}")
    public ResponseEntity<?> accept(@PathVariable String id,
                                    @RequestHeader("username") String driver) {
        return ResponseEntity.ok(rideService.acceptRide(driver, id));
    }

    @PostMapping("/complete/{id}")
    public ResponseEntity<?> complete(@PathVariable String id,
                                      @RequestHeader("username") String driver) {
        return ResponseEntity.ok(rideService.completeRide(driver, id));
    }
}
