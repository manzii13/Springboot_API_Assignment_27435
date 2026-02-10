package auca.ac.user_profile_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import auca.ac.user_profile_api.model.ApiResponse;
import auca.ac.user_profile_api.model.UserProfile;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {

    private List<UserProfile> users = new ArrayList<>();

    public UserProfileController() {
        users.add(new UserProfile(1L, "john_doe", "john@gmail.com",
                "John Doe", 25, "USA", "Software developer", true));
        users.add(new UserProfile(2L, "mary99", "mary@gmail.com",
                "Mary Smith", 30, "UK", "Designer", false));
    }

    // creating the profile
    @PostMapping
    public ResponseEntity<ApiResponse<UserProfile>> createUser(@RequestBody UserProfile user) {
        users.add(user);
        return new ResponseEntity<>(
                new ApiResponse<>(true, "User profile created successfully", user),
                HttpStatus.CREATED
        );
    }

    // get all users
    @GetMapping
    public ResponseEntity<ApiResponse<List<UserProfile>>> getAllUsers() {
        return ResponseEntity.ok(
                new ApiResponse<>(true, "User profiles retrieved", users)
        );
    }

    // get by id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserProfile>> getUserById(@PathVariable Long id) {
        for (UserProfile user : users) {
            if (user.getUserId().equals(id)) {
                return ResponseEntity.ok(
                        new ApiResponse<>(true, "User found", user)
                );
            }
        }
        return new ResponseEntity<>(
                new ApiResponse<>(false, "User not found", null),
                HttpStatus.NOT_FOUND
        );
    }

    // search user by thir username
    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<UserProfile>>> searchByUsername(
            @RequestParam String username) {

        List<UserProfile> result = new ArrayList<>();
        for (UserProfile user : users) {
            if (user.getUsername().toLowerCase().contains(username.toLowerCase())) {
                result.add(user);
            }
        }

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Search results", result)
        );
    }

    // get user by their country
    @GetMapping("/country/{country}")
    public ResponseEntity<ApiResponse<List<UserProfile>>> getByCountry(
            @PathVariable String country) {

        List<UserProfile> result = new ArrayList<>();
        for (UserProfile user : users) {
            if (user.getCountry().equalsIgnoreCase(country)) {
                result.add(user);
            }
        }

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Users from " + country, result)
        );
    }

    // get by age range
    @GetMapping("/age-range")
    public ResponseEntity<ApiResponse<List<UserProfile>>> getByAgeRange(
            @RequestParam int min,
            @RequestParam int max) {

        List<UserProfile> result = new ArrayList<>();
        for (UserProfile user : users) {
            if (user.getAge() >= min && user.getAge() <= max) {
                result.add(user);
            }
        }

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Users in age range", result)
        );
    }

    // activating and de-activating status
    @PatchMapping("/{id}/status")
    public ResponseEntity<ApiResponse<UserProfile>> updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {

        for (UserProfile user : users) {
            if (user.getUserId().equals(id)) {
                user.setActive(active);
                return ResponseEntity.ok(
                        new ApiResponse<>(true, "User status updated", user)
                );
            }
        }

        return new ResponseEntity<>(
                new ApiResponse<>(false, "User not found", null),
                HttpStatus.NOT_FOUND
        );
    }

    // deleting by id
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable Long id) {
        users.removeIf(user -> user.getUserId().equals(id));
        return ResponseEntity.ok(
                new ApiResponse<>(true, "User deleted successfully", null)
        );
    }
}

