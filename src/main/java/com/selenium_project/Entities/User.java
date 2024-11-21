package com.selenium_project.Entities;

public class User {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private String dateOfBirth;
    private String location;
    private String phoneNumber;
    private String bio;
    private String post;
    private String comment;
    private String reply;
    private String editedBio;
    private String message;
    private String homeSearch;
    private String bookmarkSearch;

    // Constructor
    public User(String username, String password, String email, String firstName, String lastName, 
                String gender, String dateOfBirth, String location, String phoneNumber, String bio, 
                String post, String comment, String reply, String editedBio, String message, 
                String homeSearch, String bookmarkSearch) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
        this.post = post;
        this.comment = comment;
        this.reply = reply;
        this.editedBio = editedBio;
        this.message = message;
        this.homeSearch = homeSearch;
        this.bookmarkSearch = bookmarkSearch;
    }

    public User(String username, String password) {
this.username = username;
this.password = password;

}

    // Getters and Setters for each field
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getEditedBio() {
        return editedBio;
    }

    public void setEditedBio(String editedBio) {
        this.editedBio = editedBio;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHomeSearch() {
        return homeSearch;
    }

    public void setHomeSearch(String homeSearch) {
        this.homeSearch = homeSearch;
    }

   

    public String getBookmarkSearch() {
        return bookmarkSearch;
    }

    public void setBookmarkSearch(String bookmarkSearch) {
        this.bookmarkSearch = bookmarkSearch;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", location='" + location + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", bio='" + bio + '\'' +
                ", post='" + post + '\'' +
                ", comment='" + comment + '\'' +
                ", reply='" + reply + '\'' +
                ", editedBio='" + editedBio + '\'' +
                ", message='" + message + '\'' +
                ", homeSearch='" + homeSearch + '\'' +
                ", bookmarkSearch='" + bookmarkSearch + '\'' +
                '}';
    }
}

