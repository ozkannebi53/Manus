package com.akrep.gmi.galactic.firebase

import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.google.firebase.messaging.FirebaseMessaging

object FirebaseConfig {
    val auth: FirebaseAuth by lazy { Firebase.auth }
    val firestore: FirebaseFirestore by lazy { Firebase.firestore }
    val messaging: FirebaseMessaging by lazy { FirebaseMessaging.getInstance() }

    fun initializeFirebase() {
        // Firebase otomatik olarak initialize edilir
        // Firestore ayarları
        firestore.firestoreSettings = com.google.firebase.firestore.FirebaseFirestoreSettings.Builder()
            .setPersistenceEnabled(true)
            .build()
    }
}
