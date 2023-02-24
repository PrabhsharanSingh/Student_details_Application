package com.example.studentdiary

data class StudentDetails(
    val name: String,
    val rollNo: Int,
    val phoneNo: Long,
    val course: String,
    val email: String,
    val address: String,
    val city: String,
    val state: String,
    val country: String,
)

val studentDetailsList = mutableListOf<StudentDetails>(
    StudentDetails("Aman",1,9291992299,"CS","singhprabhsharan19@gmail.com","G-12 V, MIG Flats","New Delhi","Delhi","India"),
    StudentDetails("Aman",2,9291992299,"CS","aman@gmail.com","G-12 V, MIG Flats","New Delhi","Delhi","India"),
    StudentDetails("Aman",3,9291992299,"CS","aman@gmail.com","G-12 V, MIG Flats","New Delhi","Delhi","India"),
    StudentDetails("Aman",4,9291992299,"CS","aman@gmail.com","G-12 V, MIG Flats","New Delhi","Delhi","India"),
    StudentDetails("Aman",5,9291992299,"CS","aman@gmail.com","G-12 V, MIG Flats","New Delhi","Delhi","India"),
    StudentDetails("Aman",6,9291992299,"CS","aman@gmail.com","G-12 V, MIG Flats","New Delhi","Delhi","India"),
    StudentDetails("Aman",7,9291992299,"CS","aman@gmail.com","G-12 V, MIG Flats","New Delhi","Delhi","India"),
    StudentDetails("Aman",8,9291992299,"CS","aman@gmail.com","G-12 V, MIG Flats","New Delhi","Delhi","India"),
)