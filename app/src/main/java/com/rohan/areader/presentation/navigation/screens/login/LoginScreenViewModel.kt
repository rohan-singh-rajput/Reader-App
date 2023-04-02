package com.rohan.areader.presentation.navigation.screens.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.rohan.areader.data.remote.login_data.model.MUser
import kotlinx.coroutines.launch

class LoginScreenViewModel : ViewModel() {
//    val loadingState = MutableStateFlow(LoadingState.IDLE)

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _loading = MutableLiveData(false)

    val loading: LiveData<Boolean> = _loading

    fun createUserWithEmailAndPassword(email: String, password: String, home: () -> Unit) {
        if (_loading.value == false) {
            _loading.value == true
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    home()
                } else {
                    Log.d(
                        "create user",
                        "createUserWithEmailAndPassword:  ${task.result.toString()}"
                    )
                }
                _loading.value = false
            }
        }

    }


    fun signInWithEmailAndPassword(email: String, password: String, home: () -> Unit) {
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val displayName = task.result?.user?.email?.split('@')?.get(0)
                        home()
                    } else {
                        Log.d(
                            "sign in", "signInWithEmailAndPassword: ${task.result.toString()}"
                        )
                    }
                }
            } catch (ex: Exception) {
                Log.d("Sign In Error", "signInWithEmailAndPassword: ${ex.message} ")
            }
        }
    }

    private fun createUser(displayName: String) {
        val userId = auth.currentUser?.uid
        val user = MUser(
            id = null,
            userId = userId.toString(),
            displayName = displayName,
            avatarUrl = "",
            quote = "life is great",
            profession = "Android developer"
        ).toMap()


        FirebaseFirestore.getInstance()
            .collection("users")
            .add(user)
    }


}