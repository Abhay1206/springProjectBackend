package com.task.project.Controller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.project.Model.User;
import com.task.project.Service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/User")
public class UserController {

    private final UserService userService;

    /**
     * The function "editName" in a Java controller class updates the name of a user
     * identified by
     * their userId.
     * 
     * @param userId The userId parameter is an Integer that represents the unique
     *               identifier of a
     *               user. It is used to identify the user whose name needs to be
     *               edited.
     * @param name   The "name" parameter is a String that represents the new name
     *               that the user wants to
     *               update.
     * @return The method is returning a ResponseEntity object with a String as the
     *         response body and
     *         HttpStatus.CREATED as the status code.
     */
    @PutMapping("/editName")
    public ResponseEntity<String> editName(@RequestParam(name = "userId") Integer userId,
            @RequestParam(name = "name") String name) {
        return new ResponseEntity<String>(userService.editName(userId, name), HttpStatus.CREATED);
    }

    /**
     * The function "editBio" is a PUT request mapping that takes in a user ID and a
     * bio as parameters,
     * and returns a ResponseEntity with the result of editing the user's bio.
     * 
     * @param userId The userId parameter is an Integer that represents the unique
     *               identifier of a user.
     *               It is used to identify the user whose bio needs to be edited.
     * @param bio    The "bio" parameter is a string that represents the new
     *               biography that the user wants
     *               to update.
     * @return The method is returning a ResponseEntity object with a String as the
     *         response body and
     *         HttpStatus.CREATED as the status code.
     */
    @PutMapping("/editBio")
    public ResponseEntity<String> editBio(@RequestParam(name = "userId") Integer userId,
            @RequestParam(name = "bio") String bio) {
        return new ResponseEntity<String>(userService.editBio(userId, bio), HttpStatus.CREATED);
    }

    /**
     * The function "editAddress" is a PUT request mapping that takes in a user ID
     * and address as
     * parameters and returns a ResponseEntity with the result of the userService's
     * editAddress method.
     * 
     * @param userId  The userId parameter is an Integer that represents the unique
     *                identifier of the
     *                user whose address needs to be edited.
     * @param address The "address" parameter is a string that represents the new
     *                address that the user
     *                wants to update.
     * @return The method is returning a ResponseEntity object with a String as the
     *         response body and
     *         HttpStatus.CREATED as the status code.
     */
    @PutMapping("/editAddress")
    public ResponseEntity<String> editAddress(@RequestParam(name = "userId") Integer userId,
            @RequestParam(name = "address") String address) {
        return new ResponseEntity<String>(userService.editAddress(userId, address), HttpStatus.CREATED);
    }

    /**
     * This function is a GET request mapping that retrieves a user based on their
     * user ID.
     * 
     * @param userId The `userId` parameter is an `Integer` that represents the
     *               unique identifier of a
     *               user. It is passed as a request parameter in the URL when
     *               making a GET request to the `/getUser`
     *               endpoint.
     * @return The method is returning a ResponseEntity object with the User object
     *         and HttpStatus.OK.
     */
    @GetMapping("/getUser")
    public ResponseEntity<User> getUser(@RequestParam(name = "userId") Integer userId) {
        return new ResponseEntity<User>(userService.getuser(userId),
                HttpStatus.OK);
    }

    /**
     * The `follow` function in a Java controller class handles a POST request to
     * follow a user and returns
     * a ResponseEntity with the result.
     * 
     * @param aId The parameter "aId" represents the ID of the user who wants to
     *            follow another user.
     * @param bId The parameter "bId" is an Integer representing the ID of the user
     *            that is being followed.
     * @return The method is returning a ResponseEntity object with a String as the
     *         response body and
     *         HttpStatus.OK as the status code.
     */

    @PostMapping("/followUser")
    public ResponseEntity<String> follow(@RequestParam(name = "aId") Integer aId,
            @RequestParam(name = "bId") Integer bId) {
        return new ResponseEntity<String>(userService.follow(aId, bId), HttpStatus.OK);
    }
}
