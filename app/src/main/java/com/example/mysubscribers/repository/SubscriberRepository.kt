package com.example.mysubscribers.repository

import com.example.mysubscribers.data.db.entity.SubscriberEntity

interface SubscriberRepository {

    suspend fun insertSubscriber(name: String, email: String): Long

    suspend fun updateSubscriber(id: Long, name: String, email: String)

    suspend fun deleteSubscriber(id: Long)

    suspend fun deleteAllSubscriber()

    suspend fun getAllSubscriber(): List<SubscriberEntity>

}