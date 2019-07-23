package com.newline.sjyn.audionce.route.user

import com.newline.sjyn.audionce.model.User
import com.newline.sjyn.audionce.model.UserData
import com.newline.sjyn.audionce.model.UserLogin
import com.newline.sjyn.audionce.model.Users
import org.mindrot.jbcrypt.BCrypt

object UserApi {
    fun createUser(userData: UserData): UserData {
        val generatedSalt = BCrypt.gensalt()
        val saltedPassword = BCrypt.hashpw(userData.password, generatedSalt)
        val createdUser = User.new {
            username = userData.username
            password = saltedPassword
            email = userData.email
            salt = generatedSalt
        }
        userData.id = createdUser.id.value
        return userData
    }

    fun loginUser(userLogin: UserLogin) {
        val userName = userLogin.username.trim()
        val sentPassword = userLogin.password.trim()

        val matchingUsers = User.find {
            Users.username eq userName
        }
        if (!matchingUsers.empty()) {
            if (checkPasswords(sentPassword, matchingUsers.first())) {
                // create a session for the user
            } else {
                // RETURN 401
            }
        } else {
            // RETURN 404
        }
    }

    fun logoutUser() {

    }

    private fun checkPasswords(sentPassword: String, lookupEntity: User): Boolean {
        return with(lookupEntity) {
            this.password == BCrypt.hashpw(sentPassword, this.salt)
        }
    }
}