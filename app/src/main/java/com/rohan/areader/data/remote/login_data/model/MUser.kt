package com.rohan.areader.data.remote.login_data.model

data class MUser(
    val id: String?,
    val userId: String,
    val displayName: String,
    val avatarUrl: String,
    val quote: String,
    val profession: String
) {
    fun toMap(): MutableMap<String, Any> {
        return mutableMapOf(
            "user_id" to this.userId,
            "display_name" to this.displayName,
            "quote" to quote,
            "profession" to profession,
            "avatarUrl" to avatarUrl
        )

    }
}
