package edu.tcu.cs.frogcrew.system.exception;

public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException(String objectName, Integer id) {
        super("Could not find " + objectName + " with id " + id);
    }

    public ObjectNotFoundException(String objectName, Integer userId, Integer gameId) {
        super("Could not find " + objectName + " for user with id " + userId + " and game with id " + gameId);
    }
}
