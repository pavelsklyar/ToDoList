package model;

import database.tables.Users;

import javax.servlet.http.HttpSession;

public class Authentication {

    public boolean regUser(String email, String password) {
        String salt = Security.getSalt();
        String pass = Security.getHashPassword(password, salt);

        return Users.setNewUser(email, pass, salt);
    }

    public boolean authUser(String email, String password) {
        User user = Users.getUserByEmail(email);

        if (user != null)
            return user.getPassword().equals(Security.getHashPassword(password, user.getSalt()));
        else
            return false;
    }
}
