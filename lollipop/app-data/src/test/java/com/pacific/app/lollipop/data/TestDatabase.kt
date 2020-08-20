package com.pacific.app.lollipop.data

import com.pacific.app.lollipop.data.db.AppDatabase
import com.pacific.app.lollipop.data.db.UserDao

object TestDatabase : AppDatabase {

    override fun userDao(): UserDao {
        TODO("Not yet implemented")
    }
}