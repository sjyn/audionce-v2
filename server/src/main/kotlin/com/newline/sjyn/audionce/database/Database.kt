package com.newline.sjyn.audionce.database

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

//object PostgresDatabase : IDatabase {
//    private val database = Database.connect("jdbc:h2:mem:test", driver = "org.h2.Driver")
//
//    override fun <T : Entity<Any>> create(model: T): T {
//        transaction {
//            model.klass.table.insert {
//
//            }
//        }
//    }
//
//    override fun <T : Entity<Any>> delete(model: T): T {
//
//    }
//
//    override fun <T : Entity<Any>> update(model: T): T {
//
//    }
//
//    override fun <T : Entity<Any>> getById(id: Int): T {
//
//    }
//
//    override fun <T : Entity<Any>> getUserByUsername(username: String): T {
//
//    }
//
//}