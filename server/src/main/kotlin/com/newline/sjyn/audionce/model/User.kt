package com.newline.sjyn.audionce.model

import org.jetbrains.exposed.dao.*
import org.jetbrains.exposed.sql.Column

data class UserLogin(
    val username: String,
    val password: String
)

data class UserData(
    var id: Int?,
    val username: String,
    val password: String,
    val email: String
)

class User (id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<User>(Users)

    var username: String by Users.username
    var password: String by Users.password
    var email: String by Users.email
    var salt: String by Users.salt
}

object Users: IntIdTable() {
    val username: Column<String> = varchar("username", 50).uniqueIndex()
    val password: Column<String> = varchar("password", 128)
    val email: Column<String> = varchar("email", 128).uniqueIndex()
    val salt: Column<String> = varchar("salt", 128)
}
