package com.navi9519.labb_3_cocktail_app.model.database.user

import com.navi9519.labb_3_cocktail_app.model.database.MyDatabase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class UserRepository (
    private val myDatabase: MyDatabase,
    private val coroutineScope: CoroutineScope
    ) {

        // SAVE USER
        fun insertOrUpdateUser(user: User) {
            myDatabase.userDao().insertOrUpdateUser(user)
        }

    // Delete user
    fun deleteUser(user: User) {
        myDatabase.userDao().deleteUser(user)
    }

        fun findAllUsers(): Flow<List<User>> {
            return myDatabase.userDao().findAllUsers()
        }

    fun findUserByUsernameAndPassword(username: String, password: String): Flow<User?> {
        return myDatabase.userDao().findUserByUsernameAndPassword(username, password)

    }

        // Handle Thread Operations
        fun performDatabaseOperation(dispatcher: CoroutineDispatcher, databaseOperation: suspend () -> Unit) {
            coroutineScope.launch(dispatcher) {
                databaseOperation()
            }
        }
    }