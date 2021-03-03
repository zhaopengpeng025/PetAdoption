package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R
import java.util.Date


enum class Gender {
    Boy,Girl
}

data class Puppy(
    var name:String,
    var gender:Gender,
    var age:String,
    var weight:Int,
    var health:String,
    var story:String,
    var logcation:String,
    var species:String,
    var picture:Int = R.drawable.default_puppy
)

data class User(
    var name:String,
    var mobile:String,
    var email:String
)

data class AdoptionInfo(
    var puppy: Puppy,
    var issueDate: Date = Date(),
    var location:String,
    var condition:String,
    var contact:User
)