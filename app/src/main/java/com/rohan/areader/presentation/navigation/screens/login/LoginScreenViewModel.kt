package com.rohan.areader.presentation.navigation.screens.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

class LoginScreenViewModel : ViewModel() {
//    val loadingState = MutableStateFlow(LoadingState.IDLE)

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _loading = MutableLiveData(false)

    val loading: LiveData<Boolean> = _loading

    fun createUserWithEmailAndPassword(email: String, password: String) = viewModelScope.launch {
        try {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d(
                            "Create User",
                            "createUserWithEmailAndPassword: ${task.result.toString()}"
                        )
                    }
                }
        } catch (ex: Exception) {
            Log.d("create User", "createUserWithEmailAndPassword: ${ex.message}")
        }
    }


    fun signInWithEmailAndPassword(email: String, password: String, home: () -> Unit) = viewModelScope.launch {
        try {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("Sign in", "Signed IN ")
                        home()
                    } else {
                        Log.d("sign in", "signInWithEmailAndPassword: ${task.result.toString()}")
                    }
                }
        } catch (ex: Exception) {
            Log.d("Sign In Error", "signInWithEmailAndPassword: ${ex.message} ")
        }
    }

}