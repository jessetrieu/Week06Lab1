/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import bean.User;

/**
 *
 * @author 579957
 */
public class UserService {
    
        public User login(String userName, String password){
        
        if((userName.equals("adam") || userName.equals("betty")) && password.equals("password")){
        
        return new User(userName);

        }
        return null;
    }
    
}
